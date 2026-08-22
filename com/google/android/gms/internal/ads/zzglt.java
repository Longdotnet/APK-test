package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzglt {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzglp
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzglt.zzd((zzgjt) zzgfmVar);
            }
        }, zzgjt.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglq
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzglt.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglr
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzglt.zzc((zzgjo) zzgezVar, zzgfnVar);
            }
        }, zzgjo.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgls
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzglt.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgjo zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseKey");
        }
        try {
            zzgvl zzgvlVarZzd = zzgvl.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgvlVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzgvlVarZzd.zzg().zzd() == 32) {
                return zzgjo.zzc(zzgjt.zzd(zzf(zzgoxVar.zzc()), zzgvlVarZzd.zzf().zza()), zzgxf.zzb(zzgvlVarZzd.zzg().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only 32 byte key size is accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing XAesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgjt zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XAesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to XAesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgvo zzgvoVarZzd = zzgvo.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            if (zzgvoVarZzd.zza() == 0) {
                return zzgjt.zzd(zzf(zzgoyVar.zzc().zzg()), zzgvoVarZzd.zzf().zza());
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing XAesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgjo zzgjoVar, zzgfn zzgfnVar) {
        zzgvj zzgvjVarZzb = zzgvl.zzb();
        byte[] bArrZzd = zzgjoVar.zze().zzd(zzgfnVar);
        zzgvjVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        zzgvp zzgvpVarZzb = zzgvr.zzb();
        zzgvpVarZzb.zza(zzgjoVar.zzd().zzb());
        zzgvjVarZzb.zzb((zzgvr) zzgvpVarZzb.zzbr());
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzgvl) zzgvjVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzgjoVar.zzd().zzc()), zzgjoVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgjt zzgjtVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        zzgvm zzgvmVarZzb = zzgvo.zzb();
        zzgvp zzgvpVarZzb = zzgvr.zzb();
        zzgvpVarZzb.zza(zzgjtVar.zzb());
        zzgvmVarZzb.zza((zzgvr) zzgvpVarZzb.zzbr());
        zzgudVarZza.zzc(((zzgvo) zzgvmVarZzb.zzbr()).zzaN());
        zzgudVarZza.zza(zzg(zzgjtVar.zzc()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgjs zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzgjs.zza;
        }
        if (iOrdinal == 3) {
            return zzgjs.zzb;
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    private static zzgvf zzg(zzgjs zzgjsVar) throws GeneralSecurityException {
        if (Objects.equals(zzgjsVar, zzgjs.zza)) {
            return zzgvf.TINK;
        }
        if (Objects.equals(zzgjsVar, zzgjs.zzb)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgjsVar.toString()));
    }
}
