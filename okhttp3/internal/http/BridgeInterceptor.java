package okhttp3.internal.http;

import com.android.billingclient.api.zzda;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.GzipSource;
import okio.RealBufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public final class BridgeInterceptor implements Interceptor {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object cookieJar;

    public BridgeInterceptor(HttpUrl.Companion cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    public static int retryAfter(Response response, int i) {
        String strHeader$default = Response.header$default("Retry-After", response);
        if (strHeader$default == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
        if (!patternCompile.matcher(strHeader$default).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strHeader$default);
        Intrinsics.checkNotNullExpressionValue(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    public Request followUpRequest(Response response, Dispatcher dispatcher) throws ProtocolException {
        String strHeader$default;
        HttpUrl.Builder builder;
        RealConnection realConnection;
        Route route = (dispatcher == null || (realConnection = (RealConnection) dispatcher.executorServiceOrNull) == null) ? null : realConnection.route;
        int i = response.code;
        String str = (String) response.request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                ((OkHttpClient) this.cookieJar).authenticator.getClass();
                return null;
            }
            if (i == 421) {
                if (dispatcher == null || Intrinsics.areEqual(((ExchangeFinder) dispatcher.runningAsyncCalls).address.url.host, ((RealConnection) dispatcher.executorServiceOrNull).route.address.url.host)) {
                    return null;
                }
                RealConnection realConnection2 = (RealConnection) dispatcher.executorServiceOrNull;
                synchronized (realConnection2) {
                    realConnection2.noCoalescedConnections = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.code != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                Intrinsics.checkNotNull(route);
                if (route.proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                ((OkHttpClient) this.cookieJar).proxyAuthenticator.getClass();
                return null;
            }
            if (i == 408) {
                if (!((OkHttpClient) this.cookieJar).retryOnConnectionFailure) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.code != 408) && retryAfter(response, 0) <= 0) {
                    return response.request;
                }
                return null;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        OkHttpClient okHttpClient = (OkHttpClient) this.cookieJar;
        if (!okHttpClient.followRedirects || (strHeader$default = Response.header$default("Location", response)) == null) {
            return null;
        }
        Request request = response.request;
        HttpUrl httpUrl = (HttpUrl) request.url;
        httpUrl.getClass();
        try {
            builder = new HttpUrl.Builder();
            builder.parse$okhttp(httpUrl, strHeader$default);
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        HttpUrl httpUrlBuild = builder != null ? builder.build() : null;
        if (httpUrlBuild == null) {
            return null;
        }
        if (!Intrinsics.areEqual(httpUrlBuild.scheme, ((HttpUrl) request.url).scheme) && !okHttpClient.followSslRedirects) {
            return null;
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        if (RangesKt.permitsRequestBody(str)) {
            boolean zEquals = str.equals("PROPFIND");
            int i2 = response.code;
            boolean z = zEquals || i2 == 308 || i2 == 307;
            if (str.equals("PROPFIND") || i2 == 308 || i2 == 307) {
                builderNewBuilder.method(str, z ? (RequestBody) request.body : null);
            } else {
                builderNewBuilder.method("GET", null);
            }
            if (!z) {
                ((Headers.Builder) builderNewBuilder.headers).removeAll("Transfer-Encoding");
                ((Headers.Builder) builderNewBuilder.headers).removeAll("Content-Length");
                ((Headers.Builder) builderNewBuilder.headers).removeAll("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor((HttpUrl) request.url, httpUrlBuild)) {
            ((Headers.Builder) builderNewBuilder.headers).removeAll(oKjScaD.QUpASvvBIjwaifx);
        }
        builderNewBuilder.url = httpUrlBuild;
        return builderNewBuilder.build();
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        RealResponseBody realResponseBody;
        Response responseProceed;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        switch (this.$r8$classId) {
            case 0:
                Request request = realInterceptorChain.request;
                Request.Builder builderNewBuilder = request.newBuilder();
                RequestBody requestBody = (RequestBody) request.body;
                if (requestBody != null) {
                    MediaType mediaTypeContentType = requestBody.contentType();
                    if (mediaTypeContentType != null) {
                        builderNewBuilder.header("Content-Type", mediaTypeContentType.mediaType);
                    }
                    long jContentLength = requestBody.contentLength();
                    if (jContentLength != -1) {
                        builderNewBuilder.header("Content-Length", String.valueOf(jContentLength));
                        ((Headers.Builder) builderNewBuilder.headers).removeAll("Transfer-Encoding");
                    } else {
                        builderNewBuilder.header("Transfer-Encoding", "chunked");
                        ((Headers.Builder) builderNewBuilder.headers).removeAll("Content-Length");
                    }
                }
                Headers headers = (Headers) request.headers;
                String str = headers.get("Host");
                boolean z = false;
                HttpUrl url = (HttpUrl) request.url;
                if (str == null) {
                    builderNewBuilder.header("Host", Util.toHostHeader(url, false));
                }
                if (headers.get("Connection") == null) {
                    builderNewBuilder.header("Connection", "Keep-Alive");
                }
                if (headers.get("Accept-Encoding") == null && headers.get("Range") == null) {
                    builderNewBuilder.header("Accept-Encoding", "gzip");
                    z = true;
                }
                HttpUrl.Companion companion = (HttpUrl.Companion) this.cookieJar;
                companion.getClass();
                Intrinsics.checkNotNullParameter(url, "url");
                if (headers.get("User-Agent") == null) {
                    builderNewBuilder.header("User-Agent", "okhttp/4.9.0");
                }
                Response responseProceed2 = realInterceptorChain.proceed(builderNewBuilder.build());
                Headers headers2 = responseProceed2.headers;
                HttpHeaders.receiveHeaders(companion, url, headers2);
                Response.Builder builderNewBuilder2 = responseProceed2.newBuilder();
                builderNewBuilder2.request = request;
                if (z && "gzip".equalsIgnoreCase(Response.header$default("Content-Encoding", responseProceed2)) && HttpHeaders.promisesBody(responseProceed2) && (realResponseBody = responseProceed2.body) != null) {
                    GzipSource gzipSource = new GzipSource(realResponseBody.source());
                    Headers.Builder builderNewBuilder3 = headers2.newBuilder();
                    builderNewBuilder3.removeAll("Content-Encoding");
                    builderNewBuilder3.removeAll("Content-Length");
                    builderNewBuilder2.headers = builderNewBuilder3.build().newBuilder();
                    builderNewBuilder2.body = new RealResponseBody(Response.header$default("Content-Type", responseProceed2), -1L, new RealBufferedSource(gzipSource));
                }
                return builderNewBuilder2.build();
            default:
                Request request2 = realInterceptorChain.request;
                RealCall realCall = realInterceptorChain.call;
                List list = EmptyList.INSTANCE;
                Response response = null;
                int i = 0;
                Request requestFollowUpRequest = request2;
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        realCall.getClass();
                        if (realCall.interceptorScopedExchange != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        synchronized (realCall) {
                            try {
                                if (realCall.responseBodyOpen) {
                                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                }
                                if (realCall.requestBodyOpen) {
                                    throw new IllegalStateException("Check failed.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z2) {
                            RealConnectionPool realConnectionPool = realCall.connectionPool;
                            HttpUrl httpUrl = (HttpUrl) requestFollowUpRequest.url;
                            boolean z3 = httpUrl.isHttps;
                            OkHttpClient okHttpClient = realCall.client;
                            if (z3) {
                                SSLSocketFactory sSLSocketFactory2 = okHttpClient.sslSocketFactoryOrNull;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                HostnameVerifier hostnameVerifier2 = okHttpClient.hostnameVerifier;
                                certificatePinner = okHttpClient.certificatePinner;
                                sSLSocketFactory = sSLSocketFactory2;
                                hostnameVerifier = hostnameVerifier2;
                            } else {
                                sSLSocketFactory = null;
                                hostnameVerifier = null;
                                certificatePinner = null;
                            }
                            realCall.exchangeFinder = new ExchangeFinder(realConnectionPool, new Address(httpUrl.host, httpUrl.port, okHttpClient.dns, okHttpClient.socketFactory, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.proxyAuthenticator, okHttpClient.protocols, okHttpClient.connectionSpecs, okHttpClient.proxySelector), realCall);
                        }
                        try {
                            if (realCall.canceled) {
                                throw new IOException("Canceled");
                            }
                            try {
                                responseProceed = realInterceptorChain.proceed(requestFollowUpRequest);
                            } catch (IOException e) {
                                if (!recover(e, realCall, requestFollowUpRequest, !(e instanceof ConnectionShutdownException))) {
                                    Util.withSuppressed(e, list);
                                    throw e;
                                }
                                ArrayList arrayList = new ArrayList(list.size() + 1);
                                arrayList.addAll(list);
                                arrayList.add(e);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                list = arrayList;
                                z2 = false;
                            } catch (RouteException e2) {
                                List list2 = list;
                                if (!recover(e2.lastConnectException, realCall, requestFollowUpRequest, false)) {
                                    IOException iOException = e2.firstConnectException;
                                    Util.withSuppressed(iOException, list2);
                                    throw iOException;
                                }
                                IOException iOException2 = e2.firstConnectException;
                                ArrayList arrayList2 = new ArrayList(list2.size() + 1);
                                arrayList2.addAll(list2);
                                arrayList2.add(iOException2);
                                realCall.exitNetworkInterceptorExchange$okhttp(true);
                                list = arrayList2;
                                z2 = false;
                            }
                        } catch (Throwable th2) {
                            realCall.exitNetworkInterceptorExchange$okhttp(true);
                            throw th2;
                        }
                        break;
                    }
                    if (response != null) {
                        Response.Builder builderNewBuilder4 = responseProceed.newBuilder();
                        Response.Builder builderNewBuilder5 = response.newBuilder();
                        builderNewBuilder5.body = null;
                        Response responseBuild = builderNewBuilder5.build();
                        if (responseBuild.body != null) {
                            throw new IllegalArgumentException("priorResponse.body != null");
                        }
                        builderNewBuilder4.priorResponse = responseBuild;
                        responseProceed = builderNewBuilder4.build();
                    }
                    response = responseProceed;
                    requestFollowUpRequest = followUpRequest(response, realCall.interceptorScopedExchange);
                    if (requestFollowUpRequest == null) {
                        realCall.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RealResponseBody realResponseBody2 = response.body;
                    if (realResponseBody2 != null) {
                        Util.closeQuietly(realResponseBody2);
                    }
                    i++;
                    if (i > 20) {
                        throw new ProtocolException("Too many follow-up requests: " + i);
                    }
                    realCall.exitNetworkInterceptorExchange$okhttp(true);
                    list = list;
                }
                break;
        }
    }

    public boolean recover(IOException iOException, RealCall realCall, Request request, boolean z) {
        RouteSelector routeSelector;
        boolean zHasNext;
        RealConnection realConnection;
        if (!((OkHttpClient) this.cookieJar).retryOnConnectionFailure) {
            return false;
        }
        if ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException) || (!(iOException instanceof InterruptedIOException) ? !(((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) : (iOException instanceof SocketTimeoutException) && !z)) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.exchangeFinder;
        Intrinsics.checkNotNull(exchangeFinder);
        int i = exchangeFinder.refusedStreamCount;
        if (i == 0 && exchangeFinder.connectionShutdownCount == 0 && exchangeFinder.otherFailureCount == 0) {
            zHasNext = false;
        } else if (exchangeFinder.nextRouteToTry != null) {
            zHasNext = true;
        } else {
            Route route = null;
            if (i <= 1 && exchangeFinder.connectionShutdownCount <= 1 && exchangeFinder.otherFailureCount <= 0 && (realConnection = exchangeFinder.call.connection) != null) {
                synchronized (realConnection) {
                    if (realConnection.routeFailureCount == 0 && Util.canReuseConnectionFor(realConnection.route.address.url, exchangeFinder.address.url)) {
                        route = realConnection.route;
                    }
                }
            }
            if (route != null) {
                exchangeFinder.nextRouteToTry = route;
            } else {
                zzda zzdaVar = exchangeFinder.routeSelection;
                if ((zzdaVar == null || !zzdaVar.hasNext()) && (routeSelector = exchangeFinder.routeSelector) != null) {
                    zHasNext = routeSelector.hasNext();
                }
            }
            zHasNext = true;
        }
        return zHasNext;
    }

    public BridgeInterceptor(OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.cookieJar = client;
    }
}
