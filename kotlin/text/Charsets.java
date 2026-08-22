package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Charsets {
    public static final Charset UTF_8;
    public static volatile Charset utf_32be;
    public static volatile Charset utf_32le;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
        UTF_8 = charsetForName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        Intrinsics.checkNotNullExpressionValue(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
