package okhttp3;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.firebase.auth.zzr;
import java.net.ProxySelector;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.OkHostnameVerifier;

/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpClient implements Cloneable {
    public final HttpUrl.Companion authenticator;
    public final ExceptionsKt certificateChainCleaner;
    public final CertificatePinner certificatePinner;
    public final int connectTimeoutMillis;
    public final ConnectionPool connectionPool;
    public final List connectionSpecs;
    public final HttpUrl.Companion cookieJar;
    public final Dispatcher dispatcher;
    public final HttpUrl.Companion dns;
    public final zzr eventListenerFactory;
    public final boolean followRedirects;
    public final boolean followSslRedirects;
    public final HostnameVerifier hostnameVerifier;
    public final List interceptors;
    public final List networkInterceptors;
    public final List protocols;
    public final HttpUrl.Companion proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final int readTimeoutMillis;
    public final boolean retryOnConnectionFailure;
    public final ConnectionPool routeDatabase;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactoryOrNull;
    public final int writeTimeoutMillis;
    public final X509TrustManager x509TrustManager;
    public static final List DEFAULT_PROTOCOLS = Util.immutableListOf(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List DEFAULT_CONNECTION_SPECS = Util.immutableListOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);

    public final class Builder {
        public final HttpUrl.Companion authenticator;
        public ExceptionsKt certificateChainCleaner;
        public final CertificatePinner certificatePinner;
        public final int connectTimeout;
        public final List connectionSpecs;
        public final HttpUrl.Companion cookieJar;
        public final HttpUrl.Companion dns;
        public final boolean followRedirects;
        public final boolean followSslRedirects;
        public HostnameVerifier hostnameVerifier;
        public List protocols;
        public final HttpUrl.Companion proxyAuthenticator;
        public final int readTimeout;
        public final SocketFactory socketFactory;
        public SSLSocketFactory sslSocketFactoryOrNull;
        public final int writeTimeout;
        public X509TrustManager x509TrustManagerOrNull;
        public final Dispatcher dispatcher = new Dispatcher(0);
        public final ConnectionPool connectionPool = new ConnectionPool(0);
        public final ArrayList interceptors = new ArrayList();
        public final ArrayList networkInterceptors = new ArrayList();
        public final zzr eventListenerFactory = new zzr(27);
        public final boolean retryOnConnectionFailure = true;

        public Builder() {
            HttpUrl.Companion companion = HttpUrl.Companion.NONE;
            this.authenticator = companion;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = HttpUrl.Companion.NO_COOKIES;
            this.dns = HttpUrl.Companion.SYSTEM;
            this.proxyAuthenticator = companion;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "SocketFactory.getDefault()");
            this.socketFactory = socketFactory;
            this.connectionSpecs = OkHttpClient.DEFAULT_CONNECTION_SPECS;
            this.protocols = OkHttpClient.DEFAULT_PROTOCOLS;
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
        }

        public final void protocols(List protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            ArrayList mutableList = CollectionsKt.toMutableList(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!mutableList.contains(protocol) && !mutableList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (mutableList.contains(protocol) && mutableList.size() > 1) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (mutableList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            if (mutableList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            mutableList.remove(Protocol.SPDY_3);
            mutableList.equals(this.protocols);
            List listUnmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
            this.protocols = listUnmodifiableList;
        }
    }

    public final Object clone() {
        return super.clone();
    }

    public OkHttpClient(Builder builder) throws NoSuchAlgorithmException, KeyStoreException {
        boolean z;
        this.dispatcher = builder.dispatcher;
        this.connectionPool = builder.connectionPool;
        this.interceptors = Util.toImmutableList(builder.interceptors);
        this.networkInterceptors = Util.toImmutableList(builder.networkInterceptors);
        this.eventListenerFactory = builder.eventListenerFactory;
        this.retryOnConnectionFailure = builder.retryOnConnectionFailure;
        this.authenticator = builder.authenticator;
        this.followRedirects = builder.followRedirects;
        this.followSslRedirects = builder.followSslRedirects;
        this.cookieJar = builder.cookieJar;
        this.dns = builder.dns;
        ProxySelector proxySelector = ProxySelector.getDefault();
        this.proxySelector = proxySelector == null ? NullProxySelector.INSTANCE : proxySelector;
        this.proxyAuthenticator = builder.proxyAuthenticator;
        this.socketFactory = builder.socketFactory;
        List list = builder.connectionSpecs;
        this.connectionSpecs = list;
        this.protocols = builder.protocols;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.connectTimeoutMillis = builder.connectTimeout;
        this.readTimeoutMillis = builder.readTimeout;
        this.writeTimeoutMillis = builder.writeTimeout;
        this.routeDatabase = new ConnectionPool(2);
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ConnectionSpec) it.next()).isTls) {
                        SSLSocketFactory sSLSocketFactory = builder.sslSocketFactoryOrNull;
                        if (sSLSocketFactory != null) {
                            this.sslSocketFactoryOrNull = sSLSocketFactory;
                            ExceptionsKt exceptionsKt = builder.certificateChainCleaner;
                            Intrinsics.checkNotNull(exceptionsKt);
                            this.certificateChainCleaner = exceptionsKt;
                            X509TrustManager x509TrustManager = builder.x509TrustManagerOrNull;
                            Intrinsics.checkNotNull(x509TrustManager);
                            this.x509TrustManager = x509TrustManager;
                            CertificatePinner certificatePinner = builder.certificatePinner;
                            certificatePinner.getClass();
                            this.certificatePinner = Intrinsics.areEqual(certificatePinner.certificateChainCleaner, exceptionsKt) ? certificatePinner : new CertificatePinner(certificatePinner.pins, exceptionsKt);
                            break;
                        }
                        Platform platform = Platform.platform;
                        X509TrustManager x509TrustManagerPlatformTrustManager = Platform.platform.platformTrustManager();
                        this.x509TrustManager = x509TrustManagerPlatformTrustManager;
                        this.sslSocketFactoryOrNull = Platform.platform.newSslSocketFactory(x509TrustManagerPlatformTrustManager);
                        ExceptionsKt exceptionsKtBuildCertificateChainCleaner = Platform.platform.buildCertificateChainCleaner(x509TrustManagerPlatformTrustManager);
                        this.certificateChainCleaner = exceptionsKtBuildCertificateChainCleaner;
                        CertificatePinner certificatePinner2 = builder.certificatePinner;
                        certificatePinner2.getClass();
                        this.certificatePinner = Intrinsics.areEqual(certificatePinner2.certificateChainCleaner, exceptionsKtBuildCertificateChainCleaner) ? certificatePinner2 : new CertificatePinner(certificatePinner2.pins, exceptionsKtBuildCertificateChainCleaner);
                        break;
                    }
                } else {
                    this.sslSocketFactoryOrNull = null;
                    this.certificateChainCleaner = null;
                    this.x509TrustManager = null;
                    this.certificatePinner = CertificatePinner.DEFAULT;
                    break;
                }
            }
        } else {
            this.sslSocketFactoryOrNull = null;
            this.certificateChainCleaner = null;
            this.x509TrustManager = null;
            this.certificatePinner = CertificatePinner.DEFAULT;
            break;
        }
        List list2 = this.interceptors;
        if (list2 != null) {
            if (!list2.contains(null)) {
                List list3 = this.networkInterceptors;
                if (list3 != null) {
                    if (!list3.contains(null)) {
                        List list4 = this.connectionSpecs;
                        boolean z2 = list4 instanceof Collection;
                        X509TrustManager x509TrustManager2 = this.x509TrustManager;
                        ExceptionsKt exceptionsKt2 = this.certificateChainCleaner;
                        SSLSocketFactory sSLSocketFactory2 = this.sslSocketFactoryOrNull;
                        if (!z2 || !list4.isEmpty()) {
                            Iterator it2 = list4.iterator();
                            while (it2.hasNext()) {
                                if (((ConnectionSpec) it2.next()).isTls) {
                                    if (sSLSocketFactory2 != null) {
                                        if (exceptionsKt2 != null) {
                                            if (x509TrustManager2 == null) {
                                                throw new IllegalStateException("x509TrustManager == null");
                                            }
                                            return;
                                        }
                                        throw new IllegalStateException(nYVxXTZQ.IwRhb);
                                    }
                                    throw new IllegalStateException("sslSocketFactory == null");
                                }
                            }
                        }
                        if (sSLSocketFactory2 == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            if (exceptionsKt2 == null) {
                                if (x509TrustManager2 == null) {
                                    if (Intrinsics.areEqual(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                        return;
                                    } else {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                }
                                throw new IllegalStateException("Check failed.");
                            }
                            throw new IllegalStateException("Check failed.");
                        }
                        throw new IllegalStateException("Check failed.");
                    }
                    throw new IllegalStateException(("Null network interceptor: " + list3).toString());
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
            }
            throw new IllegalStateException(("Null interceptor: " + list2).toString());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    }
}
