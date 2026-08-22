package okhttp3.internal.connection;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.measurement.internal.zzef;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.ByteString;
import okio.Okio;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public final class RealConnection extends Http2Connection.Listener {
    public int allocationLimit;
    public final ArrayList calls;
    public Handshake handshake;
    public Http2Connection http2Connection;
    public long idleAtNs;
    public boolean noCoalescedConnections;
    public boolean noNewExchanges;
    public Protocol protocol;
    public Socket rawSocket;
    public int refusedStreamCount;
    public final Route route;
    public int routeFailureCount;
    public RealBufferedSink sink;
    public Socket socket;
    public RealBufferedSource source;
    public int successCount;

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
        }
    }

    public RealConnection(RealConnectionPool connectionPool, Route route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public static void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.proxy.type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address;
            address.proxySelector.connectFailed(address.url.uri(), failedRoute.proxy.address(), failure);
        }
        ConnectionPool connectionPool = client.routeDatabase;
        synchronized (connectionPool) {
            ((LinkedHashSet) connectionPool.delegate).add(failedRoute);
        }
    }

    public final void connect(int i, int i2, int i3, boolean z, RealCall call) throws Throwable {
        Intrinsics.checkNotNullParameter(call, "call");
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.route.address.connectionSpecs;
        zzef zzefVar = new zzef(list);
        Address address = this.route.address;
        if (address.sslSocketFactory == null) {
            if (!list.contains(ConnectionSpec.CLEARTEXT)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.route.address.url.host;
            Platform platform = Platform.platform;
            if (!Platform.platform.isCleartextTrafficPermitted(str)) {
                throw new RouteException(new UnknownServiceException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.protocols.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        while (true) {
            try {
                Route route = this.route;
                if (route.address.sslSocketFactory != null && route.proxy.type() == Proxy.Type.HTTP) {
                    connectTunnel(i, i2, i3, call);
                    if (this.rawSocket != null) {
                        break;
                    } else {
                        break;
                    }
                }
                connectSocket(i, i2, call);
                establishProtocol(zzefVar, call);
                InetSocketAddress inetSocketAddress = this.route.socketAddress;
                Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
                break;
            } catch (IOException e) {
                Socket socket = this.socket;
                if (socket != null) {
                    Util.closeQuietly(socket);
                }
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                this.http2Connection = null;
                this.allocationLimit = 1;
                InetSocketAddress inetSocketAddress2 = this.route.socketAddress;
                Intrinsics.checkNotNullParameter(inetSocketAddress2, "inetSocketAddress");
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    ExceptionsKt.addSuppressed(routeException.firstConnectException, e);
                    routeException.lastConnectException = e;
                }
                if (!z) {
                    throw routeException;
                }
                zzefVar.zzd = true;
                if (!zzefVar.zzc) {
                    throw routeException;
                }
                if (e instanceof ProtocolException) {
                    throw routeException;
                }
                if (e instanceof InterruptedIOException) {
                    throw routeException;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw routeException;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw routeException;
                }
                if (!(e instanceof SSLException)) {
                    throw routeException;
                }
            }
        }
        Route route2 = this.route;
        if (route2.address.sslSocketFactory != null && route2.proxy.type() == Proxy.Type.HTTP && this.rawSocket == null) {
            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        this.idleAtNs = System.nanoTime();
    }

    public final void connectSocket(int i, int i2, RealCall call) throws IOException {
        Socket socket;
        int i3;
        Route route = this.route;
        Proxy proxy = route.proxy;
        Address address = route.address;
        Proxy.Type type = proxy.type();
        if (type != null && ((i3 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1 || i3 == 2)) {
            socket = address.socketFactory.createSocket();
            Intrinsics.checkNotNull(socket);
        } else {
            socket = new Socket(proxy);
        }
        this.rawSocket = socket;
        InetSocketAddress inetSocketAddress = this.route.socketAddress;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        socket.setSoTimeout(i2);
        try {
            Platform platform = Platform.platform;
            Platform.platform.connectSocket(socket, this.route.socketAddress, i);
            try {
                this.source = new RealBufferedSource(Okio.source(socket));
                this.sink = new RealBufferedSink(Okio.sink(socket));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress);
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void connectTunnel(int i, int i2, int i3, RealCall realCall) throws IOException {
        Request.Builder builder = new Request.Builder();
        Route route = this.route;
        HttpUrl url = route.address.url;
        Intrinsics.checkNotNullParameter(url, "url");
        builder.url = url;
        builder.method("CONNECT", null);
        Address address = route.address;
        builder.header("Host", Util.toHostHeader(address.url, true));
        builder.header("Proxy-Connection", "Keep-Alive");
        builder.header("User-Agent", "okhttp/4.9.0");
        Request requestBuild = builder.build();
        Headers.Builder builder2 = new Headers.Builder();
        Headers.Companion.checkName("Proxy-Authenticate");
        Headers.Companion.checkValue("OkHttp-Preemptive", "Proxy-Authenticate");
        builder2.removeAll("Proxy-Authenticate");
        builder2.addLenient$okhttp("Proxy-Authenticate", "OkHttp-Preemptive");
        builder2.build();
        address.proxyAuthenticator.getClass();
        connectSocket(i, i2, realCall);
        String str = "CONNECT " + Util.toHostHeader((HttpUrl) requestBuild.url, true) + " HTTP/1.1";
        RealBufferedSource realBufferedSource = this.source;
        Intrinsics.checkNotNull(realBufferedSource);
        RealBufferedSink realBufferedSink = this.sink;
        Intrinsics.checkNotNull(realBufferedSink);
        RouteSelector routeSelector = new RouteSelector(null, this, realBufferedSource, realBufferedSink);
        Timeout timeout = realBufferedSource.source.timeout();
        long j = i2;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(j, timeUnit);
        realBufferedSink.sink.timeout().timeout(i3, timeUnit);
        routeSelector.writeRequest((Headers) requestBuild.headers, str);
        routeSelector.finishRequest();
        Response.Builder responseHeaders = routeSelector.readResponseHeaders(false);
        Intrinsics.checkNotNull(responseHeaders);
        responseHeaders.request = requestBuild;
        Response responseBuild = responseHeaders.build();
        long jHeadersContentLength = Util.headersContentLength(responseBuild);
        if (jHeadersContentLength != -1) {
            Http1ExchangeCodec$FixedLengthSource http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource = routeSelector.newFixedLengthSource(jHeadersContentLength);
            Util.skipAll(http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource, Integer.MAX_VALUE, timeUnit);
            http1ExchangeCodec$FixedLengthSourceNewFixedLengthSource.close();
        }
        int i4 = responseBuild.code;
        if (i4 != 200) {
            if (i4 != 407) {
                throw new IOException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i4, "Unexpected response code for CONNECT: "));
            }
            address.proxyAuthenticator.getClass();
            throw new IOException("Failed to authenticate with proxy");
        }
        if (!realBufferedSource.bufferField.exhausted() || !realBufferedSink.bufferField.exhausted()) {
            throw new IOException("TLS tunnel buffered too many bytes!");
        }
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        if (okhttp3.internal.tls.OkHostnameVerifier.verify(r1, (java.security.cert.X509Certificate) r11) != false) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isEligible$okhttp(okhttp3.Address r10, java.util.List r11) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.isEligible$okhttp(okhttp3.Address, java.util.List):boolean");
    }

    public final boolean isHealthy(boolean z) {
        long j;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        long jNanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        RealBufferedSource realBufferedSource = this.source;
        Intrinsics.checkNotNull(realBufferedSource);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.idleAtNs;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !realBufferedSource.exhausted();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient client, RealInterceptorChain realInterceptorChain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        RealBufferedSource realBufferedSource = this.source;
        Intrinsics.checkNotNull(realBufferedSource);
        RealBufferedSink realBufferedSink = this.sink;
        Intrinsics.checkNotNull(realBufferedSink);
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, realInterceptorChain, http2Connection);
        }
        int i = realInterceptorChain.readTimeoutMillis;
        socket.setSoTimeout(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        realBufferedSource.source.timeout().timeout(i, timeUnit);
        realBufferedSink.sink.timeout().timeout(realInterceptorChain.writeTimeoutMillis, timeUnit);
        return new RouteSelector(client, this, realBufferedSource, realBufferedSink);
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void onSettings(Http2Connection connection, Settings settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void onStream(Http2Stream http2Stream) {
        http2Stream.close(null, 8);
    }

    public final void startHttp2() throws SocketException {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        RealBufferedSource realBufferedSource = this.source;
        Intrinsics.checkNotNull(realBufferedSource);
        RealBufferedSink realBufferedSink = this.sink;
        Intrinsics.checkNotNull(realBufferedSink);
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.INSTANCE;
        Request request = new Request(taskRunner);
        String peerName = this.route.address.url.host;
        Intrinsics.checkNotNullParameter(peerName, "peerName");
        request.lazyCacheControl = socket;
        request.method = Util.okHttpName + ' ' + peerName;
        request.url = realBufferedSource;
        request.headers = realBufferedSink;
        request.body = this;
        Http2Connection http2Connection = new Http2Connection(request);
        this.http2Connection = http2Connection;
        Settings settings = Http2Connection.DEFAULT_SETTINGS;
        this.allocationLimit = (settings.set & 16) != 0 ? settings.values[4] : Integer.MAX_VALUE;
        Http2Writer http2Writer = http2Connection.writer;
        synchronized (http2Writer) {
            try {
                if (http2Writer.closed) {
                    throw new IOException("closed");
                }
                Logger logger = Http2Writer.logger;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                }
                RealBufferedSink realBufferedSink2 = http2Writer.sink;
                ByteString byteString = Http2.CONNECTION_PREFACE;
                realBufferedSink2.getClass();
                Intrinsics.checkNotNullParameter(byteString, "byteString");
                if (realBufferedSink2.closed) {
                    throw new IllegalStateException("closed");
                }
                realBufferedSink2.bufferField.write(byteString);
                realBufferedSink2.emitCompleteSegments();
                http2Writer.sink.flush();
            } catch (Throwable th) {
                throw th;
            }
        }
        http2Connection.writer.settings(http2Connection.okHttpSettings);
        int initialWindowSize = http2Connection.okHttpSettings.getInitialWindowSize();
        if (initialWindowSize != 65535) {
            http2Connection.writer.windowUpdate(0, initialWindowSize - 65535);
        }
        taskRunner.newQueue().schedule(new TaskQueue$execute$1(http2Connection.connectionName, 0, http2Connection.readerRunnable), 0L);
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        Route route = this.route;
        sb.append(route.address.url.host);
        sb.append(':');
        sb.append(route.address.url.port);
        sb.append(", proxy=");
        sb.append(route.proxy);
        sb.append(" hostAddress=");
        sb.append(route.socketAddress);
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (obj = handshake.cipherSuite) == null) {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void establishProtocol(zzef zzefVar, RealCall call) throws Throwable {
        Address address = this.route.address;
        SSLSocketFactory sSLSocketFactory = address.sslSocketFactory;
        Protocol protocol = Protocol.HTTP_1_1;
        if (sSLSocketFactory == null) {
            List list = address.protocols;
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol2)) {
                this.socket = this.rawSocket;
                this.protocol = protocol;
                return;
            } else {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                startHttp2();
                return;
            }
        }
        Intrinsics.checkNotNullParameter(call, "call");
        final Address address2 = this.route.address;
        SSLSocketFactory sSLSocketFactory2 = address2.sslSocketFactory;
        SSLSocket sSLSocket = null;
        String selectedProtocol = null;
        try {
            Intrinsics.checkNotNull(sSLSocketFactory2);
            Socket socket = this.rawSocket;
            HttpUrl httpUrl = address2.url;
            Socket socketCreateSocket = sSLSocketFactory2.createSocket(socket, httpUrl.host, httpUrl.port, true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                ConnectionSpec connectionSpecConfigureSecureSocket = zzefVar.configureSecureSocket(sSLSocket2);
                if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                    Platform platform = Platform.platform;
                    Platform.platform.configureTlsExtensions(sSLSocket2, address2.url.host, address2.protocols);
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
                final Handshake handshake = GamepadHandler_API19.get(sslSocketSession);
                HostnameVerifier hostnameVerifier = address2.hostnameVerifier;
                Intrinsics.checkNotNull(hostnameVerifier);
                if (hostnameVerifier.verify(address2.url.host, sslSocketSession)) {
                    final CertificatePinner certificatePinner = address2.certificatePinner;
                    Intrinsics.checkNotNull(certificatePinner);
                    this.handshake = new Handshake(handshake.tlsVersion, handshake.cipherSuite, handshake.localCertificates, new Function0() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            ExceptionsKt exceptionsKt = certificatePinner.certificateChainCleaner;
                            Intrinsics.checkNotNull(exceptionsKt);
                            return exceptionsKt.clean(address2.url.host, handshake.peerCertificates());
                        }
                    });
                    String hostname = address2.url.host;
                    Intrinsics.checkNotNullParameter(hostname, "hostname");
                    Iterator it = certificatePinner.pins.iterator();
                    if (it.hasNext()) {
                        it.next().getClass();
                        throw new ClassCastException();
                    }
                    if (connectionSpecConfigureSecureSocket.supportsTlsExtensions) {
                        Platform platform2 = Platform.platform;
                        selectedProtocol = Platform.platform.getSelectedProtocol(sSLSocket2);
                    }
                    this.socket = sSLSocket2;
                    this.source = new RealBufferedSource(Okio.source(sSLSocket2));
                    this.sink = new RealBufferedSink(Okio.sink(sSLSocket2));
                    if (selectedProtocol != null) {
                        protocol = Protocol.Companion.get(selectedProtocol);
                    }
                    this.protocol = protocol;
                    Platform platform3 = Platform.platform;
                    Platform.platform.afterHandshake(sSLSocket2);
                    if (this.protocol == Protocol.HTTP_2) {
                        startHttp2();
                        return;
                    }
                    return;
                }
                List listPeerCertificates = handshake.peerCertificates();
                if (listPeerCertificates.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address2.url.host + " not verified (no certificates)");
                }
                Object obj = listPeerCertificates.get(0);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                X509Certificate x509Certificate = (X509Certificate) obj;
                StringBuilder sb = new StringBuilder("\n              |Hostname ");
                sb.append(address2.url.host);
                sb.append(" not verified:\n              |    certificate: ");
                CertificatePinner certificatePinner2 = CertificatePinner.DEFAULT;
                sb.append(Okio.pin(x509Certificate));
                sb.append(oKjScaD.NLqOIrqUpICoO);
                Principal subjectDN = x509Certificate.getSubjectDN();
                Intrinsics.checkNotNullExpressionValue(subjectDN, "cert.subjectDN");
                sb.append(subjectDN.getName());
                sb.append("\n              |    subjectAltNames: ");
                List subjectAltNames = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 7);
                List subjectAltNames2 = OkHostnameVerifier.getSubjectAltNames(x509Certificate, 2);
                ArrayList arrayList = new ArrayList(subjectAltNames2.size() + subjectAltNames.size());
                arrayList.addAll(subjectAltNames);
                arrayList.addAll(subjectAltNames2);
                sb.append(arrayList);
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(StringsKt__IndentKt.trimMargin$default(sb.toString()));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform platform4 = Platform.platform;
                    Platform.platform.afterHandshake(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.closeQuietly((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
