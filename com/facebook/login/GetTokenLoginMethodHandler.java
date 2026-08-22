package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.ProfileCache;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.appset.zzb;
import java.util.ArrayList;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class GetTokenLoginMethodHandler extends LoginMethodHandler {
    public static final Parcelable.Creator<GetTokenLoginMethodHandler> CREATOR = new zzb(1);
    public GetTokenClient getTokenClient;
    public final String nameForLogging;

    public GetTokenLoginMethodHandler(LoginClient loginClient) {
        this.loginClient = loginClient;
        this.nameForLogging = "get_token";
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final void cancel() {
        GetTokenClient getTokenClient = this.getTokenClient;
        if (getTokenClient == null) {
            return;
        }
        getTokenClient.running = false;
        getTokenClient.listener = null;
        this.getTokenClient = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public final String getNameForLogging() {
        return this.nameForLogging;
    }

    public final void onComplete(LoginClient.Request request, Bundle result) {
        LoginClient.Result result2;
        AuthenticationToken authenticationToken;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            AccessToken accessTokenCreateAccessTokenFromNativeLogin = CloseableKt.createAccessTokenFromNativeLogin(result, request.applicationId);
            String str = request.nonce;
            String string = result.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string == null || string.length() == 0 || str == null || str.length() == 0) {
                authenticationToken = null;
            } else {
                try {
                    authenticationToken = new AuthenticationToken(string, str);
                } catch (Exception e) {
                    throw new FacebookException(e.getMessage());
                }
            }
            result2 = new LoginClient.Result(request, LoginClient.Result.Code.SUCCESS, accessTokenCreateAccessTokenFromNativeLogin, authenticationToken, null, null);
        } catch (FacebookException e2) {
            LoginClient.Request request2 = getLoginClient().pendingRequest;
            String message = e2.getMessage();
            ArrayList arrayList = new ArrayList();
            if (message != null) {
                arrayList.add(message);
            }
            result2 = new LoginClient.Result(request2, LoginClient.Result.Code.ERROR, null, null, TextUtils.join(": ", arrayList), null);
        }
        getLoginClient().completeAndValidate(result2);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0049 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:24:0x004b A[Catch: all -> 0x0096, TRY_ENTER, TryCatch #1 {, blocks: (B:7:0x001b, B:12:0x0024, B:24:0x004b, B:27:0x0057, B:18:0x0042, B:15:0x0032), top: B:51:0x001b, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057 A[Catch: all -> 0x0096, TRY_LEAVE, TryCatch #1 {, blocks: (B:7:0x001b, B:12:0x0024, B:24:0x004b, B:27:0x0057, B:18:0x0042, B:15:0x0032), top: B:51:0x001b, inners: #0 }] */
    @Override // com.facebook.login.LoginMethodHandler
    public final int tryAuthorize(LoginClient.Request request) {
        int i;
        Intent intentCreatePlatformServiceIntent;
        boolean z;
        Intrinsics.checkNotNullParameter(request, "request");
        Context activity = getLoginClient().getActivity();
        if (activity == null) {
            activity = FacebookSdk.getApplicationContext();
        }
        GetTokenClient getTokenClient = new GetTokenClient(activity, request);
        this.getTokenClient = getTokenClient;
        synchronized (getTokenClient) {
            if (!getTokenClient.running) {
                NativeProtocol nativeProtocol = NativeProtocol.INSTANCE;
                int i2 = getTokenClient.protocolVersion;
                if (CrashShieldHandler.isObjectCrashing(NativeProtocol.class)) {
                    i = 0;
                    if (i == -1) {
                        NativeProtocol nativeProtocol2 = NativeProtocol.INSTANCE;
                        intentCreatePlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(getTokenClient.context);
                        if (intentCreatePlatformServiceIntent == null) {
                            z = false;
                        } else {
                            getTokenClient.running = true;
                            getTokenClient.context.bindService(intentCreatePlatformServiceIntent, getTokenClient, 1);
                            z = true;
                        }
                    }
                } else {
                    try {
                        i = NativeProtocol.INSTANCE.getLatestAvailableProtocolVersionForAppInfoList(NativeProtocol.facebookAppInfoList, new int[]{i2}).mLoggingLevel;
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(NativeProtocol.class, th);
                        i = 0;
                    }
                    if (i == -1) {
                        NativeProtocol nativeProtocol3 = NativeProtocol.INSTANCE;
                        intentCreatePlatformServiceIntent = NativeProtocol.createPlatformServiceIntent(getTokenClient.context);
                        if (intentCreatePlatformServiceIntent == null) {
                            z = false;
                        } else {
                            getTokenClient.running = true;
                            getTokenClient.context.bindService(intentCreatePlatformServiceIntent, getTokenClient, 1);
                            z = true;
                        }
                    }
                }
            }
            z = false;
        }
        if (Boolean.valueOf(z).equals(Boolean.FALSE)) {
            return 0;
        }
        ProfileCache profileCache = getLoginClient().backgroundProcessingListener;
        if (profileCache != null) {
            View view = ((LoginFragment) profileCache.sharedPreferences).progressBar;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                throw null;
            }
            view.setVisibility(0);
        }
        CodelessManager$$ExternalSyntheticLambda0 codelessManager$$ExternalSyntheticLambda0 = new CodelessManager$$ExternalSyntheticLambda0(this, request, 7);
        GetTokenClient getTokenClient2 = this.getTokenClient;
        if (getTokenClient2 != null) {
            getTokenClient2.listener = codelessManager$$ExternalSyntheticLambda0;
        }
        return 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetTokenLoginMethodHandler(Parcel source) {
        super(source);
        Intrinsics.checkNotNullParameter(source, "source");
        this.nameForLogging = "get_token";
    }
}
