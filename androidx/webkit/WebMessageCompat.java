package androidx.webkit;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class WebMessageCompat {
    public final String mString;
    public final int mType;

    public WebMessageCompat(String str) {
        this.mString = str;
        this.mType = 0;
    }

    public WebMessageCompat(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.mString = null;
        this.mType = 1;
    }
}
