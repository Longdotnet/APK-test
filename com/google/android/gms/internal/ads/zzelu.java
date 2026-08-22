package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzelu implements zzgdj {
    final /* synthetic */ zzeln zza;
    final /* synthetic */ zzfhu zzb;
    final /* synthetic */ zzfhj zzc;
    final /* synthetic */ zzdhb zzd;
    final /* synthetic */ zzelv zze;

    public zzelu(zzelv zzelvVar, zzeln zzelnVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzdhb zzdhbVar) {
        this.zza = zzelnVar;
        this.zzb = zzfhuVar;
        this.zzc = zzfhjVar;
        this.zzd = zzdhbVar;
        Objects.requireNonNull(zzelvVar);
        this.zze = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhu zzfhuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdhb zzdhbVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = zzdhbVar.zza().zza(th);
        zzdhbVar.zzb().zzdD(zzeVarZza);
        zzelv zzelvVar = this.zze;
        zzelvVar.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzdD(zzeVarZza);
            }
        });
        zzfdt.zzb(zzeVarZza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
            zzfhx zzfhxVar = zzelvVar.zze;
            zzfhj zzfhjVar = this.zzc;
            zzfhjVar.zza(zzeVarZza);
            zzfhjVar.zzh(th);
            zzfhjVar.zzg(false);
            zzfhxVar.zzc(zzfhjVar.zzm());
            return;
        }
        zzfhuVar.zzc(zzeVarZza);
        zzfhj zzfhjVar2 = this.zzc;
        zzfhjVar2.zzh(th);
        zzfhjVar2.zzg(false);
        zzfhuVar.zza(zzfhjVar2);
        zzfhuVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfhu zzfhuVar;
        zzelv zzelvVar = this.zze;
        zzcra zzcraVar = (zzcra) obj;
        synchronized (zzelvVar) {
            try {
                zzcraVar.zzo().zza(zzelvVar.zzd.zzd());
                this.zza.zzb(zzcraVar);
                zzelvVar.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzels
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzb().zzu();
                    }
                });
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zzb) == null) {
                    zzfhx zzfhxVar = zzelvVar.zze;
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
