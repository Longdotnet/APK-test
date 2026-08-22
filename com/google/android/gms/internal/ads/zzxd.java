package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzxd extends zzbl {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;
    private final zzap zzf;
    private final zzaj zzg;

    static {
        zzad zzadVar = new zzad();
        zzadVar.zza("SinglePeriodTimeline");
        zzadVar.zzb(Uri.EMPTY);
        zzadVar.zzc();
    }

    public zzxd(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzap zzapVar, zzaj zzajVar) {
        this.zzc = j4;
        this.zzd = j5;
        this.zze = z;
        zzapVar.getClass();
        this.zzf = zzapVar;
        this.zzg = zzajVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int zza(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int zzb() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final zzbj zzd(int i, zzbj zzbjVar, boolean z) {
        zzdd.zza(i, 0, 1);
        zzbjVar.zzi(null, z ? zzb : null, 0, this.zzc, 0L, zzb.zza, false);
        return zzbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final zzbk zze(int i, zzbk zzbkVar, long j) {
        zzdd.zza(i, 0, 1);
        Object obj = zzbk.zza;
        zzap zzapVar = this.zzf;
        long j2 = this.zzd;
        zzbkVar.zza(obj, zzapVar, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zze, false, this.zzg, 0L, j2, 0, 0, 0L);
        return zzbkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final Object zzf(int i) {
        zzdd.zza(i, 0, 1);
        return zzb;
    }
}
