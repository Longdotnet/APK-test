package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzmf {
    private final zzma zza;
    private final int zzb;
    private final zzma zzc;
    private int zzd = 0;
    private boolean zze = false;
    private boolean zzf = false;

    public zzmf(zzma zzmaVar, zzma zzmaVar2, int i) {
        this.zza = zzmaVar;
        this.zzb = i;
        this.zzc = zzmaVar2;
    }

    private final int zzM(zzma zzmaVar, zzlc zzlcVar, zzze zzzeVar, zzil zzilVar) {
        if (zzmaVar != null && zzU(zzmaVar)) {
            zzma zzmaVar2 = this.zza;
            boolean z = zzmaVar != zzmaVar2;
            if ((zzmaVar != zzmaVar2 || !zzT()) && (zzmaVar != this.zzc || !zzV())) {
                zzwz zzwzVarZzq = zzmaVar.zzq();
                zzwz[] zzwzVarArr = zzlcVar.zzc;
                int i = this.zzb;
                zzwz zzwzVar = zzwzVarArr[i];
                boolean zZzb = zzzeVar.zzb(i);
                if (zZzb && zzwzVarZzq == zzwzVar) {
                    return 1;
                }
                if (!zzmaVar.zzS()) {
                    zzz[] zzzVarArrZzW = zzW(zzzeVar.zzc[i]);
                    zzwz zzwzVar2 = zzwzVarArr[i];
                    zzwzVar2.getClass();
                    zzmaVar.zzI(zzzVarArrZzW, zzwzVar2, zzlcVar.zzf(), zzlcVar.zze(), zzlcVar.zzg.zza);
                    return 3;
                }
                if (!zzmaVar.zzX()) {
                    return 0;
                }
                zzO(zzmaVar, zzilVar);
                if (!zZzb || zzI()) {
                    zzQ(!z);
                }
                return 1;
            }
        }
        return 1;
    }

    private final zzma zzN(zzlc zzlcVar) {
        if (zzlcVar != null) {
            int i = this.zzb;
            zzwz[] zzwzVarArr = zzlcVar.zzc;
            if (zzwzVarArr[i] != null) {
                zzma zzmaVar = this.zza;
                zzwz zzwzVarZzq = zzmaVar.zzq();
                zzwz zzwzVar = zzwzVarArr[i];
                if (zzwzVarZzq == zzwzVar) {
                    return zzmaVar;
                }
                zzma zzmaVar2 = this.zzc;
                if (zzmaVar2 != null && zzmaVar2.zzq() == zzwzVar) {
                    return zzmaVar2;
                }
            }
        }
        return null;
    }

    private final void zzO(zzma zzmaVar, zzil zzilVar) {
        boolean z = true;
        if (this.zza != zzmaVar && this.zzc != zzmaVar) {
            z = false;
        }
        zzdd.zzf(z);
        if (zzU(zzmaVar)) {
            zzilVar.zzd(zzmaVar);
            zzX(zzmaVar);
            zzmaVar.zzs();
        }
    }

    private final void zzP(zzma zzmaVar, zzwz zzwzVar, zzil zzilVar, long j, boolean z) {
        if (zzU(zzmaVar)) {
            if (zzwzVar != zzmaVar.zzq()) {
                zzO(zzmaVar, zzilVar);
            } else if (z) {
                zzmaVar.zzK(j);
            }
        }
    }

    private final void zzQ(boolean z) {
        if (z) {
            if (this.zze) {
                this.zza.zzJ();
                this.zze = false;
                return;
            }
            return;
        }
        if (this.zzf) {
            zzma zzmaVar = this.zzc;
            zzmaVar.getClass();
            zzmaVar.zzJ();
            this.zzf = false;
        }
    }

    private final void zzR(boolean z) {
        if (z) {
            zzma zzmaVar = this.zzc;
            zzmaVar.getClass();
            zzmaVar.zzv(17, this.zza);
        } else {
            zzma zzmaVar2 = this.zza;
            zzma zzmaVar3 = this.zzc;
            zzmaVar3.getClass();
            zzmaVar2.zzv(17, zzmaVar3);
        }
    }

    private final boolean zzS(zzlc zzlcVar, zzma zzmaVar) {
        if (zzmaVar == null) {
            return true;
        }
        zzwz[] zzwzVarArr = zzlcVar.zzc;
        int i = this.zzb;
        zzwz zzwzVar = zzwzVarArr[i];
        if (zzmaVar.zzq() != null) {
            if (zzmaVar.zzq() == zzwzVar) {
                if (zzwzVar != null && !zzmaVar.zzR()) {
                    zzlcVar.zzg();
                    boolean z = zzlcVar.zzg.zzg;
                }
            }
            zzlc zzlcVarZzg = zzlcVar.zzg();
            return zzlcVarZzg != null && zzlcVarZzg.zzc[i] == zzmaVar.zzq();
        }
        return true;
    }

    private final boolean zzT() {
        int i = this.zzd;
        return i == 2 || i == 4;
    }

    private static boolean zzU(zzma zzmaVar) {
        return zzmaVar.zzcU() != 0;
    }

    private final boolean zzV() {
        return this.zzd == 3;
    }

    private static zzz[] zzW(zzyw zzywVar) {
        int iZzh = zzywVar != null ? zzywVar.zzh() : 0;
        zzz[] zzzVarArr = new zzz[iZzh];
        for (int i = 0; i < iZzh; i++) {
            zzywVar.getClass();
            zzzVarArr[i] = zzywVar.zza(i);
        }
        return zzzVarArr;
    }

    private static final void zzX(zzma zzmaVar) {
        if (zzmaVar.zzcU() == 2) {
            zzmaVar.zzQ();
        }
    }

    private static final void zzY(zzma zzmaVar, long j) {
        zzmaVar.zzL();
        if (zzmaVar instanceof zzxo) {
            throw null;
        }
    }

    public final void zzA() {
        zzma zzmaVar = this.zza;
        if (zzmaVar.zzcU() == 1 && this.zzd != 4) {
            zzmaVar.zzP();
            return;
        }
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 == null || zzmaVar2.zzcU() != 1 || this.zzd == 3) {
            return;
        }
        zzmaVar2.zzP();
    }

    public final void zzB() {
        int i;
        zzdd.zzf(!zzI());
        if (zzU(this.zza)) {
            i = 3;
        } else {
            zzma zzmaVar = this.zzc;
            i = (zzmaVar == null || !zzU(zzmaVar)) ? 2 : 4;
        }
        this.zzd = i;
    }

    public final void zzC() {
        zzma zzmaVar = this.zza;
        if (zzU(zzmaVar)) {
            zzX(zzmaVar);
        }
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 == null || !zzU(zzmaVar2)) {
            return;
        }
        zzX(zzmaVar2);
    }

    public final boolean zzD(zzlc zzlcVar) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        return zzmaVarZzN == null || zzmaVarZzN.zzR() || zzmaVarZzN.zzY() || zzmaVarZzN.zzX();
    }

    public final boolean zzE(zzlc zzlcVar) {
        return zzS(zzlcVar, this.zza) && zzS(zzlcVar, this.zzc);
    }

    public final boolean zzF(zzlc zzlcVar) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        zzmaVarZzN.getClass();
        return zzmaVarZzN.zzR();
    }

    public final boolean zzG() {
        return this.zzc != null;
    }

    public final boolean zzH() {
        zzma zzmaVar = this.zza;
        boolean zZzX = zzU(zzmaVar) ? zzmaVar.zzX() : true;
        zzma zzmaVar2 = this.zzc;
        return (zzmaVar2 == null || !zzU(zzmaVar2)) ? zZzX : zZzX & zzmaVar2.zzX();
    }

    public final boolean zzI() {
        return zzT() || zzV();
    }

    public final boolean zzJ(zzlc zzlcVar) {
        return (zzT() && zzN(zzlcVar) == this.zza) || (zzV() && zzN(zzlcVar) == this.zzc);
    }

    public final boolean zzK(zzlc zzlcVar) {
        return zzN(zzlcVar) != null;
    }

    public final boolean zzL() {
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            return zzU(this.zza);
        }
        zzma zzmaVar = this.zzc;
        zzmaVar.getClass();
        return zzU(zzmaVar);
    }

    public final int zza() {
        zzma zzmaVar = this.zzc;
        boolean zZzU = zzU(this.zza);
        int i = 0;
        if (zzmaVar != null && zzU(zzmaVar)) {
            i = 1;
        }
        return (zZzU ? 1 : 0) + i;
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final int zzc(zzlc zzlcVar, zzze zzzeVar, zzil zzilVar) {
        int iZzM = zzM(this.zza, zzlcVar, zzzeVar, zzilVar);
        return iZzM == 1 ? zzM(this.zzc, zzlcVar, zzzeVar, zzilVar) : iZzM;
    }

    public final long zzd(long j, long j2) {
        zzma zzmaVar = this.zza;
        long jZzf = zzU(zzmaVar) ? zzmaVar.zzf(j, j2) : Long.MAX_VALUE;
        zzma zzmaVar2 = this.zzc;
        return (zzmaVar2 == null || !zzU(zzmaVar2)) ? jZzf : Math.min(jZzf, zzmaVar2.zzf(j, j2));
    }

    public final long zze(zzlc zzlcVar) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        Objects.requireNonNull(zzmaVarZzN);
        return zzmaVarZzN.zzh();
    }

    public final void zzf(zzil zzilVar) {
        zzO(this.zza, zzilVar);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            boolean z = zzU(zzmaVar) && this.zzd != 3;
            zzO(zzmaVar, zzilVar);
            zzQ(false);
            if (z) {
                zzR(true);
            }
        }
        this.zzd = 0;
    }

    public final void zzg(zzil zzilVar) {
        boolean z;
        zzma zzmaVar;
        if (zzI()) {
            int i = this.zzd;
            if (i == 4) {
                z = true;
            } else if (i == 2) {
                i = 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zzmaVar = this.zza;
            } else {
                zzmaVar = this.zzc;
                zzmaVar.getClass();
            }
            zzO(zzmaVar, zzilVar);
            zzQ(z);
            this.zzd = i == 4 ? 1 : 0;
        }
    }

    public final void zzh(zzme zzmeVar, zzyw zzywVar, zzwz zzwzVar, long j, boolean z, boolean z2, long j2, long j3, zzvh zzvhVar, zzil zzilVar) throws zzin {
        zzz[] zzzVarArrZzW = zzW(zzywVar);
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            this.zze = true;
            zzma zzmaVar = this.zza;
            zzmaVar.zzt(zzmeVar, zzzVarArrZzW, zzwzVar, j, z, z2, j2, j3, zzvhVar);
            zzilVar.zze(zzmaVar);
            return;
        }
        this.zzf = true;
        zzma zzmaVar2 = this.zzc;
        zzmaVar2.getClass();
        zzmaVar2.zzt(zzmeVar, zzzVarArrZzW, zzwzVar, j, z, z2, j2, j3, zzvhVar);
        zzilVar.zze(zzmaVar2);
    }

    public final void zzi() {
        zzma zzmaVar = this.zza;
        if (zzU(zzmaVar)) {
            zzmaVar.zzu();
            return;
        }
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 == null || !zzU(zzmaVar2)) {
            return;
        }
        zzmaVar2.zzu();
    }

    public final void zzj(int i, Object obj, zzlc zzlcVar) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        zzmaVarZzN.getClass();
        zzmaVarZzN.zzv(11, obj);
    }

    public final void zzk(zzwz zzwzVar, zzil zzilVar, long j, boolean z) {
        zzP(this.zza, zzwzVar, zzilVar, j, z);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzP(zzmaVar, zzwzVar, zzilVar, j, z);
        }
    }

    public final void zzl() {
        int i = this.zzd;
        if (i == 3 || i == 4) {
            zzR(i == 4);
            this.zzd = this.zzd != 4 ? 1 : 0;
        } else if (i == 2) {
            this.zzd = 0;
        }
    }

    public final void zzm(zzze zzzeVar, zzze zzzeVar2, long j) {
        int i;
        int i2 = this.zzb;
        boolean zZzb = zzzeVar.zzb(i2);
        boolean zZzb2 = zzzeVar2.zzb(i2);
        zzma zzmaVar = this.zzc;
        if (zzmaVar == null || (i = this.zzd) == 3 || (i == 0 && zzU(this.zza))) {
            zzmaVar = this.zza;
        }
        if (!zZzb || zzmaVar.zzS()) {
            return;
        }
        zzb();
        zzme zzmeVar = zzzeVar.zzb[i2];
        zzme zzmeVar2 = zzzeVar2.zzb[i2];
        if (zZzb2 && Objects.equals(zzmeVar2, zzmeVar) && !zzI()) {
            return;
        }
        zzY(zzmaVar, j);
    }

    public final void zzn(zzlc zzlcVar) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        zzmaVarZzN.getClass();
        zzmaVarZzN.zzx();
    }

    public final void zzo() {
        this.zza.zzH();
        this.zze = false;
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzmaVar.zzH();
            this.zzf = false;
        }
    }

    public final void zzp(long j, long j2) {
        zzma zzmaVar = this.zza;
        if (zzU(zzmaVar)) {
            zzmaVar.zzW(j, j2);
        }
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 == null || !zzU(zzmaVar2)) {
            return;
        }
        zzmaVar2.zzW(j, j2);
    }

    public final void zzq() {
        if (!zzU(this.zza)) {
            zzQ(true);
        }
        zzma zzmaVar = this.zzc;
        if (zzmaVar == null || zzU(zzmaVar)) {
            return;
        }
        zzQ(false);
    }

    public final void zzr(zzlc zzlcVar, long j) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        if (zzmaVarZzN != null) {
            zzmaVarZzN.zzK(j);
        }
    }

    public final void zzs(long j) {
        int i;
        zzma zzmaVar = this.zza;
        if (zzU(zzmaVar) && (i = this.zzd) != 4 && i != 2) {
            zzY(zzmaVar, j);
        }
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 == null || !zzU(zzmaVar2) || this.zzd == 3) {
            return;
        }
        zzY(zzmaVar2, j);
    }

    public final void zzt(zzlc zzlcVar, long j) {
        zzma zzmaVarZzN = zzN(zzlcVar);
        zzmaVarZzN.getClass();
        zzY(zzmaVarZzN, j);
    }

    public final void zzu(float f, float f2) {
        this.zza.zzN(f, f2);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzmaVar.zzN(f, f2);
        }
    }

    public final void zzv(zzmh zzmhVar) {
        this.zza.zzv(18, zzmhVar);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzmaVar.zzv(18, zzmhVar);
        }
    }

    public final void zzw(zzbl zzblVar) {
        this.zza.zzO(zzblVar);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzmaVar.zzO(zzblVar);
        }
    }

    public final void zzx(zzabp zzabpVar) {
        if (zzb() != 2) {
            return;
        }
        this.zza.zzv(7, zzabpVar);
        zzma zzmaVar = this.zzc;
        if (zzmaVar != null) {
            zzmaVar.zzv(7, zzabpVar);
        }
    }

    public final void zzy(Object obj) {
        if (zzb() != 2) {
            return;
        }
        int i = this.zzd;
        if (i != 4 && i != 1) {
            this.zza.zzv(1, obj);
            return;
        }
        zzma zzmaVar = this.zzc;
        zzmaVar.getClass();
        zzmaVar.zzv(1, obj);
    }

    public final void zzz(float f) {
        if (zzb() != 1) {
            return;
        }
        zzma zzmaVar = this.zza;
        Float fValueOf = Float.valueOf(f);
        zzmaVar.zzv(2, fValueOf);
        zzma zzmaVar2 = this.zzc;
        if (zzmaVar2 != null) {
            zzmaVar2.zzv(2, fValueOf);
        }
    }
}
