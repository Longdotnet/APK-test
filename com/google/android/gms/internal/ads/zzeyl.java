package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeyl implements zzgdj {
    final /* synthetic */ zzfhu zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ zzcpx zzc;
    final /* synthetic */ zzeym zzd;

    public zzeyl(zzeym zzeymVar, zzfhu zzfhuVar, zzfhj zzfhjVar, zzcpx zzcpxVar) {
        this.zza = zzfhuVar;
        this.zzb = zzfhjVar;
        this.zzc = zzcpxVar;
        Objects.requireNonNull(zzeymVar);
        this.zzd = zzeymVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhu zzfhuVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzga)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzeym zzeymVar = this.zzd;
        synchronized (zzeymVar) {
            try {
                zzcpx zzcpxVar = this.zzc;
                com.google.android.gms.ads.internal.client.zze zzeVarZza = zzcpxVar.zzc().zza(th);
                zzeymVar.zzn = zzeVarZza;
                zzcpxVar.zze().zzdD(zzeVarZza);
                zzfdt.zzb(zzeVarZza.zza, th, "BannerAdLoader.onFailure");
                if (zzeymVar.zzm) {
                    zzeymVar.zzt();
                    zzeymVar.zzh.zzd(zzeymVar.zzj.zzc());
                }
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zza) == null) {
                    zzfhx zzfhxVar = zzeymVar.zzi;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zza(zzeVarZza);
                    zzfhjVar.zzh(th);
                    zzfhjVar.zzg(false);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzc(zzeVarZza);
                    zzfhj zzfhjVar2 = this.zzb;
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
        zzeym zzeymVar = this.zzd;
        zzcos zzcosVar = (zzcos) obj;
        synchronized (zzeymVar) {
            try {
                if (zzeymVar.zzm) {
                    zzeymVar.zzq();
                }
                if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzfhuVar = this.zza) == null) {
                    zzfhx zzfhxVar = zzeymVar.zzi;
                    zzfhj zzfhjVar = this.zzb;
                    zzfhjVar.zzb(zzcosVar.zzq().zzb);
                    zzfhjVar.zzd(zzcosVar.zzm().zzg());
                    zzfhjVar.zzg(true);
                    zzfhxVar.zzc(zzfhjVar.zzm());
                } else {
                    zzfhuVar.zzg(zzcosVar.zzq().zzb);
                    zzfhuVar.zze(zzcosVar.zzm().zzg());
                    zzfhj zzfhjVar2 = this.zzb;
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
