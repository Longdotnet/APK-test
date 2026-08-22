package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaek {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final String zzn;
    public final zzfs zzo;

    private zzaek(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, String str, zzfs zzfsVar) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = i11;
        this.zzk = i12;
        this.zzl = f;
        this.zzm = i13;
        this.zzn = str;
        this.zzo = zzfsVar;
    }

    public static zzaek zza(zzen zzenVar) {
        return zzc(zzenVar, false, null);
    }

    public static zzaek zzb(zzen zzenVar, zzfs zzfsVar) {
        return zzc(zzenVar, true, zzfsVar);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:116:0x02c0  */
    private static zzaek zzc(zzen zzenVar, boolean z, zzfs zzfsVar) throws zzaz {
        boolean z2;
        String str;
        int i;
        int i2;
        zzfo zzfoVar;
        int i3;
        int i4 = 4;
        if (z) {
            try {
                zzenVar.zzM(4);
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                z2 = true;
                if (z2 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzaz.zza("Error parsing".concat(str), e);
            }
        } else {
            try {
                zzenVar.zzM(21);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                z2 = true;
                if (z2 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzaz.zza("Error parsing".concat(str), e);
            }
        }
        int iZzm = zzenVar.zzm() & 3;
        int iZzm2 = zzenVar.zzm();
        int iZzc = zzenVar.zzc();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iZzm2; i7++) {
            zzenVar.zzM(1);
            int iZzq = zzenVar.zzq();
            for (int i8 = 0; i8 < iZzq; i8++) {
                int iZzq2 = zzenVar.zzq();
                i6 += iZzq2 + 4;
                zzenVar.zzM(iZzq2);
            }
        }
        zzenVar.zzL(iZzc);
        byte[] bArr = new byte[i6];
        zzfs zzfsVar2 = zzfsVar;
        int i9 = 0;
        float f = 1.0f;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        String strZzd = null;
        int i22 = 0;
        while (i22 < iZzm2) {
            int iZzm3 = zzenVar.zzm() & 63;
            int iZzq3 = zzenVar.zzq();
            int i23 = i5;
            zzfs zzfsVarZze = zzfsVar2;
            while (i23 < iZzq3) {
                int iZzq4 = zzenVar.zzq();
                int i24 = iZzm2;
                System.arraycopy(zzfv.zza, i5, bArr, i9, i4);
                int i25 = i9 + 4;
                System.arraycopy(zzenVar.zzN(), zzenVar.zzc(), bArr, i25, iZzq4);
                int i26 = 32;
                if (iZzm3 == 32) {
                    if (i23 == 0) {
                        zzfsVarZze = zzfv.zze(bArr, i25, i25 + iZzq4);
                        i = iZzq3;
                        iZzm3 = iZzm3;
                        i3 = 0;
                        i23 = 0;
                    }
                    i9 = i25 + iZzq4;
                    zzenVar.zzM(iZzq4);
                    i23++;
                    i5 = i3;
                    iZzm2 = i24;
                    iZzq3 = i;
                    iZzm3 = iZzm3;
                    i4 = 4;
                } else {
                    i26 = iZzm3;
                }
                i = iZzq3;
                if (i26 != 33) {
                    iZzm3 = iZzm3;
                    if (i26 == 39 && i23 == 0) {
                        int i27 = i9 + 6;
                        int i28 = (i25 + iZzq4) - 1;
                        while (true) {
                            byte b = bArr[i28];
                            if (b != 0) {
                                if (b != 0 && i28 > i27) {
                                    zzfw zzfwVar = new zzfw(bArr, i27, i28 + 1);
                                    while (true) {
                                        if (zzfwVar.zzg(16)) {
                                            int iZza = zzfwVar.zza(8);
                                            int i29 = 0;
                                            while (iZza == 255) {
                                                i29 += 255;
                                                iZza = zzfwVar.zza(8);
                                            }
                                            int i30 = i29 + iZza;
                                            int iZza2 = zzfwVar.zza(8);
                                            int i31 = 0;
                                            while (iZza2 == 255) {
                                                i31 += 255;
                                                iZza2 = zzfwVar.zza(8);
                                            }
                                            int i32 = i31 + iZza2;
                                            if (i32 != 0 && zzfwVar.zzg(i32)) {
                                                if (i30 == 176) {
                                                    int iZzc2 = zzfwVar.zzc();
                                                    boolean zZzh = zzfwVar.zzh();
                                                    int iZzc3 = zZzh ? zzfwVar.zzc() : 0;
                                                    int iZzc4 = zzfwVar.zzc();
                                                    int i33 = 0;
                                                    int iZzc5 = -1;
                                                    int iZzc6 = -1;
                                                    int i34 = -1;
                                                    int iZza3 = -1;
                                                    int i35 = -1;
                                                    int iZza4 = -1;
                                                    while (true) {
                                                        if (i33 <= iZzc4) {
                                                            iZzc5 = zzfwVar.zzc();
                                                            iZzc6 = zzfwVar.zzc();
                                                            i2 = i23;
                                                            int iZza5 = zzfwVar.zza(6);
                                                            if (iZza5 != 63) {
                                                                iZza3 = zzfwVar.zza(iZza5 == 0 ? Math.max(0, iZzc2 - 30) : Math.max(0, (iZza5 + iZzc2) - 31));
                                                                if (zZzh) {
                                                                    int iZza6 = zzfwVar.zza(6);
                                                                    if (iZza6 != 63) {
                                                                        iZza4 = zzfwVar.zza(iZza6 == 0 ? Math.max(0, iZzc3 - 30) : Math.max(0, (iZza6 + iZzc3) - 31));
                                                                        i35 = iZza6;
                                                                    }
                                                                } else {
                                                                    zZzh = zZzh;
                                                                }
                                                                if (zzfwVar.zzh()) {
                                                                    zzfwVar.zzf(10);
                                                                }
                                                                i33++;
                                                                i34 = iZza5;
                                                                i23 = i2;
                                                                zZzh = zZzh;
                                                                i10 = i10;
                                                            }
                                                            zzfoVar = null;
                                                        } else {
                                                            i2 = i23;
                                                            i10 = i10;
                                                            zzfoVar = new zzfo(iZzc2, iZzc3, iZzc4 + 1, iZzc5, iZzc6, i34, iZza3, i35, iZza4);
                                                        }
                                                    }
                                                } else {
                                                    zzfwVar.zzf(i32 * 8);
                                                    i23 = i23;
                                                    i10 = i10;
                                                }
                                            }
                                            i10 = i10;
                                            zzfoVar = null;
                                        }
                                    }
                                }
                                if (zzfoVar == null && zzfsVarZze != null) {
                                    i3 = 0;
                                    if (zzfoVar.zza == ((zzfi) zzfsVarZze.zza.get(0)).zzb) {
                                        i23 = i2;
                                        i10 = i10;
                                        i20 = 4;
                                    } else {
                                        i20 = 5;
                                    }
                                }
                                i23 = i2;
                                i10 = i10;
                            } else if (i28 > i27) {
                                i28--;
                            }
                            i2 = i23;
                            i10 = i10;
                            zzfoVar = null;
                            if (zzfoVar == null) {
                            }
                        }
                    } else {
                        i2 = i23;
                        i10 = i10;
                    }
                    i3 = 0;
                    i23 = i2;
                    i10 = i10;
                } else if (i23 == 0) {
                    zzfp zzfpVarZzd = zzfv.zzd(bArr, i25, i25 + iZzq4, zzfsVarZze);
                    int i36 = zzfpVarZzd.zza + 1;
                    int i37 = zzfpVarZzd.zze;
                    int i38 = zzfpVarZzd.zzf;
                    int i39 = zzfpVarZzd.zzg;
                    int i40 = zzfpVarZzd.zzh;
                    int i41 = zzfpVarZzd.zzc + 8;
                    int i42 = zzfpVarZzd.zzd + 8;
                    int i43 = zzfpVarZzd.zzk;
                    int i44 = zzfpVarZzd.zzl;
                    int i45 = zzfpVarZzd.zzm;
                    float f2 = zzfpVarZzd.zzi;
                    int i46 = zzfpVarZzd.zzj;
                    zzfk zzfkVar = zzfpVarZzd.zzb;
                    if (zzfkVar != null) {
                        strZzd = zzdk.zzd(zzfkVar.zza, zzfkVar.zzb, zzfkVar.zzc, zzfkVar.zzd, zzfkVar.zze, zzfkVar.zzf);
                    }
                    i10 = i36;
                    i11 = i37;
                    i3 = 0;
                    i21 = i46;
                    i19 = i45;
                    i17 = i43;
                    i15 = i41;
                    i14 = i40;
                    i12 = i38;
                    i16 = i42;
                    i13 = i39;
                    f = f2;
                    i18 = i44;
                } else {
                    iZzm3 = iZzm3;
                    i2 = i23;
                    i10 = i10;
                    i3 = 0;
                    i23 = i2;
                    i10 = i10;
                }
                i9 = i25 + iZzq4;
                zzenVar.zzM(iZzq4);
                i23++;
                i5 = i3;
                iZzm2 = i24;
                iZzq3 = i;
                iZzm3 = iZzm3;
                i4 = 4;
            }
            i22++;
            zzfsVar2 = zzfsVarZze;
            i4 = 4;
        }
        return new zzaek(i6 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzm + 1, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, f, i21, strZzd, zzfsVar2);
    }
}
