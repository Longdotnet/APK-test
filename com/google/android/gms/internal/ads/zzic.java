package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzic implements zzma, zzmd {
    private final int zzb;
    private zzme zzd;
    private int zze;
    private zzph zzf;
    private zzdj zzg;
    private int zzh;
    private zzwz zzi;
    private zzz[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzvh zzq;
    private zzmc zzr;
    private final Object zza = new Object();
    private final zzkv zzc = new zzkv();
    private long zzm = Long.MIN_VALUE;
    private zzbl zzp = zzbl.zza;

    public zzic(int i) {
        this.zzb = i;
    }

    private final void zzaa(long j, boolean z) {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzA(j, z);
    }

    public void zzA(long j, boolean z) {
        throw null;
    }

    public void zzB() {
    }

    public final void zzC() {
        zzmc zzmcVar;
        synchronized (this.zza) {
            zzmcVar = this.zzr;
        }
        if (zzmcVar != null) {
            zzmcVar.zza(this);
        }
    }

    public void zzD() {
    }

    public void zzE() {
    }

    public void zzF() {
    }

    public void zzG(zzz[] zzzVarArr, long j, long j2, zzvh zzvhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzH() {
        zzdd.zzf(this.zzh == 0);
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzI(zzz[] zzzVarArr, zzwz zzwzVar, long j, long j2, zzvh zzvhVar) {
        zzdd.zzf(!this.zzn);
        this.zzi = zzwzVar;
        this.zzq = zzvhVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzzVarArr;
        this.zzk = j2;
        zzG(zzzVarArr, j, j2, zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzJ() {
        zzdd.zzf(this.zzh == 0);
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzK(long j) {
        zzaa(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzL() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final void zzM(zzmc zzmcVar) {
        synchronized (this.zza) {
            this.zzr = zzmcVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ void zzN(float f, float f2) {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzO(zzbl zzblVar) {
        if (Objects.equals(this.zzp, zzblVar)) {
            return;
        }
        this.zzp = zzblVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzP() {
        zzdd.zzf(this.zzh == 1);
        this.zzh = 2;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzQ() {
        zzdd.zzf(this.zzh == 2);
        this.zzh = 1;
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final boolean zzR() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final boolean zzS() {
        return this.zzn;
    }

    public final boolean zzT() {
        if (zzR()) {
            return this.zzn;
        }
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        return zzwzVar.zze();
    }

    public final zzz[] zzU() {
        zzz[] zzzVarArr = this.zzj;
        zzzVarArr.getClass();
        return zzzVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzma, com.google.android.gms.internal.ads.zzmd
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final int zzcU() {
        return this.zzh;
    }

    public final int zzcV(zzkv zzkvVar, zzhs zzhsVar, int i) {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        int iZza = zzwzVar.zza(zzkvVar, zzhsVar, i);
        if (iZza == -4) {
            if (zzhsVar.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhsVar.zze + this.zzk;
            zzhsVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (iZza == -5) {
            zzz zzzVar = zzkvVar.zza;
            zzzVar.getClass();
            long j2 = zzzVar.zzt;
            if (j2 != Long.MAX_VALUE) {
                zzx zzxVarZzb = zzzVar.zzb();
                zzxVarZzb.zzal(j2 + this.zzk);
                zzkvVar.zza = zzxVarZzb.zzan();
                return -5;
            }
        }
        return iZza;
    }

    public final long zzcW() {
        return this.zzl;
    }

    public final zzdj zzcX() {
        zzdj zzdjVar = this.zzg;
        zzdjVar.getClass();
        return zzdjVar;
    }

    public final int zzd(long j) {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        return zzwzVar.zzb(j - this.zzk);
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public int zze() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ long zzf(long j, long j2) {
        return 10000L;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final long zzh() {
        return this.zzm;
    }

    public final zzbl zzi() {
        return this.zzp;
    }

    public final zzin zzk(Throwable th, zzz zzzVar, boolean z, int i) {
        int iZzZ = 4;
        if (zzzVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzZ = zzZ(zzzVar) & 7;
            } catch (zzin unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzin.zzb(th, zzV(), this.zze, zzzVar, iZzZ, this.zzq, z, i);
    }

    public final zzkv zzl() {
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        return zzkvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public zzlb zzm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final zzmd zzn() {
        return this;
    }

    public final zzme zzo() {
        zzme zzmeVar = this.zzd;
        zzmeVar.getClass();
        return zzmeVar;
    }

    public final zzph zzp() {
        zzph zzphVar = this.zzf;
        zzphVar.getClass();
        return zzphVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final zzwz zzq() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzmd
    public final void zzr() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzs() {
        zzdd.zzf(this.zzh == 1);
        zzkv zzkvVar = this.zzc;
        zzkvVar.zzb = null;
        zzkvVar.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzy();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzt(zzme zzmeVar, zzz[] zzzVarArr, zzwz zzwzVar, long j, boolean z, boolean z2, long j2, long j3, zzvh zzvhVar) {
        zzdd.zzf(this.zzh == 0);
        this.zzd = zzmeVar;
        this.zzq = zzvhVar;
        this.zzh = 1;
        zzz(z, z2);
        zzI(zzzVarArr, zzwzVar, j2, j3, zzvhVar);
        zzaa(j2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public /* synthetic */ void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzlv
    public void zzv(int i, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzw(int i, zzph zzphVar, zzdj zzdjVar) {
        this.zze = i;
        this.zzf = zzphVar;
        this.zzg = zzdjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzma
    public final void zzx() {
        zzwz zzwzVar = this.zzi;
        zzwzVar.getClass();
        zzwzVar.zzd();
    }

    public void zzy() {
        throw null;
    }

    public void zzz(boolean z, boolean z2) {
    }
}
