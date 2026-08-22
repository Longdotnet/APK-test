package com.google.android.gms.internal.ads;

import androidx.lifecycle.hSi.sgtsHsWT;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgpk {
    private zzgpu zza = null;
    private zzgxf zzb = null;
    private Integer zzc = null;

    private zzgpk() {
    }

    public final zzgpk zza(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzgpk zzb(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpk zzc(zzgpu zzgpuVar) {
        this.zza = zzgpuVar;
        return this;
    }

    public /* synthetic */ zzgpk(zzgpl zzgplVar) {
    }

    public final zzgpm zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzgxeVarZza;
        zzgpu zzgpuVar = this.zza;
        if (zzgpuVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgpuVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgpuVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException(sgtsHsWT.wnsALzgSvy);
        }
        if (this.zza.zzf() == zzgps.zzd) {
            zzgxeVarZza = zzgnz.zza;
        } else if (this.zza.zzf() == zzgps.zzc || this.zza.zzf() == zzgps.zzb) {
            zzgxeVarZza = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzgps.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
            }
            zzgxeVarZza = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzgpm(this.zza, this.zzb, zzgxeVarZza, this.zzc, null);
    }
}
