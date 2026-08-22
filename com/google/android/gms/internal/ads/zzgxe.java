package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzgxe {
    private final byte[] zza;

    private zzgxe(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.zza = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i2);
    }

    public static zzgxe zzb(byte[] bArr) {
        if (bArr != null) {
            return zzc(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    public static zzgxe zzc(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("data must be non-null");
        }
        int length = bArr.length;
        if (i2 > length) {
            i2 = length;
        }
        return new zzgxe(bArr, 0, i2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgxe) {
            return Arrays.equals(((zzgxe) obj).zza, this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArr) {
            sb.append("0123456789abcdef".charAt((b & 255) >> 4));
            sb.append("0123456789abcdef".charAt(b & 15));
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Bytes(", sb.toString(), ")");
    }

    public final int zza() {
        return this.zza.length;
    }

    public final byte[] zzd() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
