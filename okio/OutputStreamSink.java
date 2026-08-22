package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public final class OutputStreamSink implements Sink {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object out;
    public final SocketAsyncTimeout timeout;

    public OutputStreamSink(OutputStream outputStream, SocketAsyncTimeout socketAsyncTimeout) {
        this.out = outputStream;
        this.timeout = socketAsyncTimeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((OutputStream) this.out).close();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        ((OutputStreamSink) this.out).close();
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((OutputStream) this.out).flush();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = this.timeout;
                socketAsyncTimeout.enter();
                try {
                    try {
                        ((OutputStreamSink) this.out).flush();
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return;
                    } catch (IOException e) {
                        if (!socketAsyncTimeout.exit()) {
                            throw e;
                        }
                        throw socketAsyncTimeout.newTimeoutException(e);
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    @Override // okio.Sink
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.timeout;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "sink(" + ((OutputStream) this.out) + ')';
            default:
                return "AsyncTimeout.sink(" + ((OutputStreamSink) this.out) + ')';
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0044 A[LOOP:0: B:5:0x000d->B:18:0x0044, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0046 A[SYNTHETIC] */
    @Override // okio.Sink
    public final void write(Buffer buffer, long j) throws IOException {
        SocketAsyncTimeout socketAsyncTimeout;
        switch (this.$r8$classId) {
            case 0:
                StringsKt__IndentKt.checkOffsetAndCount(buffer.size, 0L, j);
                while (j > 0) {
                    this.timeout.throwIfReached();
                    Segment segment = buffer.head;
                    Intrinsics.checkNotNull(segment);
                    int iMin = (int) Math.min(j, segment.limit - segment.pos);
                    ((OutputStream) this.out).write(segment.data, segment.pos, iMin);
                    int i = segment.pos + iMin;
                    segment.pos = i;
                    long j2 = iMin;
                    j -= j2;
                    buffer.size -= j2;
                    if (i == segment.limit) {
                        buffer.head = segment.pop();
                        SegmentPool.recycle(segment);
                    }
                }
                return;
            default:
                StringsKt__IndentKt.checkOffsetAndCount(buffer.size, 0L, j);
                while (true) {
                    long j3 = 0;
                    if (j <= 0) {
                        return;
                    }
                    Segment segment2 = buffer.head;
                    Intrinsics.checkNotNull(segment2);
                    try {
                        try {
                            while (j3 < 65536) {
                                j3 += (long) (segment2.limit - segment2.pos);
                                if (j3 >= j) {
                                    j3 = j;
                                    socketAsyncTimeout = this.timeout;
                                    socketAsyncTimeout.enter();
                                    ((OutputStreamSink) this.out).write(buffer, j3);
                                    if (!socketAsyncTimeout.exit()) {
                                        throw socketAsyncTimeout.newTimeoutException(null);
                                    }
                                    j -= j3;
                                } else {
                                    segment2 = segment2.next;
                                    Intrinsics.checkNotNull(segment2);
                                }
                            }
                            ((OutputStreamSink) this.out).write(buffer, j3);
                            if (!socketAsyncTimeout.exit()) {
                                throw socketAsyncTimeout.newTimeoutException(null);
                            }
                            j -= j3;
                        } catch (IOException e) {
                            if (!socketAsyncTimeout.exit()) {
                                throw e;
                            }
                            throw socketAsyncTimeout.newTimeoutException(e);
                        }
                    } catch (Throwable th) {
                        socketAsyncTimeout.exit();
                        throw th;
                    }
                    socketAsyncTimeout = this.timeout;
                    socketAsyncTimeout.enter();
                }
                break;
        }
    }

    public OutputStreamSink(SocketAsyncTimeout socketAsyncTimeout, OutputStreamSink outputStreamSink) {
        this.timeout = socketAsyncTimeout;
        this.out = outputStreamSink;
    }
}
