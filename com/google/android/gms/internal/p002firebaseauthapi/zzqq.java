package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public final class zzqq {
    private static final ThreadLocal zza = new zzqp();

    public static byte[] zza(int i) {
        byte[] bArr = new byte[i];
        ((SecureRandom) zza.get()).nextBytes(bArr);
        return bArr;
    }
}
