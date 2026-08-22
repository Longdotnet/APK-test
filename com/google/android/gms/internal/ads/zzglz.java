package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzglz {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzglv
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzglz.zzd((zzgka) zzgfmVar);
            }
        }, zzgka.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglw
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzglz.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglx
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzglz.zzc((zzgju) zzgezVar, zzgfnVar);
            }
        }, zzgju.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgly
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzglz.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgju zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgvu zzgvuVarZzd = zzgvu.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgvuVarZzd.zza() == 0) {
                return zzgju.zzc(zzf(zzgoxVar.zzc()), zzgxf.zzb(zzgvuVarZzd.zzf().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgka zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            if (zzgvx.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza()).zza() == 0) {
                return zzgka.zzc(zzf(zzgoyVar.zzc().zzg()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgju zzgjuVar, zzgfn zzgfnVar) {
        zzgvs zzgvsVarZzb = zzgvu.zzb();
        byte[] bArrZzd = zzgjuVar.zze().zzd(zzgfnVar);
        zzgvsVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgvu) zzgvsVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzgjuVar.zzd().zzb()), zzgjuVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgka zzgkaVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzgudVarZza.zzc(zzgvx.zzc().zzaN());
        zzgudVarZza.zza(zzg(zzgkaVar.zzb()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgjz zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzgjz.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgjz.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzgjz.zzb;
    }

    private static zzgvf zzg(zzgjz zzgjzVar) throws GeneralSecurityException {
        if (zzgjz.zza.equals(zzgjzVar)) {
            return zzgvf.TINK;
        }
        if (zzgjz.zzb.equals(zzgjzVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgjz.zzc.equals(zzgjzVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgjzVar.toString()));
    }
}
