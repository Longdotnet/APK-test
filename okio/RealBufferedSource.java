package okio;

import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__IndentKt;
import okio.internal.BufferKt;
import okio.internal.ByteStringKt;

/* JADX INFO: loaded from: classes3.dex */
public final class RealBufferedSource implements BufferedSource {
    public final Buffer bufferField;
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        Buffer buffer = this.bufferField;
        buffer.skip(buffer.size);
    }

    public final boolean exhausted() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        if (buffer.exhausted()) {
            if (this.source.read(buffer, 8192) == -1) {
                return true;
            }
        }
        return false;
    }

    public final long indexOf(byte b, long j, long j2) {
        long j3;
        Segment segment;
        RealBufferedSource realBufferedSource = this;
        long j4 = j2;
        if (realBufferedSource.closed) {
            throw new IllegalStateException("closed");
        }
        long jMax = 0;
        if (j4 < 0) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j4, "fromIndex=0 toIndex=").toString());
        }
        while (jMax < j4) {
            Buffer buffer = realBufferedSource.bufferField;
            buffer.getClass();
            long j5 = 0;
            if (!(0 <= jMax && j4 >= jMax)) {
                throw new IllegalArgumentException(("size=" + buffer.size + " fromIndex=" + jMax + " toIndex=" + j4).toString());
            }
            long j6 = buffer.size;
            long j7 = j4 > j6 ? j6 : j4;
            long j8 = -1;
            if (jMax != j7 && (segment = buffer.head) != null) {
                if (j6 - jMax < jMax) {
                    while (j6 > jMax) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        j6 -= (long) (segment.limit - segment.pos);
                    }
                    long j9 = jMax;
                    while (j6 < j7) {
                        int iMin = (int) Math.min(segment.limit, (((long) segment.pos) + j7) - j6);
                        for (int i = (int) ((((long) segment.pos) + j9) - j6); i < iMin; i++) {
                            if (segment.data[i] == b) {
                                j8 = ((long) (i - segment.pos)) + j6;
                                break;
                            }
                        }
                        j9 = j6 + ((long) (segment.limit - segment.pos));
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j6 = j9;
                    }
                } else {
                    while (true) {
                        long j10 = ((long) (segment.limit - segment.pos)) + j5;
                        if (j10 > jMax) {
                            break;
                        }
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j5 = j10;
                    }
                    long j11 = jMax;
                    while (j5 < j7) {
                        int iMin2 = (int) Math.min(segment.limit, (((long) segment.pos) + j7) - j5);
                        for (int i2 = (int) ((((long) segment.pos) + j11) - j5); i2 < iMin2; i2++) {
                            if (segment.data[i2] == b) {
                                j8 = ((long) (i2 - segment.pos)) + j5;
                                break;
                            }
                        }
                        j11 = ((long) (segment.limit - segment.pos)) + j5;
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j5 = j11;
                    }
                }
            }
            j3 = -1;
            if (j8 != -1) {
                return j8;
            }
            long j12 = buffer.size;
            if (j12 < j2) {
                realBufferedSource = this;
                if (realBufferedSource.source.read(buffer, 8192) != -1) {
                    jMax = Math.max(jMax, j12);
                    j4 = j2;
                }
            }
            return j3;
        }
        j3 = -1;
        return j3;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Buffer buffer = this.bufferField;
        if (buffer.size == 0) {
            if (this.source.read(buffer, 8192) == -1) {
                return -1;
            }
        }
        return buffer.read(sink);
    }

    public final byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    public final ByteString readByteString(long j) {
        require(j);
        return this.bufferField.readByteString(j);
    }

    public final long readHexadecimalUnsignedLong() throws EOFException {
        Buffer buffer;
        long j;
        int i;
        int i2;
        int i3 = 48;
        require(1L);
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            boolean zRequest = request(i5);
            buffer = this.bufferField;
            if (!zRequest) {
                break;
            }
            byte b = buffer.getByte(i4);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                if (i4 != 0) {
                    break;
                }
                ExceptionsKt.checkRadix(16);
                ExceptionsKt.checkRadix(16);
                String string = Integer.toString(b, 16);
                Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
            }
            i4 = i5;
        }
        long j2 = 0;
        if (buffer.size == 0) {
            throw new EOFException();
        }
        long j3 = 0;
        int i6 = 0;
        boolean z = false;
        while (true) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i7 = segment.pos;
            int i8 = segment.limit;
            int i9 = i6;
            while (true) {
                if (i7 >= i8) {
                    j = j2;
                    i = i9;
                    break;
                }
                byte b2 = segment.data[i7];
                byte b3 = (byte) i3;
                if (b2 < b3 || b2 > ((byte) 57)) {
                    byte b4 = (byte) 97;
                    if ((b2 < b4 || b2 > ((byte) TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE)) && (b2 < (b4 = (byte) 65) || b2 > ((byte) 70))) {
                        i = i9;
                        j = 0;
                        if (i != 0) {
                            z = true;
                            break;
                        }
                        char[] cArr = ByteStringKt.HEX_DIGIT_CHARS;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]})));
                    }
                    i2 = (b2 - b4) + 10;
                } else {
                    i2 = b2 - b3;
                }
                if ((j3 & (-1152921504606846976L)) != 0) {
                    Buffer buffer2 = new Buffer();
                    buffer2.writeHexadecimalUnsignedLong(j3);
                    buffer2.writeByte(b2);
                    throw new NumberFormatException("Number too large: ".concat(buffer2.readString(buffer2.size, Charsets.UTF_8)));
                }
                j3 = (j3 << 4) | ((long) i2);
                i7++;
                i9++;
                j2 = 0;
                i3 = 48;
            }
            if (i7 == i8) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i7;
            }
            if (z || buffer.head == null) {
                buffer.size -= (long) i;
                return j3;
            }
            i6 = i;
            j2 = j;
            i3 = 48;
        }
    }

    public final int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    public final short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public final String readString(Charset charset) {
        Buffer buffer = this.bufferField;
        buffer.writeAll(this.source);
        return buffer.readString(buffer.size, charset);
    }

    public final String readUtf8LineStrict(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "limit < 0: ").toString());
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        byte b = (byte) 10;
        long jIndexOf = indexOf(b, 0L, j2);
        Buffer buffer = this.bufferField;
        if (jIndexOf != -1) {
            return BufferKt.readUtf8Line(buffer, jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && buffer.getByte(j2 - 1) == ((byte) 13) && request(1 + j2) && buffer.getByte(j2) == b) {
            return BufferKt.readUtf8Line(buffer, j2);
        }
        Buffer out = new Buffer();
        long jMin = Math.min(32, buffer.size);
        long j3 = 0;
        buffer.getClass();
        Intrinsics.checkNotNullParameter(out, "out");
        StringsKt__IndentKt.checkOffsetAndCount(buffer.size, 0L, jMin);
        if (jMin != 0) {
            out.size += jMin;
            Segment segment = buffer.head;
            while (true) {
                Intrinsics.checkNotNull(segment);
                long j4 = segment.limit - segment.pos;
                if (j3 < j4) {
                    break;
                }
                j3 -= j4;
                segment = segment.next;
            }
            while (jMin > 0) {
                Intrinsics.checkNotNull(segment);
                Segment segmentSharedCopy = segment.sharedCopy();
                int i = segmentSharedCopy.pos + ((int) j3);
                segmentSharedCopy.pos = i;
                segmentSharedCopy.limit = Math.min(i + ((int) jMin), segmentSharedCopy.limit);
                Segment segment2 = out.head;
                if (segment2 == null) {
                    segmentSharedCopy.prev = segmentSharedCopy;
                    segmentSharedCopy.next = segmentSharedCopy;
                    out.head = segmentSharedCopy;
                } else {
                    Segment segment3 = segment2.prev;
                    Intrinsics.checkNotNull(segment3);
                    segment3.push(segmentSharedCopy);
                }
                jMin -= (long) (segmentSharedCopy.limit - segmentSharedCopy.pos);
                segment = segment.next;
                j3 = 0;
            }
        }
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size, j) + " content=" + out.readByteString(out.size).hex() + "…");
    }

    public final boolean request(long j) {
        Buffer buffer;
        if (j < 0) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.bufferField;
            if (buffer.size >= j) {
                return true;
            }
        } while (this.source.read(buffer, 8192) != -1);
        return false;
    }

    public final void require(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public final int select(Options options) throws EOFException {
        Buffer buffer;
        Intrinsics.checkNotNullParameter(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            buffer = this.bufferField;
            int iSelectPrefix = BufferKt.selectPrefix(buffer, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    break;
                }
                buffer.skip(options.byteStrings[iSelectPrefix].getSize$okio());
                return iSelectPrefix;
            }
        } while (this.source.read(buffer, 8192) != -1);
        return -1;
    }

    public final void skip(long j) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            Buffer buffer = this.bufferField;
            if (buffer.size == 0) {
                if (this.source.read(buffer, 8192) == -1) {
                    throw new EOFException();
                }
            }
            long jMin = Math.min(j, buffer.size);
            buffer.skip(jMin);
            j -= jMin;
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.timeout();
    }

    public final String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j >= 0) {
            if (!this.closed) {
                Buffer buffer = this.bufferField;
                if (buffer.size == 0) {
                    if (this.source.read(buffer, 8192) == -1) {
                        return -1L;
                    }
                }
                return buffer.read(sink, Math.min(j, buffer.size));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
    }
}
