package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public final class zzegr extends zzegq {
    private final zzche zza;
    private final zzcvf zzb;
    private final zzdbw zzc;
    private final zzehb zzd;
    private final zzedr zze;

    public zzegr(zzche zzcheVar, zzcvf zzcvfVar, zzdbw zzdbwVar, zzehb zzehbVar, zzedr zzedrVar) {
        this.zza = zzcheVar;
        this.zzb = zzcvfVar;
        this.zzc = zzdbwVar;
        this.zzd = zzehbVar;
        this.zze = zzedrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzegq
    public final ListenableFuture zzc(zzfcw zzfcwVar, Bundle bundle, zzfca zzfcaVar, zzfcn zzfcnVar) {
        zzcvf zzcvfVar = this.zzb;
        zzcvfVar.zzk(zzfcwVar);
        zzcvfVar.zzg(bundle);
        zzcvfVar.zzh(new zzcuy(zzfcnVar, zzfcaVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdR)).booleanValue()) {
            zzcvfVar.zze(this.zze);
        }
        zzcof zzcofVarZzc = this.zza.zzc();
        zzcofVarZzc.zzd(zzcvfVar.zzl());
        zzcofVarZzc.zzc(this.zzc);
        zzcse zzcseVarZzb = zzcofVarZzc.zze().zzb();
        return zzcseVarZzb.zzh(zzcseVarZzb.zzi());
    }
}
