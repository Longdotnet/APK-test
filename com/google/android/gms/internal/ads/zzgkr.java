package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkr {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkn
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkr.zzd((zzghm) zzgfmVar);
            }
        }, zzghm.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgko
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkr.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgkp
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkr.zzc((zzghe) zzgezVar, zzgfnVar);
            }
        }, zzghe.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkq
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkr.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzghe zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzgsy zzgsyVarZzd = zzgsy.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgsyVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzghj zzghjVarZzc = zzghm.zzc();
            zzghjVarZzc.zzb(zzgsyVarZzd.zzf().zzd());
            zzghjVarZzc.zza(12);
            zzghjVarZzc.zzc(16);
            zzghjVarZzc.zzd(zzf(zzgoxVar.zzc()));
            zzghm zzghmVarZze = zzghjVarZzc.zze();
            zzghc zzghcVarZzc = zzghe.zzc();
            zzghcVarZzc.zzc(zzghmVarZze);
            zzghcVarZzc.zzb(zzgxf.zzb(zzgsyVarZzd.zzf().zzA(), zzgfnVar));
            zzghcVarZzc.zza(zzgoxVar.zzf());
            return zzghcVarZzc.zzd();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    public static /* synthetic */ zzghm zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgtb zzgtbVarZzf = zzgtb.zzf(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzgtbVarZzf.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzghj zzghjVarZzc = zzghm.zzc();
            zzghjVarZzc.zzb(zzgtbVarZzf.zza());
            zzghjVarZzc.zza(12);
            zzghjVarZzc.zzc(16);
            zzghjVarZzc.zzd(zzf(zzgoyVar.zzc().zzg()));
            return zzghjVarZzc.zze();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghe zzgheVar, zzgfn zzgfnVar) {
        zzgsw zzgswVarZzb = zzgsy.zzb();
        byte[] bArrZzd = zzgheVar.zze().zzd(zzgfnVar);
        zzgswVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgsy) zzgswVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzgheVar.zzd().zzd()), zzgheVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzghm zzghmVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgsz zzgszVarZzc = zzgtb.zzc();
        zzgszVarZzc.zza(zzghmVar.zzb());
        zzgudVarZza.zzc(((zzgtb) zzgszVarZzc.zzbr()).zzaN());
        zzgudVarZza.zza(zzg(zzghmVar.zzd()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzghk zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzghk.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzghk.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzghk.zzb;
    }

    private static zzgvf zzg(zzghk zzghkVar) throws GeneralSecurityException {
        if (zzghk.zza.equals(zzghkVar)) {
            return zzgvf.TINK;
        }
        if (zzghk.zzb.equals(zzghkVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzghk.zzc.equals(zzghkVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzghkVar)));
    }
}
