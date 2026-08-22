package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcjc implements zzdtm {
    private final Long zza;
    private final String zzb;
    private final zzcio zzc;
    private final zzcje zzd;

    public zzcjc(zzcio zzcioVar, zzcje zzcjeVar, Long l, String str) {
        this.zzc = zzcioVar;
        this.zzd = zzcjeVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdtw zza() {
        zzcje zzcjeVar = this.zzd;
        return zzdtx.zza(this.zza.longValue(), zzcjeVar.zze, zzcjeVar.zzc(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdtm
    public final zzdua zzb() {
        zzcje zzcjeVar = this.zzd;
        return zzdub.zza(this.zza.longValue(), zzcjeVar.zze, zzcjeVar.zzc(), this.zzc, this.zzb);
    }
}
