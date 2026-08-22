package com.google.android.gms.internal.ads;

import java.security.KeyPairGenerator;
import java.security.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class zzgwq implements zzgwu {
    @Override // com.google.android.gms.internal.ads.zzgwu
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
