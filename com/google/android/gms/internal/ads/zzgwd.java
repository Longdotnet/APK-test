package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes.dex */
public final class zzgwd implements zzget {
    private final SecretKey zza;
    private final byte[] zzb;

    private zzgwd(byte[] bArr, zzgxe zzgxeVar) throws GeneralSecurityException {
        if (!zzgmg.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zza = zzgkm.zzc(bArr);
        this.zzb = zzgxeVar.zzd();
    }

    public static zzget zzb(zzghe zzgheVar) {
        return new zzgwd(zzgheVar.zze().zzd(zzgey.zza()), zzgheVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        if (length < length2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzgpj.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        AlgorithmParameterSpec algorithmParameterSpecZza = zzgkm.zza(bArr, length2, 12);
        SecretKey secretKey = this.zza;
        Cipher cipherZzb = zzgkm.zzb();
        cipherZzb.init(2, secretKey, algorithmParameterSpecZza);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZzb.updateAAD(bArr2);
        }
        return cipherZzb.doFinal(bArr, length2 + 12, (length - length2) - 12);
    }
}
