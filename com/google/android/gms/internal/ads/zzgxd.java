package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzgxd implements zzget {
    private final zzgll zza;
    private final byte[] zzb;

    private zzgxd(byte[] bArr, byte[] bArr2) {
        this.zza = new zzgll(bArr);
        this.zzb = bArr2;
    }

    public static zzget zzb(zzgju zzgjuVar) {
        return new zzgxd(zzgjuVar.zze().zzd(zzgey.zza()), zzgjuVar.zzb().zzd());
    }

    private final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length < 40) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.zza.zzb(ByteBuffer.wrap(bArr, 24, length - 24), Arrays.copyOf(bArr, 24), bArr2);
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr3.length;
        if (length == 0) {
            return zzc(bArr, bArr2);
        }
        if (zzgpj.zzc(bArr3, bArr)) {
            return zzc(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }
}
