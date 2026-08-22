package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzggf implements zzgow {
    private static final zzggf zza = new zzggf();
    private static final zzgoq zzb = zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzggb
        @Override // com.google.android.gms.internal.ads.zzgoo
        public final Object zza(zzgez zzgezVar) {
            return zzglm.zzb((zzgnd) zzgezVar);
        }
    }, zzgnd.class, zzget.class);

    public static void zzc() {
        zzgnv.zza().zzd(zza);
        zzgnv.zza().zzc(zzb);
    }

    public static void zzd(zzgos zzgosVar) {
        zzgosVar.zzb(zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zza() {
        return zzget.class;
    }

    @Override // com.google.android.gms.internal.ads.zzgow
    public final Class zzb() {
        return zzget.class;
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
                zzgez zzgezVarZzb = zzgfgVarZzb.zzb();
                if (zzgezVarZzb instanceof zzgfz) {
                    zzgxeVarZzc = ((zzgfz) zzgezVarZzb).zzb();
                } else {
                    if (!(zzgezVarZzb instanceof zzgnd)) {
                        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m("Cannot get output prefix for key of class ", zzgezVarZzb.getClass().getName(), " with parameters ", String.valueOf(zzgezVarZzb.zza())));
                    }
                    zzgxeVarZzc = ((zzgnd) zzgezVarZzb).zzc();
                }
                zzgojVar.zza(zzgxeVarZzc, new zzggc((zzget) zzgorVar.zza(zzgfgVarZzb), zzgfgVarZzb.zza()));
            }
        }
        if (zzgnhVar.zza()) {
            zzgniVar = zzgnl.zza;
            zzgniVarZza = zzgniVar;
        } else {
            zzgnj zzgnjVarZza = zzgnt.zzb().zza();
            zzgni zzgniVarZza2 = zzgnjVarZza.zza(zzgmyVar, zzgnhVar, "aead", "encrypt");
            zzgniVarZza = zzgnjVarZza.zza(zzgmyVar, zzgnhVar, "aead", "decrypt");
            zzgniVar = zzgniVarZza2;
        }
        zzgfi zzgfiVar = (zzgfi) zzgmyVar;
        return new zzggd(new zzggc((zzget) zzgorVar.zza(zzgfiVar.zzc()), zzgfiVar.zzc().zza()), zzgojVar.zzb(), zzgniVar, zzgniVarZza, null);
    }
}
