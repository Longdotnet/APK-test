package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
final class zzgmb extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }

    public static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzgwm.zza.zza(yzwzcWHcnH.UFMYENhpxv);
            if (zzgks.zzb(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
