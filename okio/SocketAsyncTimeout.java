package okio;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import okhttp3.Dispatcher;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;

/* JADX INFO: loaded from: classes3.dex */
public final class SocketAsyncTimeout extends AsyncTimeout {
    public final /* synthetic */ int $r8$classId;
    public final Object socket;

    public /* synthetic */ SocketAsyncTimeout(Object obj, int i) {
        this.$r8$classId = i;
        this.socket = obj;
    }

    public void exitAndThrowIfTimedOut() throws IOException {
        if (exit()) {
            throw newTimeoutException(null);
        }
    }

    public IOException newTimeoutException(IOException iOException) {
        switch (this.$r8$classId) {
            case 0:
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            default:
                SocketTimeoutException socketTimeoutException2 = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException2.initCause(iOException);
                }
                return socketTimeoutException2;
        }
    }

    @Override // okio.AsyncTimeout
    public final void timedOut() {
        Socket socket;
        switch (this.$r8$classId) {
            case 0:
                Socket socket2 = (Socket) this.socket;
                try {
                    socket2.close();
                    return;
                } catch (AssertionError e) {
                    if (!Okio.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket2, (Throwable) e);
                    return;
                } catch (Exception e2) {
                    Okio__JvmOkioKt.logger.log(Level.WARNING, "Failed to close timed out socket " + socket2, (Throwable) e2);
                    return;
                }
            case 1:
                RealCall realCall = (RealCall) this.socket;
                if (realCall.canceled) {
                    return;
                }
                realCall.canceled = true;
                Dispatcher dispatcher = realCall.exchange;
                if (dispatcher != null) {
                    ((ExchangeCodec) dispatcher.runningSyncCalls).cancel();
                }
                RealConnection realConnection = realCall.connectionToCancel;
                if (realConnection == null || (socket = realConnection.rawSocket) == null) {
                    return;
                }
                Util.closeQuietly(socket);
                return;
            default:
                ((Http2Stream) this.socket).closeLater(9);
                Http2Connection http2Connection = ((Http2Stream) this.socket).connection;
                synchronized (http2Connection) {
                    long j = http2Connection.degradedPongsReceived;
                    long j2 = http2Connection.degradedPingsSent;
                    if (j < j2) {
                        return;
                    }
                    http2Connection.degradedPingsSent = j2 + 1;
                    http2Connection.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
                    http2Connection.writerQueue.schedule(new TaskQueue$execute$1(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder(), http2Connection.connectionName, " ping"), http2Connection), 0L);
                    return;
                }
        }
    }
}
