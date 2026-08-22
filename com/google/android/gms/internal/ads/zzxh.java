package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzxh implements zzvf, zzve {
    private final zzvf zza;
    private final long zzb;
    private zzve zzc;

    public zzxh(zzvf zzvfVar, long j) {
        this.zza = zzvfVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmiVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        long jZzd = this.zza.zzd();
        if (jZzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        zzwz[] zzwzVarArr2 = new zzwz[zzwzVarArr.length];
        int i = 0;
        while (true) {
            zzwz zzwzVarZzc = null;
            if (i >= zzwzVarArr.length) {
                break;
            }
            zzxg zzxgVar = (zzxg) zzwzVarArr[i];
            if (zzxgVar != null) {
                zzwzVarZzc = zzxgVar.zzc();
            }
            zzwzVarArr2[i] = zzwzVarZzc;
            i++;
        }
        zzvf zzvfVar = this.zza;
        long j2 = this.zzb;
        long jZzf = zzvfVar.zzf(zzywVarArr, zArr, zzwzVarArr2, zArr2, j - j2);
        for (int i2 = 0; i2 < zzwzVarArr.length; i2++) {
            zzwz zzwzVar = zzwzVarArr2[i2];
            if (zzwzVar == null) {
                zzwzVarArr[i2] = null;
            } else {
                zzwz zzwzVar2 = zzwzVarArr[i2];
                if (zzwzVar2 == null || ((zzxg) zzwzVar2).zzc() != zzwzVar) {
                    zzwzVarArr[i2] = new zzxg(zzwzVar, j2);
                }
            }
        }
        return jZzf + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        this.zza.zzh(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzi() {
        this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        zzve zzveVar = this.zzc;
        zzveVar.getClass();
        zzveVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzk(zzve zzveVar, long j) {
        this.zzc = zzveVar;
        this.zza.zzk(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        zzve zzveVar = this.zzc;
        zzveVar.getClass();
        zzveVar.zzl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzvf zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        long j = zzlaVar.zza;
        long j2 = this.zzb;
        zzky zzkyVarZza = zzlaVar.zza();
        zzkyVarZza.zze(j - j2);
        return this.zza.zzo(zzkyVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zza.zzp();
    }
}
