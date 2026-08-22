package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzglk extends zzglh {
    public zzglk(byte[] bArr, int i) {
        super(bArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final int zza() {
        return 24;
    }

    @Override // com.google.android.gms.internal.ads.zzglh
    public final int[] zzb(int[] iArr, int i) {
        int length = iArr.length;
        if (length != 6) {
            throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        zzglf.zzb(iArr2, zzglf.zzd(this.zza, iArr));
        iArr2[12] = i;
        iArr2[13] = 0;
        iArr2[14] = iArr[4];
        iArr2[15] = iArr[5];
        return iArr2;
    }
}
