package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcit implements zzexb {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    private final zzcio zzg;

    public zzcit(zzcio zzcioVar, Context context, String str) {
        this.zzg = zzcioVar;
        zzhgr zzhgrVarZza = zzhgs.zza(context);
        this.zza = zzhgrVarZza;
        zzhgr zzhgrVarZza2 = zzhgs.zza(str);
        this.zzb = zzhgrVarZza2;
        zzhha zzhhaVar = zzcioVar.zzbh;
        zzezt zzeztVarZzc = zzezt.zzc(zzhgrVarZza, zzhhaVar, zzcioVar.zzbi);
        this.zzc = zzeztVarZzc;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzexz.zza(zzhhaVar));
        this.zzd = zzhhaVarZzc;
        zzhha zzhhaVar2 = zzcioVar.zza;
        zzhha zzhhaVar3 = zzcioVar.zzS;
        zzfcy zzfcyVarZza = zzfcy.zza();
        zzhha zzhhaVar4 = zzcioVar.zzi;
        zzhha zzhhaVarZzc2 = zzhgq.zzc(zzeyb.zza(zzhgrVarZza, zzhhaVar2, zzhhaVar3, zzeztVarZzc, zzhhaVarZzc, zzfcyVarZza, zzhhaVar4));
        this.zze = zzhhaVarZzc2;
        this.zzf = zzhgq.zzc(zzeyh.zza(zzhhaVar3, zzhgrVarZza, zzhgrVarZza2, zzhhaVarZzc2, zzhhaVarZzc, zzhhaVar4, zzcioVar.zzl));
    }

    @Override // com.google.android.gms.internal.ads.zzexb
    public final zzeyg zza() {
        return (zzeyg) this.zzf.zzb();
    }
}
