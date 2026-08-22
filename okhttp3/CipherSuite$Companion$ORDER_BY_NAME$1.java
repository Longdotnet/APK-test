package okhttp3;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String a = (String) obj;
        String b = (String) obj2;
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        int iMin = Math.min(a.length(), b.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = a.charAt(i);
            char cCharAt2 = b.charAt(i);
            if (cCharAt != cCharAt2) {
                if (Intrinsics.compare(cCharAt, cCharAt2) >= 0) {
                    return 1;
                }
                return -1;
            }
        }
        int length = a.length();
        int length2 = b.length();
        if (length == length2) {
            return 0;
        }
        if (length >= length2) {
            return 1;
        }
        return -1;
    }
}
