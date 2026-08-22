package okio.internal;

import kotlin.jvm.internal.Intrinsics;
import okio.SegmentedByteString;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteStringKt {
    public static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final int access$decodeHexDigit(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:? A[RETURN, SYNTHETIC] */
    public static final int segment(SegmentedByteString segment, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(segment, "$this$segment");
        int i3 = i + 1;
        int length = segment.segments.length;
        int[] binarySearch = segment.directory;
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        int i4 = length - 1;
        int i5 = 0;
        while (i5 <= i4) {
            i2 = (i5 + i4) >>> 1;
            int i6 = binarySearch[i2];
            if (i6 < i3) {
                i5 = i2 + 1;
            } else {
                if (i6 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                i4 = i2 - 1;
            }
        }
        i2 = (-i5) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }
}
