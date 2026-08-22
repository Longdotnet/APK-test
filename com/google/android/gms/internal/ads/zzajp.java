package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzajp {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final zzz zzg;
    public final int zzh;
    public final long[] zzi;
    public final long[] zzj;
    public final int zzk;
    private final zzajq[] zzl;

    public zzajp(int i, int i2, long j, long j2, long j3, long j4, zzz zzzVar, int i3, zzajq[] zzajqVarArr, int i4, long[] jArr, long[] jArr2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = zzzVar;
        this.zzh = i3;
        this.zzl = zzajqVarArr;
        this.zzk = i4;
        this.zzi = jArr;
        this.zzj = jArr2;
    }

    public final zzajp zza(zzz zzzVar) {
        return new zzajp(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, zzzVar, this.zzh, this.zzl, this.zzk, this.zzi, this.zzj);
    }

    public final zzajq zzb(int i) {
        return this.zzl[i];
    }
}
