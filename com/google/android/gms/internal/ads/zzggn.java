package com.google.android.gms.internal.ads;

import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzggn {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private Integer zzd = null;
    private zzggo zze = null;
    private zzggp zzf = zzggp.zzc;

    private zzggn() {
    }

    public final zzggn zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzggn zzb(zzggo zzggoVar) {
        this.zze = zzggoVar;
        return this;
    }

    public final zzggn zzd(int i) throws GeneralSecurityException {
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i)));
        }
        this.zzc = Integer.valueOf(i);
        return this;
    }

    public final zzggn zze(int i) throws GeneralSecurityException {
        if (i < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
        }
        this.zzd = Integer.valueOf(i);
        return this;
    }

    public final zzggn zzf(zzggp zzggpVar) {
        this.zzf = zzggpVar;
        return this;
    }

    public final zzggr zzg() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("AES key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("iv size is not set");
        }
        Integer num = this.zzd;
        if (num == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zze == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzf == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        int iIntValue = num.intValue();
        zzggo zzggoVar = this.zze;
        if (zzggoVar == zzggo.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
            }
        } else if (zzggoVar == zzggo.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
            }
        } else if (zzggoVar == zzggo.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
            }
        } else if (zzggoVar == zzggo.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
            }
        } else {
            if (zzggoVar != zzggo.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
            }
        }
        return new zzggr(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, null);
    }

    public /* synthetic */ zzggn(zzggq zzggqVar) {
    }

    public final zzggn zzc(int i) throws InvalidAlgorithmParameterException {
        if (i < 16) {
            throw new InvalidAlgorithmParameterException(String.format(xPQrbOSWiEdU.cKXeGcdTmuW, Integer.valueOf(i)));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }
}
