package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;

/* JADX INFO: loaded from: classes2.dex */
final class zzfdg implements zzgdj {
    final /* synthetic */ zzcfg zza;
    final /* synthetic */ zzcmq zzb;
    final /* synthetic */ zzfjy zzc;
    final /* synthetic */ zzeca zzd;

    public zzfdg(zzcfg zzcfgVar, zzcmq zzcmqVar, zzfjy zzfjyVar, zzeca zzecaVar) {
        this.zza = zzcfgVar;
        this.zzb = zzcmqVar;
        this.zzc = zzfjyVar;
        this.zzd = zzecaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzcmq zzcmqVar;
        String str = (String) obj;
        zzcfg zzcfgVar = this.zza;
        zzfca zzfcaVarZzD = zzcfgVar.zzD();
        if (zzfcaVarZzD != null && !zzfcaVarZzD.zzai) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzfcaVarZzD.zzax;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkx)).booleanValue() && (zzcmqVar = this.zzb) != null && zzcmq.zzj(str)) {
                zzcmqVar.zzi(str, this.zzc, com.google.android.gms.ads.internal.client.zzbb.zzb.zzg, zzvVar);
                return;
            } else {
                this.zzc.zzd(str, zzvVar, null, null);
                return;
            }
        }
        zzfcd zzfcdVarZzR = zzcfgVar.zzR();
        if (zzfcdVarZzR == null) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(new IllegalArgumentException("Common configuration cannot be null"), nYVxXTZQ.sUyLSYCSFp);
            return;
        }
        com.google.android.gms.ads.internal.zzv zzvVar2 = com.google.android.gms.ads.internal.zzv.zza;
        zzvVar2.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zZzA = zzvVar2.zzi.zzA(zzcfgVar.getContext());
        boolean z = false;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgx)).booleanValue() && zzfcaVarZzD != null && zzfcaVarZzD.zzS;
        if (zzfcaVarZzD != null && zzfcaVarZzD.zzad != null) {
            z = true;
        }
        this.zzd.zzd(new zzecc(jCurrentTimeMillis, zzfcdVarZzR.zzb, str, (zZzA || z2 || z) ? 2 : 1));
    }
}
