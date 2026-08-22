package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes.dex */
final class zzeq implements zzet {
    private final int zza;

    public zzeq(int i) throws InvalidAlgorithmParameterException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Unsupported key length: "));
        }
        this.zza = i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzet
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzet
    public final byte[] zzb() throws GeneralSecurityException {
        int i = this.zza;
        if (i == 16) {
            return zzff.zzi;
        }
        if (i == 32) {
            return zzff.zzj;
        }
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzet
    public final byte[] zzc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws InvalidAlgorithmParameterException {
        int length = bArr.length;
        if (length == this.zza) {
            return new zzdl(bArr, false).zza(bArr2, bArr3, bArr4);
        }
        throw new InvalidAlgorithmParameterException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(length, "Unexpected key length: "));
    }
}
