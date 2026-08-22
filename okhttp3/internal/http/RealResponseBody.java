package okhttp3.internal.http;

import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.RealBufferedSource;

/* JADX INFO: loaded from: classes3.dex */
public final class RealResponseBody implements Closeable {
    public final /* synthetic */ int $r8$classId = 0;
    public final long contentLength;
    public final Object contentTypeString;
    public final Object source;

    public RealResponseBody(String str, long j, RealBufferedSource realBufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = realBufferedSource;
    }

    public final Charset charset() {
        MediaType mediaType;
        String str = null;
        switch (this.$r8$classId) {
            case 0:
                String str2 = (String) this.contentTypeString;
                if (str2 == null) {
                    mediaType = null;
                } else {
                    Pattern pattern = MediaType.TYPE_SUBTYPE;
                    try {
                        mediaType = MediaType.Companion.get(str2);
                    } catch (IllegalArgumentException unused) {
                        mediaType = null;
                    }
                }
                break;
            default:
                mediaType = (MediaType) this.source;
                break;
        }
        if (mediaType != null) {
            Charset charsetForName = Charsets.UTF_8;
            String[] strArr = mediaType.parameterNamesAndValues;
            IntProgression intProgressionStep = RangesKt.step(new IntRange(0, strArr.length - 1, 1), 2);
            int i = intProgressionStep.first;
            int i2 = intProgressionStep.last;
            int i3 = intProgressionStep.step;
            if (i3 < 0 ? i >= i2 : i <= i2) {
                while (true) {
                    if (StringsKt__StringsKt.equals(strArr[i], "charset")) {
                        str = strArr[i + 1];
                    } else if (i != i2) {
                        i += i3;
                    }
                }
            }
            if (str != null) {
                try {
                    charsetForName = Charset.forName(str);
                } catch (IllegalArgumentException unused2) {
                }
            }
            if (charsetForName != null) {
                return charsetForName;
            }
        }
        return Charsets.UTF_8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Util.closeQuietly(source());
    }

    public final long contentLength() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.contentLength;
    }

    public final BufferedSource source() {
        switch (this.$r8$classId) {
            case 0:
                return (RealBufferedSource) this.source;
            default:
                return (Buffer) this.contentTypeString;
        }
    }

    public RealResponseBody(Buffer buffer, MediaType mediaType, long j) {
        this.contentTypeString = buffer;
        this.source = mediaType;
        this.contentLength = j;
    }
}
