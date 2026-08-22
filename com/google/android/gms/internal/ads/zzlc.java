package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzlc {
    public final zzvf zza;
    public final Object zzb;
    public final zzwz[] zzc;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzld zzg;
    public boolean zzh;
    private final boolean[] zzi;
    private final zzmd[] zzj;
    private final zzzd zzk;
    private final zzlr zzl;
    private zzlc zzm;
    private zzxk zzn;
    private zzze zzo;
    private long zzp;

    public zzlc(zzmd[] zzmdVarArr, long j, zzzd zzzdVar, zzzm zzzmVar, zzlr zzlrVar, zzld zzldVar, zzze zzzeVar, long j2) {
        this.zzj = zzmdVarArr;
        this.zzp = j;
        this.zzk = zzzdVar;
        this.zzl = zzlrVar;
        zzvh zzvhVar = zzldVar.zza;
        this.zzb = zzvhVar.zza;
        this.zzg = zzldVar;
        this.zzn = zzxk.zza;
        this.zzo = zzzeVar;
        this.zzc = new zzwz[2];
        this.zzi = new boolean[2];
        long j3 = zzldVar.zzb;
        long j4 = zzldVar.zzd;
        zzvf zzvfVarZzp = zzlrVar.zzp(zzvhVar, zzzmVar, j3);
        this.zza = j4 != -9223372036854775807L ? new zzul(zzvfVarZzp, true, 0L, j4) : zzvfVarZzp;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzze zzzeVar = this.zzo;
            if (i >= zzzeVar.zza) {
                return;
            }
            zzzeVar.zzb(i);
            zzyw zzywVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzze zzzeVar = this.zzo;
            if (i >= zzzeVar.zza) {
                return;
            }
            zzzeVar.zzb(i);
            zzyw zzywVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza(zzze zzzeVar, long j, boolean z) {
        return zzb(zzzeVar, j, false, new boolean[2]);
    }

    public final long zzb(zzze zzzeVar, long j, boolean z, boolean[] zArr) {
        zzmd[] zzmdVarArr;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzzeVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z || !zzzeVar.zza(this.zzo, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzmdVarArr = this.zzj;
            if (i2 >= 2) {
                break;
            }
            zzmdVarArr[i2].zzb();
            i2++;
        }
        zzu();
        this.zzo = zzzeVar;
        zzv();
        zzvf zzvfVar = this.zza;
        zzyw[] zzywVarArr = zzzeVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzwz[] zzwzVarArr = this.zzc;
        long jZzf = zzvfVar.zzf(zzywVarArr, zArr3, zzwzVarArr, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            zzmdVarArr[i3].zzb();
        }
        this.zzf = false;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzwzVarArr[i4] != null) {
                zzdd.zzf(zzzeVar.zzb(i4));
                zzmdVarArr[i4].zzb();
                this.zzf = true;
            } else {
                zzdd.zzf(zzywVarArr[i4] == null);
            }
        }
        return jZzf;
    }

    public final long zzc() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzb = this.zzf ? this.zza.zzb() : Long.MIN_VALUE;
        return jZzb == Long.MIN_VALUE ? this.zzg.zze : jZzb;
    }

    public final long zzd() {
        if (this.zze) {
            return this.zza.zzc();
        }
        return 0L;
    }

    public final long zze() {
        return this.zzp;
    }

    public final long zzf() {
        return this.zzg.zzb + this.zzp;
    }

    public final zzlc zzg() {
        return this.zzm;
    }

    public final zzxk zzh() {
        return this.zzn;
    }

    public final zzze zzi() {
        return this.zzo;
    }

    public final zzze zzj(float f, zzbl zzblVar, boolean z) {
        zzxk zzxkVar = this.zzn;
        zzvh zzvhVar = this.zzg.zza;
        zzzd zzzdVar = this.zzk;
        zzmd[] zzmdVarArr = this.zzj;
        zzze zzzeVarZzo = zzzdVar.zzo(zzmdVarArr, zzxkVar, zzvhVar, zzblVar);
        for (int i = 0; i < zzzeVarZzo.zza; i++) {
            boolean z2 = true;
            if (zzzeVarZzo.zzb(i)) {
                if (zzzeVarZzo.zzc[i] == null) {
                    zzmdVarArr[i].zzb();
                    z2 = false;
                }
                zzdd.zzf(z2);
            } else {
                zzdd.zzf(zzzeVarZzo.zzc[i] == null);
            }
        }
        for (zzyw zzywVar : zzzeVarZzo.zzc) {
        }
        return zzzeVarZzo;
    }

    public final void zzk(zzla zzlaVar) {
        zzdd.zzf(zzw());
        this.zza.zzo(zzlaVar);
    }

    public final void zzl(float f, zzbl zzblVar, boolean z) {
        this.zze = true;
        this.zzn = this.zza.zzg();
        zzze zzzeVarZzj = zzj(f, zzblVar, z);
        zzld zzldVar = this.zzg;
        long jMax = zzldVar.zzb;
        long j = zzldVar.zze;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZza = zza(zzzeVarZzj, jMax, false);
        long j2 = this.zzp;
        zzld zzldVar2 = this.zzg;
        this.zzp = (zzldVar2.zzb - jZza) + j2;
        this.zzg = zzldVar2.zzb(jZza);
    }

    public final void zzm(zzve zzveVar, long j) {
        this.zzd = true;
        this.zza.zzk(zzveVar, j);
    }

    public final void zzn(long j) {
        zzdd.zzf(zzw());
        if (this.zze) {
            this.zza.zzm(j - this.zzp);
        }
    }

    public final void zzo() {
        zzu();
        zzvf zzvfVar = this.zza;
        try {
            boolean z = zzvfVar instanceof zzul;
            zzlr zzlrVar = this.zzl;
            if (z) {
                zzlrVar.zzi(((zzul) zzvfVar).zza);
            } else {
                zzlrVar.zzi(zzvfVar);
            }
        } catch (RuntimeException e) {
            zzea.zzd("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzp(zzlc zzlcVar) {
        if (zzlcVar == this.zzm) {
            return;
        }
        zzu();
        this.zzm = zzlcVar;
        zzv();
    }

    public final void zzq(long j) {
        this.zzp = j;
    }

    public final void zzr() {
        zzvf zzvfVar = this.zza;
        if (zzvfVar instanceof zzul) {
            long j = this.zzg.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzul) zzvfVar).zzn(0L, j);
        }
    }

    public final boolean zzs() {
        if (this.zze) {
            return !this.zzf || this.zza.zzb() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zzt() {
        if (this.zze) {
            return zzs() || zzc() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }
}
