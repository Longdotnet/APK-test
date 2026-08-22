package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzgxz implements Iterable<Byte>, Serializable {
    public static final zzgxz zzb = new zzgxw(zzgzu.zzb);
    private int zza = 0;

    static {
        int i = zzgxm.zza;
    }

    private static zzgxz zzc(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "length (", ") must be >= 1"));
        }
        if (i == 1) {
            return (zzgxz) it.next();
        }
        int i2 = i >>> 1;
        zzgxz zzgxzVarZzc = zzc(it, i2);
        zzgxz zzgxzVarZzc2 = zzc(it, i - i2);
        if (Integer.MAX_VALUE - zzgxzVarZzc.zzd() >= zzgxzVarZzc2.zzd()) {
            return zzhbk.zzC(zzgxzVarZzc, zzgxzVarZzc2);
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzgxzVarZzc.zzd(), zzgxzVarZzc2.zzd(), "ByteString would be too long: ", "+"));
    }

    public static zzgxx zzt() {
        return new zzgxx(128);
    }

    public static zzgxz zzu(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzc(iterable.iterator(), size);
    }

    public static zzgxz zzv(byte[] bArr, int i, int i2) {
        zzq(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgxw(bArr2);
    }

    public static zzgxz zzw(String str) {
        return new zzgxw(str.getBytes(zzgzu.zza));
    }

    public static void zzy(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i >= 0) {
                throw new ArrayIndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Index < 0: "));
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzi = this.zza;
        if (iZzi == 0) {
            int iZzd = zzd();
            iZzi = zzi(iZzd, 0, iZzd);
            if (iZzi == 0) {
                iZzi = 1;
            }
            this.zza = iZzi;
        }
        return iZzi;
    }

    public final byte[] zzA() {
        int iZzd = zzd();
        if (iZzd == 0) {
            return zzgzu.zzb;
        }
        byte[] bArr = new byte[iZzd];
        zze(bArr, 0, 0, iZzd);
        return bArr;
    }

    public abstract byte zza(int i);

    public abstract byte zzb(int i);

    public abstract int zzd();

    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    public abstract int zzf();

    public abstract boolean zzh();

    public abstract int zzi(int i, int i2, int i3);

    public abstract int zzj(int i, int i2, int i3);

    public abstract zzgxz zzk(int i, int i2);

    public abstract zzgyf zzl();

    public abstract String zzm(Charset charset);

    public abstract ByteBuffer zzn();

    public abstract void zzo(zzgxq zzgxqVar);

    public abstract boolean zzp();

    public final int zzr() {
        return this.zza;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzs */
    public zzgxu iterator() {
        return new zzgxr(this);
    }

    public final String zzx() {
        return zzd() == 0 ? "" : zzm(zzgzu.zza);
    }

    @Deprecated
    public final void zzz(byte[] bArr, int i, int i2, int i3) {
        zzq(0, i3, zzd());
        zzq(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public static int zzq(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, i3, YcVWhnLsj.zYSRbSLihCcLNx, " >= "));
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int iZzd = zzd();
        String strZza = zzd() <= 50 ? zzhbv.zza(this) : zzhbv.zza(zzk(0, 47)).concat(eoBKjVuj.ZhfEXbvC);
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(iZzd);
        sb.append(" contents=\"");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, strZza, "\">");
    }
}
