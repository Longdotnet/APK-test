package com.google.android.gms.internal.ads;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
final class zzgwb extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }

    public static final Cipher zza() {
        try {
            return (Cipher) zzgwm.zza.zza(bUqMCsuPSX.xHr);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
