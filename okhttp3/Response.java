package okhttp3;

import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http.RealResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class Response implements Closeable {
    public final RealResponseBody body;
    public final Response cacheResponse;
    public final int code;
    public final Dispatcher exchange;
    public final Handshake handshake;
    public final Headers headers;
    public final String message;
    public final Response networkResponse;
    public final Response priorResponse;
    public final Protocol protocol;
    public final long receivedResponseAtMillis;
    public final Request request;
    public final long sentRequestAtMillis;

    public final class Builder {
        public RealResponseBody body;
        public Response cacheResponse;
        public Dispatcher exchange;
        public Handshake handshake;
        public String message;
        public Response networkResponse;
        public Response priorResponse;
        public Protocol protocol;
        public long receivedResponseAtMillis;
        public Request request;
        public long sentRequestAtMillis;
        public int code = -1;
        public Headers.Builder headers = new Headers.Builder();

        public static void checkSupportResponse(String str, Response response) {
            if (response != null) {
                if (response.body != null) {
                    throw new IllegalArgumentException(str.concat(".body != null").toString());
                }
                if (response.networkResponse != null) {
                    throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
                }
                if (response.cacheResponse != null) {
                    throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
                }
                if (response.priorResponse != null) {
                    throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                }
            }
        }

        public final Response build() {
            int i = this.code;
            if (i < 0) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            Request request = this.request;
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.protocol;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.message;
            if (str != null) {
                return new Response(request, protocol, str, i, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null");
        }
    }

    public Response(Request request, Protocol protocol, String message, int i, Handshake handshake, Headers headers, RealResponseBody realResponseBody, Response response, Response response2, Response response3, long j, long j2, Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = realResponseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = dispatcher;
    }

    public static String header$default(String str, Response response) {
        response.getClass();
        String str2 = response.headers.get(str);
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        RealResponseBody realResponseBody = this.body;
        if (realResponseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        realResponseBody.close();
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.request = this.request;
        builder.protocol = this.protocol;
        builder.code = this.code;
        builder.message = this.message;
        builder.handshake = this.handshake;
        builder.headers = this.headers.newBuilder();
        builder.body = this.body;
        builder.networkResponse = this.networkResponse;
        builder.cacheResponse = this.cacheResponse;
        builder.priorResponse = this.priorResponse;
        builder.sentRequestAtMillis = this.sentRequestAtMillis;
        builder.receivedResponseAtMillis = this.receivedResponseAtMillis;
        builder.exchange = this.exchange;
        return builder;
    }

    public final String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + ((HttpUrl) this.request.url) + '}';
    }
}
