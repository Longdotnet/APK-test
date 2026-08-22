package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgqm {
    static {
        int i = zzgvi.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgqt.zzc();
        zzgpy.zzc();
        zzgqg.zza(true);
        if (zzgmh.zzb()) {
            return;
        }
        zzgpq.zzd(true);
    }
}
