package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.appset.zzb;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class KatanaProxyLoginMethodHandler extends WebLoginMethodHandler {
    public static final Parcelable.Creator<KatanaProxyLoginMethodHandler> CREATOR = new zzb(3);
    public final String nameForLogging;

    public KatanaProxyLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        this.nameForLogging = "katana_proxy_auth";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getNameForLogging() {
        return this.nameForLogging;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010c  */
    /* JADX WARN: Code duplicated, block: B:54:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:? A[LOOP:0: B:39:0x0106->B:55:?, LOOP_END, SYNTHETIC] */
    @Override // com.facebook.login.LoginMethodHandler
    public final int tryAuthorize(LoginClient.Request request) {
        Class<NativeProtocol> cls;
        String str;
        int i;
        Intrinsics.checkNotNullParameter(request, "request");
        boolean z = FacebookSdk.ignoreAppSwitchToLoggedOut && Validate.getChromePackage() != null && request.loginBehavior.allowsCustomTabAuth;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException unused) {
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "e2e.toString()");
        NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
        getLoginClient().getActivity();
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
        String str2 = request.messengerPageId;
        boolean z2 = request.resetMessengerState;
        boolean z3 = request.isFamilyLogin;
        boolean z4 = request.shouldSkipAccountDeduplication;
        String str3 = request.nonce;
        CodeChallengeMethod codeChallengeMethod = request.codeChallengeMethod;
        if (codeChallengeMethod != null) {
            codeChallengeMethod.name();
        }
        Class<NativeProtocol> cls2 = NativeProtocol.class;
        ArrayList<Intent> arrayList = null;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            str = string;
        } else {
            try {
                Intrinsics.checkNotNullParameter(applicationId, "applicationId");
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(authType, "authType");
                ArrayList arrayList2 = NativeProtocol.facebookAppInfoList;
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ArrayList arrayList4 = arrayList3;
                    cls = cls2;
                    String str4 = str3;
                    String str5 = applicationId;
                    boolean z5 = z4;
                    boolean z6 = z3;
                    boolean z7 = z2;
                    String str6 = str2;
                    String str7 = authType;
                    HashSet hashSet = permissions;
                    String str8 = applicationId;
                    boolean z8 = z;
                    boolean z9 = z;
                    str = string;
                    try {
                        Intent intentCreateNativeAppIntent = NativeProtocol.INSTANCE.createNativeAppIntent((NativeProtocol.KatanaAppInfo) it.next(), str5, permissions, string, zHasPublishPermission, defaultAudience2, clientState, str7, z8, str6, z7, LoginTargetApp.FACEBOOK, z6, z5, str4);
                        if (intentCreateNativeAppIntent != null) {
                            arrayList4.add(intentCreateNativeAppIntent);
                        }
                        string = str;
                        cls2 = cls;
                        arrayList3 = arrayList4;
                        str3 = str4;
                        z4 = z5;
                        z3 = z6;
                        z2 = z7;
                        str2 = str6;
                        authType = str7;
                        permissions = hashSet;
                        applicationId = str8;
                        z = z9;
                    } catch (Throwable th) {
                        th = th;
                        CrashShieldHandler.handleThrowable(cls, th);
                        addLoggingExtra("e2e", str);
                        i = 0;
                        for (Intent intent : arrayList) {
                            i++;
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            Validate.sdkInitialized();
                            if (tryIntent(intent)) {
                                return i;
                            }
                        }
                        return 0;
                    }
                }
                str = string;
                arrayList = arrayList3;
            } catch (Throwable th2) {
                th = th2;
                cls = cls2;
                str = string;
            }
        }
        addLoggingExtra("e2e", str);
        i = 0;
        while (r0.hasNext()) {
            i++;
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            Validate.sdkInitialized();
            if (tryIntent(intent)) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KatanaProxyLoginMethodHandler(Parcel source) {
        super(source, 1);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "katana_proxy_auth";
    }
}
