package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzeb {
    private int zza;
    private long[] zzb;

    public zzeb() {
        throw null;
    }

    public final int zza() {
        return this.zza;
    }

    public final long zzb(int i) {
        if (i < 0 || i >= this.zza) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, this.zza, "Invalid index ", ", size is "));
        }
        return this.zzb[i];
    }

    public final void zzc(long j) {
        int i = this.zza;
        long[] jArr = this.zzb;
        if (i == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i + i);
        }
        long[] jArr2 = this.zzb;
        int i2 = this.zza;
        this.zza = i2 + 1;
        jArr2[i2] = j;
    }

    public final void zzd(long[] jArr) {
        int i = this.zza;
        int length = jArr.length;
        int i2 = i + length;
        long[] jArr2 = this.zzb;
        int length2 = jArr2.length;
        if (i2 > length2) {
            this.zzb = Arrays.copyOf(jArr2, Math.max(length2 + length2, i2));
        }
        System.arraycopy(jArr, 0, this.zzb, this.zza, length);
        this.zza = i2;
    }

    public zzeb(int i) {
        this.zzb = new long[i];
    }
}
