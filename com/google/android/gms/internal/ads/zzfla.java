package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfla implements Runnable {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zze zza;
    final /* synthetic */ zzfld zzb;

    public zzfla(zzfld zzfldVar, com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zza = zzeVar;
        Objects.requireNonNull(zzfldVar);
        this.zzb = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzJ(this.zza);
    }
}
