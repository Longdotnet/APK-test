package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzegx extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzdbw zzc;
    private final zzehb zzd;
    private final zzfco zze;
    private final zzedr zzf;

    public zzegx(zzche zzcheVar, zzcvf zzcvfVar, zzdbw zzdbwVar, zzfco zzfcoVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzdbwVar;
        this.zze = zzfcoVar;
        this.zzd = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzfco zzfcoVar;
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zzd));
        zzbcv zzbcvVar = zzbde.zzdQ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (zzfcoVar = this.zze) != null) {
            zzcvfVar.zzj(zzfcoVar);
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdor zzdorVarZzh = this.zza.zzh();
        zzdorVarZzh.zzd(zzcvfVar.zzl());
        zzdorVarZzh.zzc(this.zzc);
        zzcse zzcseVarZzb = zzdorVarZzh.zze().zzb();
        return zzcseVarZzb.zzh(zzcseVarZzb.zzi());
    }
}
