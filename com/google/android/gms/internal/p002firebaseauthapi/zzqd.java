package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.KeyPairGenerator;
import java.security.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class zzqd implements zzqh {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
