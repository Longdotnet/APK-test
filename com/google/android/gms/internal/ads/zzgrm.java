package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrm {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgml zzc;
    private static final zzgml zzd;
    private static final zzgoh zze;
    private static final zzgod zzf;
    private static final zzgmx zzg;
    private static final zzgmt zzh;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzgxeVarZzb;
        zzgmj zzgmjVarZza = zzgml.zza();
        zzgmjVarZza.zza(zzgvf.RAW, zzgqj.zzd);
        zzgmjVarZza.zza(zzgvf.TINK, zzgqj.zza);
        zzgmjVarZza.zza(zzgvf.LEGACY, zzgqj.zzc);
        zzgmjVarZza.zza(zzgvf.CRUNCHY, zzgqj.zzb);
        zzc = zzgmjVarZza.zzb();
        zzgmj zzgmjVarZza2 = zzgml.zza();
        zzgmjVarZza2.zza(zzgto.SHA1, zzgqi.zza);
        zzgmjVarZza2.zza(zzgto.SHA224, zzgqi.zzb);
        zzgmjVarZza2.zza(zzgto.SHA256, zzgqi.zzc);
        zzgmjVarZza2.zza(zzgto.SHA384, zzgqi.zzd);
        zzgmjVarZza2.zza(zzgto.SHA512, zzgqi.zze);
        zzd = zzgmjVarZza2.zzb();
        zze = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgri
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgrm.zzb((zzgql) zzgfmVar);
            }
        }, zzgql.class, zzgoy.class);
        zzf = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgrj
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgrm.zzd((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zzg = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgrk
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgrm.zza((zzgqb) zzgezVar, zzgfnVar);
            }
        }, zzgqb.class, zzgox.class);
        zzh = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgrl
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgrm.zzc((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgqb zzgqbVar, zzgfn zzgfnVar) {
        zzgtp zzgtpVarZzb = zzgtr.zzb();
        zzgtpVarZzb.zzb(zzf(zzgqbVar.zzc()));
        byte[] bArrZzd = zzgqbVar.zze().zzd(zzgfnVar);
        zzgtpVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgtr) zzgtpVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, (zzgvf) zzc.zzb(zzgqbVar.zzc().zzg()), zzgqbVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgql zzgqlVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzgts zzgtsVarZzc = zzgtu.zzc();
        zzgtsVarZzc.zzb(zzf(zzgqlVar));
        zzgtsVarZzc.zza(zzgqlVar.zzc());
        zzgudVarZza.zzc(((zzgtu) zzgtsVarZzc.zzbr()).zzaN());
        zzgudVarZza.zza((zzgvf) zzc.zzb(zzgqlVar.zzg()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static /* synthetic */ zzgqb zzc(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgtr zzgtrVarZzf = zzgtr.zzf(zzgoxVar.zze(), zzgyr.zza());
            if (zzgtrVarZzf.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgqh zzgqhVarZze = zzgql.zze();
            zzgqhVarZze.zzb(zzgtrVarZzf.zzh().zzd());
            zzgqhVarZze.zzc(zzgtrVarZzf.zzg().zza());
            zzgqhVarZze.zza((zzgqi) zzd.zzc(zzgtrVarZzf.zzg().zzb()));
            zzgqhVarZze.zzd((zzgqj) zzc.zzc(zzgoxVar.zzc()));
            zzgql zzgqlVarZze = zzgqhVarZze.zze();
            zzgpz zzgpzVarZzb = zzgqb.zzb();
            zzgpzVarZzb.zzc(zzgqlVarZze);
            zzgpzVarZzb.zzb(zzgxf.zzb(zzgtrVarZzf.zzh().zzA(), zzgfnVar));
            zzgpzVarZzb.zza(zzgoxVar.zzf());
            return zzgpzVarZzb.zzd();
        } catch (zzgzw | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgql zzd(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgtu zzgtuVarZzg = zzgtu.zzg(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzgtuVarZzg.zzb() != 0) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgtuVarZzg.zzb(), "Parsing HmacParameters failed: unknown Version "));
            }
            zzgqh zzgqhVarZze = zzgql.zze();
            zzgqhVarZze.zzb(zzgtuVarZzg.zza());
            zzgqhVarZze.zzc(zzgtuVarZzg.zzh().zza());
            zzgqhVarZze.zza((zzgqi) zzd.zzc(zzgtuVarZzg.zzh().zzb()));
            zzgqhVarZze.zzd((zzgqj) zzc.zzc(zzgoyVar.zzc().zzg()));
            return zzgqhVarZze.zze();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zze);
        zzgnyVar.zzh(zzf);
        zzgnyVar.zzg(zzg);
        zzgnyVar.zzf(zzh);
    }

    private static zzgtx zzf(zzgql zzgqlVar) {
        zzgtv zzgtvVarZzc = zzgtx.zzc();
        zzgtvVarZzc.zzb(zzgqlVar.zzb());
        zzgtvVarZzc.zza((zzgto) zzd.zzb(zzgqlVar.zzf()));
        return (zzgtx) zzgtvVarZzc.zzbr();
    }
}
