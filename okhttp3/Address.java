package okhttp3;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class Address {
    public final CertificatePinner certificatePinner;
    public final List connectionSpecs;
    public final HttpUrl.Companion dns;
    public final HostnameVerifier hostnameVerifier;
    public final List protocols;
    public final HttpUrl.Companion proxyAuthenticator;
    public final ProxySelector proxySelector;
    public final SocketFactory socketFactory;
    public final SSLSocketFactory sslSocketFactory;
    public final HttpUrl url;

    public Address(String uriHost, int i, HttpUrl.Companion dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, HttpUrl.Companion proxyAuthenticator, List protocols, List connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = certificatePinner;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxySelector = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str = sSLSocketFactory != null ? "https" : "http";
        if (str.equalsIgnoreCase("http")) {
            builder.scheme = "http";
        } else {
            if (!str.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException("unexpected scheme: ".concat(str));
            }
            builder.scheme = "https";
        }
        String canonicalHost = TextStreamsKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(uriHost, 0, 0, 7, false));
        if (canonicalHost == null) {
            throw new IllegalArgumentException("unexpected host: ".concat(uriHost));
        }
        builder.host = canonicalHost;
        if (1 > i || 65535 < i) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "unexpected port: ").toString());
        }
        builder.port = i;
        this.url = builder.build();
        this.protocols = Util.toImmutableList(protocols);
        this.connectionSpecs = Util.toImmutableList(connectionSpecs);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (Intrinsics.areEqual(this.url, address.url) && equalsNonHost$okhttp(address)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equalsNonHost$okhttp(Address that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.dns, that.dns) && Intrinsics.areEqual(this.proxyAuthenticator, that.proxyAuthenticator) && Intrinsics.areEqual(this.protocols, that.protocols) && Intrinsics.areEqual(this.connectionSpecs, that.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, that.proxySelector) && Intrinsics.areEqual(null, null) && Intrinsics.areEqual(this.sslSocketFactory, that.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, that.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, that.certificatePinner) && this.url.port == that.url.port;
    }

    public final int hashCode() {
        return Objects.hashCode(this.certificatePinner) + ((Objects.hashCode(this.hostnameVerifier) + ((Objects.hashCode(this.sslSocketFactory) + ((this.proxySelector.hashCode() + ((this.connectionSpecs.hashCode() + ((this.protocols.hashCode() + ((this.proxyAuthenticator.hashCode() + ((this.dns.hashCode() + CoroutineAdapterKt$$ExternalSyntheticLambda0.m(527, 31, this.url.url)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.url;
        sb.append(httpUrl.host);
        sb.append(':');
        sb.append(httpUrl.port);
        sb.append(", ");
        sb.append("proxySelector=" + this.proxySelector);
        sb.append("}");
        return sb.toString();
    }
}
