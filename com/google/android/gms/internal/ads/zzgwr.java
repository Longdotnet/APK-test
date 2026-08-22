package com.google.android.gms.internal.ads;

import java.security.Provider;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class zzgwr implements zzgwu {
    @Override // com.google.android.gms.internal.ads.zzgwu
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
