package com.facebook.login;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.ProfileCache;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import java.util.ArrayList;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes2.dex */
public class LoginFragment extends Fragment {
    public String callingPackage;
    public ActivityResultLauncher launcher;
    public LoginClient loginClient;
    public View progressBar;
    public LoginClient.Request request;

    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        getLoginClient().onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        LoginClient loginClient = bundle == null ? null : (LoginClient) bundle.getParcelable("loginClient");
        if (loginClient == null) {
            loginClient = new LoginClient();
            loginClient.currentHandler = -1;
            if (loginClient.fragment != null) {
                throw new FacebookException("Can't set fragment once it is already set.");
            }
            loginClient.fragment = this;
        } else {
            if (loginClient.fragment != null) {
                throw new FacebookException("Can't set fragment once it is already set.");
            }
            loginClient.fragment = this;
        }
        this.loginClient = loginClient;
        getLoginClient().onCompletedListener = new InputConnectionCompat$$ExternalSyntheticLambda0(this, 5);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
        Intent intent = activity.getIntent();
        if (intent != null && (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) != null) {
            this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
        }
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(2), new InputConnectionCompat$$ExternalSyntheticLambda0(new LoginFragment$getLoginMethodHandlerCallback$1(this, activity, 0), 6));
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult(),\n            getLoginMethodHandlerCallback(activity))");
        this.launcher = activityResultLauncherRegisterForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.com_facebook_login_fragment, viewGroup, false);
        View viewFindViewById = viewInflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById<View>(R.id.com_facebook_login_fragment_progress_bar)");
        this.progressBar = viewFindViewById;
        getLoginClient().backgroundProcessingListener = new ProfileCache(this, 20);
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        LoginMethodHandler currentHandler = getLoginClient().getCurrentHandler();
        if (currentHandler != null) {
            currentHandler.cancel();
        }
        this.mCalled = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        View view = getView();
        View viewFindViewById = view == null ? null : view.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        this.mCalled = true;
        if (this.callingPackage == null) {
            Log.e(DaWYVMJ.wcWdrIGSjW, "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
            return;
        }
        LoginClient loginClient = getLoginClient();
        LoginClient.Request request = this.request;
        LoginClient.Request request2 = loginClient.pendingRequest;
        if ((request2 == null || loginClient.currentHandler < 0) && request != null) {
            if (request2 != null) {
                throw new FacebookException("Attempted to authorize while a request is pending.");
            }
            Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
            if (!Headers.Companion.isCurrentAccessTokenActive() || loginClient.checkInternetPermission()) {
                loginClient.pendingRequest = request;
                ArrayList arrayList = new ArrayList();
                boolean zIsInstagramLogin = request.isInstagramLogin();
                LoginBehavior loginBehavior = request.loginBehavior;
                if (!zIsInstagramLogin) {
                    if (loginBehavior.allowsGetTokenAuth) {
                        arrayList.add(new GetTokenLoginMethodHandler(loginClient));
                    }
                    if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsKatanaAuth) {
                        arrayList.add(new KatanaProxyLoginMethodHandler(loginClient));
                    }
                } else if (!FacebookSdk.bypassAppSwitch && loginBehavior.allowsInstagramAppAuth) {
                    arrayList.add(new InstagramAppLoginMethodHandler(loginClient));
                }
                if (loginBehavior.allowsCustomTabAuth) {
                    arrayList.add(new CustomTabLoginMethodHandler(loginClient));
                }
                if (loginBehavior.allowsWebViewAuth) {
                    arrayList.add(new WebViewLoginMethodHandler(loginClient));
                }
                if (!request.isInstagramLogin() && loginBehavior.allowsDeviceAuth) {
                    arrayList.add(new DeviceAuthMethodHandler(loginClient));
                }
                Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                loginClient.handlersToTry = (LoginMethodHandler[]) array;
                loginClient.tryNextHandler();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("loginClient", getLoginClient());
    }
}
