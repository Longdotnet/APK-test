package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfkz implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zzb;
    final /* synthetic */ zzfld zzc;

    public zzfkz(zzfld zzfldVar, long j, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zza = j;
        this.zzb = zzeaVar;
        Objects.requireNonNull(zzfldVar);
        this.zzc = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfld zzfldVar = this.zzc;
        if (zzfldVar.zzp != null) {
            zzfldVar.zzp.zzi(this.zza, zzfld.zzO(this.zzb), zzfldVar.zzr, zzfldVar.zze.zzd, zzfldVar.zzd(), zzfldVar.zzD());
        }
    }
}
