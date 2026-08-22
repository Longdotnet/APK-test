package okio;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    String readString(Charset charset);

    int select(Options options);
}
