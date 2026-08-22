package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghc {
    private zzghm zza = null;
    private zzgxf zzb = null;
    private Integer zzc = null;

    private zzghc() {
    }

    public final zzghc zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghc zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzghc zzc(zzghm zzghmVar) {
        this.zza = zzghmVar;
        return this;
    }

    public final zzghe zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzgxeVarZzb;
        zzghm zzghmVar = this.zza;
        if (zzghmVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzghmVar.zzb() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghmVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzghk.zzc) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (this.zza.zzd() == zzghk.zzb) {
            zzgxeVarZzb = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzghk.zza) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzgxeVarZzb = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzghe(this.zza, this.zzb, zzgxeVarZzb, this.zzc, null);
    }

    public /* synthetic */ zzghc(zzghd zzghdVar) {
    }
}
