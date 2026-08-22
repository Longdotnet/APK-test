package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzxi extends zzuv {
    private final zzap zzc;

    public zzxi(zzbl zzblVar, zzap zzapVar) {
        super(zzblVar);
        this.zzc = zzapVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuv, com.google.android.gms.internal.ads.zzbl
    public final zzbk zze(int i, zzbk zzbkVar, long j) {
        this.zzb.zze(i, zzbkVar, j);
        zzap zzapVar = this.zzc;
        zzbkVar.zzd = zzapVar;
        zzak zzakVar = zzapVar.zzb;
        zzbkVar.zzc = null;
        return zzbkVar;
    }
}
