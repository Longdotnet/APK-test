package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public final class zzamv implements zzamz {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzafb zzi;
    private zzafb zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzafb zzw;
    private long zzx;
    private final zzem zzc = new zzem(new byte[7], 7);
    private final zzen zzd = new zzen(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzamv(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzh();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzh();
    }

    private final void zzh() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzi() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private final void zzj(zzafb zzafbVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzafbVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final boolean zzk(zzen zzenVar, byte[] bArr, int i) {
        int iMin = Math.min(zzenVar.zza(), i - this.zzl);
        zzenVar.zzH(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | 65280);
    }

    private static final boolean zzm(zzen zzenVar, byte[] bArr, int i) {
        if (zzenVar.zza() < i) {
            return false;
        }
        zzenVar.zzH(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0242 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0242 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x0242 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:75:0x0209  */
    /* JADX WARN: Code duplicated, block: B:77:0x0214  */
    /* JADX WARN: Code duplicated, block: B:79:0x0218  */
    /* JADX WARN: Code duplicated, block: B:81:0x021b  */
    /* JADX WARN: Code duplicated, block: B:86:0x022a  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) {
        int i;
        char c;
        int i2;
        int i3;
        int iZzd;
        byte[] bArrZzN;
        int iZzd2;
        int i4;
        byte b;
        int i5;
        int i6;
        int i7;
        byte b2;
        int i8 = 0;
        int i9 = 2;
        this.zzi.getClass();
        String str = zzex.zza;
        while (zzenVar.zza() > 0) {
            int i10 = this.zzk;
            char c2 = 7;
            if (i10 == 0) {
                byte[] bArrZzN2 = zzenVar.zzN();
                int iZzc = zzenVar.zzc();
                int iZzd3 = zzenVar.zzd();
                while (true) {
                    if (iZzc < iZzd3) {
                        int i11 = iZzc + 1;
                        byte b3 = bArrZzN2[iZzc];
                        int i12 = b3 & 255;
                        if (this.zzm == 512 && zzl((byte) -1, (byte) i12)) {
                            if (!this.zzo) {
                                int i13 = iZzc - 1;
                                zzenVar.zzL(iZzc);
                                zzem zzemVar = this.zzc;
                                if (zzm(zzenVar, zzemVar.zza, 1)) {
                                    zzemVar.zzl(4);
                                    int iZzd4 = zzemVar.zzd(1);
                                    int i14 = this.zzp;
                                    if (i14 != -1 && iZzd4 != i14) {
                                        c2 = 7;
                                    } else if (this.zzq == -1) {
                                        if (zzm(zzenVar, zzemVar.zza, 4)) {
                                            zzemVar.zzl(14);
                                            iZzd = zzemVar.zzd(13);
                                            c2 = 7;
                                            if (iZzd >= 7) {
                                                bArrZzN = zzenVar.zzN();
                                                iZzd2 = zzenVar.zzd();
                                                i4 = i13 + iZzd;
                                                if (i4 >= iZzd2) {
                                                    b = bArrZzN[i4];
                                                    if (b == -1) {
                                                        i7 = i4 + 1;
                                                        if (i7 != iZzd2) {
                                                            b2 = bArrZzN[i7];
                                                            if (zzl((byte) -1, b2) || ((b2 & 8) >> 3) != iZzd4) {
                                                            }
                                                        }
                                                    } else if (b == 73 || ((i5 = i4 + 1) != iZzd2 && (bArrZzN[i5] != 68 || ((i6 = i4 + 2) != iZzd2 && bArrZzN[i6] != 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else if (zzm(zzenVar, zzemVar.zza, 1)) {
                                        zzemVar.zzl(i9);
                                        if (zzemVar.zzd(4) == this.zzq) {
                                            zzenVar.zzL(iZzc + 1);
                                            if (zzm(zzenVar, zzemVar.zza, 4)) {
                                                zzemVar.zzl(14);
                                                iZzd = zzemVar.zzd(13);
                                                c2 = 7;
                                                if (iZzd >= 7) {
                                                    bArrZzN = zzenVar.zzN();
                                                    iZzd2 = zzenVar.zzd();
                                                    i4 = i13 + iZzd;
                                                    if (i4 >= iZzd2) {
                                                        b = bArrZzN[i4];
                                                        if (b == -1) {
                                                            i7 = i4 + 1;
                                                            if (i7 != iZzd2) {
                                                                b2 = bArrZzN[i7];
                                                                if (zzl((byte) -1, b2)) {
                                                                }
                                                            }
                                                        } else if (b == 73) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            c2 = 7;
                                        }
                                    }
                                } else {
                                    c2 = 7;
                                }
                            }
                            this.zzr = (b3 & 8) >> 3;
                            this.zzn = 1 == ((b3 & 1) ^ 1);
                            if (this.zzo) {
                                zzi();
                            } else {
                                this.zzk = 1;
                                this.zzl = 0;
                            }
                            zzenVar.zzL(i11);
                            i8 = 0;
                            i9 = 2;
                        } else {
                            c2 = c2;
                        }
                        int i15 = this.zzm;
                        int i16 = i15 | i12;
                        if (i16 == 329) {
                            i = 2;
                            c = 3;
                            i2 = 0;
                            i3 = 768;
                        } else if (i16 == 511) {
                            i = 2;
                            c = 3;
                            i2 = 0;
                            i3 = 512;
                        } else if (i16 == 836) {
                            i = 2;
                            c = 3;
                            i2 = 0;
                            i3 = 1024;
                        } else if (i16 == 1075) {
                            this.zzk = 2;
                            this.zzl = 3;
                            this.zzu = 0;
                            this.zzd.zzL(0);
                            zzenVar.zzL(i11);
                            i9 = 2;
                            i8 = 0;
                        } else if (i15 != 256) {
                            this.zzm = 256;
                            i8 = 0;
                            i9 = 2;
                        } else {
                            i = 2;
                            c = 3;
                            i2 = 0;
                            i8 = i2;
                            iZzc = i11;
                            i9 = i;
                        }
                        this.zzm = i3;
                        i8 = i2;
                        iZzc = i11;
                        i9 = i;
                    } else {
                        zzenVar.zzL(iZzc);
                    }
                }
            } else if (i10 != 1) {
                if (i10 == i9) {
                    zzen zzenVar2 = this.zzd;
                    if (zzk(zzenVar, zzenVar2.zzN(), 10)) {
                        this.zzj.zzr(zzenVar2, 10);
                        zzenVar2.zzL(6);
                        zzj(this.zzj, 0L, 10, zzenVar2.zzl() + 10);
                    }
                } else if (i10 != 3) {
                    int iMin = Math.min(zzenVar.zza(), this.zzu - this.zzl);
                    this.zzw.zzr(zzenVar, iMin);
                    int i17 = this.zzl + iMin;
                    this.zzl = i17;
                    if (i17 == this.zzu) {
                        zzdd.zzf(this.zzv != -9223372036854775807L ? 1 : i8);
                        this.zzw.zzt(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzh();
                    }
                } else {
                    int i18 = true != this.zzn ? 5 : 7;
                    zzem zzemVar2 = this.zzc;
                    if (zzk(zzenVar, zzemVar2.zza, i18)) {
                        zzemVar2.zzl(i8);
                        if (this.zzs) {
                            zzemVar2.zzn(10);
                        } else {
                            int iZzd5 = zzemVar2.zzd(i9) + 1;
                            if (iZzd5 != i9) {
                                zzea.zzf("AdtsReader", "Detected audio object type: " + iZzd5 + ", but assuming AAC LC.");
                            }
                            zzemVar2.zzn(5);
                            int iZzd6 = zzemVar2.zzd(3);
                            int i19 = this.zzq;
                            byte[] bArr = new byte[i9];
                            bArr[i8] = (byte) (((i19 >> 1) & 7) | 16);
                            bArr[1] = (byte) (((iZzd6 << 3) & 120) | ((i19 << 7) & 128));
                            zzacp zzacpVarZza = zzacr.zza(bArr);
                            zzx zzxVar = new zzx();
                            zzxVar.zzS(this.zzh);
                            zzxVar.zzG(this.zzg);
                            zzxVar.zzah("audio/mp4a-latm");
                            zzxVar.zzE(zzacpVarZza.zzc);
                            zzxVar.zzD(zzacpVarZza.zzb);
                            zzxVar.zzai(zzacpVarZza.zza);
                            zzxVar.zzT(Collections.singletonList(bArr));
                            zzxVar.zzW(this.zze);
                            zzxVar.zzaf(this.zzf);
                            zzz zzzVarZzan = zzxVar.zzan();
                            this.zzt = 1024000000 / ((long) zzzVarZzan.zzH);
                            this.zzi.zzm(zzzVarZzan);
                            this.zzs = true;
                        }
                        zzemVar2.zzn(4);
                        int iZzd7 = zzemVar2.zzd(13);
                        zzj(this.zzi, this.zzt, 0, this.zzn ? iZzd7 - 9 : iZzd7 - 7);
                    }
                }
            } else if (zzenVar.zza() != 0) {
                zzem zzemVar3 = this.zzc;
                zzemVar3.zza[i8] = zzenVar.zzN()[zzenVar.zzc()];
                zzemVar3.zzl(i9);
                int iZzd8 = zzemVar3.zzd(4);
                int i20 = this.zzq;
                if (i20 == -1 || iZzd8 == i20) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = iZzd8;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzh = zzaonVar.zzb();
        zzafb zzafbVarZzw = zzadyVar.zzw(zzaonVar.zza(), 1);
        this.zzi = zzafbVarZzw;
        this.zzw = zzafbVarZzw;
        if (!this.zzb) {
            this.zzj = new zzadr();
            return;
        }
        zzaonVar.zzc();
        zzafb zzafbVarZzw2 = zzadyVar.zzw(zzaonVar.zza(), 5);
        this.zzj = zzafbVarZzw2;
        zzx zzxVar = new zzx();
        zzxVar.zzS(zzaonVar.zzb());
        zzxVar.zzG(this.zzg);
        zzxVar.zzah("application/id3");
        zzafbVarZzw2.zzm(zzxVar.zzan());
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzv = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzv = -9223372036854775807L;
        zzg();
    }
}
