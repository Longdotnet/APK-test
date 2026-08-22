package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class zzgyc extends zzgyf {
    private final InputStream zza;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    public /* synthetic */ zzgyc(InputStream inputStream, int i, zzgye zzgyeVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        byte[] bArr = zzgzu.zzb;
        this.zza = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzI(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.zza.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzJ() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk + i;
        int i3 = this.zzl;
        if (i2 <= i3) {
            this.zzh = 0;
            return;
        }
        int i4 = i2 - i3;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    private final void zzK(int i) throws zzgzw {
        if (zzL(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.zzk) - this.zzi) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzgzw("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
    }

    private final boolean zzL(int i) throws IOException {
        int i2 = this.zzi;
        int i3 = i2 + i;
        int i4 = this.zzg;
        if (i3 <= i4) {
            throw new IllegalStateException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i5 = this.zzk;
        if (i > (Integer.MAX_VALUE - i5) - i2 || i5 + i2 + i > this.zzl) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.zzf;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            i5 = this.zzk + i2;
            this.zzk = i5;
            i4 = this.zzg - i2;
            this.zzg = i4;
            this.zzi = 0;
        }
        try {
            int i6 = this.zza.read(this.zzf, i4, Math.min(4096 - i4, (Integer.MAX_VALUE - i5) - i4));
            if (i6 != 0 && i6 >= -1 && i6 <= 4096) {
                if (i6 <= 0) {
                    return false;
                }
                this.zzg += i6;
                zzJ();
                return this.zzg >= i || zzL(i);
            }
            throw new IllegalStateException(String.valueOf(this.zza.getClass()) + "#read(byte[]) returned invalid result: " + i6 + "\nThe InputStream implementation is buggy.");
        } catch (zzgzw e) {
            e.zza();
            throw e;
        }
    }

    private final byte[] zzM(int i, boolean z) throws IOException {
        byte[] bArrZzN = zzN(i);
        if (bArrZzN != null) {
            return bArrZzN;
        }
        int i2 = this.zzi;
        int i3 = this.zzg;
        int i4 = i3 - i2;
        this.zzk += i3;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, i2, bArr, 0, i4);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    private final byte[] zzN(int i) throws IOException {
        if (i == 0) {
            return zzgzu.zzb;
        }
        int i2 = this.zzk;
        int i3 = this.zzi;
        int i4 = i2 + i3 + i;
        if ((-2147483647) + i4 > 0) {
            throw new zzgzw("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i5 = this.zzl;
        if (i4 > i5) {
            zzC((i5 - i2) - i3);
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.zzg - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.zza.available()) {
                    return null;
                }
            } catch (zzgzw e) {
                e.zza();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzf, this.zzi, bArr, 0, i6);
        this.zzk += this.zzg;
        this.zzi = 0;
        this.zzg = 0;
        while (i6 < i) {
            try {
                int i8 = this.zza.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.zzk += i8;
                i6 += i8;
            } catch (zzgzw e2) {
                e2.zza();
                throw e2;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzA() {
        return this.zzi == this.zzg && !zzL(1);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final boolean zzB() {
        return zzq() != 0;
    }

    public final void zzC(int i) throws zzgzw {
        int i2 = this.zzg;
        int i3 = this.zzi;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.zzi = i3 + i;
            return;
        }
        if (i < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.zzk;
        int i6 = i5 + i3;
        int i7 = this.zzl;
        if (i6 + i > i7) {
            zzC((i7 - i5) - i3);
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = i6;
        this.zzg = 0;
        this.zzi = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.zza.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(String.valueOf(this.zza.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (zzgzw e) {
                    e.zza();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzk += i4;
                zzJ();
                throw th;
            }
        }
        this.zzk += i4;
        zzJ();
        if (i4 >= i) {
            return;
        }
        int i8 = this.zzg;
        int i9 = i8 - this.zzi;
        this.zzi = i8;
        zzK(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.zzg;
            if (i10 <= i11) {
                this.zzi = i10;
                return;
            } else {
                i9 += i11;
                this.zzi = i11;
                zzK(1);
            }
        }
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
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final int zzd(int i) throws zzgzw {
        if (i < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.zzk + this.zzi + i;
        if (i2 < 0) {
            throw new zzgzw("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit. If reading multiple messages, consider resetting the counter between each message using CodedInputStream.resetSizeCounter().");
        }
        int i3 = this.zzl;
        if (i2 > i3) {
            throw new zzgzw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzl = i2;
        zzJ();
        return i3;
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
        int i = this.zzi;
        if (this.zzg - i < 4) {
            zzK(4);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    public final int zzi() {
        int i;
        int i2 = this.zzi;
        int i3 = this.zzg;
        if (i3 != i2) {
            byte[] bArr = this.zzf;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i4;
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
                this.zzi = i5;
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
        int i = this.zzi;
        if (this.zzg - i < 8) {
            zzK(8);
            i = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 7]) & 255) << 56) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public final long zzq() {
        long j;
        long j2;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i3;
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
                this.zzi = i4;
                return j;
            }
        }
        return zzr();
    }

    public final long zzr() throws zzgzw {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.zzi == this.zzg) {
                zzK(1);
            }
            byte[] bArr = this.zzf;
            int i2 = this.zzi;
            this.zzi = i2 + 1;
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
    public final zzgxz zzv() throws IOException {
        int iZzi = zzi();
        int i = this.zzg;
        int i2 = this.zzi;
        if (iZzi <= i - i2 && iZzi > 0) {
            zzgxz zzgxzVarZzv = zzgxz.zzv(this.zzf, i2, iZzi);
            this.zzi += iZzi;
            return zzgxzVarZzv;
        }
        if (iZzi == 0) {
            return zzgxz.zzb;
        }
        if (iZzi < 0) {
            throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrZzN = zzN(iZzi);
        if (bArrZzN != null) {
            return zzgxz.zzv(bArrZzN, 0, bArrZzN.length);
        }
        int i3 = this.zzi;
        int i4 = this.zzg;
        int i5 = i4 - i3;
        this.zzk += i4;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> listZzI = zzI(iZzi - i5);
        byte[] bArr = new byte[iZzi];
        System.arraycopy(this.zzf, i3, bArr, 0, i5);
        for (byte[] bArr2 : listZzI) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        zzgxz zzgxzVar = zzgxz.zzb;
        return new zzgxw(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzx() throws IOException {
        byte[] bArrZzM;
        int iZzi = zzi();
        int i = this.zzi;
        int i2 = this.zzg;
        if (iZzi <= i2 - i && iZzi > 0) {
            bArrZzM = this.zzf;
            this.zzi = i + iZzi;
        } else {
            if (iZzi == 0) {
                return "";
            }
            if (iZzi < 0) {
                throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (iZzi <= i2) {
                zzK(iZzi);
                bArrZzM = this.zzf;
                this.zzi = iZzi;
            } else {
                bArrZzM = zzM(iZzi, false);
            }
        }
        return zzhcj.zzh(bArrZzM, i, iZzi);
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzy(int i) throws zzgzw {
        if (this.zzj != i) {
            throw new zzgzw("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final void zzz(int i) {
        this.zzl = i;
        zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzgyf
    public final String zzw() throws zzgzw {
        int iZzi = zzi();
        if (iZzi > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzi <= i - i2) {
                String str = new String(this.zzf, i2, iZzi, zzgzu.zza);
                this.zzi += iZzi;
                return str;
            }
        }
        if (iZzi == 0) {
            return RDFWIi.jbYL;
        }
        if (iZzi >= 0) {
            if (iZzi <= this.zzg) {
                zzK(iZzi);
                String str2 = new String(this.zzf, this.zzi, iZzi, zzgzu.zza);
                this.zzi += iZzi;
                return str2;
            }
            return new String(zzM(iZzi, false), zzgzu.zza);
        }
        throw new zzgzw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }
}
