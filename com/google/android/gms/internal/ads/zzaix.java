package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.inject.PVS.jIKWv;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaix {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzex.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    public static zzav zzb(zzfc zzfcVar) {
        zzfa zzfaVar;
        zzfd zzfdVarZzb = zzfcVar.zzb(1751411826);
        zzfd zzfdVarZzb2 = zzfcVar.zzb(1801812339);
        zzfd zzfdVarZzb3 = zzfcVar.zzb(1768715124);
        if (zzfdVarZzb != null && zzfdVarZzb2 != null && zzfdVarZzb3 != null && zzi(zzfdVarZzb.zza) == 1835299937) {
            zzen zzenVar = zzfdVarZzb2.zza;
            zzenVar.zzL(12);
            int iZzg = zzenVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i = 0; i < iZzg; i++) {
                int iZzg2 = zzenVar.zzg();
                zzenVar.zzM(4);
                strArr[i] = zzenVar.zzB(iZzg2 - 8, StandardCharsets.UTF_8);
            }
            zzen zzenVar2 = zzfdVarZzb3.zza;
            zzenVar2.zzL(8);
            ArrayList arrayList = new ArrayList();
            while (zzenVar2.zza() > 8) {
                int iZzg3 = zzenVar2.zzg() + zzenVar2.zzc();
                int iZzg4 = zzenVar2.zzg() - 1;
                if (iZzg4 < 0 || iZzg4 >= iZzg) {
                    CoroutineAdapterKt$$ExternalSyntheticLambda0.m23m(iZzg4, "Skipped metadata with unknown key index: ", "BoxParsers");
                } else {
                    String str = strArr[iZzg4];
                    while (true) {
                        int iZzc = zzenVar2.zzc();
                        if (iZzc >= iZzg3) {
                            zzfaVar = null;
                            break;
                        }
                        int iZzg5 = zzenVar2.zzg();
                        if (zzenVar2.zzg() == 1684108385) {
                            int iZzg6 = zzenVar2.zzg();
                            int iZzg7 = zzenVar2.zzg();
                            int i2 = iZzg5 - 16;
                            byte[] bArr = new byte[i2];
                            zzenVar2.zzH(bArr, 0, i2);
                            zzfaVar = new zzfa(str, bArr, iZzg7, iZzg6);
                            break;
                        }
                        zzenVar2.zzL(iZzc + iZzg5);
                    }
                    if (zzfaVar != null) {
                        arrayList.add(zzfaVar);
                    }
                }
                zzenVar2.zzL(iZzg3);
            }
            if (!arrayList.isEmpty()) {
                return new zzav(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00d9  */
    public static zzav zzc(zzfd zzfdVar) {
        int iZzn;
        zzen zzenVar = zzfdVar.zza;
        zzenVar.zzL(8);
        zzav zzavVar = new zzav(-9223372036854775807L, new zzau[0]);
        while (zzenVar.zza() >= 8) {
            int iZzc = zzenVar.zzc();
            int iZzg = zzenVar.zzg() + iZzc;
            int iZzg2 = zzenVar.zzg();
            zzav zzavVar2 = null;
            if (iZzg2 == 1835365473) {
                zzenVar.zzL(iZzc);
                zzenVar.zzM(8);
                zzg(zzenVar);
                while (zzenVar.zzc() < iZzg) {
                    int iZzc2 = zzenVar.zzc();
                    int iZzg3 = zzenVar.zzg() + iZzc2;
                    if (zzenVar.zzg() == 1768715124) {
                        zzenVar.zzL(iZzc2);
                        zzenVar.zzM(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzenVar.zzc() < iZzg3) {
                            zzau zzauVarZza = zzajf.zza(zzenVar);
                            if (zzauVarZza != null) {
                                arrayList.add(zzauVarZza);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzavVar2 = new zzav(arrayList);
                            break;
                        }
                        break;
                    }
                    zzenVar.zzL(iZzg3);
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (iZzg2 == 1936553057) {
                zzenVar.zzL(iZzc);
                zzenVar.zzM(12);
                while (zzenVar.zzc() < iZzg) {
                    int iZzc3 = zzenVar.zzc();
                    int iZzg4 = zzenVar.zzg();
                    if (zzenVar.zzg() == 1935766900) {
                        if (iZzg4 < 16) {
                            break;
                        }
                        zzenVar.zzM(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzm = zzenVar.zzm();
                            int iZzm2 = zzenVar.zzm();
                            if (iZzm == 0) {
                                i = iZzm2;
                            } else if (iZzm == 1) {
                                i2 = iZzm2;
                            }
                        }
                        if (i == 12) {
                            iZzn = 240;
                        } else if (i == 13) {
                            iZzn = 120;
                        } else if (i == 21 && zzenVar.zza() >= 8 && zzenVar.zzc() + 8 <= iZzg) {
                            int iZzg5 = zzenVar.zzg();
                            int iZzg6 = zzenVar.zzg();
                            if (iZzg5 < 12 || iZzg6 != 1936877170) {
                                iZzn = -2147483647;
                            } else {
                                iZzn = zzenVar.zzn();
                            }
                        } else {
                            iZzn = -2147483647;
                        }
                        if (iZzn == -2147483647) {
                            break;
                        }
                        zzavVar2 = new zzav(-9223372036854775807L, new zzahp(iZzn, i2));
                        break;
                    }
                    zzenVar.zzL(iZzc3 + iZzg4);
                }
                zzavVar = zzavVar.zzd(zzavVar2);
            } else if (iZzg2 == -1451722374) {
                zzavVar = zzavVar.zzd(zzm(zzenVar));
            }
            zzenVar.zzL(iZzg);
        }
        return zzavVar;
    }

    public static zzfh zzd(zzen zzenVar) {
        long jZzt;
        long jZzt2;
        zzenVar.zzL(8);
        if (zza(zzenVar.zzg()) == 0) {
            jZzt = zzenVar.zzu();
            jZzt2 = zzenVar.zzu();
        } else {
            jZzt = zzenVar.zzt();
            jZzt2 = zzenVar.zzt();
        }
        return new zzfh(jZzt, jZzt2, zzenVar.zzu());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0282  */
    /* JADX WARN: Code duplicated, block: B:103:0x028a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x028c  */
    /* JADX WARN: Code duplicated, block: B:105:0x029a  */
    /* JADX WARN: Code duplicated, block: B:106:0x029d  */
    /* JADX WARN: Code duplicated, block: B:111:0x02c3 A[DONT_INVERT, LOOP:14: B:111:0x02c3->B:115:0x02cd, LOOP_START, PHI: r24
  0x02c3: PHI (r24v2 int) = (r24v1 int), (r24v3 int) binds: [B:110:0x02c1, B:115:0x02cd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:115:0x02cd A[LOOP:14: B:111:0x02c3->B:115:0x02cd, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:116:0x02d4 A[EDGE_INSN: B:116:0x02d4->B:117:0x02d5 BREAK  A[LOOP:14: B:111:0x02c3->B:115:0x02cd]] */
    /* JADX WARN: Code duplicated, block: B:118:0x02d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x02d9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x02db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x02dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x02df A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:124:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:125:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:126:0x0303  */
    /* JADX WARN: Code duplicated, block: B:127:0x0310  */
    /* JADX WARN: Code duplicated, block: B:128:0x031e  */
    /* JADX WARN: Code duplicated, block: B:129:0x032d  */
    /* JADX WARN: Code duplicated, block: B:132:0x036a  */
    /* JADX WARN: Code duplicated, block: B:133:0x036d  */
    /* JADX WARN: Code duplicated, block: B:289:0x02b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:290:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x020f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x0207 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:297:0x024b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x010f  */
    /* JADX WARN: Code duplicated, block: B:70:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f2 A[LOOP:12: B:71:0x01ea->B:74:0x01f2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x0236  */
    /* JADX WARN: Code duplicated, block: B:82:0x023b A[ADDED_TO_REGION, ALLOW_MULTIPLE_INSNS_LOOP_COND, LOOP:13: B:82:0x023b->B:84:0x023f, LOOP_START, PHI: r14 r23 r24
  0x023b: PHI (r14v12 int) = (r14v10 int), (r14v13 int) binds: [B:80:0x0238, B:84:0x023f] A[DONT_GENERATE, DONT_INLINE]
  0x023b: PHI (r23v3 int) = (r23v1 int), (r23v7 int) binds: [B:80:0x0238, B:84:0x023f] A[DONT_GENERATE, DONT_INLINE]
  0x023b: PHI (r24v5 int) = (r24v1 int), (r24v6 int) binds: [B:80:0x0238, B:84:0x023f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:83:0x023d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x023f A[LOOP:13: B:82:0x023b->B:84:0x023f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:90:0x0262  */
    /* JADX WARN: Code duplicated, block: B:93:0x026a  */
    /* JADX WARN: Code duplicated, block: B:94:0x026c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0271  */
    /* JADX WARN: Code duplicated, block: B:99:0x0279  */
    public static zzajs zze(zzajp zzajpVar, zzfc zzfcVar, zzaej zzaejVar) throws zzaz {
        zzaiq zzaiuVar;
        boolean z;
        int iZzp;
        int iZzp2;
        int iZzp3;
        long[] jArr;
        int[] iArrCopyOf;
        long[] jArr2;
        int[] iArr;
        zzajp zzajpVarZza;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int iZzp4;
        long j;
        long j2;
        long j3;
        int iZzp5;
        int iZzg;
        int i6;
        int iZzp6;
        int i7;
        long[] jArr3;
        int[] iArrCopyOf2;
        int i8;
        long[] jArrCopyOf;
        long j4;
        boolean z2;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        long[] jArr4;
        int[] iArr2;
        long j5;
        int i14;
        int[] iArr3;
        String str;
        long j6;
        boolean zZza;
        int i15;
        int iZzc;
        int i16;
        int i17;
        int i18;
        long[] jArr5;
        int[] iArr4;
        long[] jArr6;
        int i19;
        zzajp zzajpVarZza2;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        int i20;
        int[] iArr8;
        int i21;
        int length;
        long j7;
        zzajp zzajpVarZza3 = zzajpVar;
        zzfd zzfdVarZzb = zzfcVar.zzb(1937011578);
        if (zzfdVarZzb != null) {
            zzaiuVar = new zzait(zzfdVarZzb, zzajpVarZza3.zzg);
        } else {
            zzfd zzfdVarZzb2 = zzfcVar.zzb(1937013298);
            if (zzfdVarZzb2 == null) {
                throw zzaz.zza("Track has no sample table size information", null);
            }
            zzaiuVar = new zzaiu(zzfdVarZzb2);
        }
        int iZzb = zzaiuVar.zzb();
        if (iZzb == 0) {
            return new zzajs(zzajpVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        if (zzajpVarZza3.zzb == 2) {
            long j8 = zzajpVarZza3.zzf;
            if (j8 > 0) {
                zzx zzxVarZzb = zzajpVarZza3.zzg.zzb();
                zzxVarZzb.zzO(iZzb / (j8 / 1000000.0f));
                zzajpVarZza3 = zzajpVarZza3.zza(zzxVarZzb.zzan());
            }
        }
        zzfd zzfdVarZzb3 = zzfcVar.zzb(1937007471);
        if (zzfdVarZzb3 == null) {
            zzfdVarZzb3 = zzfcVar.zzb(1668232756);
            zzfdVarZzb3.getClass();
            z = true;
        } else {
            z = false;
        }
        zzfd zzfdVarZzb4 = zzfcVar.zzb(1937011555);
        zzfdVarZzb4.getClass();
        zzen zzenVar = zzfdVarZzb4.zza;
        zzfd zzfdVarZzb5 = zzfcVar.zzb(1937011827);
        zzfdVarZzb5.getClass();
        zzen zzenVar2 = zzfdVarZzb5.zza;
        zzfd zzfdVarZzb6 = zzfcVar.zzb(1937011571);
        zzen zzenVar3 = zzfdVarZzb6 != null ? zzfdVarZzb6.zza : null;
        zzfd zzfdVarZzb7 = zzfcVar.zzb(1668576371);
        zzen zzenVar4 = zzfdVarZzb7 != null ? zzfdVarZzb7.zza : null;
        zzaim zzaimVar = new zzaim(zzenVar, zzfdVarZzb3.zza, z);
        zzenVar2.zzL(12);
        int iZzp7 = zzenVar2.zzp() - 1;
        int iZzp8 = zzenVar2.zzp();
        int iZzp9 = zzenVar2.zzp();
        if (zzenVar4 != null) {
            zzenVar4.zzL(12);
            iZzp = zzenVar4.zzp();
        } else {
            iZzp = 0;
        }
        if (zzenVar3 != null) {
            zzenVar3.zzL(12);
            iZzp3 = zzenVar3.zzp();
            if (iZzp3 > 0) {
                iZzp2 = zzenVar3.zzp() - 1;
            } else {
                iZzp2 = -1;
                zzenVar3 = null;
            }
        } else {
            iZzp2 = -1;
            iZzp3 = 0;
        }
        int iZza = zzaiuVar.zza();
        zzz zzzVar = zzajpVarZza3.zzg;
        if (iZza != -1) {
            String str2 = zzzVar.zzo;
            if (("audio/raw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/g711-alaw".equals(str2)) && iZzp7 == 0) {
                if (iZzp == 0 && iZzp3 == 0) {
                    int i22 = zzaimVar.zza;
                    long[] jArr7 = new long[i22];
                    int[] iArr9 = new int[i22];
                    while (zzaimVar.zza()) {
                        int i23 = zzaimVar.zzb;
                        jArr7[i23] = zzaimVar.zzd;
                        iArr9[i23] = zzaimVar.zzc;
                    }
                    long j9 = iZzp9;
                    int i24 = 8192 / iZza;
                    int i25 = 0;
                    for (int i26 = 0; i26 < i22; i26++) {
                        int i27 = iArr9[i26];
                        String str3 = zzex.zza;
                        i25 += ((i27 + i24) - 1) / i24;
                    }
                    long[] jArr8 = new long[i25];
                    iArr3 = new int[i25];
                    jArrCopyOf = new long[i25];
                    int[] iArr10 = new int[i25];
                    zzzVar = zzzVar;
                    int i28 = 0;
                    int i29 = 0;
                    int i30 = 0;
                    i14 = 0;
                    int i31 = 0;
                    while (i30 < i22) {
                        int i32 = iArr9[i30];
                        long j10 = jArr7[i30];
                        int i33 = i31;
                        int i34 = i22;
                        int iMax = i14;
                        int i35 = i33;
                        long[] jArr9 = jArr7;
                        int i36 = i32;
                        while (i36 > 0) {
                            int iMin = Math.min(i24, i36);
                            jArr8[i35] = j10;
                            int[] iArr11 = iArr9;
                            int i37 = iZza * iMin;
                            iArr3[i35] = i37;
                            i29 += i37;
                            iMax = Math.max(iMax, i37);
                            jArrCopyOf[i35] = ((long) i28) * j9;
                            iArr10[i35] = 1;
                            j10 += (long) iArr3[i35];
                            i28 += iMin;
                            i36 -= iMin;
                            i35++;
                            i24 = i24;
                            jArr8 = jArr8;
                            iArr9 = iArr11;
                        }
                        i30++;
                        i24 = i24;
                        jArr7 = jArr9;
                        iArr9 = iArr9;
                        int i38 = i35;
                        i14 = iMax;
                        i22 = i34;
                        i31 = i38;
                    }
                    long j11 = j9 * ((long) i28);
                    j5 = i29;
                    zzajpVarZza = zzajpVarZza3;
                    j4 = j11;
                    iArr2 = iArr10;
                    jArr4 = jArr8;
                } else {
                    iZzp7 = 0;
                }
            }
            jArr = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArr2 = new long[iZzb];
            iArr = new int[iZzb];
            zzajpVarZza = zzajpVarZza3;
            i = iZzp7;
            i2 = iZzp;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            iZzp4 = 0;
            j = 0;
            j2 = 0;
            j3 = 0;
            iZzp5 = iZzp8;
            iZzg = 0;
            int i39 = iZzp2;
            i6 = iZzp3;
            iZzp6 = i39;
            while (true) {
                if (i4 < iZzb) {
                    i7 = i3;
                    jArr3 = jArr;
                    iArrCopyOf2 = iArr;
                    i8 = iZzg;
                    jArrCopyOf = jArr2;
                    break;
                }
                j6 = j;
                zZza = true;
                i7 = i3;
                while (true) {
                    if (i7 != 0) {
                        i15 = i7;
                        break;
                    }
                    zZza = zzaimVar.zza();
                    if (zZza) {
                        i15 = 0;
                        break;
                    }
                    int i40 = iZzg;
                    long j12 = zzaimVar.zzd;
                    i7 = zzaimVar.zzc;
                    j6 = j12;
                    zzenVar2 = zzenVar2;
                    iZzg = i40;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzea.zzf("BoxParsers", "Unexpected end of chunk data");
                    long[] jArrCopyOf2 = Arrays.copyOf(jArr, i4);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                    jArr3 = jArrCopyOf2;
                    jArrCopyOf = Arrays.copyOf(jArr2, i4);
                    iArrCopyOf2 = Arrays.copyOf(iArr, i4);
                    iZzb = i4;
                    i8 = iZzg;
                    break;
                }
                if (zzenVar4 != null) {
                    while (iZzp4 == 0) {
                        if (i2 > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        i2--;
                        iZzp4 = zzenVar4.zzp();
                        iZzg = zzenVar4.zzg();
                    }
                    iZzp4--;
                }
                iZzg = iZzg;
                jArr[i4] = j6;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i4] = iZzc;
                zzaiq zzaiqVar = zzaiuVar;
                zzaim zzaimVar2 = zzaimVar;
                j3 += (long) iZzc;
                if (iZzc > i5) {
                    i5 = iZzc;
                }
                jArr2[i4] = j2 + ((long) iZzg);
                if (zzenVar3 == null) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                iArr[i4] = i16;
                if (i4 == iZzp6) {
                    iArr[i4] = 1;
                    i17 = -1;
                    i6--;
                    if (i6 > 0) {
                        zzenVar3.getClass();
                        iZzp6 = zzenVar3.zzp() - 1;
                    }
                } else {
                    i17 = -1;
                }
                j2 += (long) iZzp9;
                i18 = iZzp5 - 1;
                if (i18 == 0) {
                    iZzp5 = i18;
                } else if (i > 0) {
                    i--;
                    iZzp5 = zzenVar2.zzp();
                    iZzp9 = zzenVar2.zzg();
                } else {
                    iZzp5 = 0;
                }
                long j13 = j6 + ((long) iArrCopyOf[i4]);
                i4++;
                i3 = i15 + i17;
                iZzb = iZzb;
                zzaiuVar = zzaiqVar;
                zzaimVar = zzaimVar2;
                zzenVar2 = zzenVar2;
                j = j13;
            }
            j4 = j2 + ((long) i8);
            if (zzenVar4 != null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i2 > 0) {
                    z2 = true;
                    break;
                }
                if (zzenVar4.zzp() != 0) {
                    z2 = false;
                    break;
                }
                zzenVar4.zzg();
                i2--;
            }
            if (i6 == 0) {
                z3 = z2;
                i9 = i6;
                i10 = iZzp5;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
            } else if (iZzp5 == 0) {
                z3 = z2;
                i10 = iZzp5;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
                i9 = 0;
            } else if (i7 == 0) {
                z3 = z2;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
                i9 = 0;
                i10 = 0;
            } else if (i == 0) {
                z3 = z2;
                i11 = i;
                i12 = iZzp4;
                i9 = 0;
                i10 = 0;
                i13 = 0;
            } else if (iZzp4 == 0) {
                if (z2) {
                    iArrCopyOf = iArrCopyOf;
                    zzajpVarZza = zzajpVarZza;
                } else {
                    i9 = 0;
                    i10 = 0;
                    i13 = 0;
                    i11 = 0;
                    i12 = 0;
                    z3 = false;
                }
                jArr4 = jArr3;
                iArr2 = iArrCopyOf2;
                iZzb = iZzb;
                j5 = j3;
                i14 = i5;
                iArr3 = iArrCopyOf;
            } else {
                z3 = z2;
                i12 = iZzp4;
                i9 = 0;
                i10 = 0;
                i13 = 0;
                i11 = 0;
            }
            StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Inconsistent stbl box for track ", zzajpVarZza.zza, ": remainingSynchronizationSamples ", i9, ", remainingSamplesAtTimestampDelta ");
            sbM.append(i10);
            sbM.append(", remainingSamplesInChunk ");
            sbM.append(i13);
            sbM.append(", remainingTimestampDeltaChanges ");
            sbM.append(i11);
            sbM.append(", remainingSamplesAtTimestampOffset ");
            sbM.append(i12);
            if (true != z3) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sbM.append(str);
            zzea.zzf("BoxParsers", sbM.toString());
            jArr4 = jArr3;
            iArr2 = iArrCopyOf2;
            iZzb = iZzb;
            j5 = j3;
            i14 = i5;
            iArr3 = iArrCopyOf;
        } else {
            jArr = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArr2 = new long[iZzb];
            iArr = new int[iZzb];
            zzajpVarZza = zzajpVarZza3;
            i = iZzp7;
            i2 = iZzp;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            iZzp4 = 0;
            j = 0;
            j2 = 0;
            j3 = 0;
            iZzp5 = iZzp8;
            iZzg = 0;
            int i310 = iZzp2;
            i6 = iZzp3;
            iZzp6 = i310;
            while (true) {
                if (i4 < iZzb) {
                    i7 = i3;
                    jArr3 = jArr;
                    iArrCopyOf2 = iArr;
                    i8 = iZzg;
                    jArrCopyOf = jArr2;
                    break;
                }
                j6 = j;
                zZza = true;
                i7 = i3;
                while (true) {
                    if (i7 != 0) {
                        i15 = i7;
                        break;
                    }
                    zZza = zzaimVar.zza();
                    if (zZza) {
                        i15 = 0;
                        break;
                    }
                    int i41 = iZzg;
                    long j14 = zzaimVar.zzd;
                    i7 = zzaimVar.zzc;
                    j6 = j14;
                    zzenVar2 = zzenVar2;
                    iZzg = i41;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzea.zzf("BoxParsers", "Unexpected end of chunk data");
                    long[] jArrCopyOf3 = Arrays.copyOf(jArr, i4);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i4);
                    jArr3 = jArrCopyOf3;
                    jArrCopyOf = Arrays.copyOf(jArr2, i4);
                    iArrCopyOf2 = Arrays.copyOf(iArr, i4);
                    iZzb = i4;
                    i8 = iZzg;
                    break;
                }
                if (zzenVar4 != null) {
                    while (iZzp4 == 0) {
                        if (i2 > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        i2--;
                        iZzp4 = zzenVar4.zzp();
                        iZzg = zzenVar4.zzg();
                    }
                    iZzp4--;
                }
                iZzg = iZzg;
                jArr[i4] = j6;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i4] = iZzc;
                zzaiq zzaiqVar2 = zzaiuVar;
                zzaim zzaimVar3 = zzaimVar;
                j3 += (long) iZzc;
                if (iZzc > i5) {
                    i5 = iZzc;
                }
                jArr2[i4] = j2 + ((long) iZzg);
                if (zzenVar3 == null) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                iArr[i4] = i16;
                if (i4 == iZzp6) {
                    iArr[i4] = 1;
                    i17 = -1;
                    i6--;
                    if (i6 > 0) {
                        zzenVar3.getClass();
                        iZzp6 = zzenVar3.zzp() - 1;
                    }
                } else {
                    i17 = -1;
                }
                j2 += (long) iZzp9;
                i18 = iZzp5 - 1;
                if (i18 == 0) {
                    iZzp5 = i18;
                } else if (i > 0) {
                    i--;
                    iZzp5 = zzenVar2.zzp();
                    iZzp9 = zzenVar2.zzg();
                } else {
                    iZzp5 = 0;
                }
                long j15 = j6 + ((long) iArrCopyOf[i4]);
                i4++;
                i3 = i15 + i17;
                iZzb = iZzb;
                zzaiuVar = zzaiqVar2;
                zzaimVar = zzaimVar3;
                zzenVar2 = zzenVar2;
                j = j15;
            }
            j4 = j2 + ((long) i8);
            if (zzenVar4 != null) {
                z2 = true;
                break;
            }
            while (true) {
                if (i2 > 0) {
                    z2 = true;
                    break;
                }
                if (zzenVar4.zzp() != 0) {
                    z2 = false;
                    break;
                }
                zzenVar4.zzg();
                i2--;
            }
            if (i6 == 0) {
                z3 = z2;
                i9 = i6;
                i10 = iZzp5;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
            } else if (iZzp5 == 0) {
                z3 = z2;
                i10 = iZzp5;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
                i9 = 0;
            } else if (i7 == 0) {
                z3 = z2;
                i11 = i;
                i12 = iZzp4;
                i13 = i7;
                i9 = 0;
                i10 = 0;
            } else if (i == 0) {
                z3 = z2;
                i11 = i;
                i12 = iZzp4;
                i9 = 0;
                i10 = 0;
                i13 = 0;
            } else if (iZzp4 == 0) {
                if (z2) {
                    i9 = 0;
                    i10 = 0;
                    i13 = 0;
                    i11 = 0;
                    i12 = 0;
                    z3 = false;
                } else {
                    iArrCopyOf = iArrCopyOf;
                    zzajpVarZza = zzajpVarZza;
                }
                jArr4 = jArr3;
                iArr2 = iArrCopyOf2;
                iZzb = iZzb;
                j5 = j3;
                i14 = i5;
                iArr3 = iArrCopyOf;
            } else {
                z3 = z2;
                i12 = iZzp4;
                i9 = 0;
                i10 = 0;
                i13 = 0;
                i11 = 0;
            }
            StringBuilder sbM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Inconsistent stbl box for track ", zzajpVarZza.zza, ": remainingSynchronizationSamples ", i9, ", remainingSamplesAtTimestampDelta ");
            sbM2.append(i10);
            sbM2.append(", remainingSamplesInChunk ");
            sbM2.append(i13);
            sbM2.append(", remainingTimestampDeltaChanges ");
            sbM2.append(i11);
            sbM2.append(", remainingSamplesAtTimestampOffset ");
            sbM2.append(i12);
            if (true != z3) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sbM2.append(str);
            zzea.zzf("BoxParsers", sbM2.toString());
            jArr4 = jArr3;
            iArr2 = iArrCopyOf2;
            iZzb = iZzb;
            j5 = j3;
            i14 = i5;
            iArr3 = iArrCopyOf;
        }
        long j16 = zzajpVarZza.zzf;
        if (j16 > 0) {
            long jZzu = zzex.zzu(8 * j5, 1000000L, j16, RoundingMode.HALF_DOWN);
            if (jZzu > 0 && jZzu < 2147483647L) {
                zzx zzxVarZzb2 = zzzVar.zzb();
                zzxVarZzb2.zzC((int) jZzu);
                zzajpVarZza = zzajpVarZza.zza(zzxVarZzb2.zzan());
            }
        }
        long j17 = zzajpVarZza.zzc;
        RoundingMode roundingMode = RoundingMode.DOWN;
        long jZzu2 = zzex.zzu(j4, 1000000L, j17, roundingMode);
        long[] jArr10 = zzajpVarZza.zzi;
        if (jArr10 == null) {
            zzex.zzG(jArrCopyOf, 1000000L, j17);
            return new zzajs(zzajpVarZza, jArr4, iArr3, i14, jArrCopyOf, iArr2, jZzu2);
        }
        int length2 = jArr10.length;
        if (length2 == 1) {
            if (zzajpVarZza.zzb != 1 || (length = jArrCopyOf.length) < 2) {
                jArr5 = jArr4;
                iArr4 = iArr2;
                jArr6 = jArr10;
            } else {
                long[] jArr11 = zzajpVarZza.zzj;
                jArr11.getClass();
                long j18 = jArr11[0];
                long j19 = jArr10[0];
                jArr5 = jArr4;
                iArr4 = iArr2;
                long j20 = zzajpVarZza.zzd;
                long jZzu3 = j18 + zzex.zzu(j19, j17, j20, roundingMode);
                int i42 = length - 1;
                int iMax2 = Math.max(0, Math.min(4, i42));
                int iMax3 = Math.max(0, Math.min(length - 4, i42));
                long j21 = jArrCopyOf[0];
                if (j21 <= j18 && j18 < jArrCopyOf[iMax2] && jArrCopyOf[iMax3] < jZzu3 && jZzu3 <= j4) {
                    long j22 = zzajpVarZza.zzg.zzH;
                    long jZzu4 = zzex.zzu(j18 - j21, j22, j17, roundingMode);
                    long jZzu5 = zzex.zzu(j4 - jZzu3, j22, j17, roundingMode);
                    if (jZzu4 != 0) {
                        j7 = jZzu4;
                    } else if (jZzu5 != 0) {
                        j7 = 0;
                    }
                    if (j7 <= 2147483647L && jZzu5 <= 2147483647L) {
                        zzaejVar.zza = (int) j7;
                        zzaejVar.zzb = (int) jZzu5;
                        zzex.zzG(jArrCopyOf, 1000000L, j17);
                        return new zzajs(zzajpVarZza, jArr5, iArr3, i14, jArrCopyOf, iArr4, zzex.zzu(jArr10[0], 1000000L, j20, roundingMode));
                    }
                }
                jArr6 = jArr10;
            }
            i19 = 1;
            length2 = 1;
        } else {
            jArr5 = jArr4;
            iArr4 = iArr2;
            iZzb = iZzb;
            jArr6 = jArr10;
            i19 = 1;
        }
        if (length2 == i19 && jArr6[0] == 0) {
            long[] jArr12 = zzajpVarZza.zzj;
            jArr12.getClass();
            long j23 = jArr12[0];
            for (int i43 = 0; i43 < jArrCopyOf.length; i43++) {
                jArrCopyOf[i43] = zzex.zzu(jArrCopyOf[i43] - j23, 1000000L, j17, RoundingMode.DOWN);
            }
            return new zzajs(zzajpVarZza, jArr5, iArr3, i14, jArrCopyOf, iArr4, zzex.zzu(j4 - j23, 1000000L, j17, RoundingMode.DOWN));
        }
        int i44 = zzajpVarZza.zzb;
        boolean z4 = i44 == 1;
        long[] jArr13 = zzajpVarZza.zzj;
        int[] iArr12 = new int[length2];
        int[] iArr13 = new int[length2];
        jArr13.getClass();
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        boolean z5 = false;
        while (i47 < jArr6.length) {
            long j24 = jArr13[i47];
            if (j24 != -1) {
                iArr7 = iArr13;
                i20 = i47;
                int i48 = i45;
                int i49 = i46;
                iArr8 = iArr12;
                long jZzu6 = zzex.zzu(jArr6[i47], j17, zzajpVarZza.zzd, RoundingMode.DOWN);
                int i50 = 1;
                iArr8[i20] = zzex.zzd(jArrCopyOf, j24, true, true);
                long j25 = jZzu6 + j24;
                iArr7[i20] = zzex.zza(jArrCopyOf, j25, z4, false);
                int i51 = iArr8[i20];
                while (true) {
                    i21 = iArr8[i20];
                    if (i21 < 0 || (iArr4[i21] & i50) != 0) {
                        break;
                    }
                    iArr8[i20] = i21 - 1;
                    i50 = 1;
                }
                if (i21 < 0) {
                    iArr8[i20] = i51;
                    while (true) {
                        i21 = iArr8[i20];
                        if (i21 >= iArr7[i20] || (iArr4[i21] & 1) != 0) {
                            break;
                        }
                        iArr8[i20] = i21 + 1;
                    }
                }
                if (i44 == 2 && i21 != iArr7[i20]) {
                    while (true) {
                        int i52 = iArr7[i20];
                        if (i52 >= jArrCopyOf.length - 1) {
                            break;
                        }
                        int i53 = i52 + 1;
                        if (jArrCopyOf[i53] > j25) {
                            break;
                        }
                        iArr7[i20] = i53;
                    }
                }
                int i54 = iArr7[i20];
                int i55 = iArr8[i20];
                i45 = (i54 - i55) + i48;
                i46 = i54;
                z5 |= i49 != i55;
            } else {
                iArr7 = iArr13;
                i20 = i47;
                iArr8 = iArr12;
            }
            i47 = i20 + 1;
            zzajpVarZza = zzajpVarZza;
            iArr3 = iArr3;
            iArr13 = iArr7;
            jArr13 = jArr13;
            iArr12 = iArr8;
            jArr6 = jArr6;
        }
        long[] jArr14 = jArr13;
        long[] jArr15 = jArr6;
        int[] iArr14 = iArr13;
        int[] iArr15 = iArr12;
        int[] iArr16 = iArr3;
        zzajp zzajpVar2 = zzajpVarZza;
        int i56 = i45;
        boolean z6 = z5 | (i56 != iZzb);
        long[] jArr16 = z6 ? new long[i56] : jArr5;
        int[] iArr17 = z6 ? new int[i56] : iArr16;
        if (true == z6) {
            i14 = 0;
        }
        int[] iArr18 = z6 ? new int[i56] : iArr4;
        long[] jArr17 = new long[i56];
        int i57 = 0;
        int i58 = 0;
        boolean z7 = false;
        int i59 = i14;
        long[] jArr18 = jArr15;
        long j26 = 0;
        while (i58 < jArr18.length) {
            long j27 = jArr14[i58];
            int i60 = iArr15[i58];
            int i61 = iArr14[i58];
            if (z6) {
                int i62 = i61 - i60;
                System.arraycopy(jArr5, i60, jArr16, i57, i62);
                iArr6 = iArr16;
                System.arraycopy(iArr6, i60, iArr17, i57, i62);
                iArr5 = iArr4;
                System.arraycopy(iArr5, i60, iArr18, i57, i62);
            } else {
                iArr5 = iArr4;
                iArr6 = iArr16;
            }
            int i63 = i57;
            int i64 = i60;
            int i65 = i59;
            boolean z8 = z7;
            int i66 = i63;
            while (i64 < i61) {
                int[] iArr19 = iArr5;
                zzajp zzajpVar3 = zzajpVar2;
                int i67 = i64;
                long j28 = zzajpVar3.zzd;
                RoundingMode roundingMode2 = RoundingMode.DOWN;
                long[] jArr19 = jArr16;
                int[] iArr20 = iArr18;
                int i68 = i65;
                long[] jArr20 = jArr5;
                long[] jArr21 = jArr18;
                int i69 = i61;
                int i70 = i58;
                long jZzu7 = zzex.zzu(j26, 1000000L, j28, roundingMode2);
                long jZzu8 = zzex.zzu(jArrCopyOf[i67] - j27, 1000000L, j17, roundingMode2);
                z8 = (!(jZzu8 >= 0)) | z8;
                jArr17[i66] = jZzu7 + jZzu8;
                if (z6 && iArr17[i66] > i68) {
                    i68 = iArr6[i67];
                }
                i65 = i68;
                i66++;
                i64 = i67 + 1;
                jArr5 = jArr20;
                jArr18 = jArr21;
                i61 = i69;
                jArr16 = jArr19;
                iArr5 = iArr19;
                i58 = i70;
                zzajpVar2 = zzajpVar3;
                iArr18 = iArr20;
            }
            long[] jArr22 = jArr18;
            int i71 = i58;
            j26 += jArr22[i71];
            i58 = i71 + 1;
            iArr16 = iArr6;
            i57 = i66;
            z7 = z8;
            jArr18 = jArr22;
            iArr4 = iArr5;
            i59 = i65;
            zzajpVar2 = zzajpVar2;
            iArr18 = iArr18;
            jArr16 = jArr16;
        }
        long[] jArr23 = jArr16;
        int[] iArr21 = iArr18;
        zzajp zzajpVar4 = zzajpVar2;
        long jZzu9 = zzex.zzu(j26, 1000000L, zzajpVar4.zzd, RoundingMode.DOWN);
        if (z7) {
            zzx zzxVarZzb3 = zzajpVar4.zzg.zzb();
            zzxVarZzb3.zzP(true);
            zzajpVarZza2 = zzajpVar4.zza(zzxVarZzb3.zzan());
        } else {
            zzajpVarZza2 = zzajpVar4;
        }
        return new zzajs(zzajpVarZza2, jArr23, iArr17, i59, jArr17, iArr21, jZzu9);
    }

    /* JADX WARN: Code duplicated, block: B:601:0x0e52  */
    /* JADX WARN: Code duplicated, block: B:602:0x0e57  */
    /* JADX WARN: Code duplicated, block: B:604:0x0e5d  */
    /* JADX WARN: Code duplicated, block: B:606:0x0e6e  */
    /* JADX WARN: Code duplicated, block: B:607:0x0e79  */
    /* JADX WARN: Code duplicated, block: B:610:0x0e93  */
    /* JADX WARN: Code duplicated, block: B:70:0x0182  */
    /* JADX WARN: Code duplicated, block: B:71:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0186  */
    /* JADX WARN: Code duplicated, block: B:73:0x0188 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x018a  */
    /* JADX WARN: Code duplicated, block: B:75:0x018c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0191 A[PHI: r7
  0x0191: PHI (r7v8 int) = (r7v9 int), (r7v5 int) binds: [B:83:0x019a, B:72:0x0186] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0196  */
    /* JADX WARN: Code duplicated, block: B:82:0x0198  */
    /* JADX WARN: Code duplicated, block: B:84:0x019c  */
    /* JADX WARN: Code duplicated, block: B:85:0x019f A[DONT_INVERT, PHI: r7 r8 r15
  0x019f: PHI (r7v6 int) = (r7v5 int), (r7v7 int) binds: [B:69:0x0180, B:79:0x0192] A[DONT_GENERATE, DONT_INLINE]
  0x019f: PHI (r8v6 int) = (r8v5 int), (r8v7 int) binds: [B:69:0x0180, B:79:0x0192] A[DONT_GENERATE, DONT_INLINE]
  0x019f: PHI (r15v6 int) = (r15v5 int), (r15v7 int) binds: [B:69:0x0180, B:79:0x0192] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:89:0x01a7 A[ADDED_TO_REGION] */
    public static List zzf(zzfc zzfcVar, zzaej zzaejVar, long j, zzs zzsVar, boolean z, boolean z2, zzfve zzfveVar) {
        int i;
        String str;
        String str2;
        long j2;
        int i2;
        int i3;
        int i4;
        boolean z3;
        boolean z4;
        long jZzu;
        int i5;
        long jZzu2;
        String str3;
        ArrayList arrayList;
        int i6;
        String str4;
        int i7;
        zzfc zzfcVar2;
        int i8;
        long[] jArr;
        long[] jArr2;
        zzz zzzVarZzan;
        zzajp zzajpVar;
        zzfb zzfbVar;
        zzav zzavVar;
        zzav zzavVar2;
        Pair pairCreate;
        ArrayList arrayList2;
        zzs zzsVarZzb;
        String str5;
        char c;
        char c2;
        int i9;
        int i10;
        zzais zzaisVar;
        int i11;
        int i12;
        zzais zzaisVar2;
        String str6;
        int i13;
        int i14;
        zzfs zzfsVar;
        boolean z5;
        String str7;
        boolean z6;
        String str8;
        boolean z7;
        char c3;
        int i15;
        boolean z8;
        String str9;
        boolean z9;
        boolean z10;
        boolean z11;
        char c4;
        String str10;
        zzfyq zzfyqVarZzo;
        long j3;
        boolean z12;
        int i16;
        boolean z13;
        ArrayList arrayList3;
        int i17;
        String str11 = "video/hevc";
        String str12 = "video/3gpp";
        String str13 = "application/ttml+xml";
        int i18 = 1835297121;
        int i19 = 4;
        int i20 = 8;
        ArrayList arrayList4 = new ArrayList();
        int i21 = 0;
        while (true) {
            List list = zzfcVar.zzc;
            if (i21 >= list.size()) {
                return arrayList4;
            }
            zzfc zzfcVar3 = (zzfc) list.get(i21);
            if (zzfcVar3.zzd != 1953653099) {
                arrayList3 = arrayList4;
                i6 = i21;
                str4 = str11;
                str = str12;
                str2 = str13;
                i7 = i19;
                i17 = i18;
                i8 = i20;
            } else {
                zzfd zzfdVarZzb = zzfcVar.zzb(1836476516);
                zzfdVarZzb.getClass();
                zzfc zzfcVarZza = zzfcVar3.zza(i18);
                zzfcVarZza.getClass();
                zzfd zzfdVarZzb2 = zzfcVarZza.zzb(1751411826);
                zzfdVarZzb2.getClass();
                int iZzi = zzi(zzfdVarZzb2.zza);
                if (iZzi == 1936684398) {
                    i = 1;
                } else if (iZzi == 1986618469) {
                    i = 2;
                } else if (iZzi == 1952807028 || iZzi == 1935832172 || iZzi == 1937072756 || iZzi == 1668047728) {
                    i = 3;
                } else {
                    i = iZzi == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    arrayList = arrayList4;
                    i8 = i20;
                    i6 = i21;
                    zzfcVar2 = zzfcVar3;
                    str4 = str11;
                    str = str12;
                    str2 = str13;
                    i7 = i19;
                    zzajpVar = null;
                } else {
                    zzfd zzfdVarZzb3 = zzfcVar3.zzb(1953196132);
                    zzfdVarZzb3.getClass();
                    zzen zzenVar = zzfdVarZzb3.zza;
                    zzenVar.zzL(i20);
                    int iZza = zza(zzenVar.zzg());
                    if (iZza != 0) {
                        i20 = 16;
                    }
                    zzenVar.zzM(i20);
                    int iZzg = zzenVar.zzg();
                    zzenVar.zzM(i19);
                    int iZzc = zzenVar.zzc();
                    int i22 = 0;
                    while (true) {
                        int i23 = iZza == 0 ? 4 : 8;
                        str = str12;
                        str2 = str13;
                        if (i22 >= i23) {
                            zzenVar.zzM(i23);
                        } else {
                            if (zzenVar.zzN()[iZzc + i22] != -1) {
                                long jZzu3 = iZza == 0 ? zzenVar.zzu() : zzenVar.zzw();
                                if (jZzu3 != 0) {
                                    j2 = jZzu3;
                                    i2 = 10;
                                    break;
                                }
                                break;
                            }
                            i22++;
                            str12 = str;
                            str13 = str2;
                        }
                        i2 = 10;
                        j2 = -9223372036854775807L;
                        break;
                    }
                    zzenVar.zzM(i2);
                    int iZzq = zzenVar.zzq();
                    zzenVar.zzM(4);
                    int iZzg2 = zzenVar.zzg();
                    int iZzg3 = zzenVar.zzg();
                    zzenVar.zzM(4);
                    int iZzg4 = zzenVar.zzg();
                    int iZzg5 = zzenVar.zzg();
                    if (iZzg2 == 0) {
                        if (iZzg3 == 65536) {
                            if (iZzg4 == -65536) {
                                z12 = true;
                                i16 = iZzg4;
                                z13 = iZzg5 != 0;
                            } else if (iZzg4 == 65536) {
                                z13 = iZzg5 != 0;
                                i16 = 65536;
                                z12 = true;
                            } else {
                                iZzg3 = 65536;
                            }
                            if (z12 != z13) {
                                i3 = 90;
                            } else {
                                iZzg3 = 65536;
                                iZzg4 = i16;
                            }
                            i4 = i3;
                        }
                        iZzg2 = 0;
                        if (iZzg2 == 0) {
                            if (iZzg2 != -65536) {
                                i3 = 180;
                                i4 = i3;
                            } else {
                                i3 = 180;
                                i4 = i3;
                            }
                            i4 = 0;
                        } else {
                            if (iZzg3 == -65536) {
                                if (iZzg4 != 65536) {
                                    if (iZzg4 == -65536) {
                                        if (iZzg5 == 0) {
                                            z4 = false;
                                        } else {
                                            z4 = true;
                                        }
                                        z3 = z4;
                                        iZzg4 = -65536;
                                    }
                                    iZzg3 = -65536;
                                } else if (iZzg5 == 0) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                if (true != z3) {
                                    i3 = 270;
                                } else {
                                    iZzg3 = -65536;
                                }
                                i4 = i3;
                            }
                            iZzg2 = 0;
                            if (iZzg2 != -65536) {
                                i3 = 180;
                                i4 = i3;
                            } else {
                                i3 = 180;
                                i4 = i3;
                            }
                            i4 = 0;
                        }
                    } else if (iZzg2 == 0) {
                        if (iZzg3 == -65536) {
                            if (iZzg4 != 65536) {
                                if (iZzg4 == -65536) {
                                    if (iZzg5 == 0) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                    z3 = z4;
                                    iZzg4 = -65536;
                                }
                                iZzg3 = -65536;
                            } else if (iZzg5 == 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (true != z3) {
                                i3 = 270;
                            } else {
                                iZzg3 = -65536;
                            }
                            i4 = i3;
                        }
                        iZzg2 = 0;
                        if (iZzg2 != -65536) {
                            i3 = 180;
                            i4 = i3;
                        } else {
                            i3 = 180;
                            i4 = i3;
                        }
                        i4 = 0;
                    } else if ((iZzg2 != -65536 || iZzg2 == 65536) && iZzg3 == 0 && iZzg4 == 0 && iZzg5 == -65536) {
                        i3 = 180;
                        i4 = i3;
                    } else {
                        i4 = 0;
                    }
                    zzaiv zzaivVar = new zzaiv(iZzg, j2, iZzq, i4);
                    long j4 = j == -9223372036854775807L ? zzaivVar.zzb : j;
                    long j5 = zzd(zzfdVarZzb.zza).zzc;
                    if (j4 == -9223372036854775807L) {
                        i5 = 1835626086;
                        jZzu = -9223372036854775807L;
                    } else {
                        jZzu = zzex.zzu(j4, 1000000L, j5, RoundingMode.DOWN);
                        i5 = 1835626086;
                    }
                    zzfc zzfcVarZza2 = zzfcVarZza.zza(i5);
                    zzfcVarZza2.getClass();
                    zzfc zzfcVarZza3 = zzfcVarZza2.zza(1937007212);
                    zzfcVarZza3.getClass();
                    zzfd zzfdVarZzb4 = zzfcVarZza.zzb(1835296868);
                    zzfdVarZzb4.getClass();
                    zzen zzenVar2 = zzfdVarZzb4.zza;
                    zzenVar2.zzL(8);
                    int iZza2 = zza(zzenVar2.zzg());
                    zzenVar2.zzM(iZza2 != 0 ? 16 : 8);
                    long jZzu4 = zzenVar2.zzu();
                    int iZzc2 = zzenVar2.zzc();
                    int i24 = 0;
                    while (true) {
                        int i25 = iZza2 == 0 ? 4 : 8;
                        if (i24 >= i25) {
                            zzenVar2.zzM(i25);
                        } else {
                            if (zzenVar2.zzN()[iZzc2 + i24] != -1) {
                                long jZzu5 = iZza2 == 0 ? zzenVar2.zzu() : zzenVar2.zzw();
                                if (jZzu5 != 0) {
                                    jZzu2 = zzex.zzu(jZzu5, 1000000L, jZzu4, RoundingMode.DOWN);
                                    break;
                                }
                                break;
                            }
                            i24++;
                        }
                        jZzu2 = -9223372036854775807L;
                        break;
                    }
                    int iZzq2 = zzenVar2.zzq();
                    char c5 = 3;
                    char[] cArr = {(char) (((iZzq2 >> 10) & 31) + 96), (char) (((iZzq2 >> 5) & 31) + 96), (char) ((iZzq2 & 31) + 96)};
                    int i26 = 0;
                    while (true) {
                        if (i26 >= 3) {
                            str3 = new String(cArr);
                            break;
                        }
                        char c6 = cArr[i26];
                        if (c6 < 'a' || c6 > 'z') {
                            str3 = null;
                            break;
                        }
                        i26++;
                    }
                    zzaip zzaipVar = new zzaip(jZzu4, jZzu2, str3);
                    zzfd zzfdVarZzb5 = zzfcVarZza3.zzb(1937011556);
                    if (zzfdVarZzb5 == null) {
                        throw zzaz.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                    }
                    int i27 = zzaivVar.zza;
                    int i28 = zzaivVar.zzd;
                    String str14 = zzaipVar.zzc;
                    zzen zzenVar3 = zzfdVarZzb5.zza;
                    char c7 = '\f';
                    zzenVar3.zzL(12);
                    int iZzg6 = zzenVar3.zzg();
                    zzais zzaisVar3 = new zzais(iZzg6);
                    int i29 = 0;
                    while (i29 < iZzg6) {
                        int i30 = iZzg6;
                        int iZzc3 = zzenVar3.zzc();
                        zzaiv zzaivVar2 = zzaivVar;
                        int iZzg7 = zzenVar3.zzg();
                        boolean z14 = iZzg7 > 0;
                        String str15 = ZRqOdXiy.tlVJMmy;
                        zzadz.zzc(z14, str15);
                        int iZzg8 = zzenVar3.zzg();
                        int i31 = i;
                        int i32 = i28;
                        int iIntValue = 1701733238;
                        if (iZzg8 == 1635148593 || iZzg8 == 1635148595 || iZzg8 == 1701733238 || iZzg8 == 1831958048 || iZzg8 == 1836070006 || iZzg8 == 1752589105 || iZzg8 == 1751479857 || iZzg8 == 1932670515 || iZzg8 == 1211250227 || iZzg8 == 1748121139 || iZzg8 == 1987063864 || iZzg8 == 1987063865 || iZzg8 == 1635135537 || iZzg8 == 1685479798 || iZzg8 == 1685479729 || iZzg8 == 1685481573 || iZzg8 == 1685481521 || iZzg8 == 1634760241) {
                            int i33 = iZzg8;
                            String str16 = str14;
                            arrayList2 = arrayList4;
                            int i34 = i27;
                            i21 = i21;
                            zzfcVar3 = zzfcVar3;
                            str11 = str11;
                            zzais zzaisVar4 = zzaisVar3;
                            i31 = i31;
                            zzenVar3 = zzenVar3;
                            zzenVar3.zzL(iZzc3 + 16);
                            zzenVar3.zzM(16);
                            int iZzq3 = zzenVar3.zzq();
                            int iZzq4 = zzenVar3.zzq();
                            zzenVar3.zzM(50);
                            int iZzc4 = zzenVar3.zzc();
                            if (i33 == 1701733238) {
                                Pair pairZzj = zzj(zzenVar3, iZzc3, iZzg7);
                                if (pairZzj != null) {
                                    iIntValue = ((Integer) pairZzj.first).intValue();
                                    zzsVarZzb = zzsVar == null ? null : zzsVar.zzb(((zzajq) pairZzj.second).zzb);
                                    zzaisVar4.zza[i29] = (zzajq) pairZzj.second;
                                } else {
                                    zzaisVar4 = zzaisVar4;
                                    zzsVarZzb = zzsVar;
                                }
                                zzenVar3.zzL(iZzc4);
                                i33 = iIntValue;
                            } else {
                                zzaisVar4 = zzaisVar4;
                                zzsVarZzb = zzsVar;
                            }
                            if (i33 == 1831958048) {
                                str5 = "video/mpeg";
                            } else if (i33 == 1211250227) {
                                i33 = 1211250227;
                                str5 = str;
                            } else {
                                str5 = null;
                            }
                            i29 = i29;
                            int i35 = i33;
                            zzs zzsVar2 = zzsVarZzb;
                            String str17 = str5;
                            float fZzp = 1.0f;
                            int iZzb = -1;
                            int i36 = 8;
                            zzfs zzfsVar2 = null;
                            int i37 = -1;
                            int i38 = 8;
                            int i39 = -1;
                            int i40 = -1;
                            int i41 = -1;
                            int i42 = -1;
                            ByteBuffer byteBufferZzp = null;
                            byte[] bArrCopyOfRange = null;
                            zzail zzailVarZzn = null;
                            zzain zzainVar = null;
                            int i43 = -1;
                            boolean z15 = false;
                            int i44 = -1;
                            String str18 = null;
                            int i45 = iZzc4;
                            List listZzi = null;
                            while (i45 - iZzc3 < iZzg7) {
                                zzenVar3.zzL(i45);
                                int iZzc5 = zzenVar3.zzc();
                                int iZzg9 = zzenVar3.zzg();
                                if (iZzg9 != 0) {
                                    i11 = iZzg9;
                                } else {
                                    if (zzenVar3.zzc() - iZzc3 == iZzg7) {
                                        break;
                                    }
                                    i11 = 0;
                                }
                                zzadz.zzc(i11 > 0, str15);
                                int iZzg10 = zzenVar3.zzg();
                                int i46 = iZzc3;
                                if (iZzg10 == 1635148611) {
                                    int i47 = iZzc5 + 8;
                                    zzadz.zzc(str17 == null, null);
                                    zzenVar3.zzL(i47);
                                    zzacz zzaczVarZza = zzacz.zza(zzenVar3);
                                    List list2 = zzaczVarZza.zza;
                                    zzaisVar4.zzc = zzaczVarZza.zzb;
                                    if (z15) {
                                        z11 = true;
                                    } else {
                                        fZzp = zzaczVarZza.zzk;
                                        z11 = false;
                                    }
                                    String str19 = zzaczVarZza.zzl;
                                    int i48 = zzaczVarZza.zzj;
                                    int i49 = zzaczVarZza.zzg;
                                    int i50 = zzaczVarZza.zzh;
                                    int i51 = zzaczVarZza.zzi;
                                    int i52 = zzaczVarZza.zze;
                                    i12 = zzaczVarZza.zzf;
                                    str18 = str19;
                                    zzaisVar2 = zzaisVar4;
                                    str6 = str15;
                                    i42 = i48;
                                    iZzb = i51;
                                    i35 = i35;
                                    i38 = i52;
                                    zzfsVar = zzfsVar2;
                                    i40 = i49;
                                    i39 = i50;
                                    str17 = "video/avc";
                                    z15 = z11;
                                    listZzi = list2;
                                } else {
                                    int i53 = i37;
                                    if (iZzg10 == 1752589123) {
                                        int i54 = iZzc5 + 8;
                                        zzadz.zzc(str17 == null, null);
                                        zzenVar3.zzL(i54);
                                        zzaek zzaekVarZza = zzaek.zza(zzenVar3);
                                        List list3 = zzaekVarZza.zza;
                                        zzaisVar4.zzc = zzaekVarZza.zzb;
                                        if (z15) {
                                            z10 = true;
                                        } else {
                                            fZzp = zzaekVarZza.zzl;
                                            z10 = false;
                                        }
                                        int i55 = zzaekVarZza.zzm;
                                        int i56 = zzaekVarZza.zzc;
                                        String str20 = zzaekVarZza.zzn;
                                        int i57 = zzaekVarZza.zzk;
                                        if (i57 == -1) {
                                            i57 = i53;
                                        }
                                        int i58 = zzaekVarZza.zzd;
                                        int i59 = zzaekVarZza.zze;
                                        i40 = zzaekVarZza.zzh;
                                        int i60 = zzaekVarZza.zzi;
                                        int i61 = zzaekVarZza.zzj;
                                        int i62 = zzaekVarZza.zzf;
                                        i12 = zzaekVarZza.zzg;
                                        z15 = z10;
                                        str18 = str20;
                                        zzaisVar2 = zzaisVar4;
                                        str6 = str15;
                                        i44 = i58;
                                        i43 = i59;
                                        str17 = str11;
                                        i35 = i35;
                                        zzfsVar = zzaekVarZza.zzo;
                                        i39 = i60;
                                        i37 = i57;
                                        iZzb = i61;
                                        i38 = i62;
                                        i42 = i55;
                                        listZzi = list3;
                                        i41 = i56;
                                    } else {
                                        if (iZzg10 == 1818785347) {
                                            int i63 = iZzc5 + 8;
                                            String str21 = str11;
                                            zzadz.zzc(str21.equals(str17), "lhvC must follow hvcC atom");
                                            if (zzfsVar2 != null) {
                                                z9 = zzfsVar2.zza.size() >= 2;
                                            } else {
                                                z9 = false;
                                                zzfsVar2 = null;
                                            }
                                            zzadz.zzc(z9, "must have at least two layers");
                                            zzenVar3.zzL(i63);
                                            zzfsVar2.getClass();
                                            zzaek zzaekVarZzb = zzaek.zzb(zzenVar3, zzfsVar2);
                                            zzadz.zzc(zzaisVar4.zzc == zzaekVarZzb.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                            int i64 = zzaekVarZzb.zzh;
                                            if (i64 != -1) {
                                                zzadz.zzc(i40 == i64, "colorSpace must be the same for both views");
                                            }
                                            int i65 = zzaekVarZzb.zzi;
                                            if (i65 != -1) {
                                                zzadz.zzc(i39 == i65, "colorRange must be the same for both views");
                                            }
                                            int i66 = zzaekVarZzb.zzj;
                                            if (i66 != -1) {
                                                zzadz.zzc(iZzb == i66, "colorTransfer must be the same for both views");
                                            }
                                            zzadz.zzc(i38 == zzaekVarZzb.zzf, "bitdepthLuma must be the same for both views");
                                            zzadz.zzc(i36 == zzaekVarZzb.zzg, "bitdepthChroma must be the same for both views");
                                            if (listZzi != null) {
                                                int i67 = zzfyq.zzd;
                                                zzfyn zzfynVar = new zzfyn();
                                                zzfynVar.zzh(listZzi);
                                                zzfynVar.zzh(zzaekVarZzb.zza);
                                                listZzi = zzfynVar.zzi();
                                            } else {
                                                zzadz.zzc(false, "initializationData must be already set from hvcC atom");
                                                listZzi = null;
                                            }
                                            str18 = zzaekVarZzb.zzn;
                                            i12 = i36;
                                            str17 = "video/mv-hevc";
                                            zzaisVar2 = zzaisVar4;
                                            str6 = str15;
                                            str11 = str21;
                                            i37 = i53;
                                            i35 = i35;
                                        } else {
                                            String str22 = str11;
                                            if (iZzg10 == 1986361461) {
                                                zzenVar3.zzL(iZzc5 + 8);
                                                str11 = str22;
                                                int iZzc6 = zzenVar3.zzc();
                                                zzaio zzaioVar = null;
                                                while (iZzc6 - iZzc5 < i11) {
                                                    zzenVar3.zzL(iZzc6);
                                                    int iZzg11 = zzenVar3.zzg();
                                                    zzadz.zzc(iZzg11 > 0, str15);
                                                    int i68 = i36;
                                                    if (zzenVar3.zzg() == 1702454643) {
                                                        zzenVar3.zzL(iZzc6 + 8);
                                                        int iZzc7 = zzenVar3.zzc();
                                                        while (true) {
                                                            if (iZzc7 - iZzc6 >= iZzg11) {
                                                                str9 = str15;
                                                                zzaioVar = null;
                                                                break;
                                                            }
                                                            zzenVar3.zzL(iZzc7);
                                                            int iZzg12 = zzenVar3.zzg();
                                                            zzadz.zzc(iZzg12 > 0, str15);
                                                            str9 = str15;
                                                            if (zzenVar3.zzg() == 1937011305) {
                                                                zzenVar3.zzM(4);
                                                                int iZzm = zzenVar3.zzm();
                                                                zzaioVar = new zzaio(new zzair(1 == (iZzm & 1), (iZzm & 2) == 2, (iZzm & 8) == 8));
                                                                break;
                                                            }
                                                            iZzc7 += iZzg12;
                                                            str15 = str9;
                                                        }
                                                    } else {
                                                        str9 = str15;
                                                    }
                                                    iZzc6 += iZzg11;
                                                    zzaisVar4 = zzaisVar4;
                                                    i36 = i68;
                                                    str15 = str9;
                                                    i38 = i38;
                                                }
                                                i12 = i36;
                                                zzaisVar2 = zzaisVar4;
                                                str6 = str15;
                                                i38 = i38;
                                                zzaiw zzaiwVar = zzaioVar == null ? null : new zzaiw(zzaioVar);
                                                if (zzaiwVar != null) {
                                                    if (zzfsVar2 == null) {
                                                        z8 = true;
                                                        zzfsVar2 = null;
                                                    } else if (zzfsVar2.zza.size() >= 2) {
                                                        zzadz.zzc(zzaiwVar.zzb(), "both eye views must be marked as available");
                                                        zzadz.zzc(!zzaiwVar.zza.zza.zzc, "for MV-HEVC, eye_views_reversed must be set to false");
                                                    } else {
                                                        z8 = true;
                                                    }
                                                    i37 = i53 == -1 ? z8 != zzaiwVar.zza.zza.zzc ? 4 : 5 : i53;
                                                }
                                                i14 = i39;
                                                i13 = i53;
                                                i35 = i35;
                                                zzfsVar = zzfsVar2;
                                            } else {
                                                i12 = i36;
                                                zzaisVar2 = zzaisVar4;
                                                str6 = str15;
                                                str11 = str22;
                                                i38 = i38;
                                                if (iZzg10 == 1685480259 || iZzg10 == 1685485123 || iZzg10 == 1685485379) {
                                                    i13 = i53;
                                                    i14 = i39;
                                                    i35 = i35;
                                                    zzfsVar = zzfsVar2;
                                                    int i69 = i11 - 8;
                                                    int i70 = iZzc5 + 8;
                                                    byte[] bArr = new byte[i69];
                                                    zzenVar3.zzH(bArr, 0, i69);
                                                    if (listZzi != null) {
                                                        int i71 = zzfyq.zzd;
                                                        zzfyn zzfynVar2 = new zzfyn();
                                                        zzfynVar2.zzh(listZzi);
                                                        zzfynVar2.zzf(bArr);
                                                        listZzi = zzfynVar2.zzi();
                                                    } else {
                                                        zzadz.zzc(false, "initializationData must already be set from hvcC or avcC atom");
                                                        listZzi = null;
                                                    }
                                                    zzenVar3.zzL(i70);
                                                    zzez zzezVarZza = zzez.zza(zzenVar3);
                                                    if (zzezVarZza != null) {
                                                        str18 = zzezVarZza.zza;
                                                        str17 = "video/dolby-vision";
                                                    }
                                                } else if (iZzg10 == 1987076931) {
                                                    int i72 = iZzc5 + 12;
                                                    if (str17 == null) {
                                                        str8 = null;
                                                        z7 = true;
                                                    } else {
                                                        str8 = null;
                                                        z7 = false;
                                                    }
                                                    zzadz.zzc(z7, str8);
                                                    zzenVar3.zzL(i72);
                                                    byte bZzm = (byte) zzenVar3.zzm();
                                                    byte bZzm2 = (byte) zzenVar3.zzm();
                                                    int iZzm2 = zzenVar3.zzm();
                                                    int i73 = iZzm2 >> 4;
                                                    int i74 = iZzm2 >> 1;
                                                    int i75 = i35;
                                                    String str23 = i75 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                    if (str23.equals("video/x-vnd.on2.vp9")) {
                                                        int i76 = zzdk.zza;
                                                        i15 = 1;
                                                        c3 = 3;
                                                        listZzi = zzfyq.zzo(new byte[]{1, 1, bZzm, 2, 1, bZzm2, 3, 1, (byte) i73, 4, 1, (byte) (i74 & 7)});
                                                    } else {
                                                        c3 = 3;
                                                        i15 = 1;
                                                    }
                                                    int i77 = iZzm2 & 1;
                                                    int iZzm3 = zzenVar3.zzm();
                                                    int iZzm4 = zzenVar3.zzm();
                                                    int iZza3 = zzk.zza(iZzm3);
                                                    int i78 = i15 != i77 ? 2 : 1;
                                                    i40 = iZza3;
                                                    zzfsVar = zzfsVar2;
                                                    i35 = i75;
                                                    i12 = i73;
                                                    iZzb = zzk.zzb(iZzm4);
                                                    i38 = i12;
                                                    i37 = i53;
                                                    String str24 = str23;
                                                    i39 = i78;
                                                    str17 = str24;
                                                } else {
                                                    int i79 = i35;
                                                    if (iZzg10 == 1635135811) {
                                                        int i80 = i11 - 8;
                                                        byte[] bArr2 = new byte[i80];
                                                        zzenVar3.zzH(bArr2, 0, i80);
                                                        zzfyq zzfyqVarZzo2 = zzfyq.zzo(bArr2);
                                                        zzenVar3.zzL(iZzc5 + 8);
                                                        zzk zzkVarZzl = zzl(zzenVar3);
                                                        int i81 = zzkVarZzl.zzf;
                                                        int i82 = zzkVarZzl.zzg;
                                                        int i83 = zzkVarZzl.zzb;
                                                        i39 = zzkVarZzl.zzc;
                                                        i12 = i82;
                                                        zzfsVar = zzfsVar2;
                                                        i35 = i79;
                                                        i40 = i83;
                                                        i38 = i81;
                                                        i37 = i53;
                                                        listZzi = zzfyqVarZzo2;
                                                        iZzb = zzkVarZzl.zzd;
                                                        str17 = "video/av01";
                                                    } else if (iZzg10 == 1668050025) {
                                                        if (byteBufferZzp == null) {
                                                            byteBufferZzp = zzp();
                                                        }
                                                        ByteBuffer byteBuffer = byteBufferZzp;
                                                        byteBuffer.position(21);
                                                        byteBuffer.putShort(zzenVar3.zzE());
                                                        byteBuffer.putShort(zzenVar3.zzE());
                                                        byteBufferZzp = byteBuffer;
                                                        zzfsVar = zzfsVar2;
                                                        i35 = i79;
                                                        i38 = i38;
                                                        i37 = i53;
                                                    } else {
                                                        if (iZzg10 == 1835295606) {
                                                            if (byteBufferZzp == null) {
                                                                byteBufferZzp = zzp();
                                                            }
                                                            ByteBuffer byteBuffer2 = byteBufferZzp;
                                                            short sZzE = zzenVar3.zzE();
                                                            short sZzE2 = zzenVar3.zzE();
                                                            short sZzE3 = zzenVar3.zzE();
                                                            short sZzE4 = zzenVar3.zzE();
                                                            short sZzE5 = zzenVar3.zzE();
                                                            zzfsVar = zzfsVar2;
                                                            short sZzE6 = zzenVar3.zzE();
                                                            i35 = i79;
                                                            short sZzE7 = zzenVar3.zzE();
                                                            i14 = i39;
                                                            short sZzE8 = zzenVar3.zzE();
                                                            long jZzu6 = zzenVar3.zzu();
                                                            long jZzu7 = zzenVar3.zzu();
                                                            i13 = i53;
                                                            byteBuffer2.position(1);
                                                            byteBuffer2.putShort(sZzE5);
                                                            byteBuffer2.putShort(sZzE6);
                                                            byteBuffer2.putShort(sZzE);
                                                            byteBuffer2.putShort(sZzE2);
                                                            byteBuffer2.putShort(sZzE3);
                                                            byteBuffer2.putShort(sZzE4);
                                                            byteBuffer2.putShort(sZzE7);
                                                            byteBuffer2.putShort(sZzE8);
                                                            byteBuffer2.putShort((short) (jZzu6 / 10000));
                                                            byteBuffer2.putShort((short) (jZzu7 / 10000));
                                                            byteBufferZzp = byteBuffer2;
                                                        } else {
                                                            zzfsVar = zzfsVar2;
                                                            i35 = i79;
                                                            i13 = i53;
                                                            i14 = i39;
                                                            if (iZzg10 == 1681012275) {
                                                                if (str17 == null) {
                                                                    str7 = null;
                                                                    z6 = true;
                                                                } else {
                                                                    str7 = null;
                                                                    z6 = false;
                                                                }
                                                                zzadz.zzc(z6, str7);
                                                                str17 = str;
                                                            } else if (iZzg10 == 1702061171) {
                                                                zzadz.zzc(str17 == null, null);
                                                                zzain zzainVarZzo = zzo(zzenVar3, iZzc5);
                                                                String str25 = zzainVarZzo.zza;
                                                                byte[] bArr3 = zzainVarZzo.zzb;
                                                                if (bArr3 != null) {
                                                                    listZzi = zzfyq.zzo(bArr3);
                                                                }
                                                                zzainVar = zzainVarZzo;
                                                                str17 = str25;
                                                            } else if (iZzg10 == 1651798644) {
                                                                zzailVarZzn = zzn(zzenVar3, iZzc5);
                                                            } else if (iZzg10 == 1885434736) {
                                                                zzenVar3.zzL(iZzc5 + 8);
                                                                fZzp = zzenVar3.zzp() / zzenVar3.zzp();
                                                                i38 = i38;
                                                                i39 = i14;
                                                                i37 = i13;
                                                                z15 = true;
                                                            } else if (iZzg10 == 1937126244) {
                                                                int i84 = iZzc5 + 8;
                                                                while (true) {
                                                                    if (i84 - iZzc5 < i11) {
                                                                        zzenVar3.zzL(i84);
                                                                        int iZzg13 = zzenVar3.zzg() + i84;
                                                                        if (zzenVar3.zzg() == 1886547818) {
                                                                            bArrCopyOfRange = Arrays.copyOfRange(zzenVar3.zzN(), i84, iZzg13);
                                                                        } else {
                                                                            i84 = iZzg13;
                                                                        }
                                                                    } else {
                                                                        i38 = i38;
                                                                        i39 = i14;
                                                                        i37 = i13;
                                                                        bArrCopyOfRange = null;
                                                                    }
                                                                }
                                                            } else if (iZzg10 == 1936995172) {
                                                                int iZzm5 = zzenVar3.zzm();
                                                                zzenVar3.zzM(3);
                                                                if (iZzm5 == 0) {
                                                                    int iZzm6 = zzenVar3.zzm();
                                                                    if (iZzm6 == 0) {
                                                                        i38 = i38;
                                                                        i39 = i14;
                                                                        i37 = 0;
                                                                    } else if (iZzm6 == 1) {
                                                                        i38 = i38;
                                                                        i39 = i14;
                                                                        i37 = 1;
                                                                    } else if (iZzm6 == 2) {
                                                                        i38 = i38;
                                                                        i39 = i14;
                                                                        i37 = 2;
                                                                    } else if (iZzm6 == 3) {
                                                                        i37 = 3;
                                                                        i39 = i14;
                                                                    }
                                                                }
                                                            } else {
                                                                if (iZzg10 == 1634760259) {
                                                                    int i85 = i11 - 12;
                                                                    byte[] bArr4 = new byte[i85];
                                                                    zzenVar3.zzL(iZzc5 + 12);
                                                                    zzenVar3.zzH(bArr4, 0, i85);
                                                                    zzfyq zzfyqVarZzo3 = zzfyq.zzo(bArr4);
                                                                    zzk zzkVarZzk = zzk(new zzen(bArr4));
                                                                    i38 = zzkVarZzk.zzf;
                                                                    i12 = zzkVarZzk.zzg;
                                                                    i40 = zzkVarZzk.zzb;
                                                                    i39 = zzkVarZzk.zzc;
                                                                    listZzi = zzfyqVarZzo3;
                                                                    iZzb = zzkVarZzk.zzd;
                                                                    str17 = "video/apv";
                                                                } else if (iZzg10 == 1668246642 && i40 == -1) {
                                                                    if (iZzb == -1) {
                                                                        int iZzg14 = zzenVar3.zzg();
                                                                        if (iZzg14 == 1852009592 || iZzg14 == 1852009571) {
                                                                            int iZzq5 = zzenVar3.zzq();
                                                                            int iZzq6 = zzenVar3.zzq();
                                                                            zzenVar3.zzM(2);
                                                                            if (i11 != 19) {
                                                                                z5 = false;
                                                                            } else if ((zzenVar3.zzm() & 128) != 0) {
                                                                                i11 = 19;
                                                                                z5 = true;
                                                                            } else {
                                                                                i11 = 19;
                                                                                z5 = false;
                                                                            }
                                                                            int iZza4 = zzk.zza(iZzq5);
                                                                            int i86 = true != z5 ? 2 : 1;
                                                                            i40 = iZza4;
                                                                            iZzb = zzk.zzb(iZzq6);
                                                                            i39 = i86;
                                                                            i38 = i38;
                                                                        } else {
                                                                            zzea.zzf("BoxParsers", "Unsupported color type: ".concat(zzff.zze(iZzg14)));
                                                                            iZzb = -1;
                                                                            i40 = -1;
                                                                        }
                                                                    } else {
                                                                        i40 = -1;
                                                                    }
                                                                }
                                                                i37 = i13;
                                                            }
                                                        }
                                                        i39 = i14;
                                                        i37 = i13;
                                                    }
                                                }
                                            }
                                            i38 = i38;
                                            i39 = i14;
                                            i37 = i13;
                                        }
                                        zzfsVar = zzfsVar2;
                                    }
                                }
                                i45 += i11;
                                zzfsVar2 = zzfsVar;
                                iZzg7 = iZzg7;
                                i35 = i35;
                                iZzc3 = i46;
                                zzaisVar4 = zzaisVar2;
                                i36 = i12;
                                str15 = str6;
                            }
                            int i87 = i36;
                            zzais zzaisVar5 = zzaisVar4;
                            int i88 = i37;
                            int i89 = i38;
                            int i90 = i39;
                            iZzg7 = iZzg7;
                            iZzc3 = iZzc3;
                            c = '\f';
                            c2 = 3;
                            if (str17 == null) {
                                str14 = str16;
                                i10 = i32;
                                i9 = i34;
                                zzaisVar = zzaisVar5;
                            } else {
                                zzx zzxVar = new zzx();
                                i9 = i34;
                                zzxVar.zzR(i9);
                                zzxVar.zzah(str17);
                                zzxVar.zzE(str18);
                                zzxVar.zzam(iZzq3);
                                zzxVar.zzQ(iZzq4);
                                zzxVar.zzK(i44);
                                zzxVar.zzJ(i43);
                                zzxVar.zzad(fZzp);
                                i10 = i32;
                                zzxVar.zzag(i10);
                                zzxVar.zzae(bArrCopyOfRange);
                                zzxVar.zzak(i88);
                                zzxVar.zzT(listZzi);
                                zzxVar.zzY(i42);
                                zzxVar.zzZ(i41);
                                zzxVar.zzL(zzsVar2);
                                str14 = str16;
                                zzxVar.zzW(str14);
                                zzi zziVar = new zzi();
                                zziVar.zzc(i40);
                                zziVar.zzb(i90);
                                zziVar.zzd(iZzb);
                                zziVar.zze(byteBufferZzp != null ? byteBufferZzp.array() : null);
                                zziVar.zzf(i89);
                                zziVar.zza(i87);
                                zzxVar.zzF(zziVar.zzg());
                                if (zzailVarZzn != null) {
                                    zzxVar.zzC(zzgbt.zzf(zzailVarZzn.zza));
                                    zzxVar.zzac(zzgbt.zzf(zzailVarZzn.zzb));
                                } else if (zzainVar != null) {
                                    zzxVar.zzC(zzgbt.zzf(zzainVar.zzc));
                                    zzxVar.zzac(zzgbt.zzf(zzainVar.zzd));
                                }
                                zzz zzzVarZzan2 = zzxVar.zzan();
                                zzaisVar = zzaisVar5;
                                zzaisVar.zzb = zzzVarZzan2;
                            }
                        } else if (iZzg8 == 1836069985 || iZzg8 == 1701733217 || iZzg8 == 1633889587 || iZzg8 == 1700998451 || iZzg8 == 1633889588 || iZzg8 == 1835823201 || iZzg8 == 1685353315 || iZzg8 == 1685353317 || iZzg8 == 1685353320 || iZzg8 == 1685353324 || iZzg8 == 1685353336 || iZzg8 == 1935764850 || iZzg8 == 1935767394 || iZzg8 == 1819304813 || iZzg8 == 1936684916 || iZzg8 == 1953984371 || iZzg8 == 778924082 || iZzg8 == 778924083 || iZzg8 == 1835557169 || iZzg8 == 1835560241 || iZzg8 == 1634492771 || iZzg8 == 1634492791 || iZzg8 == 1970037111 || iZzg8 == 1332770163 || iZzg8 == 1716281667 || iZzg8 == 1767992678 || iZzg8 == 1768973165 || iZzg8 == 1718641517) {
                            char c8 = 13159;
                            char c9 = 16;
                            String str26 = str14;
                            arrayList2 = arrayList4;
                            zzq(zzenVar3, iZzg8, iZzc3, iZzg7, i27, str26, z2, zzsVar, zzaisVar3, i29);
                            zzaisVar = zzaisVar3;
                            str14 = str26;
                            i10 = i32;
                            i9 = i27;
                            c = '\f';
                            c2 = 3;
                        } else if (iZzg8 == 1414810956 || iZzg8 == 1954034535 || iZzg8 == 2004251764 || iZzg8 == 1937010800 || iZzg8 == 1664495672) {
                            zzenVar3.zzL(iZzc3 + 16);
                            if (iZzg8 == 1414810956) {
                                arrayList4 = arrayList4;
                                i21 = i21;
                                str11 = str11;
                                str10 = str2;
                                zzfyqVarZzo = null;
                                j3 = Long.MAX_VALUE;
                                c4 = 13159;
                            } else {
                                i21 = i21;
                                c4 = 13159;
                                if (iZzg8 == 1954034535) {
                                    int i91 = iZzg7 - 16;
                                    byte[] bArr5 = new byte[i91];
                                    zzenVar3.zzH(bArr5, 0, i91);
                                    zzfyqVarZzo = zzfyq.zzo(bArr5);
                                    str10 = "application/x-quicktime-tx3g";
                                } else {
                                    if (iZzg8 == 2004251764) {
                                        str10 = "application/x-mp4-vtt";
                                        zzfyqVarZzo = null;
                                    } else {
                                        str11 = str11;
                                        if (iZzg8 == 1937010800) {
                                            arrayList4 = arrayList4;
                                            j3 = 0;
                                            str10 = str2;
                                            zzfyqVarZzo = null;
                                        } else {
                                            zzaisVar3.zzd = 1;
                                            arrayList4 = arrayList4;
                                            str10 = "application/x-mp4-cea-608";
                                            zzfyqVarZzo = null;
                                            j3 = Long.MAX_VALUE;
                                        }
                                    }
                                    zzx zzxVar2 = new zzx();
                                    zzxVar2.zzR(i27);
                                    zzxVar2.zzah(str10);
                                    zzxVar2.zzW(str14);
                                    zzxVar2.zzal(j3);
                                    zzxVar2.zzT(zzfyqVarZzo);
                                    zzaisVar3.zzb = zzxVar2.zzan();
                                    i9 = i27;
                                    zzaisVar = zzaisVar3;
                                    arrayList2 = arrayList4;
                                    i10 = i32;
                                    c = '\f';
                                    c2 = 3;
                                }
                                j3 = Long.MAX_VALUE;
                            }
                            zzx zzxVar3 = new zzx();
                            zzxVar3.zzR(i27);
                            zzxVar3.zzah(str10);
                            zzxVar3.zzW(str14);
                            zzxVar3.zzal(j3);
                            zzxVar3.zzT(zzfyqVarZzo);
                            zzaisVar3.zzb = zzxVar3.zzan();
                            i9 = i27;
                            zzaisVar = zzaisVar3;
                            arrayList2 = arrayList4;
                            i10 = i32;
                            c = '\f';
                            c2 = 3;
                        } else {
                            if (iZzg8 == 1835365492) {
                                zzenVar3.zzL(iZzc3 + 16);
                                zzenVar3.zzy((char) 0);
                                String strZzy = zzenVar3.zzy((char) 0);
                                if (strZzy != null) {
                                    zzx zzxVar4 = new zzx();
                                    zzxVar4.zzR(i27);
                                    zzxVar4.zzah(strZzy);
                                    zzaisVar3.zzb = zzxVar4.zzan();
                                }
                            } else if (iZzg8 == 1667329389) {
                                zzx zzxVar5 = new zzx();
                                zzxVar5.zzR(i27);
                                zzxVar5.zzah("application/x-camera-motion");
                                zzaisVar3.zzb = zzxVar5.zzan();
                            }
                            i29 = i29;
                            arrayList2 = arrayList4;
                            i9 = i27;
                            i21 = i21;
                            zzfcVar3 = zzfcVar3;
                            str11 = str11;
                            iZzg7 = iZzg7;
                            iZzc3 = iZzc3;
                            zzaisVar = zzaisVar3;
                            i31 = i31;
                            i10 = i32;
                            c2 = 3;
                            zzenVar3 = zzenVar3;
                            c = '\f';
                        }
                        zzenVar3.zzL(iZzc3 + iZzg7);
                        zzsVar = zzsVar;
                        zzaisVar3 = zzaisVar;
                        i27 = i9;
                        i29++;
                        i = i31;
                        i21 = i21;
                        iZzg6 = i30;
                        zzaivVar = zzaivVar2;
                        arrayList4 = arrayList2;
                        zzfcVar3 = zzfcVar3;
                        c5 = c2;
                        i28 = i10;
                        c7 = c;
                        zzenVar3 = zzenVar3;
                        str11 = str11;
                    }
                    int i92 = i;
                    arrayList = arrayList4;
                    i6 = i21;
                    zzfc zzfcVar4 = zzfcVar3;
                    str4 = str11;
                    zzaiv zzaivVar3 = zzaivVar;
                    zzais zzaisVar6 = zzaisVar3;
                    i7 = 4;
                    if (z) {
                        zzfcVar2 = zzfcVar4;
                    } else {
                        zzfcVar2 = zzfcVar4;
                        zzfc zzfcVarZza4 = zzfcVar2.zza(1701082227);
                        if (zzfcVarZza4 != null) {
                            zzfd zzfdVarZzb6 = zzfcVarZza4.zzb(1701606260);
                            if (zzfdVarZzb6 == null) {
                                pairCreate = null;
                                i8 = 8;
                            } else {
                                zzen zzenVar4 = zzfdVarZzb6.zza;
                                i8 = 8;
                                zzenVar4.zzL(8);
                                int iZza5 = zza(zzenVar4.zzg());
                                int iZzp = zzenVar4.zzp();
                                long[] jArr3 = new long[iZzp];
                                long[] jArr4 = new long[iZzp];
                                for (int i93 = 0; i93 < iZzp; i93++) {
                                    jArr3[i93] = iZza5 == 1 ? zzenVar4.zzw() : zzenVar4.zzu();
                                    jArr4[i93] = iZza5 == 1 ? zzenVar4.zzt() : zzenVar4.zzg();
                                    if (zzenVar4.zzE() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    zzenVar4.zzM(2);
                                }
                                pairCreate = Pair.create(jArr3, jArr4);
                            }
                            if (pairCreate != null) {
                                long[] jArr5 = (long[]) pairCreate.first;
                                jArr2 = (long[]) pairCreate.second;
                                jArr = jArr5;
                            }
                            zzzVarZzan = zzaisVar6.zzb;
                            if (zzzVarZzan == null) {
                                zzajpVar = null;
                            } else {
                                if (zzaivVar3.zzc != 0) {
                                    zzfbVar = new zzfb(zzaivVar3.zzc);
                                    zzx zzxVarZzb = zzzVarZzan.zzb();
                                    zzavVar = zzzVarZzan.zzl;
                                    if (zzavVar != null) {
                                        zzavVar2 = zzavVar.zzc(zzfbVar);
                                    } else {
                                        zzavVar2 = new zzav(-9223372036854775807L, zzfbVar);
                                    }
                                    zzxVarZzb.zzaa(zzavVar2);
                                    zzzVarZzan = zzxVarZzb.zzan();
                                }
                                zzajpVar = new zzajp(zzaivVar3.zza, i92, zzaipVar.zza, j5, jZzu, zzaipVar.zzb, zzzVarZzan, zzaisVar6.zzd, zzaisVar6.zza, zzaisVar6.zzc, jArr, jArr2);
                            }
                        }
                        jArr = null;
                        jArr2 = null;
                        zzzVarZzan = zzaisVar6.zzb;
                        if (zzzVarZzan == null) {
                            zzajpVar = null;
                        } else {
                            if (zzaivVar3.zzc != 0) {
                                zzfbVar = new zzfb(zzaivVar3.zzc);
                                zzx zzxVarZzb2 = zzzVarZzan.zzb();
                                zzavVar = zzzVarZzan.zzl;
                                if (zzavVar != null) {
                                    zzavVar2 = zzavVar.zzc(zzfbVar);
                                } else {
                                    zzavVar2 = new zzav(-9223372036854775807L, zzfbVar);
                                }
                                zzxVarZzb2.zzaa(zzavVar2);
                                zzzVarZzan = zzxVarZzb2.zzan();
                            }
                            zzajpVar = new zzajp(zzaivVar3.zza, i92, zzaipVar.zza, j5, jZzu, zzaipVar.zzb, zzzVarZzan, zzaisVar6.zzd, zzaisVar6.zza, zzaisVar6.zzc, jArr, jArr2);
                        }
                    }
                    i8 = 8;
                    jArr = null;
                    jArr2 = null;
                    zzzVarZzan = zzaisVar6.zzb;
                    if (zzzVarZzan == null) {
                        zzajpVar = null;
                    } else {
                        if (zzaivVar3.zzc != 0) {
                            zzfbVar = new zzfb(zzaivVar3.zzc);
                            zzx zzxVarZzb3 = zzzVarZzan.zzb();
                            zzavVar = zzzVarZzan.zzl;
                            if (zzavVar != null) {
                                zzavVar2 = zzavVar.zzc(zzfbVar);
                            } else {
                                zzavVar2 = new zzav(-9223372036854775807L, zzfbVar);
                            }
                            zzxVarZzb3.zzaa(zzavVar2);
                            zzzVarZzan = zzxVarZzb3.zzan();
                        }
                        zzajpVar = new zzajp(zzaivVar3.zza, i92, zzaipVar.zza, j5, jZzu, zzaipVar.zzb, zzzVarZzan, zzaisVar6.zzd, zzaisVar6.zza, zzaisVar6.zzc, jArr, jArr2);
                    }
                }
                zzajp zzajpVar2 = (zzajp) zzfveVar.apply(zzajpVar);
                if (zzajpVar2 != null) {
                    i17 = 1835297121;
                    zzfc zzfcVarZza5 = zzfcVar2.zza(1835297121);
                    zzfcVarZza5.getClass();
                    zzfc zzfcVarZza6 = zzfcVarZza5.zza(1835626086);
                    zzfcVarZza6.getClass();
                    zzfc zzfcVarZza7 = zzfcVarZza6.zza(1937007212);
                    zzfcVarZza7.getClass();
                    zzajs zzajsVarZze = zze(zzajpVar2, zzfcVarZza7, zzaejVar);
                    arrayList3 = arrayList;
                    arrayList3.add(zzajsVarZze);
                } else {
                    arrayList3 = arrayList;
                    i17 = 1835297121;
                }
            }
            i20 = i8;
            i18 = i17;
            i21 = i6 + 1;
            str11 = str4;
            i19 = i7;
            str12 = str;
            str13 = str2;
            arrayList4 = arrayList3;
        }
    }

    public static void zzg(zzen zzenVar) {
        int iZzc = zzenVar.zzc();
        zzenVar.zzM(4);
        if (zzenVar.zzg() != 1751411826) {
            iZzc += 4;
        }
        zzenVar.zzL(iZzc);
    }

    private static int zzh(zzen zzenVar) {
        int iZzm = zzenVar.zzm();
        int i = iZzm & 127;
        while ((iZzm & 128) == 128) {
            iZzm = zzenVar.zzm();
            i = (i << 7) | (iZzm & 127);
        }
        return i;
    }

    private static int zzi(zzen zzenVar) {
        zzenVar.zzL(16);
        return zzenVar.zzg();
    }

    private static Pair zzj(zzen zzenVar, int i, int i2) throws zzaz {
        zzajq zzajqVar;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iZzc = zzenVar.zzc();
        while (iZzc - i < i2) {
            zzenVar.zzL(iZzc);
            int iZzg = zzenVar.zzg();
            zzadz.zzc(iZzg > 0, "childAtomSize must be positive");
            if (zzenVar.zzg() == 1936289382) {
                int i5 = iZzc + 8;
                int i6 = 0;
                int i7 = -1;
                String strZzB = null;
                Integer numValueOf = null;
                while (i5 - iZzc < iZzg) {
                    zzenVar.zzL(i5);
                    int iZzg2 = zzenVar.zzg();
                    int iZzg3 = zzenVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzenVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzenVar.zzM(4);
                        strZzB = zzenVar.zzB(4, StandardCharsets.UTF_8);
                    } else if (iZzg3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzg2;
                    }
                    i5 += iZzg2;
                }
                if ("cenc".equals(strZzB) || "cbc1".equals(strZzB) || "cens".equals(strZzB) || "cbcs".equals(strZzB)) {
                    zzadz.zzc(numValueOf != null, "frma atom is mandatory");
                    zzadz.zzc(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzajqVar = null;
                            break;
                        }
                        zzenVar.zzL(i8);
                        int iZzg4 = zzenVar.zzg();
                        if (zzenVar.zzg() == 1952804451) {
                            int iZza = zza(zzenVar.zzg());
                            zzenVar.zzM(1);
                            if (iZza == 0) {
                                zzenVar.zzM(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iZzm = zzenVar.zzm();
                                int i9 = (iZzm & 240) >> 4;
                                i3 = iZzm & 15;
                                i4 = i9;
                            }
                            boolean z = zzenVar.zzm() == 1;
                            int iZzm2 = zzenVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzenVar.zzH(bArr2, 0, 16);
                            if (z && iZzm2 == 0) {
                                int iZzm3 = zzenVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzenVar.zzH(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            zzajqVar = new zzajq(z, strZzB, iZzm2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzg4;
                    }
                    zzadz.zzc(zzajqVar != null, "tenc atom is mandatory");
                    String str = zzex.zza;
                    pairCreate = Pair.create(numValueOf, zzajqVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzc += iZzg;
        }
        return null;
    }

    private static zzk zzk(zzen zzenVar) {
        zzi zziVar = new zzi();
        byte[] bArrZzN = zzenVar.zzN();
        zzem zzemVar = new zzem(bArrZzN, bArrZzN.length);
        zzemVar.zzl(zzenVar.zzc() * 8);
        zzemVar.zzo(1);
        int iZzd = zzemVar.zzd(8);
        for (int i = 0; i < iZzd; i++) {
            zzemVar.zzo(1);
            int iZzd2 = zzemVar.zzd(8);
            for (int i2 = 0; i2 < iZzd2; i2++) {
                zzemVar.zzn(6);
                boolean zZzp = zzemVar.zzp();
                zzemVar.zzm();
                zzemVar.zzo(11);
                zzemVar.zzn(4);
                int iZzd3 = zzemVar.zzd(4) + 8;
                zziVar.zzf(iZzd3);
                zziVar.zza(iZzd3);
                zzemVar.zzo(1);
                if (zZzp) {
                    int iZzd4 = zzemVar.zzd(8);
                    int iZzd5 = zzemVar.zzd(8);
                    zzemVar.zzo(1);
                    boolean zZzp2 = zzemVar.zzp();
                    zziVar.zzc(zzk.zza(iZzd4));
                    zziVar.zzb(true != zZzp2 ? 2 : 1);
                    zziVar.zzd(zzk.zzb(iZzd5));
                }
            }
        }
        return zziVar.zzg();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0049  */
    /* JADX WARN: Code duplicated, block: B:75:0x0151  */
    /* JADX WARN: Code duplicated, block: B:83:0x016b A[PHI: r3
  0x016b: PHI (r3v5 int) = (r3v4 int), (r3v4 int), (r3v8 int) binds: [B:76:0x015d, B:77:0x015f, B:82:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x017a  */
    private static zzk zzl(zzen zzenVar) {
        int i;
        int iZzd;
        int iZzd2;
        zzi zziVar = new zzi();
        byte[] bArrZzN = zzenVar.zzN();
        zzem zzemVar = new zzem(bArrZzN, bArrZzN.length);
        zzemVar.zzl(zzenVar.zzc() * 8);
        zzemVar.zzo(1);
        int iZzd3 = zzemVar.zzd(3);
        zzemVar.zzn(6);
        boolean zZzp = zzemVar.zzp();
        boolean zZzp2 = zzemVar.zzp();
        boolean z = false;
        if (iZzd3 != 2) {
            if (iZzd3 <= 2) {
                i = true != zZzp ? 8 : 10;
                zziVar.zzf(i);
                zziVar.zza(i);
            }
        } else if (zZzp) {
            i = true == zZzp2 ? 12 : 10;
            zziVar.zzf(i);
            zziVar.zza(i);
        } else {
            zZzp = false;
            iZzd3 = 2;
            if (iZzd3 <= 2) {
                if (true != zZzp) {
                }
                zziVar.zzf(i);
                zziVar.zza(i);
            }
        }
        int i2 = 13;
        zzemVar.zzn(13);
        zzemVar.zzm();
        int iZzd4 = zzemVar.zzd(4);
        if (iZzd4 != 1) {
            zzea.zze("BoxParsers", "Unsupported obu_type: " + iZzd4);
            return zziVar.zzg();
        }
        if (zzemVar.zzp()) {
            zzea.zze("BoxParsers", "Unsupported obu_extension_flag");
            return zziVar.zzg();
        }
        boolean zZzp3 = zzemVar.zzp();
        zzemVar.zzm();
        if (zZzp3 && zzemVar.zzd(8) > 127) {
            zzea.zze("BoxParsers", "Excessive obu_size");
            return zziVar.zzg();
        }
        int iZzd5 = zzemVar.zzd(3);
        zzemVar.zzm();
        if (zzemVar.zzp()) {
            zzea.zze("BoxParsers", "Unsupported reduced_still_picture_header");
            return zziVar.zzg();
        }
        if (zzemVar.zzp()) {
            zzea.zze("BoxParsers", "Unsupported timing_info_present_flag");
            return zziVar.zzg();
        }
        if (zzemVar.zzp()) {
            zzea.zze("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return zziVar.zzg();
        }
        int iZzd6 = zzemVar.zzd(5);
        for (int i3 = 0; i3 <= iZzd6; i3++) {
            zzemVar.zzn(12);
            if (zzemVar.zzd(5) > 7) {
                zzemVar.zzm();
            }
        }
        int iZzd7 = zzemVar.zzd(4);
        int iZzd8 = zzemVar.zzd(4);
        zzemVar.zzn(iZzd7 + 1);
        zzemVar.zzn(iZzd8 + 1);
        if (zzemVar.zzp()) {
            zzemVar.zzn(7);
        }
        zzemVar.zzn(7);
        boolean zZzp4 = zzemVar.zzp();
        if (zZzp4) {
            zzemVar.zzn(2);
        }
        if ((zzemVar.zzp() || zzemVar.zzd(1) > 0) && !zzemVar.zzp()) {
            zzemVar.zzn(1);
        }
        if (zZzp4) {
            zzemVar.zzn(3);
        }
        zzemVar.zzn(3);
        boolean zZzp5 = zzemVar.zzp();
        if (iZzd5 != 2) {
            if (iZzd5 != 1) {
            }
            if (zzemVar.zzp()) {
                int iZzd9 = zzemVar.zzd(8);
                iZzd = zzemVar.zzd(8);
                int iZzd10 = zzemVar.zzd(8);
                if (!z || iZzd9 != 1) {
                    i2 = iZzd;
                    iZzd2 = zzemVar.zzd(1);
                } else if (iZzd != 13) {
                    iZzd9 = 1;
                    i2 = iZzd;
                    iZzd2 = zzemVar.zzd(1);
                } else if (iZzd10 == 0) {
                    iZzd2 = 1;
                    iZzd9 = 1;
                } else {
                    iZzd9 = 1;
                    iZzd2 = zzemVar.zzd(1);
                }
                zziVar.zzc(zzk.zza(iZzd9));
                zziVar.zzb(iZzd2 != 1 ? 2 : 1);
                zziVar.zzd(zzk.zzb(i2));
            }
            return zziVar.zzg();
        }
        if (zZzp5) {
            zzemVar.zzm();
        }
        if (zzemVar.zzp()) {
            z = true;
        }
        if (zzemVar.zzp()) {
            int iZzd11 = zzemVar.zzd(8);
            iZzd = zzemVar.zzd(8);
            int iZzd12 = zzemVar.zzd(8);
            if (!z) {
                i2 = iZzd;
                iZzd2 = zzemVar.zzd(1);
            } else {
                i2 = iZzd;
                iZzd2 = zzemVar.zzd(1);
            }
            zziVar.zzc(zzk.zza(iZzd11));
            zziVar.zzb(iZzd2 != 1 ? 2 : 1);
            zziVar.zzd(zzk.zzb(i2));
        }
        return zziVar.zzg();
    }

    private static zzav zzm(zzen zzenVar) {
        short sZzE = zzenVar.zzE();
        zzenVar.zzM(2);
        String strZzB = zzenVar.zzB(sZzE, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzB.lastIndexOf(43), strZzB.lastIndexOf(45));
        try {
            return new zzav(-9223372036854775807L, new zzfg(Float.parseFloat(strZzB.substring(0, iMax)), Float.parseFloat(strZzB.substring(iMax, strZzB.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzail zzn(zzen zzenVar, int i) {
        zzenVar.zzL(i + 8);
        zzenVar.zzM(4);
        return new zzail(zzenVar.zzu(), zzenVar.zzu());
    }

    private static zzain zzo(zzen zzenVar, int i) {
        zzenVar.zzL(i + 12);
        zzenVar.zzM(1);
        zzh(zzenVar);
        zzenVar.zzM(2);
        int iZzm = zzenVar.zzm();
        if ((iZzm & 128) != 0) {
            zzenVar.zzM(2);
        }
        if ((iZzm & 64) != 0) {
            zzenVar.zzM(zzenVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzenVar.zzM(2);
        }
        zzenVar.zzM(1);
        zzh(zzenVar);
        String strZzd = zzay.zzd(zzenVar.zzm());
        if ("audio/mpeg".equals(strZzd) || "audio/vnd.dts".equals(strZzd) || "audio/vnd.dts.hd".equals(strZzd)) {
            return new zzain(strZzd, null, -1L, -1L);
        }
        zzenVar.zzM(4);
        long jZzu = zzenVar.zzu();
        long jZzu2 = zzenVar.zzu();
        zzenVar.zzM(1);
        int iZzh = zzh(zzenVar);
        byte[] bArr = new byte[iZzh];
        zzenVar.zzH(bArr, 0, iZzh);
        return new zzain(strZzd, bArr, jZzu2 <= 0 ? -1L : jZzu2, jZzu > 0 ? jZzu : -1L);
    }

    private static ByteBuffer zzp() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code duplicated, block: B:135:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:137:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:138:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:141:0x0208  */
    /* JADX WARN: Code duplicated, block: B:143:0x0220  */
    /* JADX WARN: Code duplicated, block: B:144:0x0232  */
    /* JADX WARN: Code duplicated, block: B:147:0x024f  */
    /* JADX WARN: Code duplicated, block: B:149:0x025a  */
    /* JADX WARN: Code duplicated, block: B:150:0x0265  */
    /* JADX WARN: Code duplicated, block: B:152:0x026e  */
    /* JADX WARN: Code duplicated, block: B:154:0x027b  */
    /* JADX WARN: Code duplicated, block: B:156:0x0282  */
    /* JADX WARN: Code duplicated, block: B:157:0x0289  */
    /* JADX WARN: Code duplicated, block: B:160:0x029c  */
    /* JADX WARN: Code duplicated, block: B:161:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:163:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:186:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:187:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:189:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:191:0x030e A[PHI: r10
  0x030e: PHI (r10v13 int) = (r10v14 int), (r10v18 int), (r10v39 int) binds: [B:245:0x04aa, B:243:0x0484, B:190:0x030c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:192:0x0313  */
    /* JADX WARN: Code duplicated, block: B:194:0x031a  */
    /* JADX WARN: Code duplicated, block: B:195:0x032a  */
    /* JADX WARN: Code duplicated, block: B:197:0x032f  */
    /* JADX WARN: Code duplicated, block: B:198:0x033f  */
    /* JADX WARN: Code duplicated, block: B:200:0x0344 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:201:0x0346  */
    /* JADX WARN: Code duplicated, block: B:204:0x0363  */
    /* JADX WARN: Code duplicated, block: B:244:0x04a5  */
    /* JADX WARN: Code duplicated, block: B:246:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:248:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:250:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:253:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:255:0x04dc A[LOOP:2: B:251:0x04cc->B:255:0x04dc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:266:0x0525  */
    /* JADX WARN: Code duplicated, block: B:268:0x0530  */
    /* JADX WARN: Code duplicated, block: B:269:0x053b  */
    /* JADX WARN: Code duplicated, block: B:271:0x0543  */
    /* JADX WARN: Code duplicated, block: B:285:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:294:0x04e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x04ea A[EDGE_INSN: B:295:0x04ea->B:257:0x04ea BREAK  A[LOOP:2: B:251:0x04cc->B:255:0x04dc], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:29:0x0085  */
    /* JADX WARN: Code duplicated, block: B:86:0x0154  */
    private static void zzq(zzen zzenVar, int i, int i2, int i3, int i4, String str, boolean z, zzs zzsVar, zzais zzaisVar, int i5) throws zzaz {
        int i6;
        int iZzg;
        int iRound;
        int iZzp;
        int i7;
        String str2;
        String str3;
        List listZzo;
        zzain zzainVarZzo;
        zzail zzailVarZzn;
        int iZzg2;
        boolean z2;
        int iZzg3;
        int i8;
        int iZzc;
        int i9;
        String str4;
        byte[] bArr;
        String str5;
        String str6;
        zzen zzenVar2;
        int i10;
        int i11;
        int i12;
        int i13;
        int iZzn;
        int iZzm;
        byte[] bArr2;
        int iZzm2;
        byte[] bArr3;
        zzen zzenVar3 = zzenVar;
        int i14 = i;
        int i15 = i2;
        int i16 = i3;
        zzs zzsVarZzb = zzsVar;
        zzenVar3.zzL(i15 + 16);
        if (z) {
            int iZzq = zzenVar.zzq();
            zzenVar3.zzM(6);
            i6 = iZzq;
        } else {
            zzenVar3.zzM(8);
            i6 = 0;
        }
        int i17 = 268435456;
        if (i6 == 0 || i6 == 1) {
            int iZzq2 = zzenVar.zzq();
            zzenVar3.zzM(6);
            int iZzn2 = zzenVar.zzn();
            zzenVar3.zzL(zzenVar.zzc() - 4);
            iZzg = zzenVar.zzg();
            if (i6 == 1) {
                zzenVar3.zzM(16);
            }
            iRound = iZzn2;
            iZzp = iZzq2;
            i7 = -1;
        } else {
            if (i6 != 2) {
                return;
            }
            zzenVar3.zzM(16);
            iRound = (int) Math.round(Double.longBitsToDouble(zzenVar.zzt()));
            iZzp = zzenVar.zzp();
            zzenVar3.zzM(4);
            int iZzp2 = zzenVar.zzp();
            int iZzp3 = zzenVar.zzp();
            int i18 = iZzp3 & 1;
            int i19 = iZzp3 & 2;
            if (i18 == 0) {
                if (iZzp2 == 8) {
                    i7 = 3;
                } else if (iZzp2 == 16) {
                    i7 = i19 != 0 ? 268435456 : 2;
                } else if (iZzp2 == 24) {
                    i7 = i19 != 0 ? 1342177280 : 21;
                } else if (iZzp2 == 32) {
                    i7 = i19 != 0 ? 1610612736 : 22;
                } else {
                    i7 = -1;
                }
            } else if (iZzp2 == 32) {
                i7 = 4;
            } else {
                i7 = -1;
            }
            zzenVar3.zzM(8);
            iZzg = 0;
        }
        if (i14 == 1767992678) {
            iRound = -1;
            iZzp = -1;
        } else {
            if (i14 == 1935764850) {
                iRound = 8000;
            } else if (i14 == 1935767394) {
                iRound = 16000;
                i14 = 1935767394;
            }
            iZzp = 1;
        }
        int iZzc2 = zzenVar.zzc();
        int iIntValue = 1701733217;
        if (i14 == 1701733217) {
            Pair pairZzj = zzj(zzenVar3, i15, i16);
            if (pairZzj != null) {
                iIntValue = ((Integer) pairZzj.first).intValue();
                zzsVarZzb = zzsVarZzb == null ? null : zzsVarZzb.zzb(((zzajq) pairZzj.second).zzb);
                zzaisVar.zza[i5] = (zzajq) pairZzj.second;
            }
            i14 = iIntValue;
            zzenVar3.zzL(iZzc2);
        }
        String str7 = "audio/mhm1";
        if (i14 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i14 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i14 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i14 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i14 == 1685353320 || i14 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i14 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i14 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i14 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (i14 != 1935767394) {
                if (i14 != 1936684916) {
                    if (i14 != 1953984371) {
                        if (i14 == 1819304813) {
                            if (i7 == -1) {
                                i14 = i14;
                                str2 = "audio/raw";
                                i17 = 2;
                            } else {
                                i17 = i7;
                            }
                        } else if (i14 == 778924082 || i14 == 778924083) {
                            str2 = "audio/mpeg";
                        } else if (i14 == 1835557169) {
                            str2 = "audio/mha1";
                        } else if (i14 == 1835560241) {
                            i14 = i14;
                            i17 = i7;
                            str2 = "audio/mhm1";
                        } else if (i14 == 1634492771) {
                            str2 = "audio/alac";
                        } else if (i14 == 1634492791) {
                            str2 = "audio/g711-alaw";
                        } else if (i14 == 1970037111) {
                            str2 = "audio/g711-mlaw";
                        } else if (i14 == 1332770163) {
                            str2 = "audio/opus";
                        } else if (i14 == 1716281667) {
                            str2 = "audio/flac";
                        } else if (i14 == 1835823201) {
                            str2 = jIKWv.QKDdVKWB;
                        } else if (i14 == 1767992678) {
                            i14 = 1767992678;
                            i17 = i7;
                            str2 = xPQrbOSWiEdU.IKlqtNhZqCGNVEI;
                        } else {
                            i14 = i14;
                            i17 = i7;
                            str2 = null;
                        }
                    }
                    str2 = "audio/raw";
                } else {
                    i14 = i14;
                    str2 = "audio/raw";
                    i17 = 2;
                }
                str3 = null;
                listZzo = null;
                zzainVarZzo = null;
                zzailVarZzn = null;
                while (iZzc2 - i15 < i16) {
                    zzenVar3.zzL(iZzc2);
                    iZzg2 = zzenVar.zzg();
                    if (iZzg2 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String str8 = "childAtomSize must be positive";
                    zzadz.zzc(z2, "childAtomSize must be positive");
                    iZzg3 = zzenVar.zzg();
                    iRound = iRound;
                    if (iZzg3 == 1835557187) {
                        zzenVar3.zzL(iZzc2 + 8);
                        zzenVar3.zzM(1);
                        iZzm2 = zzenVar.zzm();
                        zzenVar3.zzM(1);
                        if (Objects.equals(str2, str7)) {
                            i8 = 0;
                            str5 = String.format("mhm1.%02X", Integer.valueOf(iZzm2));
                        } else {
                            i8 = 0;
                            str5 = String.format("mha1.%02X", Integer.valueOf(iZzm2));
                        }
                        int iZzq3 = zzenVar.zzq();
                        bArr3 = new byte[iZzq3];
                        zzenVar3.zzH(bArr3, i8, iZzq3);
                        if (listZzo == null) {
                            listZzo = zzfyq.zzo(bArr3);
                        } else {
                            listZzo = zzfyq.zzp(bArr3, (byte[]) listZzo.get(i8));
                        }
                    } else {
                        str7 = str7;
                        i8 = 0;
                        if (iZzg3 == 1835557200) {
                            zzenVar3.zzL(iZzc2 + 8);
                            iZzm = zzenVar.zzm();
                            if (iZzm > 0) {
                                bArr2 = new byte[iZzm];
                                zzenVar3.zzH(bArr2, 0, iZzm);
                                if (listZzo == null) {
                                    listZzo = zzfyq.zzo(bArr2);
                                    str5 = str3;
                                } else {
                                    listZzo = zzfyq.zzp((byte[]) listZzo.get(0), bArr2);
                                    str5 = str3;
                                    iRound = iRound;
                                    i14 = i14;
                                }
                            } else {
                                iRound = iRound;
                                str5 = str3;
                            }
                        } else {
                            if (iZzg3 == 1702061171) {
                                iRound = iRound;
                                iZzc = iZzc2;
                                i9 = -1;
                            } else if (z || iZzg3 != 2002876005) {
                                if (iZzg3 == 1651798644) {
                                    zzailVarZzn = zzn(zzenVar3, iZzc2);
                                } else {
                                    if (iZzg3 == 1684103987) {
                                        zzenVar3.zzL(iZzc2 + 8);
                                        zzaisVar.zzb = zzacu.zzc(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                                    } else if (iZzg3 == 1684366131) {
                                        zzenVar3.zzL(iZzc2 + 8);
                                        zzaisVar.zzb = zzacu.zzd(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                                    } else if (iZzg3 == 1684103988) {
                                        zzenVar3.zzL(iZzc2 + 8);
                                        zzaisVar.zzb = zzacy.zza(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                                    } else if (iZzg3 != 1684892784) {
                                        if (iZzg > 0) {
                                            throw zzaz.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                                        }
                                        str5 = str3;
                                        i14 = i14;
                                        iRound = iZzg;
                                        iZzp = 2;
                                    } else if (iZzg3 != 1684305011 || iZzg3 == 1969517683) {
                                        zzx zzxVar = new zzx();
                                        zzxVar.zzR(i4);
                                        zzxVar.zzah(str2);
                                        zzxVar.zzD(iZzp);
                                        iRound = iRound;
                                        zzxVar.zzai(iRound);
                                        zzxVar.zzL(zzsVarZzb);
                                        zzxVar.zzW(str);
                                        zzaisVar.zzb = zzxVar.zzan();
                                        str5 = str3;
                                    } else if (iZzg3 == 1682927731) {
                                        int i20 = iZzg2 - 8;
                                        byte[] bArr4 = zzb;
                                        int length = bArr4.length;
                                        byte[] bArrCopyOf = Arrays.copyOf(bArr4, length + i20);
                                        zzenVar3.zzL(iZzc2 + 8);
                                        zzenVar3.zzH(bArrCopyOf, length, i20);
                                        listZzo = zzaeq.zze(bArrCopyOf);
                                    } else {
                                        if (iZzg3 == 1684425825) {
                                            byte[] bArr5 = new byte[iZzg2 - 8];
                                            bArr5[0] = 102;
                                            bArr5[1] = 76;
                                            bArr5[2] = 97;
                                            bArr5[3] = 67;
                                            zzenVar3.zzL(iZzc2 + 12);
                                            zzenVar3.zzH(bArr5, 4, iZzg2 - 12);
                                            zzfyq zzfyqVarZzo = zzfyq.zzo(bArr5);
                                            str5 = str3;
                                            listZzo = zzfyqVarZzo;
                                        } else if (iZzg3 == 1634492771) {
                                            int i21 = iZzg2 - 12;
                                            byte[] bArr6 = new byte[i21];
                                            zzenVar3.zzL(iZzc2 + 12);
                                            zzenVar3.zzH(bArr6, 0, i21);
                                            int i22 = zzdk.zza;
                                            zzen zzenVar4 = new zzen(bArr6);
                                            zzenVar4.zzL(9);
                                            int iZzm3 = zzenVar4.zzm();
                                            zzenVar4.zzL(20);
                                            Pair pairCreate = Pair.create(Integer.valueOf(zzenVar4.zzp()), Integer.valueOf(iZzm3));
                                            int iIntValue2 = ((Integer) pairCreate.first).intValue();
                                            int iIntValue3 = ((Integer) pairCreate.second).intValue();
                                            zzfyq zzfyqVarZzo2 = zzfyq.zzo(bArr6);
                                            str5 = str3;
                                            iZzp = iIntValue3;
                                            listZzo = zzfyqVarZzo2;
                                            i14 = i14;
                                            iRound = iIntValue2;
                                        } else if (iZzg3 == 1767990114) {
                                            zzenVar3.zzL(iZzc2 + 9);
                                            int iZzb = zzgbt.zzb(zzenVar.zzv());
                                            byte[] bArr7 = new byte[iZzb];
                                            zzenVar3.zzH(bArr7, 0, iZzb);
                                            listZzo = zzfyq.zzo(bArr7);
                                        } else if (iZzg3 == 1885564227) {
                                            zzenVar3.zzL(iZzc2 + 12);
                                            ByteOrder byteOrder = (zzenVar.zzm() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                            int iZzm4 = zzenVar.zzm();
                                            if (i14 == 1768973165) {
                                                iZzn = zzex.zzn(iZzm4, byteOrder);
                                            } else {
                                                iZzn = (i14 == 1718641517 && iZzm4 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : i17;
                                            }
                                            str5 = str3;
                                            i17 = iZzn;
                                            if (iZzn != -1) {
                                                str2 = "audio/raw";
                                            }
                                        }
                                        iRound = iRound;
                                        i14 = i14;
                                    }
                                    iRound = iRound;
                                    str5 = str3;
                                }
                                str5 = str3;
                                iRound = iRound;
                                i14 = i14;
                            } else {
                                iZzc = zzenVar.zzc();
                                zzadz.zzc(iZzc >= iZzc2, null);
                                while (true) {
                                    if (iZzc - iZzc2 >= iZzg2) {
                                        iZzc = -1;
                                        break;
                                    }
                                    zzenVar3.zzL(iZzc);
                                    int iZzg4 = zzenVar.zzg();
                                    zzadz.zzc(iZzg4 > 0, str8);
                                    String str9 = str8;
                                    if (zzenVar.zzg() == 1702061171) {
                                        break;
                                    }
                                    iZzc += iZzg4;
                                    str8 = str9;
                                }
                                i9 = -1;
                            }
                            if (iZzc != i9) {
                                zzainVarZzo = zzo(zzenVar3, iZzc);
                                str4 = zzainVarZzo.zza;
                                bArr = zzainVarZzo.zzb;
                                if (bArr != null) {
                                    if ("audio/vorbis".equals(str4)) {
                                        zzenVar2 = new zzen(bArr);
                                        i10 = 1;
                                        zzenVar2.zzM(1);
                                        i11 = 0;
                                        while (true) {
                                            if (zzenVar2.zza() > 0) {
                                                i14 = i14;
                                                i12 = 255;
                                                break;
                                            }
                                            i14 = i14;
                                            i12 = 255;
                                            if (zzenVar2.zzf() == 255) {
                                                break;
                                            }
                                            zzenVar2.zzM(i10);
                                            i11 += 255;
                                            i14 = i14;
                                            i10 = 1;
                                        }
                                        int iZzm5 = zzenVar2.zzm() + i11;
                                        i13 = 0;
                                        while (zzenVar2.zza() > 0 && zzenVar2.zzf() == i12) {
                                            zzenVar2.zzM(1);
                                            i13 += i12;
                                        }
                                        int iZzm6 = zzenVar2.zzm() + i13;
                                        byte[] bArr8 = new byte[iZzm5];
                                        int iZzc3 = zzenVar2.zzc();
                                        System.arraycopy(bArr, iZzc3, bArr8, 0, iZzm5);
                                        int i23 = iZzc3 + iZzm5 + iZzm6;
                                        int length2 = bArr.length - i23;
                                        byte[] bArr9 = new byte[length2];
                                        System.arraycopy(bArr, i23, bArr9, 0, length2);
                                        listZzo = zzfyq.zzp(bArr8, bArr9);
                                    } else {
                                        i14 = i14;
                                        if ("audio/mp4a-latm".equals(str4)) {
                                            zzacp zzacpVarZza = zzacr.zza(bArr);
                                            iRound = zzacpVarZza.zza;
                                            iZzp = zzacpVarZza.zzb;
                                            str6 = zzacpVarZza.zzc;
                                        } else {
                                            str6 = str3;
                                        }
                                        listZzo = zzfyq.zzo(bArr);
                                        str5 = str6;
                                    }
                                    str2 = str4;
                                } else {
                                    i14 = i14;
                                }
                                str5 = str3;
                                str2 = str4;
                            } else {
                                str5 = str3;
                            }
                        }
                        iZzc2 += iZzg2;
                        zzenVar3 = zzenVar;
                        i15 = i2;
                        str3 = str5;
                        i14 = i14;
                        str7 = str7;
                        i16 = i3;
                    }
                    iRound = iRound;
                    i14 = i14;
                    iZzc2 += iZzg2;
                    zzenVar3 = zzenVar;
                    i15 = i2;
                    str3 = str5;
                    i14 = i14;
                    str7 = str7;
                    i16 = i3;
                }
                if (zzaisVar.zzb == null || str2 == null) {
                }
                zzx zzxVar2 = new zzx();
                zzxVar2.zzR(i4);
                zzxVar2.zzah(str2);
                zzxVar2.zzE(str3);
                zzxVar2.zzD(iZzp);
                zzxVar2.zzai(iRound);
                zzxVar2.zzab(i17);
                zzxVar2.zzT(listZzo);
                zzxVar2.zzL(zzsVarZzb);
                zzxVar2.zzW(str);
                if (zzainVarZzo != null) {
                    zzxVar2.zzC(zzgbt.zzf(zzainVarZzo.zzc));
                    zzxVar2.zzac(zzgbt.zzf(zzainVarZzo.zzd));
                } else if (zzailVarZzn != null) {
                    zzxVar2.zzC(zzgbt.zzf(zzailVarZzn.zza));
                    zzxVar2.zzac(zzgbt.zzf(zzailVarZzn.zzb));
                }
                zzaisVar.zzb = zzxVar2.zzan();
                return;
            }
            str2 = "audio/amr-wb";
        }
        i14 = i14;
        i17 = i7;
        str3 = null;
        listZzo = null;
        zzainVarZzo = null;
        zzailVarZzn = null;
        while (iZzc2 - i15 < i16) {
            zzenVar3.zzL(iZzc2);
            iZzg2 = zzenVar.zzg();
            if (iZzg2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            String str10 = "childAtomSize must be positive";
            zzadz.zzc(z2, "childAtomSize must be positive");
            iZzg3 = zzenVar.zzg();
            iRound = iRound;
            if (iZzg3 == 1835557187) {
                zzenVar3.zzL(iZzc2 + 8);
                zzenVar3.zzM(1);
                iZzm2 = zzenVar.zzm();
                zzenVar3.zzM(1);
                if (Objects.equals(str2, str7)) {
                    i8 = 0;
                    str5 = String.format("mhm1.%02X", Integer.valueOf(iZzm2));
                } else {
                    i8 = 0;
                    str5 = String.format("mha1.%02X", Integer.valueOf(iZzm2));
                }
                int iZzq4 = zzenVar.zzq();
                bArr3 = new byte[iZzq4];
                zzenVar3.zzH(bArr3, i8, iZzq4);
                if (listZzo == null) {
                    listZzo = zzfyq.zzo(bArr3);
                } else {
                    listZzo = zzfyq.zzp(bArr3, (byte[]) listZzo.get(i8));
                }
            } else {
                str7 = str7;
                i8 = 0;
                if (iZzg3 == 1835557200) {
                    zzenVar3.zzL(iZzc2 + 8);
                    iZzm = zzenVar.zzm();
                    if (iZzm > 0) {
                        bArr2 = new byte[iZzm];
                        zzenVar3.zzH(bArr2, 0, iZzm);
                        if (listZzo == null) {
                            listZzo = zzfyq.zzo(bArr2);
                            str5 = str3;
                        } else {
                            listZzo = zzfyq.zzp((byte[]) listZzo.get(0), bArr2);
                            str5 = str3;
                            iRound = iRound;
                            i14 = i14;
                        }
                    } else {
                        iRound = iRound;
                        str5 = str3;
                    }
                } else {
                    if (iZzg3 == 1702061171) {
                        if (z) {
                        }
                        if (iZzg3 == 1651798644) {
                            zzailVarZzn = zzn(zzenVar3, iZzc2);
                        } else {
                            if (iZzg3 == 1684103987) {
                                zzenVar3.zzL(iZzc2 + 8);
                                zzaisVar.zzb = zzacu.zzc(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                            } else if (iZzg3 == 1684366131) {
                                zzenVar3.zzL(iZzc2 + 8);
                                zzaisVar.zzb = zzacu.zzd(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                            } else if (iZzg3 == 1684103988) {
                                zzenVar3.zzL(iZzc2 + 8);
                                zzaisVar.zzb = zzacy.zza(zzenVar3, Integer.toString(i4), str, zzsVarZzb);
                            } else if (iZzg3 != 1684892784) {
                                if (iZzg3 != 1684305011) {
                                }
                                zzx zzxVar3 = new zzx();
                                zzxVar3.zzR(i4);
                                zzxVar3.zzah(str2);
                                zzxVar3.zzD(iZzp);
                                iRound = iRound;
                                zzxVar3.zzai(iRound);
                                zzxVar3.zzL(zzsVarZzb);
                                zzxVar3.zzW(str);
                                zzaisVar.zzb = zzxVar3.zzan();
                                str5 = str3;
                            } else {
                                if (iZzg > 0) {
                                    throw zzaz.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                                }
                                str5 = str3;
                                i14 = i14;
                                iRound = iZzg;
                                iZzp = 2;
                            }
                            iRound = iRound;
                            str5 = str3;
                        }
                        str5 = str3;
                        iRound = iRound;
                        i14 = i14;
                    } else {
                        iRound = iRound;
                        iZzc = iZzc2;
                        i9 = -1;
                    }
                    if (iZzc != i9) {
                        zzainVarZzo = zzo(zzenVar3, iZzc);
                        str4 = zzainVarZzo.zza;
                        bArr = zzainVarZzo.zzb;
                        if (bArr != null) {
                            if ("audio/vorbis".equals(str4)) {
                                zzenVar2 = new zzen(bArr);
                                i10 = 1;
                                zzenVar2.zzM(1);
                                i11 = 0;
                                while (true) {
                                    if (zzenVar2.zza() > 0) {
                                        i14 = i14;
                                        i12 = 255;
                                        break;
                                    }
                                    i14 = i14;
                                    i12 = 255;
                                    if (zzenVar2.zzf() == 255) {
                                        break;
                                        break;
                                    }
                                    zzenVar2.zzM(i10);
                                    i11 += 255;
                                    i14 = i14;
                                    i10 = 1;
                                }
                                int iZzm7 = zzenVar2.zzm() + i11;
                                i13 = 0;
                                while (zzenVar2.zza() > 0) {
                                    zzenVar2.zzM(1);
                                    i13 += i12;
                                }
                                int iZzm8 = zzenVar2.zzm() + i13;
                                byte[] bArr10 = new byte[iZzm7];
                                int iZzc4 = zzenVar2.zzc();
                                System.arraycopy(bArr, iZzc4, bArr10, 0, iZzm7);
                                int i24 = iZzc4 + iZzm7 + iZzm8;
                                int length3 = bArr.length - i24;
                                byte[] bArr11 = new byte[length3];
                                System.arraycopy(bArr, i24, bArr11, 0, length3);
                                listZzo = zzfyq.zzp(bArr10, bArr11);
                            } else {
                                i14 = i14;
                                if ("audio/mp4a-latm".equals(str4)) {
                                    zzacp zzacpVarZza2 = zzacr.zza(bArr);
                                    iRound = zzacpVarZza2.zza;
                                    iZzp = zzacpVarZza2.zzb;
                                    str6 = zzacpVarZza2.zzc;
                                } else {
                                    str6 = str3;
                                }
                                listZzo = zzfyq.zzo(bArr);
                                str5 = str6;
                            }
                            str2 = str4;
                        } else {
                            i14 = i14;
                        }
                        str5 = str3;
                        str2 = str4;
                    } else {
                        str5 = str3;
                    }
                }
                iZzc2 += iZzg2;
                zzenVar3 = zzenVar;
                i15 = i2;
                str3 = str5;
                i14 = i14;
                str7 = str7;
                i16 = i3;
            }
            iRound = iRound;
            i14 = i14;
            iZzc2 += iZzg2;
            zzenVar3 = zzenVar;
            i15 = i2;
            str3 = str5;
            i14 = i14;
            str7 = str7;
            i16 = i3;
        }
        if (zzaisVar.zzb == null) {
        }
    }
}
