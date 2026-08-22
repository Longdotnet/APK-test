package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkx {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkt
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkx.zzd((zzghx) zzgfmVar);
            }
        }, zzghx.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgku
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkx.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgkv
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkx.zzc((zzghp) zzgezVar, zzgfnVar);
            }
        }, zzghp.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkw
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkx.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzghp zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgte zzgteVarZzd = zzgte.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgteVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzghu zzghuVarZzc = zzghx.zzc();
            zzghuVarZzc.zza(zzgteVarZzd.zzf().zzd());
            zzghuVarZzc.zzb(zzf(zzgoxVar.zzc()));
            zzghx zzghxVarZzc = zzghuVarZzc.zzc();
            zzghn zzghnVarZzc = zzghp.zzc();
            zzghnVarZzc.zzc(zzghxVarZzc);
            zzghnVarZzc.zzb(zzgxf.zzb(zzgteVarZzd.zzf().zzA(), zzgfnVar));
            zzghnVarZzc.zza(zzgoxVar.zzf());
            return zzghnVarZzc.zzd();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzghx zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgth zzgthVarZzf = zzgth.zzf(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzgthVarZzf.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzghu zzghuVarZzc = zzghx.zzc();
            zzghuVarZzc.zza(zzgthVarZzf.zza());
            zzghuVarZzc.zzb(zzf(zzgoyVar.zzc().zzg()));
            return zzghuVarZzc.zzc();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghp zzghpVar, zzgfn zzgfnVar) {
        zzgtc zzgtcVarZzb = zzgte.zzb();
        byte[] bArrZzd = zzghpVar.zze().zzd(zzgfnVar);
        zzgtcVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgte) zzgtcVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzghpVar.zzd().zzd()), zzghpVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzghx zzghxVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgtf zzgtfVarZzc = zzgth.zzc();
        zzgtfVarZzc.zza(zzghxVar.zzb());
        zzgudVarZza.zzc(((zzgth) zzgtfVarZzc.zzbr()).zzaN());
        zzgudVarZza.zza(zzg(zzghxVar.zzd()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzghv zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzghv.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzghv.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzghv.zzb;
    }

    private static zzgvf zzg(zzghv zzghvVar) throws GeneralSecurityException {
        if (zzghv.zza.equals(zzghvVar)) {
            return zzgvf.TINK;
        }
        if (zzghv.zzb.equals(zzghvVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzghv.zzc.equals(zzghvVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzghvVar)));
    }
}
