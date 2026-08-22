package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.login.vu.dLDI;

/* JADX INFO: loaded from: classes2.dex */
final class zzacj extends zzacn {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzacj(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzN() {
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzO(byte b) throws zzack {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            this.zzc = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzack(String.format(dLDI.tJiQyUybYvUfJ, Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzP(int i, boolean z) throws zzack {
        zzs(i << 3);
        zzO(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzQ(int i, zzacc zzaccVar) throws zzack {
        zzs((i << 3) | 2);
        zzs(zzaccVar.zzd());
        zzaccVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn, com.google.android.gms.internal.p002firebaseauthapi.zzabs
    public final void zza(byte[] bArr, int i, int i2) throws zzack {
        zze(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws zzack {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzack(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzh(int i, int i2) throws zzack {
        zzs((i << 3) | 5);
        zzi(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzi(int i) throws zzack {
        try {
            byte[] bArr = this.zza;
            int i2 = this.zzc;
            int i3 = i2 + 1;
            this.zzc = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.zzc = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.zzc = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.zzc = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzack(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzj(int i, long j) throws zzack {
        zzs((i << 3) | 1);
        zzk(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzk(long j) throws zzack {
        try {
            byte[] bArr = this.zza;
            int i = this.zzc;
            int i2 = i + 1;
            this.zzc = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i3 = i + 2;
            this.zzc = i3;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i4 = i + 3;
            this.zzc = i4;
            bArr[i3] = (byte) (((int) (j >> 16)) & 255);
            int i5 = i + 4;
            this.zzc = i5;
            bArr[i4] = (byte) (((int) (j >> 24)) & 255);
            int i6 = i + 5;
            this.zzc = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.zzc = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.zzc = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.zzc = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzack(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzl(int i, int i2) throws zzack {
        zzs(i << 3);
        zzm(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzm(int i) throws zzack {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu(i);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzn(int i, zzaek zzaekVar, zzaew zzaewVar) throws zzack {
        zzs((i << 3) | 2);
        zzs(((zzabm) zzaekVar).zzn(zzaewVar));
        zzaewVar.zzn(zzaekVar, this.zze);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzo(int i, String str) throws zzack {
        zzs((i << 3) | 2);
        zzp(str);
    }

    public final void zzp(String str) throws zzack {
        int i = this.zzc;
        try {
            int iZzE = zzacn.zzE(str.length() * 3);
            int iZzE2 = zzacn.zzE(str.length());
            if (iZzE2 != iZzE) {
                zzs(zzagc.zzc(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzagc.zzb(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzE2;
            this.zzc = i3;
            int iZzb = zzagc.zzb(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzs((iZzb - i) - iZzE2);
            this.zzc = iZzb;
        } catch (zzagb e) {
            this.zzc = i;
            zzJ(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzack(e2);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzq(int i, int i2) throws zzack {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzr(int i, int i2) throws zzack {
        zzs(i << 3);
        zzs(i2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzs(int i) throws zzack {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzack(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        byte[] bArr2 = this.zza;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzt(int i, long j) throws zzack {
        zzs(i << 3);
        zzu(j);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacn
    public final void zzu(long j) throws zzack {
        if (zzacn.zzb && this.zzb - this.zzc >= 10) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i = this.zzc;
                this.zzc = i + 1;
                zzafx.zzn(bArr, i, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i2 = this.zzc;
            this.zzc = 1 + i2;
            zzafx.zzn(bArr2, i2, (byte) j);
            return;
        }
        while ((j & (-128)) != 0) {
            try {
                byte[] bArr3 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzack(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzc), Integer.valueOf(this.zzb), 1), e);
            }
        }
        byte[] bArr4 = this.zza;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        bArr4[i4] = (byte) j;
    }
}
