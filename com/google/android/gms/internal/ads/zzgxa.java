package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class zzgxa implements zzgro {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public zzgxa(String str, Key key) throws GeneralSecurityException {
        byte b;
        int i;
        zzgwz zzgwzVar = new zzgwz(this);
        this.zza = zzgwzVar;
        if (!zzgmg.zza(2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        this.zzb = str;
        this.zzc = key;
        if (key.getEncoded().length < 16) {
            throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
        }
        switch (str) {
            case "HMACSHA1":
                b = 0;
                break;
            case "HMACSHA224":
                b = 1;
                break;
            case "HMACSHA256":
                b = 2;
                break;
            case "HMACSHA384":
                b = 3;
                break;
            case "HMACSHA512":
                b = 4;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            i = 20;
        } else if (b == 1) {
            i = 28;
        } else if (b == 2) {
            i = 32;
        } else if (b == 3) {
            i = 48;
        } else {
            if (b != 4) {
                throw new NoSuchAlgorithmException("unknown Hmac algorithm: ".concat(str));
            }
            i = 64;
        }
        this.zzd = i;
        zzgwzVar.get();
    }

    @Override // com.google.android.gms.internal.ads.zzgro
    public final byte[] zza(byte[] bArr, int i) throws InvalidAlgorithmParameterException {
        if (i > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ThreadLocal threadLocal = this.zza;
        ((Mac) threadLocal.get()).update(bArr);
        return Arrays.copyOf(((Mac) threadLocal.get()).doFinal(), i);
    }
}
