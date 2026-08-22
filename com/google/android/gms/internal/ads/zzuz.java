package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzuz implements zzvf, zzve {
    public final zzvh zza;
    private final long zzb;
    private zzvj zzc;
    private zzvf zzd;
    private zzve zze;
    private long zzf = -9223372036854775807L;
    private final zzzm zzg;

    public zzuz(zzvh zzvhVar, zzzm zzzmVar, long j) {
        this.zza = zzvhVar;
        this.zzg = zzzmVar;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != -9223372036854775807L ? j2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zza(j, zzmiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == -9223372036854775807L || j != this.zzb) ? j : j2;
        this.zzf = -9223372036854775807L;
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zzf(zzywVarArr, zArr, zzwzVarArr, zArr2, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        return zzvfVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        zzvfVar.zzh(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzi() {
        zzvf zzvfVar = this.zzd;
        if (zzvfVar != null) {
            zzvfVar.zzi();
            return;
        }
        zzvj zzvjVar = this.zzc;
        if (zzvjVar != null) {
            zzvjVar.zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        zzve zzveVar = this.zze;
        String str = zzex.zza;
        zzveVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzk(zzve zzveVar, long j) {
        this.zze = zzveVar;
        zzvf zzvfVar = this.zzd;
        if (zzvfVar != null) {
            zzvfVar.zzk(this, zzv(this.zzb));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        zzve zzveVar = this.zze;
        String str = zzex.zza;
        zzveVar.zzl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        zzvf zzvfVar = this.zzd;
        String str = zzex.zza;
        zzvfVar.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        zzvf zzvfVar = this.zzd;
        return zzvfVar != null && zzvfVar.zzo(zzlaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        zzvf zzvfVar = this.zzd;
        return zzvfVar != null && zzvfVar.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzvh zzvhVar) {
        long jZzv = zzv(this.zzb);
        zzvj zzvjVar = this.zzc;
        zzvjVar.getClass();
        zzvf zzvfVarZzI = zzvjVar.zzI(zzvhVar, this.zzg, jZzv);
        this.zzd = zzvfVarZzI;
        if (this.zze != null) {
            zzvfVarZzI.zzk(this, jZzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzt() {
        zzvf zzvfVar = this.zzd;
        if (zzvfVar != null) {
            zzvj zzvjVar = this.zzc;
            zzvjVar.getClass();
            zzvjVar.zzG(zzvfVar);
        }
    }

    public final void zzu(zzvj zzvjVar) {
        zzdd.zzf(this.zzc == null);
        this.zzc = zzvjVar;
    }
}
