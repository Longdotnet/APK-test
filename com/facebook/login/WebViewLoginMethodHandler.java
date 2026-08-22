package com.facebook.login;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.room.RoomOpenHelper;
import com.facebook.AccessTokenSource;
import com.facebook.internal.FacebookDialogFragment;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WebDialog;
import com.google.android.gms.appset.zzb;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class WebViewLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<WebViewLoginMethodHandler> CREATOR = new zzb(7);
    public String e2e;
    public WebDialog loginDialog;
    public final String nameForLogging;
    public final AccessTokenSource tokenSource;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewLoginMethodHandler(Parcel source) {
        super(source, 0);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
        this.e2e = source.readString();
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final void cancel() {
        WebDialog webDialog = this.loginDialog;
        if (webDialog != null) {
            if (webDialog != null) {
                webDialog.cancel();
            }
            this.loginDialog = null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getNameForLogging() {
        return this.nameForLogging;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public final AccessTokenSource getTokenSource() {
        return this.tokenSource;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final int tryAuthorize(LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        Bundle parameters = getParameters(request);
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this, request, 23, false);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
        this.e2e = string;
        addLoggingExtra("e2e", string);
        FragmentActivity activity = getLoginClient().getActivity();
        if (activity == null) {
            return 0;
        }
        boolean zIsChromeOS = Utility.isChromeOS(activity);
        String applicationId = request.applicationId;
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Validate.notNullOrEmpty(applicationId, "applicationId");
        String str = this.e2e;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str2 = zIsChromeOS ? "fbconnect://chrome_os_success" : "fbconnect://success";
        String authType = request.authType;
        Intrinsics.checkNotNullParameter(authType, "authType");
        LoginBehavior loginBehavior = request.loginBehavior;
        Intrinsics.checkNotNullParameter(loginBehavior, "loginBehavior");
        LoginTargetApp targetApp = request.loginTargetApp;
        Intrinsics.checkNotNullParameter(targetApp, "targetApp");
        boolean z = request.isFamilyLogin;
        boolean z2 = request.shouldSkipAccountDeduplication;
        parameters.putString("redirect_uri", str2);
        parameters.putString("client_id", applicationId);
        parameters.putString("e2e", str);
        parameters.putString("response_type", targetApp == LoginTargetApp.INSTAGRAM ? "token,signed_request,graph_domain,granted_scopes" : "token,signed_request,graph_domain");
        parameters.putString("return_scopes", "true");
        parameters.putString("auth_type", authType);
        parameters.putString("login_behavior", loginBehavior.name());
        if (z) {
            parameters.putString("fx_app", targetApp.targetApp);
        }
        if (z2) {
            parameters.putString("skip_dedupe", "true");
        }
        int i = WebDialog.webDialogTheme;
        WebDialog.initDefaultTheme(activity);
        this.loginDialog = new WebDialog(activity, "oauth", parameters, targetApp, roomOpenHelper);
        FacebookDialogFragment facebookDialogFragment = new FacebookDialogFragment();
        facebookDialogFragment.setRetainInstance(true);
        facebookDialogFragment.innerDialog = this.loginDialog;
        facebookDialogFragment.show(activity.getSupportFragmentManager(), "FacebookDialogFragment");
        return 1;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, i);
        dest.writeString(this.e2e);
    }

    public WebViewLoginMethodHandler(LoginClient loginClient) {
        this.loginClient = loginClient;
        this.nameForLogging = "web_view";
        this.tokenSource = AccessTokenSource.WEB_VIEW;
    }
}
