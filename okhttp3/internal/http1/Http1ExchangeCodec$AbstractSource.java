package okhttp3.internal.http1;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okio.Buffer;
import okio.ForwardingTimeout;
import okio.RealBufferedSource;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Http1ExchangeCodec$AbstractSource implements Source {
    public boolean closed;
    public final /* synthetic */ RouteSelector this$0;
    public final ForwardingTimeout timeout;

    public Http1ExchangeCodec$AbstractSource(RouteSelector routeSelector) {
        this.this$0 = routeSelector;
        this.timeout = new ForwardingTimeout(((RealBufferedSource) routeSelector.routeDatabase).source.timeout());
    }

    public final void responseBodyComplete() {
        RouteSelector routeSelector = this.this$0;
        int i = routeSelector.nextProxyIndex;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + routeSelector.nextProxyIndex);
        }
        ForwardingTimeout forwardingTimeout = this.timeout;
        Timeout timeout = forwardingTimeout.delegate;
        forwardingTimeout.delegate = Timeout.NONE;
        timeout.clearDeadline();
        timeout.clearTimeout();
        routeSelector.nextProxyIndex = 6;
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.timeout;
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        RouteSelector routeSelector = this.this$0;
        Intrinsics.checkNotNullParameter(buffer, CyjpdoedCdLTIO.aMhFDIlFRUY);
        try {
            return ((RealBufferedSource) routeSelector.routeDatabase).read(buffer, j);
        } catch (IOException e) {
            ((RealConnection) routeSelector.address).noNewExchanges$okhttp();
            responseBodyComplete();
            throw e;
        }
    }
}
