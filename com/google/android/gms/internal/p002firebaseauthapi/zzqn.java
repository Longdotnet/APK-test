package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class zzqn implements zzjk {
    private final ThreadLocal zza;
    private final String zzb;
    private final Key zzc;
    private final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    public zzqn(String str, Key key) throws GeneralSecurityException {
        byte b;
        int i;
        zzqm zzqmVar = new zzqm(this);
        this.zza = zzqmVar;
        if (!zzdv.zza(2)) {
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
        if (b != 0) {
            if (b == 1) {
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
        } else {
            this.zzd = 20;
        }
        zzqmVar.get();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzjk
    public final byte[] zza(byte[] bArr, int i) throws InvalidAlgorithmParameterException {
        if (i > this.zzd) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        ((Mac) this.zza.get()).update(bArr);
        return Arrays.copyOf(((Mac) this.zza.get()).doFinal(), i);
    }
}
