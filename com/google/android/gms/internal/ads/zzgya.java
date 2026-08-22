package com.google.android.gms.internal.ads;

import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class zzgya extends zzgyf {
    private final byte[] zza;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzgya(byte[] bArr, int i, int i2, boolean z, zzgye zzgyeVar) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zza = bArr;
        this.zzf = i2 + i;
        this.zzh = i;
        this.zzi = i;
    }

    private final void zzC() {
        int i = this.zzf + this.zzg;
        this.zzf = i;
        int i2 = i - this.zzi;
        int i3 = this.zzk;
        if (i2 <= i3) {
            this.zzg = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzg = i4;
        this.zzf = i - i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzA() {
        return this.zzh == this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzB() {
        return zzq() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final double zza() {
        return Double.longBitsToDouble(zzp());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final float zzb() {
        return Float.intBitsToFloat(zzh());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzc() {
        return this.zzh - this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zze() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzf() {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzg() {
        return zzi();
    }

    public final int zzh() throws zzgzw {
        int i = this.zzh;
        if (this.zzf - i < 4) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zza;
        this.zzh = i + 4;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public final int zzi() {
        int i;
        int i2 = this.zzh;
        int i3 = this.zzf;
        if (i3 != i2) {
            byte[] bArr = this.zza;
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
        return (int) zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzj() {
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzk() {
        return zzgyf.zzD(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzl() throws zzgzw {
        if (zzA()) {
            this.zzj = 0;
            return 0;
        }
        int iZzi = zzi();
        this.zzj = iZzi;
        if ((iZzi >>> 3) != 0) {
            return iZzi;
        }
        throw new zzgzw("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzm() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzn() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzo() {
        return zzq();
    }

    public final long zzp() throws zzgzw {
        int i = this.zzh;
        if (this.zzf - i < 8) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.zza;
        this.zzh = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 7]) & 255) << 56) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final long zzq() {
        long j;
        long j2;
        int i = this.zzh;
        int i2 = this.zzf;
        if (i2 != i) {
            byte[] bArr = this.zza;
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
                            long j4 = (((long) bArr[i8]) << 28) ^ ((long) i9);
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
        return zzr();
    }

    public final long zzr() throws zzgzw {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            int i2 = this.zzh;
            if (i2 == this.zzf) {
                throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            byte[] bArr = this.zza;
            this.zzh = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw new zzgzw("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzs() {
        return zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzt() {
        return zzgyf.zzF(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final long zzu() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final zzgxz zzv() throws zzgzw {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                zzgxz zzgxzVarZzv = zzgxz.zzv(this.zza, i2, iZzi);
                this.zzh += iZzi;
                return zzgxzVarZzv;
            }
        }
        if (iZzi == 0) {
            return zzgxz.zzb;
        }
        if (iZzi > 0) {
            int i3 = this.zzf;
            int i4 = this.zzh;
            if (iZzi <= i3 - i4) {
                int i5 = iZzi + i4;
                this.zzh = i5;
                byte[] bArrCopyOfRange = Arrays.copyOfRange(this.zza, i4, i5);
                zzgxz zzgxzVar = zzgxz.zzb;
                return new zzgxw(bArrCopyOfRange);
            }
        }
        if (iZzi <= 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzw() throws zzgzw {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                String str = new String(this.zza, i2, iZzi, zzgzu.zza);
                this.zzh += iZzi;
                return str;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzy(int i) throws zzgzw {
        if (this.zzj != i) {
            throw new zzgzw("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzz(int i) {
        this.zzk = i;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzd(int i) {
        if (i < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = (this.zzh - this.zzi) + i;
        if (i2 < 0) {
            throw new zzgzw(TSDAbK.nJwpPJHqFla);
        }
        int i3 = this.zzk;
        if (i2 > i3) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = i2;
        zzC();
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzx() throws zzgzw {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzf;
            int i2 = this.zzh;
            if (iZzi <= i - i2) {
                String strZzh = zzhcj.zzh(this.zza, i2, iZzi);
                this.zzh += iZzi;
                return strZzh;
            }
        }
        if (iZzi == 0) {
            return "";
        }
        if (iZzi <= 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzgzw(sgtsHsWT.mlijArUpJIq);
    }
}
