package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.Provider;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes.dex */
public final class zzqe implements zzqh {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
