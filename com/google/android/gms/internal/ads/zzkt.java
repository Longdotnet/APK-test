package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.ads.jY.UUFMQdNK;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzkt implements Handler.Callback, zzve, zzzc, zzlq, zzik, zzlu, zzia, zzabp {
    private static final long zza = zzex.zzv(10000);
    private boolean zzB;
    private boolean zzC;
    private zzkr zzD;
    private zzls zzE;
    private zzkq zzF;
    private boolean zzG;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzL;
    private boolean zzO;
    private int zzP;
    private zzkr zzQ;
    private long zzR;
    private long zzS;
    private int zzT;
    private boolean zzU;
    private zzin zzV;
    private zzix zzX;
    private boolean zzZ;
    private final zzjj zzab;
    private final zzig zzac;
    private final zzmf[] zzb;
    private final zzmd[] zzc;
    private final boolean[] zzd;
    private final zzzd zze;
    private final zzze zzf;
    private final zzkx zzg;
    private final zzzl zzh;
    private final zzdt zzi;
    private final zzlt zzj;
    private final Looper zzk;
    private final zzbk zzl;
    private final zzbj zzm;
    private final long zzn;
    private final zzil zzo;
    private final ArrayList zzp;
    private final zzdj zzq;
    private final zzlf zzr;
    private final zzlr zzs;
    private final long zzt;
    private final zzph zzu;
    private final zzmo zzv;
    private final zzdt zzw;
    private final boolean zzx;
    private final zzib zzy;
    private zzmi zzz;
    private long zzY = -9223372036854775807L;
    private int zzM = 0;
    private boolean zzN = false;
    private boolean zzH = false;
    private float zzaa = 1.0f;
    private zzmh zzA = zzmh.zza;
    private long zzW = -9223372036854775807L;
    private long zzK = -9223372036854775807L;

    public zzkt(Context context, zzma[] zzmaVarArr, zzma[] zzmaVarArr2, zzzd zzzdVar, zzze zzzeVar, zzkx zzkxVar, zzzl zzzlVar, int i, boolean z, zzmo zzmoVar, zzmi zzmiVar, zzig zzigVar, long j, boolean z2, boolean z3, Looper looper, zzdj zzdjVar, zzjj zzjjVar, zzph zzphVar, zzlt zzltVar, zzix zzixVar, final zzabp zzabpVar) {
        this.zzab = zzjjVar;
        this.zze = zzzdVar;
        this.zzf = zzzeVar;
        this.zzg = zzkxVar;
        this.zzh = zzzlVar;
        int i2 = 0;
        this.zzz = zzmiVar;
        this.zzac = zzigVar;
        this.zzt = j;
        this.zzq = zzdjVar;
        this.zzu = zzphVar;
        this.zzX = zzixVar;
        this.zzv = zzmoVar;
        this.zzn = zzkxVar.zzb(zzphVar);
        zzkxVar.zzg(zzphVar);
        zzbl zzblVar = zzbl.zza;
        zzls zzlsVarZzh = zzls.zzh(zzzeVar);
        this.zzE = zzlsVarZzh;
        this.zzF = new zzkq(zzlsVarZzh);
        int length = zzmaVarArr.length;
        this.zzc = new zzmd[2];
        this.zzd = new boolean[2];
        zzmc zzmcVarZze = zzzdVar.zze();
        this.zzb = new zzmf[2];
        boolean z4 = false;
        for (int i3 = 2; i2 < i3; i3 = 2) {
            zzmaVarArr[i2].zzw(i2, zzphVar, zzdjVar);
            this.zzc[i2] = zzmaVarArr[i2].zzn();
            this.zzc[i2].zzM(zzmcVarZze);
            zzma zzmaVar = zzmaVarArr2[i2];
            if (zzmaVar != null) {
                zzmaVar.zzw(i2, zzphVar, zzdjVar);
                z4 = true;
            }
            this.zzb[i2] = new zzmf(zzmaVarArr[i2], zzmaVarArr2[i2], i2);
            i2++;
        }
        this.zzx = z4;
        this.zzo = new zzil(this, zzdjVar);
        this.zzp = new ArrayList();
        this.zzl = new zzbk();
        this.zzm = new zzbj();
        zzzdVar.zzr(this, zzzlVar);
        this.zzU = true;
        zzdt zzdtVarZzd = zzdjVar.zzd(looper, null);
        this.zzw = zzdtVarZzd;
        this.zzr = new zzlf(zzmoVar, zzdtVarZzd, new zzkk(this), zzixVar);
        this.zzs = new zzlr(this, zzmoVar, zzdtVarZzd, zzphVar);
        zzlt zzltVar2 = new zzlt(null);
        this.zzj = zzltVar2;
        Looper looperZza = zzltVar2.zza();
        this.zzk = looperZza;
        zzdt zzdtVarZzd2 = zzdjVar.zzd(looperZza, this);
        this.zzi = zzdtVarZzd2;
        this.zzy = new zzib(context, looperZza, this);
        zzdtVarZzd2.zzc(35, new zzabp() { // from class: com.google.android.gms.internal.ads.zzkl
            @Override // com.google.android.gms.internal.ads.zzabp
            public final void zzcT(long j2, long j3, zzz zzzVar, MediaFormat mediaFormat) {
                this.zza.zzcT(j2, j3, zzzVar, mediaFormat);
            }
        }).zza();
    }

    private final long zzA(zzlc zzlcVar) {
        if (zzlcVar == null) {
            return 0L;
        }
        long jZze = zzlcVar.zze();
        if (zzlcVar.zze) {
            int i = 0;
            while (true) {
                zzmf[] zzmfVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzmfVarArr[i].zzK(zzlcVar)) {
                    long jZze2 = zzmfVarArr[i].zze(zzlcVar);
                    if (jZze2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZze = Math.max(jZze2, jZze);
                }
                i++;
            }
        }
        return jZze;
    }

    private final long zzB() {
        return zzC(this.zzE.zzq);
    }

    private final long zzC(long j) {
        zzlc zzlcVarZzi = this.zzr.zzi();
        if (zzlcVarZzi == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzR - zzlcVarZzi.zze()));
    }

    private final long zzD(zzvh zzvhVar, long j, boolean z) {
        zzlf zzlfVar = this.zzr;
        return zzE(zzvhVar, j, zzlfVar.zzj() != zzlfVar.zzn(), z);
    }

    private final long zzE(zzvh zzvhVar, long j, boolean z, boolean z2) throws zzin {
        zzan();
        zzav(false, true);
        if (z2 || this.zzE.zze == 3) {
            zzaj(2);
        }
        zzlf zzlfVar = this.zzr;
        zzlc zzlcVarZzj = zzlfVar.zzj();
        zzlc zzlcVarZzg = zzlcVarZzj;
        while (zzlcVarZzg != null && !zzvhVar.equals(zzlcVarZzg.zzg.zza)) {
            zzlcVarZzg = zzlcVarZzg.zzg();
        }
        if (z || zzlcVarZzj != zzlcVarZzg || (zzlcVarZzg != null && zzlcVarZzg.zze() + j < 0)) {
            zzK();
            if (zzlcVarZzg != null) {
                while (zzlfVar.zzj() != zzlcVarZzg) {
                    zzlfVar.zze();
                }
                zzlfVar.zza(zzlcVarZzg);
                zzlcVarZzg.zzq(1000000000000L);
                zzM();
                zzlcVarZzg.zzh = true;
            }
        }
        zzJ();
        if (zzlcVarZzg != null) {
            zzlfVar.zza(zzlcVarZzg);
            if (!zzlcVarZzg.zze) {
                zzlcVarZzg.zzg = zzlcVarZzg.zzg.zzb(j);
            } else if (zzlcVarZzg.zzf) {
                zzvf zzvfVar = zzlcVarZzg.zza;
                j = zzvfVar.zze(j);
                zzvfVar.zzh(j - this.zzn, false);
            }
            zzac(j);
            zzT();
        } else {
            zzlfVar.zzs();
            zzac(j);
        }
        zzP(false);
        this.zzi.zzj(2);
        return j;
    }

    private final Pair zzF(zzbl zzblVar) {
        long j = 0;
        if (zzblVar.zzo()) {
            return Pair.create(zzls.zzi(), 0L);
        }
        int iZzg = zzblVar.zzg(this.zzN);
        zzbk zzbkVar = this.zzl;
        zzbj zzbjVar = this.zzm;
        Pair pairZzl = zzblVar.zzl(zzbkVar, zzbjVar, iZzg, -9223372036854775807L);
        zzvh zzvhVarZzq = this.zzr.zzq(zzblVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzvhVarZzq.zzb()) {
            zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
            if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                zzbjVar.zzh();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzvhVarZzq, Long.valueOf(j));
    }

    private static Pair zzG(zzbl zzblVar, zzkr zzkrVar, boolean z, int i, boolean z2, zzbk zzbkVar, zzbj zzbjVar) {
        zzbl zzblVar2 = zzkrVar.zza;
        if (zzblVar.zzo()) {
            return null;
        }
        zzbl zzblVar3 = true == zzblVar2.zzo() ? zzblVar : zzblVar2;
        try {
            Pair pairZzl = zzblVar3.zzl(zzbkVar, zzbjVar, zzkrVar.zzb, zzkrVar.zzc);
            if (zzblVar.equals(zzblVar3)) {
                return pairZzl;
            }
            if (zzblVar.zza(pairZzl.first) != -1) {
                return (zzblVar3.zzn(pairZzl.first, zzbjVar).zzf && zzblVar3.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar3.zza(pairZzl.first)) ? zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(pairZzl.first, zzbjVar).zzc, zzkrVar.zzc) : pairZzl;
            }
            int iZzd = zzd(zzbkVar, zzbjVar, i, z2, pairZzl.first, zzblVar3, zzblVar);
            if (iZzd != -1) {
                return zzblVar.zzl(zzbkVar, zzbjVar, iZzd, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private final zzls zzH(zzvh zzvhVar, long j, long j2, long j3, boolean z, int i) {
        List listZzn;
        zzxk zzxkVar;
        zzze zzzeVar;
        zzlc zzlcVarZzj;
        int i2 = 0;
        this.zzU = (!this.zzU && j == this.zzE.zzs && zzvhVar.equals(this.zzE.zzb)) ? false : true;
        zzab();
        zzls zzlsVar = this.zzE;
        zzxk zzxkVar2 = zzlsVar.zzh;
        zzze zzzeVar2 = zzlsVar.zzi;
        List list = zzlsVar.zzj;
        if (this.zzs.zzj()) {
            zzlf zzlfVar = this.zzr;
            zzlc zzlcVarZzj2 = zzlfVar.zzj();
            zzxk zzxkVarZzh = zzlcVarZzj2 == null ? zzxk.zza : zzlcVarZzj2.zzh();
            zzze zzzeVarZzi = zzlcVarZzj2 == null ? this.zzf : zzlcVarZzj2.zzi();
            zzyw[] zzywVarArr = zzzeVarZzi.zzc;
            zzfyn zzfynVar = new zzfyn();
            boolean z2 = false;
            for (zzyw zzywVar : zzywVarArr) {
                if (zzywVar != null) {
                    zzav zzavVar = zzywVar.zza(0).zzl;
                    if (zzavVar == null) {
                        zzfynVar.zzf(new zzav(-9223372036854775807L, new zzau[0]));
                    } else {
                        zzfynVar.zzf(zzavVar);
                        z2 = true;
                    }
                }
            }
            zzfyq zzfyqVarZzi = z2 ? zzfynVar.zzi() : zzfyq.zzn();
            if (zzlcVarZzj2 != null) {
                zzld zzldVar = zzlcVarZzj2.zzg;
                if (zzldVar.zzc != j2) {
                    zzlcVarZzj2.zzg = zzldVar.zza(j2);
                }
            }
            if (zzlfVar.zzj() == zzlfVar.zzn() && (zzlcVarZzj = zzlfVar.zzj()) != null) {
                zzze zzzeVarZzi2 = zzlcVarZzj.zzi();
                while (true) {
                    zzmf[] zzmfVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzzeVarZzi2.zzb(i2)) {
                        if (zzmfVarArr[i2].zzb() != 1) {
                            break;
                        }
                        int i3 = zzzeVarZzi2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            listZzn = zzfyqVarZzi;
            zzxkVar = zzxkVarZzh;
            zzzeVar = zzzeVarZzi;
        } else if (zzvhVar.equals(this.zzE.zzb)) {
            listZzn = list;
            zzxkVar = zzxkVar2;
            zzzeVar = zzzeVar2;
        } else {
            zzzeVar = this.zzf;
            zzxkVar = zzxk.zza;
            listZzn = zzfyq.zzn();
        }
        if (z) {
            this.zzF.zzc(i);
        }
        return this.zzE.zzc(zzvhVar, j, j2, j3, zzB(), zzxkVar, zzzeVar, listZzn);
    }

    private final void zzI() {
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzv(this.zzB ? this.zzA : null);
            i++;
        }
    }

    private final void zzJ() {
        if (this.zzx && zzaw()) {
            zzmf[] zzmfVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzmf zzmfVar = zzmfVarArr[i];
                int iZza = zzmfVar.zza();
                zzmfVar.zzg(this.zzo);
                this.zzP -= iZza - zzmfVar.zza();
            }
            this.zzY = -9223372036854775807L;
        }
    }

    private final void zzK() {
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                this.zzY = -9223372036854775807L;
                return;
            }
            int iZza = zzmfVarArr[i].zza();
            zzmfVarArr[i].zzf(this.zzo);
            zzX(i, false);
            this.zzP -= iZza;
            i++;
        }
    }

    private final void zzL(zzlc zzlcVar, int i, boolean z, long j) throws zzin {
        zzmf zzmfVar = this.zzb[i];
        if (zzmfVar.zzL()) {
            return;
        }
        boolean z2 = zzlcVar == this.zzr.zzj();
        zzze zzzeVarZzi = zzlcVar.zzi();
        zzme zzmeVar = zzzeVarZzi.zzb[i];
        zzyw zzywVar = zzzeVarZzi.zzc[i];
        boolean z3 = zzaA() && this.zzE.zze == 3;
        boolean z4 = !z && z3;
        this.zzP++;
        zzmfVar.zzh(zzmeVar, zzywVar, zzlcVar.zzc[i], this.zzR, z4, z2, j, zzlcVar.zze(), zzlcVar.zzg.zza, this.zzo);
        zzmfVar.zzj(11, new zzkm(this), zzlcVar);
        if (z3 && z2) {
            zzmfVar.zzA();
        }
    }

    private final void zzM() throws zzin {
        zzN(new boolean[2], this.zzr.zzn().zzf());
    }

    private final void zzN(boolean[] zArr, long j) throws zzin {
        zzmf[] zzmfVarArr;
        zzlc zzlcVarZzn = this.zzr.zzn();
        zzze zzzeVarZzi = zzlcVarZzn.zzi();
        int i = 0;
        while (true) {
            zzmfVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzzeVarZzi.zzb(i)) {
                zzmfVarArr[i].zzq();
            }
            i++;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzzeVarZzi.zzb(i2) && !zzmfVarArr[i2].zzK(zzlcVarZzn)) {
                zzL(zzlcVarZzn, i2, zArr[i2], j);
            }
        }
    }

    private final void zzO(IOException iOException, int i) {
        zzlf zzlfVar = this.zzr;
        zzin zzinVarZzc = zzin.zzc(iOException, i);
        zzlc zzlcVarZzj = zzlfVar.zzj();
        if (zzlcVarZzj != null) {
            zzinVarZzc = zzinVarZzc.zza(zzlcVarZzj.zzg.zza);
        }
        zzea.zzd("ExoPlayerImplInternal", "Playback error", zzinVarZzc);
        zzam(false, false);
        this.zzE = this.zzE.zze(zzinVarZzc);
    }

    private final void zzP(boolean z) {
        zzlc zzlcVarZzi = this.zzr.zzi();
        zzvh zzvhVar = zzlcVarZzi == null ? this.zzE.zzb : zzlcVarZzi.zzg.zza;
        boolean zEquals = this.zzE.zzk.equals(zzvhVar);
        if (!zEquals) {
            this.zzE = this.zzE.zzb(zzvhVar);
        }
        zzls zzlsVar = this.zzE;
        zzlsVar.zzq = zzlcVarZzi == null ? zzlsVar.zzs : zzlcVarZzi.zzc();
        this.zzE.zzr = zzB();
        if ((!zEquals || z) && zzlcVarZzi != null && zzlcVarZzi.zze) {
            zzap(zzlcVarZzi.zzg.zza, zzlcVarZzi.zzh(), zzlcVarZzi.zzi());
        }
    }

    /* JADX WARN: Code duplicated, block: B:194:0x036f  */
    /* JADX WARN: Code duplicated, block: B:195:0x0375  */
    /* JADX WARN: Code duplicated, block: B:198:0x0387  */
    /* JADX WARN: Code duplicated, block: B:202:0x0392  */
    /* JADX WARN: Code duplicated, block: B:204:0x039c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:210:0x03af  */
    /* JADX WARN: Code duplicated, block: B:214:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:218:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:51:0x0146  */
    /* JADX WARN: Code duplicated, block: B:52:0x0163  */
    /* JADX WARN: Code duplicated, block: B:55:0x016f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0175 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:60:0x017b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0184  */
    /* JADX WARN: Code duplicated, block: B:69:0x0194  */
    /* JADX WARN: Code duplicated, block: B:72:0x019b  */
    /* JADX WARN: Code duplicated, block: B:79:0x01af  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:88:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:91:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:93:0x01e2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    private final void zzQ(zzbl zzblVar, boolean z) throws Throwable {
        zzvh zzvhVar;
        zzbj zzbjVar;
        zzbk zzbkVar;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int iZzg;
        boolean z5;
        long jLongValue;
        zzvh zzvhVarZzq;
        int i3;
        zzvh zzvhVar2;
        boolean z6;
        zzbj zzbjVarZzn;
        boolean z7;
        zzvh zzvhVarZzi;
        long jZzD;
        boolean z8;
        boolean z9;
        long j;
        int iZzg2;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i4;
        boolean z14;
        int i5;
        Object obj;
        long j2;
        Object obj2;
        zzls zzlsVar = this.zzE;
        zzkr zzkrVar = this.zzQ;
        int i6 = this.zzM;
        boolean z15 = this.zzN;
        boolean z16 = false;
        if (zzblVar.zzo()) {
            zzvhVarZzi = zzls.zzi();
            z9 = false;
            j = -9223372036854775807L;
            z8 = true;
            z7 = true;
            jZzD = 0;
        } else {
            zzbj zzbjVar2 = this.zzm;
            zzvh zzvhVar3 = zzlsVar.zzb;
            Object obj3 = zzvhVar3.zza;
            boolean zZzaz = zzaz(zzlsVar, zzbjVar2);
            long jLongValue2 = (zzvhVar3.zzb() || zZzaz) ? zzlsVar.zzc : zzlsVar.zzs;
            zzbk zzbkVar2 = this.zzl;
            if (zzkrVar != null) {
                zzvhVar = zzvhVar3;
                Pair pairZzG = zzG(zzblVar, zzkrVar, true, i6, z15, zzbkVar2, zzbjVar2);
                if (pairZzG == null) {
                    iZzg2 = zzblVar.zzg(z15);
                    obj3 = obj3;
                    jLongValue2 = jLongValue2;
                    zzbjVar = zzbjVar2;
                    z13 = true;
                    z11 = false;
                    z12 = false;
                } else {
                    if (zzkrVar.zzc == -9223372036854775807L) {
                        zzbjVar = zzbjVar2;
                        iZzg2 = zzblVar.zzn(pairZzG.first, zzbjVar).zzc;
                        obj3 = obj3;
                        jLongValue2 = jLongValue2;
                        z10 = false;
                    } else {
                        zzbjVar = zzbjVar2;
                        obj3 = pairZzG.first;
                        jLongValue2 = ((Long) pairZzG.second).longValue();
                        iZzg2 = -1;
                        z10 = true;
                    }
                    z11 = zzlsVar.zze == 4;
                    z12 = z10;
                    z13 = false;
                }
                z3 = z13;
                z4 = z12;
                zzbkVar = zzbkVar2;
                i2 = iZzg2;
                z2 = z11;
            } else {
                zzvhVar = zzvhVar3;
                zzbjVar = zzbjVar2;
                zzbkVar = zzbkVar2;
                zzbl zzblVar2 = zzlsVar.zza;
                if (zzblVar2.zzo()) {
                    iZzg = zzblVar.zzg(z15);
                } else {
                    if (zzblVar.zza(obj3) == -1) {
                        int iZzd = zzd(zzbkVar, zzbjVar, i6, z15, obj3, zzblVar2, zzblVar);
                        if (iZzd == -1) {
                            iZzd = zzblVar.zzg(z15);
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        z3 = z5;
                        obj3 = obj3;
                        zzbkVar = zzbkVar;
                        jLongValue2 = jLongValue2;
                        z2 = false;
                        z4 = false;
                        i2 = iZzd;
                    } else if (jLongValue2 == -9223372036854775807L) {
                        iZzg = zzblVar.zzn(obj3, zzbjVar).zzc;
                    } else if (zZzaz) {
                        zzblVar2.zzn(obj3, zzbjVar);
                        zzbkVar = zzbkVar;
                        if (zzblVar2.zze(zzbjVar.zzc, zzbkVar, 0L).zzn == zzblVar2.zza(obj3)) {
                            Pair pairZzl = zzblVar.zzl(zzbkVar, zzbjVar, zzblVar.zzn(obj3, zzbjVar).zzc, jLongValue2);
                            obj3 = pairZzl.first;
                            jLongValue2 = ((Long) pairZzl.second).longValue();
                        } else {
                            obj3 = obj3;
                            jLongValue2 = jLongValue2;
                        }
                        i = -1;
                        i2 = -1;
                        z2 = false;
                        z3 = false;
                        z4 = true;
                    } else {
                        i = -1;
                        i2 = -1;
                        z2 = false;
                        z3 = false;
                        z4 = false;
                    }
                    if (i2 != i) {
                        Pair pairZzl2 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                        obj3 = pairZzl2.first;
                        jLongValue = ((Long) pairZzl2.second).longValue();
                        jLongValue2 = -9223372036854775807L;
                    } else {
                        jLongValue = jLongValue2;
                    }
                    zzvhVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
                    i3 = zzvhVarZzq.zze;
                    if (i3 != -1) {
                        zzvhVar2 = zzvhVar;
                        int i7 = zzvhVar2.zze;
                        boolean z17 = i7 == -1 && i3 >= i7;
                        if (obj3.equals(obj3) || zzvhVar2.zzb() || zzvhVarZzq.zzb() || !z17) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                        if (!zZzaz && jLongValue2 == jLongValue2 && obj3.equals(zzvhVarZzq.zza)) {
                            if (zzvhVar2.zzb()) {
                                zzbjVarZzn.zzk(zzvhVar2.zzb);
                            }
                            if (zzvhVarZzq.zzb()) {
                                zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                            }
                        }
                        z7 = true;
                        if (true == z6) {
                            zzvhVarZzq = zzvhVar2;
                        }
                        if (zzvhVarZzq.zzb()) {
                            if (zzvhVarZzq.equals(zzvhVar2)) {
                                jLongValue = zzlsVar.zzs;
                            } else {
                                zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                                if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                                    zzbjVar.zzh();
                                }
                                jLongValue = 0;
                            }
                        }
                        zzvhVarZzi = zzvhVarZzq;
                        jZzD = jLongValue;
                        z8 = z3;
                        z9 = z4;
                        long j3 = jLongValue2;
                        z16 = z2;
                        j = j3;
                    } else {
                        zzvhVar2 = zzvhVar;
                    }
                    if (obj3.equals(obj3)) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                    if (!zZzaz) {
                        if (zzvhVar2.zzb()) {
                            zzbjVarZzn.zzk(zzvhVar2.zzb);
                        }
                        if (zzvhVarZzq.zzb()) {
                            zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                        }
                    }
                    z7 = true;
                    if (true == z6) {
                        zzvhVarZzq = zzvhVar2;
                    }
                    if (zzvhVarZzq.zzb()) {
                        if (zzvhVarZzq.equals(zzvhVar2)) {
                            jLongValue = zzlsVar.zzs;
                        } else {
                            zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                            if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                                zzbjVar.zzh();
                            }
                            jLongValue = 0;
                        }
                    }
                    zzvhVarZzi = zzvhVarZzq;
                    jZzD = jLongValue;
                    z8 = z3;
                    z9 = z4;
                    long j4 = jLongValue2;
                    z16 = z2;
                    j = j4;
                }
                i2 = iZzg;
                i = -1;
                z2 = false;
                z3 = false;
                z4 = false;
                if (i2 != i) {
                    Pair pairZzl3 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                    obj3 = pairZzl3.first;
                    jLongValue = ((Long) pairZzl3.second).longValue();
                    jLongValue2 = -9223372036854775807L;
                } else {
                    jLongValue = jLongValue2;
                }
                zzvhVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
                i3 = zzvhVarZzq.zze;
                if (i3 != -1) {
                    zzvhVar2 = zzvhVar;
                    int i8 = zzvhVar2.zze;
                    if (i8 == -1) {
                    }
                    if (obj3.equals(obj3)) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                    zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                    if (!zZzaz) {
                        if (zzvhVar2.zzb()) {
                            zzbjVarZzn.zzk(zzvhVar2.zzb);
                        }
                        if (zzvhVarZzq.zzb()) {
                            zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                        }
                    }
                    z7 = true;
                    if (true == z6) {
                        zzvhVarZzq = zzvhVar2;
                    }
                    if (zzvhVarZzq.zzb()) {
                        if (zzvhVarZzq.equals(zzvhVar2)) {
                            jLongValue = zzlsVar.zzs;
                        } else {
                            zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                            if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                                zzbjVar.zzh();
                            }
                            jLongValue = 0;
                        }
                    }
                    zzvhVarZzi = zzvhVarZzq;
                    jZzD = jLongValue;
                    z8 = z3;
                    z9 = z4;
                    long j5 = jLongValue2;
                    z16 = z2;
                    j = j5;
                } else {
                    zzvhVar2 = zzvhVar;
                }
                if (obj3.equals(obj3)) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                if (!zZzaz) {
                    if (zzvhVar2.zzb()) {
                        zzbjVarZzn.zzk(zzvhVar2.zzb);
                    }
                    if (zzvhVarZzq.zzb()) {
                        zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                    }
                }
                z7 = true;
                if (true == z6) {
                    zzvhVarZzq = zzvhVar2;
                }
                if (zzvhVarZzq.zzb()) {
                    if (zzvhVarZzq.equals(zzvhVar2)) {
                        jLongValue = zzlsVar.zzs;
                    } else {
                        zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                        if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                            zzbjVar.zzh();
                        }
                        jLongValue = 0;
                    }
                }
                zzvhVarZzi = zzvhVarZzq;
                jZzD = jLongValue;
                z8 = z3;
                z9 = z4;
                long j6 = jLongValue2;
                z16 = z2;
                j = j6;
            }
            i = -1;
            if (i2 != i) {
                Pair pairZzl4 = zzblVar.zzl(zzbkVar, zzbjVar, i2, -9223372036854775807L);
                obj3 = pairZzl4.first;
                jLongValue = ((Long) pairZzl4.second).longValue();
                jLongValue2 = -9223372036854775807L;
            } else {
                jLongValue = jLongValue2;
            }
            zzvhVarZzq = this.zzr.zzq(zzblVar, obj3, jLongValue);
            i3 = zzvhVarZzq.zze;
            if (i3 != -1) {
                zzvhVar2 = zzvhVar;
                int i9 = zzvhVar2.zze;
                if (i9 == -1) {
                }
                if (obj3.equals(obj3)) {
                    z6 = false;
                } else {
                    z6 = false;
                }
                zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
                if (!zZzaz) {
                    if (zzvhVar2.zzb()) {
                        zzbjVarZzn.zzk(zzvhVar2.zzb);
                    }
                    if (zzvhVarZzq.zzb()) {
                        zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                    }
                }
                z7 = true;
                if (true == z6) {
                    zzvhVarZzq = zzvhVar2;
                }
                if (zzvhVarZzq.zzb()) {
                    if (zzvhVarZzq.equals(zzvhVar2)) {
                        jLongValue = zzlsVar.zzs;
                    } else {
                        zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                        if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                            zzbjVar.zzh();
                        }
                        jLongValue = 0;
                    }
                }
                zzvhVarZzi = zzvhVarZzq;
                jZzD = jLongValue;
                z8 = z3;
                z9 = z4;
                long j7 = jLongValue2;
                z16 = z2;
                j = j7;
            } else {
                zzvhVar2 = zzvhVar;
            }
            if (obj3.equals(obj3)) {
                z6 = false;
            } else {
                z6 = false;
            }
            zzbjVarZzn = zzblVar.zzn(obj3, zzbjVar);
            if (!zZzaz) {
                if (zzvhVar2.zzb()) {
                    zzbjVarZzn.zzk(zzvhVar2.zzb);
                }
                if (zzvhVarZzq.zzb()) {
                    zzbjVarZzn.zzk(zzvhVarZzq.zzb);
                }
            }
            z7 = true;
            if (true == z6) {
                zzvhVarZzq = zzvhVar2;
            }
            if (zzvhVarZzq.zzb()) {
                if (zzvhVarZzq.equals(zzvhVar2)) {
                    jLongValue = zzlsVar.zzs;
                } else {
                    zzblVar.zzn(zzvhVarZzq.zza, zzbjVar);
                    if (zzvhVarZzq.zzc == zzbjVar.zze(zzvhVarZzq.zzb)) {
                        zzbjVar.zzh();
                    }
                    jLongValue = 0;
                }
            }
            zzvhVarZzi = zzvhVarZzq;
            jZzD = jLongValue;
            z8 = z3;
            z9 = z4;
            long j8 = jLongValue2;
            z16 = z2;
            j = j8;
        }
        boolean z18 = (this.zzE.zzb.equals(zzvhVarZzi) && jZzD == this.zzE.zzs) ? false : z7;
        int i10 = 2;
        if (z8) {
            try {
                if (this.zzE.zze != z7) {
                    i4 = 4;
                    try {
                        zzaj(4);
                    } catch (Throwable th) {
                        th = th;
                        i5 = 4;
                        obj = null;
                        zzls zzlsVar2 = this.zzE;
                        zzbl zzblVar3 = zzlsVar2.zza;
                        zzvh zzvhVar4 = zzlsVar2.zzb;
                        if (true != z9) {
                            j2 = -9223372036854775807L;
                        } else {
                            j2 = jZzD;
                        }
                        zzau(zzblVar, zzvhVarZzi, zzblVar3, zzvhVar4, j2, false);
                        if (z18) {
                            zzls zzlsVar3 = this.zzE;
                            obj2 = zzlsVar3.zzb.zza;
                            zzbl zzblVar4 = zzlsVar3.zza;
                            if (z18) {
                            }
                            long j9 = this.zzE.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzE = zzH(zzvhVarZzi, jZzD, j, j9, z, i5);
                        } else {
                            zzls zzlsVar4 = this.zzE;
                            obj2 = zzlsVar4.zzb.zza;
                            zzbl zzblVar5 = zzlsVar4.zza;
                            if (z18) {
                            }
                            long j10 = this.zzE.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzE = zzH(zzvhVarZzi, jZzD, j, j10, z, i5);
                        }
                        zzab();
                        zzad(zzblVar, this.zzE.zza);
                        this.zzE = this.zzE.zzg(zzblVar);
                        if (!zzblVar.zzo()) {
                            this.zzQ = obj;
                        }
                        zzP(false);
                        this.zzi.zzj(2);
                        throw th;
                    }
                } else {
                    i4 = 4;
                }
                z14 = false;
                try {
                    zzaa(false, false, false, z7);
                } catch (Throwable th2) {
                    th = th2;
                    i5 = i4;
                    obj = null;
                    zzls zzlsVar5 = this.zzE;
                    zzbl zzblVar6 = zzlsVar5.zza;
                    zzvh zzvhVar5 = zzlsVar5.zzb;
                    if (true != z9) {
                        j2 = -9223372036854775807L;
                    } else {
                        j2 = jZzD;
                    }
                    zzau(zzblVar, zzvhVarZzi, zzblVar6, zzvhVar5, j2, false);
                    if (z18) {
                        zzls zzlsVar6 = this.zzE;
                        obj2 = zzlsVar6.zzb.zza;
                        zzbl zzblVar7 = zzlsVar6.zza;
                        if (z18) {
                        }
                        long j11 = this.zzE.zzd;
                        if (zzblVar.zza(obj2) != -1) {
                            i5 = 3;
                        }
                        this.zzE = zzH(zzvhVarZzi, jZzD, j, j11, z, i5);
                    } else {
                        zzls zzlsVar7 = this.zzE;
                        obj2 = zzlsVar7.zzb.zza;
                        zzbl zzblVar8 = zzlsVar7.zza;
                        if (z18) {
                        }
                        long j12 = this.zzE.zzd;
                        if (zzblVar.zza(obj2) != -1) {
                            i5 = 3;
                        }
                        this.zzE = zzH(zzvhVarZzi, jZzD, j, j12, z, i5);
                    }
                    zzab();
                    zzad(zzblVar, this.zzE.zza);
                    this.zzE = this.zzE.zzg(zzblVar);
                    if (!zzblVar.zzo()) {
                        this.zzQ = obj;
                    }
                    zzP(false);
                    this.zzi.zzj(2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                i4 = 4;
                z14 = false;
                i5 = i4;
                obj = null;
                zzls zzlsVar8 = this.zzE;
                zzbl zzblVar9 = zzlsVar8.zza;
                zzvh zzvhVar6 = zzlsVar8.zzb;
                if (true != z9) {
                    j2 = -9223372036854775807L;
                } else {
                    j2 = jZzD;
                }
                zzau(zzblVar, zzvhVarZzi, zzblVar9, zzvhVar6, j2, false);
                if (z18) {
                    zzls zzlsVar9 = this.zzE;
                    obj2 = zzlsVar9.zzb.zza;
                    zzbl zzblVar10 = zzlsVar9.zza;
                    if (z18) {
                    }
                    long j13 = this.zzE.zzd;
                    if (zzblVar.zza(obj2) != -1) {
                        i5 = 3;
                    }
                    this.zzE = zzH(zzvhVarZzi, jZzD, j, j13, z, i5);
                } else {
                    zzls zzlsVar10 = this.zzE;
                    obj2 = zzlsVar10.zzb.zza;
                    zzbl zzblVar11 = zzlsVar10.zza;
                    if (z18) {
                    }
                    long j14 = this.zzE.zzd;
                    if (zzblVar.zza(obj2) != -1) {
                        i5 = 3;
                    }
                    this.zzE = zzH(zzvhVarZzi, jZzD, j, j14, z, i5);
                }
                zzab();
                zzad(zzblVar, this.zzE.zza);
                this.zzE = this.zzE.zzg(zzblVar);
                if (!zzblVar.zzo()) {
                    this.zzQ = obj;
                }
                zzP(false);
                this.zzi.zzj(2);
                throw th;
            }
        } else {
            i4 = 4;
            z14 = false;
        }
        zzmf[] zzmfVarArr = this.zzb;
        for (?? r1 = z14; r1 < 2; r1++) {
            zzmfVarArr[r1].zzw(zzblVar);
        }
        try {
            if (z18) {
                i5 = i4;
                z7 = z14;
                if (!zzblVar.zzo()) {
                    zzlf zzlfVar = this.zzr;
                    for (zzlc zzlcVarZzj = zzlfVar.zzj(); zzlcVarZzj != null; zzlcVarZzj = zzlcVarZzj.zzg()) {
                        if (zzlcVarZzj.zzg.zza.equals(zzvhVarZzi)) {
                            zzlcVarZzj.zzg = zzlfVar.zzp(zzblVar, zzlcVarZzj.zzg);
                            zzlcVarZzj.zzr();
                        }
                    }
                    jZzD = zzD(zzvhVarZzi, jZzD, z16);
                }
            } else {
                try {
                    zzlf zzlfVar2 = this.zzr;
                    i5 = i4;
                    z7 = z14;
                    try {
                        int iZzb = zzlfVar2.zzb(zzblVar, this.zzR, zzlfVar2.zzn() == null ? 0L : zzA(zzlfVar2.zzn()), (!zzaw() || zzlfVar2.zzm() == null) ? 0L : zzA(zzlfVar2.zzm()));
                        if ((iZzb & 1) != 0) {
                            try {
                                zzaf(z7);
                                i10 = 2;
                            } catch (Throwable th4) {
                                th = th4;
                                obj = null;
                                zzls zzlsVar11 = this.zzE;
                                zzbl zzblVar12 = zzlsVar11.zza;
                                zzvh zzvhVar7 = zzlsVar11.zzb;
                                if (true != z9) {
                                    j2 = -9223372036854775807L;
                                } else {
                                    j2 = jZzD;
                                }
                                zzau(zzblVar, zzvhVarZzi, zzblVar12, zzvhVar7, j2, false);
                                if (z18 || j != this.zzE.zzc) {
                                    zzls zzlsVar12 = this.zzE;
                                    obj2 = zzlsVar12.zzb.zza;
                                    zzbl zzblVar13 = zzlsVar12.zza;
                                    boolean z19 = (z18 || !z || zzblVar13.zzo() || zzblVar13.zzn(obj2, this.zzm).zzf) ? false : true;
                                    long j15 = this.zzE.zzd;
                                    if (zzblVar.zza(obj2) != -1) {
                                        i5 = 3;
                                    }
                                    this.zzE = zzH(zzvhVarZzi, jZzD, j, j15, z19, i5);
                                }
                                zzab();
                                zzad(zzblVar, this.zzE.zza);
                                this.zzE = this.zzE.zzg(zzblVar);
                                if (!zzblVar.zzo()) {
                                    this.zzQ = obj;
                                }
                                zzP(false);
                                this.zzi.zzj(2);
                                throw th;
                            }
                        } else {
                            i10 = 2;
                            if ((iZzb & 2) != 0) {
                                zzJ();
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        i10 = 2;
                        obj = null;
                        zzls zzlsVar13 = this.zzE;
                        zzbl zzblVar14 = zzlsVar13.zza;
                        zzvh zzvhVar8 = zzlsVar13.zzb;
                        if (true != z9) {
                            j2 = -9223372036854775807L;
                        } else {
                            j2 = jZzD;
                        }
                        zzau(zzblVar, zzvhVarZzi, zzblVar14, zzvhVar8, j2, false);
                        if (z18) {
                            zzls zzlsVar14 = this.zzE;
                            obj2 = zzlsVar14.zzb.zza;
                            zzbl zzblVar15 = zzlsVar14.zza;
                            if (z18) {
                            }
                            long j16 = this.zzE.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzE = zzH(zzvhVarZzi, jZzD, j, j16, z19, i5);
                        } else {
                            zzls zzlsVar15 = this.zzE;
                            obj2 = zzlsVar15.zzb.zza;
                            zzbl zzblVar16 = zzlsVar15.zza;
                            if (z18) {
                            }
                            long j17 = this.zzE.zzd;
                            if (zzblVar.zza(obj2) != -1) {
                                i5 = 3;
                            }
                            this.zzE = zzH(zzvhVarZzi, jZzD, j, j17, z19, i5);
                        }
                        zzab();
                        zzad(zzblVar, this.zzE.zza);
                        this.zzE = this.zzE.zzg(zzblVar);
                        if (!zzblVar.zzo()) {
                            this.zzQ = obj;
                        }
                        zzP(false);
                        this.zzi.zzj(2);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    i5 = i4;
                    z7 = z14;
                }
            }
            zzls zzlsVar16 = this.zzE;
            zzbl zzblVar17 = zzlsVar16.zza;
            zzvh zzvhVar9 = zzlsVar16.zzb;
            long j18 = true != z9 ? -9223372036854775807L : jZzD;
            int i11 = i10;
            zzau(zzblVar, zzvhVarZzi, zzblVar17, zzvhVar9, j18, false);
            if (z18 || j != this.zzE.zzc) {
                zzls zzlsVar17 = this.zzE;
                Object obj4 = zzlsVar17.zzb.zza;
                zzbl zzblVar18 = zzlsVar17.zza;
                boolean z20 = (!z18 || !z || zzblVar18.zzo() || zzblVar18.zzn(obj4, this.zzm).zzf) ? z7 : true;
                long j19 = this.zzE.zzd;
                if (zzblVar.zza(obj4) != -1) {
                    i5 = 3;
                }
                this.zzE = zzH(zzvhVarZzi, jZzD, j, j19, z20, i5);
            }
            zzab();
            zzad(zzblVar, this.zzE.zza);
            this.zzE = this.zzE.zzg(zzblVar);
            if (!zzblVar.zzo()) {
                this.zzQ = null;
            }
            zzP(z7);
            this.zzi.zzj(i11);
        } catch (Throwable th7) {
            th = th7;
        }
    }

    private final void zzR(zzbb zzbbVar, boolean z) {
        zzS(zzbbVar, zzbbVar.zzb, true, z);
    }

    private final void zzS(zzbb zzbbVar, float f, boolean z, boolean z2) {
        int i;
        if (z) {
            if (z2) {
                this.zzF.zza(1);
            }
            zzls zzlsVar = this.zzE;
            this.zzE = new zzls(zzlsVar.zza, zzlsVar.zzb, zzlsVar.zzc, zzlsVar.zzd, zzlsVar.zze, zzlsVar.zzf, zzlsVar.zzg, zzlsVar.zzh, zzlsVar.zzi, zzlsVar.zzj, zzlsVar.zzk, zzlsVar.zzl, zzlsVar.zzm, zzlsVar.zzn, zzbbVar, zzlsVar.zzq, zzlsVar.zzr, zzlsVar.zzs, zzlsVar.zzt, false);
        }
        float f2 = zzbbVar.zzb;
        zzlc zzlcVarZzj = this.zzr.zzj();
        while (true) {
            i = 0;
            if (zzlcVarZzj == null) {
                break;
            }
            zzyw[] zzywVarArr = zzlcVarZzj.zzi().zzc;
            int length = zzywVarArr.length;
            while (i < length) {
                zzyw zzywVar = zzywVarArr[i];
                i++;
            }
            zzlcVarZzj = zzlcVarZzj.zzg();
        }
        zzmf[] zzmfVarArr = this.zzb;
        while (i < 2) {
            zzmfVarArr[i].zzu(f, f2);
            i++;
        }
    }

    private final void zzT() {
        long jZze;
        long jZze2;
        zzlf zzlfVar;
        boolean zZzh;
        zzlf zzlfVar2 = this.zzr;
        if (zzaC(zzlfVar2.zzi())) {
            zzlc zzlcVarZzi = zzlfVar2.zzi();
            long jZzC = zzC(zzlcVarZzi.zzd());
            if (zzlcVarZzi == zzlfVar2.zzj()) {
                jZze = this.zzR;
                jZze2 = zzlcVarZzi.zze();
            } else {
                jZze = this.zzR - zzlcVarZzi.zze();
                jZze2 = zzlcVarZzi.zzg.zzb;
            }
            zzlfVar = zzlfVar2;
            zzkw zzkwVar = new zzkw(this.zzu, this.zzE.zza, zzlcVarZzi.zzg.zza, jZze - jZze2, jZzC, this.zzo.zzc().zzb, this.zzE.zzl, this.zzJ, zzaB(this.zzE.zza, zzlcVarZzi.zzg.zza) ? this.zzac.zzb() : -9223372036854775807L, this.zzK);
            zzkx zzkxVar = this.zzg;
            zZzh = zzkxVar.zzh(zzkwVar);
            zzlc zzlcVarZzj = zzlfVar.zzj();
            if (!zZzh && zzlcVarZzj.zze && jZzC < 500000 && this.zzn > 0) {
                zzlcVarZzj.zza.zzh(this.zzE.zzs, false);
                zZzh = zzkxVar.zzh(zzkwVar);
            }
        } else {
            zzlfVar = zzlfVar2;
            zZzh = false;
        }
        this.zzL = zZzh;
        if (zZzh) {
            zzlc zzlcVarZzi2 = zzlfVar.zzi();
            zzlcVarZzi2.getClass();
            zzky zzkyVar = new zzky();
            zzkyVar.zze(this.zzR - zzlcVarZzi2.zze());
            zzkyVar.zzf(this.zzo.zzc().zzb);
            zzkyVar.zzd(this.zzK);
            zzlcVarZzi2.zzk(new zzla(zzkyVar, null));
        }
        zzao();
    }

    private final void zzU() {
        zzlf zzlfVar = this.zzr;
        zzlfVar.zzt();
        zzlc zzlcVarZzl = zzlfVar.zzl();
        if (zzlcVarZzl != null) {
            if (!zzlcVarZzl.zzd || zzlcVarZzl.zze) {
                zzvf zzvfVar = zzlcVarZzl.zza;
                if (zzvfVar.zzp()) {
                    return;
                }
                if (this.zzg.zzi(this.zzE.zza, zzlcVarZzl.zzg.zza, zzlcVarZzl.zze ? zzvfVar.zzb() : 0L)) {
                    if (!zzlcVarZzl.zzd) {
                        zzlcVarZzl.zzm(this, zzlcVarZzl.zzg.zzb);
                        return;
                    }
                    zzky zzkyVar = new zzky();
                    zzkyVar.zze(this.zzR - zzlcVarZzl.zze());
                    zzkyVar.zzf(this.zzo.zzc().zzb);
                    zzkyVar.zzd(this.zzK);
                    zzlcVarZzl.zzk(new zzla(zzkyVar, null));
                }
            }
        }
    }

    private final void zzV() {
        this.zzF.zzb(this.zzE);
        if (this.zzF.zze) {
            zzjj zzjjVar = this.zzab;
            zzjjVar.zza.zzab(this.zzF);
            this.zzF = new zzkq(this.zzE);
        }
    }

    private final void zzW(int i) throws Throwable {
        zzmf zzmfVar = this.zzb[i];
        try {
            zzlc zzlcVarZzj = this.zzr.zzj();
            if (zzlcVarZzj == null) {
                throw null;
            }
            zzmfVar.zzn(zzlcVarZzj);
        } catch (IOException e) {
            e = e;
            zzmfVar.zzb();
            throw e;
        } catch (RuntimeException e2) {
            e = e2;
            zzmfVar.zzb();
            throw e;
        }
    }

    private final void zzX(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzw.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzki
                @Override // java.lang.Runnable
                public final void run() {
                    zzkt zzktVar = this.zza;
                    int i2 = i;
                    zzktVar.zzv.zzJ(i2, zzktVar.zzb[i2].zzb(), z);
                }
            });
        }
    }

    private final void zzY() throws zzin {
        int i;
        boolean z;
        zzil zzilVar = this.zzo;
        float f = zzilVar.zzc().zzb;
        zzlf zzlfVar = this.zzr;
        zzlc zzlcVarZzj = zzlfVar.zzj();
        zzlc zzlcVarZzn = zzlfVar.zzn();
        zzze zzzeVar = null;
        boolean z2 = true;
        while (zzlcVarZzj != null && zzlcVarZzj.zze) {
            zzls zzlsVar = this.zzE;
            zzze zzzeVarZzj = zzlcVarZzj.zzj(f, zzlsVar.zza, zzlsVar.zzl);
            zzze zzzeVar2 = zzlcVarZzj == zzlfVar.zzj() ? zzzeVarZzj : zzzeVar;
            zzze zzzeVarZzi = zzlcVarZzj.zzi();
            boolean z3 = false;
            if (zzzeVarZzi != null) {
                zzyw[] zzywVarArr = zzzeVarZzj.zzc;
                if (zzzeVarZzi.zzc.length == zzywVarArr.length) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= zzywVarArr.length) {
                            if (zzlcVarZzj != zzlcVarZzn) {
                                z3 = true;
                            }
                            z2 &= z3;
                            zzlcVarZzj = zzlcVarZzj.zzg();
                            zzzeVar = zzzeVar2;
                        } else if (zzzeVarZzj.zza(zzzeVarZzi, i2)) {
                            i2++;
                        }
                    }
                }
            }
            if (z2) {
                zzlc zzlcVarZzj2 = zzlfVar.zzj();
                int iZza = zzlfVar.zza(zzlcVarZzj2) & 1;
                zzmf[] zzmfVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzzeVar2.getClass();
                long jZzb = zzlcVarZzj2.zzb(zzzeVar2, this.zzE.zzs, 1 == iZza, zArr);
                zzls zzlsVar2 = this.zzE;
                boolean z4 = (zzlsVar2.zze == 4 || jZzb == zzlsVar2.zzs) ? false : true;
                zzls zzlsVar3 = this.zzE;
                zzlc zzlcVar = zzlcVarZzj2;
                i = 2;
                this.zzE = zzH(zzlsVar3.zzb, jZzb, zzlsVar3.zzc, zzlsVar3.zzd, z4, 5);
                if (z4) {
                    zzac(jZzb);
                }
                zzJ();
                boolean[] zArr2 = new boolean[2];
                int i3 = 0;
                while (i3 < 2) {
                    int iZza2 = zzmfVarArr[i3].zza();
                    zArr2[i3] = zzmfVarArr[i3].zzL();
                    zzlc zzlcVar2 = zzlcVar;
                    zzmfVarArr[i3].zzk(zzlcVar2.zzc[i3], zzilVar, this.zzR, zArr[i3]);
                    if (iZza2 - zzmfVarArr[i3].zza() > 0) {
                        zzX(i3, false);
                    }
                    this.zzP -= iZza2 - zzmfVarArr[i3].zza();
                    i3++;
                    zzlcVar = zzlcVar2;
                }
                zzN(zArr2, this.zzR);
                z = true;
                zzlcVar.zzh = true;
            } else {
                i = 2;
                zzlfVar.zza(zzlcVarZzj);
                if (zzlcVarZzj.zze) {
                    long jMax = Math.max(zzlcVarZzj.zzg.zzb, this.zzR - zzlcVarZzj.zze());
                    if (this.zzx && zzaw() && zzlfVar.zzm() == zzlcVarZzj) {
                        zzJ();
                    }
                    zzlcVarZzj.zza(zzzeVarZzj, jMax, false);
                }
                z = true;
            }
            zzP(z);
            if (this.zzE.zze != 4) {
                zzT();
                zzat();
                this.zzi.zzj(i);
                return;
            }
            return;
        }
    }

    private final void zzZ() throws zzin {
        zzY();
        zzaf(true);
    }

    private final boolean zzaA() {
        zzls zzlsVar = this.zzE;
        return zzlsVar.zzl && zzlsVar.zzn == 0;
    }

    private final boolean zzaB(zzbl zzblVar, zzvh zzvhVar) {
        if (!zzvhVar.zzb() && !zzblVar.zzo()) {
            int i = zzblVar.zzn(zzvhVar.zza, this.zzm).zzc;
            zzbk zzbkVar = this.zzl;
            zzblVar.zze(i, zzbkVar, 0L);
            if (zzbkVar.zzb() && zzbkVar.zzi && zzbkVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzaC(zzlc zzlcVar) {
        if (zzlcVar != null) {
            try {
                if (zzlcVar.zze) {
                    zzwz[] zzwzVarArr = zzlcVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzwz zzwzVar = zzwzVarArr[i];
                        if (zzwzVar != null) {
                            zzwzVar.zzd();
                        }
                    }
                } else {
                    zzlcVar.zza.zzi();
                }
                if (zzlcVar.zzd() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private static final void zzaD(zzlw zzlwVar) {
        zzlwVar.zzi();
        try {
            zzlwVar.zzc().zzv(zzlwVar.zza(), zzlwVar.zzg());
        } finally {
            zzlwVar.zzh(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0096 A[PHI: r2 r7 r9
  0x0096: PHI (r2v2 com.google.android.gms.internal.ads.zzvh) = (r2v1 com.google.android.gms.internal.ads.zzvh), (r2v6 com.google.android.gms.internal.ads.zzvh) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r9v2 long) = (r9v1 long), (r9v5 long) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00db A[PHI: r3
  0x00db: PHI (r3v3 com.google.android.gms.internal.ads.zzbl) = 
  (r3v2 com.google.android.gms.internal.ads.zzbl)
  (r3v2 com.google.android.gms.internal.ads.zzbl)
  (r3v11 com.google.android.gms.internal.ads.zzbl)
  (r3v11 com.google.android.gms.internal.ads.zzbl)
 binds: [B:31:0x00a3, B:33:0x00a7, B:35:0x00b8, B:37:0x00ce] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzaa(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzvh zzvhVar;
        zzbl zzblVar;
        this.zzi.zzg(2);
        this.zzC = false;
        this.zzD = null;
        this.zzV = null;
        zzav(false, true);
        this.zzo.zzi();
        this.zzR = 1000000000000L;
        try {
            zzK();
        } catch (zzin | RuntimeException e) {
            zzea.zzd("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzmf[] zzmfVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzmfVarArr[i].zzq();
                } catch (RuntimeException e2) {
                    zzea.zzd("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzP = 0;
        zzls zzlsVar = this.zzE;
        zzvh zzvhVar2 = zzlsVar.zzb;
        long jLongValue = zzlsVar.zzs;
        long j = (this.zzE.zzb.zzb() || zzaz(this.zzE, this.zzm)) ? this.zzE.zzc : this.zzE.zzs;
        if (z2) {
            this.zzQ = null;
            Pair pairZzF = zzF(this.zzE.zza);
            zzvhVar2 = (zzvh) pairZzF.first;
            jLongValue = ((Long) pairZzF.second).longValue();
            j = -9223372036854775807L;
            z5 = zzvhVar2.equals(this.zzE.zzb) ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        zzlf zzlfVar = this.zzr;
        zzlfVar.zzs();
        this.zzL = false;
        zzbl zzblVarZzx = this.zzE.zza;
        if (z3 && (zzblVarZzx instanceof zzly)) {
            zzblVarZzx = ((zzly) zzblVarZzx).zzx(this.zzs.zzq());
            if (zzvhVar2.zzb != -1) {
                Object obj = zzvhVar2.zza;
                zzbj zzbjVar = this.zzm;
                zzblVarZzx.zzn(obj, zzbjVar);
                zzbk zzbkVar = this.zzl;
                zzblVarZzx.zze(zzbjVar.zzc, zzbkVar, 0L);
                if (zzbkVar.zzb()) {
                    zzblVar = zzblVarZzx;
                    zzvhVar = new zzvh(obj, zzvhVar2.zzd);
                } else {
                    zzvhVar = zzvhVar2;
                    zzblVar = zzblVarZzx;
                }
            } else {
                zzvhVar = zzvhVar2;
                zzblVar = zzblVarZzx;
            }
        } else {
            zzvhVar = zzvhVar2;
            zzblVar = zzblVarZzx;
        }
        zzls zzlsVar2 = this.zzE;
        int i2 = zzlsVar2.zze;
        zzin zzinVar = z4 ? null : zzlsVar2.zzf;
        zzxk zzxkVar = z5 ? zzxk.zza : zzlsVar2.zzh;
        zzze zzzeVar = z5 ? this.zzf : zzlsVar2.zzi;
        List listZzn = z5 ? zzfyq.zzn() : zzlsVar2.zzj;
        zzls zzlsVar3 = this.zzE;
        this.zzE = new zzls(zzblVar, zzvhVar, j3, j2, i2, zzinVar, false, zzxkVar, zzzeVar, listZzn, zzvhVar, zzlsVar3.zzl, zzlsVar3.zzm, zzlsVar3.zzn, zzlsVar3.zzo, j2, 0L, j2, 0L, false);
        if (z3) {
            zzlfVar.zzv();
            this.zzs.zzh();
        }
    }

    private final void zzab() {
        zzlc zzlcVarZzj = this.zzr.zzj();
        boolean z = false;
        if (zzlcVarZzj != null && zzlcVarZzj.zzg.zzi && this.zzH) {
            z = true;
        }
        this.zzI = z;
    }

    private final void zzac(long j) {
        zzlc zzlcVarZzj = this.zzr.zzj();
        long jZze = j + (zzlcVarZzj == null ? 1000000000000L : zzlcVarZzj.zze());
        this.zzR = jZze;
        this.zzo.zzf(jZze);
        zzmf[] zzmfVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzmfVarArr[i].zzr(zzlcVarZzj, this.zzR);
        }
        for (zzlc zzlcVarZzj2 = r0.zzj(); zzlcVarZzj2 != null; zzlcVarZzj2 = zzlcVarZzj2.zzg()) {
            for (zzyw zzywVar : zzlcVarZzj2.zzi().zzc) {
            }
        }
    }

    private final void zzad(zzbl zzblVar, zzbl zzblVar2) {
        if (zzblVar.zzo() && zzblVar2.zzo()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
        } else {
            Object obj = ((zzkp) arrayList.get(size)).zzb;
            String str = zzex.zza;
            throw null;
        }
    }

    private final void zzae(long j) {
        long jMin = 1000;
        if (zzax()) {
            jMin = this.zzE.zze != 3 ? zza : 1000L;
            if (zzaA()) {
                zzmf[] zzmfVarArr = this.zzb;
                for (int i = 0; i < 2; i++) {
                    jMin = Math.min(jMin, zzex.zzv(zzmfVarArr[i].zzd(this.zzR, this.zzS)));
                }
                zzlf zzlfVar = this.zzr;
                zzlc zzlcVarZzg = zzlfVar.zzj() != null ? zzlfVar.zzj().zzg() : null;
                if (zzlcVarZzg != null) {
                    if (this.zzR + (zzex.zzs(jMin) * this.zzE.zzo.zzb) >= zzlcVarZzg.zzf()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzE.zze != 3 || zzaA()) {
            jMin = zza;
        }
        this.zzi.zzk(2, j + jMin);
    }

    private final void zzaf(boolean z) throws zzin {
        zzvh zzvhVar = this.zzr.zzj().zzg.zza;
        long jZzE = zzE(zzvhVar, this.zzE.zzs, true, false);
        if (jZzE != this.zzE.zzs) {
            zzls zzlsVar = this.zzE;
            this.zzE = zzH(zzvhVar, jZzE, zzlsVar.zzc, zzlsVar.zzd, z, 5);
        }
    }

    private final void zzag(zzkr zzkrVar, boolean z) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        zzvh zzvhVar;
        long j2;
        long jZza;
        long j3;
        zzls zzlsVar;
        int i;
        this.zzF.zza(z ? 1 : 0);
        if (this.zzC) {
            this.zzD = zzkrVar;
            return;
        }
        zzbl zzblVar = this.zzE.zza;
        int i2 = this.zzM;
        boolean z3 = this.zzN;
        zzbk zzbkVar = this.zzl;
        zzbj zzbjVar = this.zzm;
        Pair pairZzG = zzG(zzblVar, zzkrVar, true, i2, z3, zzbkVar, zzbjVar);
        if (pairZzG == null) {
            Pair pairZzF = zzF(this.zzE.zza);
            zzvhVar = (zzvh) pairZzF.first;
            jLongValue = ((Long) pairZzF.second).longValue();
            z2 = !this.zzE.zza.zzo();
            j = -9223372036854775807L;
        } else {
            Object obj = pairZzG.first;
            jLongValue = ((Long) pairZzG.second).longValue();
            long j4 = zzkrVar.zzc;
            j = j4 == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            zzvh zzvhVarZzq = this.zzr.zzq(this.zzE.zza, obj, jLongValue);
            if (zzvhVarZzq.zzb()) {
                this.zzE.zza.zzn(zzvhVarZzq.zza, zzbjVar);
                if (zzbjVar.zze(zzvhVarZzq.zzb) == zzvhVarZzq.zzc) {
                    zzbjVar.zzh();
                }
                jLongValue = 0;
                zzvhVar = zzvhVarZzq;
                z2 = true;
            } else {
                z2 = j4 == -9223372036854775807L;
                zzvhVar = zzvhVarZzq;
            }
        }
        try {
            if (!this.zzE.zza.zzo()) {
                if (pairZzG == null) {
                    if (this.zzE.zze != 1) {
                        zzaj(4);
                    }
                    zzaa(false, true, false, true);
                } else {
                    if (zzvhVar.equals(this.zzE.zzb)) {
                        zzlc zzlcVarZzj = this.zzr.zzj();
                        if (zzlcVarZzj == null || !zzlcVarZzj.zze || jLongValue == 0) {
                            jZza = jLongValue;
                        } else {
                            zzvf zzvfVar = zzlcVarZzj.zza;
                            long j5 = zzbkVar.zzm;
                            if (this.zzB && j5 != -9223372036854775807L) {
                                Double d = this.zzA.zzc;
                            }
                            jZza = zzvfVar.zza(jLongValue, this.zzz);
                        }
                        if (zzex.zzv(jZza) == zzex.zzv(this.zzE.zzs) && ((i = (zzlsVar = this.zzE).zze) == 2 || i == 3)) {
                            j3 = zzlsVar.zzs;
                        }
                    } else {
                        jZza = jLongValue;
                    }
                    this.zzC = this.zzB;
                    long jZzD = zzD(zzvhVar, jZza, this.zzE.zze == 4);
                    z2 |= jLongValue != jZzD;
                    try {
                        zzls zzlsVar2 = this.zzE;
                        zzbl zzblVar2 = zzlsVar2.zza;
                        zzau(zzblVar2, zzvhVar, zzblVar2, zzlsVar2.zzb, j, true);
                        j3 = jZzD;
                    } catch (Throwable th) {
                        th = th;
                        j2 = jZzD;
                        this.zzE = zzH(zzvhVar, j2, j, j2, z2, 2);
                        throw th;
                    }
                }
                this.zzE = zzH(zzvhVar, j3, j, j3, z2, 2);
            }
            this.zzQ = zzkrVar;
            j3 = jLongValue;
            this.zzE = zzH(zzvhVar, j3, j, j3, z2, 2);
        } catch (Throwable th2) {
            th = th2;
            j2 = jLongValue;
        }
    }

    private final void zzah(zzbb zzbbVar) {
        this.zzi.zzg(16);
        this.zzo.zzg(zzbbVar);
    }

    private final void zzai(boolean z, int i, boolean z2, int i2) {
        this.zzF.zza(z2 ? 1 : 0);
        zzar(z, i, i2);
    }

    private final void zzaj(int i) {
        zzls zzlsVar = this.zzE;
        if (zzlsVar.zze != i) {
            if (i != 2) {
                this.zzW = -9223372036854775807L;
            }
            this.zzE = zzlsVar.zzf(i);
        }
    }

    private final void zzak(float f) {
        this.zzaa = f;
        float fZza = f * this.zzy.zza();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzz(fZza);
            i++;
        }
    }

    private final void zzal() {
        zzlc zzlcVarZzj = this.zzr.zzj();
        if (zzlcVarZzj == null) {
            return;
        }
        zzze zzzeVarZzi = zzlcVarZzj.zzi();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzzeVarZzi.zzb(i)) {
                zzmfVarArr[i].zzA();
            }
            i++;
        }
    }

    private final void zzam(boolean z, boolean z2) {
        zzaa(z || !this.zzO, false, true, false);
        this.zzF.zza(z2 ? 1 : 0);
        this.zzg.zze(this.zzu);
        this.zzy.zzb(this.zzE.zzl, 1);
        zzaj(1);
    }

    private final void zzan() {
        this.zzo.zzi();
        int i = 0;
        while (true) {
            zzmf[] zzmfVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzmfVarArr[i].zzC();
            i++;
        }
    }

    private final void zzao() {
        zzlc zzlcVarZzi = this.zzr.zzi();
        boolean z = true;
        if (!this.zzL && (zzlcVarZzi == null || !zzlcVarZzi.zza.zzp())) {
            z = false;
        }
        zzls zzlsVar = this.zzE;
        if (z != zzlsVar.zzg) {
            this.zzE = zzlsVar.zza(z);
        }
    }

    private final void zzap(zzvh zzvhVar, zzxk zzxkVar, zzze zzzeVar) {
        long jZze;
        long jZze2;
        zzlf zzlfVar = this.zzr;
        zzlc zzlcVarZzi = zzlfVar.zzi();
        zzlcVarZzi.getClass();
        if (zzlcVarZzi == zzlfVar.zzj()) {
            jZze = this.zzR;
            jZze2 = zzlcVarZzi.zze();
        } else {
            jZze = this.zzR - zzlcVarZzi.zze();
            jZze2 = zzlcVarZzi.zzg.zzb;
        }
        this.zzg.zzf(new zzkw(this.zzu, this.zzE.zza, zzvhVar, jZze - jZze2, zzC(zzlcVarZzi.zzc()), this.zzo.zzc().zzb, this.zzE.zzl, this.zzJ, zzaB(this.zzE.zza, zzlcVarZzi.zzg.zza) ? this.zzac.zzb() : -9223372036854775807L, this.zzK), zzxkVar, zzzeVar.zzc);
    }

    private final void zzaq() {
        zzls zzlsVar = this.zzE;
        zzar(zzlsVar.zzl, zzlsVar.zzn, zzlsVar.zzm);
    }

    private final void zzar(boolean z, int i, int i2) {
        zzas(z, this.zzy.zzb(z, this.zzE.zze), i, i2);
    }

    private final void zzas(boolean z, int i, int i2, int i3) {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = 0;
        }
        zzls zzlsVar = this.zzE;
        if (zzlsVar.zzl == z2 && zzlsVar.zzn == i2 && zzlsVar.zzm == i3) {
            return;
        }
        this.zzE = zzlsVar.zzd(z2, i3, i2);
        zzav(false, false);
        zzlf zzlfVar = this.zzr;
        for (zzlc zzlcVarZzj = zzlfVar.zzj(); zzlcVarZzj != null; zzlcVarZzj = zzlcVarZzj.zzg()) {
            for (zzyw zzywVar : zzlcVarZzj.zzi().zzc) {
            }
        }
        if (!zzaA()) {
            zzan();
            zzat();
            boolean z3 = this.zzE.zzp;
            zzlfVar.zzu(this.zzR);
            return;
        }
        int i4 = this.zzE.zze;
        if (i4 == 3) {
            this.zzo.zzh();
            zzal();
            this.zzi.zzj(2);
        } else if (i4 == 2) {
            this.zzi.zzj(2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzat() {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkt.zzat():void");
    }

    private final void zzau(zzbl zzblVar, zzvh zzvhVar, zzbl zzblVar2, zzvh zzvhVar2, long j, boolean z) {
        if (!zzaB(zzblVar, zzvhVar)) {
            zzbb zzbbVar = zzvhVar.zzb() ? zzbb.zza : this.zzE.zzo;
            if (this.zzo.zzc().equals(zzbbVar)) {
                return;
            }
            zzah(zzbbVar);
            zzS(this.zzE.zzo, zzbbVar.zzb, false, false);
            return;
        }
        Object obj = zzvhVar.zza;
        zzbj zzbjVar = this.zzm;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        zzig zzigVar = this.zzac;
        zzaj zzajVar = zzbkVar.zzj;
        String str = zzex.zza;
        zzigVar.zzd(zzajVar);
        if (j != -9223372036854775807L) {
            zzigVar.zze(zzz(zzblVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzblVar2.zzo() ? zzblVar2.zze(zzblVar2.zzn(zzvhVar2.zza, zzbjVar).zzc, zzbkVar, 0L).zzb : null, zzbkVar.zzb) || z) {
            zzigVar.zze(-9223372036854775807L);
        }
    }

    private final void zzav(boolean z, boolean z2) {
        this.zzJ = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzK = jElapsedRealtime;
    }

    private final boolean zzaw() {
        if (!this.zzx) {
            return false;
        }
        zzmf[] zzmfVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzmfVarArr[i].zzI()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzax() {
        if (!this.zzB) {
            return false;
        }
        boolean z = this.zzA.zzg;
        return true;
    }

    private final boolean zzay() {
        zzlc zzlcVarZzj = this.zzr.zzj();
        long j = zzlcVarZzj.zzg.zze;
        if (!zzlcVarZzj.zze) {
            return false;
        }
        if (j == -9223372036854775807L || this.zzE.zzs < j) {
            return true;
        }
        return !zzaA();
    }

    private static boolean zzaz(zzls zzlsVar, zzbj zzbjVar) {
        zzvh zzvhVar = zzlsVar.zzb;
        zzbl zzblVar = zzlsVar.zza;
        return zzblVar.zzo() || zzblVar.zzn(zzvhVar.zza, zzbjVar).zzf;
    }

    public static int zzd(zzbk zzbkVar, zzbj zzbjVar, int i, boolean z, Object obj, zzbl zzblVar, zzbl zzblVar2) {
        Object obj2 = zzblVar.zze(zzblVar.zzn(obj, zzbjVar).zzc, zzbkVar, 0L).zzb;
        for (int i2 = 0; i2 < zzblVar2.zzc(); i2++) {
            if (zzblVar2.zze(i2, zzbkVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZza = zzblVar.zza(obj);
        int iZzb = zzblVar.zzb();
        int iZzi = iZza;
        int iZza2 = -1;
        for (int i3 = 0; i3 < iZzb && iZza2 == -1; i3++) {
            iZzi = zzblVar.zzi(iZzi, zzbjVar, zzbkVar, i, z);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzblVar2.zza(zzblVar.zzf(iZzi));
        }
        if (iZza2 == -1) {
            return -1;
        }
        return zzblVar2.zzd(iZza2, zzbjVar, false).zzc;
    }

    public static /* synthetic */ zzlc zzg(zzkt zzktVar, zzld zzldVar, long j) {
        zzzm zzzmVarZzk = zzktVar.zzg.zzk();
        long j2 = zzktVar.zzX.zzb;
        zzze zzzeVar = zzktVar.zzf;
        zzlr zzlrVar = zzktVar.zzs;
        return new zzlc(zzktVar.zzc, j, zzktVar.zze, zzzmVarZzk, zzlrVar, zzldVar, zzzeVar, -9223372036854775807L);
    }

    public static /* synthetic */ void zzh(zzkt zzktVar, zzlw zzlwVar) {
        try {
            zzaD(zzlwVar);
        } catch (zzin e) {
            zzea.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private final long zzz(zzbl zzblVar, Object obj, long j) {
        int i = zzblVar.zzn(obj, this.zzm).zzc;
        zzbk zzbkVar = this.zzl;
        zzblVar.zze(i, zzbkVar, 0L);
        if (zzbkVar.zzf == -9223372036854775807L || !zzbkVar.zzb() || !zzbkVar.zzi) {
            return -9223372036854775807L;
        }
        long j2 = zzbkVar.zzg;
        String str = zzex.zza;
        return zzex.zzs((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbkVar.zzf) - j;
    }

    /* JADX WARN: Code duplicated, block: B:257:0x0577  */
    /* JADX WARN: Code duplicated, block: B:265:0x0595  */
    /* JADX WARN: Code duplicated, block: B:319:0x069f  */
    /* JADX WARN: Code duplicated, block: B:321:0x06a3 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x062d, TRY_LEAVE, TryCatch #9 {zzin -> 0x062d, blocks: (B:358:0x071f, B:285:0x0617, B:287:0x061e, B:289:0x0622, B:298:0x063f, B:300:0x0643, B:304:0x064b, B:306:0x0651, B:308:0x066e, B:311:0x0677, B:321:0x06a3, B:313:0x067d, B:315:0x0685, B:316:0x068e, B:318:0x0694, B:296:0x0635, B:329:0x06c8, B:334:0x06d2, B:337:0x06db, B:339:0x06e1, B:343:0x06ef, B:345:0x06f6), top: B:656:0x057d }] */
    /* JADX WARN: Code duplicated, block: B:331:0x06cc A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x0773, TRY_ENTER, TRY_LEAVE, TryCatch #6 {zzin -> 0x0773, blocks: (B:347:0x06fd, B:349:0x0703, B:351:0x0709, B:354:0x0710, B:355:0x071a, B:327:0x06c2, B:331:0x06cc), top: B:654:0x06c2 }] */
    /* JADX WARN: Code duplicated, block: B:334:0x06d2 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x062d, TRY_ENTER, TryCatch #9 {zzin -> 0x062d, blocks: (B:358:0x071f, B:285:0x0617, B:287:0x061e, B:289:0x0622, B:298:0x063f, B:300:0x0643, B:304:0x064b, B:306:0x0651, B:308:0x066e, B:311:0x0677, B:321:0x06a3, B:313:0x067d, B:315:0x0685, B:316:0x068e, B:318:0x0694, B:296:0x0635, B:329:0x06c8, B:334:0x06d2, B:337:0x06db, B:339:0x06e1, B:343:0x06ef, B:345:0x06f6), top: B:656:0x057d }] */
    /* JADX WARN: Code duplicated, block: B:336:0x06da A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:337:0x06db A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x062d, TryCatch #9 {zzin -> 0x062d, blocks: (B:358:0x071f, B:285:0x0617, B:287:0x061e, B:289:0x0622, B:298:0x063f, B:300:0x0643, B:304:0x064b, B:306:0x0651, B:308:0x066e, B:311:0x0677, B:321:0x06a3, B:313:0x067d, B:315:0x0685, B:316:0x068e, B:318:0x0694, B:296:0x0635, B:329:0x06c8, B:334:0x06d2, B:337:0x06db, B:339:0x06e1, B:343:0x06ef, B:345:0x06f6), top: B:656:0x057d }] */
    /* JADX WARN: Code duplicated, block: B:341:0x06e9  */
    /* JADX WARN: Code duplicated, block: B:344:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:353:0x070d  */
    /* JADX WARN: Code duplicated, block: B:409:0x0811 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x0760, LOOP:10: B:408:0x080f->B:409:0x0811, LOOP_END, TryCatch #18 {zzin -> 0x0760, blocks: (B:363:0x0745, B:365:0x074b, B:367:0x0753, B:370:0x0768, B:371:0x076b, B:375:0x0777, B:423:0x0848, B:427:0x0856, B:432:0x0863, B:434:0x086b, B:435:0x0871, B:437:0x087f, B:438:0x0899, B:440:0x089d, B:442:0x08a5, B:457:0x08cf, B:443:0x08a9, B:445:0x08b2, B:449:0x08bb, B:455:0x08cb, B:459:0x08dc, B:461:0x08e2, B:465:0x08ef, B:467:0x08f7, B:469:0x08fb, B:470:0x0906, B:472:0x090c, B:525:0x0a27, B:528:0x0a2e, B:530:0x0a32, B:532:0x0a3a, B:533:0x0a3d, B:534:0x0a40, B:536:0x0a46, B:538:0x0a4f, B:540:0x0a59, B:542:0x0a5f, B:544:0x0a6a, B:551:0x0a8e, B:553:0x0a94, B:557:0x0a9e, B:567:0x0ab8, B:564:0x0aaf, B:566:0x0ab3, B:545:0x0a71, B:548:0x0a7f, B:549:0x0a86, B:550:0x0a87, B:473:0x0917, B:475:0x091d, B:477:0x0921, B:504:0x09c9, B:506:0x09d5, B:507:0x09e2, B:509:0x09e9, B:511:0x09ed, B:515:0x09f6, B:517:0x0a05, B:519:0x0a0b, B:521:0x0a15, B:522:0x0a1a, B:523:0x0a1f, B:524:0x0a24, B:480:0x092f, B:482:0x0933, B:484:0x0945, B:486:0x0953, B:488:0x095d, B:492:0x0966, B:494:0x0970, B:500:0x097b, B:458:0x08d5, B:378:0x0781, B:380:0x0785, B:382:0x078b, B:384:0x0791, B:386:0x079b, B:389:0x07a1, B:390:0x07a4, B:392:0x07ad, B:394:0x07bf, B:396:0x07c8, B:398:0x07d0, B:403:0x07dc, B:405:0x0806, B:407:0x080c, B:409:0x0811, B:410:0x0819, B:412:0x0820, B:413:0x0823, B:414:0x082c, B:416:0x0830, B:418:0x0836, B:419:0x083b, B:422:0x0847, B:569:0x0ac0, B:573:0x0acc), top: B:653:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:412:0x0820 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x0760, TryCatch #18 {zzin -> 0x0760, blocks: (B:363:0x0745, B:365:0x074b, B:367:0x0753, B:370:0x0768, B:371:0x076b, B:375:0x0777, B:423:0x0848, B:427:0x0856, B:432:0x0863, B:434:0x086b, B:435:0x0871, B:437:0x087f, B:438:0x0899, B:440:0x089d, B:442:0x08a5, B:457:0x08cf, B:443:0x08a9, B:445:0x08b2, B:449:0x08bb, B:455:0x08cb, B:459:0x08dc, B:461:0x08e2, B:465:0x08ef, B:467:0x08f7, B:469:0x08fb, B:470:0x0906, B:472:0x090c, B:525:0x0a27, B:528:0x0a2e, B:530:0x0a32, B:532:0x0a3a, B:533:0x0a3d, B:534:0x0a40, B:536:0x0a46, B:538:0x0a4f, B:540:0x0a59, B:542:0x0a5f, B:544:0x0a6a, B:551:0x0a8e, B:553:0x0a94, B:557:0x0a9e, B:567:0x0ab8, B:564:0x0aaf, B:566:0x0ab3, B:545:0x0a71, B:548:0x0a7f, B:549:0x0a86, B:550:0x0a87, B:473:0x0917, B:475:0x091d, B:477:0x0921, B:504:0x09c9, B:506:0x09d5, B:507:0x09e2, B:509:0x09e9, B:511:0x09ed, B:515:0x09f6, B:517:0x0a05, B:519:0x0a0b, B:521:0x0a15, B:522:0x0a1a, B:523:0x0a1f, B:524:0x0a24, B:480:0x092f, B:482:0x0933, B:484:0x0945, B:486:0x0953, B:488:0x095d, B:492:0x0966, B:494:0x0970, B:500:0x097b, B:458:0x08d5, B:378:0x0781, B:380:0x0785, B:382:0x078b, B:384:0x0791, B:386:0x079b, B:389:0x07a1, B:390:0x07a4, B:392:0x07ad, B:394:0x07bf, B:396:0x07c8, B:398:0x07d0, B:403:0x07dc, B:405:0x0806, B:407:0x080c, B:409:0x0811, B:410:0x0819, B:412:0x0820, B:413:0x0823, B:414:0x082c, B:416:0x0830, B:418:0x0836, B:419:0x083b, B:422:0x0847, B:569:0x0ac0, B:573:0x0acc), top: B:653:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:416:0x0830 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x0760, TryCatch #18 {zzin -> 0x0760, blocks: (B:363:0x0745, B:365:0x074b, B:367:0x0753, B:370:0x0768, B:371:0x076b, B:375:0x0777, B:423:0x0848, B:427:0x0856, B:432:0x0863, B:434:0x086b, B:435:0x0871, B:437:0x087f, B:438:0x0899, B:440:0x089d, B:442:0x08a5, B:457:0x08cf, B:443:0x08a9, B:445:0x08b2, B:449:0x08bb, B:455:0x08cb, B:459:0x08dc, B:461:0x08e2, B:465:0x08ef, B:467:0x08f7, B:469:0x08fb, B:470:0x0906, B:472:0x090c, B:525:0x0a27, B:528:0x0a2e, B:530:0x0a32, B:532:0x0a3a, B:533:0x0a3d, B:534:0x0a40, B:536:0x0a46, B:538:0x0a4f, B:540:0x0a59, B:542:0x0a5f, B:544:0x0a6a, B:551:0x0a8e, B:553:0x0a94, B:557:0x0a9e, B:567:0x0ab8, B:564:0x0aaf, B:566:0x0ab3, B:545:0x0a71, B:548:0x0a7f, B:549:0x0a86, B:550:0x0a87, B:473:0x0917, B:475:0x091d, B:477:0x0921, B:504:0x09c9, B:506:0x09d5, B:507:0x09e2, B:509:0x09e9, B:511:0x09ed, B:515:0x09f6, B:517:0x0a05, B:519:0x0a0b, B:521:0x0a15, B:522:0x0a1a, B:523:0x0a1f, B:524:0x0a24, B:480:0x092f, B:482:0x0933, B:484:0x0945, B:486:0x0953, B:488:0x095d, B:492:0x0966, B:494:0x0970, B:500:0x097b, B:458:0x08d5, B:378:0x0781, B:380:0x0785, B:382:0x078b, B:384:0x0791, B:386:0x079b, B:389:0x07a1, B:390:0x07a4, B:392:0x07ad, B:394:0x07bf, B:396:0x07c8, B:398:0x07d0, B:403:0x07dc, B:405:0x0806, B:407:0x080c, B:409:0x0811, B:410:0x0819, B:412:0x0820, B:413:0x0823, B:414:0x082c, B:416:0x0830, B:418:0x0836, B:419:0x083b, B:422:0x0847, B:569:0x0ac0, B:573:0x0acc), top: B:653:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:418:0x0836 A[Catch: IOException -> 0x002a, zzuh -> 0x002e, zzgk -> 0x0032, zzaz -> 0x0036, zzsa -> 0x003a, RuntimeException -> 0x0629, zzin -> 0x0760, TryCatch #18 {zzin -> 0x0760, blocks: (B:363:0x0745, B:365:0x074b, B:367:0x0753, B:370:0x0768, B:371:0x076b, B:375:0x0777, B:423:0x0848, B:427:0x0856, B:432:0x0863, B:434:0x086b, B:435:0x0871, B:437:0x087f, B:438:0x0899, B:440:0x089d, B:442:0x08a5, B:457:0x08cf, B:443:0x08a9, B:445:0x08b2, B:449:0x08bb, B:455:0x08cb, B:459:0x08dc, B:461:0x08e2, B:465:0x08ef, B:467:0x08f7, B:469:0x08fb, B:470:0x0906, B:472:0x090c, B:525:0x0a27, B:528:0x0a2e, B:530:0x0a32, B:532:0x0a3a, B:533:0x0a3d, B:534:0x0a40, B:536:0x0a46, B:538:0x0a4f, B:540:0x0a59, B:542:0x0a5f, B:544:0x0a6a, B:551:0x0a8e, B:553:0x0a94, B:557:0x0a9e, B:567:0x0ab8, B:564:0x0aaf, B:566:0x0ab3, B:545:0x0a71, B:548:0x0a7f, B:549:0x0a86, B:550:0x0a87, B:473:0x0917, B:475:0x091d, B:477:0x0921, B:504:0x09c9, B:506:0x09d5, B:507:0x09e2, B:509:0x09e9, B:511:0x09ed, B:515:0x09f6, B:517:0x0a05, B:519:0x0a0b, B:521:0x0a15, B:522:0x0a1a, B:523:0x0a1f, B:524:0x0a24, B:480:0x092f, B:482:0x0933, B:484:0x0945, B:486:0x0953, B:488:0x095d, B:492:0x0966, B:494:0x0970, B:500:0x097b, B:458:0x08d5, B:378:0x0781, B:380:0x0785, B:382:0x078b, B:384:0x0791, B:386:0x079b, B:389:0x07a1, B:390:0x07a4, B:392:0x07ad, B:394:0x07bf, B:396:0x07c8, B:398:0x07d0, B:403:0x07dc, B:405:0x0806, B:407:0x080c, B:409:0x0811, B:410:0x0819, B:412:0x0820, B:413:0x0823, B:414:0x082c, B:416:0x0830, B:418:0x0836, B:419:0x083b, B:422:0x0847, B:569:0x0ac0, B:573:0x0acc), top: B:653:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:695:0x083b A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r22v12 */
    /* JADX WARN: Type inference failed for: r22v13 */
    /* JADX WARN: Type inference failed for: r22v14 */
    /* JADX WARN: Type inference failed for: r22v15 */
    /* JADX WARN: Type inference failed for: r22v16 */
    /* JADX WARN: Type inference failed for: r22v18 */
    /* JADX WARN: Type inference failed for: r22v19, types: [long] */
    /* JADX WARN: Type inference failed for: r22v9 */
    /* JADX WARN: Type inference failed for: r41v0, types: [com.google.android.gms.internal.ads.zzkt, com.google.android.gms.internal.ads.zzve] */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:376:0x077b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message r42) {
        /*
            Method dump skipped, instruction units count: 3208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkt.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final void zza(int i) {
        this.zzi.zzd(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzia
    public final void zzb(float f) {
        this.zzi.zzj(34);
    }

    @Override // com.google.android.gms.internal.ads.zzik
    public final void zzc(zzbb zzbbVar) {
        this.zzi.zzc(16, zzbbVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzcT(long j, long j2, zzz zzzVar, MediaFormat mediaFormat) {
        if (this.zzC) {
            this.zzi.zzb(37).zza();
        }
    }

    public final Looper zze() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzxa
    public final /* bridge */ /* synthetic */ void zzj(zzxb zzxbVar) {
        this.zzi.zzc(9, (zzvf) zzxbVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlq
    public final void zzk() {
        zzdt zzdtVar = this.zzi;
        zzdtVar.zzg(2);
        zzdtVar.zzj(22);
    }

    @Override // com.google.android.gms.internal.ads.zzve
    public final void zzl(zzvf zzvfVar) {
        this.zzi.zzc(8, zzvfVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzm() {
        this.zzi.zzj(10);
    }

    public final void zzn() {
        this.zzi.zzb(29).zza();
    }

    public final void zzo(zzbl zzblVar, int i, long j) {
        this.zzi.zzc(3, new zzkr(zzblVar, i, j)).zza();
    }

    public final void zzq(zze zzeVar, boolean z) {
        this.zzi.zze(31, 0, 0, zzeVar).zza();
    }

    public final void zzr(boolean z, int i, int i2) {
        this.zzi.zzd(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzs(zzmh zzmhVar) {
        this.zzi.zzc(38, zzmhVar).zza();
    }

    public final void zzt(float f) {
        this.zzi.zzc(32, Float.valueOf(f)).zza();
    }

    public final void zzu() {
        this.zzi.zzb(6).zza();
    }

    public final boolean zzw() {
        if (this.zzG || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzG = true;
        zzdm zzdmVar = new zzdm(this.zzq);
        this.zzi.zzc(7, zzdmVar).zza();
        return zzdmVar.zzc(this.zzt);
    }

    public final boolean zzx(Object obj, long j) {
        if (this.zzG || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzdm zzdmVar = new zzdm(this.zzq);
        this.zzi.zzc(30, new Pair(obj, zzdmVar)).zza();
        if (j != -9223372036854775807L) {
            return zzdmVar.zzc(j);
        }
        return true;
    }

    public final void zzy(List list, int i, long j, zzxc zzxcVar) {
        this.zzi.zzc(17, new zzkn(list, zzxcVar, i, j, null)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlu
    public final void zzp(zzlw zzlwVar) {
        if (!this.zzG && this.zzk.getThread().isAlive()) {
            this.zzi.zzc(14, zzlwVar).zza();
        } else {
            zzea.zzf(UUFMQdNK.KoCiwVxmAeCNnp, "Ignoring messages sent after release.");
            zzlwVar.zzh(false);
        }
    }
}
