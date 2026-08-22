package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzgis {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgio
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgis.zzd((zzgin) zzgfmVar);
            }
        }, zzgin.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgip
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgis.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgiq
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgis.zzc((zzgil) zzgezVar, zzgfnVar);
            }
        }, zzgil.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgis.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgil zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzguv zzguvVarZzd = zzguv.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzguvVarZzd.zza() == 0) {
                return zzgil.zzc(zzgin.zzc(zzguvVarZzd.zzf().zzf(), zzf(zzgoxVar.zzc())), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got ".concat(String.valueOf(zzguvVarZzd)));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgin zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            return zzgin.zzc(zzguy.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza()).zzf(), zzf(zzgoyVar.zzc().zzg()));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgil zzgilVar, zzgfn zzgfnVar) {
        zzgut zzgutVarZzb = zzguv.zzb();
        zzguw zzguwVarZza = zzguy.zza();
        zzguwVarZza.zza(zzgilVar.zzd().zzd());
        zzgutVarZzb.zza((zzguy) zzguwVarZza.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzguv) zzgutVarZzb.zzbr()).zzaN(), zzgtz.REMOTE, zzg(zzgilVar.zzd().zzb()), zzgilVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgin zzginVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzguw zzguwVarZza = zzguy.zza();
        zzguwVarZza.zza(zzginVar.zzd());
        zzgudVarZza.zzc(((zzguy) zzguwVarZza.zzbr()).zzaN());
        zzgudVarZza.zza(zzg(zzginVar.zzb()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgim zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzgim.zza;
        }
        if (iOrdinal == 3) {
            return zzgim.zzb;
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    private static zzgvf zzg(zzgim zzgimVar) throws GeneralSecurityException {
        if (zzgim.zza.equals(zzgimVar)) {
            return zzgvf.TINK;
        }
        if (zzgim.zzb.equals(zzgimVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgimVar.toString()));
    }
}
