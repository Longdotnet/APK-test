package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgvz implements zzgww {
    private static final ThreadLocal zza = new zzgvy();
    private final SecretKeySpec zzb;
    private final int zzc;
    private final int zzd;

    public zzgvz(byte[] bArr, int i) throws GeneralSecurityException {
        if (!zzgmg.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzgxc.zza(bArr.length);
        this.zzb = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) zza.get()).getBlockSize();
        this.zzd = blockSize;
        if (i > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        int length = bArr.length;
        int i = this.zzc;
        if (length < i) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        int i2 = length - i;
        byte[] bArr3 = new byte[i2];
        Cipher cipher = (Cipher) zza.get();
        byte[] bArr4 = new byte[this.zzd];
        System.arraycopy(bArr2, 0, bArr4, 0, i);
        cipher.init(2, this.zzb, new IvParameterSpec(bArr4));
        if (cipher.doFinal(bArr, i, i2, bArr3, 0) == i2) {
            return bArr3;
        }
        throw new GeneralSecurityException(MnHfHMYQDPUO.mFKZkPSojaUs);
    }
}
