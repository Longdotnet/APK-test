package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes.dex */
abstract class zzdn {
    int[] zza;
    private final int zzb;

    public zzdn(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzdj.zzd(bArr);
        this.zzb = i;
    }

    public abstract int zza();

    public abstract int[] zzb(int[] iArr, int i);

    public final ByteBuffer zzc(byte[] bArr, int i) {
        int[] iArrZzb = zzb(zzdj.zzd(bArr), i);
        int[] iArr = (int[]) iArrZzb.clone();
        zzdj.zzc(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            iArrZzb[i2] = iArrZzb[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzb, 0, 16);
        return byteBufferOrder;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zza()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferZzc = zzc(bArr, this.zzb + i3);
            if (i3 == i) {
                zzpp.zza(byteBufferAllocate, byteBuffer, byteBufferZzc, iRemaining % 64);
            } else {
                zzpp.zza(byteBufferAllocate, byteBuffer, byteBufferZzc, 64);
            }
        }
        return byteBufferAllocate.array();
    }
}
