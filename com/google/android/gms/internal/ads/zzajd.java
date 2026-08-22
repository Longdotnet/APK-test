package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzajd implements zzadv {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzz zzb;
    private long zzA;
    private long zzB;
    private zzajc zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzady zzI;
    private zzafb[] zzJ;
    private zzafb[] zzK;
    private boolean zzL;
    private long zzM;
    private final zzakr zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzen zzg;
    private final zzen zzh;
    private final zzen zzi;
    private final byte[] zzj;
    private final zzen zzk;
    private final zzags zzl;
    private final zzen zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzfz zzp;
    private final zzadj zzq;
    private zzfyq zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzen zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        zzx zzxVar = new zzx();
        zzxVar.zzah("application/x-emsg");
        zzb = zzxVar.zzan();
    }

    @Deprecated
    public zzajd() {
        this(zzakr.zza, 32, null, null, zzfyq.zzn(), null);
    }

    private static int zzg(int i) throws zzaz {
        if (i >= 0) {
            return i;
        }
        throw zzaz.zza("Unexpected negative value: " + i, null);
    }

    private static Pair zzh(zzen zzenVar, long j) throws zzaz {
        long jZzw;
        long jZzw2;
        zzenVar.zzL(8);
        int iZza = zzaix.zza(zzenVar.zzg());
        zzenVar.zzM(4);
        long jZzu = zzenVar.zzu();
        if (iZza == 0) {
            jZzw = zzenVar.zzu();
            jZzw2 = zzenVar.zzu();
        } else {
            jZzw = zzenVar.zzw();
            jZzw2 = zzenVar.zzw();
        }
        long j2 = jZzw;
        long j3 = jZzw2 + j;
        long jZzu2 = zzex.zzu(j2, 1000000L, jZzu, RoundingMode.DOWN);
        zzenVar.zzM(2);
        int iZzq = zzenVar.zzq();
        int[] iArr = new int[iZzq];
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        long[] jArr3 = new long[iZzq];
        long j4 = jZzu2;
        int i = 0;
        long j5 = j2;
        while (i < iZzq) {
            int iZzg = zzenVar.zzg();
            if ((Integer.MIN_VALUE & iZzg) != 0) {
                throw zzaz.zza("Unhandled indirect reference", null);
            }
            long jZzu3 = zzenVar.zzu();
            iArr[i] = iZzg & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + jZzu3;
            long[] jArr4 = jArr3;
            long[] jArr5 = jArr2;
            int i2 = iZzq;
            int[] iArr2 = iArr;
            long jZzu4 = zzex.zzu(j6, 1000000L, jZzu, RoundingMode.DOWN);
            jArr5[i] = jZzu4 - jArr4[i];
            zzenVar.zzM(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr2 = jArr5;
            jArr = jArr;
            iZzq = i2;
            jArr3 = jArr4;
            j5 = j6;
            j4 = jZzu4;
        }
        return Pair.create(Long.valueOf(jZzu2), new zzadi(iArr, jArr, jArr2, jArr3));
    }

    private final void zzk() {
        this.zzs = 0;
        this.zzv = 0;
    }

    private static void zzl(zzen zzenVar, int i, zzajr zzajrVar) throws zzaz {
        zzenVar.zzL(i + 8);
        int iZzg = zzenVar.zzg();
        int i2 = zzaix.zza;
        if ((iZzg & 1) != 0) {
            throw zzaz.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzg & 2) != 0;
        int iZzp = zzenVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzajrVar.zzl, 0, zzajrVar.zze, false);
            return;
        }
        int i3 = zzajrVar.zze;
        if (iZzp != i3) {
            throw zzaz.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i3, null);
        }
        Arrays.fill(zzajrVar.zzl, 0, iZzp, z);
        zzajrVar.zza(zzenVar.zza());
        zzen zzenVar2 = zzajrVar.zzn;
        zzenVar.zzH(zzenVar2.zzN(), 0, zzenVar2.zzd());
        zzenVar2.zzL(0);
        zzajrVar.zzo = false;
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0375  */
    /* JADX WARN: Code duplicated, block: B:136:0x037c  */
    /* JADX WARN: Code duplicated, block: B:139:0x038d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x038f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0398  */
    /* JADX WARN: Code duplicated, block: B:144:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:145:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:148:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:149:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:150:0x03bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x03be  */
    /* JADX WARN: Code duplicated, block: B:152:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:153:0x03c3 A[PHI: r11
  0x03c3: PHI (r11v16 int) = (r11v14 int), (r11v17 int) binds: [B:149:0x03ba, B:152:0x03c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:155:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:156:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:159:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:160:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:163:0x0410 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x0412 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:165:0x0414  */
    /* JADX WARN: Code duplicated, block: B:166:0x0417  */
    /* JADX WARN: Code duplicated, block: B:167:0x0419  */
    /* JADX WARN: Code duplicated, block: B:89:0x025f  */
    private final void zzm(long j) throws zzaz {
        zzajd zzajdVar;
        int i;
        SparseArray sparseArray;
        int i2;
        int i3;
        zzfc zzfcVar;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bArr;
        byte[] bArr2;
        int i8;
        boolean z;
        List list;
        int i9;
        byte[] bArr3;
        int i10;
        int i11;
        int i12;
        int i13;
        long j2;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        boolean z2;
        int i14;
        boolean z3;
        long j3;
        long j4;
        int iZzg;
        int iZzg2;
        int iZzg3;
        int iZzg4;
        long jZzu;
        zzajc zzajcVar;
        boolean z4;
        long[] jArr2;
        int i15;
        final zzajd zzajdVar2 = this;
        int i16 = 8;
        while (true) {
            ArrayDeque arrayDeque = zzajdVar2.zzn;
            if (arrayDeque.isEmpty() || ((zzfc) arrayDeque.peek()).zza != j) {
                break;
            }
            zzfc zzfcVar2 = (zzfc) arrayDeque.pop();
            int i17 = zzfcVar2.zzd;
            int i18 = 12;
            if (i17 == 1836019574) {
                zzs zzsVarZzj = zzj(zzfcVar2.zzb);
                zzfc zzfcVarZza = zzfcVar2.zza(1836475768);
                zzfcVarZza.getClass();
                SparseArray sparseArray2 = new SparseArray();
                List list2 = zzfcVarZza.zzb;
                int size = list2.size();
                long jZzu2 = -9223372036854775807L;
                int i19 = 0;
                while (i19 < size) {
                    zzfd zzfdVar = (zzfd) list2.get(i19);
                    int i20 = zzfdVar.zzd;
                    if (i20 == 1953654136) {
                        zzen zzenVar = zzfdVar.zza;
                        zzenVar.zzL(i18);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzenVar.zzg()), new zzaiy(zzenVar.zzg() - 1, zzenVar.zzg(), zzenVar.zzg(), zzenVar.zzg()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (zzaiy) pairCreate.second);
                    } else if (i20 == 1835362404) {
                        zzen zzenVar2 = zzfdVar.zza;
                        zzenVar2.zzL(i16);
                        jZzu2 = zzaix.zza(zzenVar2.zzg()) == 0 ? zzenVar2.zzu() : zzenVar2.zzw();
                    }
                    i19++;
                    i18 = 12;
                }
                List listZzf = zzaix.zzf(zzfcVar2, new zzaej(), jZzu2, zzsVarZzj, (zzajdVar2.zzd & 16) != 0, false, new zzfve(zzajdVar2) { // from class: com.google.android.gms.internal.ads.zzaiz
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj) {
                        return (zzajp) obj;
                    }
                });
                int size2 = listZzf.size();
                SparseArray sparseArray3 = zzajdVar2.zzf;
                if (sparseArray3.size() == 0) {
                    String strZza = zzajg.zza(listZzf);
                    for (int i21 = 0; i21 < size2; i21++) {
                        zzajs zzajsVar = (zzajs) listZzf.get(i21);
                        zzajp zzajpVar = zzajsVar.zza;
                        zzafb zzafbVarZzw = zzajdVar2.zzI.zzw(i21, zzajpVar.zzb);
                        long j5 = zzajpVar.zze;
                        zzafbVarZzw.zzl(j5);
                        int i22 = zzajpVar.zza;
                        sparseArray3.put(i22, new zzajc(zzafbVarZzw, zzajsVar, zzn(sparseArray2, i22), strZza));
                        zzajdVar2.zzA = Math.max(zzajdVar2.zzA, j5);
                    }
                    zzajdVar2.zzI.zzG();
                } else {
                    zzdd.zzf(sparseArray3.size() == size2);
                    for (int i23 = 0; i23 < size2; i23++) {
                        zzajs zzajsVar2 = (zzajs) listZzf.get(i23);
                        int i24 = zzajsVar2.zza.zza;
                        ((zzajc) sparseArray3.get(i24)).zzh(zzajsVar2, zzn(sparseArray2, i24));
                    }
                }
            } else {
                int i25 = 0;
                if (i17 == 1836019558) {
                    SparseArray sparseArray4 = zzajdVar2.zzf;
                    int i26 = zzajdVar2.zzd;
                    byte[] bArr4 = zzajdVar2.zzj;
                    List list3 = zzfcVar2.zzc;
                    int size3 = list3.size();
                    int i27 = 0;
                    while (i27 < size3) {
                        zzfc zzfcVar3 = (zzfc) list3.get(i27);
                        if (zzfcVar3.zzd == 1953653094) {
                            zzfd zzfdVarZzb = zzfcVar3.zzb(1952868452);
                            zzfdVarZzb.getClass();
                            zzen zzenVar3 = zzfdVarZzb.zza;
                            zzenVar3.zzL(i16);
                            int iZzg5 = zzenVar3.zzg();
                            int i28 = zzaix.zza;
                            zzajc zzajcVar2 = (zzajc) sparseArray4.get(zzenVar3.zzg());
                            if (zzajcVar2 == null) {
                                zzajcVar2 = null;
                            } else {
                                if ((iZzg5 & 1) != 0) {
                                    long jZzw = zzenVar3.zzw();
                                    zzajr zzajrVar = zzajcVar2.zzb;
                                    zzajrVar.zzb = jZzw;
                                    zzajrVar.zzc = jZzw;
                                }
                                zzaiy zzaiyVar = zzajcVar2.zze;
                                zzajcVar2.zzb.zza = new zzaiy((iZzg5 & 2) != 0 ? zzenVar3.zzg() - 1 : zzaiyVar.zza, (iZzg5 & 8) != 0 ? zzenVar3.zzg() : zzaiyVar.zzb, (iZzg5 & 16) != 0 ? zzenVar3.zzg() : zzaiyVar.zzc, (iZzg5 & 32) != 0 ? zzenVar3.zzg() : zzaiyVar.zzd);
                            }
                            if (zzajcVar2 == null) {
                                sparseArray = sparseArray4;
                                i2 = i26;
                                i3 = size3;
                                zzfcVar = zzfcVar2;
                                i4 = i27;
                                i6 = 8;
                                i5 = 0;
                            } else {
                                zzajr zzajrVar2 = zzajcVar2.zzb;
                                long j6 = zzajrVar2.zzp;
                                boolean z5 = zzajrVar2.zzq;
                                zzajcVar2.zzi();
                                zzajcVar2.zzm = true;
                                zzfd zzfdVarZzb2 = zzfcVar3.zzb(1952867444);
                                if (zzfdVarZzb2 == null || (i26 & 2) != 0) {
                                    zzajrVar2.zzp = j6;
                                    zzajrVar2.zzq = z5;
                                } else {
                                    zzen zzenVar4 = zzfdVarZzb2.zza;
                                    zzenVar4.zzL(8);
                                    zzajrVar2.zzp = zzaix.zza(zzenVar4.zzg()) == 1 ? zzenVar4.zzw() : zzenVar4.zzu();
                                    zzajrVar2.zzq = true;
                                }
                                List list4 = zzfcVar3.zzb;
                                int size4 = list4.size();
                                int i29 = 0;
                                int i30 = 0;
                                int i31 = 0;
                                while (true) {
                                    i7 = 1953658222;
                                    if (i29 >= size4) {
                                        break;
                                    }
                                    int i32 = size3;
                                    zzfd zzfdVar2 = (zzfd) list4.get(i29);
                                    if (zzfdVar2.zzd == 1953658222) {
                                        zzen zzenVar5 = zzfdVar2.zza;
                                        zzenVar5.zzL(12);
                                        int iZzp = zzenVar5.zzp();
                                        if (iZzp > 0) {
                                            i31 += iZzp;
                                            i15 = 1;
                                            i30++;
                                        } else {
                                            i15 = 1;
                                        }
                                    } else {
                                        i15 = 1;
                                    }
                                    i29 += i15;
                                    size3 = i32;
                                }
                                i3 = size3;
                                zzajcVar2.zzh = 0;
                                zzajcVar2.zzg = 0;
                                zzajcVar2.zzf = 0;
                                zzajrVar2.zzd = i30;
                                zzajrVar2.zze = i31;
                                if (zzajrVar2.zzg.length < i30) {
                                    zzajrVar2.zzf = new long[i30];
                                    zzajrVar2.zzg = new int[i30];
                                }
                                if (zzajrVar2.zzh.length < i31) {
                                    int i33 = (i31 * 125) / 100;
                                    zzajrVar2.zzh = new int[i33];
                                    zzajrVar2.zzi = new long[i33];
                                    zzajrVar2.zzj = new boolean[i33];
                                    zzajrVar2.zzl = new boolean[i33];
                                }
                                int i34 = 0;
                                int i35 = 0;
                                int i36 = 0;
                                while (i34 < size4) {
                                    zzfd zzfdVar3 = (zzfd) list4.get(i34);
                                    if (zzfdVar3.zzd == i7) {
                                        int i37 = i35 + 1;
                                        zzen zzenVar6 = zzfdVar3.zza;
                                        zzenVar6.zzL(8);
                                        int iZzg6 = zzenVar6.zzg();
                                        zzajp zzajpVar2 = zzajcVar2.zzd.zza;
                                        zzaiy zzaiyVar2 = zzajrVar2.zza;
                                        String str = zzex.zza;
                                        zzajrVar2.zzg[i35] = zzenVar6.zzp();
                                        long[] jArr3 = zzajrVar2.zzf;
                                        long j7 = zzajrVar2.zzb;
                                        jArr3[i35] = j7;
                                        if ((iZzg6 & 1) != 0) {
                                            jArr3[i35] = j7 + ((long) zzenVar6.zzg());
                                        }
                                        boolean z6 = (iZzg6 & 4) != 0;
                                        int i38 = zzaiyVar2.zzd;
                                        int iZzg7 = z6 ? zzenVar6.zzg() : i38;
                                        int i39 = iZzg6 & 256;
                                        int i40 = iZzg6 & 512;
                                        int i41 = iZzg6 & 1024;
                                        int i42 = iZzg6 & 2048;
                                        int i43 = iZzg7;
                                        long[] jArr4 = zzajpVar2.zzi;
                                        if (jArr4 != null) {
                                            bArr3 = bArr4;
                                            list = list4;
                                            if (jArr4.length == 1 && (jArr2 = zzajpVar2.zzj) != null) {
                                                long j8 = jArr4[0];
                                                if (j8 == 0) {
                                                    i11 = i39;
                                                    i12 = i42;
                                                    i13 = i40;
                                                } else {
                                                    i13 = i40;
                                                    long j9 = zzajpVar2.zzd;
                                                    RoundingMode roundingMode = RoundingMode.DOWN;
                                                    long jZzu3 = zzex.zzu(j8, 1000000L, j9, roundingMode);
                                                    i12 = i42;
                                                    i11 = i39;
                                                    if (jZzu3 + zzex.zzu(jArr2[0], 1000000L, zzajpVar2.zzc, roundingMode) < zzajpVar2.zze) {
                                                    }
                                                    iArr = zzajrVar2.zzh;
                                                    jArr = zzajrVar2.zzi;
                                                    zArr = zzajrVar2.zzj;
                                                    if (zzajpVar2.zzb == 2 || (i26 & 1) == 0) {
                                                        z2 = false;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                    i14 = zzajrVar2.zzg[i35] + i36;
                                                    z3 = z2;
                                                    j3 = zzajpVar2.zzc;
                                                    j4 = zzajrVar2.zzp;
                                                    while (i36 < i14) {
                                                        if (i11 != 0) {
                                                            iZzg = zzenVar6.zzg();
                                                        } else {
                                                            iZzg = zzaiyVar2.zzb;
                                                        }
                                                        zzg(iZzg);
                                                        if (i13 != 0) {
                                                            iZzg2 = zzenVar6.zzg();
                                                        } else {
                                                            iZzg2 = zzaiyVar2.zzc;
                                                        }
                                                        zzg(iZzg2);
                                                        if (i41 != 0) {
                                                            iZzg3 = zzenVar6.zzg();
                                                        } else if (i36 != 0) {
                                                            iZzg3 = i38;
                                                        } else if (z6) {
                                                            iZzg3 = i43;
                                                            i36 = 0;
                                                        } else {
                                                            i36 = 0;
                                                            iZzg3 = i38;
                                                        }
                                                        if (i12 != 0) {
                                                            iZzg4 = zzenVar6.zzg();
                                                        } else {
                                                            iZzg4 = 0;
                                                        }
                                                        jZzu = zzex.zzu((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.DOWN);
                                                        jArr[i36] = jZzu;
                                                        int i44 = i14;
                                                        if (zzajrVar2.zzq) {
                                                            zzajcVar = zzajcVar2;
                                                        } else {
                                                            zzajcVar = zzajcVar2;
                                                            jArr[i36] = jZzu + zzajcVar.zzd.zzh;
                                                        }
                                                        iArr[i36] = iZzg2;
                                                        if (((iZzg3 >> 16) & 1) != 0) {
                                                            z4 = false;
                                                        } else if (z3) {
                                                            z4 = true;
                                                        } else if (i36 == 0) {
                                                            z4 = true;
                                                            i36 = 0;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        zArr[i36] = z4;
                                                        j4 += (long) iZzg;
                                                        i36++;
                                                        zzaiyVar2 = zzaiyVar2;
                                                        zzenVar6 = zzenVar6;
                                                        j3 = j3;
                                                        i26 = i26;
                                                        i13 = i13;
                                                        i41 = i41;
                                                        zzajcVar2 = zzajcVar;
                                                        i14 = i44;
                                                    }
                                                    i9 = i26;
                                                    int i45 = i14;
                                                    i10 = 1;
                                                    zzajrVar2.zzp = j4;
                                                    zzajcVar2 = zzajcVar2;
                                                    i35 = i37;
                                                    i36 = i45;
                                                }
                                                j2 = jArr2[0];
                                                iArr = zzajrVar2.zzh;
                                                jArr = zzajrVar2.zzi;
                                                zArr = zzajrVar2.zzj;
                                                if (zzajpVar2.zzb == 2) {
                                                    z2 = false;
                                                } else {
                                                    z2 = false;
                                                }
                                                i14 = zzajrVar2.zzg[i35] + i36;
                                                z3 = z2;
                                                j3 = zzajpVar2.zzc;
                                                j4 = zzajrVar2.zzp;
                                                while (i36 < i14) {
                                                    if (i11 != 0) {
                                                        iZzg = zzenVar6.zzg();
                                                    } else {
                                                        iZzg = zzaiyVar2.zzb;
                                                    }
                                                    zzg(iZzg);
                                                    if (i13 != 0) {
                                                        iZzg2 = zzenVar6.zzg();
                                                    } else {
                                                        iZzg2 = zzaiyVar2.zzc;
                                                    }
                                                    zzg(iZzg2);
                                                    if (i41 != 0) {
                                                        iZzg3 = zzenVar6.zzg();
                                                    } else if (i36 != 0) {
                                                        iZzg3 = i38;
                                                    } else if (z6) {
                                                        iZzg3 = i43;
                                                        i36 = 0;
                                                    } else {
                                                        i36 = 0;
                                                        iZzg3 = i38;
                                                    }
                                                    if (i12 != 0) {
                                                        iZzg4 = zzenVar6.zzg();
                                                    } else {
                                                        iZzg4 = 0;
                                                    }
                                                    jZzu = zzex.zzu((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.DOWN);
                                                    jArr[i36] = jZzu;
                                                    int i46 = i14;
                                                    if (zzajrVar2.zzq) {
                                                        zzajcVar = zzajcVar2;
                                                        jArr[i36] = jZzu + zzajcVar.zzd.zzh;
                                                    } else {
                                                        zzajcVar = zzajcVar2;
                                                    }
                                                    iArr[i36] = iZzg2;
                                                    if (((iZzg3 >> 16) & 1) != 0) {
                                                        z4 = false;
                                                    } else if (z3) {
                                                        z4 = true;
                                                    } else if (i36 == 0) {
                                                        z4 = true;
                                                        i36 = 0;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    zArr[i36] = z4;
                                                    j4 += (long) iZzg;
                                                    i36++;
                                                    zzaiyVar2 = zzaiyVar2;
                                                    zzenVar6 = zzenVar6;
                                                    j3 = j3;
                                                    i26 = i26;
                                                    i13 = i13;
                                                    i41 = i41;
                                                    zzajcVar2 = zzajcVar;
                                                    i14 = i46;
                                                }
                                                i9 = i26;
                                                int i47 = i14;
                                                i10 = 1;
                                                zzajrVar2.zzp = j4;
                                                zzajcVar2 = zzajcVar2;
                                                i35 = i37;
                                                i36 = i47;
                                            }
                                            j2 = 0;
                                            iArr = zzajrVar2.zzh;
                                            jArr = zzajrVar2.zzi;
                                            zArr = zzajrVar2.zzj;
                                            if (zzajpVar2.zzb == 2) {
                                                z2 = false;
                                            } else {
                                                z2 = false;
                                            }
                                            i14 = zzajrVar2.zzg[i35] + i36;
                                            z3 = z2;
                                            j3 = zzajpVar2.zzc;
                                            j4 = zzajrVar2.zzp;
                                            while (i36 < i14) {
                                                if (i11 != 0) {
                                                    iZzg = zzenVar6.zzg();
                                                } else {
                                                    iZzg = zzaiyVar2.zzb;
                                                }
                                                zzg(iZzg);
                                                if (i13 != 0) {
                                                    iZzg2 = zzenVar6.zzg();
                                                } else {
                                                    iZzg2 = zzaiyVar2.zzc;
                                                }
                                                zzg(iZzg2);
                                                if (i41 != 0) {
                                                    iZzg3 = zzenVar6.zzg();
                                                } else if (i36 != 0) {
                                                    iZzg3 = i38;
                                                } else if (z6) {
                                                    iZzg3 = i43;
                                                    i36 = 0;
                                                } else {
                                                    i36 = 0;
                                                    iZzg3 = i38;
                                                }
                                                if (i12 != 0) {
                                                    iZzg4 = zzenVar6.zzg();
                                                } else {
                                                    iZzg4 = 0;
                                                }
                                                jZzu = zzex.zzu((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.DOWN);
                                                jArr[i36] = jZzu;
                                                int i48 = i14;
                                                if (zzajrVar2.zzq) {
                                                    zzajcVar = zzajcVar2;
                                                    jArr[i36] = jZzu + zzajcVar.zzd.zzh;
                                                } else {
                                                    zzajcVar = zzajcVar2;
                                                }
                                                iArr[i36] = iZzg2;
                                                if (((iZzg3 >> 16) & 1) != 0) {
                                                    z4 = false;
                                                } else if (z3) {
                                                    z4 = true;
                                                } else if (i36 == 0) {
                                                    z4 = true;
                                                    i36 = 0;
                                                } else {
                                                    z4 = false;
                                                }
                                                zArr[i36] = z4;
                                                j4 += (long) iZzg;
                                                i36++;
                                                zzaiyVar2 = zzaiyVar2;
                                                zzenVar6 = zzenVar6;
                                                j3 = j3;
                                                i26 = i26;
                                                i13 = i13;
                                                i41 = i41;
                                                zzajcVar2 = zzajcVar;
                                                i14 = i48;
                                            }
                                            i9 = i26;
                                            int i49 = i14;
                                            i10 = 1;
                                            zzajrVar2.zzp = j4;
                                            zzajcVar2 = zzajcVar2;
                                            i35 = i37;
                                            i36 = i49;
                                        } else {
                                            list = list4;
                                            bArr3 = bArr4;
                                        }
                                        i11 = i39;
                                        i12 = i42;
                                        i13 = i40;
                                        j2 = 0;
                                        iArr = zzajrVar2.zzh;
                                        jArr = zzajrVar2.zzi;
                                        zArr = zzajrVar2.zzj;
                                        if (zzajpVar2.zzb == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i14 = zzajrVar2.zzg[i35] + i36;
                                        z3 = z2;
                                        j3 = zzajpVar2.zzc;
                                        j4 = zzajrVar2.zzp;
                                        while (i36 < i14) {
                                            if (i11 != 0) {
                                                iZzg = zzenVar6.zzg();
                                            } else {
                                                iZzg = zzaiyVar2.zzb;
                                            }
                                            zzg(iZzg);
                                            if (i13 != 0) {
                                                iZzg2 = zzenVar6.zzg();
                                            } else {
                                                iZzg2 = zzaiyVar2.zzc;
                                            }
                                            zzg(iZzg2);
                                            if (i41 != 0) {
                                                iZzg3 = zzenVar6.zzg();
                                            } else if (i36 != 0) {
                                                iZzg3 = i38;
                                            } else if (z6) {
                                                iZzg3 = i43;
                                                i36 = 0;
                                            } else {
                                                i36 = 0;
                                                iZzg3 = i38;
                                            }
                                            if (i12 != 0) {
                                                iZzg4 = zzenVar6.zzg();
                                            } else {
                                                iZzg4 = 0;
                                            }
                                            jZzu = zzex.zzu((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.DOWN);
                                            jArr[i36] = jZzu;
                                            int i410 = i14;
                                            if (zzajrVar2.zzq) {
                                                zzajcVar = zzajcVar2;
                                                jArr[i36] = jZzu + zzajcVar.zzd.zzh;
                                            } else {
                                                zzajcVar = zzajcVar2;
                                            }
                                            iArr[i36] = iZzg2;
                                            if (((iZzg3 >> 16) & 1) != 0) {
                                                z4 = false;
                                            } else if (z3) {
                                                z4 = true;
                                            } else if (i36 == 0) {
                                                z4 = true;
                                                i36 = 0;
                                            } else {
                                                z4 = false;
                                            }
                                            zArr[i36] = z4;
                                            j4 += (long) iZzg;
                                            i36++;
                                            zzaiyVar2 = zzaiyVar2;
                                            zzenVar6 = zzenVar6;
                                            j3 = j3;
                                            i26 = i26;
                                            i13 = i13;
                                            i41 = i41;
                                            zzajcVar2 = zzajcVar;
                                            i14 = i410;
                                        }
                                        i9 = i26;
                                        int i411 = i14;
                                        i10 = 1;
                                        zzajrVar2.zzp = j4;
                                        zzajcVar2 = zzajcVar2;
                                        i35 = i37;
                                        i36 = i411;
                                    } else {
                                        list = list4;
                                        i9 = i26;
                                        bArr3 = bArr4;
                                        i27 = i27;
                                        i10 = 1;
                                    }
                                    i34 += i10;
                                    size4 = size4;
                                    sparseArray4 = sparseArray4;
                                    zzfcVar2 = zzfcVar2;
                                    zzfcVar3 = zzfcVar3;
                                    i27 = i27;
                                    bArr4 = bArr3;
                                    list4 = list;
                                    i26 = i9;
                                    i7 = 1953658222;
                                }
                                List list5 = list4;
                                sparseArray = sparseArray4;
                                i2 = i26;
                                byte[] bArr5 = bArr4;
                                zzfcVar = zzfcVar2;
                                zzfc zzfcVar4 = zzfcVar3;
                                i4 = i27;
                                zzajp zzajpVar3 = zzajcVar2.zzd.zza;
                                zzaiy zzaiyVar3 = zzajrVar2.zza;
                                zzaiyVar3.getClass();
                                zzajq zzajqVarZzb = zzajpVar3.zzb(zzaiyVar3.zza);
                                zzfd zzfdVarZzb3 = zzfcVar4.zzb(1935763834);
                                if (zzfdVarZzb3 != null) {
                                    zzajqVarZzb.getClass();
                                    int i50 = zzajqVarZzb.zzd;
                                    zzen zzenVar7 = zzfdVarZzb3.zza;
                                    zzenVar7.zzL(8);
                                    if ((zzenVar7.zzg() & 1) == 1) {
                                        zzenVar7.zzM(8);
                                    }
                                    int iZzm = zzenVar7.zzm();
                                    int iZzp2 = zzenVar7.zzp();
                                    int i51 = zzajrVar2.zze;
                                    if (iZzp2 > i51) {
                                        throw zzaz.zza("Saiz sample count " + iZzp2 + " is greater than fragment sample count" + i51, null);
                                    }
                                    if (iZzm == 0) {
                                        boolean[] zArr2 = zzajrVar2.zzl;
                                        i8 = 0;
                                        for (int i52 = 0; i52 < iZzp2; i52++) {
                                            int iZzm2 = zzenVar7.zzm();
                                            i8 += iZzm2;
                                            zArr2[i52] = iZzm2 > i50;
                                        }
                                        z = false;
                                    } else {
                                        boolean z7 = iZzm > i50;
                                        i8 = iZzm * iZzp2;
                                        z = false;
                                        Arrays.fill(zzajrVar2.zzl, 0, iZzp2, z7);
                                    }
                                    Arrays.fill(zzajrVar2.zzl, iZzp2, zzajrVar2.zze, z);
                                    if (i8 > 0) {
                                        zzajrVar2.zza(i8);
                                    }
                                }
                                zzfd zzfdVarZzb4 = zzfcVar4.zzb(1935763823);
                                if (zzfdVarZzb4 != null) {
                                    zzen zzenVar8 = zzfdVarZzb4.zza;
                                    zzenVar8.zzL(8);
                                    int iZzg8 = zzenVar8.zzg();
                                    if ((iZzg8 & 1) == 1) {
                                        zzenVar8.zzM(8);
                                    }
                                    int iZzp3 = zzenVar8.zzp();
                                    if (iZzp3 != 1) {
                                        throw zzaz.zza("Unexpected saio entry count: " + iZzp3, null);
                                    }
                                    zzajrVar2.zzc += zzaix.zza(iZzg8) == 0 ? zzenVar8.zzu() : zzenVar8.zzw();
                                }
                                zzfd zzfdVarZzb5 = zzfcVar4.zzb(1936027235);
                                if (zzfdVarZzb5 != null) {
                                    zzl(zzfdVarZzb5.zza, 0, zzajrVar2);
                                }
                                String str2 = zzajqVarZzb != null ? zzajqVarZzb.zzb : null;
                                zzen zzenVar9 = null;
                                zzen zzenVar10 = null;
                                int i53 = 0;
                                while (i53 < list5.size()) {
                                    List list6 = list5;
                                    zzfd zzfdVar4 = (zzfd) list6.get(i53);
                                    zzen zzenVar11 = zzfdVar4.zza;
                                    int i54 = zzfdVar4.zzd;
                                    if (i54 == 1935828848) {
                                        zzenVar11.zzL(12);
                                        if (zzenVar11.zzg() == 1936025959) {
                                            zzenVar9 = zzenVar11;
                                        }
                                    } else if (i54 == 1936158820) {
                                        zzenVar11.zzL(12);
                                        if (zzenVar11.zzg() == 1936025959) {
                                            zzenVar10 = zzenVar11;
                                        }
                                    }
                                    i53++;
                                    list5 = list6;
                                }
                                List list7 = list5;
                                if (zzenVar9 != null && zzenVar10 != null) {
                                    zzenVar9.zzL(8);
                                    int iZza = zzaix.zza(zzenVar9.zzg());
                                    zzenVar9.zzM(4);
                                    if (iZza == 1) {
                                        zzenVar9.zzM(4);
                                    }
                                    if (zzenVar9.zzg() != 1) {
                                        throw zzaz.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzenVar10.zzL(8);
                                    int iZza2 = zzaix.zza(zzenVar10.zzg());
                                    zzenVar10.zzM(4);
                                    if (iZza2 == 1) {
                                        if (zzenVar10.zzu() == 0) {
                                            throw zzaz.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZza2 >= 2) {
                                        zzenVar10.zzM(4);
                                    }
                                    if (zzenVar10.zzu() != 1) {
                                        throw zzaz.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    zzenVar10.zzM(1);
                                    int iZzm3 = zzenVar10.zzm();
                                    int i55 = (iZzm3 & 240) >> 4;
                                    int i56 = iZzm3 & 15;
                                    if (zzenVar10.zzm() == 1) {
                                        int iZzm4 = zzenVar10.zzm();
                                        byte[] bArr6 = new byte[16];
                                        zzenVar10.zzH(bArr6, 0, 16);
                                        if (iZzm4 == 0) {
                                            int iZzm5 = zzenVar10.zzm();
                                            byte[] bArr7 = new byte[iZzm5];
                                            zzenVar10.zzH(bArr7, 0, iZzm5);
                                            bArr2 = bArr7;
                                        } else {
                                            bArr2 = null;
                                        }
                                        zzajrVar2.zzk = true;
                                        zzajrVar2.zzm = new zzajq(true, str2, iZzm4, bArr6, i55, i56, bArr2);
                                    }
                                }
                                int size5 = list7.size();
                                int i57 = 0;
                                while (i57 < size5) {
                                    zzfd zzfdVar5 = (zzfd) list7.get(i57);
                                    if (zzfdVar5.zzd == 1970628964) {
                                        zzen zzenVar12 = zzfdVar5.zza;
                                        zzenVar12.zzL(8);
                                        bArr = bArr5;
                                        zzenVar12.zzH(bArr, 0, 16);
                                        if (Arrays.equals(bArr, zza)) {
                                            zzl(zzenVar12, 16, zzajrVar2);
                                        }
                                    } else {
                                        bArr = bArr5;
                                    }
                                    i57++;
                                    bArr5 = bArr;
                                }
                                bArr4 = bArr5;
                                i6 = 8;
                                i5 = 0;
                            }
                        } else {
                            sparseArray = sparseArray4;
                            i2 = i26;
                            i3 = size3;
                            zzfcVar = zzfcVar2;
                            i4 = i27;
                            i5 = i25;
                            i6 = i16;
                        }
                        i27 = i4 + 1;
                        i16 = i6;
                        i25 = i5;
                        list3 = list3;
                        size3 = i3;
                        sparseArray4 = sparseArray;
                        zzfcVar2 = zzfcVar;
                        i26 = i2;
                    }
                    int i58 = i25;
                    SparseArray sparseArray5 = sparseArray4;
                    i = i16;
                    zzs zzsVarZzj2 = zzj(zzfcVar2.zzb);
                    if (zzsVarZzj2 != null) {
                        int size6 = sparseArray5.size();
                        for (int i59 = i58; i59 < size6; i59++) {
                            ((zzajc) sparseArray5.valueAt(i59)).zzj(zzsVarZzj2);
                        }
                    }
                    zzajdVar = this;
                    if (zzajdVar.zzz != -9223372036854775807L) {
                        int size7 = sparseArray5.size();
                        for (int i60 = i58; i60 < size7; i60++) {
                            zzajc zzajcVar3 = (zzajc) sparseArray5.valueAt(i60);
                            long j10 = zzajdVar.zzz;
                            int i61 = zzajcVar3.zzf;
                            while (true) {
                                zzajr zzajrVar3 = zzajcVar3.zzb;
                                if (i61 >= zzajrVar3.zze || zzajrVar3.zzi[i61] > j10) {
                                    break;
                                }
                                if (zzajrVar3.zzj[i61]) {
                                    zzajcVar3.zzi = i61;
                                }
                                i61++;
                            }
                        }
                        zzajdVar.zzz = -9223372036854775807L;
                    }
                } else {
                    zzajdVar = zzajdVar2;
                    i = i16;
                    if (!arrayDeque.isEmpty()) {
                        ((zzfc) arrayDeque.peek()).zzc(zzfcVar2);
                    }
                }
                zzajdVar2 = zzajdVar;
                i16 = i;
            }
        }
        zzk();
    }

    private static final zzaiy zzn(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaiy) sparseArray.valueAt(0);
        }
        zzaiy zzaiyVar = (zzaiy) sparseArray.get(i);
        zzaiyVar.getClass();
        return zzaiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ zzadv zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final /* synthetic */ List zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zze(zzady zzadyVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzadyVar = new zzaku(zzadyVar, this.zzc);
        }
        this.zzI = zzadyVar;
        zzk();
        zzafb[] zzafbVarArr = new zzafb[2];
        this.zzJ = zzafbVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzafbVarArr[0] = this.zzI.zzw(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzafb[] zzafbVarArr2 = (zzafb[]) zzex.zzQ(this.zzJ, i);
        this.zzJ = zzafbVarArr2;
        for (zzafb zzafbVar : zzafbVarArr2) {
            zzafbVar.zzm(zzb);
        }
        List list = this.zze;
        this.zzK = new zzafb[list.size()];
        while (i4 < this.zzK.length) {
            zzafb zzafbVarZzw = this.zzI.zzw(i3, 3);
            zzafbVarZzw.zzm((zzz) list.get(i4));
            this.zzK[i4] = zzafbVarZzw;
            i4++;
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzf(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzajc) sparseArray.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzc();
        this.zzz = j2;
        this.zzn.clear();
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final boolean zzi(zzadw zzadwVar) {
        zzaey zzaeyVarZza = zzajo.zza(zzadwVar);
        this.zzr = zzaeyVarZza != null ? zzfyq.zzo(zzaeyVarZza) : zzfyq.zzn();
        return zzaeyVarZza == null;
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0205  */
    /* JADX WARN: Code duplicated, block: B:110:0x0217  */
    /* JADX WARN: Code duplicated, block: B:120:0x0240  */
    /* JADX WARN: Code duplicated, block: B:122:0x026f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0277  */
    /* JADX WARN: Code duplicated, block: B:125:0x027b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0283  */
    /* JADX WARN: Code duplicated, block: B:130:0x0293  */
    /* JADX WARN: Code duplicated, block: B:131:0x0297  */
    /* JADX WARN: Code duplicated, block: B:135:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:138:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:139:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:143:0x02de  */
    /* JADX WARN: Code duplicated, block: B:145:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:148:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:151:0x0312  */
    /* JADX WARN: Code duplicated, block: B:435:0x02af A[EDGE_INSN: B:435:0x02af->B:133:0x02af BREAK  A[LOOP:6: B:66:0x014d->B:68:0x0153], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:436:0x030c A[EDGE_INSN: B:436:0x030c->B:149:0x030c BREAK  A[LOOP:7: B:141:0x02d6->B:439:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:441:0x0237 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:442:0x022f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:443:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x014d A[LOOP:6: B:66:0x014d->B:68:0x0153, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:68:0x0153 A[LOOP:6: B:66:0x014d->B:68:0x0153, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x015f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0176  */
    /* JADX WARN: Code duplicated, block: B:79:0x0184  */
    /* JADX WARN: Code duplicated, block: B:80:0x0186  */
    /* JADX WARN: Code duplicated, block: B:83:0x0198  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a9  */
    @Override // com.google.android.gms.internal.ads.zzadv
    public final int zzb(zzadw zzadwVar, zzaer zzaerVar) throws zzaz {
        zzajc zzajcVar;
        zzajp zzajpVar;
        zzafb zzafbVar;
        long jZze;
        int i;
        zzen zzenVar;
        byte[] bArrZzN;
        int i2;
        int i3;
        int iZzb;
        int i4;
        int iZzg;
        String str;
        int i5;
        char c;
        char c2;
        int iZzf;
        int i6;
        zzfz zzfzVar;
        zzfz zzfzVar2;
        zzfz zzfzVar3;
        int iZza;
        zzajq zzajqVarZzf;
        zzafa zzafaVar;
        ArrayDeque arrayDeque;
        int i7;
        zzajb zzajbVar;
        int i8;
        long j;
        long j2;
        int i9;
        int i10;
        int i11;
        int i12;
        int iZzc;
        long jZzu;
        long jZzu2;
        String str2;
        String str3;
        long jZzu3;
        long j3;
        while (true) {
            int i13 = this.zzs;
            if (i13 != 0) {
                String str4 = YcVWhnLsj.IVIcausAcKPiy;
                if (i13 != 1) {
                    long j4 = Long.MAX_VALUE;
                    if (i13 != 2) {
                        zzajcVar = this.zzC;
                        if (zzajcVar != null) {
                            break;
                        }
                        SparseArray sparseArray = this.zzf;
                        int size = sparseArray.size();
                        long j5 = Long.MAX_VALUE;
                        zzajc zzajcVar2 = null;
                        for (int i14 = 0; i14 < size; i14++) {
                            zzajc zzajcVar3 = (zzajc) sparseArray.valueAt(i14);
                            if ((zzajcVar3.zzm || zzajcVar3.zzf != zzajcVar3.zzd.zzb) && (!zzajcVar3.zzm || zzajcVar3.zzh != zzajcVar3.zzb.zzd)) {
                                long jZzd = zzajcVar3.zzd();
                                if (jZzd < j5) {
                                    zzajcVar2 = zzajcVar3;
                                    j5 = jZzd;
                                }
                            }
                        }
                        if (zzajcVar2 != null) {
                            int iZzd = (int) (zzajcVar2.zzd() - zzadwVar.zzf());
                            if (iZzd < 0) {
                                zzea.zzf(str4, "Ignoring negative offset to sample data.");
                                iZzd = 0;
                            }
                            zzadwVar.zzk(iZzd);
                            this.zzC = zzajcVar2;
                            zzajcVar = zzajcVar2;
                            break;
                        }
                        int iZzf2 = (int) (this.zzx - zzadwVar.zzf());
                        if (iZzf2 < 0) {
                            throw zzaz.zza("Offset to end of mdat was negative.", null);
                        }
                        zzadwVar.zzk(iZzf2);
                        zzk();
                    } else {
                        SparseArray sparseArray2 = this.zzf;
                        int size2 = sparseArray2.size();
                        zzajc zzajcVar4 = null;
                        for (int i15 = 0; i15 < size2; i15++) {
                            zzajr zzajrVar = ((zzajc) sparseArray2.valueAt(i15)).zzb;
                            if (zzajrVar.zzo) {
                                long j6 = zzajrVar.zzc;
                                if (j6 < j4) {
                                    zzajcVar4 = (zzajc) sparseArray2.valueAt(i15);
                                    j4 = j6;
                                }
                            }
                        }
                        if (zzajcVar4 == null) {
                            this.zzs = 3;
                        } else {
                            int iZzf3 = (int) (j4 - zzadwVar.zzf());
                            if (iZzf3 < 0) {
                                throw zzaz.zza("Offset to encryption data was negative.", null);
                            }
                            zzadwVar.zzk(iZzf3);
                            zzajr zzajrVar2 = zzajcVar4.zzb;
                            zzen zzenVar2 = zzajrVar2.zzn;
                            zzadwVar.zzi(zzenVar2.zzN(), 0, zzenVar2.zzd());
                            zzenVar2.zzL(0);
                            zzajrVar2.zzo = false;
                        }
                    }
                } else {
                    long j7 = this.zzu - ((long) this.zzv);
                    zzen zzenVar3 = this.zzw;
                    int i16 = (int) j7;
                    if (zzenVar3 != null) {
                        zzadwVar.zzi(zzenVar3.zzN(), 8, i16);
                        zzfd zzfdVar = new zzfd(this.zzt, zzenVar3);
                        ArrayDeque arrayDeque2 = this.zzn;
                        if (arrayDeque2.isEmpty()) {
                            int i17 = zzfdVar.zzd;
                            if (i17 == 1936286840) {
                                Pair pairZzh = zzh(zzfdVar.zza, zzadwVar.zzf());
                                this.zzq.zzb((zzadi) pairZzh.second);
                                if (!this.zzL) {
                                    this.zzB = ((Long) pairZzh.first).longValue();
                                    this.zzI.zzP((zzaeu) pairZzh.second);
                                    this.zzL = true;
                                }
                            } else if (i17 == 1701671783) {
                                zzen zzenVar4 = zzfdVar.zza;
                                if (this.zzJ.length != 0) {
                                    zzenVar4.zzL(8);
                                    int iZza2 = zzaix.zza(zzenVar4.zzg());
                                    if (iZza2 == 0) {
                                        String strZzy = zzenVar4.zzy((char) 0);
                                        strZzy.getClass();
                                        String strZzy2 = zzenVar4.zzy((char) 0);
                                        strZzy2.getClass();
                                        long jZzu4 = zzenVar4.zzu();
                                        long jZzu5 = zzenVar4.zzu();
                                        RoundingMode roundingMode = RoundingMode.DOWN;
                                        jZzu = zzex.zzu(jZzu5, 1000000L, jZzu4, roundingMode);
                                        long j8 = this.zzB;
                                        long j9 = j8 != -9223372036854775807L ? j8 + jZzu : -9223372036854775807L;
                                        jZzu2 = zzex.zzu(zzenVar4.zzu(), 1000L, jZzu4, roundingMode);
                                        str2 = strZzy;
                                        str3 = strZzy2;
                                        jZzu3 = zzenVar4.zzu();
                                        j3 = j9;
                                    } else if (iZza2 != 1) {
                                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZza2, "Skipping unsupported emsg version: ", str4);
                                    } else {
                                        long jZzu6 = zzenVar4.zzu();
                                        long jZzw = zzenVar4.zzw();
                                        RoundingMode roundingMode2 = RoundingMode.DOWN;
                                        long jZzu7 = zzex.zzu(jZzw, 1000000L, jZzu6, roundingMode2);
                                        long jZzu8 = zzex.zzu(zzenVar4.zzu(), 1000L, jZzu6, roundingMode2);
                                        long jZzu9 = zzenVar4.zzu();
                                        String strZzy3 = zzenVar4.zzy((char) 0);
                                        strZzy3.getClass();
                                        String strZzy4 = zzenVar4.zzy((char) 0);
                                        strZzy4.getClass();
                                        jZzu2 = jZzu8;
                                        jZzu3 = jZzu9;
                                        str2 = strZzy3;
                                        str3 = strZzy4;
                                        j3 = jZzu7;
                                        jZzu = -9223372036854775807L;
                                    }
                                    byte[] bArr = new byte[zzenVar4.zza()];
                                    zzenVar4.zzH(bArr, 0, zzenVar4.zza());
                                    zzen zzenVar5 = new zzen(this.zzl.zza(new zzagr(str2, str3, jZzu2, jZzu3, bArr)));
                                    int iZza3 = zzenVar5.zza();
                                    for (zzafb zzafbVar2 : this.zzJ) {
                                        zzenVar5.zzL(0);
                                        zzafbVar2.zzr(zzenVar5, iZza3);
                                    }
                                    if (j3 == -9223372036854775807L) {
                                        this.zzo.addLast(new zzajb(jZzu, true, iZza3));
                                        this.zzy += iZza3;
                                    } else {
                                        ArrayDeque arrayDeque3 = this.zzo;
                                        if (arrayDeque3.isEmpty()) {
                                            for (zzafb zzafbVar3 : this.zzJ) {
                                                zzafbVar3.zzt(j3, 1, iZza3, 0, null);
                                            }
                                        } else {
                                            arrayDeque3.addLast(new zzajb(j3, false, iZza3));
                                            this.zzy += iZza3;
                                        }
                                    }
                                }
                            }
                        } else {
                            ((zzfc) arrayDeque2.peek()).zzd(zzfdVar);
                        }
                    } else {
                        zzadwVar.zzk(i16);
                    }
                    zzm(zzadwVar.zzf());
                }
            } else {
                if (this.zzv == 0) {
                    zzen zzenVar6 = this.zzm;
                    if (!zzadwVar.zzn(zzenVar6.zzN(), 0, 8, true)) {
                        if (this.zzM == -1) {
                            this.zzp.zzd();
                            return -1;
                        }
                        zzaerVar.zza = 0L;
                        this.zzM = -1L;
                        this.zzI.zzP(this.zzq.zza());
                        return 1;
                    }
                    this.zzv = 8;
                    zzenVar6.zzL(0);
                    this.zzu = zzenVar6.zzu();
                    this.zzt = zzenVar6.zzg();
                }
                long j10 = this.zzu;
                if (j10 == 1) {
                    zzen zzenVar7 = this.zzm;
                    zzadwVar.zzi(zzenVar7.zzN(), 8, 8);
                    this.zzv += 8;
                    this.zzu = zzenVar7.zzw();
                } else if (j10 == 0) {
                    long jZzd2 = zzadwVar.zzd();
                    if (jZzd2 == -1) {
                        ArrayDeque arrayDeque4 = this.zzn;
                        jZzd2 = !arrayDeque4.isEmpty() ? ((zzfc) arrayDeque4.peek()).zza : -1L;
                    }
                    if (jZzd2 != -1) {
                        this.zzu = (jZzd2 - zzadwVar.zzf()) + ((long) this.zzv);
                    }
                }
                long j11 = this.zzu;
                long j12 = this.zzv;
                if (j11 < j12) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                if (this.zzM != -1) {
                    if (this.zzt == 1936286840) {
                        zzen zzenVar8 = this.zzk;
                        zzenVar8.zzI((int) j11);
                        System.arraycopy(this.zzm.zzN(), 0, zzenVar8.zzN(), 0, 8);
                        zzadwVar.zzi(zzenVar8.zzN(), 8, (int) (this.zzu - ((long) this.zzv)));
                        this.zzq.zzb((zzadi) zzh(new zzfd(1936286840, zzenVar8).zza, zzadwVar.zze()).second);
                    } else {
                        zzadwVar.zzo((int) (j11 - j12), true);
                    }
                    zzk();
                } else {
                    long jZzf = zzadwVar.zzf() - j12;
                    int i18 = this.zzt;
                    if ((i18 == 1836019558 || i18 == 1835295092) && !this.zzL) {
                        this.zzI.zzP(new zzaet(this.zzA, jZzf));
                        this.zzL = true;
                    }
                    if (this.zzt == 1836019558) {
                        SparseArray sparseArray3 = this.zzf;
                        int size3 = sparseArray3.size();
                        for (int i19 = 0; i19 < size3; i19++) {
                            zzajr zzajrVar3 = ((zzajc) sparseArray3.valueAt(i19)).zzb;
                            zzajrVar3.zzc = jZzf;
                            zzajrVar3.zzb = jZzf;
                        }
                    }
                    int i20 = this.zzt;
                    if (i20 == 1835295092) {
                        this.zzC = null;
                        this.zzx = jZzf + this.zzu;
                        this.zzs = 2;
                    } else if (i20 == 1836019574 || i20 == 1953653099 || i20 == 1835297121 || i20 == 1835626086 || i20 == 1937007212 || i20 == 1836019558 || i20 == 1953653094 || i20 == 1836475768 || i20 == 1701082227) {
                        long jZzf2 = (zzadwVar.zzf() + this.zzu) - 8;
                        this.zzn.push(new zzfc(i20, jZzf2));
                        if (this.zzu == this.zzv) {
                            zzm(jZzf2);
                        } else {
                            zzk();
                        }
                    } else if (i20 == 1751411826 || i20 == 1835296868 || i20 == 1836476516 || i20 == 1936286840 || i20 == 1937011556 || i20 == 1937011827 || i20 == 1668576371 || i20 == 1937011555 || i20 == 1937011578 || i20 == 1937013298 || i20 == 1937007471 || i20 == 1668232756 || i20 == 1937011571 || i20 == 1952867444 || i20 == 1952868452 || i20 == 1953196132 || i20 == 1953654136 || i20 == 1953658222 || i20 == 1886614376 || i20 == 1935763834 || i20 == 1935763823 || i20 == 1936027235 || i20 == 1970628964 || i20 == 1935828848 || i20 == 1936158820 || i20 == 1701606260 || i20 == 1835362404 || i20 == 1701671783) {
                        if (this.zzv != 8) {
                            throw zzaz.zzc("Leaf atom defines extended atom size (unsupported).");
                        }
                        if (this.zzu > 2147483647L) {
                            throw zzaz.zzc("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        zzen zzenVar9 = new zzen((int) this.zzu);
                        System.arraycopy(this.zzm.zzN(), 0, zzenVar9.zzN(), 0, 8);
                        this.zzw = zzenVar9;
                        this.zzs = 1;
                    } else {
                        if (this.zzu > 2147483647L) {
                            throw zzaz.zzc("Skipping atom with length > 2147483647 (unsupported).");
                        }
                        this.zzw = null;
                        this.zzs = 1;
                    }
                }
            }
        }
        String str5 = "video/avc";
        if (this.zzs == 3) {
            this.zzD = zzajcVar.zzb();
            String str6 = zzajcVar.zzd.zza.zzg.zzo;
            if (!Objects.equals(str6, "video/avc")) {
                Objects.equals(str6, "video/hevc");
            }
            this.zzG = true;
            if (zzajcVar.zzf < zzajcVar.zzi) {
                zzadwVar.zzk(this.zzD);
                zzajq zzajqVarZzf2 = zzajcVar.zzf();
                if (zzajqVarZzf2 != null) {
                    zzajr zzajrVar4 = zzajcVar.zzb;
                    zzen zzenVar10 = zzajrVar4.zzn;
                    int i21 = zzajqVarZzf2.zzd;
                    if (i21 != 0) {
                        zzenVar10.zzM(i21);
                    }
                    if (zzajrVar4.zzb(zzajcVar.zzf)) {
                        zzenVar10.zzM(zzenVar10.zzq() * 6);
                    }
                }
                if (!zzajcVar.zzl()) {
                    this.zzC = null;
                }
                i7 = 3;
            } else {
                if (zzajcVar.zzd.zza.zzh == 1) {
                    this.zzD -= 8;
                    zzadwVar.zzk(8);
                }
                if ("audio/ac4".equals(zzajcVar.zzd.zza.zzg.zzo)) {
                    this.zzE = zzajcVar.zzc(this.zzD, 7);
                    int i22 = this.zzD;
                    zzen zzenVar11 = this.zzk;
                    zzacy.zzc(i22, zzenVar11);
                    zzajcVar.zza.zzr(zzenVar11, 7);
                    iZzc = this.zzE + 7;
                    this.zzE = iZzc;
                    i12 = 0;
                } else {
                    i12 = 0;
                    iZzc = zzajcVar.zzc(this.zzD, 0);
                    this.zzE = iZzc;
                }
                this.zzD += iZzc;
                this.zzs = 4;
                this.zzF = i12;
                zzajpVar = zzajcVar.zzd.zza;
                zzafbVar = zzajcVar.zza;
                jZze = zzajcVar.zze();
                i = zzajpVar.zzk;
                if (i == 0) {
                    while (true) {
                        i10 = this.zzE;
                        i11 = this.zzD;
                        if (i10 < i11) {
                            break;
                        }
                        this.zzE += zzafbVar.zzf(zzadwVar, i11 - i10, false);
                    }
                } else {
                    zzenVar = this.zzh;
                    bArrZzN = zzenVar.zzN();
                    bArrZzN[0] = 0;
                    bArrZzN[1] = 0;
                    bArrZzN[2] = 0;
                    i2 = 4 - i;
                    while (this.zzE < this.zzD) {
                        i3 = this.zzF;
                        if (i3 == 0) {
                            if (this.zzK.length <= 0 || !this.zzG) {
                                iZzb = zzfv.zzb(zzajpVar.zzg);
                                if (i + iZzb > this.zzD - this.zzE) {
                                    i4 = 0;
                                } else {
                                    i4 = iZzb;
                                }
                            } else {
                                i4 = 0;
                            }
                            zzadwVar.zzi(bArrZzN, i2, i + i4);
                            zzenVar.zzL(0);
                            iZzg = zzenVar.zzg();
                            if (iZzg >= 0) {
                                throw zzaz.zza("Invalid NAL length", null);
                            }
                            this.zzF = iZzg - i4;
                            zzen zzenVar12 = this.zzg;
                            zzenVar12.zzL(0);
                            zzafbVar.zzr(zzenVar12, 4);
                            this.zzE += 4;
                            this.zzD += i2;
                            if (this.zzK.length > 0 || i4 <= 0) {
                                str = str5;
                                i5 = i;
                                c = 6;
                            } else {
                                zzz zzzVar = zzajpVar.zzg;
                                byte b = bArrZzN[4];
                                String str7 = zzzVar.zzo;
                                if (Objects.equals(str7, str5)) {
                                    i5 = i;
                                } else {
                                    i5 = i;
                                    if (!zzay.zzg(zzzVar.zzk, str5)) {
                                        str = str5;
                                        c = 6;
                                    }
                                    boolean z = (!Objects.equals(str7, "video/hevc") || zzay.zzg(zzzVar.zzk, "video/hevc")) && ((b & 126) >> 1) == 39;
                                    this.zzH = z;
                                    zzafbVar.zzr(zzenVar, i4);
                                    this.zzE += i4;
                                    if (i4 > 0 && !this.zzG && zzfv.zzj(bArrZzN, 4, i4, zzajpVar.zzg)) {
                                        this.zzG = true;
                                    }
                                    i = i5;
                                    str5 = str;
                                }
                                str = str5;
                                c = 6;
                                if ((b & 31) != 6) {
                                    if (Objects.equals(str7, "video/hevc")) {
                                    }
                                }
                                this.zzH = z;
                                zzafbVar.zzr(zzenVar, i4);
                                this.zzE += i4;
                                if (i4 > 0) {
                                    this.zzG = true;
                                }
                                i = i5;
                                str5 = str;
                            }
                            this.zzH = z;
                            zzafbVar.zzr(zzenVar, i4);
                            this.zzE += i4;
                            if (i4 > 0) {
                                this.zzG = true;
                            }
                            i = i5;
                            str5 = str;
                        } else {
                            String str8 = str5;
                            int i23 = i;
                            if (this.zzH) {
                                zzen zzenVar13 = this.zzi;
                                zzenVar13.zzI(i3);
                                zzadwVar.zzi(zzenVar13.zzN(), 0, this.zzF);
                                zzafbVar.zzr(zzenVar13, this.zzF);
                                iZzf = this.zzF;
                                int iZzc2 = zzfv.zzc(zzenVar13.zzN(), zzenVar13.zzd());
                                zzenVar13.zzL(0);
                                zzenVar13.zzK(iZzc2);
                                i6 = zzajpVar.zzg.zzq;
                                if (i6 == -1) {
                                    zzfzVar3 = this.zzp;
                                    if (zzfzVar3.zza() != 0) {
                                        zzfzVar3.zze(0);
                                    }
                                } else {
                                    zzfzVar = this.zzp;
                                    if (zzfzVar.zza() != i6) {
                                        zzfzVar.zze(i6);
                                    }
                                }
                                zzfzVar2 = this.zzp;
                                zzfzVar2.zzb(jZze, zzenVar13);
                                c2 = 4;
                                if ((zzajcVar.zza() & 4) != 0) {
                                    zzfzVar2.zzd();
                                }
                            } else {
                                c2 = 4;
                                iZzf = zzafbVar.zzf(zzadwVar, i3, false);
                            }
                            this.zzE += iZzf;
                            this.zzF -= iZzf;
                            i = i23;
                            str5 = str8;
                        }
                    }
                }
                iZza = zzajcVar.zza();
                if (!this.zzG) {
                    iZza |= 67108864;
                }
                int i24 = iZza;
                zzajqVarZzf = zzajcVar.zzf();
                if (zzajqVarZzf != null) {
                    zzafaVar = zzajqVarZzf.zzc;
                } else {
                    zzafaVar = null;
                }
                zzafbVar.zzt(jZze, i24, this.zzD, 0, zzafaVar);
                while (true) {
                    arrayDeque = this.zzo;
                    if (!arrayDeque.isEmpty()) {
                        break;
                    }
                    zzajbVar = (zzajb) arrayDeque.removeFirst();
                    int i25 = this.zzy;
                    i8 = zzajbVar.zzc;
                    this.zzy = i25 - i8;
                    j = zzajbVar.zza;
                    if (zzajbVar.zzb) {
                        j += jZze;
                    }
                    j2 = j;
                    for (zzafb zzafbVar4 : this.zzJ) {
                        zzafbVar4.zzt(j2, 1, i8, this.zzy, null);
                    }
                }
                if (!zzajcVar.zzl()) {
                    this.zzC = null;
                }
                i7 = 3;
            }
        } else {
            zzajpVar = zzajcVar.zzd.zza;
            zzafbVar = zzajcVar.zza;
            jZze = zzajcVar.zze();
            i = zzajpVar.zzk;
            if (i == 0) {
                while (true) {
                    i10 = this.zzE;
                    i11 = this.zzD;
                    if (i10 < i11) {
                        break;
                        break;
                    }
                    this.zzE += zzafbVar.zzf(zzadwVar, i11 - i10, false);
                }
            } else {
                zzenVar = this.zzh;
                bArrZzN = zzenVar.zzN();
                bArrZzN[0] = 0;
                bArrZzN[1] = 0;
                bArrZzN[2] = 0;
                i2 = 4 - i;
                while (this.zzE < this.zzD) {
                    i3 = this.zzF;
                    if (i3 == 0) {
                        if (this.zzK.length <= 0) {
                            iZzb = zzfv.zzb(zzajpVar.zzg);
                            if (i + iZzb > this.zzD - this.zzE) {
                                i4 = 0;
                            } else {
                                i4 = iZzb;
                            }
                        } else {
                            iZzb = zzfv.zzb(zzajpVar.zzg);
                            if (i + iZzb > this.zzD - this.zzE) {
                                i4 = 0;
                            } else {
                                i4 = iZzb;
                            }
                        }
                        zzadwVar.zzi(bArrZzN, i2, i + i4);
                        zzenVar.zzL(0);
                        iZzg = zzenVar.zzg();
                        if (iZzg >= 0) {
                            throw zzaz.zza("Invalid NAL length", null);
                        }
                        this.zzF = iZzg - i4;
                        zzen zzenVar14 = this.zzg;
                        zzenVar14.zzL(0);
                        zzafbVar.zzr(zzenVar14, 4);
                        this.zzE += 4;
                        this.zzD += i2;
                        if (this.zzK.length > 0) {
                            str = str5;
                            i5 = i;
                            c = 6;
                        } else {
                            str = str5;
                            i5 = i;
                            c = 6;
                        }
                        this.zzH = z;
                        zzafbVar.zzr(zzenVar, i4);
                        this.zzE += i4;
                        if (i4 > 0) {
                            this.zzG = true;
                        }
                        i = i5;
                        str5 = str;
                    } else {
                        String str9 = str5;
                        int i26 = i;
                        if (this.zzH) {
                            zzen zzenVar15 = this.zzi;
                            zzenVar15.zzI(i3);
                            zzadwVar.zzi(zzenVar15.zzN(), 0, this.zzF);
                            zzafbVar.zzr(zzenVar15, this.zzF);
                            iZzf = this.zzF;
                            int iZzc3 = zzfv.zzc(zzenVar15.zzN(), zzenVar15.zzd());
                            zzenVar15.zzL(0);
                            zzenVar15.zzK(iZzc3);
                            i6 = zzajpVar.zzg.zzq;
                            if (i6 == -1) {
                                zzfzVar3 = this.zzp;
                                if (zzfzVar3.zza() != 0) {
                                    zzfzVar3.zze(0);
                                }
                            } else {
                                zzfzVar = this.zzp;
                                if (zzfzVar.zza() != i6) {
                                    zzfzVar.zze(i6);
                                }
                            }
                            zzfzVar2 = this.zzp;
                            zzfzVar2.zzb(jZze, zzenVar15);
                            c2 = 4;
                            if ((zzajcVar.zza() & 4) != 0) {
                                zzfzVar2.zzd();
                            }
                        } else {
                            c2 = 4;
                            iZzf = zzafbVar.zzf(zzadwVar, i3, false);
                        }
                        this.zzE += iZzf;
                        this.zzF -= iZzf;
                        i = i26;
                        str5 = str9;
                    }
                }
            }
            iZza = zzajcVar.zza();
            if (!this.zzG) {
                iZza |= 67108864;
            }
            int i27 = iZza;
            zzajqVarZzf = zzajcVar.zzf();
            if (zzajqVarZzf != null) {
                zzafaVar = zzajqVarZzf.zzc;
            } else {
                zzafaVar = null;
            }
            zzafbVar.zzt(jZze, i27, this.zzD, 0, zzafaVar);
            while (true) {
                arrayDeque = this.zzo;
                if (!arrayDeque.isEmpty()) {
                    break;
                    break;
                }
                zzajbVar = (zzajb) arrayDeque.removeFirst();
                int i28 = this.zzy;
                i8 = zzajbVar.zzc;
                this.zzy = i28 - i8;
                j = zzajbVar.zza;
                if (zzajbVar.zzb) {
                    j += jZze;
                }
                j2 = j;
                while (i9 < r3) {
                    zzafbVar4.zzt(j2, 1, i8, this.zzy, null);
                }
            }
            if (!zzajcVar.zzl()) {
                this.zzC = null;
            }
            i7 = 3;
        }
        this.zzs = i7;
        return 0;
    }

    public zzajd(zzakr zzakrVar, int i, zzeu zzeuVar, zzajp zzajpVar, List list, zzafb zzafbVar) {
        this.zzc = zzakrVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzags();
        this.zzm = new zzen(16);
        this.zzg = new zzen(zzfv.zza);
        this.zzh = new zzen(6);
        this.zzi = new zzen();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzen(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzfyq.zzn();
        this.zzA = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzI = zzady.zza;
        this.zzJ = new zzafb[0];
        this.zzK = new zzafb[0];
        this.zzp = new zzfz(new zzfy() { // from class: com.google.android.gms.internal.ads.zzaja
            @Override // com.google.android.gms.internal.ads.zzfy
            public final void zza(long j, zzen zzenVar) {
                zzadh.zza(j, zzenVar, this.zza.zzK);
            }
        });
        this.zzq = new zzadj();
        this.zzM = -1L;
    }

    private static zzs zzj(List list) {
        int i;
        ArrayList arrayList;
        UUID[] uuidArr;
        zzajl zzajlVar;
        UUID uuid;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList2 = null;
        while (i2 < size) {
            zzfd zzfdVar = (zzfd) list.get(i2);
            if (zzfdVar.zzd == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArrZzN = zzfdVar.zza.zzN();
                zzen zzenVar = new zzen(bArrZzN);
                if (zzenVar.zzd() < 32) {
                    i = i2;
                    arrayList = arrayList2;
                    zzajlVar = null;
                } else {
                    zzenVar.zzL(0);
                    int iZza = zzenVar.zza();
                    int iZzg = zzenVar.zzg();
                    if (iZzg != iZza) {
                        zzea.zzf("PsshAtomUtil", "Advertised atom size (" + iZzg + ") does not match buffer size: " + iZza);
                    } else {
                        int iZzg2 = zzenVar.zzg();
                        if (iZzg2 != 1886614376) {
                            CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzg2, "Atom type is not pssh: ", "PsshAtomUtil");
                        } else {
                            int iZza2 = zzaix.zza(zzenVar.zzg());
                            if (iZza2 > 1) {
                                CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZza2, TSDAbK.bkEwtiWAqtKGRG, "PsshAtomUtil");
                            } else {
                                UUID uuid2 = new UUID(zzenVar.zzt(), zzenVar.zzt());
                                if (iZza2 == 1) {
                                    int iZzp = zzenVar.zzp();
                                    uuidArr = new UUID[iZzp];
                                    int i3 = 0;
                                    while (i3 < iZzp) {
                                        uuidArr[i3] = new UUID(zzenVar.zzt(), zzenVar.zzt());
                                        i3++;
                                        i2 = i2;
                                        arrayList2 = arrayList2;
                                    }
                                    i = i2;
                                    arrayList = arrayList2;
                                } else {
                                    i = i2;
                                    arrayList = arrayList2;
                                    uuidArr = null;
                                }
                                int iZzp2 = zzenVar.zzp();
                                int iZza3 = zzenVar.zza();
                                if (iZzp2 != iZza3) {
                                    zzea.zzf("PsshAtomUtil", "Atom data size (" + iZzp2 + ") does not match the bytes left: " + iZza3);
                                    zzajlVar = null;
                                } else {
                                    byte[] bArr = new byte[iZzp2];
                                    zzenVar.zzH(bArr, 0, iZzp2);
                                    zzajlVar = new zzajl(uuid2, iZza2, bArr, uuidArr);
                                }
                            }
                        }
                    }
                    i = i2;
                    arrayList = arrayList2;
                    zzajlVar = null;
                }
                if (zzajlVar == null) {
                    uuid = null;
                } else {
                    uuid = zzajlVar.zza;
                }
                if (uuid == null) {
                    zzea.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                    arrayList2 = arrayList;
                } else {
                    arrayList2 = arrayList;
                    arrayList2.add(new zzr(uuid, null, "video/mp4", bArrZzN));
                }
                i2 = i + 1;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList2 == null) {
            return null;
        }
        return new zzs(arrayList2);
    }
}
