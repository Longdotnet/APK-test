package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcna implements zzgdj {
    final /* synthetic */ zzcnc zza;

    public zzcna(zzcnc zzcncVar) {
        Objects.requireNonNull(zzcncVar);
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        String str = (String) obj;
        zzcnc zzcncVar = this.zza;
        zzcncVar.zzh.zzc(zzcncVar.zzg.zze(zzcncVar.zze, zzcncVar.zzf, false, "", str, zzcncVar.zzf.zzc, null), true == com.google.android.gms.ads.internal.zzv.zza.zzi.zzA(zzcncVar.zza) ? 2 : 1);
    }
}
