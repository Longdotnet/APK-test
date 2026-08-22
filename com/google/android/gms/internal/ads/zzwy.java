package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzwy implements zzafb {
    private boolean zzA;
    private zzsi zzB;
    private final zzws zza;
    private final zzsh zzd;
    private final zzsc zze;
    private zzww zzf;
    private zzz zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;
    private zzz zzy;
    private final zzwu zzb = new zzwu();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzafa[] zzn = new zzafa[1000];
    private final zzxf zzc = new zzxf(new zzdn() { // from class: com.google.android.gms.internal.ads.zzwt
        @Override // com.google.android.gms.internal.ads.zzdn
        public final void zza(Object obj) {
            zzsg zzsgVar = ((zzwv) obj).zzb;
        }
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;
    private boolean zzz = true;

    public zzwy(zzzm zzzmVar, zzsh zzshVar, zzsc zzscVar) {
        this.zzd = zzshVar;
        this.zze = zzscVar;
        this.zza = new zzws(zzzmVar);
    }

    private final int zzB(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzm[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzl[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.zzh) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzC(int i) {
        int i2 = this.zzq + i;
        int i3 = this.zzh;
        return i2 < i3 ? i2 : i2 - i3;
    }

    private final synchronized int zzD(zzkv zzkvVar, zzhs zzhsVar, boolean z, boolean z2, zzwu zzwuVar) {
        try {
            zzhsVar.zzd = false;
            if (!zzL()) {
                if (!z2 && !this.zzv) {
                    zzz zzzVar = this.zzy;
                    if (zzzVar == null || (!z && zzzVar == this.zzg)) {
                        return -3;
                    }
                    zzI(zzzVar, zzkvVar);
                    return -5;
                }
                zzhsVar.zzc(4);
                zzhsVar.zze = Long.MIN_VALUE;
                return -4;
            }
            zzz zzzVar2 = ((zzwv) this.zzc.zza(this.zzp + this.zzr)).zza;
            if (!z && zzzVar2 == this.zzg) {
                int iZzC = zzC(this.zzr);
                if (!zzM(iZzC)) {
                    zzhsVar.zzd = true;
                    return -3;
                }
                zzhsVar.zzc(this.zzl[iZzC]);
                if (this.zzr == this.zzo - 1 && (z2 || this.zzv)) {
                    zzhsVar.zza(536870912);
                }
                zzhsVar.zze = this.zzm[iZzC];
                zzwuVar.zza = this.zzk[iZzC];
                zzwuVar.zzb = this.zzj[iZzC];
                zzwuVar.zzc = this.zzn[iZzC];
                return -4;
            }
            zzI(zzzVar2, zzkvVar);
            return -5;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized long zzE(long j, boolean z, boolean z2) {
        int i;
        try {
            int i2 = this.zzo;
            if (i2 != 0) {
                long[] jArr = this.zzm;
                int i3 = this.zzq;
                if (j >= jArr[i3]) {
                    if (z2 && (i = this.zzr) != i2) {
                        i2 = i + 1;
                    }
                    int iZzB = zzB(i3, i2, j, false);
                    if (iZzB != -1) {
                        return zzG(iZzB);
                    }
                }
            }
            return -1L;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized long zzF() {
        int i = this.zzo;
        if (i == 0) {
            return -1L;
        }
        return zzG(i);
    }

    private final long zzG(int i) {
        long j = this.zzt;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int iZzC = zzC(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                jMax = Math.max(jMax, this.zzm[iZzC]);
                if ((this.zzl[iZzC] & 1) != 0) {
                    break;
                }
                iZzC--;
                if (iZzC == -1) {
                    iZzC = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j, jMax);
        this.zzo -= i;
        int i3 = this.zzp + i;
        this.zzp = i3;
        int i4 = this.zzq + i;
        this.zzq = i4;
        int i5 = this.zzh;
        if (i4 >= i5) {
            this.zzq = i4 - i5;
        }
        int i6 = this.zzr - i;
        this.zzr = i6;
        if (i6 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i3);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i7 = this.zzq;
        if (i7 == 0) {
            i7 = this.zzh;
        }
        int i8 = i7 - 1;
        return this.zzj[i8] + ((long) this.zzk[i8]);
    }

    private final synchronized void zzH(long j, int i, long j2, int i2, zzafa zzafaVar) {
        try {
            int i3 = this.zzo;
            if (i3 > 0) {
                int iZzC = zzC(i3 - 1);
                zzdd.zzd(this.zzj[iZzC] + ((long) this.zzk[iZzC]) <= j2);
            }
            this.zzv = (536870912 & i) != 0;
            this.zzu = Math.max(this.zzu, j);
            int iZzC2 = zzC(this.zzo);
            this.zzm[iZzC2] = j;
            this.zzj[iZzC2] = j2;
            this.zzk[iZzC2] = i2;
            this.zzl[iZzC2] = i;
            this.zzn[iZzC2] = zzafaVar;
            this.zzi[iZzC2] = 0;
            zzxf zzxfVar = this.zzc;
            if (zzxfVar.zzf() || !((zzwv) zzxfVar.zzb()).zza.equals(this.zzy)) {
                zzz zzzVar = this.zzy;
                if (zzzVar == null) {
                    throw null;
                }
                zzxfVar.zzc(this.zzp + this.zzo, new zzwv(zzzVar, this.zzd.zzb(this.zze, zzzVar), null));
            }
            int i4 = this.zzo + 1;
            this.zzo = i4;
            int i5 = this.zzh;
            if (i4 == i5) {
                int i6 = i5 + 1000;
                long[] jArr = new long[i6];
                long[] jArr2 = new long[i6];
                long[] jArr3 = new long[i6];
                int[] iArr = new int[i6];
                int[] iArr2 = new int[i6];
                zzafa[] zzafaVarArr = new zzafa[i6];
                int i7 = this.zzq;
                int i8 = i5 - i7;
                System.arraycopy(this.zzj, i7, jArr2, 0, i8);
                System.arraycopy(this.zzm, this.zzq, jArr3, 0, i8);
                System.arraycopy(this.zzl, this.zzq, iArr, 0, i8);
                System.arraycopy(this.zzk, this.zzq, iArr2, 0, i8);
                System.arraycopy(this.zzn, this.zzq, zzafaVarArr, 0, i8);
                System.arraycopy(this.zzi, this.zzq, jArr, 0, i8);
                int i9 = this.zzq;
                System.arraycopy(this.zzj, 0, jArr2, i8, i9);
                System.arraycopy(this.zzm, 0, jArr3, i8, i9);
                System.arraycopy(this.zzl, 0, iArr, i8, i9);
                System.arraycopy(this.zzk, 0, iArr2, i8, i9);
                System.arraycopy(this.zzn, 0, zzafaVarArr, i8, i9);
                System.arraycopy(this.zzi, 0, jArr, i8, i9);
                this.zzj = jArr2;
                this.zzm = jArr3;
                this.zzl = iArr;
                this.zzk = iArr2;
                this.zzn = zzafaVarArr;
                this.zzi = jArr;
                this.zzq = 0;
                this.zzh = i6;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void zzI(zzz zzzVar, zzkv zzkvVar) {
        zzz zzzVar2 = this.zzg;
        zzs zzsVar = zzzVar2 == null ? null : zzzVar2.zzs;
        this.zzg = zzzVar;
        zzs zzsVar2 = zzzVar.zzs;
        zzsh zzshVar = this.zzd;
        zzkvVar.zza = zzzVar.zzc(zzshVar.zza(zzzVar));
        zzkvVar.zzb = this.zzB;
        if (zzzVar2 == null || !Objects.equals(zzsVar, zzsVar2)) {
            zzsi zzsiVarZzc = zzshVar.zzc(this.zze, zzzVar);
            this.zzB = zzsiVarZzc;
            zzkvVar.zzb = zzsiVarZzc;
        }
    }

    private final void zzJ() {
        if (this.zzB != null) {
            this.zzB = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzK() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzL() {
        return this.zzr != this.zzo;
    }

    private final boolean zzM(int i) {
        if (this.zzB != null) {
            return (this.zzl[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzN(zzz zzzVar) {
        try {
            this.zzx = false;
            if (Objects.equals(zzzVar, this.zzy)) {
                return false;
            }
            zzxf zzxfVar = this.zzc;
            if (zzxfVar.zzf() || !((zzwv) zzxfVar.zzb()).zza.equals(zzzVar)) {
                this.zzy = zzzVar;
            } else {
                this.zzy = ((zzwv) zzxfVar.zzb()).zza;
            }
            boolean z = this.zzz;
            zzz zzzVar2 = this.zzy;
            this.zzz = z & zzay.zzf(zzzVar2.zzo, zzzVar2.zzk);
            this.zzA = false;
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x002e A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046 A[EDGE_INSN: B:25:0x0046->B:28:0x0054 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0047 A[EDGE_INSN: B:26:0x0047->B:28:0x0054 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:27:0x0049 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x003d A[SYNTHETIC] */
    public final synchronized boolean zzA(long j, boolean z) {
        int iZzB;
        int i;
        try {
            zzK();
            int i2 = this.zzr;
            int iZzC = zzC(i2);
            if (zzL() && j >= this.zzm[iZzC]) {
                if (j <= this.zzu) {
                    if (this.zzz) {
                        iZzB = this.zzo - i2;
                        i = 0;
                        while (true) {
                            if (i < iZzB) {
                                if (z) {
                                    iZzB = -1;
                                    break;
                                }
                                break;
                            }
                            if (this.zzm[iZzC] < j) {
                                iZzB = i;
                                break;
                            }
                            iZzC++;
                            if (iZzC == this.zzh) {
                                iZzC = 0;
                            }
                            i++;
                        }
                    } else {
                        iZzB = zzB(iZzC, this.zzo - i2, j, true);
                    }
                    if (iZzB == -1) {
                        this.zzs = j;
                        this.zzr += iZzB;
                        return true;
                    }
                } else if (z) {
                    z = true;
                    if (this.zzz) {
                        iZzB = this.zzo - i2;
                        i = 0;
                        while (true) {
                            if (i < iZzB) {
                                if (z) {
                                    iZzB = -1;
                                    break;
                                }
                                break;
                                break;
                            }
                            if (this.zzm[iZzC] < j) {
                                iZzB = i;
                                break;
                            }
                            iZzC++;
                            if (iZzC == this.zzh) {
                                iZzC = 0;
                            }
                            i++;
                        }
                    } else {
                        iZzB = zzB(iZzC, this.zzo - i2, j, true);
                    }
                    if (iZzB == -1) {
                        this.zzs = j;
                        this.zzr += iZzB;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzc(long j, boolean z) {
        int i = this.zzr;
        int iZzC = zzC(i);
        if (zzL() && j >= this.zzm[iZzC]) {
            if (j > this.zzu && z) {
                return this.zzo - i;
            }
            int iZzB = zzB(iZzC, this.zzo - i, j, true);
            if (iZzB == -1) {
                return 0;
            }
            return iZzB;
        }
        return 0;
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r9 != 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(com.google.android.gms.internal.ads.zzkv r9, com.google.android.gms.internal.ads.zzhs r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = r1
            goto L9
        L7:
            r0 = 0
            r5 = r0
        L9:
            com.google.android.gms.internal.ads.zzwu r0 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            r7 = r0
            int r9 = r2.zzD(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3b
            boolean r9 = r10.zzf()
            if (r9 != 0) goto L2a
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L32
            if (r9 == 0) goto L2c
            com.google.android.gms.internal.ads.zzws r9 = r8.zza
            r9.zzd(r10, r0)
        L2a:
            r9 = r12
            goto L3b
        L2c:
            com.google.android.gms.internal.ads.zzws r9 = r8.zza
            r9.zze(r10, r0)
            goto L35
        L32:
            if (r9 == 0) goto L35
            goto L2a
        L35:
            int r9 = r8.zzr
            int r9 = r9 + r1
            r8.zzr = r9
            return r12
        L3b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwy.zze(com.google.android.gms.internal.ads.zzkv, com.google.android.gms.internal.ads.zzhs, int, boolean):int");
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ int zzf(zzl zzlVar, int i, boolean z) {
        return zzaez.zza(this, zzlVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final int zzg(zzl zzlVar, int i, boolean z, int i2) {
        return this.zza.zza(zzlVar, i, z);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    public final synchronized zzz zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzy;
    }

    public final void zzj(long j, boolean z, boolean z2) {
        this.zza.zzc(zzE(j, false, z2));
    }

    public final void zzk() {
        this.zza.zzc(zzF());
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzl(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzm(zzz zzzVar) {
        boolean zZzN = zzN(zzzVar);
        zzww zzwwVar = this.zzf;
        if (zzwwVar == null || !zZzN) {
            return;
        }
        zzwwVar.zzN(zzzVar);
    }

    public final void zzn() throws zzsa {
        zzsi zzsiVar = this.zzB;
        if (zzsiVar != null) {
            throw zzsiVar.zza();
        }
    }

    public final void zzo() {
        zzk();
        zzJ();
    }

    public final void zzp() {
        zzq(true);
        zzJ();
    }

    public final void zzq(boolean z) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z) {
            this.zzy = null;
            this.zzx = true;
            this.zzz = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final /* synthetic */ void zzr(zzen zzenVar, int i) {
        zzaez.zzb(this, zzenVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzs(zzen zzenVar, int i, int i2) {
        this.zza.zzh(zzenVar, i);
    }

    public final void zzu(long j) {
        this.zzs = j;
    }

    public final void zzv(zzww zzwwVar) {
        this.zzf = zzwwVar;
    }

    public final synchronized void zzw(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzr + i <= this.zzo) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzdd.zzd(z);
        this.zzr += i;
    }

    public final synchronized boolean zzx() {
        return this.zzv;
    }

    public final synchronized boolean zzy(boolean z) {
        boolean z2 = true;
        if (zzL()) {
            if (((zzwv) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
                return true;
            }
            return zzM(zzC(this.zzr));
        }
        if (!z && !this.zzv) {
            zzz zzzVar = this.zzy;
            if (zzzVar == null) {
                z2 = false;
            } else if (zzzVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    public final synchronized boolean zzz(int i) {
        zzK();
        int i2 = this.zzp;
        if (i >= i2 && i <= this.zzo + i2) {
            this.zzs = Long.MIN_VALUE;
            this.zzr = i - i2;
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafb
    public final void zzt(long j, int i, int i2, int i3, zzafa zzafaVar) {
        if (this.zzw) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzw = false;
            }
        }
        if (this.zzz) {
            if (j < this.zzs) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzA) {
                    zzea.zzf(ZRqOdXiy.BvOS, "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzy)));
                    this.zzA = true;
                }
                i |= 1;
            }
        }
        int i4 = i;
        zzH(j, i4, (this.zza.zzb() - ((long) i2)) - ((long) i3), i2, zzafaVar);
    }
}
