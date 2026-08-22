package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzelf implements zzeln {
    final /* synthetic */ zzelg zza;

    public zzelf(zzelg zzelgVar) {
        Objects.requireNonNull(zzelgVar);
        this.zza = zzelgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final void zza() {
        zzelg zzelgVar = this.zza;
        synchronized (zzelgVar) {
            zzelgVar.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeln
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzelg zzelgVar = this.zza;
        zzdfb zzdfbVar = (zzdfb) obj;
        synchronized (zzelgVar) {
            zzelgVar.zzj = zzdfbVar;
            zzelgVar.zzj.zzk();
        }
    }
}
