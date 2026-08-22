package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzego extends zzegq {
    private final zzche zza;
    private final zzdgw zzb;
    private final zzcvf zzc;
    private final zzdbw zzd;
    private final zzehb zze;
    private final zzedr zzf;

    public zzego(zzche zzcheVar, zzdgw zzdgwVar, zzcvf zzcvfVar, zzdbw zzdbwVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzdgwVar;
        this.zzc = zzcvfVar;
        this.zzd = zzdbwVar;
        this.zze = zzehbVar;
        this.zzf = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzc;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzf);
        }
        zzdha zzdhaVarZzg = this.zza.zzg();
        zzdhaVarZzg.zzf(zzcvfVar.zzl());
        zzdhaVarZzg.zze(this.zzd);
        zzdhaVarZzg.zzd(this.zzb);
        zzdhaVarZzg.zzc(new zzcop(null));
        zzcse zzcseVarZza = zzdhaVarZzg.zzg().zza();
        return zzcseVarZza.zzh(zzcseVarZza.zzi());
    }
}
