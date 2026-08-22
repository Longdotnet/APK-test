package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgjd {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgiz
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgjd.zzd((zzgiy) zzgfmVar);
            }
        }, zzgiy.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgja
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgjd.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgjb
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgjd.zzc((zzgit) zzgezVar, zzgfnVar);
            }
        }, zzgit.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgjc
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgjd.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgit zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzgvb zzgvbVarZzd = zzgvb.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgvbVarZzd.zza() == 0) {
                return zzgit.zzc(zzf(zzgvbVarZzd.zzf(), zzgoxVar.zzc()), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got ".concat(String.valueOf(zzgvbVarZzd)));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzgiy zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            return zzf(zzgve.zzf(zzgoyVar.zzc().zzh(), zzgyr.zza()), zzgoyVar.zzc().zzg());
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgit zzgitVar, zzgfn zzgfnVar) {
        zzguz zzguzVarZzb = zzgvb.zzb();
        zzguzVarZzb.zza(zzg(zzgitVar.zzd()));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgvb) zzguzVarZzb.zzbr()).zzaN(), zzgtz.REMOTE, zzh(zzgitVar.zzd().zzc()), zzgitVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgiy zzgiyVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzgudVarZza.zzc(zzg(zzgiyVar).zzaN());
        zzgudVarZza.zza(zzh(zzgiyVar.zzc()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgiy zzf(zzgve zzgveVar, zzgvf zzgvfVar) throws GeneralSecurityException {
        zzgiv zzgivVar;
        zzgiw zzgiwVar;
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb(zzgveVar.zza().zzi());
        zzgudVarZza.zzc(zzgveVar.zza().zzh());
        zzgudVarZza.zza(zzgvf.RAW);
        zzgfm zzgfmVarZza = zzgfo.zza(((zzguf) zzgudVarZza.zzbr()).zzaV());
        if (zzgfmVarZza instanceof zzghm) {
            zzgivVar = zzgiv.zza;
        } else if (zzgfmVarZza instanceof zzgid) {
            zzgivVar = zzgiv.zzc;
        } else if (zzgfmVarZza instanceof zzgka) {
            zzgivVar = zzgiv.zzb;
        } else if (zzgfmVarZza instanceof zzggr) {
            zzgivVar = zzgiv.zzd;
        } else if (zzgfmVarZza instanceof zzghb) {
            zzgivVar = zzgiv.zze;
        } else {
            if (!(zzgfmVarZza instanceof zzghx)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzgfmVarZza.toString()));
            }
            zzgivVar = zzgiv.zzf;
        }
        zzgiu zzgiuVar = new zzgiu(null);
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            zzgiwVar = zzgiw.zza;
        } else {
            if (iOrdinal != 3) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
            zzgiwVar = zzgiw.zzb;
        }
        zzgiuVar.zzd(zzgiwVar);
        zzgiuVar.zzc(zzgveVar.zzg());
        zzgiuVar.zza((zzgga) zzgfmVarZza);
        zzgiuVar.zzb(zzgivVar);
        return zzgiuVar.zze();
    }

    private static zzgve zzg(zzgiy zzgiyVar) throws GeneralSecurityException {
        try {
            zzguf zzgufVarZzf = zzguf.zzf(zzgfo.zzb(zzgiyVar.zzb()), zzgyr.zza());
            zzgvc zzgvcVarZzb = zzgve.zzb();
            zzgvcVarZzb.zzb(zzgiyVar.zzd());
            zzgvcVarZzb.zza(zzgufVarZzf);
            return (zzgve) zzgvcVarZzb.zzbr();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgvf zzh(zzgiw zzgiwVar) throws GeneralSecurityException {
        if (zzgiw.zza.equals(zzgiwVar)) {
            return zzgvf.TINK;
        }
        if (zzgiw.zzb.equals(zzgiwVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgiwVar)));
    }
}
