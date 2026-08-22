package okio;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okio.internal.BufferKt;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes3.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public Segment head;
    public long size;

    public final Object clone() {
        Buffer buffer = new Buffer();
        if (this.size != 0) {
            Segment segment = this.head;
            Intrinsics.checkNotNull(segment);
            Segment segmentSharedCopy = segment.sharedCopy();
            buffer.head = segmentSharedCopy;
            segmentSharedCopy.prev = segmentSharedCopy;
            segmentSharedCopy.next = segmentSharedCopy;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                Segment segment3 = segmentSharedCopy.prev;
                Intrinsics.checkNotNull(segment3);
                Intrinsics.checkNotNull(segment2);
                segment3.push(segment2.sharedCopy());
            }
            buffer.size = this.size;
        }
        return buffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, okio.Sink
    public final void close() {
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Buffer) {
                long j = this.size;
                Buffer buffer = (Buffer) obj;
                if (j == buffer.size) {
                    if (j != 0) {
                        Segment segment = this.head;
                        Intrinsics.checkNotNull(segment);
                        Segment segment2 = buffer.head;
                        Intrinsics.checkNotNull(segment2);
                        int i = segment.pos;
                        int i2 = segment2.pos;
                        long j2 = 0;
                        while (j2 < this.size) {
                            long jMin = Math.min(segment.limit - i, segment2.limit - i2);
                            long j3 = 0;
                            while (j3 < jMin) {
                                int i3 = i + 1;
                                byte b = segment.data[i];
                                int i4 = i2 + 1;
                                if (b == segment2.data[i2]) {
                                    j3++;
                                    i2 = i4;
                                    i = i3;
                                }
                            }
                            if (i == segment.limit) {
                                Segment segment3 = segment.next;
                                Intrinsics.checkNotNull(segment3);
                                i = segment3.pos;
                                segment = segment3;
                            }
                            if (i2 == segment2.limit) {
                                segment2 = segment2.next;
                                Intrinsics.checkNotNull(segment2);
                                i2 = segment2.pos;
                            }
                            j2 += jMin;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
    }

    public final byte getByte(long j) {
        StringsKt__IndentKt.checkOffsetAndCount(this.size, j, 1L);
        Segment segment = this.head;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        }
        long j2 = this.size;
        if (j2 - j < j) {
            while (j2 > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                j2 -= (long) (segment.limit - segment.pos);
            }
            return segment.data[(int) ((((long) segment.pos) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment.limit;
            int i2 = segment.pos;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return segment.data[(int) ((((long) i2) + j) - j3)];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j3 = j4;
        }
    }

    public final int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != this.head);
        return i;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
        }
        long j2 = this.size;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        sink.write(this, j);
        return j;
    }

    public final byte readByte() {
        if (this.size == 0) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        int i3 = i + 1;
        byte b = segment.data[i];
        this.size--;
        if (i3 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i3;
        }
        return b;
    }

    public final byte[] readByteArray(long j) throws EOFException {
        int iMin;
        if (j < 0 || j > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount: ").toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i - i2;
            StringsKt__IndentKt.checkOffsetAndCount(i, i2, i3);
            Segment segment = this.head;
            if (segment != null) {
                iMin = Math.min(i3, segment.limit - segment.pos);
                int i4 = segment.pos;
                ArraysKt.copyInto(segment.data, i2, bArr, i4, i4 + iMin);
                int i5 = segment.pos + iMin;
                segment.pos = i5;
                this.size -= (long) iMin;
                if (i5 == segment.limit) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                iMin = -1;
            }
            if (iMin == -1) {
                throw new EOFException();
            }
            i2 += iMin;
        }
        return bArr;
    }

    public final ByteString readByteString(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount: ").toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(readByteArray(j));
        }
        ByteString byteStringSnapshot = snapshot((int) j);
        skip(j);
        return byteStringSnapshot;
    }

    public final int readInt() throws EOFException {
        if (this.size < 4) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment.data;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = i4 | (bArr[i3] & 255);
        this.size -= 4;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return i6;
    }

    public final short readShort() throws EOFException {
        if (this.size < 2) {
            throw new EOFException();
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        int i2 = segment.limit;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        int i3 = i + 1;
        byte[] bArr = segment.data;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.size -= 2;
        if (i5 == i2) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        return readString(this.size, charset);
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(options, "options");
        int iSelectPrefix = BufferKt.selectPrefix(this, options, false);
        if (iSelectPrefix == -1) {
            return -1;
        }
        skip(options.byteStrings[iSelectPrefix].getSize$okio());
        return iSelectPrefix;
    }

    public final void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            long j2 = iMin;
            this.size -= j2;
            j -= j2;
            int i = segment.pos + iMin;
            segment.pos = i;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
        }
    }

    public final ByteString snapshot(int i) {
        if (i == 0) {
            return ByteString.EMPTY;
        }
        StringsKt__IndentKt.checkOffsetAndCount(this.size, 0L, i);
        Segment segment = this.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment = segment.next;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment segment2 = this.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return Timeout.NONE;
    }

    public final Segment writableSegment$okio(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException(bUqMCsuPSX.gOrV);
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment segmentTake = SegmentPool.take();
            this.head = segmentTake;
            segmentTake.prev = segmentTake;
            segmentTake.next = segmentTake;
            return segmentTake;
        }
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        if (segment2.limit + i <= 8192 && segment2.owner) {
            return segment2;
        }
        Segment segmentTake2 = SegmentPool.take();
        segment2.push(segmentTake2);
        return segmentTake2;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Segment segmentTake;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        StringsKt__IndentKt.checkOffsetAndCount(source.size, 0L, j);
        while (j > 0) {
            Segment segment = source.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            Segment segment2 = source.head;
            Intrinsics.checkNotNull(segment2);
            long j2 = i - segment2.pos;
            int i2 = 0;
            if (j < j2) {
                Segment segment3 = this.head;
                Segment segment4 = segment3 != null ? segment3.prev : null;
                if (segment4 != null && segment4.owner) {
                    if ((((long) segment4.limit) + j) - ((long) (segment4.shared ? 0 : segment4.pos)) <= 8192) {
                        Segment segment5 = source.head;
                        Intrinsics.checkNotNull(segment5);
                        segment5.writeTo(segment4, (int) j);
                        source.size -= j;
                        this.size += j;
                        return;
                    }
                }
                Segment segment6 = source.head;
                Intrinsics.checkNotNull(segment6);
                int i3 = (int) j;
                if (i3 <= 0 || i3 > segment6.limit - segment6.pos) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i3 >= 1024) {
                    segmentTake = segment6.sharedCopy();
                } else {
                    segmentTake = SegmentPool.take();
                    int i4 = segment6.pos;
                    ArraysKt.copyInto(segment6.data, 0, segmentTake.data, i4, i4 + i3);
                }
                segmentTake.limit = segmentTake.pos + i3;
                segment6.pos += i3;
                Segment segment7 = segment6.prev;
                Intrinsics.checkNotNull(segment7);
                segment7.push(segmentTake);
                source.head = segmentTake;
            }
            Segment segment8 = source.head;
            Intrinsics.checkNotNull(segment8);
            long j3 = segment8.limit - segment8.pos;
            source.head = segment8.pop();
            Segment segment9 = this.head;
            if (segment9 == null) {
                this.head = segment8;
                segment8.prev = segment8;
                segment8.next = segment8;
            } else {
                Segment segment10 = segment9.prev;
                Intrinsics.checkNotNull(segment10);
                segment10.push(segment8);
                Segment segment11 = segment8.prev;
                if (segment11 == segment8) {
                    throw new IllegalStateException("cannot compact");
                }
                Intrinsics.checkNotNull(segment11);
                if (segment11.owner) {
                    int i5 = segment8.limit - segment8.pos;
                    Segment segment12 = segment8.prev;
                    Intrinsics.checkNotNull(segment12);
                    int i6 = 8192 - segment12.limit;
                    Segment segment13 = segment8.prev;
                    Intrinsics.checkNotNull(segment13);
                    if (!segment13.shared) {
                        Segment segment14 = segment8.prev;
                        Intrinsics.checkNotNull(segment14);
                        i2 = segment14.pos;
                    }
                    if (i5 <= i6 + i2) {
                        Segment segment15 = segment8.prev;
                        Intrinsics.checkNotNull(segment15);
                        segment8.writeTo(segment15, i5);
                        segment8.pop();
                        SegmentPool.recycle(segment8);
                    }
                }
            }
            source.size -= j3;
            this.size += j3;
            j -= j3;
        }
    }

    public final void writeAll(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        while (source.read(this, 8192) != -1) {
        }
    }

    public final void writeByte(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(1);
        int i2 = segmentWritableSegment$okio.limit;
        segmentWritableSegment$okio.limit = i2 + 1;
        segmentWritableSegment$okio.data[i2] = (byte) i;
        this.size++;
    }

    public final void writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            writeByte(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment segmentWritableSegment$okio = writableSegment$okio(i);
        int i2 = segmentWritableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            segmentWritableSegment$okio.data[i3] = BufferKt.HEX_DIGIT_BYTES[(int) (15 & j)];
            j >>>= 4;
        }
        segmentWritableSegment$okio.limit += i;
        this.size += (long) i;
    }

    public final void writeInt(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(4);
        int i2 = segmentWritableSegment$okio.limit;
        byte[] bArr = segmentWritableSegment$okio.data;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 4;
        this.size += 4;
    }

    public final void writeShort(int i) {
        Segment segmentWritableSegment$okio = writableSegment$okio(2);
        int i2 = segmentWritableSegment$okio.limit;
        byte[] bArr = segmentWritableSegment$okio.data;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        segmentWritableSegment$okio.limit = i2 + 2;
        this.size += 2;
    }

    @Override // okio.BufferedSink
    public final /* bridge */ /* synthetic */ BufferedSink writeUtf8(String str) {
        m124writeUtf8(str);
        return this;
    }

    public final void writeUtf8CodePoint(int i) {
        String str;
        int i2 = 0;
        if (i < 128) {
            writeByte(i);
            return;
        }
        if (i < 2048) {
            Segment segmentWritableSegment$okio = writableSegment$okio(2);
            int i3 = segmentWritableSegment$okio.limit;
            byte[] bArr = segmentWritableSegment$okio.data;
            bArr[i3] = (byte) ((i >> 6) | 192);
            bArr[1 + i3] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio.limit = i3 + 2;
            this.size += 2;
            return;
        }
        if (55296 <= i && 57343 >= i) {
            writeByte(63);
            return;
        }
        if (i < 65536) {
            Segment segmentWritableSegment$okio2 = writableSegment$okio(3);
            int i4 = segmentWritableSegment$okio2.limit;
            byte[] bArr2 = segmentWritableSegment$okio2.data;
            bArr2[i4] = (byte) ((i >> 12) | 224);
            bArr2[1 + i4] = (byte) (((i >> 6) & 63) | 128);
            bArr2[2 + i4] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio2.limit = i4 + 3;
            this.size += 3;
            return;
        }
        if (i <= 1114111) {
            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
            int i5 = segmentWritableSegment$okio3.limit;
            byte[] bArr3 = segmentWritableSegment$okio3.data;
            bArr3[i5] = (byte) ((i >> 18) | 240);
            bArr3[1 + i5] = (byte) (((i >> 12) & 63) | 128);
            bArr3[2 + i5] = (byte) (((i >> 6) & 63) | 128);
            bArr3[3 + i5] = (byte) ((i & 63) | 128);
            segmentWritableSegment$okio3.limit = i5 + 4;
            this.size += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = ByteStringKt.HEX_DIGIT_CHARS;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            while (i2 < 8 && cArr2[i2] == '0') {
                i2++;
            }
            str = new String(cArr2, i2, 8 - i2);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public final String readString(long j, Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount: ").toString());
        }
        if (this.size < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return sgtsHsWT.ZAcUoprDDQQbh;
        }
        Segment segment = this.head;
        Intrinsics.checkNotNull(segment);
        int i = segment.pos;
        if (((long) i) + j > segment.limit) {
            return new String(readByteArray(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment.data, i, i2, charset);
        int i3 = segment.pos + i2;
        segment.pos = i3;
        this.size -= j;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return str;
    }

    public final String toString() {
        long j = this.size;
        if (j <= Integer.MAX_VALUE) {
            return snapshot((int) j).toString();
        }
        throw new IllegalStateException((DaWYVMJ.hfNtFes + this.size).toString());
    }

    /* JADX INFO: renamed from: writeUtf8 */
    public final void m124writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        writeUtf8(0, string.length(), string);
    }

    public final void writeUtf8(int i, int i2, String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (i < 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "beginIndex < 0: ").toString());
        }
        if (i2 >= i) {
            if (i2 > string.length()) {
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i2, "endIndex > string.length: ", " > ");
                sbM.append(string.length());
                throw new IllegalArgumentException(sbM.toString().toString());
            }
            while (i < i2) {
                char cCharAt = string.charAt(i);
                if (cCharAt < 128) {
                    Segment segmentWritableSegment$okio = writableSegment$okio(1);
                    int i3 = segmentWritableSegment$okio.limit - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    byte[] bArr = segmentWritableSegment$okio.data;
                    bArr[i + i3] = (byte) cCharAt;
                    while (i4 < iMin) {
                        char cCharAt2 = string.charAt(i4);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) cCharAt2;
                        i4++;
                    }
                    int i5 = segmentWritableSegment$okio.limit;
                    int i6 = (i3 + i4) - i5;
                    segmentWritableSegment$okio.limit = i5 + i6;
                    this.size += (long) i6;
                    i = i4;
                } else {
                    if (cCharAt < 2048) {
                        Segment segmentWritableSegment$okio2 = writableSegment$okio(2);
                        int i7 = segmentWritableSegment$okio2.limit;
                        byte[] bArr2 = segmentWritableSegment$okio2.data;
                        bArr2[i7] = (byte) ((cCharAt >> 6) | 192);
                        bArr2[i7 + 1] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio2.limit = i7 + 2;
                        this.size += 2;
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i8 = i + 1;
                        char cCharAt3 = i8 < i2 ? string.charAt(i8) : (char) 0;
                        if (cCharAt <= 56319 && 56320 <= cCharAt3 && 57343 >= cCharAt3) {
                            int i9 = (((cCharAt & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                            Segment segmentWritableSegment$okio3 = writableSegment$okio(4);
                            int i10 = segmentWritableSegment$okio3.limit;
                            byte[] bArr3 = segmentWritableSegment$okio3.data;
                            bArr3[i10] = (byte) ((i9 >> 18) | 240);
                            bArr3[i10 + 1] = (byte) (((i9 >> 12) & 63) | 128);
                            bArr3[i10 + 2] = (byte) (((i9 >> 6) & 63) | 128);
                            bArr3[i10 + 3] = (byte) ((i9 & 63) | 128);
                            segmentWritableSegment$okio3.limit = i10 + 4;
                            this.size += 4;
                            i += 2;
                        } else {
                            writeByte(63);
                            i = i8;
                        }
                    } else {
                        Segment segmentWritableSegment$okio4 = writableSegment$okio(3);
                        int i11 = segmentWritableSegment$okio4.limit;
                        byte[] bArr4 = segmentWritableSegment$okio4.data;
                        bArr4[i11] = (byte) ((cCharAt >> '\f') | 224);
                        bArr4[i11 + 1] = (byte) ((63 & (cCharAt >> 6)) | 128);
                        bArr4[i11 + 2] = (byte) ((cCharAt & '?') | 128);
                        segmentWritableSegment$okio4.limit = i11 + 3;
                        this.size += 3;
                    }
                    i++;
                }
            }
            return;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, i, "endIndex < beginIndex: ", " < ").toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), segment.limit - segment.pos);
        sink.put(segment.data, segment.pos, iMin);
        int i = segment.pos + iMin;
        segment.pos = i;
        this.size -= (long) iMin;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return iMin;
    }

    public final void write(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, byteString.getSize$okio());
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        int iRemaining = source.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i, 8192 - segmentWritableSegment$okio.limit);
            source.get(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
            i -= iMin;
            segmentWritableSegment$okio.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    public final void write(byte[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        long j = i2;
        StringsKt__IndentKt.checkOffsetAndCount(source.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment segmentWritableSegment$okio = writableSegment$okio(1);
            int iMin = Math.min(i3 - i, 8192 - segmentWritableSegment$okio.limit);
            int i4 = i + iMin;
            ArraysKt.copyInto(source, segmentWritableSegment$okio.limit, segmentWritableSegment$okio.data, i, i4);
            segmentWritableSegment$okio.limit += iMin;
            i = i4;
        }
        this.size += j;
    }
}
