package okio.internal;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.Options;
import okio.Segment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BufferKt {
    public static final byte[] HEX_DIGIT_BYTES;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        HEX_DIGIT_BYTES = bytes;
    }

    public static final String readUtf8Line(Buffer readUtf8Line, long j) throws EOFException {
        Intrinsics.checkNotNullParameter(readUtf8Line, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (readUtf8Line.getByte(j2) == ((byte) 13)) {
                String string = readUtf8Line.readString(j2, Charsets.UTF_8);
                readUtf8Line.skip(2L);
                return string;
            }
        }
        String string2 = readUtf8Line.readString(j, Charsets.UTF_8);
        readUtf8Line.skip(1L);
        return string2;
    }

    public static final int selectPrefix(Buffer selectPrefix, Options options, boolean z) {
        int i;
        int i2;
        Segment segment;
        byte[] bArr;
        int i3;
        Intrinsics.checkNotNullParameter(selectPrefix, "$this$selectPrefix");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = selectPrefix.head;
        int i4 = -2;
        if (segment2 == null) {
            return z ? -2 : -1;
        }
        int i5 = segment2.pos;
        int i6 = segment2.limit;
        byte[] bArr2 = segment2.data;
        Segment segment3 = segment2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int[] iArr = options.trie;
            int i10 = iArr[i8];
            int i11 = i8 + 2;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (segment3 == null) {
                break;
            }
            if (i10 >= 0) {
                int i13 = i5 + 1;
                int i14 = bArr2[i5] & 255;
                int i15 = i11 + i10;
                while (i11 != i15) {
                    if (i14 == iArr[i11]) {
                        i = iArr[i11 + i10];
                        if (i13 == i6) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i2 = segment3.pos;
                            i6 = segment3.limit;
                            bArr2 = segment3.data;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        } else {
                            i2 = i13;
                        }
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i16 = (i10 * (-1)) + i11;
            while (true) {
                int i17 = i5 + 1;
                int i18 = i11 + 1;
                if ((bArr2[i5] & 255) != iArr[i11]) {
                    return i7;
                }
                boolean z2 = i18 == i16;
                if (i17 == i6) {
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.next;
                    Intrinsics.checkNotNull(segment4);
                    i3 = segment4.pos;
                    int i19 = segment4.limit;
                    bArr = segment4.data;
                    if (segment4 != segment2) {
                        segment = segment4;
                        i6 = i19;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        i6 = i19;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    bArr = bArr2;
                    i3 = i17;
                }
                if (z2) {
                    i = iArr[i18];
                    i2 = i3;
                    bArr2 = bArr;
                    segment3 = segment;
                    break;
                }
                i5 = i3;
                bArr2 = bArr;
                segment3 = segment;
                i11 = i18;
            }
            if (i >= 0) {
                return i;
            }
            i8 = -i;
            i5 = i2;
            i4 = -2;
        }
        return z ? i4 : i7;
    }
}
