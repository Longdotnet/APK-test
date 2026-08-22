package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzffb implements zzgdj {
    final /* synthetic */ zzffe zza;
    final /* synthetic */ zzfff zzb;

    public zzffb(zzfff zzfffVar, zzffe zzffeVar) {
        this.zza = zzffeVar;
        Objects.requireNonNull(zzfffVar);
        this.zzb = zzfffVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfff zzfffVar = this.zzb;
        synchronized (zzfffVar) {
            zzfffVar.zze = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfff zzfffVar = this.zzb;
        synchronized (zzfffVar) {
            try {
                zzfffVar.zze = null;
                zzfffVar.zzd.addFirst(this.zza);
                if (zzfffVar.zzf == 1) {
                    zzfffVar.zzh();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
