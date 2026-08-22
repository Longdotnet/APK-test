package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzwm extends zzuv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzwm(zzwq zzwqVar, zzbl zzblVar) {
        super(zzblVar);
        Objects.requireNonNull(zzwqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzuv, com.google.android.gms.internal.ads.zzbl
    public final zzbj zzd(int i, zzbj zzbjVar, boolean z) {
        this.zzb.zzd(i, zzbjVar, z);
        zzbjVar.zzf = true;
        return zzbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuv, com.google.android.gms.internal.ads.zzbl
    public final zzbk zze(int i, zzbk zzbkVar, long j) {
        this.zzb.zze(i, zzbkVar, j);
        zzbkVar.zzk = true;
        return zzbkVar;
    }
}
