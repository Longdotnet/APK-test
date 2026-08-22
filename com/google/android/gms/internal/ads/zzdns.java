package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdns implements zzgdj {
    final /* synthetic */ zzfca zza;
    final /* synthetic */ zzfcd zzb;
    final /* synthetic */ zzcmq zzc;
    final /* synthetic */ zzdny zzd;

    public zzdns(zzdny zzdnyVar, zzfca zzfcaVar, zzfcd zzfcdVar, zzcmq zzcmqVar) {
        this.zza = zzfcaVar;
        this.zzb = zzfcdVar;
        this.zzc = zzcmqVar;
        Objects.requireNonNull(zzdnyVar);
        this.zzd = zzdnyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzcfg zzcfgVar = (zzcfg) obj;
        zzfca zzfcaVar = this.zza;
        zzcfgVar.zzW(zzfcaVar, this.zzb);
        zzcgy zzcgyVarZzN = zzcfgVar.zzN();
        zzbcv zzbcvVar = zzbde.zzkB;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzcgyVarZzN != null) {
            zzcmq zzcmqVar = this.zzc;
            zzdny zzdnyVar = this.zzd;
            zzcgyVarZzN.zzM(zzcmqVar, zzdnyVar.zzi, zzdnyVar.zzj);
            zzcgyVarZzN.zzO(zzcmqVar, zzdnyVar.zzi, zzdnyVar.zzd);
        }
        if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zznt)).booleanValue() || zzcgyVarZzN == null) {
            return;
        }
        zzcgyVarZzN.zzP(zzfcaVar);
    }
}
