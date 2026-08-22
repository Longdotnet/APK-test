package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzis {
    public static final /* synthetic */ int zza = 0;
    private static final zzqv zzb;
    private static final zzgv zzc;
    private static final zzgr zzd;
    private static final zzfz zze;
    private static final zzfv zzf;

    static {
        zzqv zzqvVarZzb = zzhj.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzqvVarZzb;
        zzc = zzgv.zza(new zzgt() { // from class: com.google.android.gms.internal.firebase-auth-api.zzio
        }, zzin.class, zzgz.class);
        zzd = zzgr.zza(new zzgp() { // from class: com.google.android.gms.internal.firebase-auth-api.zzip
        }, zzqvVarZzb, zzgz.class);
        zze = zzfz.zza(new zzfx() { // from class: com.google.android.gms.internal.firebase-auth-api.zziq
        }, zzie.class, zzgy.class);
        zzf = zzfv.zzb(new zzft() { // from class: com.google.android.gms.internal.firebase-auth-api.zzir
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzft
            public final zzaw zza(zzha zzhaVar, zzca zzcaVar) throws GeneralSecurityException {
                zzik zzikVar;
                zzil zzilVar;
                int i = zzis.zza;
                if (!((zzgy) zzhaVar).zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to HmacParameters.parseParameters");
                }
                try {
                    zzmt zzmtVarZze = zzmt.zze(((zzgy) zzhaVar).zze(), zzacs.zza());
                    if (zzmtVarZze.zza() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    zzij zzijVar = new zzij(null);
                    zzijVar.zzb(zzmtVarZze.zzg().zzd());
                    zzijVar.zzc(zzmtVarZze.zzf().zza());
                    int iZzf = zzmtVarZze.zzf().zzf();
                    zzoy zzoyVar = zzoy.UNKNOWN_PREFIX;
                    int i2 = iZzf - 2;
                    if (i2 == 1) {
                        zzikVar = zzik.zza;
                    } else if (i2 == 2) {
                        zzikVar = zzik.zzd;
                    } else if (i2 == 3) {
                        zzikVar = zzik.zzc;
                    } else if (i2 == 4) {
                        zzikVar = zzik.zze;
                    } else {
                        if (i2 != 5) {
                            throw new GeneralSecurityException("Unable to parse HashType: " + zzmq.zza(iZzf));
                        }
                        zzikVar = zzik.zzb;
                    }
                    zzijVar.zza(zzikVar);
                    zzoy zzoyVarZzc = ((zzgy) zzhaVar).zzc();
                    int iOrdinal = zzoyVarZzc.ordinal();
                    if (iOrdinal == 1) {
                        zzilVar = zzil.zza;
                    } else if (iOrdinal == 2) {
                        zzilVar = zzil.zzc;
                    } else if (iOrdinal == 3) {
                        zzilVar = zzil.zzd;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzoyVarZzc.zza());
                        }
                        zzilVar = zzil.zzb;
                    }
                    zzijVar.zzd(zzilVar);
                    zzin zzinVarZze = zzijVar.zze();
                    zzic zzicVar = new zzic(null);
                    zzicVar.zzc(zzinVarZze);
                    zzicVar.zzb(zzqw.zzb(zzmtVarZze.zzg().zzt(), zzcaVar));
                    zzicVar.zza(((zzgy) zzhaVar).zzf());
                    return zzicVar.zzd();
                } catch (zzadn | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing HmacKey failed");
                }
            }
        }, zzqvVarZzb, zzgy.class);
    }

    public static void zza() {
        zzgn zzgnVarZzb = zzgn.zzb();
        zzgnVarZzb.zzf(zzc);
        zzgnVarZzb.zze(zzd);
        zzgnVarZzb.zzd(zze);
        zzgnVarZzb.zzc(zzf);
    }
}
