package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;

/* JADX INFO: loaded from: classes2.dex */
final class zzfya {
    public static int zza(int i) {
        return (i + 1) * (i < 32 ? 4 : 2);
    }

    public static int zzb(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int iZzb = zzfyi.zzb(obj);
        int i2 = iZzb & i;
        int iZzc = zzc(obj3, i2);
        if (iZzc != 0) {
            int i3 = ~i;
            int i4 = iZzb & i3;
            int i5 = -1;
            while (true) {
                int i6 = iZzc - 1;
                int i7 = iArr[i6];
                int i8 = i7 & i;
                if ((i7 & i3) != i4 || !zzfvm.zza(obj, objArr[i6]) || (objArr2 != null && !zzfvm.zza(obj2, objArr2[i6]))) {
                    if (i8 == 0) {
                        break;
                    }
                    i5 = i6;
                    iZzc = i8;
                } else {
                    if (i5 == -1) {
                        zze(obj3, i2, i8);
                    } else {
                        iArr[i5] = (iArr[i5] & i3) | (i8 & i);
                    }
                    return i6;
                }
            }
        }
        return -1;
    }

    public static int zzc(Object obj, int i) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i] & 255;
        }
        return obj instanceof short[] ? (char) ((short[]) obj)[i] : ((int[]) obj)[i];
    }

    public static Object zzd(int i) {
        if (i < 2 || i > 1073741824 || Integer.highestOneBit(i) != i) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, QTaELkFI.CFNTXwptS));
        }
        if (i <= 256) {
            return new byte[i];
        }
        return i <= 65536 ? new short[i] : new int[i];
    }

    public static void zze(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }
}
