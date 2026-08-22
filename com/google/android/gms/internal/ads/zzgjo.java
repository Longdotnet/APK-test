package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjo extends zzgfz {
    private final zzgjt zza;
    private final zzgxf zzb;
    private final zzgxe zzc;
    private final Integer zzd;

    private zzgjo(zzgjt zzgjtVar, zzgxf zzgxfVar, zzgxe zzgxeVar, Integer num) {
        this.zza = zzgjtVar;
        this.zzb = zzgxfVar;
        this.zzc = zzgxeVar;
        this.zzd = num;
    }

    public static zzgjo zzc(zzgjt zzgjtVar, zzgxf zzgxfVar, Integer num) throws GeneralSecurityException {
        zzgxe zzgxeVarZzb;
        zzgjs zzgjsVarZzc = zzgjtVar.zzc();
        zzgjs zzgjsVar = zzgjs.zzb;
        if (zzgjsVarZzc != zzgjsVar && num == null) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("For given Variant ", zzgjtVar.zzc().toString(), " the value of idRequirement must be non-null"));
        }
        if (zzgjtVar.zzc() == zzgjsVar && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgxfVar.zza() != 32) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgxfVar.zza(), "XAesGcmKey key must be constructed with key of length 32 bytes, not "));
        }
        if (zzgjtVar.zzc() == zzgjsVar) {
            zzgxeVarZzb = zzgnz.zza;
        } else {
            if (zzgjtVar.zzc() != zzgjs.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgjtVar.zzc().toString()));
            }
            zzgxeVarZzb = zzgnz.zzb(num.intValue());
        }
        return new zzgjo(zzgjtVar, zzgxfVar, zzgxeVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzc;
    }

    public final zzgjt zzd() {
        return this.zza;
    }

    public final zzgxf zze() {
        return this.zzb;
    }

    public final Integer zzf() {
        return this.zzd;
    }
}
