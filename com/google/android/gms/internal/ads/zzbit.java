package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzbit extends zzbic {
    private final com.google.android.gms.ads.formats.zzi zza;

    public zzbit(com.google.android.gms.ads.formats.zzi zziVar) {
        this.zza = zziVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbid
    public final void zze(zzbij zzbijVar) {
        zzbik zzbikVar = new zzbik(zzbijVar);
        com.google.ads.mediation.zze zzeVar = (com.google.ads.mediation.zze) this.zza;
        zzeVar.getClass();
        com.google.ads.mediation.zza zzaVar = new com.google.ads.mediation.zza();
        zzaVar.zzo = new Bundle();
        zzaVar.zza = zzbikVar.zzh();
        zzaVar.zzb = zzbikVar.zzk();
        zzaVar.zzc = zzbikVar.zzf();
        zzaVar.zzd = zzbikVar.zzb();
        zzaVar.zze = zzbikVar.zzg();
        zzaVar.zzf = zzbikVar.zze();
        zzaVar.zzg = zzbikVar.zzc();
        zzaVar.zzh = zzbikVar.zzj();
        zzaVar.zzi = zzbikVar.zzi();
        zzaVar.zzn = zzbikVar.zzd();
        zzaVar.zzp = true;
        zzaVar.zzq = true;
        zzaVar.zzj = zzbikVar.zza();
        zzeVar.zzb.onAdLoaded(zzeVar.zza, zzaVar);
    }
}
