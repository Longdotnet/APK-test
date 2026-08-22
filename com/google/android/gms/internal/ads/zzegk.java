package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzegk implements zzgdj {
    final /* synthetic */ zzfca zza;
    final /* synthetic */ zzegl zzb;

    public zzegk(zzegl zzeglVar, zzfca zzfcaVar) {
        this.zza = zzfcaVar;
        Objects.requireNonNull(zzeglVar);
        this.zzb = zzeglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzegl zzeglVar = this.zzb;
        synchronized (zzeglVar) {
            try {
                zzegm zzegmVar = zzeglVar.zzh;
                zzfca zzfcaVar = this.zza;
                zzegmVar.zzb(th, zzfcaVar);
                zzfca zzfcaVarZza = zzeglVar.zzh.zza();
                if (zzfcaVar.zzav) {
                    while (zzfcaVarZza != null) {
                        zzeglVar.zze(zzfcaVarZza);
                        zzfcaVarZza = zzeglVar.zzh.zza();
                    }
                } else if (zzfcaVarZza != null) {
                    zzeglVar.zze(zzfcaVarZza);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzegl zzeglVar = this.zzb;
        zzehc zzehcVar = (zzehc) obj;
        synchronized (zzeglVar) {
            try {
                zzeglVar.zzh.zzc(zzehcVar, this.zza);
                zzfca zzfcaVarZza = zzeglVar.zzh.zza();
                if (zzfcaVarZza != null) {
                    zzeglVar.zze(zzfcaVarZza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
