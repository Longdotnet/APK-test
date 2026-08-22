package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrn implements zzgfl {
    private zzgrn(zzgfl zzgflVar, zzgvf zzgvfVar, byte[] bArr) {
    }

    public static zzgfl zza(zzgnd zzgndVar) throws GeneralSecurityException {
        byte[] bArrZzd;
        zzgox zzgoxVarZzb = zzgndVar.zzb(zzgey.zza());
        zzgfl zzgflVar = (zzgfl) zzgmp.zzc().zza(zzgoxVarZzb.zzg(), zzgfl.class).zzc(zzgoxVarZzb.zze());
        zzgvf zzgvfVarZzc = zzgoxVarZzb.zzc();
        int iOrdinal = zzgvfVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrZzd = zzgnz.zzb(zzgndVar.zzd().intValue()).zzd();
        } else if (iOrdinal == 2) {
            bArrZzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrZzd = zzgnz.zza(zzgndVar.zzd().intValue()).zzd();
        } else {
            bArrZzd = zzgnz.zza.zzd();
        }
        return new zzgrn(zzgflVar, zzgvfVarZzc, bArrZzd);
    }
}
