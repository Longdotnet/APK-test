package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcje implements zzdtu {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    private final Context zze;
    private final zzble zzf;
    private final zzcio zzg;
    private final zzcje zzh = this;

    public zzcje(zzcio zzcioVar, Context context, zzble zzbleVar) {
        this.zzg = zzcioVar;
        this.zze = context;
        this.zzf = zzbleVar;
        zzhgr zzhgrVarZza = zzhgs.zza(this);
        this.zza = zzhgrVarZza;
        zzhgr zzhgrVarZza2 = zzhgs.zza(zzbleVar);
        this.zzb = zzhgrVarZza2;
        zzdtq zzdtqVarZzd = zzdtq.zzd(zzhgrVarZza2);
        this.zzc = zzdtqVarZzd;
        this.zzd = zzhgq.zzc(zzdts.zza(zzhgrVarZza, zzdtqVarZzd));
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtl zzb() {
        return new zzcjb(this.zzg, this.zzh, null);
    }

    public final zzdtp zzc() {
        return zzdtq.zzc(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final zzdtr zzd() {
        return (zzdtr) this.zzd.zzb();
    }
}
