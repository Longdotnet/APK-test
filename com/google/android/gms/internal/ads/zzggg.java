package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggg {
    private zzggr zza = null;
    private zzgxf zzb = null;
    private zzgxf zzc = null;
    private Integer zzd = null;

    private zzggg() {
    }

    public final zzggg zza(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzggg zzb(zzgxf zzgxfVar) {
        this.zzc = zzgxfVar;
        return this;
    }

    public final zzggg zzc(Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzggg zzd(zzggr zzggrVar) {
        this.zza = zzggrVar;
        return this;
    }

    public final zzggi zze() throws GeneralSecurityException {
        zzgxe zzgxeVarZzb;
        zzggr zzggrVar = this.zza;
        if (zzggrVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzgxf zzgxfVar = this.zzb;
        if (zzgxfVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzggrVar.zzb() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzggrVar.zzc() != this.zzc.zza()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzh() == zzggp.zzc) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (this.zza.zzh() == zzggp.zzb) {
            zzgxeVarZzb = zzgnz.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzh() != zzggp.zza) {
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzh())));
            }
            zzgxeVarZzb = zzgnz.zzb(this.zzd.intValue());
        }
        return new zzggi(this.zza, this.zzb, this.zzc, zzgxeVarZzb, this.zzd, null);
    }

    public /* synthetic */ zzggg(zzggh zzgghVar) {
    }
}
