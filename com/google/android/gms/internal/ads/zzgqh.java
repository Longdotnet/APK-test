package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqh {
    private Integer zza = null;
    private Integer zzb = null;
    private zzgqi zzc = null;
    private zzgqj zzd = zzgqj.zzd;

    private zzgqh() {
    }

    public final zzgqh zza(zzgqi zzgqiVar) {
        this.zzc = zzgqiVar;
        return this;
    }

    public final zzgqh zzb(int i) {
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzgqh zzc(int i) {
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzgqh zzd(zzgqj zzgqjVar) {
        this.zzd = zzgqjVar;
        return this;
    }

    public final zzgql zze() throws GeneralSecurityException {
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
        if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
        }
        Integer num2 = this.zzb;
        int iIntValue = num2.intValue();
        zzgqi zzgqiVar = this.zzc;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (zzgqiVar == zzgqi.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (zzgqiVar == zzgqi.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (zzgqiVar == zzgqi.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (zzgqiVar == zzgqi.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (zzgqiVar != zzgqi.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new zzgql(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, null);
    }

    public /* synthetic */ zzgqh(zzgqk zzgqkVar) {
    }
}
