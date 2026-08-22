package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzwl implements zzvf, zzady, zzzs, zzzw, zzww {
    private static final Map zzb;
    private static final zzz zzc;
    private zzaeu zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private int zzH;
    private boolean zzI;
    private long zzJ;
    private boolean zzL;
    private int zzM;
    private boolean zzN;
    private boolean zzO;
    private final zzzm zzP;
    private final Uri zzd;
    private final zzgj zze;
    private final zzsh zzf;
    private final zzvr zzg;
    private final zzsc zzh;
    private final zzwh zzi;
    private final long zzj;
    private final long zzk;
    private final zzwa zzm;
    private zzve zzr;
    private zzagv zzs;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private zzwk zzz;
    private final zzaaa zzl = new zzaaa("ProgressiveMediaPeriod");
    private final zzdm zzn = new zzdm(zzdj.zza);
    private final Runnable zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzwc
        @Override // java.lang.Runnable
        public final void run() {
            this.zza.zzV();
        }
    };
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzwd
        @Override // java.lang.Runnable
        public final void run() {
            zzwl.zzA(this.zza);
        }
    };
    private final Handler zzq = zzex.zzy(null);
    private zzwj[] zzu = new zzwj[0];
    private zzwy[] zzt = new zzwy[0];
    private long zzK = -9223372036854775807L;
    private int zzD = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzx zzxVar = new zzx();
        zzxVar.zzS("icy");
        zzxVar.zzah("application/x-icy");
        zzc = zzxVar.zzan();
    }

    public zzwl(Uri uri, zzgj zzgjVar, zzwa zzwaVar, zzsh zzshVar, zzsc zzscVar, zzzq zzzqVar, zzvr zzvrVar, zzwh zzwhVar, zzzm zzzmVar, String str, int i, int i2, zzz zzzVar, long j, zzaai zzaaiVar) {
        this.zzd = uri;
        this.zze = zzgjVar;
        this.zzf = zzshVar;
        this.zzh = zzscVar;
        this.zzg = zzvrVar;
        this.zzi = zzwhVar;
        this.zzP = zzzmVar;
        this.zzj = i;
        this.zzm = zzwaVar;
        this.zzk = j;
    }

    public static /* synthetic */ void zzA(zzwl zzwlVar) {
        if (zzwlVar.zzO) {
            return;
        }
        zzve zzveVar = zzwlVar.zzr;
        zzveVar.getClass();
        zzveVar.zzj(zzwlVar);
    }

    public static /* synthetic */ void zzC(zzwl zzwlVar, zzaeu zzaeuVar) {
        zzwlVar.zzA = zzwlVar.zzs == null ? zzaeuVar : new zzaet(-9223372036854775807L, 0L);
        zzwlVar.zzB = zzaeuVar.zza();
        boolean z = false;
        if (!zzwlVar.zzI && zzaeuVar.zza() == -9223372036854775807L) {
            z = true;
        }
        zzwlVar.zzC = z;
        zzwlVar.zzD = true == z ? 7 : 1;
        if (zzwlVar.zzw) {
            zzwlVar.zzi.zza(zzwlVar.zzB, zzaeuVar, z);
        } else {
            zzwlVar.zzV();
        }
    }

    public static /* bridge */ /* synthetic */ void zzF(final zzwl zzwlVar) {
        zzwlVar.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzwb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI = true;
            }
        });
    }

    private final int zzR() {
        int iZzd = 0;
        for (zzwy zzwyVar : this.zzt) {
            iZzd += zzwyVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    private final long zzS(boolean z) {
        int i = 0;
        long jMax = Long.MIN_VALUE;
        while (true) {
            zzwy[] zzwyVarArr = this.zzt;
            if (i >= zzwyVarArr.length) {
                return jMax;
            }
            if (z) {
                jMax = Math.max(jMax, zzwyVarArr[i].zzh());
            } else {
                zzwk zzwkVar = this.zzz;
                zzwkVar.getClass();
                if (zzwkVar.zzc[i]) {
                    jMax = Math.max(jMax, zzwyVarArr[i].zzh());
                }
            }
            i++;
        }
    }

    private final zzafb zzT(zzwj zzwjVar) {
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            if (zzwjVar.equals(this.zzu[i])) {
                return this.zzt[i];
            }
        }
        if (this.zzv) {
            zzea.zzf("ProgressiveMediaPeriod", "Extractor added new track (id=" + zzwjVar.zza + ") after finishing tracks.");
            return new zzadr();
        }
        zzwy zzwyVar = new zzwy(this.zzP, this.zzf, this.zzh);
        zzwyVar.zzv(this);
        int i2 = length + 1;
        zzwj[] zzwjVarArr = (zzwj[]) Arrays.copyOf(this.zzu, i2);
        zzwjVarArr[length] = zzwjVar;
        String str = zzex.zza;
        this.zzu = zzwjVarArr;
        zzwy[] zzwyVarArr = (zzwy[]) Arrays.copyOf(this.zzt, i2);
        zzwyVarArr[length] = zzwyVar;
        this.zzt = zzwyVarArr;
        return zzwyVar;
    }

    private final void zzU() {
        zzdd.zzf(this.zzw);
        this.zzz.getClass();
        this.zzA.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzV() {
        int i;
        if (this.zzO || this.zzw || !this.zzv || this.zzA == null) {
            return;
        }
        for (zzwy zzwyVar : this.zzt) {
            if (zzwyVar.zzi() == null) {
                return;
            }
        }
        this.zzn.zzd();
        int length = this.zzt.length;
        zzbm[] zzbmVarArr = new zzbm[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzz zzzVarZzi = this.zzt[i2].zzi();
            zzzVarZzi.getClass();
            String str = zzzVarZzi.zzo;
            boolean zZzh = zzay.zzh(str);
            boolean z = zZzh || zzay.zzj(str);
            zArr[i2] = z;
            this.zzx = z | this.zzx;
            this.zzy = this.zzk != -9223372036854775807L && length == 1 && zzay.zzi(str);
            zzagv zzagvVar = this.zzs;
            if (zzagvVar != null) {
                if (zZzh || this.zzu[i2].zzb) {
                    zzav zzavVar = zzzVarZzi.zzl;
                    zzav zzavVar2 = zzavVar == null ? new zzav(-9223372036854775807L, zzagvVar) : zzavVar.zzc(zzagvVar);
                    zzx zzxVarZzb = zzzVarZzi.zzb();
                    zzxVarZzb.zzaa(zzavVar2);
                    zzzVarZzi = zzxVarZzb.zzan();
                }
                if (zZzh && zzzVarZzi.zzh == -1 && zzzVarZzi.zzi == -1 && (i = zzagvVar.zza) != -1) {
                    zzx zzxVarZzb2 = zzzVarZzi.zzb();
                    zzxVarZzb2.zzC(i);
                    zzzVarZzi = zzxVarZzb2.zzan();
                }
            }
            zzz zzzVarZzc = zzzVarZzi.zzc(this.zzf.zza(zzzVarZzi));
            zzbmVarArr[i2] = new zzbm(Integer.toString(i2), zzzVarZzc);
            this.zzG = zzzVarZzc.zzu | this.zzG;
        }
        this.zzz = new zzwk(new zzxk(zzbmVarArr), zArr);
        if (this.zzy && this.zzB == -9223372036854775807L) {
            this.zzB = this.zzk;
            this.zzA = new zzwf(this, this.zzA);
        }
        this.zzi.zza(this.zzB, this.zzA, this.zzC);
        this.zzw = true;
        zzve zzveVar = this.zzr;
        zzveVar.getClass();
        zzveVar.zzl(this);
    }

    private final void zzW(int i) {
        zzU();
        zzwk zzwkVar = this.zzz;
        boolean[] zArr = zzwkVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzz zzzVarZzb = zzwkVar.zza.zzb(i).zzb(0);
        this.zzg.zzd(new zzvd(1, zzay.zzb(zzzVarZzb.zzo), zzzVarZzb, 0, null, zzex.zzv(this.zzJ), -9223372036854775807L));
        zArr[i] = true;
    }

    private final void zzX(int i) {
        zzU();
        if (this.zzL) {
            if ((!this.zzx || this.zzz.zzb[i]) && !this.zzt[i].zzy(false)) {
                this.zzK = 0L;
                this.zzL = false;
                this.zzF = true;
                this.zzJ = 0L;
                this.zzM = 0;
                for (zzwy zzwyVar : this.zzt) {
                    zzwyVar.zzq(false);
                }
                zzve zzveVar = this.zzr;
                zzveVar.getClass();
                zzveVar.zzj(this);
            }
        }
    }

    private final void zzY() {
        zzwg zzwgVar = new zzwg(this, this.zzd, this.zze, this.zzm, this, this.zzn);
        if (this.zzw) {
            zzdd.zzf(zzZ());
            long j = this.zzB;
            if (j != -9223372036854775807L && this.zzK > j) {
                this.zzN = true;
                this.zzK = -9223372036854775807L;
                return;
            }
            zzaeu zzaeuVar = this.zzA;
            zzaeuVar.getClass();
            zzwg.zzf(zzwgVar, zzaeuVar.zzg(this.zzK).zza.zzc, this.zzK);
            for (zzwy zzwyVar : this.zzt) {
                zzwyVar.zzu(this.zzK);
            }
            this.zzK = -9223372036854775807L;
        }
        this.zzM = zzR();
        this.zzl.zza(zzwgVar, this, zzzq.zza(this.zzD));
    }

    private final boolean zzZ() {
        return this.zzK != -9223372036854775807L;
    }

    private final boolean zzaa() {
        return this.zzF || zzZ();
    }

    public static /* bridge */ /* synthetic */ long zzr(zzwl zzwlVar, boolean z) {
        return zzwlVar.zzS(true);
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzG() {
        this.zzv = true;
        this.zzq.post(this.zzo);
    }

    public final void zzH() throws IOException {
        this.zzl.zzi(zzzq.zza(this.zzD));
    }

    public final void zzI(int i) {
        this.zzt[i].zzn();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final /* bridge */ /* synthetic */ void zzJ(zzzv zzzvVar, long j, long j2, boolean z) {
        zzwg zzwgVar = (zzwg) zzzvVar;
        zzhi zzhiVar = zzwgVar.zzd;
        zzuy zzuyVar = new zzuy(zzwgVar.zzb, zzwgVar.zzl, zzhiVar.zzh(), zzhiVar.zzi(), j, j2, zzhiVar.zzg());
        long unused = zzwgVar.zzb;
        this.zzg.zze(zzuyVar, new zzvd(1, -1, null, 0, null, zzex.zzv(zzwgVar.zzk), zzex.zzv(this.zzB)));
        if (z) {
            return;
        }
        for (zzwy zzwyVar : this.zzt) {
            zzwyVar.zzq(false);
        }
        if (this.zzH > 0) {
            zzve zzveVar = this.zzr;
            zzveVar.getClass();
            zzveVar.zzj(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final /* bridge */ /* synthetic */ void zzK(zzzv zzzvVar, long j, long j2) {
        zzwg zzwgVar = (zzwg) zzzvVar;
        if (this.zzB == -9223372036854775807L && this.zzA != null) {
            long jZzS = zzS(true);
            long j3 = jZzS == Long.MIN_VALUE ? 0L : jZzS + 10000;
            this.zzB = j3;
            this.zzi.zza(j3, this.zzA, this.zzC);
        }
        zzhi zzhiVar = zzwgVar.zzd;
        zzuy zzuyVar = new zzuy(zzwgVar.zzb, zzwgVar.zzl, zzhiVar.zzh(), zzhiVar.zzi(), j, j2, zzhiVar.zzg());
        long unused = zzwgVar.zzb;
        this.zzg.zzf(zzuyVar, new zzvd(1, -1, null, 0, null, zzex.zzv(zzwgVar.zzk), zzex.zzv(this.zzB)));
        this.zzN = true;
        zzve zzveVar = this.zzr;
        zzveVar.getClass();
        zzveVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final /* bridge */ /* synthetic */ void zzL(zzzv zzzvVar, long j, long j2, int i) {
        zzwg zzwgVar = (zzwg) zzzvVar;
        zzhi zzhiVar = zzwgVar.zzd;
        this.zzg.zzh(i == 0 ? new zzuy(zzwgVar.zzb, zzwgVar.zzl, j) : new zzuy(zzwgVar.zzb, zzwgVar.zzl, zzhiVar.zzh(), zzhiVar.zzi(), j, j2, zzhiVar.zzg()), new zzvd(1, -1, null, 0, null, zzex.zzv(zzwgVar.zzk), zzex.zzv(this.zzB)), i);
    }

    @Override // com.google.android.gms.internal.ads.zzzw
    public final void zzM() {
        for (zzwy zzwyVar : this.zzt) {
            zzwyVar.zzp();
        }
        this.zzm.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzww
    public final void zzN(zzz zzzVar) {
        this.zzq.post(this.zzo);
    }

    public final void zzO() {
        if (this.zzw) {
            for (zzwy zzwyVar : this.zzt) {
                zzwyVar.zzo();
            }
        }
        this.zzl.zzj(this);
        this.zzq.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzO = true;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final void zzP(final zzaeu zzaeuVar) {
        this.zzq.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzwe
            @Override // java.lang.Runnable
            public final void run() {
                zzwl.zzC(this.zza, zzaeuVar);
            }
        });
    }

    public final boolean zzQ(int i) {
        return !zzaa() && this.zzt[i].zzy(this.zzN);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zza(long j, zzmi zzmiVar) {
        zzU();
        if (!this.zzA.zzh()) {
            return 0L;
        }
        zzaes zzaesVarZzg = this.zzA.zzg(j);
        zzaev zzaevVar = zzaesVarZzg.zza;
        zzaev zzaevVar2 = zzaesVarZzg.zzb;
        long j2 = zzmiVar.zzc;
        if (j2 == 0) {
            if (zzmiVar.zzd == 0) {
                return j;
            }
            j2 = 0;
        }
        long j3 = zzaevVar.zzb;
        String str = zzex.zza;
        long j4 = j - j2;
        long j5 = zzmiVar.zzd;
        long j6 = j + j5;
        long j7 = j ^ j6;
        long j8 = j5 ^ j6;
        if (((j ^ j2) & (j ^ j4)) < 0) {
            j4 = Long.MIN_VALUE;
        }
        if ((j7 & j8) < 0) {
            j6 = Long.MAX_VALUE;
        }
        boolean z = j4 <= j3 && j3 <= j6;
        long j9 = zzaevVar2.zzb;
        boolean z2 = j4 <= j9 && j9 <= j6;
        if (z && z2) {
            if (Math.abs(j3 - j) > Math.abs(j9 - j)) {
                return j9;
            }
        } else if (!z) {
            return z2 ? j9 : j4;
        }
        return j3;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        long jZzS;
        zzU();
        if (this.zzN || this.zzH == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzK;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzS = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzwk zzwkVar = this.zzz;
                if (zzwkVar.zzb[i] && zzwkVar.zzc[i] && !this.zzt[i].zzx()) {
                    jZzS = Math.min(jZzS, this.zzt[i].zzh());
                }
            }
        } else {
            jZzS = Long.MAX_VALUE;
        }
        if (jZzS == Long.MAX_VALUE) {
            jZzS = zzS(false);
        }
        return jZzS == Long.MIN_VALUE ? this.zzJ : jZzS;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzd() {
        if (this.zzG) {
            this.zzG = false;
        } else {
            if (!this.zzF) {
                return -9223372036854775807L;
            }
            if (!this.zzN && zzR() <= this.zzM) {
                return -9223372036854775807L;
            }
            this.zzF = false;
        }
        return this.zzJ;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e A[LOOP:1: B:36:0x007c->B:37:0x007e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0093 A[LOOP:2: B:40:0x0091->B:41:0x0093, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0079, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x008a, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zze(long j) {
        zzaaa zzaaaVar;
        int i;
        zzU();
        boolean[] zArr = this.zzz.zzb;
        if (true != this.zzA.zzh()) {
            j = 0;
        }
        this.zzF = false;
        long j2 = this.zzJ;
        this.zzJ = j;
        if (zzZ()) {
            this.zzK = j;
            return j;
        }
        if (this.zzD == 7 || !(this.zzN || this.zzl.zzl())) {
            this.zzL = false;
            this.zzK = j;
            this.zzN = false;
            this.zzG = false;
            zzaaaVar = this.zzl;
            if (zzaaaVar.zzl()) {
                zzaaaVar.zzh();
                for (zzwy zzwyVar : this.zzt) {
                    zzwyVar.zzq(false);
                }
                break;
            }
            for (zzwy zzwyVar2 : this.zzt) {
                zzwyVar2.zzk();
            }
            zzaaaVar.zzg();
            break;
        }
        int length = this.zzt.length;
        for (int i2 = 0; i2 < length; i2++) {
            zzwy zzwyVar3 = this.zzt[i2];
            if (zzwyVar3.zzb() != 0 || j2 != j) {
                if (!(this.zzy ? zzwyVar3.zzz(zzwyVar3.zza()) : zzwyVar3.zzA(j, this.zzN)) && (zArr[i2] || !this.zzx)) {
                    this.zzL = false;
                    this.zzK = j;
                    this.zzN = false;
                    this.zzG = false;
                    zzaaaVar = this.zzl;
                    if (zzaaaVar.zzl()) {
                        zzaaaVar.zzh();
                        while (i < r2) {
                            zzwyVar.zzq(false);
                        }
                        break;
                        break;
                    }
                    while (i < r3) {
                        zzwyVar2.zzk();
                    }
                    zzaaaVar.zzg();
                    break;
                }
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final long zzf(zzyw[] zzywVarArr, boolean[] zArr, zzwz[] zzwzVarArr, boolean[] zArr2, long j) {
        zzyw zzywVar;
        zzU();
        zzwk zzwkVar = this.zzz;
        zzxk zzxkVar = zzwkVar.zza;
        boolean[] zArr3 = zzwkVar.zzc;
        int i = this.zzH;
        int i2 = 0;
        for (int i3 = 0; i3 < zzywVarArr.length; i3++) {
            zzwz zzwzVar = zzwzVarArr[i3];
            if (zzwzVar != null && (zzywVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((zzwi) zzwzVar).zzb;
                zzdd.zzf(zArr3[i4]);
                this.zzH--;
                zArr3[i4] = false;
                zzwzVarArr[i3] = null;
            }
        }
        boolean z = !this.zzE ? j == 0 || this.zzy : i != 0;
        for (int i5 = 0; i5 < zzywVarArr.length; i5++) {
            if (zzwzVarArr[i5] == null && (zzywVar = zzywVarArr[i5]) != null) {
                zzdd.zzf(zzywVar.zzh() == 1);
                zzdd.zzf(zzywVar.zze(0) == 0);
                int iZza = zzxkVar.zza(zzywVar.zzc());
                zzdd.zzf(!zArr3[iZza]);
                this.zzH++;
                zArr3[iZza] = true;
                this.zzG = zzywVar.zzb().zzu | this.zzG;
                zzwzVarArr[i5] = new zzwi(this, iZza);
                zArr2[i5] = true;
                if (!z) {
                    zzwy zzwyVar = this.zzt[iZza];
                    z = (zzwyVar.zzb() == 0 || zzwyVar.zzA(j, true)) ? false : true;
                }
            }
        }
        if (this.zzH == 0) {
            this.zzL = false;
            this.zzF = false;
            this.zzG = false;
            zzaaa zzaaaVar = this.zzl;
            if (zzaaaVar.zzl()) {
                zzwy[] zzwyVarArr = this.zzt;
                int length = zzwyVarArr.length;
                while (i2 < length) {
                    zzwyVarArr[i2].zzk();
                    i2++;
                }
                zzaaaVar.zzg();
            } else {
                this.zzN = false;
                for (zzwy zzwyVar2 : this.zzt) {
                    zzwyVar2.zzq(false);
                }
            }
        } else if (z) {
            j = zze(j);
            while (i2 < zzwzVarArr.length) {
                if (zzwzVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzE = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final zzxk zzg() {
        zzU();
        return this.zzz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzh(long j, boolean z) {
        if (this.zzy) {
            return;
        }
        zzU();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzz.zzc;
        int length = this.zzt.length;
        for (int i = 0; i < length; i++) {
            this.zzt[i].zzj(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzi() throws IOException {
        zzH();
        if (this.zzN && !this.zzw) {
            throw zzaz.zza("Loading finished before preparation is complete.", null);
        }
    }

    public final int zzj(int i, zzkv zzkvVar, zzhs zzhsVar, int i2) {
        if (zzaa()) {
            return -3;
        }
        zzW(i);
        int iZze = this.zzt[i].zze(zzkvVar, zzhsVar, i2, this.zzN);
        if (iZze == -3) {
            zzX(i);
        }
        return iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzk(zzve zzveVar, long j) {
        this.zzr = zzveVar;
        this.zzn.zzf();
        zzY();
    }

    public final int zzl(int i, long j) {
        if (zzaa()) {
            return 0;
        }
        zzW(i);
        zzwy zzwyVar = this.zzt[i];
        int iZzc = zzwyVar.zzc(j, this.zzN);
        zzwyVar.zzw(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzX(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        if (this.zzN) {
            return false;
        }
        zzaaa zzaaaVar = this.zzl;
        if (zzaaaVar.zzk() || this.zzL) {
            return false;
        }
        if (this.zzw && this.zzH == 0) {
            return false;
        }
        boolean zZzf = this.zzn.zzf();
        if (zzaaaVar.zzl()) {
            return zZzf;
        }
        zzY();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvf, com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zzl.zzl() && this.zzn.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzzs
    public final /* bridge */ /* synthetic */ zzzt zzu(zzzv zzzvVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzzt zzztVarZzb;
        zzaeu zzaeuVar;
        zzwg zzwgVar = (zzwg) zzzvVar;
        zzhi zzhiVar = zzwgVar.zzd;
        zzuy zzuyVar = new zzuy(zzwgVar.zzb, zzwgVar.zzl, zzhiVar.zzh(), zzhiVar.zzi(), j, j2, zzhiVar.zzg());
        long unused = zzwgVar.zzk;
        String str = zzex.zza;
        if ((iOException instanceof zzaz) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgz) || (iOException instanceof zzzy)) {
            jMin = -9223372036854775807L;
            break;
        }
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i - 1) * 1000, 5000);
                break;
            }
            if ((cause instanceof zzgk) && ((zzgk) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == -9223372036854775807L) {
            zzztVarZzb = zzaaa.zzb;
        } else {
            int iZzR = zzR();
            boolean z = iZzR > this.zzM;
            if (this.zzI || !((zzaeuVar = this.zzA) == null || zzaeuVar.zza() == -9223372036854775807L)) {
                this.zzM = iZzR;
            } else {
                boolean z2 = this.zzw;
                if (!z2 || zzaa()) {
                    this.zzF = z2;
                    this.zzJ = 0L;
                    this.zzM = 0;
                    for (zzwy zzwyVar : this.zzt) {
                        zzwyVar.zzq(false);
                    }
                    zzwg.zzf(zzwgVar, 0L, 0L);
                } else {
                    this.zzL = true;
                    zzztVarZzb = zzaaa.zza;
                }
            }
            zzztVarZzb = zzaaa.zzb(z, jMin);
        }
        boolean zZzc = zzztVarZzb.zzc();
        this.zzg.zzg(zzuyVar, new zzvd(1, -1, null, 0, null, zzex.zzv(zzwgVar.zzk), zzex.zzv(this.zzB)), iOException, true ^ zZzc);
        if (!zZzc) {
            long unused2 = zzwgVar.zzb;
        }
        return zzztVarZzb;
    }

    public final zzafb zzv() {
        return zzT(new zzwj(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final zzafb zzw(int i, int i2) {
        return zzT(new zzwj(i, false));
    }
}
