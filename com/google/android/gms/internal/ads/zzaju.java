package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaju implements zzaeu {
    final /* synthetic */ zzajw zza;

    public /* synthetic */ zzaju(zzajw zzajwVar, zzajv zzajvVar) {
        Objects.requireNonNull(zzajwVar);
        this.zza = zzajwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        zzajw zzajwVar = this.zza;
        return zzajwVar.zzd.zzf(zzajwVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        zzajw zzajwVar = this.zza;
        long jLongValue = BigInteger.valueOf(zzajwVar.zzd.zzg(j)).multiply(BigInteger.valueOf(zzajwVar.zzc - zzajwVar.zzb)).divide(BigInteger.valueOf(zzajwVar.zzf)).longValue() + zzajwVar.zzb;
        long j2 = zzajwVar.zzb;
        long j3 = zzajwVar.zzc - 1;
        String str = zzex.zza;
        zzaev zzaevVar = new zzaev(j, Math.max(j2, Math.min(jLongValue - 30000, j3)));
        return new zzaes(zzaevVar, zzaevVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
