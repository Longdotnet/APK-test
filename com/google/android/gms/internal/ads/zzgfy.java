package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgfy {
    public static final /* synthetic */ int zza = 0;
    private static final zzgmo zzb = zzb();

    public static zzgex zza() throws GeneralSecurityException {
        if (zzgmh.zzb()) {
            throw new GeneralSecurityException("Cannot use non-FIPS-compliant AeadConfigurationV1 in FIPS mode");
        }
        return zzb;
    }

    private static zzgmo zzb() {
        try {
            zzgos zzgosVarZza = zzgov.zza();
            zzggf.zzd(zzgosVarZza);
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfr
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    return zzgwg.zzb((zzggi) zzgezVar);
                }
            }, zzggi.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfs
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    return zzgwd.zzb((zzghe) zzgezVar);
                }
            }, zzghe.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgft
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    return zzgmc.zzb((zzghp) zzgezVar);
                }
            }, zzghp.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfu
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    return zzgwc.zzb((zzggu) zzgezVar);
                }
            }, zzggu.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfv
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    zzghy zzghyVar = (zzghy) zzgezVar;
                    int i = zzgfy.zza;
                    return zzgkz.zze() ? zzgkz.zzb(zzghyVar) : zzgwf.zzb(zzghyVar);
                }
            }, zzghy.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfw
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    zzgju zzgjuVar = (zzgju) zzgezVar;
                    int i = zzgfy.zza;
                    return zzglu.zzc() ? zzglu.zzb(zzgjuVar) : zzgxd.zzb(zzgjuVar);
                }
            }, zzgju.class, zzget.class));
            zzgosVarZza.zza(zzgoq.zzb(new zzgoo() { // from class: com.google.android.gms.internal.ads.zzgfx
                @Override // com.google.android.gms.internal.ads.zzgoo
                public final Object zza(zzgez zzgezVar) {
                    return zzglo.zzb((zzgjo) zzgezVar);
                }
            }, zzgjo.class, zzget.class));
            return zzgmo.zzb(zzgosVarZza.zzc());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
