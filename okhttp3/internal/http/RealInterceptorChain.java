package okhttp3.internal.http;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: loaded from: classes3.dex */
public final class RealInterceptorChain {
    public final RealCall call;
    public int calls;
    public final int connectTimeoutMillis;
    public final Dispatcher exchange;
    public final int index;
    public final ArrayList interceptors;
    public final int readTimeoutMillis;
    public final Request request;
    public final int writeTimeoutMillis;

    public RealInterceptorChain(RealCall call, ArrayList arrayList, int i, Dispatcher dispatcher, Request request, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.call = call;
        this.interceptors = arrayList;
        this.index = i;
        this.exchange = dispatcher;
        this.request = request;
        this.connectTimeoutMillis = i2;
        this.readTimeoutMillis = i3;
        this.writeTimeoutMillis = i4;
    }

    public static RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i, Dispatcher dispatcher, Request request, int i2) {
        if ((i2 & 1) != 0) {
            i = realInterceptorChain.index;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            dispatcher = realInterceptorChain.exchange;
        }
        Dispatcher dispatcher2 = dispatcher;
        if ((i2 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        int i4 = realInterceptorChain.connectTimeoutMillis;
        int i5 = realInterceptorChain.readTimeoutMillis;
        int i6 = realInterceptorChain.writeTimeoutMillis;
        realInterceptorChain.getClass();
        Intrinsics.checkNotNullParameter(request2, "request");
        return new RealInterceptorChain(realInterceptorChain.call, realInterceptorChain.interceptors, i3, dispatcher2, request2, i4, i5, i6);
    }

    public final Response proceed(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ArrayList arrayList = this.interceptors;
        int size = arrayList.size();
        int i = this.index;
        if (i >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.calls++;
        Dispatcher dispatcher = this.exchange;
        if (dispatcher != null) {
            if (!((ExchangeFinder) dispatcher.runningAsyncCalls).sameHostAndPort((HttpUrl) request.url)) {
                throw new IllegalStateException(("network interceptor " + ((Interceptor) arrayList.get(i - 1)) + " must retain the same host and port").toString());
            }
            if (this.calls != 1) {
                throw new IllegalStateException(("network interceptor " + ((Interceptor) arrayList.get(i - 1)) + " must call proceed() exactly once").toString());
            }
        }
        int i2 = i + 1;
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, i2, null, request, 58);
        Interceptor interceptor = (Interceptor) arrayList.get(i);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (dispatcher != null && i2 < arrayList.size() && realInterceptorChainCopy$okhttp$default.calls != 1) {
            throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
        }
        if (responseIntercept.body != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }
}
