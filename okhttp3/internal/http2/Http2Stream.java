package okhttp3.internal.http2;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.Sink;
import okio.SocketAsyncTimeout;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Stream {
    public final Http2Connection connection;
    public int errorCode;
    public IOException errorException;
    public boolean hasResponseHeaders;
    public final ArrayDeque headersQueue;
    public final int id;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final SocketAsyncTimeout readTimeout;
    public final FramingSink sink;
    public final FramingSource source;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final SocketAsyncTimeout writeTimeout;

    public final class FramingSink implements Sink {
        public boolean closed;
        public final boolean finished;
        public final Buffer sendBuffer = new Buffer();

        public FramingSink(boolean z) {
            this.finished = z;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                if (this.closed) {
                    return;
                }
                boolean z = Http2Stream.this.getErrorCode$okhttp() == 0;
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.sink.finished) {
                    if (this.sendBuffer.size > 0) {
                        while (this.sendBuffer.size > 0) {
                            emitFrame(true);
                        }
                    } else if (z) {
                        http2Stream2.connection.writeData(http2Stream2.id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        public final void emitFrame(boolean z) throws IOException {
            long jMin;
            boolean z2;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (true) {
                    try {
                        Http2Stream http2Stream = Http2Stream.this;
                        if (http2Stream.writeBytesTotal < http2Stream.writeBytesMaximum || this.finished || this.closed || http2Stream.getErrorCode$okhttp() != 0) {
                            break;
                        } else {
                            Http2Stream.this.waitForIo$okhttp();
                        }
                    } catch (Throwable th) {
                        Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed$okhttp();
                Http2Stream http2Stream2 = Http2Stream.this;
                jMin = Math.min(http2Stream2.writeBytesMaximum - http2Stream2.writeBytesTotal, this.sendBuffer.size);
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.writeBytesTotal += jMin;
                z2 = z && jMin == this.sendBuffer.size && http2Stream3.getErrorCode$okhttp() == 0;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream http2Stream4 = Http2Stream.this;
                http2Stream4.connection.writeData(http2Stream4.id, z2, this.sendBuffer, jMin);
            } finally {
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            synchronized (http2Stream) {
                Http2Stream.this.checkOutNotClosed$okhttp();
            }
            while (this.sendBuffer.size > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public final Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public final void write(Buffer buffer, long j) throws IOException {
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            Buffer buffer2 = this.sendBuffer;
            buffer2.write(buffer, j);
            while (buffer2.size >= 16384) {
                emitFrame(false);
            }
        }
    }

    public final class FramingSource implements Source {
        public boolean closed;
        public boolean finished;
        public final long maxByteCount;
        public final Buffer receiveBuffer = new Buffer();
        public final Buffer readBuffer = new Buffer();

        public FramingSource(long j, boolean z) {
            this.maxByteCount = j;
            this.finished = z;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            long j;
            synchronized (Http2Stream.this) {
                this.closed = true;
                Buffer buffer = this.readBuffer;
                j = buffer.size;
                buffer.skip(j);
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Stream.notifyAll();
            }
            if (j > 0) {
                updateConnectionFlowControl(j);
            }
            Http2Stream.this.cancelStreamIfNecessary$okhttp();
        }

        @Override // okio.Source
        public final long read(Buffer sink, long j) throws Throwable {
            Throwable streamResetException;
            long j2;
            boolean z;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j3 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
            }
            while (true) {
                synchronized (Http2Stream.this) {
                    Http2Stream.this.readTimeout.enter();
                    try {
                        if (Http2Stream.this.getErrorCode$okhttp() != 0) {
                            streamResetException = Http2Stream.this.errorException;
                            if (streamResetException == null) {
                                int errorCode$okhttp = Http2Stream.this.getErrorCode$okhttp();
                                BarcodeFormat$EnumUnboxingLocalUtility.m110m(errorCode$okhttp);
                                streamResetException = new StreamResetException(errorCode$okhttp);
                            }
                        } else {
                            streamResetException = null;
                        }
                        if (this.closed) {
                            throw new IOException("stream closed");
                        }
                        Buffer buffer = this.readBuffer;
                        long j4 = buffer.size;
                        if (j4 > j3) {
                            j2 = buffer.read(sink, Math.min(j, j4));
                            Http2Stream http2Stream = Http2Stream.this;
                            long j5 = http2Stream.readBytesTotal + j2;
                            http2Stream.readBytesTotal = j5;
                            long j6 = j5 - http2Stream.readBytesAcknowledged;
                            if (streamResetException == null && j6 >= http2Stream.connection.okHttpSettings.getInitialWindowSize() / 2) {
                                Http2Stream http2Stream2 = Http2Stream.this;
                                http2Stream2.connection.writeWindowUpdateLater$okhttp(http2Stream2.id, j6);
                                Http2Stream http2Stream3 = Http2Stream.this;
                                http2Stream3.readBytesAcknowledged = http2Stream3.readBytesTotal;
                            }
                        } else {
                            if (this.finished || streamResetException != null) {
                                j2 = -1;
                            } else {
                                Http2Stream.this.waitForIo$okhttp();
                                z = true;
                                j2 = -1;
                            }
                            Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        }
                        z = false;
                        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                    } catch (Throwable th) {
                        Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                    throw th;
                }
                if (!z) {
                    if (j2 != -1) {
                        updateConnectionFlowControl(j2);
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }

        public final void updateConnectionFlowControl(long j) {
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            Http2Stream.this.connection.updateConnectionFlowControl$okhttp(j);
        }
    }

    public Http2Stream(int i, Http2Connection connection, boolean z, boolean z2, Headers headers) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.id = i;
        this.connection = connection;
        this.writeBytesMaximum = connection.peerSettings.getInitialWindowSize();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(connection.okHttpSettings.getInitialWindowSize(), z2);
        this.sink = new FramingSink(z);
        int i2 = 2;
        this.readTimeout = new SocketAsyncTimeout(this, i2);
        this.writeTimeout = new SocketAsyncTimeout(this, i2);
        if (headers == null) {
            if (!isLocallyInitiated()) {
                throw new IllegalStateException("remotely-initiated streams should have headers");
            }
        } else {
            if (isLocallyInitiated()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001b  */
    public final void cancelStreamIfNecessary$okhttp() {
        boolean z;
        boolean zIsOpen;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                FramingSource framingSource = this.source;
                if (framingSource.finished || !framingSource.closed) {
                    z = false;
                } else {
                    FramingSink framingSink = this.sink;
                    if (framingSink.finished || framingSink.closed) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                zIsOpen = isOpen();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            close(null, 9);
        } else {
            if (zIsOpen) {
                return;
            }
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        if (this.errorCode != 0) {
            IOException iOException = this.errorException;
            if (iOException != null) {
                throw iOException;
            }
            int i = this.errorCode;
            BarcodeFormat$EnumUnboxingLocalUtility.m110m(i);
            throw new StreamResetException(i);
        }
    }

    public final void close(IOException iOException, int i) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, "rstStatusCode");
        if (closeInternal(iOException, i)) {
            Http2Connection http2Connection = this.connection;
            http2Connection.getClass();
            BarcodeFormat$EnumUnboxingLocalUtility.m(i, "statusCode");
            http2Connection.writer.rstStream(this.id, i);
        }
    }

    public final boolean closeInternal(IOException iOException, int i) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            if (this.errorCode != 0) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = i;
            this.errorException = iOException;
            notifyAll();
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void closeLater(int i) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, "errorCode");
        if (closeInternal(null, i)) {
            this.connection.writeSynResetLater$okhttp(this.id, i);
        }
    }

    public final synchronized int getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final FramingSink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public final boolean isLocallyInitiated() {
        boolean z = (this.id & 1) == 1;
        this.connection.getClass();
        return true == z;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != 0) {
            return false;
        }
        FramingSource framingSource = this.source;
        if (framingSource.finished || framingSource.closed) {
            FramingSink framingSink = this.sink;
            if ((framingSink.finished || framingSink.closed) && this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public final void receiveHeaders(Headers headers, boolean z) {
        boolean zIsOpen;
        Intrinsics.checkNotNullParameter(headers, "headers");
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        synchronized (this) {
            try {
                if (this.hasResponseHeaders && z) {
                    this.source.getClass();
                } else {
                    this.hasResponseHeaders = true;
                    this.headersQueue.add(headers);
                }
                if (z) {
                    this.source.finished = true;
                }
                zIsOpen = isOpen();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zIsOpen) {
            return;
        }
        this.connection.removeStream$okhttp(this.id);
    }

    public final synchronized void receiveRstStream(int i) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, "errorCode");
        if (this.errorCode == 0) {
            this.errorCode = i;
            notifyAll();
        }
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
