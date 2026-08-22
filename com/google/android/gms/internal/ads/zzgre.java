package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.firebase.inject.PVS.jIKWv;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgre {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxe zzb;
    private static final zzgoh zzc;
    private static final zzgod zzd;
    private static final zzgmx zze;
    private static final zzgmt zzf;

    static {
        zzgxe zzgxeVarZzb = zzgpj.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzgxeVarZzb;
        zzc = zzgoh.zzb(new zzgof() { // from class: com.google.android.gms.internal.ads.zzgra
            @Override // com.google.android.gms.internal.ads.zzgof
            public final zzgpb zza(zzgfm zzgfmVar) {
                return zzgre.zzb((zzgpu) zzgfmVar);
            }
        }, zzgpu.class, zzgoy.class);
        zzd = zzgod.zzb(new zzgob() { // from class: com.google.android.gms.internal.ads.zzgrb
            @Override // com.google.android.gms.internal.ads.zzgob
            public final zzgfm zza(zzgpb zzgpbVar) {
                return zzgre.zzd((zzgoy) zzgpbVar);
            }
        }, zzgxeVarZzb, zzgoy.class);
        zze = zzgmx.zzb(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzgrc
            @Override // com.google.android.gms.internal.ads.zzgmv
            public final zzgpb zza(zzgez zzgezVar, zzgfn zzgfnVar) {
                return zzgre.zza((zzgpm) zzgezVar, zzgfnVar);
            }
        }, zzgpm.class, zzgox.class);
        zzf = zzgmt.zzb(new zzgmr() { // from class: com.google.android.gms.internal.ads.zzgrd
            @Override // com.google.android.gms.internal.ads.zzgmr
            public final zzgez zza(zzgpb zzgpbVar, zzgfn zzgfnVar) {
                return zzgre.zzc((zzgox) zzgpbVar, zzgfnVar);
            }
        }, zzgxeVarZzb, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgpm zzgpmVar, zzgfn zzgfnVar) {
        zzgrp zzgrpVarZzb = zzgrr.zzb();
        zzgrpVarZzb.zzb(zzg(zzgpmVar.zzc()));
        byte[] bArrZzd = zzgpmVar.zze().zzd(zzgfnVar);
        zzgrpVarZzb.zza(zzgxz.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgrr) zzgrpVarZzb.zzbr()).zzaN(), zzgtz.SYMMETRIC, zzh(zzgpmVar.zzc().zzf()), zzgpmVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgpu zzgpuVar) {
        zzgud zzgudVarZza = zzguf.zza();
        zzgudVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgrs zzgrsVarZzb = zzgru.zzb();
        zzgrsVarZzb.zzb(zzg(zzgpuVar));
        zzgrsVarZzb.zza(zzgpuVar.zzc());
        zzgudVarZza.zzc(((zzgru) zzgrsVarZzb.zzbr()).zzaN());
        zzgudVarZza.zza(zzh(zzgpuVar.zzf()));
        return zzgoy.zzb((zzguf) zzgudVarZza.zzbr());
    }

    public static /* synthetic */ zzgpu zzd(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzi())));
        }
        try {
            zzgru zzgruVarZzd = zzgru.zzd(zzgoyVar.zzc().zzh(), zzgyr.zza());
            zzgpr zzgprVarZze = zzgpu.zze();
            zzgprVarZze.zza(zzgruVarZzd.zza());
            zzgprVarZze.zzb(zzgruVarZzd.zzf().zza());
            zzgprVarZze.zzc(zzf(zzgoyVar.zzc().zzg()));
            return zzgprVarZze.zzd();
        } catch (zzgzw e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgny zzgnyVar) {
        zzgnyVar.zzi(zzc);
        zzgnyVar.zzh(zzd);
        zzgnyVar.zzg(zze);
        zzgnyVar.zzf(zzf);
    }

    private static zzgps zzf(zzgvf zzgvfVar) throws GeneralSecurityException {
        int iOrdinal = zzgvfVar.ordinal();
        if (iOrdinal == 1) {
            return zzgps.zza;
        }
        if (iOrdinal == 2) {
            return zzgps.zzc;
        }
        if (iOrdinal == 3) {
            return zzgps.zzd;
        }
        if (iOrdinal == 4) {
            return zzgps.zzb;
        }
        throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgvfVar.zza(), "Unable to parse OutputPrefixType: "));
    }

    private static zzgrx zzg(zzgpu zzgpuVar) {
        zzgrv zzgrvVarZzb = zzgrx.zzb();
        zzgrvVarZzb.zza(zzgpuVar.zzb());
        return (zzgrx) zzgrvVarZzb.zzbr();
    }

    private static zzgvf zzh(zzgps zzgpsVar) throws GeneralSecurityException {
        if (zzgps.zza.equals(zzgpsVar)) {
            return zzgvf.TINK;
        }
        if (zzgps.zzb.equals(zzgpsVar)) {
            return zzgvf.CRUNCHY;
        }
        if (zzgps.zzd.equals(zzgpsVar)) {
            return zzgvf.RAW;
        }
        if (zzgps.zzc.equals(zzgpsVar)) {
            return zzgvf.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzgpsVar)));
    }

    public static /* synthetic */ zzgpm zzc(zzgox zzgoxVar, zzgfn zzgfnVar) throws GeneralSecurityException {
        if (zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzgrr zzgrrVarZzd = zzgrr.zzd(zzgoxVar.zze(), zzgyr.zza());
                if (zzgrrVarZzd.zza() == 0) {
                    zzgpr zzgprVarZze = zzgpu.zze();
                    zzgprVarZze.zza(zzgrrVarZzd.zzg().zzd());
                    zzgprVarZze.zzb(zzgrrVarZzd.zzf().zza());
                    zzgprVarZze.zzc(zzf(zzgoxVar.zzc()));
                    zzgpu zzgpuVarZzd = zzgprVarZze.zzd();
                    zzgpk zzgpkVarZzb = zzgpm.zzb();
                    zzgpkVarZzb.zzc(zzgpuVarZzd);
                    zzgpkVarZzb.zza(zzgxf.zzb(zzgrrVarZzd.zzg().zzA(), zzgfnVar));
                    zzgpkVarZzb.zzb(zzgoxVar.zzf());
                    return zzgpkVarZzb.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzgzw | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        }
        throw new IllegalArgumentException(jIKWv.ePhQAPrIAL);
    }
}
