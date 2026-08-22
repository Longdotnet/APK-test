package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbio extends zzbhv {
    final /* synthetic */ zzbiq zza;

    public /* synthetic */ zzbio(zzbiq zzbiqVar, zzbip zzbipVar) {
        Objects.requireNonNull(zzbiqVar);
        this.zza = zzbiqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhw
    public final void zze(zzbhj zzbhjVar) {
        zzbiq zzbiqVar = this.zza;
        com.google.android.gms.ads.formats.zzg zzgVar = zzbiqVar.zza;
        com.google.ads.mediation.zze zzeVar = (com.google.ads.mediation.zze) zzgVar;
        zzeVar.zzb.zzd(zzeVar.zza, zzbiqVar.zzf(zzbhjVar));
    }
}
