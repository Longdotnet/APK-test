package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzghn {
    private zzghx zza = null;
    private zzgxf zzb = null;
    private Integer zzc = null;

    private zzghn() {
    }

    public final zzghn zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzghn zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzghn zzc(zzghx zzghxVar) {
        this.zza = zzghxVar;
        return this;
    }

    public /* synthetic */ zzghn(zzgho zzghoVar) {
    }

    public final zzghp zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzgxeVarZzb;
        zzghx zzghxVar = this.zza;
        if (zzghxVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzghxVar.zzb() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghxVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException(QTaELkFI.qBcWyShh);
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzghv.zzc) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (this.zza.zzd() == zzghv.zzb) {
            zzgxeVarZzb = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzghv.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzgxeVarZzb = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzghp(this.zza, this.zzb, zzgxeVarZzb, this.zzc, null);
    }
}
