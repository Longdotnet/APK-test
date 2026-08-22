package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes.dex */
final class zzgky extends ThreadLocal {
    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwm.zza.zza("ChaCha20-Poly1305");
            if (zzgkz.zzf(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
