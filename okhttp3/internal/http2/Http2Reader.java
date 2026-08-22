package okhttp3.internal.http2;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Reader implements Closeable {
    public static final Logger logger;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final RealBufferedSource source;

    public abstract class Companion {
        public static int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i3, i, "PROTOCOL_ERROR padding ", " > remaining length "));
        }
    }

    public final class ContinuationSource implements Source {
        public int flags;
        public int left;
        public int length;
        public int padding;
        public final RealBufferedSource source;
        public int streamId;

        public ContinuationSource(RealBufferedSource source) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.source = source;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return this.source.source.timeout();
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j) throws IOException {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(buffer, UUFMQdNK.bbWTdWIaPCg);
            do {
                int i3 = this.left;
                RealBufferedSource realBufferedSource = this.source;
                if (i3 != 0) {
                    long j2 = realBufferedSource.read(buffer, Math.min(j, i3));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j2;
                    return j2;
                }
                realBufferedSource.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                i = this.streamId;
                int medium = Util.readMedium(realBufferedSource);
                this.left = medium;
                this.length = medium;
                int i4 = realBufferedSource.readByte() & 255;
                this.flags = realBufferedSource.readByte() & 255;
                Logger logger = Http2Reader.logger;
                if (logger.isLoggable(Level.FINE)) {
                    ByteString byteString = Http2.CONNECTION_PREFACE;
                    logger.fine(Http2.frameLog(true, this.streamId, this.length, i4, this.flags));
                }
                i2 = realBufferedSource.readInt() & Integer.MAX_VALUE;
                this.streamId = i2;
                if (i4 != 9) {
                    throw new IOException(i4 + " != TYPE_CONTINUATION");
                }
            } while (i2 == i);
            throw new IOException("TYPE_CONTINUATION streamId changed");
        }
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger2, "Logger.getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(RealBufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.source.close();
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:111:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:113:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:114:0x01fe  */
    public final boolean nextFrame(boolean z, Http2Connection.ReaderRunnable handler) throws IOException {
        Http2Connection http2Connection;
        Http2Stream http2StreamRemoveStream$okhttp;
        int i;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(handler, "handler");
        try {
            this.source.require(9L);
            int medium = Util.readMedium(this.source);
            if (medium > 16384) {
                throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(medium, "FRAME_SIZE_ERROR: "));
            }
            int i3 = this.source.readByte() & 255;
            byte b = this.source.readByte();
            int i4 = b & 255;
            int i5 = this.source.readInt();
            int i6 = i5 & Integer.MAX_VALUE;
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Http2.frameLog(true, i6, medium, i3, i4));
            }
            if (z && i3 != 4) {
                StringBuilder sb = new StringBuilder("Expected a SETTINGS frame but was ");
                String[] strArr = Http2.FRAME_NAMES;
                sb.append(i3 < strArr.length ? strArr[i3] : Util.format("0x%02x", Integer.valueOf(i3)));
                throw new IOException(sb.toString());
            }
            switch (i3) {
                case 0:
                    readData(handler, medium, i4, i6);
                    return true;
                case 1:
                    readHeaders(handler, medium, i4, i6);
                    return true;
                case 2:
                    if (medium != 5) {
                        throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(medium, "TYPE_PRIORITY length: ", " != 5"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_PRIORITY streamId == 0");
                    }
                    RealBufferedSource realBufferedSource = this.source;
                    realBufferedSource.readInt();
                    realBufferedSource.readByte();
                    return true;
                case 3:
                    if (medium != 4) {
                        throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(medium, "TYPE_RST_STREAM length: ", " != 4"));
                    }
                    if (i6 == 0) {
                        throw new IOException("TYPE_RST_STREAM streamId == 0");
                    }
                    int i7 = this.source.readInt();
                    for (int i8 : Fragment$$ExternalSyntheticOutline0.values(14)) {
                        if (Fragment$$ExternalSyntheticOutline0.ordinal(i8) == i7) {
                            i2 = i8;
                            if (i2 != 0) {
                                throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i7, "TYPE_RST_STREAM unexpected error code: "));
                            }
                            http2Connection = Http2Connection.this;
                            http2Connection.getClass();
                            if (i6 == 0 && (i5 & 1) == 0) {
                                http2Connection.pushQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(http2Connection.connectionName + '[' + i6 + "] onReset", http2Connection, i6, i2, 0), 0L);
                            } else {
                                http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i6);
                                if (http2StreamRemoveStream$okhttp != null) {
                                    http2StreamRemoveStream$okhttp.receiveRstStream(i2);
                                }
                            }
                            return true;
                        }
                    }
                    if (i2 != 0) {
                        throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i7, "TYPE_RST_STREAM unexpected error code: "));
                    }
                    http2Connection = Http2Connection.this;
                    http2Connection.getClass();
                    if (i6 == 0) {
                        http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i6);
                        if (http2StreamRemoveStream$okhttp != null) {
                            http2StreamRemoveStream$okhttp.receiveRstStream(i2);
                        }
                    } else {
                        http2StreamRemoveStream$okhttp = http2Connection.removeStream$okhttp(i6);
                        if (http2StreamRemoveStream$okhttp != null) {
                            http2StreamRemoveStream$okhttp.receiveRstStream(i2);
                        }
                    }
                    return true;
                case 4:
                    if (i6 != 0) {
                        throw new IOException("TYPE_SETTINGS streamId != 0");
                    }
                    if ((b & 1) == 0) {
                        if (medium % 6 != 0) {
                            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(medium, "TYPE_SETTINGS length % 6 != 0: "));
                        }
                        Settings settings = new Settings();
                        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, medium), 6);
                        int i9 = intProgressionStep.first;
                        int i10 = intProgressionStep.last;
                        int i11 = intProgressionStep.step;
                        if (i11 < 0 ? i9 >= i10 : i9 <= i10) {
                            while (true) {
                                RealBufferedSource realBufferedSource2 = this.source;
                                short s = realBufferedSource2.readShort();
                                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                                int i12 = s & 65535;
                                i = realBufferedSource2.readInt();
                                if (i12 != 2) {
                                    if (i12 == 3) {
                                        i12 = 4;
                                    } else if (i12 == 4) {
                                        if (i < 0) {
                                            throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                        }
                                        i12 = 7;
                                    } else if (i12 == 5 && (i < 16384 || i > 16777215)) {
                                    }
                                } else if (i != 0 && i != 1) {
                                    throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                                }
                                settings.set(i12, i);
                                if (i9 != i10) {
                                    i9 += i11;
                                }
                            }
                            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
                        }
                        Http2Connection http2Connection2 = Http2Connection.this;
                        http2Connection2.writerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), http2Connection2.connectionName, " applyAndAckSettings"), handler, settings, i2), 0L);
                    } else if (medium != 0) {
                        throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                    }
                    return true;
                case 5:
                    readPushPromise(handler, medium, i4, i6);
                    return true;
                case 6:
                    readPing(handler, medium, i4, i6);
                    return true;
                case 7:
                    readGoAway(handler, medium, i6);
                    return true;
                case 8:
                    if (medium != 4) {
                        throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(medium, "TYPE_WINDOW_UPDATE length !=4: "));
                    }
                    long j = ((long) this.source.readInt()) & 2147483647L;
                    if (j == 0) {
                        throw new IOException("windowSizeIncrement was 0");
                    }
                    if (i6 != 0) {
                        Http2Stream stream = Http2Connection.this.getStream(i6);
                        if (stream != null) {
                            synchronized (stream) {
                                stream.writeBytesMaximum += j;
                                if (j > 0) {
                                    stream.notifyAll();
                                }
                            }
                        }
                        break;
                    } else {
                        synchronized (Http2Connection.this) {
                            Http2Connection http2Connection3 = Http2Connection.this;
                            http2Connection3.writeBytesMaximum += j;
                            http2Connection3.notifyAll();
                        }
                    }
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readGoAway(Http2Connection.ReaderRunnable readerRunnable, int i, int i2) throws IOException {
        int i3;
        Http2Stream[] http2StreamArr;
        if (i < 8) {
            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "TYPE_GOAWAY length < 8: "));
        }
        if (i2 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        int i6 = i - 8;
        int[] iArrValues = Fragment$$ExternalSyntheticOutline0.values(14);
        int length = iArrValues.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                i3 = 0;
                break;
            }
            i3 = iArrValues[i7];
            if (Fragment$$ExternalSyntheticOutline0.ordinal(i3) == i5) {
                break;
            } else {
                i7++;
            }
        }
        if (i3 == 0) {
            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i5, "TYPE_GOAWAY unexpected error code: "));
        }
        ByteString debugData = ByteString.EMPTY;
        if (i6 > 0) {
            debugData = this.source.readByteString(i6);
        }
        readerRunnable.getClass();
        Intrinsics.checkNotNullParameter(debugData, "debugData");
        debugData.getSize$okio();
        synchronized (Http2Connection.this) {
            Object[] array = Http2Connection.this.streams.values().toArray(new Http2Stream[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            http2StreamArr = (Http2Stream[]) array;
            Http2Connection.this.isShutdown = true;
        }
        for (Http2Stream http2Stream : http2StreamArr) {
            if (http2Stream.id > i4 && http2Stream.isLocallyInitiated()) {
                http2Stream.receiveRstStream(8);
                Http2Connection.this.removeStream$okhttp(http2Stream.id);
            }
        }
    }

    public final List readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = i2;
        continuationSource.flags = i3;
        continuationSource.streamId = i4;
        while (true) {
            Hpack.Reader reader = this.hpackReader;
            RealBufferedSource realBufferedSource = reader.source;
            boolean zExhausted = realBufferedSource.exhausted();
            ArrayList arrayList = reader.headerList;
            if (zExhausted) {
                List list = CollectionsKt.toList(arrayList);
                arrayList.clear();
                return list;
            }
            byte b = realBufferedSource.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            int i5 = b & 255;
            if (i5 == 128) {
                throw new IOException("index == 0");
            }
            if ((b & 128) == 128) {
                int i6 = reader.readInt(i5, 127);
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                    if (i7 <= headerArr.length - 1) {
                        arrayList.add(headerArr[i7]);
                    }
                }
                int length = reader.nextHeaderIndex + 1 + (i7 - Hpack.STATIC_HEADER_TABLE.length);
                if (length >= 0) {
                    Header[] headerArr2 = reader.dynamicTable;
                    if (length < headerArr2.length) {
                        Header header = headerArr2[length];
                        Intrinsics.checkNotNull(header);
                        arrayList.add(header);
                    }
                }
                throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i6, "Header index too large "));
            }
            if (i5 == 64) {
                Header[] headerArr3 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString = reader.readByteString();
                Hpack.checkLowercase(byteString);
                reader.insertIntoDynamicTable(new Header(byteString, reader.readByteString()));
            } else if ((b & 64) == 64) {
                reader.insertIntoDynamicTable(new Header(reader.getName(reader.readInt(i5, 63) - 1), reader.readByteString()));
            } else if ((b & 32) == 32) {
                int i8 = reader.readInt(i5, 31);
                reader.maxDynamicTableByteCount = i8;
                if (i8 < 0 || i8 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + reader.maxDynamicTableByteCount);
                }
                int i9 = reader.dynamicTableByteCount;
                if (i8 < i9) {
                    if (i8 == 0) {
                        Header[] headerArr4 = reader.dynamicTable;
                        ArraysKt.fill(headerArr4, 0, headerArr4.length);
                        reader.nextHeaderIndex = reader.dynamicTable.length - 1;
                        reader.headerCount = 0;
                        reader.dynamicTableByteCount = 0;
                    } else {
                        reader.evictToRecoverBytes(i9 - i8);
                    }
                }
            } else if (i5 == 16 || i5 == 0) {
                Header[] headerArr5 = Hpack.STATIC_HEADER_TABLE;
                ByteString byteString2 = reader.readByteString();
                Hpack.checkLowercase(byteString2);
                arrayList.add(new Header(byteString2, reader.readByteString()));
            } else {
                arrayList.add(new Header(reader.getName(reader.readInt(i5, 15) - 1), reader.readByteString()));
            }
        }
    }

    public final void readHeaders(final Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        if ((i2 & 32) != 0) {
            RealBufferedSource realBufferedSource = this.source;
            realBufferedSource.readInt();
            realBufferedSource.readByte();
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            readerRunnable.getClass();
            i -= 5;
        }
        final List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i, i2, i4), i4, i2, i3);
        readerRunnable.getClass();
        Http2Connection.this.getClass();
        if (i3 != 0 && (i3 & 1) == 0) {
            Http2Connection http2Connection = Http2Connection.this;
            http2Connection.getClass();
            http2Connection.pushQueue.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(http2Connection.connectionName + '[' + i3 + "] onHeaders", http2Connection, i3, headerBlock, z), 0L);
            return;
        }
        synchronized (Http2Connection.this) {
            Http2Stream stream = Http2Connection.this.getStream(i3);
            if (stream != null) {
                stream.receiveHeaders(Util.toHeaders(headerBlock), z);
                return;
            }
            Http2Connection http2Connection2 = Http2Connection.this;
            if (http2Connection2.isShutdown) {
                return;
            }
            if (i3 <= http2Connection2.lastGoodStreamId) {
                return;
            }
            if (i3 % 2 == http2Connection2.nextStreamId % 2) {
                return;
            }
            final Http2Stream http2Stream = new Http2Stream(i3, Http2Connection.this, false, z, Util.toHeaders(headerBlock));
            Http2Connection http2Connection3 = Http2Connection.this;
            http2Connection3.lastGoodStreamId = i3;
            http2Connection3.streams.put(Integer.valueOf(i3), http2Stream);
            TaskQueue taskQueueNewQueue = Http2Connection.this.taskRunner.newQueue();
            final String str = Http2Connection.this.connectionName + '[' + i3 + "] onStream";
            taskQueueNewQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$$inlined$synchronized$lambda$1
                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() {
                    try {
                        Http2Connection.this.listener.onStream(http2Stream);
                        return -1L;
                    } catch (IOException e) {
                        Platform platform = Platform.platform;
                        Platform platform2 = Platform.platform;
                        String str2 = "Http2Connection.Listener failure for " + Http2Connection.this.connectionName;
                        platform2.getClass();
                        Platform.log(4, str2, e);
                        try {
                            http2Stream.close(e, 2);
                            return -1L;
                        } catch (IOException unused) {
                            return -1L;
                        }
                    }
                }
            }, 0L);
        }
    }

    public final void readPing(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "TYPE_PING length != 8: "));
        }
        if (i3 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        if ((i2 & 1) == 0) {
            Http2Connection.this.writerQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), Http2Connection.this.connectionName, " ping"), readerRunnable, i4, i5, 2), 0L);
            return;
        }
        synchronized (Http2Connection.this) {
            try {
                if (i4 == 1) {
                    Http2Connection.this.intervalPongsReceived++;
                } else if (i4 == 2) {
                    Http2Connection.this.degradedPongsReceived++;
                } else if (i4 == 3) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.getClass();
                    http2Connection.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void readPushPromise(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, int i3) throws IOException {
        int i4;
        if (i3 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        int i5 = this.source.readInt() & Integer.MAX_VALUE;
        List headerBlock = readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, i4), i4, i2, i3);
        readerRunnable.getClass();
        Http2Connection http2Connection = Http2Connection.this;
        http2Connection.getClass();
        synchronized (http2Connection) {
            if (http2Connection.currentPushRequests.contains(Integer.valueOf(i5))) {
                http2Connection.writeSynResetLater$okhttp(i5, 2);
                return;
            }
            http2Connection.currentPushRequests.add(Integer.valueOf(i5));
            http2Connection.pushQueue.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$1(http2Connection.connectionName + '[' + i5 + "] onRequest", http2Connection, i5, headerBlock), 0L);
        }
    }

    public final void readData(Http2Connection.ReaderRunnable readerRunnable, int i, int i2, final int i3) throws IOException {
        int i4;
        Http2Stream http2Stream;
        boolean z;
        boolean z2;
        long j;
        if (i3 == 0) {
            throw new IOException(yzwzcWHcnH.RZJFHhQbWUWB);
        }
        final boolean z3 = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        if ((i2 & 8) != 0) {
            byte b = this.source.readByte();
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            i4 = b & 255;
        } else {
            i4 = 0;
        }
        final int iLengthWithoutPadding = Companion.lengthWithoutPadding(i, i2, i4);
        RealBufferedSource source = this.source;
        readerRunnable.getClass();
        Intrinsics.checkNotNullParameter(source, "source");
        Http2Connection.this.getClass();
        if (i3 != 0 && (i3 & 1) == 0) {
            final Http2Connection http2Connection = Http2Connection.this;
            http2Connection.getClass();
            final Buffer buffer = new Buffer();
            long j2 = iLengthWithoutPadding;
            source.require(j2);
            source.read(buffer, j2);
            final String str = http2Connection.connectionName + '[' + i3 + "] onData";
            http2Connection.pushQueue.schedule(new Task(str, http2Connection, i3, buffer, iLengthWithoutPadding, z3) { // from class: okhttp3.internal.http2.Http2Connection$pushDataLater$$inlined$execute$1
                public final /* synthetic */ Buffer $buffer$inlined;
                public final /* synthetic */ int $byteCount$inlined;
                public final /* synthetic */ int $streamId$inlined;
                public final /* synthetic */ Http2Connection this$0;

                @Override // okhttp3.internal.concurrent.Task
                public final long runOnce() {
                    try {
                        PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = this.this$0.pushObserver;
                        Buffer buffer2 = this.$buffer$inlined;
                        int i5 = this.$byteCount$inlined;
                        pushObserver$Companion$PushObserverCancel.getClass();
                        buffer2.skip(i5);
                        this.this$0.writer.rstStream(this.$streamId$inlined, 9);
                        synchronized (this.this$0) {
                            this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                        }
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }, 0L);
        } else {
            Http2Stream stream = Http2Connection.this.getStream(i3);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(i3, 2);
                long j3 = iLengthWithoutPadding;
                Http2Connection.this.updateConnectionFlowControl$okhttp(j3);
                source.skip(j3);
            } else {
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                Http2Stream.FramingSource framingSource = stream.source;
                long j4 = iLengthWithoutPadding;
                framingSource.getClass();
                while (true) {
                    if (j4 <= 0) {
                        http2Stream = stream;
                        break;
                    }
                    synchronized (Http2Stream.this) {
                        z = framingSource.finished;
                        http2Stream = stream;
                        z2 = framingSource.readBuffer.size + j4 > framingSource.maxByteCount;
                    }
                    if (z2) {
                        source.skip(j4);
                        Http2Stream.this.closeLater(4);
                        break;
                    }
                    if (z) {
                        source.skip(j4);
                        break;
                    }
                    long j5 = source.read(framingSource.receiveBuffer, j4);
                    if (j5 == -1) {
                        throw new EOFException();
                    }
                    j4 -= j5;
                    synchronized (Http2Stream.this) {
                        try {
                            if (framingSource.closed) {
                                Buffer buffer2 = framingSource.receiveBuffer;
                                j = buffer2.size;
                                buffer2.skip(j);
                            } else {
                                Buffer buffer3 = framingSource.readBuffer;
                                boolean z4 = buffer3.size == 0;
                                buffer3.writeAll(framingSource.receiveBuffer);
                                if (z4) {
                                    Http2Stream http2Stream2 = Http2Stream.this;
                                    if (http2Stream2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                                    }
                                    http2Stream2.notifyAll();
                                }
                                j = 0;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (j > 0) {
                        framingSource.updateConnectionFlowControl(j);
                    }
                    stream = http2Stream;
                }
                if (z3) {
                    http2Stream.receiveHeaders(Util.EMPTY_HEADERS, true);
                }
            }
        }
        this.source.skip(i4);
    }
}
