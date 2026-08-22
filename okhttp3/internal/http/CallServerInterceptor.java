package okhttp3.internal.http;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public final class CallServerInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws IOException {
        Long l;
        Response.Builder responseHeaders;
        RequestBody requestBody;
        boolean z;
        final Dispatcher dispatcher = realInterceptorChain.exchange;
        Intrinsics.checkNotNull(dispatcher);
        RealCall call = (RealCall) dispatcher.readyAsyncCalls;
        ExchangeCodec exchangeCodec = (ExchangeCodec) dispatcher.runningSyncCalls;
        Request request = realInterceptorChain.request;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Intrinsics.checkNotNullParameter(call, "call");
            exchangeCodec.writeRequestHeaders(request);
            boolean zPermitsRequestBody = RangesKt.permitsRequestBody((String) request.method);
            boolean z2 = true;
            RealConnection realConnection = (RealConnection) dispatcher.executorServiceOrNull;
            if (!zPermitsRequestBody || (requestBody = (RequestBody) request.body) == null) {
                l = null;
                call.messageDone$okhttp(dispatcher, true, false, null);
                responseHeaders = null;
            } else {
                if ("100-continue".equalsIgnoreCase(((Headers) request.headers).get("Expect"))) {
                    try {
                        exchangeCodec.flushRequest();
                        responseHeaders = dispatcher.readResponseHeaders(true);
                        Intrinsics.checkNotNullParameter(call, "call");
                        z = false;
                    } catch (IOException e) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        dispatcher.trackFailure(e);
                        throw e;
                    }
                } else {
                    z = true;
                    responseHeaders = null;
                }
                if (responseHeaders == null) {
                    Intrinsics.checkNotNull(requestBody);
                    final long jContentLength = requestBody.contentLength();
                    Intrinsics.checkNotNullParameter(call, "call");
                    final Sink sinkCreateRequestBody = exchangeCodec.createRequestBody(request, jContentLength);
                    RealBufferedSink realBufferedSink = new RealBufferedSink(new Sink(dispatcher, sinkCreateRequestBody, jContentLength) { // from class: okhttp3.internal.connection.Exchange$RequestBodySink
                        public long bytesReceived;
                        public boolean closed;
                        public boolean completed;
                        public final long contentLength;
                        public final Sink delegate;
                        public final /* synthetic */ Dispatcher this$0;

                        {
                            Intrinsics.checkNotNullParameter(sinkCreateRequestBody, "delegate");
                            this.delegate = sinkCreateRequestBody;
                            this.contentLength = jContentLength;
                        }

                        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                        public final void close() throws IOException {
                            if (this.closed) {
                                return;
                            }
                            this.closed = true;
                            long j = this.contentLength;
                            if (j != -1 && this.bytesReceived != j) {
                                throw new ProtocolException("unexpected end of stream");
                            }
                            try {
                                close$okio$ForwardingSink();
                                complete$1(null);
                            } catch (IOException e2) {
                                throw complete$1(e2);
                            }
                        }

                        public final void close$okio$ForwardingSink() {
                            this.delegate.close();
                        }

                        public final IOException complete$1(IOException iOException) {
                            if (this.completed) {
                                return iOException;
                            }
                            this.completed = true;
                            return this.this$0.bodyComplete(false, true, iOException);
                        }

                        @Override // okio.Sink, java.io.Flushable
                        public final void flush() throws IOException {
                            try {
                                flush$okio$ForwardingSink();
                            } catch (IOException e2) {
                                throw complete$1(e2);
                            }
                        }

                        public final void flush$okio$ForwardingSink() {
                            this.delegate.flush();
                        }

                        @Override // okio.Sink
                        public final Timeout timeout() {
                            return this.delegate.timeout();
                        }

                        public final String toString() {
                            return Exchange$RequestBodySink.class.getSimpleName() + '(' + this.delegate + ')';
                        }

                        @Override // okio.Sink
                        public final void write(Buffer buffer, long j) throws IOException {
                            if (this.closed) {
                                throw new IllegalStateException("closed");
                            }
                            long j2 = this.contentLength;
                            if (j2 == -1 || this.bytesReceived + j <= j2) {
                                try {
                                    this.delegate.write(buffer, j);
                                    this.bytesReceived += j;
                                    return;
                                } catch (IOException e2) {
                                    throw complete$1(e2);
                                }
                            }
                            throw new ProtocolException("expected " + j2 + " bytes but received " + (this.bytesReceived + j));
                        }
                    });
                    requestBody.writeTo(realBufferedSink);
                    realBufferedSink.close();
                } else {
                    call.messageDone$okhttp(dispatcher, true, false, null);
                    if (realConnection.http2Connection == null) {
                        exchangeCodec.getConnection().noNewExchanges$okhttp();
                    }
                }
                z2 = z;
                l = null;
            }
            try {
                exchangeCodec.finishRequest();
                if (responseHeaders == null) {
                    responseHeaders = dispatcher.readResponseHeaders(false);
                    Intrinsics.checkNotNull(responseHeaders);
                    if (z2) {
                        Intrinsics.checkNotNullParameter(call, "call");
                        z2 = false;
                    }
                }
                responseHeaders.request = request;
                responseHeaders.handshake = realConnection.handshake;
                responseHeaders.sentRequestAtMillis = jCurrentTimeMillis;
                responseHeaders.receivedResponseAtMillis = System.currentTimeMillis();
                Response responseBuild = responseHeaders.build();
                int i = responseBuild.code;
                if (i == 100) {
                    Response.Builder responseHeaders2 = dispatcher.readResponseHeaders(false);
                    Intrinsics.checkNotNull(responseHeaders2);
                    if (z2) {
                        Intrinsics.checkNotNullParameter(call, "call");
                    }
                    responseHeaders2.request = request;
                    responseHeaders2.handshake = realConnection.handshake;
                    responseHeaders2.sentRequestAtMillis = jCurrentTimeMillis;
                    responseHeaders2.receivedResponseAtMillis = System.currentTimeMillis();
                    responseBuild = responseHeaders2.build();
                    i = responseBuild.code;
                }
                Response.Builder builderNewBuilder = responseBuild.newBuilder();
                try {
                    String strHeader$default = Response.header$default("Content-Type", responseBuild);
                    final long jReportedContentLength = exchangeCodec.reportedContentLength(responseBuild);
                    final Source sourceOpenResponseBodySource = exchangeCodec.openResponseBodySource(responseBuild);
                    builderNewBuilder.body = new RealResponseBody(strHeader$default, jReportedContentLength, new RealBufferedSource(new Source(dispatcher, sourceOpenResponseBodySource, jReportedContentLength) { // from class: okhttp3.internal.connection.Exchange$ResponseBodySource
                        public long bytesReceived;
                        public boolean closed;
                        public boolean completed;
                        public final long contentLength;
                        public final Source delegate;
                        public boolean invokeStartEvent;
                        public final /* synthetic */ Dispatcher this$0;

                        {
                            Intrinsics.checkNotNullParameter(sourceOpenResponseBodySource, "delegate");
                            this.delegate = sourceOpenResponseBodySource;
                            this.contentLength = jReportedContentLength;
                            this.invokeStartEvent = true;
                            if (jReportedContentLength == 0) {
                                complete(null);
                            }
                        }

                        @Override // java.io.Closeable, java.lang.AutoCloseable
                        public final void close() throws IOException {
                            if (this.closed) {
                                return;
                            }
                            this.closed = true;
                            try {
                                close$okio$ForwardingSource();
                                complete(null);
                            } catch (IOException e2) {
                                throw complete(e2);
                            }
                        }

                        public final void close$okio$ForwardingSource() throws IOException {
                            this.delegate.close();
                        }

                        public final IOException complete(IOException iOException) {
                            if (this.completed) {
                                return iOException;
                            }
                            this.completed = true;
                            Dispatcher dispatcher2 = this.this$0;
                            if (iOException == null && this.invokeStartEvent) {
                                this.invokeStartEvent = false;
                                dispatcher2.getClass();
                                RealCall call2 = (RealCall) dispatcher2.readyAsyncCalls;
                                Intrinsics.checkNotNullParameter(call2, "call");
                            }
                            return dispatcher2.bodyComplete(true, false, iOException);
                        }

                        @Override // okio.Source
                        public final Timeout timeout() {
                            return this.delegate.timeout();
                        }

                        public final String toString() {
                            return Exchange$ResponseBodySource.class.getSimpleName() + '(' + this.delegate + ')';
                        }

                        @Override // okio.Source
                        public final long read(Buffer buffer, long j) throws IOException {
                            Intrinsics.checkNotNullParameter(buffer, ZRqOdXiy.jKfToAdSFfDd);
                            if (this.closed) {
                                throw new IllegalStateException("closed");
                            }
                            try {
                                long j2 = this.delegate.read(buffer, j);
                                if (this.invokeStartEvent) {
                                    this.invokeStartEvent = false;
                                    Dispatcher dispatcher2 = this.this$0;
                                    dispatcher2.getClass();
                                    Intrinsics.checkNotNullParameter((RealCall) dispatcher2.readyAsyncCalls, iafHZUfOuHNwvy.utvGsIpgfSJpmrU);
                                }
                                if (j2 == -1) {
                                    complete(null);
                                    return -1L;
                                }
                                long j3 = this.bytesReceived + j2;
                                long j4 = this.contentLength;
                                if (j4 == -1 || j3 <= j4) {
                                    this.bytesReceived = j3;
                                    if (j3 == j4) {
                                        complete(null);
                                    }
                                    return j2;
                                }
                                throw new ProtocolException("expected " + j4 + JrbhsraGtto.sLvzTUlm + j3);
                            } catch (IOException e2) {
                                throw complete(e2);
                            }
                        }
                    }));
                    Response responseBuild2 = builderNewBuilder.build();
                    if ("close".equalsIgnoreCase(((Headers) responseBuild2.request.headers).get("Connection")) || "close".equalsIgnoreCase(Response.header$default("Connection", responseBuild2))) {
                        exchangeCodec.getConnection().noNewExchanges$okhttp();
                    }
                    if (i == 204 || i == 205) {
                        RealResponseBody realResponseBody = responseBuild2.body;
                        if ((realResponseBody != null ? realResponseBody.contentLength() : -1L) > 0) {
                            StringBuilder sbM = Fragment$$ExternalSyntheticOutline0.m(i, "HTTP ", " had non-zero Content-Length: ");
                            sbM.append(realResponseBody != null ? Long.valueOf(realResponseBody.contentLength()) : l);
                            throw new ProtocolException(sbM.toString());
                        }
                    }
                    return responseBuild2;
                } catch (IOException e2) {
                    dispatcher.trackFailure(e2);
                    throw e2;
                }
            } catch (IOException e3) {
                dispatcher.trackFailure(e3);
                throw e3;
            }
        } catch (IOException e4) {
            Intrinsics.checkNotNullParameter(call, "call");
            dispatcher.trackFailure(e4);
            throw e4;
        }
    }
}
