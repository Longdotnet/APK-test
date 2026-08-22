package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrh implements zzgpv {
    public zzgrh(zzgqb zzgqbVar) throws GeneralSecurityException {
        if (!zzgmg.zza(2)) {
            throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
    }
}
