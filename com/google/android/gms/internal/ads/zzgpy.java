package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgpy implements zzgow {
    private static final zzgpy zza = new zzgpy();

    private zzgpy() {
    }

    public static void zzc() {
        zzgnv.zza().zzd(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zza() {
        return zzgpv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zzb() {
        return zzgpv.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final /* bridge */ /* synthetic */ Object zze(zzgmy zzgmyVar, zzgnh zzgnhVar, zzgor zzgorVar) throws GeneralSecurityException {
        zzgxe zzgxeVarZzc;
        zzgfg zzgfgVarZzc = ((zzgfi) zzgmyVar).zzc();
        zzgoj zzgojVar = new zzgoj();
        for (int i = 0; i < zzgmyVar.zza(); i++) {
            zzgfg zzgfgVarZzb = ((zzgfi) zzgmyVar).zzb(i);
            if (zzgfgVarZzb.zzc().equals(zzgfb.zza)) {
                zzgpv zzgpvVar = (zzgpv) zzgorVar.zza(zzgfgVarZzb);
                zzgez zzgezVarZzb = zzgfgVarZzb.zzb();
                if (zzgezVarZzb instanceof zzgqn) {
                    zzgxeVarZzc = ((zzgqn) zzgezVarZzb).zzd();
                } else {
                    if (!(zzgezVarZzb instanceof zzgnd)) {
                        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Cannot get output prefix for key of class ", zzgezVarZzb.getClass().getName(), " with parameters ", String.valueOf(zzgezVarZzb.zza())));
                    }
                    zzgxeVarZzc = ((zzgnd) zzgezVarZzb).zzc();
                }
                zzgojVar.zza(zzgxeVarZzc, zzgpvVar);
            }
        }
        return new zzgpw(zzgojVar.zzb(), (zzgpv) zzgorVar.zza(zzgfgVarZzc), null);
    }
}
