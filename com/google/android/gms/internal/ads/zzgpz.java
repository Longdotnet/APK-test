package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgpz {
    private zzgql zza = null;
    private zzgxf zzb = null;
    private Integer zzc = null;

    private zzgpz() {
    }

    public final zzgpz zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpz zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzgpz zzc(zzgql zzgqlVar) {
        this.zza = zzgqlVar;
        return this;
    }

    public final zzgqb zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzgxeVarZza;
        zzgql zzgqlVar = this.zza;
        if (zzgqlVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgqlVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgqlVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzgqj.zzd) {
            zzgxeVarZza = zzgnz.zza;
        } else if (this.zza.zzg() == zzgqj.zzc || this.zza.zzg() == zzgqj.zzb) {
            zzgxeVarZza = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzg() != zzgqj.zza) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zzg())));
            }
            zzgxeVarZza = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzgqb(this.zza, this.zzb, zzgxeVarZza, this.zzc, null);
    }

    public /* synthetic */ zzgpz(zzgqa zzgqaVar) {
    }
}
