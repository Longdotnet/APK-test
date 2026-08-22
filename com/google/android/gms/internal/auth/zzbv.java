package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbv implements Result {
    private final Status zza;
    private final String zzb;

    public zzbv(Status status) {
        com.google.android.gms.common.internal.zzah.checkNotNull(status);
        this.zza = status;
        this.zzb = wsbWxekY.oyI;
    }

    public final String getSpatulaHeader() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        this.zzb = str;
        this.zza = Status.RESULT_SUCCESS;
    }
}
