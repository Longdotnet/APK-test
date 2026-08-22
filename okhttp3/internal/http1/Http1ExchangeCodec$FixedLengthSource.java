package okhttp3.internal.http1;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Http1ExchangeCodec$FixedLengthSource extends Http1ExchangeCodec$AbstractSource {
    public long bytesRemaining;
    public final /* synthetic */ RouteSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http1ExchangeCodec$FixedLengthSource(RouteSelector routeSelector, long j) {
        super(routeSelector);
        this.this$0 = routeSelector;
        this.bytesRemaining = j;
        if (j == 0) {
            responseBodyComplete();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        if (this.bytesRemaining != 0 && !Util.discard(this, TimeUnit.MILLISECONDS)) {
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
            throw new IllegalStateException("closed");
        }
        long j2 = this.bytesRemaining;
        if (j2 == 0) {
            return -1L;
        }
        long j3 = super.read(sink, Math.min(j2, j));
        if (j3 == -1) {
            ((RealConnection) this.this$0.address).noNewExchanges$okhttp();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            responseBodyComplete();
            throw protocolException;
        }
        long j4 = this.bytesRemaining - j3;
        this.bytesRemaining = j4;
        if (j4 == 0) {
            responseBodyComplete();
        }
        return j3;
    }
}
