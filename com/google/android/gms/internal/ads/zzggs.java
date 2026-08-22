package com.google.android.gms.internal.ads;

import com.google.firebase.inject.PVS.jIKWv;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzggs {
    private zzghb zza = null;
    private zzgxf zzb = null;
    private Integer zzc = null;

    private zzggs() {
    }

    public final zzggs zza(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzggs zzb(zzgxf zzgxfVar) {
        this.zzb = zzgxfVar;
        return this;
    }

    public final zzggs zzc(zzghb zzghbVar) {
        this.zza = zzghbVar;
        return this;
    }

    public /* synthetic */ zzggs(zzggt zzggtVar) {
    }

    public final zzggu zzd() throws GeneralSecurityException {
        zzgxf zzgxfVar;
        zzgxe zzgxeVarZzb;
        zzghb zzghbVar = this.zza;
        if (zzghbVar == null || (zzgxfVar = this.zzb) == null) {
            throw new GeneralSecurityException(jIKWv.NbdbQdvXwqw);
        }
        if (zzghbVar.zzc() != zzgxfVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzghbVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzggz.zzc) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (this.zza.zze() == zzggz.zzb) {
            zzgxeVarZzb = zzgnz.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzggz.zza) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            zzgxeVarZzb = zzgnz.zzb(this.zzc.intValue());
        }
        return new zzggu(this.zza, this.zzb, zzgxeVarZzb, this.zzc, null);
    }
}
