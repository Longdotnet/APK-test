package com.google.android.gms.internal.p000authapi;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.zbc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class zbao extends GoogleApi implements HasApiKey {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbal zbalVar = new zbal();
        zbb = zbalVar;
        zbc = new Api("Auth.Api.Identity.CredentialSaving.API", zbalVar, clientKey);
    }

    public zbao(Activity activity, zbc zbcVar) {
        super(activity, (Api<zbc>) zbc, zbcVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zbd = zbbb.zba();
    }

    public final Task saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        zzah.checkNotNull(saveAccountLinkingTokenRequest);
        new ArrayList();
        TextUtils.isEmpty(saveAccountLinkingTokenRequest.zbe);
        String str = this.zbd;
        PendingIntent pendingIntent = saveAccountLinkingTokenRequest.zba;
        zzah.checkArgument(pendingIntent != null, "Consent PendingIntent cannot be null");
        String str2 = saveAccountLinkingTokenRequest.zbb;
        zzah.checkArgument("auth_code".equals(str2), "Invalid tokenType");
        String str3 = saveAccountLinkingTokenRequest.zbc;
        zzah.checkArgument(!TextUtils.isEmpty(str3), "serviceId cannot be null or empty");
        ArrayList arrayList = saveAccountLinkingTokenRequest.zbd;
        zzah.checkArgument(arrayList != null, "scopes cannot be null");
        final SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest2 = new SaveAccountLinkingTokenRequest(pendingIntent, str2, str3, arrayList, str, saveAccountLinkingTokenRequest.zbf);
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbg).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbaj
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbao zbaoVar = this.zba;
                SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest3 = saveAccountLinkingTokenRequest2;
                zbam zbamVar = new zbam(zbaoVar, (TaskCompletionSource) obj2);
                zbz zbzVar = (zbz) ((zbw) obj).getService();
                zzah.checkNotNull(saveAccountLinkingTokenRequest3);
                zbzVar.zbc(zbamVar, saveAccountLinkingTokenRequest3);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1535).build());
    }

    public final Task savePassword(SavePasswordRequest savePasswordRequest) {
        zzah.checkNotNull(savePasswordRequest);
        final SavePasswordRequest savePasswordRequest2 = new SavePasswordRequest(savePasswordRequest.zba, this.zbd, savePasswordRequest.zbc);
        return doRead(TaskApiCall.builder().setFeatures(zbba.zbe).run(new RemoteCall() { // from class: com.google.android.gms.internal.auth-api.zbak
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zbao zbaoVar = this.zba;
                SavePasswordRequest savePasswordRequest3 = savePasswordRequest2;
                zban zbanVar = new zban(zbaoVar, (TaskCompletionSource) obj2);
                zbz zbzVar = (zbz) ((zbw) obj).getService();
                zzah.checkNotNull(savePasswordRequest3);
                zbzVar.zbd(zbanVar, savePasswordRequest3);
            }
        }).setAutoResolveMissingFeatures(false).setMethodKey(1536).build());
    }

    public zbao(Context context, zbc zbcVar) {
        super(context, (Api<zbc>) zbc, zbcVar, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zbd = zbbb.zba();
    }
}
