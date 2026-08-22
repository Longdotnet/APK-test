package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
final class zzace extends zzacg {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    public /* synthetic */ zzace(byte[] bArr, int i, int i2, boolean z, zzacd zzacdVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = i2;
        this.zzh = 0;
    }

    private final void zzv() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = this.zzj;
        if (i <= i2) {
            this.zzg = 0;
            return;
        }
        int i3 = i - i2;
        this.zzg = i3;
        this.zzf = i - i3;
    }

    public final byte zza() throws zzadn {
        int i = this.zzh;
        if (i == this.zzf) {
            throw zzadn.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final int zzb() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final int zzc(int i) {
        if (i < 0) {
            throw zzadn.zzf();
        }
        int i2 = i + this.zzh;
        if (i2 < 0) {
            throw zzadn.zzg();
        }
        int i3 = this.zzj;
        if (i2 > i3) {
            throw zzadn.zzi();
        }
        this.zzj = i2;
        zzv();
        return i3;
    }

    public final int zzd() throws zzadn {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw zzadn.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final int zze() {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zze;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzh = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.zzh = i5;
                return i;
            }
        }
        return (int) zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final int zzf() throws zzadn {
        if (zzp()) {
            this.zzi = 0;
            return 0;
        }
        int iZze = zze();
        this.zzi = iZze;
        if ((iZze >>> 3) != 0) {
            return iZze;
        }
        throw zzadn.zzc();
    }

    public final long zzg() throws zzadn {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw zzadn.zzi();
        }
        byte[] bArr = this.zze;
        this.zzh = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final long zzh() {
        long j;
        long j2;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zze;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzh = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            long j3 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j3;
                        } else {
                            i6 = i + 5;
                            long j4 = ((long) i9) ^ (((long) bArr[i8]) << 28);
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (((long) bArr[i6]) << 35) ^ j4;
                                if (j5 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j6 = j5 ^ (((long) bArr[i4]) << 42);
                                    if (j6 >= 0) {
                                        j = j6 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (((long) bArr[i10]) << 49);
                                        if (j5 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            long j7 = (j5 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i + 10;
                                                if (bArr[i10] >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                j = j7;
                                            }
                                        }
                                    }
                                    i4 = i10;
                                }
                                j = j5 ^ j2;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.zzh = i4;
                return j;
            }
        }
        return zzi();
    }

    public final long zzi() throws zzadn {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZza = zza();
            j |= ((long) (bZza & 127)) << i;
            if ((bZza & 128) == 0) {
                return j;
            }
        }
        throw zzadn.zze();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final zzacc zzj() throws zzadn {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                zzacc zzaccVarZzo = zzacc.zzo(this.zze, i2, iZze);
                this.zzh += iZze;
                return zzaccVarZzo;
            }
        }
        if (iZze == 0) {
            return zzacc.zzb;
        }
        if (iZze > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZze <= i3 - i4) {
                int i5 = iZze + i4;
                this.zzh = i5;
                return zzacc.zzq(Arrays.copyOfRange(this.zze, i4, i5));
            }
        }
        if (iZze <= 0) {
            throw zzadn.zzf();
        }
        throw zzadn.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final String zzk() throws zzadn {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                String str = new String(this.zze, i2, iZze, zzadl.zzb);
                this.zzh += iZze;
                return str;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze < 0) {
            throw zzadn.zzf();
        }
        throw zzadn.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final String zzl() throws zzadn {
        int iZze = zze();
        if (iZze > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZze <= i - i2) {
                String strZzd = zzagc.zzd(this.zze, i2, iZze);
                this.zzh += iZze;
                return strZzd;
            }
        }
        if (iZze == 0) {
            return "";
        }
        if (iZze <= 0) {
            throw zzadn.zzf();
        }
        throw zzadn.zzi();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final void zzm(int i) throws zzadn {
        if (this.zzi != i) {
            throw zzadn.zzb();
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final void zzn(int i) {
        this.zzj = i;
        zzv();
    }

    public final void zzo(int i) throws zzadn {
        if (i >= 0) {
            int i2 = this.zzf;
            int i3 = this.zzh;
            if (i <= i2 - i3) {
                this.zzh = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzadn.zzi();
        }
        throw zzadn.zzf();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final boolean zzp() {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final boolean zzq() {
        return zzh() != 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacg
    public final boolean zzr(int i) throws zzadn {
        int iZzf;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.zzf - this.zzh < 10) {
                while (i3 < 10) {
                    if (zza() < 0) {
                        i3++;
                    }
                }
                throw zzadn.zze();
            }
            while (i3 < 10) {
                byte[] bArr = this.zze;
                int i4 = this.zzh;
                this.zzh = i4 + 1;
                if (bArr[i4] < 0) {
                    i3++;
                }
            }
            throw zzadn.zze();
            return true;
        }
        if (i2 == 1) {
            zzo(8);
            return true;
        }
        if (i2 == 2) {
            zzo(zze());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzadn.zza();
            }
            zzo(4);
            return true;
        }
        do {
            iZzf = zzf();
            if (iZzf == 0) {
                break;
            }
        } while (zzr(iZzf));
        zzm(((i >>> 3) << 3) | 4);
        return true;
    }
}
