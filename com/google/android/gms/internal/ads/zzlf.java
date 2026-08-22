package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzlf {
    private final zzmo zzc;
    private final zzdt zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzix zzh;
    private zzlc zzi;
    private zzlc zzj;
    private zzlc zzk;
    private zzlc zzl;
    private zzlc zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzkk zzr;
    private final zzbj zza = new zzbj();
    private final zzbk zzb = new zzbk();
    private List zzq = new ArrayList();

    public zzlf(zzmo zzmoVar, zzdt zzdtVar, zzkk zzkkVar, zzix zzixVar) {
        this.zzc = zzmoVar;
        this.zzd = zzdtVar;
        this.zzr = zzkkVar;
        this.zzh = zzixVar;
    }

    private final int zzA(zzbl zzblVar) {
        zzlc zzlcVarZzg = this.zzi;
        if (zzlcVarZzg == null) {
            return 0;
        }
        int iZza = zzblVar.zza(zzlcVarZzg.zzb);
        while (true) {
            iZza = zzblVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzlcVarZzg.getClass();
                if (zzlcVarZzg.zzg() == null || zzlcVarZzg.zzg.zzh) {
                    break;
                }
                zzlcVarZzg = zzlcVarZzg.zzg();
            }
            zzlc zzlcVarZzg2 = zzlcVarZzg.zzg();
            if (iZza == -1 || zzlcVarZzg2 == null || zzblVar.zza(zzlcVarZzg2.zzb) != iZza) {
                break;
            }
            zzlcVarZzg = zzlcVarZzg2;
        }
        int iZza2 = zza(zzlcVarZzg);
        zzlcVarZzg.zzg = zzp(zzblVar, zzlcVarZzg.zzg);
        return iZza2;
    }

    private final long zzB(zzbl zzblVar, Object obj, int i) {
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        zzbjVar.zzg(i);
        long j = zzbjVar.zzg.zza(i).zzh;
        return 0L;
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzlc zzlcVar = (zzlc) this.zzq.get(i);
            if (zzlcVar.zzb.equals(obj)) {
                return zzlcVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final zzld zzD(zzbl zzblVar, zzlc zzlcVar, long j) {
        long j2;
        long j3;
        long j4;
        zzld zzldVar = zzlcVar.zzg;
        long jZze = zzlcVar.zze();
        long j5 = zzldVar.zze;
        long j6 = (jZze + j5) - j;
        if (zzldVar.zzh) {
            zzvh zzvhVar = zzldVar.zza;
            Object obj = zzvhVar.zza;
            int iZza = zzblVar.zza(obj);
            int i = this.zzf;
            boolean z = this.zzg;
            zzbk zzbkVar = this.zzb;
            zzbj zzbjVar = this.zza;
            int iZzi = zzblVar.zzi(iZza, zzbjVar, zzbkVar, i, z);
            if (iZzi != -1) {
                int i2 = zzblVar.zzd(iZzi, zzbjVar, true).zzc;
                Object obj2 = zzbjVar.zzb;
                obj2.getClass();
                long jZzC = zzvhVar.zzd;
                if (zzblVar.zze(i2, zzbkVar, 0L).zzn == iZzi) {
                    Pair pairZzm = zzblVar.zzm(zzbkVar, zzbjVar, i2, -9223372036854775807L, Math.max(0L, j6));
                    if (pairZzm != null) {
                        obj2 = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzlc zzlcVarZzg = zzlcVar.zzg();
                        if (zzlcVarZzg == null || !zzlcVarZzg.zzb.equals(obj2)) {
                            jZzC = zzC(obj2);
                            if (jZzC == -1) {
                                jZzC = this.zze;
                                this.zze = 1 + jZzC;
                            }
                        } else {
                            jZzC = zzlcVarZzg.zzg.zza.zzd;
                        }
                        j4 = jLongValue;
                        j3 = -9223372036854775807L;
                    }
                } else {
                    j3 = 0;
                    j4 = 0;
                }
                zzvh zzvhVarZzH = zzH(zzblVar, obj2, j4, jZzC, zzbkVar, zzbjVar);
                if (j3 != -9223372036854775807L && zzldVar.zzc != -9223372036854775807L) {
                    zzblVar.zzn(obj, zzbjVar).zzb();
                    int i3 = zzbjVar.zzg.zzd;
                }
                return zzE(zzblVar, zzvhVarZzH, j3, j4);
            }
        } else {
            zzvh zzvhVar2 = zzldVar.zza;
            Object obj3 = zzvhVar2.zza;
            zzbj zzbjVar2 = this.zza;
            zzblVar.zzn(obj3, zzbjVar2);
            if (!zzvhVar2.zzb()) {
                int i4 = zzvhVar2.zze;
                if (i4 != -1) {
                    zzbjVar2.zzj(i4);
                }
                int iZze = zzbjVar2.zze(i4);
                zzbjVar2.zzk(i4);
                if (iZze != zzbjVar2.zza(i4)) {
                    return zzF(zzblVar, obj3, i4, iZze, j5, zzvhVar2.zzd, false);
                }
                zzB(zzblVar, obj3, i4);
                return zzG(zzblVar, obj3, 0L, j5, zzvhVar2.zzd, false);
            }
            int i5 = zzvhVar2.zzb;
            if (zzbjVar2.zza(i5) != -1) {
                int iZza2 = zzbjVar2.zzg.zza(i5).zza(zzvhVar2.zzc);
                if (iZza2 < 0) {
                    return zzF(zzblVar, obj3, i5, iZza2, zzldVar.zzc, zzvhVar2.zzd, false);
                }
                long jLongValue2 = zzldVar.zzc;
                if (jLongValue2 == -9223372036854775807L) {
                    Pair pairZzm2 = zzblVar.zzm(this.zzb, zzbjVar2, zzbjVar2.zzc, -9223372036854775807L, Math.max(0L, j6));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                        j2 = -9223372036854775807L;
                    }
                } else {
                    j2 = jLongValue2;
                }
                zzB(zzblVar, obj3, i5);
                return zzG(zzblVar, obj3, Math.max(0L, jLongValue2), j2, zzvhVar2.zzd, false);
            }
        }
        return null;
    }

    private final zzld zzE(zzbl zzblVar, zzvh zzvhVar, long j, long j2) {
        Object obj = zzvhVar.zza;
        zzblVar.zzn(obj, this.zza);
        return zzvhVar.zzb() ? zzF(zzblVar, obj, zzvhVar.zzb, zzvhVar.zzc, j, zzvhVar.zzd, false) : zzG(zzblVar, obj, j2, j, zzvhVar.zzd, false);
    }

    private final zzld zzF(zzbl zzblVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzvh zzvhVar = new zzvh(obj, i, i2, j2);
        Object obj2 = zzvhVar.zza;
        int i3 = zzvhVar.zzb;
        int i4 = zzvhVar.zzc;
        zzbj zzbjVar = this.zza;
        long jZzf = zzblVar.zzn(obj2, zzbjVar).zzf(i3, i4);
        if (i2 == zzbjVar.zze(i)) {
            zzbjVar.zzh();
        }
        zzbjVar.zzk(i3);
        return new zzld(zzvhVar, (jZzf == -9223372036854775807L || jZzf > 0) ? 0L : Math.max(0L, (-1) + jZzf), j, -9223372036854775807L, jZzf, false, false, false, false, false);
    }

    private final zzld zzG(zzbl zzblVar, Object obj, long j, long j2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        int iZzc = zzbjVar.zzc(jMax);
        if (iZzc == -1) {
            zzbjVar.zzb();
        } else {
            zzbjVar.zzk(iZzc);
        }
        zzvh zzvhVar = new zzvh(obj, j3, iZzc);
        boolean zZzL = zzL(zzvhVar);
        boolean zZzK = zzK(zzblVar, zzvhVar);
        boolean zZzJ = zzJ(zzblVar, zzvhVar, zZzL);
        if (iZzc != -1) {
            zzbjVar.zzk(iZzc);
        }
        if (iZzc != -1) {
            zzbjVar.zzj(iZzc);
        }
        if (iZzc != -1) {
            zzbjVar.zzg(iZzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = zzbjVar.zzd;
            j6 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L && jMax >= j5) {
            jMax = Math.max(0L, j5 - 1);
        }
        return new zzld(zzvhVar, jMax, j2, j6, j5, false, false, zZzL, zZzK, zZzJ);
    }

    private static zzvh zzH(zzbl zzblVar, Object obj, long j, long j2, zzbk zzbkVar, zzbj zzbjVar) {
        zzblVar.zzn(obj, zzbjVar);
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzblVar.zza(obj);
        zzbjVar.zzb();
        zzblVar.zzn(obj, zzbjVar);
        int iZzd = zzbjVar.zzd(j);
        return iZzd == -1 ? new zzvh(obj, j2, zzbjVar.zzc(j)) : new zzvh(obj, iZzd, zzbjVar.zze(iZzd), j2);
    }

    private final void zzI() {
        int i = zzfyq.zzd;
        final zzfyn zzfynVar = new zzfyn();
        for (zzlc zzlcVarZzg = this.zzi; zzlcVarZzg != null; zzlcVarZzg = zzlcVarZzg.zzg()) {
            zzfynVar.zzf(zzlcVarZzg.zzg.zza);
        }
        zzlc zzlcVar = this.zzj;
        final zzvh zzvhVar = zzlcVar == null ? null : zzlcVar.zzg.zza;
        this.zzd.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzle
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc.zzU(zzfynVar.zzi(), zzvhVar);
            }
        });
    }

    private final boolean zzJ(zzbl zzblVar, zzvh zzvhVar, boolean z) {
        int iZza = zzblVar.zza(zzvhVar.zza);
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzd(iZza, zzbjVar, false).zzc;
        zzbk zzbkVar = this.zzb;
        return !zzblVar.zze(i, zzbkVar, 0L).zzi && zzblVar.zzi(iZza, zzbjVar, zzbkVar, this.zzf, this.zzg) == -1 && z;
    }

    private final boolean zzK(zzbl zzblVar, zzvh zzvhVar) {
        if (!zzL(zzvhVar)) {
            return false;
        }
        Object obj = zzvhVar.zza;
        return zzblVar.zze(zzblVar.zzn(obj, this.zza).zzc, this.zzb, 0L).zzo == zzblVar.zza(obj);
    }

    private static final boolean zzL(zzvh zzvhVar) {
        return !zzvhVar.zzb() && zzvhVar.zze == -1;
    }

    public final int zza(zzlc zzlcVar) {
        zzdd.zzb(zzlcVar);
        int i = 0;
        if (zzlcVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzlcVar;
        while (zzlcVar.zzg() != null) {
            zzlcVar = zzlcVar.zzg();
            zzlcVar.getClass();
            if (zzlcVar == this.zzj) {
                zzlc zzlcVar2 = this.zzi;
                this.zzj = zzlcVar2;
                this.zzk = zzlcVar2;
                i = 3;
            }
            if (zzlcVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzlcVar.zzo();
            this.zzn--;
        }
        zzlc zzlcVar3 = this.zzl;
        zzlcVar3.getClass();
        zzlcVar3.zzp(null);
        zzI();
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006b  */
    public final int zzb(zzbl zzblVar, long j, long j2, long j3) {
        zzld zzldVarZzp;
        boolean z;
        zzlc zzlcVarZzg = this.zzi;
        zzlc zzlcVar = null;
        while (true) {
            int i = 0;
            if (zzlcVarZzg == null) {
                return 0;
            }
            zzld zzldVar = zzlcVarZzg.zzg;
            if (zzlcVar == null) {
                zzldVarZzp = zzp(zzblVar, zzldVar);
            } else {
                zzld zzldVarZzD = zzD(zzblVar, zzlcVar, j);
                if (zzldVarZzD == null || zzldVar.zzb != zzldVarZzD.zzb || !zzldVar.zza.equals(zzldVarZzD.zza)) {
                    return zza(zzlcVar);
                }
                zzldVarZzp = zzldVarZzD;
            }
            zzlcVarZzg.zzg = zzldVarZzp.zza(zzldVar.zzc);
            long j4 = zzldVar.zze;
            long j5 = zzldVarZzp.zze;
            if (j4 != j5) {
                zzlcVarZzg.zzr();
                long jZze = j5 == -9223372036854775807L ? Long.MAX_VALUE : j5 + zzlcVarZzg.zze();
                if (zzlcVarZzg == this.zzj) {
                    boolean z2 = zzlcVarZzg.zzg.zzg;
                    if (j2 == Long.MIN_VALUE || j2 >= jZze) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                boolean z3 = zzlcVarZzg == this.zzk && (j3 == Long.MIN_VALUE || j3 >= jZze);
                int iZza = zza(zzlcVarZzg);
                if (iZza != 0) {
                    return iZza;
                }
                if (j4 == -9223372036854775807L) {
                    j4 = -9223372036854775807L;
                }
                if (z && j4 != -9223372036854775807L) {
                    i = 1;
                }
                return z3 ? i | 2 : i;
            }
            zzlcVar = zzlcVarZzg;
            zzlcVarZzg = zzlcVarZzg.zzg();
        }
    }

    public final int zzc(zzbl zzblVar, int i) {
        this.zzf = i;
        return zzA(zzblVar);
    }

    public final int zzd(zzbl zzblVar, boolean z) {
        this.zzg = z;
        return zzA(zzblVar);
    }

    public final zzlc zze() {
        zzlc zzlcVar = this.zzi;
        if (zzlcVar == null) {
            return null;
        }
        if (zzlcVar == this.zzj) {
            this.zzj = zzlcVar.zzg();
        }
        if (zzlcVar == this.zzk) {
            this.zzk = zzlcVar.zzg();
        }
        zzlcVar.zzo();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzlc zzlcVar2 = this.zzi;
            this.zzo = zzlcVar2.zzb;
            this.zzp = zzlcVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzg();
        zzI();
        return this.zzi;
    }

    public final zzlc zzf() {
        zzlc zzlcVar = this.zzk;
        zzdd.zzb(zzlcVar);
        this.zzk = zzlcVar.zzg();
        zzI();
        zzlc zzlcVar2 = this.zzk;
        zzdd.zzb(zzlcVar2);
        return zzlcVar2;
    }

    public final zzlc zzg() {
        zzlc zzlcVar = this.zzk;
        zzlc zzlcVar2 = this.zzj;
        if (zzlcVar == zzlcVar2) {
            zzdd.zzb(zzlcVar2);
            this.zzk = zzlcVar2.zzg();
        }
        zzlc zzlcVar3 = this.zzj;
        zzdd.zzb(zzlcVar3);
        this.zzj = zzlcVar3.zzg();
        zzI();
        zzlc zzlcVar4 = this.zzj;
        zzdd.zzb(zzlcVar4);
        return zzlcVar4;
    }

    public final zzlc zzh(zzld zzldVar) {
        zzlc zzlcVarZzg;
        zzlc zzlcVar = this.zzl;
        long jZze = zzlcVar == null ? 1000000000000L : (zzlcVar.zze() + zzlcVar.zzg.zze) - zzldVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzlcVarZzg = null;
                break;
            }
            zzld zzldVar2 = ((zzlc) this.zzq.get(i)).zzg;
            long j = zzldVar2.zze;
            long j2 = zzldVar.zze;
            if ((j == -9223372036854775807L || j == j2) && zzldVar2.zzb == zzldVar.zzb && zzldVar2.zza.equals(zzldVar.zza)) {
                zzlcVarZzg = (zzlc) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzlcVarZzg == null) {
            zzlcVarZzg = zzkt.zzg(this.zzr.zza, zzldVar, jZze);
        } else {
            zzlcVarZzg.zzg = zzldVar;
            zzlcVarZzg.zzq(jZze);
        }
        zzlc zzlcVar2 = this.zzl;
        if (zzlcVar2 != null) {
            zzlcVar2.zzp(zzlcVarZzg);
        } else {
            this.zzi = zzlcVarZzg;
            this.zzj = zzlcVarZzg;
            this.zzk = zzlcVarZzg;
        }
        this.zzo = null;
        this.zzl = zzlcVarZzg;
        this.zzn++;
        zzI();
        return zzlcVarZzg;
    }

    public final zzlc zzi() {
        return this.zzl;
    }

    public final zzlc zzj() {
        return this.zzi;
    }

    public final zzlc zzk(zzvf zzvfVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzlc zzlcVar = (zzlc) this.zzq.get(i);
            if (zzlcVar.zza == zzvfVar) {
                return zzlcVar;
            }
        }
        return null;
    }

    public final zzlc zzl() {
        return this.zzm;
    }

    public final zzlc zzm() {
        return this.zzk;
    }

    public final zzlc zzn() {
        return this.zzj;
    }

    public final zzld zzo(long j, zzls zzlsVar) {
        zzlc zzlcVar = this.zzl;
        return zzlcVar == null ? zzE(zzlsVar.zza, zzlsVar.zzb, zzlsVar.zzc, zzlsVar.zzs) : zzD(zzlsVar.zza, zzlcVar, j);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0057  */
    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    public final zzld zzp(zzbl zzblVar, zzld zzldVar) {
        long j;
        long jZzf;
        long j2;
        long j3;
        int i;
        int i2;
        zzvh zzvhVar = zzldVar.zza;
        boolean zZzL = zzL(zzvhVar);
        boolean zZzK = zzK(zzblVar, zzvhVar);
        boolean zZzJ = zzJ(zzblVar, zzvhVar, zZzL);
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        if (zzvhVar.zzb() || (i2 = zzvhVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbjVar.zzg(i2);
            j = 0;
        }
        if (!zzvhVar.zzb()) {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzf = zzbjVar.zzd;
            }
            if (zzvhVar.zzb()) {
                zzbjVar.zzk(zzvhVar.zzb);
            } else {
                i = zzvhVar.zze;
                if (i != -1) {
                    zzbjVar.zzk(i);
                }
            }
            return new zzld(zzvhVar, zzldVar.zzb, zzldVar.zzc, j3, j2, false, false, zZzL, zZzK, zZzJ);
        }
        jZzf = zzbjVar.zzf(zzvhVar.zzb, zzvhVar.zzc);
        j3 = j;
        j2 = jZzf;
        if (zzvhVar.zzb()) {
            zzbjVar.zzk(zzvhVar.zzb);
        } else {
            i = zzvhVar.zze;
            if (i != -1) {
                zzbjVar.zzk(i);
            }
        }
        return new zzld(zzvhVar, zzldVar.zzb, zzldVar.zzc, j3, j2, false, false, zZzL, zZzK, zZzJ);
    }

    public final zzvh zzq(zzbl zzblVar, Object obj, long j) {
        long jZzC;
        int iZza;
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZza = zzblVar.zza(obj2)) == -1 || zzblVar.zzd(iZza, zzbjVar, false).zzc != i) {
            zzlc zzlcVarZzg = this.zzi;
            while (true) {
                if (zzlcVarZzg == null) {
                    zzlc zzlcVarZzg2 = this.zzi;
                    while (true) {
                        if (zzlcVarZzg2 == null) {
                            jZzC = zzC(obj);
                            if (jZzC != -1) {
                                break;
                            }
                            jZzC = this.zze;
                            this.zze = 1 + jZzC;
                            if (this.zzi != null) {
                                break;
                            }
                            this.zzo = obj;
                            this.zzp = jZzC;
                            break;
                        }
                        int iZza2 = zzblVar.zza(zzlcVarZzg2.zzb);
                        if (iZza2 != -1 && zzblVar.zzd(iZza2, zzbjVar, false).zzc == i) {
                            jZzC = zzlcVarZzg2.zzg.zza.zzd;
                            break;
                        }
                        zzlcVarZzg2 = zzlcVarZzg2.zzg();
                    }
                } else {
                    if (zzlcVarZzg.zzb.equals(obj)) {
                        jZzC = zzlcVarZzg.zzg.zza.zzd;
                        break;
                    }
                    zzlcVarZzg = zzlcVarZzg.zzg();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j2 = jZzC;
        zzblVar.zzn(obj, zzbjVar);
        int i2 = zzbjVar.zzc;
        zzbk zzbkVar = this.zzb;
        zzblVar.zze(i2, zzbkVar, 0L);
        Object obj3 = obj;
        for (int iZza3 = zzblVar.zza(obj); iZza3 >= zzbkVar.zzn; iZza3--) {
            zzblVar.zzd(iZza3, zzbjVar, true);
            zzbjVar.zzb();
            if (zzbjVar.zzd(zzbjVar.zzd) != -1) {
                Object obj4 = zzbjVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzH(zzblVar, obj3, j, j2, zzbkVar, zzbjVar);
    }

    public final void zzs() {
        if (this.zzn == 0) {
            return;
        }
        zzlc zzlcVarZzg = this.zzi;
        zzdd.zzb(zzlcVarZzg);
        this.zzo = zzlcVarZzg.zzb;
        this.zzp = zzlcVarZzg.zzg.zza.zzd;
        while (zzlcVarZzg != null) {
            zzlcVarZzg.zzo();
            zzlcVarZzg = zzlcVarZzg.zzg();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzI();
    }

    public final void zzt() {
        zzlc zzlcVar = this.zzm;
        if (zzlcVar == null || zzlcVar.zzt()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzlc zzlcVar2 = (zzlc) this.zzq.get(i);
                if (!zzlcVar2.zzt()) {
                    this.zzm = zzlcVar2;
                    return;
                }
            }
        }
    }

    public final void zzu(long j) {
        zzlc zzlcVar = this.zzl;
        if (zzlcVar != null) {
            zzlcVar.zzn(j);
        }
    }

    public final void zzv() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzlc) this.zzq.get(i)).zzo();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final void zzw(zzbl zzblVar, zzix zzixVar) {
        this.zzh = zzixVar;
        long j = zzixVar.zzb;
        zzv();
    }

    public final boolean zzx(zzvf zzvfVar) {
        zzlc zzlcVar = this.zzl;
        return zzlcVar != null && zzlcVar.zza == zzvfVar;
    }

    public final boolean zzy(zzvf zzvfVar) {
        zzlc zzlcVar = this.zzm;
        return zzlcVar != null && zzlcVar.zza == zzvfVar;
    }

    public final boolean zzz() {
        zzlc zzlcVar = this.zzl;
        if (zzlcVar == null) {
            return true;
        }
        if (zzlcVar.zzg.zzj || !zzlcVar.zzs() || this.zzl.zzg.zze == -9223372036854775807L) {
            return false;
        }
        return this.zzn < 100;
    }
}
