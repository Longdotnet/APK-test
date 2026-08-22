package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzem {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzem(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzd = i;
    }

    private final void zzq() {
        int i;
        int i2 = this.zzb;
        boolean z = false;
        if (i2 >= 0 && (i2 < (i = this.zzd) || (i2 == i && this.zzc == 0))) {
            z = true;
        }
        zzdd.zzf(z);
    }

    public final int zza() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzb() {
        zzdd.zzf(this.zzc == 0);
        return this.zzb;
    }

    public final int zzc() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zzd(int i) {
        int i2;
        if (i == 0) {
            return 0;
        }
        this.zzc += i;
        int i3 = 0;
        while (true) {
            i2 = this.zzc;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.zzc = i4;
            byte[] bArr = this.zza;
            int i5 = this.zzb;
            this.zzb = i5 + 1;
            i3 |= (bArr[i5] & 255) << i4;
        }
        byte[] bArr2 = this.zza;
        int i6 = this.zzb;
        int i7 = i3 | ((bArr2[i6] & 255) >> (8 - i2));
        int i8 = 32 - i;
        if (i2 == 8) {
            this.zzc = 0;
            this.zzb = i6 + 1;
        }
        int i9 = ((-1) >>> i8) & i7;
        zzq();
        return i9;
    }

    public final long zze(int i) {
        if (i <= 32) {
            int iZzd = zzd(i);
            String str = zzex.zza;
            return 4294967295L & ((long) iZzd);
        }
        int iZzd2 = zzd(i - 32);
        int iZzd3 = zzd(32);
        String str2 = zzex.zza;
        return (4294967295L & ((long) iZzd3)) | ((((long) iZzd2) & 4294967295L) << 32);
    }

    public final void zzf() {
        if (this.zzc == 0) {
            return;
        }
        this.zzc = 0;
        this.zzb++;
        zzq();
    }

    public final void zzg(int i, int i2) {
        int iMin = Math.min(8 - this.zzc, 14);
        int i3 = this.zzc;
        int i4 = (8 - i3) - iMin;
        byte[] bArr = this.zza;
        int i5 = this.zzb;
        byte b = (byte) (((65280 >> i3) | ((1 << i4) - 1)) & bArr[i5]);
        bArr[i5] = b;
        int i6 = 14 - iMin;
        int i7 = i & 16383;
        bArr[i5] = (byte) (b | ((i7 >>> i6) << i4));
        int i8 = i5 + 1;
        while (i6 > 8) {
            i6 -= 8;
            this.zza[i8] = (byte) (i7 >>> i6);
            i8++;
        }
        int i9 = 8 - i6;
        byte[] bArr2 = this.zza;
        byte b2 = (byte) (bArr2[i8] & ((1 << i9) - 1));
        bArr2[i8] = b2;
        bArr2[i8] = (byte) (((i7 & ((1 << i6) - 1)) << i9) | b2);
        zzn(14);
        zzq();
    }

    public final void zzh(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = 0;
        while (true) {
            i3 = i2 >> 3;
            if (i4 >= i3) {
                break;
            }
            byte[] bArr2 = this.zza;
            int i5 = this.zzb;
            int i6 = i5 + 1;
            this.zzb = i6;
            byte b = bArr2[i5];
            int i7 = this.zzc;
            byte b2 = (byte) (b << i7);
            bArr[i4] = b2;
            bArr[i4] = (byte) (((bArr2[i6] & 255) >> (8 - i7)) | b2);
            i4++;
        }
        int i8 = i2 & 7;
        if (i8 == 0) {
            return;
        }
        byte b3 = (byte) (bArr[i3] & (255 >> i8));
        bArr[i3] = b3;
        int i9 = this.zzc;
        if (i9 + i8 > 8) {
            byte[] bArr3 = this.zza;
            int i10 = this.zzb;
            this.zzb = i10 + 1;
            b3 = (byte) (b3 | ((bArr3[i10] & 255) << i9));
            bArr[i3] = b3;
            i9 -= 8;
        }
        int i11 = i9 + i8;
        this.zzc = i11;
        byte[] bArr4 = this.zza;
        int i12 = this.zzb;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | b3);
        if (i11 == 8) {
            this.zzc = 0;
            this.zzb = i12 + 1;
        }
        zzq();
    }

    public final void zzi(byte[] bArr, int i, int i2) {
        zzdd.zzf(this.zzc == 0);
        System.arraycopy(this.zza, this.zzb, bArr, 0, i2);
        this.zzb += i2;
        zzq();
    }

    public final void zzj(zzen zzenVar) {
        zzk(zzenVar.zzN(), zzenVar.zzd());
        zzl(zzenVar.zzc() * 8);
    }

    public final void zzk(byte[] bArr, int i) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i;
    }

    public final void zzl(int i) {
        int i2 = i / 8;
        this.zzb = i2;
        this.zzc = i - (i2 * 8);
        zzq();
    }

    public final void zzm() {
        int i = this.zzc + 1;
        this.zzc = i;
        if (i == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzq();
    }

    public final void zzn(int i) {
        int i2 = i / 8;
        int i3 = this.zzb + i2;
        this.zzb = i3;
        int i4 = (i - (i2 * 8)) + this.zzc;
        this.zzc = i4;
        if (i4 > 7) {
            this.zzb = i3 + 1;
            this.zzc = i4 - 8;
        }
        zzq();
    }

    public final void zzo(int i) {
        zzdd.zzf(this.zzc == 0);
        this.zzb += i;
        zzq();
    }

    public final boolean zzp() {
        int i = this.zza[this.zzb] & (128 >> this.zzc);
        zzm();
        return i != 0;
    }

    public zzem() {
        this.zza = zzex.zzb;
    }
}
