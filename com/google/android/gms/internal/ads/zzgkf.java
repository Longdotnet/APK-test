package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkb
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkf.zzd((zzggr) zzgfmVar);
            }
        }, zzggr.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgkc
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkf.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgkd
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkf.zzc((zzggi) zzgezVar, zzgfnVar);
            }
        }, zzggi.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgke
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkf.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzggi zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzgsa zzgsaVarZzd = zzgsa.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgsaVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzgsaVarZzd.zzf().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzgsaVarZzd.zzg().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzggn zzggnVarZzf = zzggr.zzf();
            zzggnVarZzf.zza(zzgsaVarZzd.zzf().zzg().zzd());
            zzggnVarZzf.zzc(zzgsaVarZzd.zzg().zzh().zzd());
            zzggnVarZzf.zzd(zzgsaVarZzd.zzf().zzf().zza());
            zzggnVarZzf.zze(zzgsaVarZzd.zzg().zzg().zza());
            zzggnVarZzf.zzb(zzf(zzgsaVarZzd.zzg().zzg().zzb()));
            zzggnVarZzf.zzf(zzg(zzgoxVar.zzc()));
            zzggr zzggrVarZzg = zzggnVarZzf.zzg();
            zzggg zzgggVarZzc = zzggi.zzc();
            zzgggVarZzc.zzd(zzggrVarZzg);
            zzgggVarZzc.zza(zzgxf.zzb(zzgsaVarZzd.zzf().zzg().zzA(), zzgfnVar));
            zzgggVarZzc.zzb(zzgxf.zzb(zzgsaVarZzd.zzg().zzh().zzA(), zzgfnVar));
            zzgggVarZzc.zzc(zzgoxVar.zzf());
            return zzgggVarZzc.zze();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    public static /* synthetic */ zzggr zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgsd zzgsdVarZzc = zzgsd.zzc(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzgsdVarZzc.zzf().zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggn zzggnVarZzf = zzggr.zzf();
            zzggnVarZzf.zza(zzgsdVarZzc.zzd().zza());
            zzggnVarZzf.zzc(zzgsdVarZzc.zzf().zza());
            zzggnVarZzf.zzd(zzgsdVarZzc.zzd().zzf().zza());
            zzggnVarZzf.zze(zzgsdVarZzc.zzf().zzh().zza());
            zzggnVarZzf.zzb(zzf(zzgsdVarZzc.zzf().zzh().zzb()));
            zzggnVarZzf.zzf(zzg(zzgoyVar.zzc().zzg()));
            return zzggnVarZzf.zzg();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzggi zzggiVar, zzgfn zzgfnVar) {
        zzgry zzgryVarZzb = zzgsa.zzb();
        zzgse zzgseVarZzb = zzgsg.zzb();
        zzgsk zzgskVarZzb = zzgsm.zzb();
        zzgskVarZzb.zza(zzggiVar.zzd().zzd());
        zzgseVarZzb.zzb((zzgsm) zzgskVarZzb.zzbr());
        byte[] bArrZzd = zzggiVar.zze().zzd(zzgfnVar);
        zzgseVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        zzgryVarZzb.zza((zzgsg) zzgseVarZzb.zzbr());
        zzgtp zzgtpVarZzb = zzgtr.zzb();
        zzgtpVarZzb.zzb(zzh(zzggiVar.zzd()));
        byte[] bArrZzd2 = zzggiVar.zzf().zzd(zzgfnVar);
        zzgtpVarZzb.zza(zzgxz.zzv(bArrZzd2, 0, bArrZzd2.length));
        zzgryVarZzb.zzb((zzgtr) zzgtpVarZzb.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzgsa) zzgryVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzi(zzggiVar.zzd().zzh()), zzggiVar.zzg());
    }

    public static /* synthetic */ zzgoy zzd(zzggr zzggrVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzgsb zzgsbVarZza = zzgsd.zza();
        zzgsh zzgshVarZzb = zzgsj.zzb();
        zzgsk zzgskVarZzb = zzgsm.zzb();
        zzgskVarZzb.zza(zzggrVar.zzd());
        zzgshVarZzb.zzb((zzgsm) zzgskVarZzb.zzbr());
        zzgshVarZzb.zza(zzggrVar.zzb());
        zzgsbVarZza.zza((zzgsj) zzgshVarZzb.zzbr());
        zzgts zzgtsVarZzc = zzgtu.zzc();
        zzgtsVarZzc.zzb(zzh(zzggrVar));
        zzgtsVarZzc.zza(zzggrVar.zzc());
        zzgsbVarZza.zzb((zzgtu) zzgtsVarZzc.zzbr());
        zzgudVarZza.zzc(((zzgsd) zzgsbVarZza.zzbr()).zzaN());
        zzgudVarZza.zza(zzi(zzggrVar.zzh()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzggo zzf(zzgto zzgtoVar) throws GeneralSecurityException {
        int iOrdinal = zzgtoVar.ordinal();
        if (iOrdinal == 1) {
            return zzggo.zza;
        }
        if (iOrdinal == 2) {
            return zzggo.zzd;
        }
        if (iOrdinal == 3) {
            return zzggo.zzc;
        }
        if (iOrdinal == 4) {
            return zzggo.zze;
        }
        if (iOrdinal == 5) {
            return zzggo.zzb;
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgtoVar.zza(), "Unable to parse HashType: "));
    }

    private static zzggp zzg(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzggp.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzggp.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzggp.zzb;
    }

    private static zzgtx zzh(zzggr zzggrVar) throws GeneralSecurityException {
        zzgto zzgtoVar;
        zzgtv zzgtvVarZzc = zzgtx.zzc();
        zzgtvVarZzc.zzb(zzggrVar.zze());
        zzggo zzggoVarZzg = zzggrVar.zzg();
        if (zzggo.zza.equals(zzggoVarZzg)) {
            zzgtoVar = zzgto.SHA1;
        } else if (zzggo.zzb.equals(zzggoVarZzg)) {
            zzgtoVar = zzgto.SHA224;
        } else if (zzggo.zzc.equals(zzggoVarZzg)) {
            zzgtoVar = zzgto.SHA256;
        } else if (zzggo.zzd.equals(zzggoVarZzg)) {
            zzgtoVar = zzgto.SHA384;
        } else {
            if (!zzggo.zze.equals(zzggoVarZzg)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzggoVarZzg)));
            }
            zzgtoVar = zzgto.SHA512;
        }
        zzgtvVarZzc.zza(zzgtoVar);
        return (zzgtx) zzgtvVarZzc.zzbr();
    }

    private static zzgvf zzi(zzggp zzggpVar) throws GeneralSecurityException {
        if (zzggp.zza.equals(zzggpVar)) {
            return zzgvf.TINK;
        }
        if (zzggp.zzb.equals(zzggpVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzggp.zzc.equals(zzggpVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggpVar)));
    }
}
