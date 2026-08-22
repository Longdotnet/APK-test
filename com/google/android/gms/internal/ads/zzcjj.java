package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzcjj implements zzfag {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    private final zzcio zzh;

    public zzcjj(zzcio zzcioVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzh = zzcioVar;
        zzhgr zzhgrVarZza = zzhgs.zza(context);
        this.zza = zzhgrVarZza;
        zzhgr zzhgrVarZza2 = zzhgs.zza(zzrVar);
        this.zzb = zzhgrVarZza2;
        zzhgr zzhgrVarZza3 = zzhgs.zza(str);
        this.zzc = zzhgrVarZza3;
        zzhha zzhhaVar = zzcioVar.zzl;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzekz.zza(zzhhaVar));
        this.zzd = zzhhaVarZzc;
        zzhha zzhhaVarZzc2 = zzhgq.zzc(zzfbe.zza(zzcioVar.zzbh));
        this.zze = zzhhaVarZzc2;
        zzhha zzhhaVarZzc3 = zzhgq.zzc(zzfae.zza(zzhgrVarZza, zzcioVar.zza, zzcioVar.zzS, zzhhaVarZzc, zzhhaVarZzc2, zzfcy.zza()));
        this.zzf = zzhhaVarZzc3;
        this.zzg = zzhgq.zzc(zzelh.zza(zzhgrVarZza, zzhgrVarZza2, zzhgrVarZza3, zzhhaVarZzc3, zzhhaVarZzc, zzhhaVarZzc2, zzcioVar.zzi, zzcioVar.zzU, zzhhaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzfag
    public final zzelg zza() {
        return (zzelg) this.zzg.zzb();
    }
}
