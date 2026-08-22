package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzexf implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzexg zzd;
    final /* synthetic */ zzexi zze;

    public zzexf(zzexi zzexiVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzexg zzexgVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzexgVar;
        Objects.requireNonNull(zzexiVar);
        this.zze = zzexiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhu zzfhuVar;
        zzbcv zzbcvVar = zzbde.zzga;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzexi zzexiVar = this.zze;
        zzcoc zzcocVar = (zzcoc) zzexiVar.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcocVar == null ? zzfdx.zzb(th, null) : zzcocVar.zzb().zza(th);
        synchronized (zzexiVar) {
            try {
                zzexiVar.zzj = null;
                if (zzcocVar != null) {
                    zzcocVar.zzc().zzdD(zzeVarZzb);
                    if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziB)).booleanValue()) {
                        zzexiVar.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexe
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zze.zzd.zzdD(zzeVarZzb);
                            }
                        });
                    }
                } else {
                    zzexiVar.zzd.zzdD(zzeVarZzb);
                    ((zzcoc) zzexiVar.zzm(this.zzd).zzh()).zzb().zzc().zzh();
                }
                zzfdt.zzb(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzexiVar.zzh;
                    zzfhj zzfhjVar = this.zzc;
                    zzfhjVar.zza(zzeVarZzb);
                    zzfhjVar.zzh(th);
                    zzfhjVar.zzg(false);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzc(zzeVarZzb);
                    zzfhj zzfhjVar2 = this.zzc;
                    zzfhjVar2.zzh(th);
                    zzfhjVar2.zzg(false);
                    zzfhuVar.zza(zzfhjVar2);
                    zzfhuVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzfhu zzfhuVar;
        zzcra zzcraVar = (zzcra) obj;
        zzexi zzexiVar = this.zze;
        synchronized (zzexiVar) {
            try {
                zzexiVar.zzj = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziB)).booleanValue()) {
                    zzcraVar.zzo().zzb(zzexiVar.zzd);
                }
                this.zza.zzb(zzcraVar);
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzexiVar.zzh;
                    zzfhj zzfhjVar = this.zzc;
                    zzfhjVar.zzb(zzcraVar.zzq().zzb);
                    zzfhjVar.zzd(zzcraVar.zzm().zzg());
                    zzfhjVar.zzg(true);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzg(zzcraVar.zzq().zzb);
                    zzfhuVar.zze(zzcraVar.zzm().zzg());
                    zzfhj zzfhjVar2 = this.zzc;
                    zzfhjVar2.zzg(true);
                    zzfhuVar.zza(zzfhjVar2);
                    zzfhuVar.zzh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
