package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookSignatureValidator;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.appset.zzb;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InstagramAppLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<InstagramAppLoginMethodHandler> CREATOR = new zzb(2);
    public final String nameForLogging;
    public final AccessTokenSource tokenSource;

    public InstagramAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.nameForLogging = "instagram_login";
        this.tokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
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
        Object obj;
        Intrinsics.checkNotNullParameter(request, "request");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        String applicationId = request.applicationId;
        HashSet permissions = request.permissions;
        boolean zHasPublishPermission = request.hasPublishPermission();
        DefaultAudience defaultAudience = request.defaultAudience;
        if (defaultAudience == null) {
            defaultAudience = DefaultAudience.NONE;
        }
        DefaultAudience defaultAudience2 = defaultAudience;
        String clientState = getClientState(request.authId);
        String authType = request.authType;
        String str = request.messengerPageId;
        boolean z = request.resetMessengerState;
        boolean z2 = request.isFamilyLogin;
        boolean z3 = request.shouldSkipAccountDeduplication;
        Intent intent = null;
        if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
            try {
                Intrinsics.checkNotNullParameter(applicationId, "applicationId");
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(authType, "authType");
                try {
                    Intent intentCreateNativeAppIntent = NativeProtocol.INSTANCE.createNativeAppIntent(new NativeProtocol.KatanaAppInfo(2), applicationId, permissions, string, zHasPublishPermission, defaultAudience2, clientState, authType, false, str, z, LoginTargetApp.INSTAGRAM, z2, z3, "");
                    if (!CrashShieldHandler.isObjectCrashing(NativeProtocol.class) && intentCreateNativeAppIntent != null) {
                        try {
                            ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intentCreateNativeAppIntent, 0);
                            if (resolveInfoResolveActivity != null) {
                                HashSet hashSet = FacebookSignatureValidator.validAppSignatureHashes;
                                String str2 = resolveInfoResolveActivity.activityInfo.packageName;
                                Intrinsics.checkNotNullExpressionValue(str2, "resolveInfo.activityInfo.packageName");
                                if (FacebookSignatureValidator.validateSignature(activity, str2)) {
                                    intent = intentCreateNativeAppIntent;
                                }
                            }
                        } catch (Throwable th) {
                            obj = NativeProtocol.class;
                            try {
                                CrashShieldHandler.handleThrowable(obj, th);
                            } catch (Throwable th2) {
                                th = th2;
                                CrashShieldHandler.handleThrowable(obj, th);
                            }
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = NativeProtocol.class;
                }
            } catch (Throwable th4) {
                th = th4;
                obj = NativeProtocol.class;
            }
        }
        Intent intent2 = intent;
        addLoggingExtra("e2e", string);
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Validate.sdkInitialized();
        return tryIntent(intent2) ? 1 : 0;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        super.writeToParcel(dest, i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InstagramAppLoginMethodHandler(Parcel source) {
        super(source, 1);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "instagram_login";
        this.tokenSource = AccessTokenSource.INSTAGRAM_APPLICATION_WEB;
    }
}
