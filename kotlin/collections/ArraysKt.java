package kotlin.collections;

import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Okio;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ArraysKt extends AsyncTimeout.Companion {
    public static List asList(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        Intrinsics.checkNotNullExpressionValue(listAsList, "asList(this)");
        return listAsList;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        int i;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (obj == null) {
            int length = objArr.length;
            i = 0;
            while (i < length) {
                if (objArr[i] != null) {
                    i++;
                }
            }
            i = -1;
        } else {
            int length2 = objArr.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (obj.equals(objArr[i2])) {
                    i = i2;
                }
            }
            i = -1;
        }
        return i >= 0;
    }

    public static final void copyInto(Object[] objArr, int i, Object[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(objArr, i2, destination, i, i3 - i2);
    }

    public static void fill(Object[] objArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Arrays.fill(objArr, i, i2, (Object) null);
    }

    public static ArrayList filterNotNull(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final void toCollection(Object[] objArr, HashSet hashSet) {
        for (Object obj : objArr) {
            hashSet.add(obj);
        }
    }

    public static List toList(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? new ArrayList(new ArrayAsCollection(objArr, false)) : Okio.listOf(objArr[0]);
        }
        return EmptyList.INSTANCE;
    }

    public static void copyInto(byte[] bArr, int i, byte[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(bArr, i2, destination, i, i3 - i2);
    }

    public static byte[] copyOfRange(int i, byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, eoBKjVuj.yNmSqEkCwDawjGw);
        int length = bArr.length;
        if (i2 <= length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            return bArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is greater than size (" + length + ").");
    }
}
