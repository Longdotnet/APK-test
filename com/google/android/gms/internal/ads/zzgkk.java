package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgkk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgkg
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgkk.zzd((zzghb) zzgfmVar);
            }
        }, zzghb.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgkh
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgkk.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgki
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgkk.zzc((zzggu) zzgezVar, zzgfnVar);
            }
        }, zzggu.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgkj
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgkk.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzggu zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgsp zzgspVarZzd = zzgsp.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgspVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzggy zzggyVarZzd = zzghb.zzd();
            zzggyVarZzd.zzb(zzgspVarZzd.zzg().zzd());
            zzggyVarZzd.zza(zzgspVarZzd.zzf().zza());
            zzggyVarZzd.zzc(16);
            zzggyVarZzd.zzd(zzf(zzgoxVar.zzc()));
            zzghb zzghbVarZze = zzggyVarZzd.zze();
            zzggs zzggsVarZzc = zzggu.zzc();
            zzggsVarZzc.zzc(zzghbVarZze);
            zzggsVarZzc.zzb(zzgxf.zzb(zzgspVarZzd.zzg().zzA(), zzgfnVar));
            zzggsVarZzc.zza(zzgoxVar.zzf());
            return zzggsVarZzc.zzd();
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzghb zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgss zzgssVarZzd = zzgss.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            zzggy zzggyVarZzd = zzghb.zzd();
            zzggyVarZzd.zzb(zzgssVarZzd.zza());
            zzggyVarZzd.zza(zzgssVarZzd.zzf().zza());
            zzggyVarZzd.zzc(16);
            zzggyVarZzd.zzd(zzf(zzgoyVar.zzc().zzg()));
            return zzggyVarZzd.zze();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzggu zzgguVar, zzgfn zzgfnVar) {
        zzgsn zzgsnVarZzb = zzgsp.zzb();
        zzgsnVarZzb.zzb(zzg(zzgguVar.zzd()));
        byte[] bArrZzd = zzgguVar.zze().zzd(zzgfnVar);
        zzgsnVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgsp) zzgsnVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzh(zzgguVar.zzd().zze()), zzgguVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzghb zzghbVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgsq zzgsqVarZzb = zzgss.zzb();
        zzgsqVarZzb.zzb(zzg(zzghbVar));
        zzgsqVarZzb.zza(zzghbVar.zzc());
        zzgudVarZza.zzc(((zzgss) zzgsqVarZzb.zzbr()).zzaN());
        zzgudVarZza.zza(zzh(zzghbVar.zze()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzggz zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzggz.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzggz.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzggz.zzb;
    }

    private static zzgsv zzg(zzghb zzghbVar) {
        zzgst zzgstVarZzb = zzgsv.zzb();
        zzgstVarZzb.zza(zzghbVar.zzb());
        return (zzgsv) zzgstVarZzb.zzbr();
    }

    private static zzgvf zzh(zzggz zzggzVar) throws GeneralSecurityException {
        if (zzggz.zza.equals(zzggzVar)) {
            return zzgvf.TINK;
        }
        if (zzggz.zzb.equals(zzggzVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzggz.zzc.equals(zzggzVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzggzVar)));
    }
}
