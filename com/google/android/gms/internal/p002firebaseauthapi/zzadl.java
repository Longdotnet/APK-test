package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.gson.yWTz.kBfGXgdfpo;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class zzadl {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName(kBfGXgdfpo.gLlR);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzacg zzf;

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int iZzd = zzd(length, bArr, 0, length);
        if (iZzd == 0) {
            return 1;
        }
        return iZzd;
    }

    public static int zzc(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzd(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static Object zze(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object zzf(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String zzg(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzh(byte[] bArr) {
        return zzagc.zze(bArr);
    }

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zzacg.zzu(bArr, 0, 0, false);
    }
}
