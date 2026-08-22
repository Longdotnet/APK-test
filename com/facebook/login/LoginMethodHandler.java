package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsLoggerImpl;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LoginMethodHandler implements Parcelable {
    public LoginClient loginClient;
    public HashMap methodLoggingExtras;

    public LoginMethodHandler(Parcel source) {
        HashMap map;
        Intrinsics.checkNotNullParameter(source, "source");
        int i = source.readInt();
        if (i < 0) {
            map = null;
        } else {
            map = new HashMap();
            if (i > 0) {
                int i2 = 0;
                do {
                    i2++;
                    map.put(source.readString(), source.readString());
                } while (i2 < i);
            }
        }
        this.methodLoggingExtras = map != null ? MapsKt__MapsKt.toMutableMap(map) : null;
    }

    public final void addLoggingExtra(String str, String str2) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        HashMap map = this.methodLoggingExtras;
        if (map == null) {
            return;
        }
    }

    public void cancel() {
    }

    public final LoginClient getLoginClient() {
        LoginClient loginClient = this.loginClient;
        if (loginClient != null) {
            return loginClient;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loginClient");
        throw null;
    }

    public abstract String getNameForLogging();

    public String getRedirectUrl() {
        return "fb" + FacebookSdk.getApplicationId() + "://authorize/";
    }

    public final void logWebLoginCompleted(String str) {
        LoginClient.Request request = getLoginClient().pendingRequest;
        String applicationId = request == null ? null : request.applicationId;
        if (applicationId == null) {
            applicationId = FacebookSdk.getApplicationId();
        }
        AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(getLoginClient().getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
            appEventsLoggerImpl.logEventImplicitly(bundle, "fb_dialogs_web_login_dialog_complete");
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    public final void processCodeExchange(LoginClient.Request request, Bundle bundle) throws Throwable {
        GraphRequest graphRequestNewGraphPathRequest;
        Intrinsics.checkNotNullParameter(request, "request");
        String string = bundle.getString("code");
        if (Utility.isNullOrEmpty(string)) {
            throw new FacebookException("No code param found from the request");
        }
        if (string == null) {
            graphRequestNewGraphPathRequest = null;
        } else {
            String redirectUri = getRedirectUrl();
            String str = request.codeVerifier;
            if (str == null) {
                str = "";
            }
            HttpMethod httpMethod = HttpMethod.GET;
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Bundle bundle2 = new Bundle();
            bundle2.putString("code", string);
            bundle2.putString("client_id", FacebookSdk.getApplicationId());
            bundle2.putString("redirect_uri", redirectUri);
            bundle2.putString("code_verifier", str);
            String str2 = GraphRequest.MIME_BOUNDARY;
            graphRequestNewGraphPathRequest = GraphRequest.Companion.newGraphPathRequest(null, "oauth/access_token", null);
            graphRequestNewGraphPathRequest.httpMethod = httpMethod;
            graphRequestNewGraphPathRequest.parameters = bundle2;
        }
        if (graphRequestNewGraphPathRequest == null) {
            throw new FacebookException("Failed to create code exchange request");
        }
        GraphResponse graphResponseExecuteAndWait = graphRequestNewGraphPathRequest.executeAndWait();
        FacebookRequestError facebookRequestError = graphResponseExecuteAndWait.error;
        if (facebookRequestError != null) {
            throw new FacebookServiceException(facebookRequestError, facebookRequestError.getErrorMessage());
        }
        try {
            JSONObject jSONObject = graphResponseExecuteAndWait.graphObject;
            String string2 = jSONObject != null ? jSONObject.getString("access_token") : null;
            if (jSONObject == null || Utility.isNullOrEmpty(string2)) {
                throw new FacebookException("No access token found from result");
            }
            bundle.putString("access_token", string2);
            if (jSONObject.has("id_token")) {
                bundle.putString("id_token", jSONObject.getString("id_token"));
            }
        } catch (JSONException e) {
            throw new FacebookException(Intrinsics.stringPlus(e.getMessage(), "Fail to process code exchange response: "));
        }
    }

    public void putChallengeParam(JSONObject jSONObject) {
    }

    public abstract int tryAuthorize(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        HashMap map = this.methodLoggingExtras;
        if (map == null) {
            dest.writeInt(-1);
            return;
        }
        dest.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            dest.writeString(str);
            dest.writeString(str2);
        }
    }

    public final String getClientState(String str) {
        Intrinsics.checkNotNullParameter(str, YcVWhnLsj.eWmXpriHPSnZyUq);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", Intrinsics.stringPlus(e.getMessage(), "Error creating client state json: "));
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "param.toString()");
        return string;
    }
}
