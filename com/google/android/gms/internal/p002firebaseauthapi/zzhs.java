package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
public final class zzhs {
    private Integer zza;
    private Integer zzb;
    private zzht zzc;

    public /* synthetic */ zzhs(zzhr zzhrVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzht.zzd;
    }

    public final zzhs zza(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i * 8)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }

    public final zzhs zzb(int i) throws GeneralSecurityException {
        if (i < 10 || i > 16) {
            throw new GeneralSecurityException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid tag size for AesCmacParameters: "));
        }
        this.zzb = Integer.valueOf(i);
        return this;
    }

    public final zzhs zzc(zzht zzhtVar) {
        this.zzc = zzhtVar;
        return this;
    }

    public final zzhv zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null || this.zzb == null) {
            throw new GeneralSecurityException("Key size and/or tag size not set");
        }
        return new zzhv(num.intValue(), this.zzb.intValue(), this.zzc, null);
    }

    private zzhs() {
        this.zza = null;
        this.zzb = null;
        throw null;
    }
}
