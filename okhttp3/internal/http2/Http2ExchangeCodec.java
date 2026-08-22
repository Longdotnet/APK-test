package okhttp3.internal.http2;

import androidx.work.WorkContinuation;
import com.google.common.base.Splitter;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okio.ByteString;
import okio.Sink;
import okio.SocketAsyncTimeout;
import okio.Source;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2ExchangeCodec implements ExchangeCodec {
    public static final List HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    public static final List HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");
    public volatile boolean canceled;
    public final RealInterceptorChain chain;
    public final RealConnection connection;
    public final Http2Connection http2Connection;
    public final Protocol protocol;
    public volatile Http2Stream stream;

    public Http2ExchangeCodec(OkHttpClient client, RealConnection connection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection;
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = client.protocols.contains(protocol) ? protocol : Protocol.HTTP_2;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(9);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Sink createRequestBody(Request request, long j) {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.getSink();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void finishRequest() throws IOException {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        http2Stream.getSink().close();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void flushRequest() {
        this.http2Connection.flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Source openResponseBodySource(Response response) {
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        return http2Stream.source;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final Response.Builder readResponseHeaders(boolean z) throws IOException {
        Headers headers;
        Http2Stream http2Stream = this.stream;
        Intrinsics.checkNotNull(http2Stream);
        synchronized (http2Stream) {
            http2Stream.readTimeout.enter();
            while (http2Stream.headersQueue.isEmpty() && http2Stream.errorCode == 0) {
                try {
                    http2Stream.waitForIo$okhttp();
                } catch (Throwable th) {
                    http2Stream.readTimeout.exitAndThrowIfTimedOut();
                    throw th;
                }
            }
            http2Stream.readTimeout.exitAndThrowIfTimedOut();
            if (http2Stream.headersQueue.isEmpty()) {
                IOException iOException = http2Stream.errorException;
                if (iOException != null) {
                    throw iOException;
                }
                int i = http2Stream.errorCode;
                BarcodeFormat$EnumUnboxingLocalUtility.m110m(i);
                throw new StreamResetException(i);
            }
            Object objRemoveFirst = http2Stream.headersQueue.removeFirst();
            Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "headersQueue.removeFirst()");
            headers = (Headers) objRemoveFirst;
        }
        Protocol protocol = this.protocol;
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        ArrayList arrayList = new ArrayList(20);
        int size = headers.size();
        Splitter splitter = null;
        for (int i2 = 0; i2 < size; i2++) {
            String name = headers.name(i2);
            String value = headers.value(i2);
            if (Intrinsics.areEqual(name, ":status")) {
                splitter = WorkContinuation.parse("HTTP/1.1 " + value);
            } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(value, "value");
                arrayList.add(name);
                arrayList.add(StringsKt__StringsKt.trim(value).toString());
            }
        }
        if (splitter == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        Response.Builder builder = new Response.Builder();
        builder.protocol = protocol;
        builder.code = splitter.limit;
        builder.message = (String) splitter.strategy;
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Headers.Builder builder2 = new Headers.Builder();
        ArrayList arrayList2 = builder2.namesAndValues;
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        arrayList2.addAll(ArraysKt.asList((String[]) array));
        builder.headers = builder2;
        if (z && builder.code == 100) {
            return null;
        }
        return builder;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final long reportedContentLength(Response response) {
        if (HttpHeaders.promisesBody(response)) {
            return Util.headersContentLength(response);
        }
        return 0L;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public final void writeRequestHeaders(Request request) throws IOException {
        int i;
        Http2Stream http2Stream;
        if (this.stream != null) {
            return;
        }
        boolean z = true;
        boolean z2 = ((RequestBody) request.body) != null;
        Headers headers = (Headers) request.headers;
        ArrayList arrayList = new ArrayList(headers.size() + 4);
        arrayList.add(new Header(Header.TARGET_METHOD, (String) request.method));
        ByteString byteString = Header.TARGET_PATH;
        HttpUrl url = (HttpUrl) request.url;
        Intrinsics.checkNotNullParameter(url, "url");
        String strEncodedPath = url.encodedPath();
        String strEncodedQuery = url.encodedQuery();
        if (strEncodedQuery != null) {
            strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
        }
        arrayList.add(new Header(byteString, strEncodedPath));
        String str = ((Headers) request.headers).get("Host");
        if (str != null) {
            arrayList.add(new Header(Header.TARGET_AUTHORITY, str));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, url.scheme));
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            String strName = headers.name(i2);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
            if (strName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (lowerCase.equals("te") && Intrinsics.areEqual(headers.value(i2), "trailers"))) {
                arrayList.add(new Header(lowerCase, headers.value(i2)));
            }
        }
        Http2Connection http2Connection = this.http2Connection;
        http2Connection.getClass();
        boolean z3 = !z2;
        synchronized (http2Connection.writer) {
            synchronized (http2Connection) {
                try {
                    if (http2Connection.nextStreamId > 1073741823) {
                        http2Connection.shutdown(8);
                    }
                    if (http2Connection.isShutdown) {
                        throw new ConnectionShutdownException();
                    }
                    i = http2Connection.nextStreamId;
                    http2Connection.nextStreamId = i + 2;
                    http2Stream = new Http2Stream(i, http2Connection, z3, false, null);
                    if (z2 && http2Connection.writeBytesTotal < http2Connection.writeBytesMaximum && http2Stream.writeBytesTotal < http2Stream.writeBytesMaximum) {
                        z = false;
                    }
                    if (http2Stream.isOpen()) {
                        http2Connection.streams.put(Integer.valueOf(i), http2Stream);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            http2Connection.writer.headers(z3, i, arrayList);
        }
        if (z) {
            http2Connection.writer.flush();
        }
        this.stream = http2Stream;
        if (this.canceled) {
            Http2Stream http2Stream2 = this.stream;
            Intrinsics.checkNotNull(http2Stream2);
            http2Stream2.closeLater(9);
            throw new IOException("Canceled");
        }
        Http2Stream http2Stream3 = this.stream;
        Intrinsics.checkNotNull(http2Stream3);
        SocketAsyncTimeout socketAsyncTimeout = http2Stream3.readTimeout;
        long j = this.chain.readTimeoutMillis;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        socketAsyncTimeout.timeout(j, timeUnit);
        Http2Stream http2Stream4 = this.stream;
        Intrinsics.checkNotNull(http2Stream4);
        http2Stream4.writeTimeout.timeout(this.chain.writeTimeoutMillis, timeUnit);
    }
}
