package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentState;
import com.daerisoft.thespikerm.GoogleMobileAdsGM$$ExternalSyntheticLambda1;
import com.facebook.AccessTokenSource;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Protocol;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new FragmentState.AnonymousClass1(27);
    public static boolean calledThroughLoggedOutAppSwitch;
    public String currentPackage;
    public final String expectedChallenge;
    public final String nameForLogging;
    public final AccessTokenSource tokenSource;
    public final String validRedirectURI;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel source) {
        super(source, 0);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        this.expectedChallenge = source.readString();
        this.validRedirectURI = Validate.getValidRedirectURI(super.getRedirectUrl());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getRedirectUrl() {
        return this.validRedirectURI;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public final AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // com.facebook.login.WebLoginMethodHandler, com.facebook.login.LoginMethodHandler
    public final boolean onActivityResult(int i, int i2, Intent intent) {
        LoginClient.Request request;
        int i3;
        boolean zAreEqual = false;
        if ((intent != null && intent.getBooleanExtra(CustomTabMainActivity.NO_ACTIVITY_EXCEPTION, false)) || i != 1 || (request = getLoginClient().pendingRequest) == null) {
            return false;
        }
        if (i2 != -1) {
            onComplete(request, null, new FacebookOperationCanceledException());
            return false;
        }
        String stringExtra = intent != null ? intent.getStringExtra(CustomTabMainActivity.EXTRA_URL) : null;
        if (stringExtra != null && (StringsKt__StringsKt.startsWith(stringExtra, "fbconnect://cct.", false) || StringsKt__StringsKt.startsWith(stringExtra, super.getRedirectUrl(), false))) {
            Uri uri = Uri.parse(stringExtra);
            Bundle urlQueryString = Utility.parseUrlQueryString(uri.getQuery());
            urlQueryString.putAll(Utility.parseUrlQueryString(uri.getFragment()));
            try {
                String string = urlQueryString.getString("state");
                if (string != null) {
                    zAreEqual = Intrinsics.areEqual(new JSONObject(string).getString("7_challenge"), this.expectedChallenge);
                }
            } catch (JSONException unused) {
            }
            if (zAreEqual) {
                String string2 = urlQueryString.getString("error");
                if (string2 == null) {
                    string2 = urlQueryString.getString("error_type");
                }
                String string3 = urlQueryString.getString("error_msg");
                if (string3 == null) {
                    string3 = urlQueryString.getString("error_message");
                }
                if (string3 == null) {
                    string3 = urlQueryString.getString("error_description");
                }
                String string4 = urlQueryString.getString("error_code");
                if (string4 == null) {
                    i3 = -1;
                } else {
                    try {
                        i3 = Integer.parseInt(string4);
                    } catch (NumberFormatException unused2) {
                        i3 = -1;
                    }
                }
                if (Utility.isNullOrEmpty(string2) && Utility.isNullOrEmpty(string3) && i3 == -1) {
                    if (urlQueryString.containsKey("access_token")) {
                        onComplete(request, urlQueryString, null);
                    } else {
                        FacebookSdk.getExecutor().execute(new GoogleMobileAdsGM$$ExternalSyntheticLambda1(this, request, urlQueryString, 5));
                    }
                } else if ((string2 == null || !(string2.equals("access_denied") || string2.equals("OAuthAccessDeniedException"))) && i3 != 4201) {
                    onComplete(request, null, new FacebookServiceException(new FacebookRequestError(i3, string2, string3), string3));
                } else {
                    onComplete(request, null, new FacebookOperationCanceledException());
                }
            } else {
                onComplete(request, null, new FacebookException("Invalid state parameter"));
            }
        }
        return true;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final void putChallengeParam(JSONObject jSONObject) {
        jSONObject.put("7_challenge", this.expectedChallenge);
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, i);
        dest.writeString(this.expectedChallenge);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final int tryAuthorize(LoginClient.Request request) {
        String str = this.validRedirectURI;
        Intrinsics.checkNotNullParameter(request, "request");
        LoginClient loginClient = getLoginClient();
        if (str.length() == 0) {
            return 0;
        }
        Bundle parameters = getParameters(request);
        parameters.putString("redirect_uri", str);
        boolean zIsInstagramLogin = request.isInstagramLogin();
        String str2 = request.applicationId;
        if (zIsInstagramLogin) {
            parameters.putString("app_id", str2);
        } else {
            parameters.putString("client_id", str2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
        parameters.putString("e2e", string);
        if (request.isInstagramLogin()) {
            parameters.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (request.permissions.contains("openid")) {
                parameters.putString("nonce", request.nonce);
            }
            parameters.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        parameters.putString("code_challenge", request.codeChallenge);
        CodeChallengeMethod codeChallengeMethod = request.codeChallengeMethod;
        parameters.putString(yzwzcWHcnH.ueLfryPVGbrT, codeChallengeMethod == null ? null : codeChallengeMethod.name());
        String str3 = FKidOcdAYt.gqVg;
        parameters.putString("return_scopes", str3);
        parameters.putString("auth_type", request.authType);
        parameters.putString("login_behavior", request.loginBehavior.name());
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        parameters.putString("sdk", Intrinsics.stringPlus("16.0.0", "android-"));
        parameters.putString("sso", "chrome_custom_tab");
        parameters.putString("cct_prefetching", FacebookSdk.hasCustomTabsPrefetching ? "1" : "0");
        boolean z = request.isFamilyLogin;
        LoginTargetApp loginTargetApp = request.loginTargetApp;
        if (z) {
            parameters.putString("fx_app", loginTargetApp.targetApp);
        }
        if (request.shouldSkipAccountDeduplication) {
            parameters.putString("skip_dedupe", str3);
        }
        String str4 = request.messengerPageId;
        if (str4 != null) {
            parameters.putString("messenger_page_id", str4);
            parameters.putString("reset_messenger_state", request.resetMessengerState ? "1" : "0");
        }
        if (calledThroughLoggedOutAppSwitch) {
            parameters.putString("cct_over_app_switch", "1");
        }
        if (FacebookSdk.hasCustomTabsPrefetching) {
            if (request.isInstagramLogin()) {
                ReentrantLock reentrantLock = CustomTabPrefetchHelper.lock;
                Protocol.Companion.mayLaunchUrl(Utility.buildUri(Utility.getInstagramDialogAuthority(), "oauth/authorize", parameters));
            } else {
                ReentrantLock reentrantLock2 = CustomTabPrefetchHelper.lock;
                Protocol.Companion.mayLaunchUrl(Utility.buildUri(Utility.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/oauth", parameters));
            }
        }
        FragmentActivity activity = loginClient.getActivity();
        if (activity == null) {
            return 0;
        }
        Intent intent = new Intent(activity, (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.EXTRA_ACTION, "oauth");
        intent.putExtra(CustomTabMainActivity.EXTRA_PARAMS, parameters);
        String str5 = CustomTabMainActivity.EXTRA_CHROME_PACKAGE;
        String chromePackage = this.currentPackage;
        if (chromePackage == null) {
            chromePackage = Validate.getChromePackage();
            this.currentPackage = chromePackage;
        }
        intent.putExtra(str5, chromePackage);
        intent.putExtra(CustomTabMainActivity.EXTRA_TARGET_APP, loginTargetApp.targetApp);
        LoginFragment loginFragment = loginClient.fragment;
        if (loginFragment != null) {
            loginFragment.startActivityForResult(intent, 1);
        }
        return 1;
    }

    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        this.loginClient = loginClient;
        this.nameForLogging = "custom_tab";
        this.tokenSource = AccessTokenSource.CHROME_CUSTOM_TAB;
        String string = new BigInteger(100, new Random()).toString(32);
        Intrinsics.checkNotNullExpressionValue(string, "BigInteger(length * 5, r).toString(32)");
        this.expectedChallenge = string;
        calledThroughLoggedOutAppSwitch = false;
        this.validRedirectURI = Validate.getValidRedirectURI(super.getRedirectUrl());
    }
}
