package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgit extends zzgfz {
    private final zzgiy zza;
    private final zzgxe zzb;
    private final Integer zzc;

    private zzgit(zzgiy zzgiyVar, zzgxe zzgxeVar, Integer num) {
        this.zza = zzgiyVar;
        this.zzb = zzgxeVar;
        this.zzc = num;
    }

    public static zzgit zzc(zzgiy zzgiyVar, Integer num) throws GeneralSecurityException {
        zzgxe zzgxeVarZzb;
        if (zzgiyVar.zzc() == zzgiw.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzgxeVarZzb = zzgnz.zza;
        } else {
            if (zzgiyVar.zzc() != zzgiw.zza) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(zzgiyVar.zzc())));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzgxeVarZzb = zzgnz.zzb(num.intValue());
        }
        return new zzgit(zzgiyVar, zzgxeVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzb;
    }

    public final zzgiy zzd() {
        return this.zza;
    }

    public final Integer zze() {
        return this.zzc;
    }
}
