package okhttp3.internal.http2;

import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.Buffer;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final PushObserver$Companion$PushObserverCancel pushObserver;
    public final TaskQueue pushQueue;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final Socket socket;
    public final LinkedHashMap streams = new LinkedHashMap();
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    public abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public void onSettings(Http2Connection connection, Settings settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void onStream(Http2Stream http2Stream);
    }

    public final class ReaderRunnable implements Function0 {
        public final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            this.reader = http2Reader;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Http2Connection http2Connection = Http2Connection.this;
            Http2Reader http2Reader = this.reader;
            try {
                if (!http2Reader.nextFrame(true, this)) {
                    throw new IOException("Required SETTINGS preface not received");
                }
                while (http2Reader.nextFrame(false, this)) {
                }
                http2Connection.close$okhttp(1, 9, null);
                Util.closeQuietly(http2Reader);
                return Unit.INSTANCE;
            } catch (IOException e) {
                http2Connection.close$okhttp(2, 2, e);
            } catch (Throwable th) {
                http2Connection.close$okhttp(3, 3, null);
                Util.closeQuietly(http2Reader);
                throw th;
            }
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(1, 9, null);
    }

    public final void close$okhttp(int i, int i2, IOException iOException) {
        int i3;
        Http2Stream[] http2StreamArr;
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, "connectionCode");
        BarcodeFormat$EnumUnboxingLocalUtility.m(i2, "streamCode");
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        try {
            shutdown(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    http2StreamArr = null;
                } else {
                    Object[] array = this.streams.values().toArray(new Http2Stream[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    http2StreamArr = (Http2Stream[]) array;
                    this.streams.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(iOException, i2);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    public final synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    public final synchronized boolean isHealthy(long j) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final void shutdown(int i) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, "statusCode");
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                this.writer.goAway(this.lastGoodStreamId, Util.EMPTY_BYTE_ARRAY, i);
            }
        }
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    public final void writeData(int i, boolean z, Buffer buffer, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.writeBytesTotal;
                            j3 = this.writeBytesMaximum;
                            if (j2 >= j3) {
                                if (!this.streams.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.writer.maxFrameSize);
                j4 = iMin;
                this.writeBytesTotal += j4;
            }
            j -= j4;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    public final void writeSynResetLater$okhttp(int i, int i2) {
        BarcodeFormat$EnumUnboxingLocalUtility.m(i2, "errorCode");
        this.writerQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$1(this.connectionName + '[' + i + "] writeSynReset", this, i, i2, 1), 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        final String str = this.connectionName + '[' + i + "] windowUpdate";
        this.writerQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                Http2Connection http2Connection = this;
                try {
                    http2Connection.writer.windowUpdate(i, j);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
            }
        }, 0L);
    }

    public Http2Connection(Request request) {
        this.listener = (Listener) request.body;
        String str = (String) request.method;
        if (str != null) {
            this.connectionName = str;
            this.nextStreamId = 3;
            TaskRunner taskRunner = (TaskRunner) request.tags;
            this.taskRunner = taskRunner;
            this.writerQueue = taskRunner.newQueue();
            this.pushQueue = taskRunner.newQueue();
            this.settingsListenerQueue = taskRunner.newQueue();
            this.pushObserver = PushObserver$Companion$PushObserverCancel.CANCEL;
            Settings settings = new Settings();
            settings.set(7, 16777216);
            this.okHttpSettings = settings;
            Settings settings2 = DEFAULT_SETTINGS;
            this.peerSettings = settings2;
            this.writeBytesMaximum = settings2.getInitialWindowSize();
            Socket socket = (Socket) request.lazyCacheControl;
            if (socket != null) {
                this.socket = socket;
                RealBufferedSink realBufferedSink = (RealBufferedSink) request.headers;
                if (realBufferedSink != null) {
                    this.writer = new Http2Writer(realBufferedSink);
                    RealBufferedSource realBufferedSource = (RealBufferedSource) request.url;
                    if (realBufferedSource != null) {
                        this.readerRunnable = new ReaderRunnable(new Http2Reader(realBufferedSource));
                        this.currentPushRequests = new LinkedHashSet();
                        return;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException(FirebaseAnalytics.Param.SOURCE);
                        throw null;
                    }
                }
                Intrinsics.throwUninitializedPropertyAccessException(UUFMQdNK.eSKzMtSraqs);
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionName");
        throw null;
    }
}
