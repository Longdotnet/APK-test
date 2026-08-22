package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class zzciy implements zzeyp {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    private final Context zzg;
    private final com.google.android.gms.ads.internal.client.zzr zzh;
    private final String zzi;
    private final zzcio zzj;

    public zzciy(zzcio zzcioVar, Context context, String str, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzj = zzcioVar;
        this.zzg = context;
        this.zzh = zzrVar;
        this.zzi = str;
        zzhgr zzhgrVarZza = zzhgs.zza(context);
        this.zza = zzhgrVarZza;
        zzhgr zzhgrVarZza2 = zzhgs.zza(zzrVar);
        this.zzb = zzhgrVarZza2;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzekz.zza(zzcioVar.zzl));
        this.zzc = zzhhaVarZzc;
        zzhha zzhhaVarZzc2 = zzhgq.zzc(zzele.zza());
        this.zzd = zzhhaVarZzc2;
        zzhha zzhhaVarZzc3 = zzhgq.zzc(zzdbd.zza());
        this.zze = zzhhaVarZzc3;
        this.zzf = zzhgq.zzc(zzeyn.zza(zzhgrVarZza, zzcioVar.zza, zzhgrVarZza2, zzcioVar.zzS, zzhhaVarZzc, zzhhaVarZzc2, zzfcy.zza(), zzhhaVarZzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzeyp
    public final zzeke zza() {
        zzeym zzeymVar = (zzeym) this.zzf.zzb();
        zzeky zzekyVar = (zzeky) this.zzc.zzb();
        zzcio zzcioVar = this.zzj;
        return new zzeke(this.zzg, this.zzh, this.zzi, zzeymVar, zzekyVar, zzchz.zzc(zzcioVar.zzbp), (zzdsj) zzcioVar.zzl.zzb());
    }
}
