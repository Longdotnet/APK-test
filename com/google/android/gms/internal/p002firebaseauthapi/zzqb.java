package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.Provider;
import javax.crypto.KeyAgreement;

/* JADX INFO: loaded from: classes.dex */
public final class zzqb implements zzqh {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
    public final /* bridge */ /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
