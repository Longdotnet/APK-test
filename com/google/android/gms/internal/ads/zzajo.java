package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzajo {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzaey zza(zzadw zzadwVar) {
        return zzc(zzadwVar, true, false);
    }

    public static zzaey zzb(zzadw zzadwVar, boolean z) {
        return zzc(zzadwVar, false, z);
    }

    private static zzaey zzc(zzadw zzadwVar, boolean z, boolean z2) {
        int i;
        zzen zzenVar;
        int i2;
        int[] iArr;
        long jZzd = zzadwVar.zzd();
        long j = -1;
        long j2 = 4096;
        if (jZzd != -1 && jZzd <= 4096) {
            j2 = jZzd;
        }
        zzen zzenVar2 = new zzen(64);
        int i3 = (int) j2;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        while (i5 < i3) {
            zzenVar2.zzI(8);
            boolean z4 = true;
            if (!zzadwVar.zzm(zzenVar2.zzN(), i4, 8, true)) {
                break;
            }
            long jZzu = zzenVar2.zzu();
            int iZzg = zzenVar2.zzg();
            if (jZzu == 1) {
                zzadwVar.zzh(zzenVar2.zzN(), 8, 8);
                i = 16;
                zzenVar2.zzK(16);
                jZzu = zzenVar2.zzt();
            } else {
                if (jZzu == 0) {
                    long jZzd2 = zzadwVar.zzd();
                    if (jZzd2 != j) {
                        jZzu = (jZzd2 - zzadwVar.zze()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = jZzu;
            long j4 = i;
            if (j3 < j4) {
                return new zzaik(iZzg, j3, i);
            }
            i5 += i;
            if (iZzg == 1836019574) {
                i3 += (int) j3;
                if (jZzd != -1 && i3 > jZzd) {
                    i3 = (int) jZzd;
                }
                zzenVar2 = zzenVar2;
                j = -1;
                i4 = 0;
            } else {
                if (iZzg == 1836019558 || iZzg == 1836475768) {
                    i4 = 1;
                    break;
                }
                z3 |= !(iZzg != 1835295092);
                long j5 = jZzd;
                if ((((long) i5) + j3) - j4 >= i3) {
                    i4 = 0;
                    break;
                }
                int i6 = (int) (j3 - j4);
                i5 += i6;
                if (iZzg != 1718909296) {
                    zzenVar = zzenVar2;
                    i2 = 0;
                    if (i6 != 0) {
                        zzadwVar.zzg(i6);
                    }
                } else {
                    if (i6 < 8) {
                        return new zzaik(1718909296, i6, 8);
                    }
                    zzenVar = zzenVar2;
                    zzenVar.zzI(i6);
                    i2 = 0;
                    zzadwVar.zzh(zzenVar.zzN(), 0, i6);
                    int iZzg2 = zzenVar.zzg();
                    boolean zZzd = zzd(iZzg2, z2) | z3;
                    zzenVar.zzM(4);
                    int iZza = zzenVar.zza() / 4;
                    if (!zZzd && iZza > 0) {
                        iArr = new int[iZza];
                        int i7 = 0;
                        while (true) {
                            if (i7 >= iZza) {
                                z4 = zZzd;
                                break;
                            }
                            int iZzg3 = zzenVar.zzg();
                            iArr[i7] = iZzg3;
                            if (zzd(iZzg3, z2)) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z4 = zZzd;
                        iArr = null;
                    }
                    if (!z4) {
                        return new zzajt(iZzg2, iArr);
                    }
                    z3 = z4;
                }
                zzenVar2 = zzenVar;
                i4 = i2;
                jZzd = j5;
                j = -1;
            }
        }
        if (!z3) {
            return zzajk.zza;
        }
        if (z != i4) {
            return i4 != 0 ? zzaje.zza : zzaje.zzb;
        }
        return null;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
