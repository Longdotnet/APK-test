package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzekd implements zzeln {
    final /* synthetic */ zzeke zza;

    public zzekd(zzeke zzekeVar) {
        Objects.requireNonNull(zzekeVar);
        this.zza = zzekeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzeke zzekeVar = this.zza;
        synchronized (zzekeVar) {
            zzekeVar.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeke zzekeVar = this.zza;
        zzcos zzcosVar = (zzcos) obj;
        synchronized (zzekeVar) {
            try {
                if (zzekeVar.zzi != null) {
                    if (zzcosVar.zzl() != null && zzekeVar.zzi.zzl() != null) {
                        zzcosVar.zzl().zzb(zzekeVar.zzi.zzl().zza());
                    }
                    zzekeVar.zzi.zzb();
                }
                zzekeVar.zzi = zzcosVar;
                zzekeVar.zzi.zzk();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
