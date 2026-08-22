package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzbu implements Result {
    private final Status zza;
    private ProxyResponse zzb;

    public zzbu(Status status) {
        this.zza = status;
    }

    public final ProxyResponse getResponse() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public zzbu(ProxyResponse proxyResponse) {
        this.zzb = proxyResponse;
        this.zza = Status.RESULT_SUCCESS;
    }
}
