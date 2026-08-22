package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginTargetApp;
import java.util.Arrays;
import java.util.Date;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class FacebookDialogFragment extends DialogFragment {
    public Dialog innerDialog;

    public final void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "fragmentActivity.intent");
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(intent, bundle, facebookException));
        activity.finish();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof WebDialog) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        FragmentActivity activity;
        String string;
        WebDialog facebookWebFallbackDialog;
        final int i = 1;
        final int i2 = 0;
        super.onCreate(bundle);
        if (this.innerDialog == null && (activity = getActivity()) != null) {
            Intent intent = activity.getIntent();
            NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(intent);
            if (methodArgumentsFromIntent == null ? false : methodArgumentsFromIntent.getBoolean("is_fallback", false)) {
                string = methodArgumentsFromIntent != null ? methodArgumentsFromIntent.getString("url") : null;
                if (Utility.isNullOrEmpty(string)) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    activity.finish();
                    return;
                }
                String str = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                int i3 = FacebookWebFallbackDialog.$r8$clinit;
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                WebDialog.initDefaultTheme(activity);
                Validate.sdkInitialized();
                int i4 = WebDialog.webDialogTheme;
                if (i4 == 0) {
                    Validate.sdkInitialized();
                    i4 = WebDialog.webDialogTheme;
                }
                facebookWebFallbackDialog = new FacebookWebFallbackDialog(activity, i4);
                facebookWebFallbackDialog.url = string;
                facebookWebFallbackDialog.expectedRedirectUrl = str;
                facebookWebFallbackDialog.onCompleteListener = new WebDialog.OnCompleteListener(this) { // from class: com.facebook.internal.FacebookDialogFragment$$ExternalSyntheticLambda0
                    public final /* synthetic */ FacebookDialogFragment f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle2, FacebookException facebookException) {
                        switch (i) {
                            case 0:
                                FacebookDialogFragment this$0 = this.f$0;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                this$0.onCompleteWebDialog(bundle2, facebookException);
                                break;
                            default:
                                FacebookDialogFragment this$1 = this.f$0;
                                Intrinsics.checkNotNullParameter(this$1, "this$0");
                                FragmentActivity activity2 = this$1.getActivity();
                                if (activity2 != null) {
                                    Intent intent2 = new Intent();
                                    if (bundle2 == null) {
                                        bundle2 = new Bundle();
                                    }
                                    intent2.putExtras(bundle2);
                                    activity2.setResult(-1, intent2);
                                    activity2.finish();
                                    break;
                                }
                                break;
                        }
                    }
                };
            } else {
                String string2 = methodArgumentsFromIntent == null ? null : methodArgumentsFromIntent.getString("action");
                Bundle bundle2 = methodArgumentsFromIntent == null ? null : methodArgumentsFromIntent.getBundle("params");
                if (Utility.isNullOrEmpty(string2)) {
                    FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                    activity.finish();
                    return;
                }
                if (string2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
                AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
                string = Headers.Companion.isCurrentAccessTokenActive() ? null : FacebookSdk.getApplicationId();
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                WebDialog.OnCompleteListener onCompleteListener = new WebDialog.OnCompleteListener(this) { // from class: com.facebook.internal.FacebookDialogFragment$$ExternalSyntheticLambda0
                    public final /* synthetic */ FacebookDialogFragment f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // com.facebook.internal.WebDialog.OnCompleteListener
                    public final void onComplete(Bundle bundle3, FacebookException facebookException) {
                        switch (i2) {
                            case 0:
                                FacebookDialogFragment this$0 = this.f$0;
                                Intrinsics.checkNotNullParameter(this$0, "this$0");
                                this$0.onCompleteWebDialog(bundle3, facebookException);
                                break;
                            default:
                                FacebookDialogFragment this$1 = this.f$0;
                                Intrinsics.checkNotNullParameter(this$1, "this$0");
                                FragmentActivity activity2 = this$1.getActivity();
                                if (activity2 != null) {
                                    Intent intent2 = new Intent();
                                    if (bundle3 == null) {
                                        bundle3 = new Bundle();
                                    }
                                    intent2.putExtras(bundle3);
                                    activity2.setResult(-1, intent2);
                                    activity2.finish();
                                    break;
                                }
                                break;
                        }
                    }
                };
                if (currentAccessToken != null) {
                    bundle2.putString("app_id", currentAccessToken.applicationId);
                    bundle2.putString("access_token", currentAccessToken.token);
                } else {
                    bundle2.putString("app_id", string);
                }
                WebDialog.initDefaultTheme(activity);
                facebookWebFallbackDialog = new WebDialog(activity, string2, bundle2, LoginTargetApp.FACEBOOK, onCompleteListener);
            }
            this.innerDialog = facebookWebFallbackDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.innerDialog;
        if (dialog == null) {
            onCompleteWebDialog(null, null);
            this.mShowsDialog = false;
            return super.onCreateDialog(bundle);
        }
        if (dialog != null) {
            return dialog;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Dialog dialog = this.mDialog;
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        this.mCalled = true;
        Dialog dialog = this.innerDialog;
        if (dialog instanceof WebDialog) {
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((WebDialog) dialog).resize();
        }
    }
}
