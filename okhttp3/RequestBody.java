package okhttp3;

import okio.RealBufferedSink;

/* JADX INFO: loaded from: classes3.dex */
public abstract class RequestBody {
    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract void writeTo(RealBufferedSink realBufferedSink);
}
