package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentActivity;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda1;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.UserSettingsManager;
import com.facebook.internal.Utility;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.concurrent.onZL.mnwSv;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {
    public final /* synthetic */ int $r8$classId;
    public Object e2e;

    public /* synthetic */ WebLoginMethodHandler() {
        this.$r8$classId = 0;
    }

    public void completeLogin(LoginClient.Result result) {
        if (result != null) {
            getLoginClient().completeAndValidate(result);
        } else {
            getLoginClient().tryNextHandler();
        }
    }

    public AccessTokenSource getTokenSource() {
        return (AccessTokenSource) this.e2e;
    }

    public void handleResultError(LoginClient.Request request, String str, String str2, String str3) {
        if (str != null && str.equals("logged_out")) {
            CustomTabLoginMethodHandler.calledThroughLoggedOutAppSwitch = true;
            completeLogin(null);
            return;
        }
        if (CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"service_disabled", "AndroidAuthKillSwitchException"}).contains(str)) {
            completeLogin(null);
            return;
        }
        if (CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"access_denied", "OAuthAccessDeniedException"}).contains(str)) {
            completeLogin(new LoginClient.Result(request, LoginClient.Result.Code.CANCEL, null, null, null, null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        completeLogin(new LoginClient.Result(request, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), str3));
    }

    public void handleResultOk(LoginClient.Request request, Bundle bundle) {
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            completeLogin(new LoginClient.Result(request, LoginClient.Result.Code.SUCCESS, CloseableKt.createAccessTokenFromWebBundle(request.permissions, bundle, getTokenSource(), request.applicationId), CloseableKt.createAuthenticationTokenFromWebBundle(bundle, request.nonce), null, null));
        } catch (FacebookException e) {
            String message = e.getMessage();
            ArrayList arrayList = new ArrayList();
            if (message != null) {
                arrayList.add(message);
            }
            completeLogin(new LoginClient.Result(request, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null));
        }
    }

    public boolean tryIntent(Intent intent) {
        if (intent != null) {
            List<ResolveInfo> listQueryIntentActivities = FacebookSdk.getApplicationContext().getPackageManager().queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "FacebookSdk.getApplicationContext()\n            .packageManager\n            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            if (!listQueryIntentActivities.isEmpty()) {
                LoginFragment loginFragment = getLoginClient().fragment;
                Unit unit = null;
                if (!(loginFragment instanceof LoginFragment)) {
                    loginFragment = null;
                }
                if (loginFragment != null) {
                    ActivityResultLauncher activityResultLauncher = loginFragment.launcher;
                    if (activityResultLauncher == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("launcher");
                        throw null;
                    }
                    activityResultLauncher.launch(intent);
                    unit = Unit.INSTANCE;
                }
                return unit != null;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel parcel, int i) {
        super(parcel);
        this.$r8$classId = i;
        switch (i) {
            case 1:
                Intrinsics.checkNotNullParameter(parcel, GsPcpBmONXh.BlWRWPuuup);
                super(parcel);
                this.e2e = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
                break;
            default:
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0087  */
    public Bundle getParameters(LoginClient.Request request) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle bundle = new Bundle();
        HashSet hashSet = request.permissions;
        if (hashSet != null && !hashSet.isEmpty()) {
            String strJoin = TextUtils.join(",", request.permissions);
            bundle.putString("scope", strJoin);
            addLoggingExtra("scope", strJoin);
        }
        DefaultAudience defaultAudience = request.defaultAudience;
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        bundle.putString("default_audience", defaultAudience.nativeProtocolAudience);
        bundle.putString("state", getClientState(request.authId));
        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
        AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
        String str = currentAccessToken == null ? null : currentAccessToken.token;
        if (str == null) {
            activity = getLoginClient().getActivity();
            if (activity != null) {
                Utility.clearFacebookCookies(activity);
            }
            addLoggingExtra("access_token", "0");
        } else {
            Context activity2 = getLoginClient().getActivity();
            if (activity2 == null) {
                activity2 = FacebookSdk.getApplicationContext();
            }
            if (str.equals(activity2.getSharedPreferences(UUFMQdNK.qPT, 0).getString("TOKEN", ""))) {
                bundle.putString("access_token", str);
                addLoggingExtra("access_token", "1");
            } else {
                activity = getLoginClient().getActivity();
                if (activity != null) {
                    Utility.clearFacebookCookies(activity);
                }
                addLoggingExtra("access_token", "0");
            }
        }
        bundle.putString(TSDAbK.xuEqU, String.valueOf(System.currentTimeMillis()));
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        bundle.putString("ies", UserSettingsManager.getAutoLogAppEventsEnabled() ? "1" : "0");
        return bundle;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean onActivityResult(int i, int i2, Intent intent) {
        String str;
        Object obj;
        switch (this.$r8$classId) {
            case 1:
                LoginClient.Request request = getLoginClient().pendingRequest;
                LoginClient.Result.Code code = LoginClient.Result.Code.CANCEL;
                if (intent == null) {
                    completeLogin(new LoginClient.Result(request, code, null, null, "Operation canceled", null));
                } else {
                    LoginClient.Result.Code code2 = LoginClient.Result.Code.ERROR;
                    String string = null;
                    String str2 = mnwSv.NOmPzEOTMW;
                    if (i2 == 0) {
                        Bundle extras = intent.getExtras();
                        String string2 = extras == null ? null : extras.getString("error");
                        if (string2 != null) {
                            str = string2;
                        } else if (extras == null) {
                            str = null;
                        } else {
                            string2 = extras.getString("error_type");
                            str = string2;
                        }
                        String string3 = (extras == null || (obj = extras.get(str2)) == null) ? null : obj.toString();
                        if ("CONNECTION_FAILURE".equals(string3)) {
                            String string4 = extras == null ? null : extras.getString("error_message");
                            if (string4 != null) {
                                string = string4;
                            } else if (extras != null) {
                                string = extras.getString("error_description");
                            }
                            ArrayList arrayList = new ArrayList();
                            if (str != null) {
                                arrayList.add(str);
                            }
                            if (string != null) {
                                arrayList.add(string);
                            }
                            completeLogin(new LoginClient.Result(request, code2, null, null, TextUtils.join(": ", arrayList), string3));
                        } else {
                            completeLogin(new LoginClient.Result(request, code, null, null, str, null));
                        }
                    } else if (i2 != -1) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("Unexpected resultCode from authorization.");
                        completeLogin(new LoginClient.Result(request, code2, null, null, TextUtils.join(": ", arrayList2), null));
                    } else {
                        Bundle extras2 = intent.getExtras();
                        if (extras2 == null) {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add("Unexpected null from returned authorization data.");
                            completeLogin(new LoginClient.Result(request, code2, null, null, TextUtils.join(": ", arrayList3), null));
                        } else {
                            String string5 = extras2.getString("error");
                            if (string5 == null) {
                                string5 = extras2.getString("error_type");
                            }
                            Object obj2 = extras2.get(str2);
                            string = obj2 != null ? obj2.toString() : null;
                            String string6 = extras2.getString("error_message");
                            if (string6 == null) {
                                string6 = extras2.getString("error_description");
                            }
                            String string7 = extras2.getString("e2e");
                            if (!Utility.isNullOrEmpty(string7)) {
                                logWebLoginCompleted(string7);
                            }
                            if (string5 != null || string != null || string6 != null || request == null) {
                                handleResultError(request, string5, string6, string);
                            } else if (!extras2.containsKey("code") || Utility.isNullOrEmpty(extras2.getString("code"))) {
                                handleResultOk(request, extras2);
                            } else {
                                FacebookSdk.getExecutor().execute(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, request, extras2, 6));
                            }
                        }
                    }
                }
                return true;
            default:
                return super.onActivityResult(i, i2, intent);
        }
    }

    public void onComplete(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        LoginClient.Result result;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        String strValueOf = null;
        this.e2e = null;
        LoginClient.Result.Code code = LoginClient.Result.Code.ERROR;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.e2e = bundle.getString("e2e");
            }
            try {
                AccessToken accessTokenCreateAccessTokenFromWebBundle = CloseableKt.createAccessTokenFromWebBundle(request.permissions, bundle, getTokenSource(), request.applicationId);
                result = new LoginClient.Result(loginClient.pendingRequest, LoginClient.Result.Code.SUCCESS, accessTokenCreateAccessTokenFromWebBundle, CloseableKt.createAuthenticationTokenFromWebBundle(bundle, request.nonce), null, null);
                if (loginClient.getActivity() != null) {
                    try {
                        CookieSyncManager.createInstance(loginClient.getActivity()).sync();
                    } catch (Exception unused) {
                    }
                    if (accessTokenCreateAccessTokenFromWebBundle != null) {
                        String str = accessTokenCreateAccessTokenFromWebBundle.token;
                        Context activity = getLoginClient().getActivity();
                        if (activity == null) {
                            activity = FacebookSdk.getApplicationContext();
                        }
                        activity.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString(QTaELkFI.kvxIuAgdsGkJe, str).apply();
                    }
                }
            } catch (FacebookException e) {
                LoginClient.Request request2 = loginClient.pendingRequest;
                String message = e.getMessage();
                ArrayList arrayList = new ArrayList();
                if (message != null) {
                    arrayList.add(message);
                }
                result = new LoginClient.Result(request2, code, null, null, TextUtils.join(": ", arrayList), null);
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            result = new LoginClient.Result(loginClient.pendingRequest, LoginClient.Result.Code.CANCEL, null, null, "User canceled log in.", null);
        } else {
            this.e2e = null;
            String message2 = facebookException == null ? null : facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError facebookRequestError = ((FacebookServiceException) facebookException).requestError;
                strValueOf = String.valueOf(facebookRequestError.errorCode);
                message2 = facebookRequestError.toString();
            }
            String str2 = strValueOf;
            LoginClient.Request request3 = loginClient.pendingRequest;
            ArrayList arrayList2 = new ArrayList();
            if (message2 != null) {
                arrayList2.add(message2);
            }
            result = new LoginClient.Result(request3, code, null, null, TextUtils.join(": ", arrayList2), str2);
        }
        if (!Utility.isNullOrEmpty((String) this.e2e)) {
            logWebLoginCompleted((String) this.e2e);
        }
        loginClient.completeAndValidate(result);
    }

    public WebLoginMethodHandler(LoginClient loginClient) {
        this.$r8$classId = 1;
        this.loginClient = loginClient;
        this.e2e = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    }
}
