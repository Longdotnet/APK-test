package okio;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes3.dex */
public final class SegmentedByteString extends ByteString {
    public final transient int[] directory;
    public final transient byte[][] segments;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.data);
        this.segments = bArr;
        this.directory = iArr;
    }

    private final Object writeReplace() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.getSize$okio() == getSize$okio() && rangeEquals(byteString, getSize$okio())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int getSize$okio() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.segments;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public final String hex() {
        return new ByteString(toByteArray()).hex();
    }

    @Override // okio.ByteString
    public final byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final byte internalGet$okio(int i) {
        byte[][] bArr = this.segments;
        int length = bArr.length - 1;
        int[] iArr = this.directory;
        StringsKt__IndentKt.checkOffsetAndCount(iArr[length], i, 1L);
        int iSegment = ByteStringKt.segment(this, i);
        return bArr[iSegment][(i - (iSegment == 0 ? 0 : iArr[iSegment - 1])) + iArr[bArr.length + iSegment]];
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > getSize$okio() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = ByteStringKt.segment(this, i);
        while (i < i4) {
            int[] iArr = this.directory;
            int i5 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i6 = iArr[iSegment] - i5;
            byte[][] bArr = this.segments;
            int i7 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!StringsKt__IndentKt.arrayRangeEquals(bArr[iSegment], (i - i5) + i7, other, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return new ByteString(toByteArray()).toAsciiLowercase();
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[getSize$okio()];
        byte[][] bArr2 = this.segments;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(bArr2[i], i3, bArr, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return new ByteString(toByteArray()).toString();
    }

    @Override // okio.ByteString
    public final void write$okio(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iSegment = ByteStringKt.segment(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.directory;
            int i3 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i4 = iArr[iSegment] - i3;
            byte[][] bArr = this.segments;
            int i5 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            Segment segment = new Segment(bArr[iSegment], i6, i6 + iMin, true);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(segment);
            }
            i2 += iMin;
            iSegment++;
        }
        buffer.size += (long) getSize$okio();
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(ByteString other, int i) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (getSize$okio() - i < 0) {
            return false;
        }
        int iSegment = ByteStringKt.segment(this, 0);
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            int[] iArr = this.directory;
            int i4 = iSegment == 0 ? 0 : iArr[iSegment - 1];
            int i5 = iArr[iSegment] - i4;
            byte[][] bArr = this.segments;
            int i6 = iArr[bArr.length + iSegment];
            int iMin = Math.min(i, i5 + i4) - i2;
            if (!other.rangeEquals(i3, bArr[iSegment], (i2 - i4) + i6, iMin)) {
                return false;
            }
            i3 += iMin;
            i2 += iMin;
            iSegment++;
        }
        return true;
    }
}
