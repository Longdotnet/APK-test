package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
final class zzbyd {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzbyd(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyo zzbyoVar) {
        this.zza = zzgVar;
    }

    public final void zza(int i, long j) {
        long j2;
        zzbcv zzbcvVar = zzbde.zzaI;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zza;
        com.google.android.gms.ads.internal.util.zzj zzjVar = (com.google.android.gms.ads.internal.util.zzj) zzgVar;
        zzjVar.zzR();
        synchronized (zzjVar.zza) {
            j2 = zzjVar.zzD;
        }
        if (j - j2 < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzaJ)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzj zzjVar2 = (com.google.android.gms.ads.internal.util.zzj) zzgVar;
            zzjVar2.zzH(i);
            zzjVar2.zzI(j);
        } else {
            com.google.android.gms.ads.internal.util.zzj zzjVar3 = (com.google.android.gms.ads.internal.util.zzj) zzgVar;
            zzjVar3.zzH(-1);
            zzjVar3.zzI(j);
        }
    }
}
