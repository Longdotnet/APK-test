package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class EncodedPayload {
    public final byte[] bytes;
    public final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.encoding = encoding;
        this.bytes = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.encoding.equals(encodedPayload.encoding)) {
            return Arrays.equals(this.bytes, encodedPayload.bytes);
        }
        return false;
    }

    public final int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }
}
