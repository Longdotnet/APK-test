package com.google.android.gms.internal.auth;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.AuthProxy;
import com.google.android.gms.auth.api.AuthProxyOptions;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo extends GoogleApi<AuthProxyOptions> implements HasApiKey {
    public zzbo(Activity activity, AuthProxyOptions authProxyOptions) {
        super(activity, (Api<AuthProxyOptions>) AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task getSpatulaHeader() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbk
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
            }
        }).setMethodKey(1520).build());
    }

    public final Task performProxyRequest(final ProxyRequest proxyRequest) {
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.auth.zzbl
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzbo zzboVar = this.zza;
                ProxyRequest proxyRequest2 = proxyRequest;
                ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), proxyRequest2);
            }
        }).setMethodKey(1518).build());
    }

    public zzbo(Context context, AuthProxyOptions authProxyOptions) {
        super(context, (Api<AuthProxyOptions>) AuthProxy.API, authProxyOptions == null ? AuthProxyOptions.zza : authProxyOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
