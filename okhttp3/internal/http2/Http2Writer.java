package okhttp3.internal.http2;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.RealBufferedSink;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Writer implements Closeable {
    public static final Logger logger = Logger.getLogger(Http2.class.getName());
    public boolean closed;
    public final Buffer hpackBuffer;
    public final Hpack.Writer hpackWriter;
    public int maxFrameSize;
    public final RealBufferedSink sink;

    public Http2Writer(RealBufferedSink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.sink = sink;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(buffer);
    }

    public final synchronized void applyAndAckSettings(Settings peerSettings) {
        try {
            Intrinsics.checkNotNullParameter(peerSettings, "peerSettings");
            if (this.closed) {
                throw new IOException("closed");
            }
            int i = this.maxFrameSize;
            int i2 = peerSettings.set;
            if ((i2 & 32) != 0) {
                i = peerSettings.values[5];
            }
            this.maxFrameSize = i;
            if (((i2 & 2) != 0 ? peerSettings.values[1] : -1) != -1) {
                Hpack.Writer writer = this.hpackWriter;
                int i3 = (i2 & 2) != 0 ? peerSettings.values[1] : -1;
                writer.getClass();
                int iMin = Math.min(i3, 16384);
                int i4 = writer.maxDynamicTableByteCount;
                if (i4 != iMin) {
                    if (iMin < i4) {
                        writer.smallestHeaderTableSizeSetting = Math.min(writer.smallestHeaderTableSizeSetting, iMin);
                    }
                    writer.emitDynamicTableSizeUpdate = true;
                    writer.maxDynamicTableByteCount = iMin;
                    int i5 = writer.dynamicTableByteCount;
                    if (iMin < i5) {
                        if (iMin == 0) {
                            Header[] headerArr = writer.dynamicTable;
                            ArraysKt.fill(headerArr, 0, headerArr.length);
                            writer.nextHeaderIndex = writer.dynamicTable.length - 1;
                            writer.headerCount = 0;
                            writer.dynamicTableByteCount = 0;
                        } else {
                            writer.evictToRecoverBytes(i5 - iMin);
                        }
                    }
                }
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void data(boolean z, int i, Buffer buffer, int i2) {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(i, i2, 0, z ? 1 : 0);
        if (i2 > 0) {
            Intrinsics.checkNotNull(buffer);
            this.sink.write(buffer, i2);
        }
    }

    public final synchronized void flush() {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final void frameHeader(int i, int i2, int i3, int i4) {
        Level level = Level.FINE;
        Logger logger2 = logger;
        if (logger2.isLoggable(level)) {
            logger2.fine(Http2.frameLog(false, i, i2, i3, i4));
        }
        if (i2 > this.maxFrameSize) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i2).toString());
        }
        if ((((int) 2147483648L) & i) != 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "reserved bit set: ").toString());
        }
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        RealBufferedSink writeMedium = this.sink;
        Intrinsics.checkNotNullParameter(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i2 >>> 16) & 255);
        writeMedium.writeByte((i2 >>> 8) & 255);
        writeMedium.writeByte(i2 & 255);
        writeMedium.writeByte(i3 & 255);
        writeMedium.writeByte(i4 & 255);
        writeMedium.writeInt(i & Integer.MAX_VALUE);
    }

    public final synchronized void goAway(int i, byte[] bArr, int i2) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i2, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (Fragment$$ExternalSyntheticOutline0.ordinal(i2) == -1) {
            throw new IllegalArgumentException("errorCode.httpCode == -1");
        }
        frameHeader(0, bArr.length + 8, 7, 0);
        this.sink.writeInt(i);
        this.sink.writeInt(Fragment$$ExternalSyntheticOutline0.ordinal(i2));
        if (bArr.length != 0) {
            RealBufferedSink realBufferedSink = this.sink;
            if (realBufferedSink.closed) {
                throw new IllegalStateException("closed");
            }
            realBufferedSink.bufferField.write(bArr, 0, bArr.length);
            realBufferedSink.emitCompleteSegments();
        }
        this.sink.flush();
    }

    public final synchronized void headers(boolean z, int i, ArrayList arrayList) {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(arrayList);
        long j = this.hpackBuffer.size;
        long jMin = Math.min(this.maxFrameSize, j);
        int i2 = j == jMin ? 4 : 0;
        if (z) {
            i2 |= 1;
        }
        frameHeader(i, (int) jMin, 1, i2);
        this.sink.write(this.hpackBuffer, jMin);
        if (j > jMin) {
            long j2 = j - jMin;
            while (j2 > 0) {
                long jMin2 = Math.min(this.maxFrameSize, j2);
                j2 -= jMin2;
                frameHeader(i, (int) jMin2, 9, j2 == 0 ? 4 : 0);
                this.sink.write(this.hpackBuffer, jMin2);
            }
        }
    }

    public final synchronized void ping(int i, int i2, boolean z) {
        if (this.closed) {
            throw new IOException("closed");
        }
        frameHeader(0, 8, 6, z ? 1 : 0);
        this.sink.writeInt(i);
        this.sink.writeInt(i2);
        this.sink.flush();
    }

    public final synchronized void rstStream(int i, int i2) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i2, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (Fragment$$ExternalSyntheticOutline0.ordinal(i2) == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        frameHeader(i, 4, 3, 0);
        this.sink.writeInt(Fragment$$ExternalSyntheticOutline0.ordinal(i2));
        this.sink.flush();
    }

    public final synchronized void settings(Settings settings) {
        int i;
        try {
            Intrinsics.checkNotNullParameter(settings, "settings");
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, Integer.bitCount(settings.set) * 6, 4, 0);
            int i2 = 0;
            while (i2 < 10) {
                boolean z = true;
                if (((1 << i2) & settings.set) == 0) {
                    z = false;
                }
                if (z) {
                    if (i2 != 4) {
                        i = i2 != 7 ? i2 : 4;
                    } else {
                        i = 3;
                    }
                    RealBufferedSink realBufferedSink = this.sink;
                    if (realBufferedSink.closed) {
                        throw new IllegalStateException("closed");
                    }
                    realBufferedSink.bufferField.writeShort(i);
                    realBufferedSink.emitCompleteSegments();
                    this.sink.writeInt(settings.values[i2]);
                }
                i2++;
            }
            this.sink.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void windowUpdate(int i, long j) {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        frameHeader(i, 4, 8, 0);
        this.sink.writeInt((int) j);
        this.sink.flush();
    }
}
