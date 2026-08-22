package okio;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final RealBufferedSource source;

    public InflaterSource(RealBufferedSource realBufferedSource, Inflater inflater) {
        this.source = realBufferedSource;
        this.inflater = inflater;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.source.source.timeout();
    }

    @Override // okio.Source
    public final long read(Buffer sink, long j) throws IOException {
        long j2;
        Intrinsics.checkNotNullParameter(sink, "sink");
        while (j >= 0) {
            if (this.closed) {
                throw new IllegalStateException(MnHfHMYQDPUO.IdnsWHHqXrm);
            }
            RealBufferedSource realBufferedSource = this.source;
            Inflater inflater = this.inflater;
            if (j == 0) {
                j2 = 0;
            } else {
                try {
                    Segment segmentWritableSegment$okio = sink.writableSegment$okio(1);
                    int iMin = (int) Math.min(j, 8192 - segmentWritableSegment$okio.limit);
                    if (inflater.needsInput() && !realBufferedSource.exhausted()) {
                        Segment segment = realBufferedSource.bufferField.head;
                        Intrinsics.checkNotNull(segment);
                        int i = segment.limit;
                        int i2 = segment.pos;
                        int i3 = i - i2;
                        this.bufferBytesHeldByInflater = i3;
                        inflater.setInput(segment.data, i2, i3);
                    }
                    int iInflate = inflater.inflate(segmentWritableSegment$okio.data, segmentWritableSegment$okio.limit, iMin);
                    int i4 = this.bufferBytesHeldByInflater;
                    if (i4 != 0) {
                        int remaining = i4 - inflater.getRemaining();
                        this.bufferBytesHeldByInflater -= remaining;
                        realBufferedSource.skip(remaining);
                    }
                    if (iInflate > 0) {
                        segmentWritableSegment$okio.limit += iInflate;
                        j2 = iInflate;
                        sink.size += j2;
                    } else {
                        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
                            sink.head = segmentWritableSegment$okio.pop();
                            SegmentPool.recycle(segmentWritableSegment$okio);
                        }
                        j2 = 0;
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            if (j2 > 0) {
                return j2;
            }
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
            if (realBufferedSource.exhausted()) {
                throw new EOFException("source exhausted prematurely");
            }
        }
        throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
    }
}
