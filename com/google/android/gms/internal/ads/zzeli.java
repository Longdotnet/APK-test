package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzeli implements zzeln {
    final /* synthetic */ zzelj zza;

    public zzeli(zzelj zzeljVar) {
        Objects.requireNonNull(zzeljVar);
        this.zza = zzeljVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcra zzcraVar = (zzcra) obj;
        zzelj zzeljVar = this.zza;
        synchronized (zzeljVar) {
            zzeljVar.zzc = zzcraVar.zzm();
            zzcraVar.zzk();
        }
    }
}
