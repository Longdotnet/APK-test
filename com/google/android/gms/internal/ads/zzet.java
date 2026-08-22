package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzet {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzet() {
        throw null;
    }

    private final Object zzf() {
        zzdd.zzf(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i = this.zzc;
        Object obj = objArr[i];
        objArr[i] = null;
        this.zzc = (i + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized int zza() {
        return this.zzd;
    }

    public final synchronized Object zzb() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    public final synchronized Object zzc(long j) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }

    public final synchronized void zzd(long j, Object obj) {
        try {
            int i = this.zzd;
            if (i > 0) {
                if (j <= this.zza[((this.zzc + i) - 1) % this.zzb.length]) {
                    zze();
                }
            }
            int length = this.zzb.length;
            if (this.zzd >= length) {
                int i2 = length + length;
                long[] jArr = new long[i2];
                Object[] objArr = new Object[i2];
                int i3 = this.zzc;
                int i4 = length - i3;
                System.arraycopy(this.zza, i3, jArr, 0, i4);
                System.arraycopy(this.zzb, this.zzc, objArr, 0, i4);
                int i5 = this.zzc;
                if (i5 > 0) {
                    System.arraycopy(this.zza, 0, jArr, i4, i5);
                    System.arraycopy(this.zzb, 0, objArr, i4, this.zzc);
                }
                this.zza = jArr;
                this.zzb = objArr;
                this.zzc = 0;
            }
            int i6 = this.zzc;
            int i7 = this.zzd;
            Object[] objArr2 = this.zzb;
            int length2 = (i6 + i7) % objArr2.length;
            this.zza[length2] = j;
            objArr2[length2] = obj;
            this.zzd = i7 + 1;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zze() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }

    public zzet(int i) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }
}
