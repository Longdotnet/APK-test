package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: loaded from: classes3.dex */
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        RealCall call = realInterceptorChain.call;
        call.getClass();
        synchronized (call) {
            try {
                if (!call.expectMoreExchanges) {
                    throw new IllegalStateException("released");
                }
                if (call.responseBodyOpen) {
                    throw new IllegalStateException("Check failed.");
                }
                if (call.requestBodyOpen) {
                    throw new IllegalStateException("Check failed.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ExchangeFinder finder = call.exchangeFinder;
        Intrinsics.checkNotNull(finder);
        OkHttpClient client = call.client;
        Intrinsics.checkNotNullParameter(client, "client");
        try {
            ExchangeCodec exchangeCodecNewCodec$okhttp = finder.findHealthyConnection(realInterceptorChain.connectTimeoutMillis, realInterceptorChain.readTimeoutMillis, realInterceptorChain.writeTimeoutMillis, client.retryOnConnectionFailure, !Intrinsics.areEqual((String) realInterceptorChain.request.method, "GET")).newCodec$okhttp(client, realInterceptorChain);
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(finder, "finder");
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.readyAsyncCalls = call;
            dispatcher.runningAsyncCalls = finder;
            dispatcher.runningSyncCalls = exchangeCodecNewCodec$okhttp;
            dispatcher.executorServiceOrNull = exchangeCodecNewCodec$okhttp.getConnection();
            call.interceptorScopedExchange = dispatcher;
            call.exchange = dispatcher;
            synchronized (call) {
                call.requestBodyOpen = true;
                call.responseBodyOpen = true;
            }
            if (call.canceled) {
                throw new IOException("Canceled");
            }
            return RealInterceptorChain.copy$okhttp$default(realInterceptorChain, 0, dispatcher, null, 61).proceed(realInterceptorChain.request);
        } catch (IOException e) {
            finder.trackFailure(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            finder.trackFailure(e2.lastConnectException);
            throw e2;
        }
    }
}
