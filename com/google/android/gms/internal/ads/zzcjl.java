package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcjl implements zzfbu {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    private final zzcio zzi;

    public zzcjl(zzcio zzcioVar, Context context, String str) {
        this.zzi = zzcioVar;
        zzhgr zzhgrVarZza = zzhgs.zza(context);
        this.zza = zzhgrVarZza;
        zzhha zzhhaVar = zzcioVar.zzbh;
        zzezu zzezuVarZzc = zzezu.zzc(zzhgrVarZza, zzhhaVar, zzcioVar.zzbi);
        this.zzb = zzezuVarZzc;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzfbe.zza(zzhhaVar));
        this.zzc = zzhhaVarZzc;
        zzhha zzhhaVarZzc2 = zzhgq.zzc(zzfct.zza());
        this.zzd = zzhhaVarZzc2;
        zzhha zzhhaVarZzc3 = zzhgq.zzc(zzfbo.zza(zzhgrVarZza, zzcioVar.zza, zzcioVar.zzS, zzezuVarZzc, zzhhaVarZzc, zzfcy.zza(), zzhhaVarZzc2));
        this.zze = zzhhaVarZzc3;
        this.zzf = zzhgq.zzc(zzfby.zza(zzhhaVarZzc3, zzhhaVarZzc, zzhhaVarZzc2));
        zzhgr zzhgrVarZzc = zzhgs.zzc(str);
        this.zzg = zzhgrVarZzc;
        this.zzh = zzhgq.zzc(zzfbs.zza(zzhgrVarZzc, zzhhaVarZzc3, zzhgrVarZza, zzhhaVarZzc, zzhhaVarZzc2, zzcioVar.zzi, zzcioVar.zzU, zzcioVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final zzfbr zza() {
        return (zzfbr) this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfbu
    public final zzfbx zzb() {
        return (zzfbx) this.zzf.zzb();
    }
}
