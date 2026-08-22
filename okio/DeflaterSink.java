package okio;

import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;

/* JADX INFO: loaded from: classes3.dex */
public final class DeflaterSink implements Sink {
    public final /* synthetic */ int $r8$classId = 1;
    public boolean closed;
    public final Object deflater;
    public final Object sink;

    public DeflaterSink(RealBufferedSink realBufferedSink, Deflater deflater) {
        this.sink = realBufferedSink;
        this.deflater = deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        switch (this.$r8$classId) {
            case 0:
                Deflater deflater = (Deflater) this.deflater;
                if (this.closed) {
                    return;
                }
                deflater.finish();
                deflate(false);
                th = null;
                try {
                    deflater.end();
                    break;
                } catch (Throwable th) {
                    if (th == null) {
                        th = th;
                    }
                }
                try {
                    ((RealBufferedSink) this.sink).close();
                    break;
                } catch (Throwable th2) {
                    if (th == null) {
                        th = th2;
                    }
                }
                this.closed = true;
                if (th != null) {
                    throw th;
                }
                return;
            default:
                if (this.closed) {
                    return;
                }
                this.closed = true;
                RouteSelector routeSelector = (RouteSelector) this.deflater;
                routeSelector.getClass();
                ForwardingTimeout forwardingTimeout = (ForwardingTimeout) this.sink;
                Timeout timeout = forwardingTimeout.delegate;
                forwardingTimeout.delegate = Timeout.NONE;
                timeout.clearDeadline();
                timeout.clearTimeout();
                routeSelector.nextProxyIndex = 3;
                return;
        }
    }

    public void deflate(boolean z) {
        Segment segmentWritableSegment$okio;
        int iDeflate;
        RealBufferedSink realBufferedSink = (RealBufferedSink) this.sink;
        Buffer buffer = realBufferedSink.bufferField;
        while (true) {
            segmentWritableSegment$okio = buffer.writableSegment$okio(1);
            Deflater deflater = (Deflater) this.deflater;
            byte[] bArr = segmentWritableSegment$okio.data;
            if (z) {
                int i = segmentWritableSegment$okio.limit;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                int i2 = segmentWritableSegment$okio.limit;
                iDeflate = deflater.deflate(bArr, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                segmentWritableSegment$okio.limit += iDeflate;
                buffer.size += (long) iDeflate;
                realBufferedSink.emitCompleteSegments();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        switch (this.$r8$classId) {
            case 0:
                deflate(true);
                ((RealBufferedSink) this.sink).flush();
                break;
            default:
                if (!this.closed) {
                    ((RealBufferedSink) ((RouteSelector) this.deflater).call).flush();
                    break;
                }
                break;
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return ((RealBufferedSink) this.sink).sink.timeout();
            default:
                return (ForwardingTimeout) this.sink;
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "DeflaterSink(" + ((RealBufferedSink) this.sink) + ')';
            default:
                return super.toString();
        }
    }

    @Override // okio.Sink
    public final void write(Buffer buffer, long j) {
        Object obj = this.deflater;
        switch (this.$r8$classId) {
            case 0:
                StringsKt__IndentKt.checkOffsetAndCount(buffer.size, 0L, j);
                while (j > 0) {
                    Segment segment = buffer.head;
                    Intrinsics.checkNotNull(segment);
                    int iMin = (int) Math.min(j, segment.limit - segment.pos);
                    ((Deflater) obj).setInput(segment.data, segment.pos, iMin);
                    deflate(false);
                    long j2 = iMin;
                    buffer.size -= j2;
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    if (i == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                    j -= j2;
                }
                return;
            default:
                if (this.closed) {
                    throw new IllegalStateException("closed");
                }
                long j3 = buffer.size;
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                if (j < 0 || 0 > j3 || j3 < j) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                ((RealBufferedSink) ((RouteSelector) obj).call).write(buffer, j);
                return;
        }
    }

    public DeflaterSink(RouteSelector routeSelector) {
        this.deflater = routeSelector;
        this.sink = new ForwardingTimeout(((RealBufferedSink) routeSelector.call).sink.timeout());
    }
}
