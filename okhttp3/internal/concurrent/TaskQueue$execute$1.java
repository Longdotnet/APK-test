package okhttp3.internal.concurrent;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue$execute$1 extends Task {
    public final /* synthetic */ Object $block;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TaskQueue$execute$1(String str, int i, Object obj) {
        super(str, true);
        this.$r8$classId = i;
        this.$block = obj;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        switch (this.$r8$classId) {
            case 0:
                ((Http2Connection.ReaderRunnable) this.$block).invoke();
                return -1L;
            case 1:
                RealConnectionPool realConnectionPool = (RealConnectionPool) this.$block;
                long jNanoTime = System.nanoTime();
                int i = 0;
                long j = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int i2 = 0;
                for (RealConnection connection : (ConcurrentLinkedQueue) realConnectionPool.connections) {
                    Intrinsics.checkNotNullExpressionValue(connection, "connection");
                    synchronized (connection) {
                        if (realConnectionPool.pruneAndGetAllocationCount(connection, jNanoTime) > 0) {
                            i2++;
                        } else {
                            i++;
                            long j2 = jNanoTime - connection.idleAtNs;
                            if (j2 > j) {
                                realConnection = connection;
                                j = j2;
                            }
                        }
                    }
                }
                long j3 = realConnectionPool.keepAliveDurationNs;
                if (j < j3 && i <= 5) {
                    if (i > 0) {
                        return j3 - j;
                    }
                    if (i2 > 0) {
                        return j3;
                    }
                    return -1L;
                }
                Intrinsics.checkNotNull(realConnection);
                synchronized (realConnection) {
                    if (!realConnection.calls.isEmpty()) {
                        return 0L;
                    }
                    if (realConnection.idleAtNs + j != jNanoTime) {
                        return 0L;
                    }
                    realConnection.noNewExchanges = true;
                    ((ConcurrentLinkedQueue) realConnectionPool.connections).remove(realConnection);
                    Socket socket = realConnection.socket;
                    Intrinsics.checkNotNull(socket);
                    Util.closeQuietly(socket);
                    if (!((ConcurrentLinkedQueue) realConnectionPool.connections).isEmpty()) {
                        return 0L;
                    }
                    ((TaskQueue) realConnectionPool.cleanupQueue).cancelAll();
                    return 0L;
                }
            default:
                Http2Connection http2Connection = (Http2Connection) this.$block;
                http2Connection.getClass();
                try {
                    http2Connection.writer.ping(2, 0, false);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, Http2Connection http2Connection) {
        super(str, true);
        this.$r8$classId = 2;
        this.$block = http2Connection;
    }
}
