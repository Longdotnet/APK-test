package okio;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class RealBufferedSink implements BufferedSink {
    public final Buffer bufferField;
    public boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        this.bufferField = new Buffer();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Sink sink = this.sink;
        if (this.closed) {
            return;
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j > 0) {
            sink.write(buffer, j);
        }
        th = null;
        try {
            sink.close();
        } catch (Throwable th) {
            if (th == null) {
                th = th;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final BufferedSink emitCompleteSegments() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        if (j == 0) {
            j = 0;
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            int i = segment2.limit;
            if (i < 8192 && segment2.owner) {
                j -= (long) (i - segment2.pos);
            }
        }
        if (j > 0) {
            this.sink.write(buffer, j);
        }
        return this;
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        Buffer buffer = this.bufferField;
        long j = buffer.size;
        Sink sink = this.sink;
        if (j > 0) {
            sink.write(buffer, j);
        }
        sink.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        return this.sink.timeout();
    }

    public final String toString() {
        return "buffer(" + this.sink + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.bufferField.write(source);
        emitCompleteSegments();
        return iWrite;
    }

    public final BufferedSink writeByte(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeByte(i);
        emitCompleteSegments();
        return this;
    }

    public final BufferedSink writeInt(int i) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.writeInt(i);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.BufferedSink
    public final BufferedSink writeUtf8(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        this.bufferField.m124writeUtf8(string);
        emitCompleteSegments();
        return this;
    }

    @Override // okio.Sink
    public final void write(Buffer source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.closed) {
            this.bufferField.write(source, j);
            emitCompleteSegments();
            return;
        }
        throw new IllegalStateException("closed");
    }
}
