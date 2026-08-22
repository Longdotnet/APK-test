package com.facebook.login;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentState;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessToken;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda1;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda2;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.util.zzbf;
import com.google.firebase.auth.zzr;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DeviceAuthDialog extends DialogFragment {
    public final AtomicBoolean completed = new AtomicBoolean();
    public TextView confirmationCode;
    public volatile GraphRequestAsyncTask currentGraphRequestPoll;
    public volatile RequestState currentRequestState;
    public DeviceAuthMethodHandler deviceAuthMethodHandler;
    public TextView instructions;
    public boolean isBeingDestroyed;
    public boolean isRetry;
    public View progressBar;
    public LoginClient.Request request;
    public volatile ScheduledFuture scheduledPoll;

    public final class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new FragmentState.AnonymousClass1(28);
        public String authorizationUri;
        public long interval;
        public long lastPoll;
        public String requestCode;
        public String userCode;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel dest, int i) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeString(this.authorizationUri);
            dest.writeString(this.userCode);
            dest.writeString(this.requestCode);
            dest.writeLong(this.interval);
            dest.writeLong(this.lastPoll);
        }
    }

    public final void completeLogin(String str, zzbf zzbfVar, String str2, Date date, Date date2) {
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            deviceAuthMethodHandler.getLoginClient().completeAndValidate(new LoginClient.Result(deviceAuthMethodHandler.getLoginClient().pendingRequest, LoginClient.Result.Code.SUCCESS, new AccessToken(str2, FacebookSdk.getApplicationId(), str, zzbfVar.zza, zzbfVar.zzb, zzbfVar.zzc, AccessTokenSource.DEVICE_AUTH, date, null, date2, "facebook"), null, null, null));
        }
        Dialog dialog = this.mDialog;
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    public final View initializeContentView(boolean z) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "requireActivity().layoutInflater");
        View viewInflate = layoutInflater.inflate(z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View viewFindViewById = viewInflate.findViewById(R.id.progress_bar);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.confirmation_code);
        if (viewFindViewById2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        this.confirmationCode = (TextView) viewFindViewById2;
        View viewFindViewById3 = viewInflate.findViewById(R.id.cancel_button);
        if (viewFindViewById3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        ((Button) viewFindViewById3).setOnClickListener(new WebDialog$$ExternalSyntheticLambda2(this, 1));
        View viewFindViewById4 = viewInflate.findViewById(R.id.com_facebook_device_auth_instructions);
        if (viewFindViewById4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        TextView textView = (TextView) viewFindViewById4;
        this.instructions = textView;
        textView.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return viewInflate;
    }

    public final void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.getLoginClient().completeAndValidate(new LoginClient.Result(deviceAuthMethodHandler.getLoginClient().pendingRequest, LoginClient.Result.Code.CANCEL, null, null, "User canceled log in.", null));
            }
            Dialog dialog = this.mDialog;
            if (dialog == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Dialog dialog = new Dialog(fragmentActivityRequireActivity) { // from class: com.facebook.login.DeviceAuthDialog$onCreateDialog$dialog$1
            @Override // android.app.Dialog
            public final void onBackPressed() {
                this.this$0.getClass();
                super.onBackPressed();
            }
        };
        dialog.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewOnCreateView = super.onCreateView(inflater, viewGroup, bundle);
        LoginFragment loginFragment = (LoginFragment) ((FacebookActivity) requireActivity()).currentFragment;
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) (loginFragment == null ? null : loginFragment.getLoginClient().getCurrentHandler());
        if (bundle != null && (requestState = (RequestState) bundle.getParcelable("request_state")) != null) {
            setCurrentRequestState(requestState);
        }
        return viewOnCreateView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        GraphRequestAsyncTask graphRequestAsyncTask = this.currentGraphRequestPoll;
        if (graphRequestAsyncTask != null) {
            graphRequestAsyncTask.cancel(true);
        }
        ScheduledFuture scheduledFuture = this.scheduledPoll;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isBeingDestroyed) {
            return;
        }
        onCancel();
    }

    public final void onError(FacebookException facebookException) {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                DeviceRequestsHelper.cleanUpAdvertisementService(requestState.userCode);
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                LoginClient.Request request = deviceAuthMethodHandler.getLoginClient().pendingRequest;
                String message = facebookException.getMessage();
                ArrayList arrayList = new ArrayList();
                if (message != null) {
                    arrayList.add(message);
                }
                deviceAuthMethodHandler.getLoginClient().completeAndValidate(new LoginClient.Result(request, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
            }
            Dialog dialog = this.mDialog;
            if (dialog == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable("request_state", this.currentRequestState);
        }
    }

    public final void onSuccess(String str, long j, Long l) {
        Date date;
        HttpMethod httpMethod = HttpMethod.GET;
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        if (j != 0) {
            date = new Date((j * 1000) + new Date().getTime());
        } else {
            date = null;
        }
        Date date2 = l.longValue() != 0 ? new Date(l.longValue() * 1000) : null;
        AccessToken accessToken = new AccessToken(str, FacebookSdk.getApplicationId(), "0", null, null, null, null, date, null, date2, "facebook");
        String str2 = GraphRequest.MIME_BOUNDARY;
        GraphRequest graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(accessToken, "me", new AccessTokenManager$$ExternalSyntheticLambda1(this, str, date, date2, 2));
        graphRequestNewGraphPathRequest.httpMethod = httpMethod;
        graphRequestNewGraphPathRequest.parameters = bundle;
        graphRequestNewGraphPathRequest.executeAsync();
    }

    public final void poll() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.lastPoll = new Date().getTime();
        }
        Bundle bundle = new Bundle();
        RequestState requestState2 = this.currentRequestState;
        bundle.putString("code", requestState2 == null ? null : requestState2.requestCode);
        StringBuilder sb = new StringBuilder();
        sb.append(FacebookSdk.getApplicationId());
        sb.append('|');
        Validate.sdkInitialized();
        String str = FacebookSdk.appClientToken;
        if (str == null) {
            throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
        }
        sb.append(str);
        bundle.putString("access_token", sb.toString());
        String str2 = GraphRequest.MIME_BOUNDARY;
        this.currentGraphRequestPoll = new GraphRequest(null, "device/login_status", bundle, HttpMethod.POST, new DeviceAuthDialog$$ExternalSyntheticLambda2(this, 0)).executeAsync();
    }

    public final void schedulePoll() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        RequestState requestState = this.currentRequestState;
        Long lValueOf = requestState == null ? null : Long.valueOf(requestState.interval);
        if (lValueOf != null) {
            synchronized (DeviceAuthMethodHandler.Companion) {
                try {
                    if (DeviceAuthMethodHandler.backgroundExecutor == null) {
                        DeviceAuthMethodHandler.backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                    }
                    scheduledThreadPoolExecutor = DeviceAuthMethodHandler.backgroundExecutor;
                    if (scheduledThreadPoolExecutor == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backgroundExecutor");
                        throw null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.scheduledPoll = scheduledThreadPoolExecutor.schedule(new AccessTokenManager$$ExternalSyntheticLambda0(this, 13), lValueOf.longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00b2  */
    public final void setCurrentRequestState(RequestState requestState) {
        Bitmap bitmapCreateBitmap;
        boolean zStartAdvertisementServiceImpl;
        this.currentRequestState = requestState;
        TextView textView = this.confirmationCode;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            throw null;
        }
        textView.setText(requestState.userCode);
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        String str = requestState.authorizationUri;
        boolean z = false;
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            bitmapCreateBitmap = null;
        } else {
            try {
                EnumMap enumMap = new EnumMap(EncodeHintType.class);
                enumMap.put(EncodeHintType.MARGIN, 2);
                try {
                    BitMatrix bitMatrixEncode = new zzr(18).encode(str, 12, enumMap);
                    int i = bitMatrixEncode.height;
                    int i2 = bitMatrixEncode.width;
                    int[] iArr = new int[i * i2];
                    if (i > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            int i5 = i3 * i2;
                            if (i2 > 0) {
                                int i6 = 0;
                                while (true) {
                                    int i7 = i6 + 1;
                                    iArr[i5 + i6] = bitMatrixEncode.get(i6, i3) ? -16777216 : -1;
                                    if (i7 >= i2) {
                                        break;
                                    } else {
                                        i6 = i7;
                                    }
                                }
                            }
                            if (i4 >= i) {
                                break;
                            } else {
                                i3 = i4;
                            }
                        }
                    }
                    bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                    try {
                        bitmapCreateBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i);
                    } catch (WriterException unused) {
                    }
                } catch (WriterException unused2) {
                    bitmapCreateBitmap = null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(DeviceRequestsHelper.class, th);
            }
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmapCreateBitmap);
        TextView textView2 = this.instructions;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("instructions");
            throw null;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
        TextView textView3 = this.confirmationCode;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmationCode");
            throw null;
        }
        textView3.setVisibility(0);
        View view = this.progressBar;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
            throw null;
        }
        view.setVisibility(8);
        if (!this.isRetry) {
            DeviceRequestsHelper deviceRequestsHelper2 = DeviceRequestsHelper.INSTANCE;
            String str2 = requestState.userCode;
            if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
                zStartAdvertisementServiceImpl = false;
            } else {
                try {
                    if (DeviceRequestsHelper.isAvailable()) {
                        zStartAdvertisementServiceImpl = DeviceRequestsHelper.INSTANCE.startAdvertisementServiceImpl(str2);
                    } else {
                        zStartAdvertisementServiceImpl = false;
                    }
                } catch (Throwable th2) {
                    CrashShieldHandler.handleThrowable(DeviceRequestsHelper.class, th2);
                }
            }
            if (zStartAdvertisementServiceImpl) {
                AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(getContext(), (String) null);
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                    appEventsLoggerImpl.logEventImplicitly(null, "fb_smart_login_service");
                }
            }
        }
        if (requestState.lastPoll != 0) {
            z = (new Date().getTime() - requestState.lastPoll) - (requestState.interval * 1000) < 0;
        }
        if (z) {
            schedulePoll();
        } else {
            poll();
        }
    }

    public final void startLogin(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.request = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.permissions));
        String str = request.deviceRedirectUriString;
        if (!Utility.isNullOrEmpty(str)) {
            bundle.putString("redirect_uri", str);
        }
        String str2 = request.deviceAuthTargetUserId;
        if (!Utility.isNullOrEmpty(str2)) {
            bundle.putString("target_user_id", str2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FacebookSdk.getApplicationId());
        sb.append('|');
        Validate.sdkInitialized();
        String str3 = FacebookSdk.appClientToken;
        if (str3 == null) {
            throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
        }
        sb.append(str3);
        bundle.putString("access_token", sb.toString());
        DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
        String str4 = null;
        if (!CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            try {
                HashMap map = new HashMap();
                String DEVICE = Build.DEVICE;
                Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                map.put("device", DEVICE);
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                map.put("model", MODEL);
                String string = new JSONObject((Map) map).toString();
                Intrinsics.checkNotNullExpressionValue(string, "JSONObject(deviceInfo as Map<*, *>).toString()");
                str4 = string;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(DeviceRequestsHelper.class, th);
            }
        }
        bundle.putString("device_info", str4);
        String str5 = GraphRequest.MIME_BOUNDARY;
        new GraphRequest(null, "device/login", bundle, HttpMethod.POST, new DeviceAuthDialog$$ExternalSyntheticLambda2(this, 1)).executeAsync();
    }
}
