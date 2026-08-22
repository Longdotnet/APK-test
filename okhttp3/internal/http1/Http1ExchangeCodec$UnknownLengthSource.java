package okhttp3.internal.http1;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Http1ExchangeCodec$UnknownLengthSource extends Http1ExchangeCodec$AbstractSource {
    public boolean inputExhausted;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.closed) {
            return;
        }
        if (!this.inputExhausted) {
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
        if (this.inputExhausted) {
            return -1L;
        }
        long j2 = super.read(sink, j);
        if (j2 != -1) {
            return j2;
        }
        this.inputExhausted = true;
        responseBodyComplete();
        return -1L;
    }
}
