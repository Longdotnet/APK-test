package okio;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink writeUtf8(String str);
}
