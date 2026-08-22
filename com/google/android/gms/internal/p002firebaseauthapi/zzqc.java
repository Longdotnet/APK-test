package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.KeyFactory;
import java.security.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class zzqc implements zzqh {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
