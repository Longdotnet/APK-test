package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzegv extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzejh zzc;
    private final zzdbw zzd;
    private final zzehb zze;
    private final zzedr zzf;

    public zzegv(zzche zzcheVar, zzcvf zzcvfVar, zzejh zzejhVar, zzdbw zzdbwVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzejhVar;
        this.zzd = zzdbwVar;
        this.zze = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdge zzdgeVarZzf = this.zza.zzf();
        zzdgeVarZzf.zze(zzcvfVar.zzl());
        zzdgeVarZzf.zzd(this.zzd);
        zzdgeVarZzf.zzc(this.zzc);
        zzcse zzcseVarZza = zzdgeVarZzf.zzf().zza();
        return zzcseVarZza.zzh(zzcseVarZza.zzi());
    }
}
