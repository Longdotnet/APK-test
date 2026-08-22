package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzdc implements zzap {
    private static final byte[] zza = new byte[0];
    private final zznx zzb;
    private final zzap zzc;

    public zzdc(zznx zznxVar, zzap zzapVar) {
        this.zzb = zznxVar;
        this.zzc = zzapVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i = byteBufferWrap.getInt();
            if (i <= 0 || i > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i];
            byteBufferWrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            return ((zzap) zzbz.zzj(this.zzb.zzf(), this.zzc.zza(bArr3, zza), zzap.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzap
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        throw null;
    }
}
