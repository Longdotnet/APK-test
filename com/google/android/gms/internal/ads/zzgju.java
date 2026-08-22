package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgju extends zzgfz {
    private final zzgka zza;
    private final zzgxf zzb;
    private final zzgxe zzc;
    private final Integer zzd;

    private zzgju(zzgka zzgkaVar, zzgxf zzgxfVar, zzgxe zzgxeVar, Integer num) {
        this.zza = zzgkaVar;
        this.zzb = zzgxfVar;
        this.zzc = zzgxeVar;
        this.zzd = num;
    }

    public static zzgju zzc(zzgjz zzgjzVar, zzgxf zzgxfVar, Integer num) throws GeneralSecurityException {
        zzgxe zzgxeVarZzb;
        zzgjz zzgjzVar2 = zzgjz.zzc;
        if (zzgjzVar != zzgjzVar2 && num == null) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("For given Variant ", zzgjzVar.toString(), " the value of idRequirement must be non-null"));
        }
        if (zzgjzVar == zzgjzVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgxfVar.zza() != 32) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgxfVar.zza(), "XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzgka zzgkaVarZzc = zzgka.zzc(zzgjzVar);
        if (zzgkaVarZzc.zzb() == zzgjzVar2) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (zzgkaVarZzc.zzb() == zzgjz.zzb) {
            zzgxeVarZzb = zzgnz.zza(num.intValue());
        } else {
            if (zzgkaVarZzc.zzb() != zzgjz.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgkaVarZzc.zzb().toString()));
            }
            zzgxeVarZzb = zzgnz.zzb(num.intValue());
        }
        return new zzgju(zzgkaVarZzc, zzgxfVar, zzgxeVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzc;
    }

    public final zzgka zzd() {
        return this.zza;
    }

    public final zzgxf zze() {
        return this.zzb;
    }

    public final Integer zzf() {
        return this.zzd;
    }
}
