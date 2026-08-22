package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzegt extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzejh zzc;
    private final zzdbw zzd;
    private final zzdgw zze;
    private final zzcyv zzf;
    private final ViewGroup zzg;
    private final zzdbb zzh;
    private final zzehb zzi;
    private final zzedr zzj;

    public zzegt(zzche zzcheVar, zzcvf zzcvfVar, zzejh zzejhVar, zzdbw zzdbwVar, zzdgw zzdgwVar, zzcyv zzcyvVar, ViewGroup viewGroup, zzdbb zzdbbVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzejhVar;
        this.zzd = zzdbwVar;
        this.zze = zzdgwVar;
        this.zzf = zzcyvVar;
        this.zzg = viewGroup;
        this.zzh = zzdbbVar;
        this.zzi = zzehbVar;
        this.zzj = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zzj);
        }
        zzcpw zzcpwVarZzd = this.zza.zzd();
        zzcpwVarZzd.zzi(zzcvfVar.zzl());
        zzcpwVarZzd.zzf(this.zzd);
        zzcpwVarZzd.zze(this.zzc);
        zzcpwVarZzd.zzd(this.zze);
        zzcpwVarZzd.zzg(new zzcqs(this.zzf, this.zzh));
        zzcpwVarZzd.zzc(new zzcop(this.zzg));
        zzcse zzcseVarZzc = zzcpwVarZzd.zzk().zzc();
        return zzcseVarZzc.zzh(zzcseVarZzc.zzi());
    }
}
