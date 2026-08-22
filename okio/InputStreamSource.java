package okio;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InputStreamSource implements Source {
    public final /* synthetic */ int $r8$classId;
    public final Object input;
    public final Object timeout;

    public /* synthetic */ InputStreamSource(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.input = obj;
        this.timeout = obj2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.$r8$classId) {
            case 0:
                ((InputStream) this.input).close();
                return;
            default:
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) this.input;
                socketAsyncTimeout.enter();
                try {
                    try {
                        ((InputStreamSource) this.timeout).close();
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

    @Override // okio.Source
    public final long read(Buffer sink, long j) throws IOException {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                if (j == 0) {
                    return 0L;
                }
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
                }
                try {
                    ((Timeout) this.timeout).throwIfReached();
                    Segment segmentWritableSegment$okio = sink.writableSegment$okio(1);
                    int i = ((InputStream) this.input).read(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit));
                    if (i == -1) {
                        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                            sink.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                        }
                        return -1L;
                    }
                    segmentWritableSegment$okio.limit += i;
                    long j2 = i;
                    sink.size += j2;
                    return j2;
                } catch (AssertionError e) {
                    if (Okio.isAndroidGetsocknameError(e)) {
                        throw new IOException(e);
                    }
                    throw e;
                }
            default:
                Intrinsics.checkNotNullParameter(sink, "sink");
                SocketAsyncTimeout socketAsyncTimeout = (SocketAsyncTimeout) this.input;
                socketAsyncTimeout.enter();
                try {
                    try {
                        long j3 = ((InputStreamSource) this.timeout).read(sink, j);
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(null);
                        }
                        return j3;
                    } catch (IOException e2) {
                        if (socketAsyncTimeout.exit()) {
                            throw socketAsyncTimeout.newTimeoutException(e2);
                        }
                        throw e2;
                    }
                } catch (Throwable th) {
                    socketAsyncTimeout.exit();
                    throw th;
                }
        }
    }

    @Override // okio.Source
    public final Timeout timeout() {
        switch (this.$r8$classId) {
            case 0:
                return (Timeout) this.timeout;
            default:
                return (SocketAsyncTimeout) this.input;
        }
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "source(" + ((InputStream) this.input) + ')';
            default:
                return "AsyncTimeout.source(" + ((InputStreamSource) this.timeout) + ')';
        }
    }
}
