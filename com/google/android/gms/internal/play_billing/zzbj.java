package com.google.android.gms.internal.play_billing;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzbj extends zzbn {
    private final int zzc;

    public zzbj(byte[] bArr, int i, int i2) {
        super(bArr);
        zzbq.zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
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

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbn, com.google.android.gms.internal.play_billing.zzbq
    public final int zzd() {
        return this.zzc;
    }
}
