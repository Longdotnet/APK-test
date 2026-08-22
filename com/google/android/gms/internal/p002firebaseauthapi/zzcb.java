package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
final class zzcb {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzok zza(zzof zzofVar) {
        zzoh zzohVarZza = zzok.zza();
        zzohVarZza.zzb(zzofVar.zzb());
        for (zzoe zzoeVar : zzofVar.zzg()) {
            zzoi zzoiVarZzb = zzoj.zzb();
            zzoiVarZzb.zzc(zzoeVar.zzb().zzf());
            zzoiVarZzb.zzd(zzoeVar.zzk());
            zzoiVarZzb.zzb(zzoeVar.zze());
            zzoiVarZzb.zza(zzoeVar.zza());
            zzohVarZza.zza((zzoj) zzoiVarZzb.zzi());
        }
        return (zzok) zzohVarZza.zzi();
    }

    public static void zzb(zzof zzofVar) {
        int iZzb = zzofVar.zzb();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzoe zzoeVar : zzofVar.zzg()) {
            if (zzoeVar.zzk() == 3) {
                if (!zzoeVar.zzi()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzoeVar.zza())));
                }
                if (zzoeVar.zze() == zzoy.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzoeVar.zza())));
                }
                if (zzoeVar.zzk() == 2) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzoeVar.zza())));
                }
                if (zzoeVar.zza() == iZzb) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                z2 &= zzoeVar.zzb().zzb() == zznr.ASYMMETRIC_PUBLIC;
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
