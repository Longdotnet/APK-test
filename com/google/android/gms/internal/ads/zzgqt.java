package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqt implements zzgow {
    private static final zzgqt zza = new zzgqt();
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgqp
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzgrn.zza((zzgnd) zzgezVar);
        }
    }, zzgnd.class, zzgfl.class);

    public static void zzc() {
        zzgnv.zza().zzd(zza);
        zzgnv.zza().zzc(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zza() {
        return zzgfl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zzb() {
        return zzgfl.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final /* bridge */ /* synthetic */ Object zze(zzgmy zzgmyVar, zzgnh zzgnhVar, zzgor zzgorVar) throws GeneralSecurityException {
        zzgni zzgniVar;
        zzgni zzgniVarZza;
        zzgxe zzgxeVarZzc;
        zzgoj zzgojVar = new zzgoj();
        for (int i = 0; i < zzgmyVar.zza(); i++) {
            zzgfg zzgfgVarZzb = ((zzgfi) zzgmyVar).zzb(i);
            if (zzgfgVarZzb.zzc().equals(zzgfb.zza)) {
                zzgfl zzgflVar = (zzgfl) zzgorVar.zza(zzgfgVarZzb);
                zzgez zzgezVarZzb = zzgfgVarZzb.zzb();
                if (zzgezVarZzb instanceof zzgqn) {
                    zzgxeVarZzc = ((zzgqn) zzgezVarZzb).zzd();
                } else {
                    if (!(zzgezVarZzb instanceof zzgnd)) {
                        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Cannot get output prefix for key of class ", zzgezVarZzb.getClass().getName(), " with parameters ", String.valueOf(zzgezVarZzb.zza())));
                    }
                    zzgxeVarZzc = ((zzgnd) zzgezVarZzb).zzc();
                }
                zzgojVar.zza(zzgxeVarZzc, new zzgqq(zzgflVar, zzgfgVarZzb.zza()));
            }
        }
        if (zzgnhVar.zza()) {
            zzgniVar = zzgnl.zza;
            zzgniVarZza = zzgniVar;
        } else {
            zzgnj zzgnjVarZza = zzgnt.zzb().zza();
            zzgni zzgniVarZza2 = zzgnjVarZza.zza(zzgmyVar, zzgnhVar, "mac", "compute");
            zzgniVarZza = zzgnjVarZza.zza(zzgmyVar, zzgnhVar, "mac", "verify");
            zzgniVar = zzgniVarZza2;
        }
        zzgfi zzgfiVar = (zzgfi) zzgmyVar;
        return new zzgqr(new zzgqq((zzgfl) zzgorVar.zza(zzgfiVar.zzc()), zzgfiVar.zzc().zza()), zzgojVar.zzb(), zzgniVar, zzgniVarZza, null);
    }
}
