package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public final class zzglo implements zzget {
    private final byte[] zza;
    private final int zzb;
    private final zzgro zzc;

    private zzglo(byte[] bArr, zzgxe zzgxeVar, int i) {
        this.zzc = new zzgwy(bArr);
        this.zza = zzgxeVar.zzd();
        this.zzb = i;
    }

    public static zzget zzb(zzgjo zzgjoVar) {
        return new zzglo(zzgjoVar.zze().zzd(zzgey.zza()), zzgjoVar.zzb(), zzgjoVar.zzd().zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zza;
        int i = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i2 = i + length2;
        if (length < i2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgpj.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArr4 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr5 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int length3 = bArrCopyOfRange.length;
        if (length3 > 12 || length3 < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArrCopyOfRange, 0, bArr4, 4, length3);
        System.arraycopy(bArrCopyOfRange, 0, bArr5, 4, length3);
        zzgro zzgroVar = this.zzc;
        byte[] bArr6 = new byte[32];
        System.arraycopy(zzgroVar.zza(bArr4, 16), 0, bArr6, 0, 16);
        System.arraycopy(zzgroVar.zza(bArr5, 16), 0, bArr6, 16, 16);
        if (!zzgmg.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        SecretKey secretKeyZzc = zzgkm.zzc(bArr6);
        int i3 = i2 + 12;
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, i3);
        if (bArrCopyOfRange2.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (length < i2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgkm.zza(bArrCopyOfRange2, 0, 12);
        Cipher cipherZzb = zzgkm.zzb();
        cipherZzb.init(2, secretKeyZzc, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZzb.updateAAD(bArr2);
        }
        return cipherZzb.doFinal(bArr, i3, length - i3);
    }
}
