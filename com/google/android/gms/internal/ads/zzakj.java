package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzakj extends zzakh {
    private zzaki zza;
    private int zzb;
    private boolean zzc;
    private zzafg zzd;
    private zzafe zze;

    @Override // com.google.android.gms.internal.ads.zzakh
    public final long zza(zzen zzenVar) {
        if ((zzenVar.zzN()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzenVar.zzN()[0];
        zzaki zzakiVar = this.zza;
        zzdd.zzb(zzakiVar);
        int i = !zzakiVar.zzd[(b >> 1) & (255 >>> (8 - zzakiVar.zze))].zza ? zzakiVar.zza.zze : zzakiVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzenVar.zzb() < zzenVar.zzd() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzenVar.zzN(), zzenVar.zzd() + 4);
            zzenVar.zzJ(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzenVar.zzK(zzenVar.zzd() + 4);
        }
        long j = i2;
        byte[] bArrZzN = zzenVar.zzN();
        bArrZzN[zzenVar.zzd() - 4] = (byte) (j & 255);
        bArrZzN[zzenVar.zzd() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzN[zzenVar.zzd() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzN[zzenVar.zzd() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03ba  */
    @Override // com.google.android.gms.internal.ads.zzakh
    public final boolean zzc(zzen zzenVar, long j, zzake zzakeVar) throws zzaz {
        zzaki zzakiVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        if (this.zza != null) {
            zzakeVar.zza.getClass();
            return false;
        }
        zzafg zzafgVar = this.zzd;
        int i4 = 4;
        if (zzafgVar != null) {
            zzafe zzafeVar = this.zze;
            if (zzafeVar == null) {
                this.zze = zzafh.zzc(zzenVar, true, true);
            } else {
                byte[] bArr = new byte[zzenVar.zzd()];
                System.arraycopy(zzenVar.zzN(), 0, bArr, 0, zzenVar.zzd());
                int i5 = zzafgVar.zza;
                int i6 = 5;
                zzafh.zzd(5, zzenVar, false);
                int iZzm = zzenVar.zzm() + 1;
                zzafd zzafdVar = new zzafd(zzenVar.zzN());
                zzafdVar.zzc(zzenVar.zzc() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzm) {
                        zzafg zzafgVar2 = zzafgVar;
                        int i10 = 6;
                        int iZzb2 = zzafdVar.zzb(6) + 1;
                        for (int i11 = 0; i11 < iZzb2; i11++) {
                            if (zzafdVar.zzb(16) != 0) {
                                throw zzaz.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i12 = 1;
                        int iZzb3 = zzafdVar.zzb(6) + 1;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzafdVar.zzb(i10) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzafdVar.zzb(16) > 2) {
                                        throw zzaz.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzafdVar.zzc(24);
                                    zzafdVar.zzc(24);
                                    zzafdVar.zzc(24);
                                    int iZzb5 = zzafdVar.zzb(i10) + i15;
                                    int i17 = 8;
                                    zzafdVar.zzc(8);
                                    int[] iArr = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr[i18] = ((zzafdVar.zzd() ? zzafdVar.zzb(5) : 0) * 8) + zzafdVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr[i19] & (1 << i20)) != 0) {
                                                zzafdVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i10 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzafdVar.zzb(i10) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzafdVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        zzea.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb7);
                                    } else {
                                        if (zzafdVar.zzd()) {
                                            i = 1;
                                            iZzb = zzafdVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzafdVar.zzd()) {
                                            int iZzb8 = zzafdVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzafdVar.zzc(zzafh.zza(i23));
                                                zzafdVar.zzc(zzafh.zza(i23));
                                            }
                                        }
                                        if (zzafdVar.zzb(2) != 0) {
                                            throw zzaz.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzafdVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzafdVar.zzc(8);
                                            zzafdVar.zzc(8);
                                            zzafdVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzafdVar.zzb(6);
                                int i26 = iZzb9 + 1;
                                zzaff[] zzaffVarArr = new zzaff[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    zzaffVarArr[i27] = new zzaff(zzafdVar.zzd(), zzafdVar.zzb(16), zzafdVar.zzb(16), zzafdVar.zzb(8));
                                }
                                if (!zzafdVar.zzd()) {
                                    throw zzaz.zza("framing bit after modes not set as expected", null);
                                }
                                zzakiVar = new zzaki(zzafgVar2, zzafeVar, bArr, zzaffVarArr, zzafh.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzafdVar.zzb(i9);
                            if (iZzb10 == 0) {
                                i2 = iZzb3;
                                int i28 = 8;
                                zzafdVar.zzc(8);
                                zzafdVar.zzc(16);
                                zzafdVar.zzc(16);
                                zzafdVar.zzc(6);
                                zzafdVar.zzc(8);
                                int iZzb11 = zzafdVar.zzb(4) + 1;
                                int i29 = 0;
                                while (i29 < iZzb11) {
                                    zzafdVar.zzc(i28);
                                    i29++;
                                    i28 = 8;
                                }
                            } else {
                                if (iZzb10 != i12) {
                                    throw zzaz.zza("floor type greater than 1 not decodable: " + iZzb10, null);
                                }
                                int iZzb12 = zzafdVar.zzb(i6);
                                int[] iArr2 = new int[iZzb12];
                                int i30 = -1;
                                for (int i31 = 0; i31 < iZzb12; i31++) {
                                    int iZzb13 = zzafdVar.zzb(4);
                                    iArr2[i31] = iZzb13;
                                    if (iZzb13 > i30) {
                                        i30 = iZzb13;
                                    }
                                }
                                int i32 = i30 + 1;
                                int[] iArr3 = new int[i32];
                                int i33 = 0;
                                while (i33 < i32) {
                                    iArr3[i33] = zzafdVar.zzb(i14) + 1;
                                    int iZzb14 = zzafdVar.zzb(i8);
                                    if (iZzb14 > 0) {
                                        i3 = 8;
                                        zzafdVar.zzc(8);
                                    } else {
                                        i3 = 8;
                                    }
                                    int i34 = iZzb3;
                                    int i35 = 0;
                                    for (int i36 = 1; i35 < (i36 << iZzb14); i36 = 1) {
                                        zzafdVar.zzc(i3);
                                        i35++;
                                        i3 = 8;
                                    }
                                    i33++;
                                    iZzb3 = i34;
                                    i8 = 2;
                                    i14 = 3;
                                }
                                i2 = iZzb3;
                                zzafdVar.zzc(i8);
                                int iZzb15 = zzafdVar.zzb(4);
                                int i37 = 0;
                                int i38 = 0;
                                for (int i39 = 0; i39 < iZzb12; i39++) {
                                    i37 += iArr3[iArr2[i39]];
                                    while (i38 < i37) {
                                        zzafdVar.zzc(iZzb15);
                                        i38++;
                                    }
                                }
                            }
                            i13++;
                            iZzb3 = i2;
                            i10 = 6;
                            i8 = 2;
                            i9 = 16;
                            i12 = 1;
                            i6 = 5;
                        }
                    } else {
                        if (zzafdVar.zzb(24) != 5653314) {
                            throw zzaz.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzafdVar.zza(), null);
                        }
                        int iZzb16 = zzafdVar.zzb(16);
                        int iZzb17 = zzafdVar.zzb(24);
                        if (zzafdVar.zzd()) {
                            zzafdVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzafdVar.zzb(zzafh.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzafdVar.zzd();
                            for (int i40 = 0; i40 < iZzb17; i40++) {
                                if (!zZzd) {
                                    zzafdVar.zzc(5);
                                } else if (zzafdVar.zzd()) {
                                    zzafdVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzafdVar.zzb(i4);
                        if (iZzb19 > 2) {
                            throw zzaz.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzafgVar = zzafgVar;
                            }
                            i7++;
                            zzafgVar = zzafgVar;
                            i4 = 4;
                        } else {
                            i8 = iZzb19;
                        }
                        zzafdVar.zzc(32);
                        zzafdVar.zzc(32);
                        int iZzb20 = zzafdVar.zzb(i4) + 1;
                        zzafdVar.zzc(1);
                        zzafdVar.zzc((int) ((i8 == 1 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        zzafgVar = zzafgVar;
                        i4 = 4;
                    }
                }
            }
            this.zza = zzakiVar;
            if (zzakiVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzafg zzafgVar3 = zzakiVar.zza;
            arrayList.add(zzafgVar3.zzg);
            arrayList.add(zzakiVar.zzc);
            zzav zzavVarZzb = zzafh.zzb(zzfyq.zzm(zzakiVar.zzb.zza));
            zzx zzxVar = new zzx();
            zzxVar.zzG("audio/ogg");
            zzxVar.zzah("audio/vorbis");
            zzxVar.zzC(zzafgVar3.zzd);
            zzxVar.zzac(zzafgVar3.zzc);
            zzxVar.zzD(zzafgVar3.zza);
            zzxVar.zzai(zzafgVar3.zzb);
            zzxVar.zzT(arrayList);
            zzxVar.zzaa(zzavVarZzb);
            zzakeVar.zza = zzxVar.zzan();
            return true;
        }
        zzafh.zzd(1, zzenVar, false);
        int iZzj = zzenVar.zzj();
        int iZzm2 = zzenVar.zzm();
        int iZzj2 = zzenVar.zzj();
        int iZzi = zzenVar.zzi();
        int i41 = iZzi <= 0 ? -1 : iZzi;
        int iZzi2 = zzenVar.zzi();
        int i42 = iZzi2 <= 0 ? -1 : iZzi2;
        int iZzi3 = zzenVar.zzi();
        int i43 = iZzi3 <= 0 ? -1 : iZzi3;
        int iZzm3 = zzenVar.zzm();
        this.zzd = new zzafg(iZzj, iZzm2, iZzj2, i41, i42, i43, (int) Math.pow(2.0d, iZzm3 & 15), (int) Math.pow(2.0d, (iZzm3 & 240) >> 4), 1 == (zzenVar.zzm() & 1), Arrays.copyOf(zzenVar.zzN(), zzenVar.zzd()));
        zzakiVar = null;
        this.zza = zzakiVar;
        if (zzakiVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzafg zzafgVar4 = zzakiVar.zza;
        arrayList2.add(zzafgVar4.zzg);
        arrayList2.add(zzakiVar.zzc);
        zzav zzavVarZzb2 = zzafh.zzb(zzfyq.zzm(zzakiVar.zzb.zza));
        zzx zzxVar2 = new zzx();
        zzxVar2.zzG("audio/ogg");
        zzxVar2.zzah("audio/vorbis");
        zzxVar2.zzC(zzafgVar4.zzd);
        zzxVar2.zzac(zzafgVar4.zzc);
        zzxVar2.zzD(zzafgVar4.zza);
        zzxVar2.zzai(zzafgVar4.zzb);
        zzxVar2.zzT(arrayList2);
        zzxVar2.zzaa(zzavVarZzb2);
        zzakeVar.zza = zzxVar2.zzan();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzafg zzafgVar = this.zzd;
        this.zzb = zzafgVar != null ? zzafgVar.zze : 0;
    }
}
