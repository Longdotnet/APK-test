package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.Provider;
import java.security.Signature;

/* JADX INFO: loaded from: classes.dex */
public final class zzqg implements zzqh {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
