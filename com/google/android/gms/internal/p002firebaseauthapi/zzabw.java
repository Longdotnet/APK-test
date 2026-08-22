package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzabw extends zzabz {
    private final int zzc;

    public zzabw(byte[] bArr, int i, int i2) {
        super(bArr);
        zzacc.zzl(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabz, com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabz, com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabz
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabz, com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabz, com.google.android.gms.internal.p002firebaseauthapi.zzacc
    public final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, 0, bArr, 0, i3);
    }
}
