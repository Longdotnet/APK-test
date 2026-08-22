package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzamx implements zzamz {
    private final zzen zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzafb zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzz zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzamx(String str, int i, int i2, String str2) {
        this.zza = new zzen(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final void zzf(zzads zzadsVar) {
        int i;
        int i2 = zzadsVar.zzb;
        if (i2 == -2147483647 || (i = zzadsVar.zzc) == -1) {
            return;
        }
        zzz zzzVar = this.zzl;
        if (zzzVar != null && i == zzzVar.zzG && i2 == zzzVar.zzH && Objects.equals(zzadsVar.zza, zzzVar.zzo)) {
            return;
        }
        zzz zzzVar2 = this.zzl;
        zzx zzxVar = zzzVar2 == null ? new zzx() : zzzVar2.zzb();
        zzxVar.zzS(this.zzf);
        zzxVar.zzG(this.zze);
        zzxVar.zzah(zzadsVar.zza);
        zzxVar.zzD(i);
        zzxVar.zzai(i2);
        zzxVar.zzW(this.zzc);
        zzxVar.zzaf(this.zzd);
        zzz zzzVarZzan = zzxVar.zzan();
        this.zzl = zzzVarZzan;
        this.zzg.zzm(zzzVarZzan);
    }

    private final boolean zzg(zzen zzenVar, byte[] bArr, int i) {
        int iMin = Math.min(zzenVar.zza(), i - this.zzi);
        zzenVar.zzH(bArr, this.zzi, iMin);
        int i2 = this.zzi + iMin;
        this.zzi = i2;
        return i2 == i;
    }

    /* JADX WARN: Code duplicated, block: B:67:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:70:0x01bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x01df  */
    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zza(zzen zzenVar) throws zzaz {
        int i;
        int i2;
        byte b;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b2;
        int i7;
        int i8;
        zzdd.zzb(this.zzg);
        while (zzenVar.zza() > 0) {
            int i9 = this.zzh;
            if (i9 == 0) {
                while (zzenVar.zza() > 0) {
                    int i10 = this.zzj << 8;
                    this.zzj = i10;
                    int iZzm = i10 | zzenVar.zzm();
                    this.zzj = iZzm;
                    if (iZzm == 2147385345 || iZzm == -25230976 || iZzm == 536864768 || iZzm == -14745368) {
                        i8 = 1;
                    } else if (iZzm == 1683496997 || iZzm == 622876772) {
                        i8 = 2;
                    } else if (iZzm == 1078008818 || iZzm == -233094848) {
                        i8 = 3;
                    } else {
                        i8 = (iZzm == 1908687592 || iZzm == -398277519) ? 4 : 0;
                    }
                    this.zzn = i8;
                    if (i8 != 0) {
                        byte[] bArrZzN = this.zza.zzN();
                        int i11 = this.zzj;
                        bArrZzN[0] = (byte) ((i11 >> 24) & 255);
                        bArrZzN[1] = (byte) ((i11 >> 16) & 255);
                        bArrZzN[2] = (byte) ((i11 >> 8) & 255);
                        bArrZzN[3] = (byte) (i11 & 255);
                        this.zzi = 4;
                        this.zzj = 0;
                        if (i8 != 3 && i8 != 4) {
                            if (i8 != 1) {
                                this.zzh = 2;
                                break;
                            } else {
                                this.zzh = 1;
                                break;
                            }
                        }
                        this.zzh = 4;
                        break;
                    }
                }
            } else if (i9 == 1) {
                zzen zzenVar2 = this.zza;
                if (zzg(zzenVar, zzenVar2.zzN(), 18)) {
                    byte[] bArrZzN2 = zzenVar2.zzN();
                    if (this.zzl == null) {
                        zzz zzzVarZzc = zzadu.zzc(bArrZzN2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzzVarZzc;
                        this.zzg.zzm(zzzVarZzc);
                    }
                    byte b3 = bArrZzN2[0];
                    if (b3 != -2) {
                        if (b3 == -1) {
                            i7 = ((bArrZzN2[7] & 3) << 12) | ((bArrZzN2[6] & 255) << 4) | ((bArrZzN2[9] & 60) >> 2);
                        } else if (b3 != 31) {
                            i = (bArrZzN2[5] & 3) << 12;
                            i2 = (bArrZzN2[6] & 255) << 4;
                            b = bArrZzN2[7];
                        } else {
                            i7 = ((bArrZzN2[8] & 60) >> 2) | ((3 & bArrZzN2[6]) << 12) | ((bArrZzN2[7] & 255) << 4);
                        }
                        i3 = i7 + 1;
                        z = true;
                        if (z) {
                            i3 = (i3 * 16) / 14;
                        }
                        this.zzm = i3;
                        if (b3 != -2) {
                            if (b3 != -1) {
                                i4 = 2;
                                i5 = (bArrZzN2[4] & 7) << 4;
                                b2 = bArrZzN2[7];
                            } else if (b3 != 31) {
                                i5 = (bArrZzN2[4] & 1) << 6;
                                i6 = bArrZzN2[5] & 252;
                                i4 = 2;
                            } else {
                                i4 = 2;
                                i5 = (bArrZzN2[5] & 7) << 4;
                                b2 = bArrZzN2[6];
                            }
                            i6 = b2 & 60;
                        } else {
                            i4 = 2;
                            i5 = (bArrZzN2[5] & 1) << 6;
                            i6 = bArrZzN2[4] & 252;
                        }
                        this.zzk = zzgbt.zzb(zzex.zzt(((i5 | (i6 >> i4)) + 1) * 32, this.zzl.zzH));
                        zzenVar2.zzL(0);
                        this.zzg.zzr(zzenVar2, 18);
                        this.zzh = 6;
                    } else {
                        i = (bArrZzN2[4] & 3) << 12;
                        i2 = (bArrZzN2[7] & 255) << 4;
                        b = bArrZzN2[6];
                    }
                    i3 = (i | i2 | ((b & 240) >> 4)) + 1;
                    z = false;
                    if (z) {
                        i3 = (i3 * 16) / 14;
                    }
                    this.zzm = i3;
                    if (b3 != -2) {
                        if (b3 != -1) {
                            i4 = 2;
                            i5 = (bArrZzN2[4] & 7) << 4;
                            b2 = bArrZzN2[7];
                        } else if (b3 != 31) {
                            i5 = (bArrZzN2[4] & 1) << 6;
                            i6 = bArrZzN2[5] & 252;
                            i4 = 2;
                        } else {
                            i4 = 2;
                            i5 = (bArrZzN2[5] & 7) << 4;
                            b2 = bArrZzN2[6];
                        }
                        i6 = b2 & 60;
                    } else {
                        i4 = 2;
                        i5 = (bArrZzN2[5] & 1) << 6;
                        i6 = bArrZzN2[4] & 252;
                    }
                    this.zzk = zzgbt.zzb(zzex.zzt(((i5 | (i6 >> i4)) + 1) * 32, this.zzl.zzH));
                    zzenVar2.zzL(0);
                    this.zzg.zzr(zzenVar2, 18);
                    this.zzh = 6;
                }
            } else if (i9 != 2) {
                if (i9 == 3) {
                    zzen zzenVar3 = this.zza;
                    if (zzg(zzenVar, zzenVar3.zzN(), this.zzo)) {
                        zzads zzadsVarZzd = zzadu.zzd(zzenVar3.zzN());
                        zzf(zzadsVarZzd);
                        this.zzm = zzadsVarZzd.zzd;
                        long j = zzadsVarZzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzenVar3.zzL(0);
                        this.zzg.zzr(zzenVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i9 == 4) {
                    zzen zzenVar4 = this.zza;
                    if (zzg(zzenVar, zzenVar4.zzN(), 6)) {
                        int iZzb = zzadu.zzb(zzenVar4.zzN());
                        this.zzp = iZzb;
                        int i12 = this.zzi;
                        if (i12 > iZzb) {
                            int i13 = i12 - iZzb;
                            this.zzi = i12 - i13;
                            zzenVar.zzL(zzenVar.zzc() - i13);
                        }
                        this.zzh = 5;
                    }
                } else if (i9 != 5) {
                    int iMin = Math.min(zzenVar.zza(), this.zzm - this.zzi);
                    this.zzg.zzr(zzenVar, iMin);
                    int i14 = this.zzi + iMin;
                    this.zzi = i14;
                    if (i14 == this.zzm) {
                        zzdd.zzf(this.zzq != -9223372036854775807L);
                        this.zzg.zzt(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzen zzenVar5 = this.zza;
                    if (zzg(zzenVar, zzenVar5.zzN(), this.zzp)) {
                        zzads zzadsVarZze = zzadu.zze(zzenVar5.zzN(), this.zzb);
                        if (this.zzn == 3) {
                            zzf(zzadsVarZze);
                        }
                        this.zzm = zzadsVarZze.zzd;
                        long j2 = zzadsVarZze.zze;
                        this.zzk = j2 != -9223372036854775807L ? j2 : 0L;
                        zzenVar5.zzL(0);
                        this.zzg.zzr(zzenVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzen zzenVar6 = this.zza;
                if (zzg(zzenVar, zzenVar6.zzN(), 7)) {
                    this.zzo = zzadu.zza(zzenVar6.zzN());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzb(zzady zzadyVar, zzaon zzaonVar) {
        zzaonVar.zzc();
        this.zzf = zzaonVar.zzb();
        this.zzg = zzadyVar.zzw(zzaonVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zzd(long j, int i) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    public final void zze() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }
}
