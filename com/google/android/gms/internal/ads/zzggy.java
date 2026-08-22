package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggy {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private zzggz zzd = zzggz.zzc;

    private zzggy() {
    }

    public final zzggy zza(int i) throws GeneralSecurityException {
        if (i != 12 && i != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzggy zzb(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzggy zzc(int i) {
        this.zzc = 16;
        return this;
    }

    public final zzggy zzd(zzggz zzggzVar) {
        this.zzd = zzggzVar;
        return this;
    }

    public final zzghb zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.zzb.intValue();
        this.zzc.getClass();
        return new zzghb(iIntValue, iIntValue2, 16, this.zzd, null);
    }

    public /* synthetic */ zzggy(zzgha zzghaVar) {
    }
}
