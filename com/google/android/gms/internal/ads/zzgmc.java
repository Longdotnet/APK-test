package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
public final class zzgmc implements zzget {
    private static final ThreadLocal zza = new zzgmb();

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzgma] */
    public static zzget zzb(zzghp zzghpVar) {
        return zzgks.zzc(zzghpVar, new Object() { // from class: com.google.android.gms.internal.ads.zzgma
        });
    }

    public static /* synthetic */ Cipher zzc() throws GeneralSecurityException {
        try {
            Cipher cipher = (Cipher) zza.get();
            if (cipher != null) {
                return cipher;
            }
            throw new GeneralSecurityException("AES GCM SIV cipher is invalid.");
        } catch (IllegalStateException e) {
            throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzget
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        throw null;
    }
}
