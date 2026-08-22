package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfac implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzdgf zzd;
    final /* synthetic */ zzfad zze;

    public zzfac(zzfad zzfadVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzdgf zzdgfVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzdgfVar;
        Objects.requireNonNull(zzfadVar);
        this.zze = zzfadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhu zzfhuVar;
        zzbcv zzbcvVar = zzbde.zzga;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdgf zzdgfVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = zzdgfVar.zza().zza(th);
        zzfad zzfadVar = this.zze;
        synchronized (zzfadVar) {
            try {
                zzfadVar.zzi = null;
                zzdgfVar.zzb().zzdD(zzeVarZza);
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziC)).booleanValue()) {
                    zzfadVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezy
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzdD(zzeVarZza);
                        }
                    });
                    zzfadVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzezz
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zze.zzdD(zzeVarZza);
                        }
                    });
                }
                zzfdt.zzb(zzeVarZza.zza, th, "InterstitialAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzfadVar.zzg;
                    zzfhj zzfhjVar = this.zzc;
                    zzfhjVar.zza(zzeVarZza);
                    zzfhjVar.zzh(th);
                    zzfhjVar.zzg(false);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzc(zzeVarZza);
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
        zzdfb zzdfbVar = (zzdfb) obj;
        zzfad zzfadVar = this.zze;
        synchronized (zzfadVar) {
            try {
                zzfadVar.zzi = null;
                zzbcv zzbcvVar = zzbde.zziC;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzdaj zzdajVarZzo = zzdfbVar.zzo();
                    zzdajVarZzo.zza(zzfadVar.zzd);
                    zzdajVarZzo.zzd(zzfadVar.zze);
                }
                this.zza.zzb(zzdfbVar);
                if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                    zzfadVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaa
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzu();
                        }
                    });
                    zzfadVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfab
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zze.zzu();
                        }
                    });
                }
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzfadVar.zzg;
                    zzfhj zzfhjVar = this.zzc;
                    zzfhjVar.zzb(zzdfbVar.zzq().zzb);
                    zzfhjVar.zzd(zzdfbVar.zzm().zzg());
                    zzfhjVar.zzg(true);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzg(zzdfbVar.zzq().zzb);
                    zzfhuVar.zze(zzdfbVar.zzm().zzg());
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
