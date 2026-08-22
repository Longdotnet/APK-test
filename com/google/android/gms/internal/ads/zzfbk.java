package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class zzfbk implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzfbl zzd;
    final /* synthetic */ zzfbn zze;

    public zzfbk(zzfbn zzfbnVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzfbl zzfblVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzfblVar;
        Objects.requireNonNull(zzfbnVar);
        this.zze = zzfbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhu zzfhuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzfbn zzfbnVar = this.zze;
        zzdos zzdosVar = (zzdos) zzfbnVar.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdosVar == null ? zzfdx.zzb(th, null) : zzdosVar.zzb().zza(th);
        synchronized (zzfbnVar) {
            try {
                if (zzdosVar != null) {
                    zzdosVar.zza().zzdD(zzeVarZzb);
                    zzfbnVar.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbi
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzdD(zzeVarZzb);
                        }
                    });
                } else {
                    zzfbnVar.zzd.zzdD(zzeVarZzb);
                    zzfbnVar.zzk(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfdt.zzb(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzfbnVar.zzg;
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
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfhu zzfhuVar;
        zzfbn zzfbnVar = this.zze;
        zzdon zzdonVar = (zzdon) obj;
        synchronized (zzfbnVar) {
            try {
                zzdonVar.zzo().zzd(zzfbnVar.zzd);
                this.zza.zzb(zzdonVar);
                Executor executor = zzfbnVar.zzb;
                final zzfbd zzfbdVar = zzfbnVar.zzd;
                Objects.requireNonNull(zzfbdVar);
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbj
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzfbdVar.zzu();
                    }
                });
                zzfbnVar.zzd.onAdMetadataChanged();
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzfbnVar.zzg;
                    zzfhj zzfhjVar = this.zzc;
                    zzfhjVar.zzb(zzdonVar.zzq().zzb);
                    zzfhjVar.zzd(zzdonVar.zzm().zzg());
                    zzfhjVar.zzg(true);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzg(zzdonVar.zzq().zzb);
                    zzfhuVar.zze(zzdonVar.zzm().zzg());
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
