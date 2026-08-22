package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzij {
    private Integer zza;
    private Integer zzb;
    private zzik zzc;
    private zzil zzd;

    public /* synthetic */ zzij(zzii zziiVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzil.zzd;
    }

    public final zzij zza(zzik zzikVar) {
        this.zzc = zzikVar;
        return this;
    }

    public final zzij zzb(int i) {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzij zzc(int i) {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzij zzd(zzil zzilVar) {
        this.zzd = zzilVar;
        return this;
    }

    public final zzin zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        Integer num2 = this.zzb;
        int iIntValue = num2.intValue();
        zzik zzikVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (zzikVar == zzik.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (zzikVar == zzik.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (zzikVar == zzik.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (zzikVar == zzik.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (zzikVar != zzik.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new zzin(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }

    private zzij() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }
}
