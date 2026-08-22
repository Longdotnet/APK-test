package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okio.SocketAsyncTimeout;

/* JADX INFO: loaded from: classes3.dex */
public final class RealCall implements Cloneable {
    public Object callStackTrace;
    public volatile boolean canceled;
    public final OkHttpClient client;
    public RealConnection connection;
    public final RealConnectionPool connectionPool;
    public volatile RealConnection connectionToCancel;
    public volatile Dispatcher exchange;
    public ExchangeFinder exchangeFinder;
    public final AtomicBoolean executed;
    public boolean expectMoreExchanges;
    public Dispatcher interceptorScopedExchange;
    public final Request originalRequest;
    public boolean requestBodyOpen;
    public boolean responseBodyOpen;
    public final SocketAsyncTimeout timeout;

    public final class CallReference extends WeakReference {
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CallReference(RealCall referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.callStackTrace = obj;
        }
    }

    public RealCall(OkHttpClient client, Request request) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
        this.originalRequest = request;
        this.connectionPool = (RealConnectionPool) client.connectionPool.delegate;
        client.eventListenerFactory.getClass();
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(this, 1);
        socketAsyncTimeout.timeout(0, TimeUnit.MILLISECONDS);
        this.timeout = socketAsyncTimeout;
        this.executed = new AtomicBoolean();
        this.expectMoreExchanges = true;
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        if (this.connection != null) {
            throw new IllegalStateException("Check failed.");
        }
        this.connection = realConnection;
        realConnection.calls.add(new CallReference(this, this.callStackTrace));
    }

    public final IOException callDone(IOException iOException) {
        IOException interruptedIOException;
        Socket socketReleaseConnectionNoEvents$okhttp;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        RealConnection realConnection = this.connection;
        if (realConnection != null) {
            synchronized (realConnection) {
                socketReleaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (this.connection == null) {
                if (socketReleaseConnectionNoEvents$okhttp != null) {
                    Util.closeQuietly(socketReleaseConnectionNoEvents$okhttp);
                }
            } else if (socketReleaseConnectionNoEvents$okhttp != null) {
                throw new IllegalStateException("Check failed.");
            }
        }
        if (this.timeout.exit()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            Intrinsics.checkNotNull(interruptedIOException);
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new RealCall(this.client, this.originalRequest);
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Dispatcher dispatcher;
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released");
            }
        }
        if (z && (dispatcher = this.exchange) != null) {
            ((ExchangeCodec) dispatcher.runningSyncCalls).cancel();
            ((RealCall) dispatcher.readyAsyncCalls).messageDone$okhttp(dispatcher, true, true, null);
        }
        this.interceptorScopedExchange = null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008b  */
    public final Response getResponseWithInterceptorChain$okhttp() throws Throwable {
        ArrayList arrayList = new ArrayList();
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.interceptors);
        arrayList.add(new BridgeInterceptor(this.client));
        arrayList.add(new BridgeInterceptor(this.client.cookieJar));
        this.client.getClass();
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.INSTANCE);
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, this.client.networkInterceptors);
        arrayList.add(new CallServerInterceptor());
        Request request = this.originalRequest;
        OkHttpClient okHttpClient = this.client;
        boolean z = false;
        try {
            Response responseProceed = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.connectTimeoutMillis, okHttpClient.readTimeoutMillis, okHttpClient.writeTimeoutMillis).proceed(this.originalRequest);
            if (this.canceled) {
                Util.closeQuietly(responseProceed);
                throw new IOException("Canceled");
            }
            noMoreExchanges$okhttp(null);
            return responseProceed;
        } catch (IOException e) {
            try {
                IOException iOExceptionNoMoreExchanges$okhttp = noMoreExchanges$okhttp(e);
                if (iOExceptionNoMoreExchanges$okhttp == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw iOExceptionNoMoreExchanges$okhttp;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    noMoreExchanges$okhttp(null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                noMoreExchanges$okhttp(null);
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001b), top: B:45:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:14:0x001b), top: B:45:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final IOException messageDone$okhttp(Dispatcher exchange, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!exchange.equals(this.exchange)) {
            return iOException;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (this.requestBodyOpen) {
                        if (z) {
                            this.requestBodyOpen = false;
                        }
                        if (z2) {
                            this.responseBodyOpen = false;
                        }
                        z5 = this.requestBodyOpen;
                        if (z5) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (!z5) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    } else if (z2 || !this.responseBodyOpen) {
                        z4 = false;
                    } else {
                        if (z) {
                            this.requestBodyOpen = false;
                        }
                        if (z2) {
                            this.responseBodyOpen = false;
                        }
                        z5 = this.requestBodyOpen;
                        if (z5 || this.responseBodyOpen) {
                            z6 = false;
                        } else {
                            z6 = true;
                        }
                        if (!z5 && !this.responseBodyOpen && !this.expectMoreExchanges) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
        }
        if (z3) {
            this.exchange = null;
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                realConnection.incrementSuccessCount$okhttp();
            }
        }
        return z4 ? callDone(iOException) : iOException;
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z = true;
                }
            }
        }
        return z ? callDone(iOException) : iOException;
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = realConnection.calls;
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual((RealCall) ((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException("Check failed.");
        }
        arrayList.remove(i);
        this.connection = null;
        if (arrayList.isEmpty()) {
            realConnection.idleAtNs = System.nanoTime();
            RealConnectionPool realConnectionPool = this.connectionPool;
            realConnectionPool.getClass();
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            boolean z = realConnection.noNewExchanges;
            TaskQueue taskQueue = (TaskQueue) realConnectionPool.cleanupQueue;
            if (z) {
                realConnection.noNewExchanges = true;
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) realConnectionPool.connections;
                concurrentLinkedQueue.remove(realConnection);
                if (concurrentLinkedQueue.isEmpty()) {
                    taskQueue.cancelAll();
                }
                Socket socket = realConnection.socket;
                Intrinsics.checkNotNull(socket);
                return socket;
            }
            taskQueue.schedule((TaskQueue$execute$1) realConnectionPool.cleanupTask, 0L);
        }
        return null;
    }
}
