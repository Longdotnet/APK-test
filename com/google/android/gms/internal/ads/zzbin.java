package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbin extends zzbhs {
    final /* synthetic */ zzbiq zza;

    public /* synthetic */ zzbin(zzbiq zzbiqVar, zzbip zzbipVar) {
        Objects.requireNonNull(zzbiqVar);
        this.zza = zzbiqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbht
    public final void zze(zzbhj zzbhjVar, String str) {
        zzbiq zzbiqVar = this.zza;
        if (zzbiqVar.zzb == null) {
            return;
        }
        com.google.android.gms.ads.formats.zzf zzfVar = zzbiqVar.zzb;
        com.google.ads.mediation.zze zzeVar = (com.google.ads.mediation.zze) zzfVar;
        zzeVar.zzb.zze(zzeVar.zza, zzbiqVar.zzf(zzbhjVar), str);
    }
}
