package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzghy extends zzgfz {
    private final zzgid zza;
    private final zzgxf zzb;
    private final zzgxe zzc;
    private final Integer zzd;

    private zzghy(zzgid zzgidVar, zzgxf zzgxfVar, zzgxe zzgxeVar, Integer num) {
        this.zza = zzgidVar;
        this.zzb = zzgxfVar;
        this.zzc = zzgxeVar;
        this.zzd = num;
    }

    public static zzghy zzc(zzgic zzgicVar, zzgxf zzgxfVar, Integer num) throws GeneralSecurityException {
        zzgxe zzgxeVarZzb;
        zzgic zzgicVar2 = zzgic.zzc;
        if (zzgicVar != zzgicVar2 && num == null) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("For given Variant ", zzgicVar.toString(), " the value of idRequirement must be non-null"));
        }
        if (zzgicVar == zzgicVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgxfVar.zza() != 32) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgxfVar.zza(), "ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not "));
        }
        zzgid zzgidVarZzc = zzgid.zzc(zzgicVar);
        if (zzgidVarZzc.zzb() == zzgicVar2) {
            zzgxeVarZzb = zzgnz.zza;
        } else if (zzgidVarZzc.zzb() == zzgic.zzb) {
            zzgxeVarZzb = zzgnz.zza(num.intValue());
        } else {
            if (zzgidVarZzc.zzb() != zzgic.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgidVarZzc.zzb().toString()));
            }
            zzgxeVarZzb = zzgnz.zzb(num.intValue());
        }
        return new zzghy(zzgidVarZzc, zzgxfVar, zzgxeVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzc;
    }

    public final zzgid zzd() {
        return this.zza;
    }

    public final zzgxf zze() {
        return this.zzb;
    }

    public final Integer zzf() {
        return this.zzd;
    }
}
