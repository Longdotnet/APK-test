package okhttp3.internal.connection;

import androidx.work.WorkContinuation;
import com.android.billingclient.api.zzda;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.common.base.Splitter;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http1.Http1ExchangeCodec$UnknownLengthSource;
import okio.Buffer;
import okio.DeflaterSink;
import okio.ForwardingTimeout;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public final class RouteSelector implements ExchangeCodec {
    public final Object address;
    public final Object call;
    public Object inetSocketAddresses;
    public int nextProxyIndex;
    public final Cloneable postponedRoutes;
    public final Object proxies;
    public final Object routeDatabase;

    public RouteSelector(Address address, ConnectionPool routeDatabase, RealCall call) {
        List listImmutableListOf;
        Intrinsics.checkNotNullParameter(routeDatabase, "routeDatabase");
        Intrinsics.checkNotNullParameter(call, "call");
        this.address = address;
        this.routeDatabase = routeDatabase;
        this.call = call;
        EmptyList emptyList = EmptyList.INSTANCE;
        this.proxies = emptyList;
        this.inetSocketAddresses = emptyList;
        this.postponedRoutes = new ArrayList();
        HttpUrl url = address.url;
        Intrinsics.checkNotNullParameter(url, "url");
        URI uri = url.uri();
        if (uri.getHost() == null) {
            listImmutableListOf = Util.immutableListOf(Proxy.NO_PROXY);
        } else {
            List<Proxy> listSelect = address.proxySelector.select(uri);
            listImmutableListOf = (listSelect == null || listSelect.isEmpty()) ? Util.immutableListOf(Proxy.NO_PROXY) : Util.toImmutableList(listSelect);
        }
        this.proxies = listImmutableListOf;
        this.nextProxyIndex = 0;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        Socket socket = ((RealConnection) this.address).rawSocket;
        if (socket != null) {
            Util.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Sink createRequestBody(Request request, long j) {
        if ("chunked".equalsIgnoreCase(((Headers) request.headers).get("Transfer-Encoding"))) {
            if (this.nextProxyIndex == 1) {
                this.nextProxyIndex = 2;
                return new Sink() { // from class: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSink
                    public boolean closed;
                    public final ForwardingTimeout timeout;

                    {
                        this.timeout = new ForwardingTimeout(((RealBufferedSink) this.this$0.call).sink.timeout());
                    }

                    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                    public final synchronized void close() {
                        if (this.closed) {
                            return;
                        }
                        this.closed = true;
                        ((RealBufferedSink) this.this$0.call).writeUtf8("0\r\n\r\n");
                        RouteSelector routeSelector = this.this$0;
                        ForwardingTimeout forwardingTimeout = this.timeout;
                        routeSelector.getClass();
                        Timeout timeout = forwardingTimeout.delegate;
                        forwardingTimeout.delegate = Timeout.NONE;
                        timeout.clearDeadline();
                        timeout.clearTimeout();
                        this.this$0.nextProxyIndex = 3;
                    }

                    @Override // okio.Sink, java.io.Flushable
                    public final synchronized void flush() {
                        if (this.closed) {
                            return;
                        }
                        ((RealBufferedSink) this.this$0.call).flush();
                    }

                    @Override // okio.Sink
                    public final Timeout timeout() {
                        return this.timeout;
                    }

                    @Override // okio.Sink
                    public final void write(Buffer buffer, long j2) {
                        if (this.closed) {
                            throw new IllegalStateException("closed");
                        }
                        if (j2 == 0) {
                            return;
                        }
                        RouteSelector routeSelector = this.this$0;
                        RealBufferedSink realBufferedSink = (RealBufferedSink) routeSelector.call;
                        if (realBufferedSink.closed) {
                            throw new IllegalStateException("closed");
                        }
                        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j2);
                        realBufferedSink.emitCompleteSegments();
                        RealBufferedSink realBufferedSink2 = (RealBufferedSink) routeSelector.call;
                        realBufferedSink2.writeUtf8("\r\n");
                        realBufferedSink2.write(buffer, j2);
                        realBufferedSink2.writeUtf8("\r\n");
                    }
                };
            }
            throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
        }
        if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
        if (this.nextProxyIndex == 1) {
            this.nextProxyIndex = 2;
            return new DeflaterSink(this);
        }
        throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        ((RealBufferedSink) this.call).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        ((RealBufferedSink) this.call).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return (RealConnection) this.address;
    }

    public boolean hasNext() {
        return this.nextProxyIndex < ((List) this.proxies).size() || !((ArrayList) this.postponedRoutes).isEmpty();
    }

    public Http1ExchangeCodec$FixedLengthSource newFixedLengthSource(long j) {
        if (this.nextProxyIndex == 4) {
            this.nextProxyIndex = 5;
            return new Http1ExchangeCodec$FixedLengthSource(this, j);
        }
        throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        if ("chunked".equalsIgnoreCase(Response.header$default("Transfer-Encoding", response))) {
            final HttpUrl httpUrl = (HttpUrl) response.request.url;
            if (this.nextProxyIndex == 4) {
                this.nextProxyIndex = 5;
                return new Http1ExchangeCodec$AbstractSource(this, httpUrl) { // from class: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource
                    public long bytesRemainingInChunk;
                    public boolean hasMoreChunks;
                    public final /* synthetic */ RouteSelector this$0;
                    public final HttpUrl url;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(this);
                        Intrinsics.checkNotNullParameter(httpUrl, "url");
                        this.this$0 = this;
                        this.url = httpUrl;
                        this.bytesRemainingInChunk = -1L;
                        this.hasMoreChunks = true;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        if (this.closed) {
                            return;
                        }
                        if (this.hasMoreChunks && !Util.discard(this, TimeUnit.MILLISECONDS)) {
                            ((RealConnection) this.this$0.address).noNewExchanges$okhttp();
                            responseBodyComplete();
                        }
                        this.closed = true;
                    }

                    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
                    public final long read(Buffer sink, long j) throws IOException {
                        Intrinsics.checkNotNullParameter(sink, "sink");
                        if (j < 0) {
                            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "byteCount < 0: ").toString());
                        }
                        if (this.closed) {
                            throw new IllegalStateException(UUFMQdNK.nLJqQtXyOoQ);
                        }
                        if (!this.hasMoreChunks) {
                            return -1L;
                        }
                        long j2 = this.bytesRemainingInChunk;
                        RouteSelector routeSelector = this.this$0;
                        if (j2 == 0 || j2 == -1) {
                            if (j2 != -1) {
                                ((RealBufferedSource) routeSelector.routeDatabase).readUtf8LineStrict(Long.MAX_VALUE);
                            }
                            try {
                                this.bytesRemainingInChunk = ((RealBufferedSource) routeSelector.routeDatabase).readHexadecimalUnsignedLong();
                                String string = StringsKt__StringsKt.trim(((RealBufferedSource) routeSelector.routeDatabase).readUtf8LineStrict(Long.MAX_VALUE)).toString();
                                if (this.bytesRemainingInChunk < 0 || (string.length() > 0 && !StringsKt__StringsKt.startsWith(string, DaWYVMJ.XVdoIi, false))) {
                                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + string + '\"');
                                }
                                if (this.bytesRemainingInChunk == 0) {
                                    this.hasMoreChunks = false;
                                    routeSelector.inetSocketAddresses = ((HeadersReader) routeSelector.proxies).readHeaders();
                                    OkHttpClient okHttpClient = (OkHttpClient) routeSelector.postponedRoutes;
                                    Intrinsics.checkNotNull(okHttpClient);
                                    Headers headers = (Headers) routeSelector.inetSocketAddresses;
                                    Intrinsics.checkNotNull(headers);
                                    HttpHeaders.receiveHeaders(okHttpClient.cookieJar, this.url, headers);
                                    responseBodyComplete();
                                }
                                if (!this.hasMoreChunks) {
                                    return -1L;
                                }
                            } catch (NumberFormatException e) {
                                throw new ProtocolException(e.getMessage());
                            }
                        }
                        long j3 = super.read(sink, Math.min(j, this.bytesRemainingInChunk));
                        if (j3 != -1) {
                            this.bytesRemainingInChunk -= j3;
                            return j3;
                        }
                        ((RealConnection) routeSelector.address).noNewExchanges$okhttp();
                        ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                        responseBodyComplete();
                        throw protocolException;
                    }
                };
            }
            throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
        }
        long jHeadersContentLength = Util.headersContentLength(response);
        if (jHeadersContentLength != -1) {
            return newFixedLengthSource(jHeadersContentLength);
        }
        if (this.nextProxyIndex == 4) {
            this.nextProxyIndex = 5;
            ((RealConnection) this.address).noNewExchanges$okhttp();
            return new Http1ExchangeCodec$UnknownLengthSource(this);
        }
        throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) {
        HeadersReader headersReader = (HeadersReader) this.proxies;
        int i = this.nextProxyIndex;
        if (i != 1 && i != 3) {
            throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
        }
        HttpUrl.Builder builder = null;
        try {
            String utf8LineStrict = ((RealBufferedSource) headersReader.source).readUtf8LineStrict(headersReader.headerLimit);
            headersReader.headerLimit -= (long) utf8LineStrict.length();
            Splitter splitter = WorkContinuation.parse(utf8LineStrict);
            int i2 = splitter.limit;
            Response.Builder builder2 = new Response.Builder();
            builder2.protocol = (Protocol) splitter.trimmer;
            builder2.code = i2;
            builder2.message = (String) splitter.strategy;
            builder2.headers = headersReader.readHeaders().newBuilder();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.nextProxyIndex = 3;
            } else {
                this.nextProxyIndex = 4;
            }
            return builder2;
        } catch (EOFException e) {
            HttpUrl httpUrl = ((RealConnection) this.address).route.address.url;
            httpUrl.getClass();
            try {
                HttpUrl.Builder builder3 = new HttpUrl.Builder();
                builder3.parse$okhttp(httpUrl, "/...");
                builder = builder3;
            } catch (IllegalArgumentException unused) {
            }
            Intrinsics.checkNotNull(builder);
            builder.encodedUsername = HttpUrl.Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
            builder.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
            throw new IOException("unexpected end of stream on ".concat(builder.build().url), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(Response.header$default("Transfer-Encoding", response))) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public void writeRequest(Headers headers, String requestLine) {
        Intrinsics.checkNotNullParameter(requestLine, "requestLine");
        if (this.nextProxyIndex != 0) {
            throw new IllegalStateException(("state: " + this.nextProxyIndex).toString());
        }
        RealBufferedSink realBufferedSink = (RealBufferedSink) this.call;
        realBufferedSink.writeUtf8(requestLine);
        realBufferedSink.writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            realBufferedSink.writeUtf8(headers.name(i));
            realBufferedSink.writeUtf8(": ");
            realBufferedSink.writeUtf8(headers.value(i));
            realBufferedSink.writeUtf8("\r\n");
        }
        realBufferedSink.writeUtf8("\r\n");
        this.nextProxyIndex = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        Proxy.Type type = ((RealConnection) this.address).route.proxy.type();
        Intrinsics.checkNotNullExpressionValue(type, "connection.route().proxy.type()");
        StringBuilder sb = new StringBuilder();
        sb.append((String) request.method);
        sb.append(' ');
        HttpUrl httpUrl = (HttpUrl) request.url;
        if (httpUrl.isHttps || type != Proxy.Type.HTTP) {
            String strEncodedPath = httpUrl.encodedPath();
            String strEncodedQuery = httpUrl.encodedQuery();
            if (strEncodedQuery != null) {
                strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
            }
            sb.append(strEncodedPath);
        } else {
            sb.append(httpUrl);
        }
        sb.append(" HTTP/1.1");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        writeRequest((Headers) request.headers, string);
    }

    /* JADX WARN: Type inference failed for: r2v21, types: [java.lang.Object, java.util.List] */
    public zzda next() {
        boolean z;
        String hostName;
        int port;
        boolean zContains;
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (this.nextProxyIndex < ((List) this.proxies).size()) {
                if (this.nextProxyIndex < ((List) this.proxies).size()) {
                    z = true;
                } else {
                    z = false;
                }
                Address address = (Address) this.address;
                if (z) {
                    List list = (List) this.proxies;
                    int i = this.nextProxyIndex;
                    this.nextProxyIndex = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    ArrayList arrayList2 = new ArrayList();
                    this.inetSocketAddresses = arrayList2;
                    if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
                        SocketAddress socketAddressAddress = proxy.address();
                        if (socketAddressAddress instanceof InetSocketAddress) {
                            InetSocketAddress socketHost = (InetSocketAddress) socketAddressAddress;
                            Intrinsics.checkNotNullParameter(socketHost, "$this$socketHost");
                            InetAddress address2 = socketHost.getAddress();
                            if (address2 != null) {
                                hostName = address2.getHostAddress();
                                Intrinsics.checkNotNullExpressionValue(hostName, "address.hostAddress");
                            } else {
                                hostName = socketHost.getHostName();
                                Intrinsics.checkNotNullExpressionValue(hostName, "hostName");
                            }
                            port = socketHost.getPort();
                        } else {
                            throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                        }
                    } else {
                        HttpUrl httpUrl = address.url;
                        hostName = httpUrl.host;
                        port = httpUrl.port;
                    }
                    if (1 <= port && 65535 >= port) {
                        if (proxy.type() == Proxy.Type.SOCKS) {
                            arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
                        } else {
                            RealCall call = (RealCall) this.call;
                            Intrinsics.checkNotNullParameter(call, "call");
                            Intrinsics.checkNotNullParameter(hostName, "domainName");
                            address.dns.getClass();
                            try {
                                InetAddress[] allByName = InetAddress.getAllByName(hostName);
                                Intrinsics.checkNotNullExpressionValue(allByName, "InetAddress.getAllByName(hostname)");
                                List list2 = ArraysKt.toList(allByName);
                                if (!list2.isEmpty()) {
                                    Iterator it = list2.iterator();
                                    while (it.hasNext()) {
                                        arrayList2.add(new InetSocketAddress((InetAddress) it.next(), port));
                                    }
                                } else {
                                    throw new UnknownHostException(address.dns + " returned no addresses for " + hostName);
                                }
                            } catch (NullPointerException e) {
                                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                                unknownHostException.initCause(e);
                                throw unknownHostException;
                            }
                        }
                        Iterator it2 = this.inetSocketAddresses.iterator();
                        while (it2.hasNext()) {
                            Route route = new Route((Address) this.address, proxy, (InetSocketAddress) it2.next());
                            ConnectionPool connectionPool = (ConnectionPool) this.routeDatabase;
                            synchronized (connectionPool) {
                                zContains = ((LinkedHashSet) connectionPool.delegate).contains(route);
                            }
                            if (zContains) {
                                ((ArrayList) this.postponedRoutes).add(route);
                            } else {
                                arrayList.add(route);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            break;
                        }
                    } else {
                        throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
                    }
                } else {
                    throw new SocketException("No route to " + address.url.host + JrbhsraGtto.jfPPD + ((List) this.proxies));
                }
            }
            if (arrayList.isEmpty()) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, (ArrayList) this.postponedRoutes);
                ((ArrayList) this.postponedRoutes).clear();
            }
            zzda zzdaVar = new zzda();
            zzdaVar.zza = arrayList;
            return zzdaVar;
        }
        throw new NoSuchElementException();
    }

    public RouteSelector(OkHttpClient okHttpClient, RealConnection connection, RealBufferedSource source, RealBufferedSink sink) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.postponedRoutes = okHttpClient;
        this.address = connection;
        this.routeDatabase = source;
        this.call = sink;
        Intrinsics.checkNotNullParameter(source, "source");
        HeadersReader headersReader = new HeadersReader();
        headersReader.source = source;
        headersReader.headerLimit = 262144;
        this.proxies = headersReader;
    }
}
