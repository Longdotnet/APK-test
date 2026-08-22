package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class zzgwp implements zzgwu {
    @Override // com.google.android.gms.internal.ads.zzgwu
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
