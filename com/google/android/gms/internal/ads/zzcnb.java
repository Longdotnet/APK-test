package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcnb implements zzgdj {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcnc zzb;

    public zzcnb(zzcnc zzcncVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzcncVar);
        this.zzb = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        String str = this.zza;
        zzcnc zzcncVar = this.zzb;
        zzcncVar.zzh.zza(zzcncVar.zzg.zze(zzcncVar.zze, zzcncVar.zzf, false, str, null, zzcncVar.zzx(), zzcncVar.zzo), null);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcnc zzcncVar = this.zzb;
        zzcncVar.zzh.zza(zzcncVar.zzg.zze(zzcncVar.zze, zzcncVar.zzf, false, this.zza, (String) obj, zzcncVar.zzx(), zzcncVar.zzo), zzcncVar.zzn);
    }
}
