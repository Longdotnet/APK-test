package okio;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public final class GzipSink implements Sink {
    public boolean closed;
    public final CRC32 crc;
    public final Deflater deflater;
    public final DeflaterSink deflaterSink;
    public final RealBufferedSink sink;

    public GzipSink(BufferedSink bufferedSink) {
        RealBufferedSink realBufferedSink = new RealBufferedSink(bufferedSink);
        this.sink = realBufferedSink;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new DeflaterSink(realBufferedSink, deflater);
        this.crc = new CRC32();
        Buffer buffer = realBufferedSink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.deflater;
        RealBufferedSink realBufferedSink = this.sink;
        if (this.closed) {
            return;
        }
        try {
            DeflaterSink deflaterSink = this.deflaterSink;
            ((Deflater) deflaterSink.deflater).finish();
            deflaterSink.deflate(false);
            int value = (int) this.crc.getValue();
            if (realBufferedSink.closed) {
                throw new IllegalStateException("closed");
            }
            int iReverseBytes = StringsKt__IndentKt.reverseBytes(value);
            Buffer buffer = realBufferedSink.bufferField;
            buffer.writeInt(iReverseBytes);
            realBufferedSink.emitCompleteSegments();
            int bytesRead = (int) deflater.getBytesRead();
            if (realBufferedSink.closed) {
                throw new IllegalStateException("closed");
            }
            buffer.writeInt(StringsKt__IndentKt.reverseBytes(bytesRead));
            realBufferedSink.emitCompleteSegments();
            th = null;
            try {
                deflater.end();
            } catch (Throwable th) {
                if (th == null) {
                    th = th;
                }
            }
            try {
                realBufferedSink.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                }
            }
            this.closed = true;
            if (th != null) {
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.sink.timeout();
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) {
        if (j < 0) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
        }
        if (j == 0) {
            return;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, iMin);
            j2 -= (long) iMin;
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        }
        this.deflaterSink.write(buffer, j);
    }
}
