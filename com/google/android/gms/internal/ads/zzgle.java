package com.google.android.gms.internal.ads;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgle {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgla
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgle.zzd((zzgid) zzgfmVar);
            }
        }, zzgid.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzglb
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgle.zzb((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzglc
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgle.zzc((zzghy) zzgezVar, zzgfnVar);
            }
        }, zzghy.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgld
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgle.zza((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzghy zza(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgtk zzgtkVarZzd = zzgtk.zzd(zzgoxVar.zze(), zzgyr.zza());
            if (zzgtkVarZzd.zza() == 0) {
                return zzghy.zzc(zzf(zzgoxVar.zzc()), zzgxf.zzb(zzgtkVarZzd.zzf().zzA(), zzgfnVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzgzw unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgid zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgtn.zzc(zzgoyVar.zzc().zzh(), zzgyr.zza());
            return zzgid.zzc(zzf(zzgoyVar.zzc().zzg()));
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzghy zzghyVar, zzgfn zzgfnVar) {
        zzgti zzgtiVarZzb = zzgtk.zzb();
        byte[] bArrZzd = zzghyVar.zze().zzd(zzgfnVar);
        zzgtiVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzgtk) zzgtiVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzg(zzghyVar.zzd().zzb()), zzghyVar.zzf());
    }

    public static /* synthetic */ zzgoy zzd(zzgid zzgidVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzgudVarZza.zzc(zzgtn.zzb().zzaN());
        zzgudVarZza.zza(zzg(zzgidVar.zzb()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgic zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzgic.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgic.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
            }
        }
        return zzgic.zzb;
    }

    private static zzgvf zzg(zzgic zzgicVar) throws GeneralSecurityException {
        if (zzgic.zza.equals(zzgicVar)) {
            return zzgvf.TINK;
        }
        if (zzgic.zzb.equals(zzgicVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgic.zzc.equals(zzgicVar)) {
            return zzgvf.RAW;
        }
        throw new GeneralSecurityException(CyjpdoedCdLTIO.AItOT.concat(zzgicVar.toString()));
    }
}
