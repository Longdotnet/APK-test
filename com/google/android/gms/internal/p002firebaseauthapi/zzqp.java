package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
final class zzqp extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final /* synthetic */ Object initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
