package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcmp implements zzgdj {
    final /* synthetic */ zzfjy zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv zzc;
    final /* synthetic */ zzcmq zzd;

    public zzcmp(zzcmq zzcmqVar, zzfjy zzfjyVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = zzfjyVar;
        this.zzb = str;
        this.zzc = zzvVar;
        Objects.requireNonNull(zzcmqVar);
        this.zzd = zzcmqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(final Throwable th) {
        zzgdy zzgdyVar = this.zzd.zzg;
        final zzfjy zzfjyVar = this.zza;
        final String str = this.zzb;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmn
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkL)).booleanValue();
                zzcmp zzcmpVar = this.zza;
                Throwable th2 = th;
                if (zBooleanValue) {
                    zzcmq zzcmqVar = zzcmpVar.zzd;
                    zzbup zzbupVarZzc = zzbun.zzc(zzcmqVar.zzc);
                    zzcmqVar.zzb = zzbupVarZzc;
                    zzbupVarZzc.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzcmq zzcmqVar2 = zzcmpVar.zzd;
                    zzbup zzbupVarZza = zzbun.zza(zzcmqVar2.zzc);
                    zzcmqVar2.zza = zzbupVarZza;
                    zzbupVarZza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                com.google.android.gms.ads.internal.util.client.zzv zzvVar2 = zzvVar;
                zzfjyVar.zzd(str, zzvVar2, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final zzfjy zzfjyVar = this.zza;
        final String str = (String) obj;
        zzgdy zzgdyVar = this.zzd.zzg;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgdyVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmo
            @Override // java.lang.Runnable
            public final void run() {
                zzfjyVar.zzd(str, zzvVar, null, null);
            }
        });
    }
}
