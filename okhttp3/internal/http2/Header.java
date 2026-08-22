package okhttp3.internal.http2;

import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Header {
    public static final ByteString PSEUDO_PREFIX;
    public static final ByteString RESPONSE_STATUS;
    public static final ByteString TARGET_AUTHORITY;
    public static final ByteString TARGET_METHOD;
    public static final ByteString TARGET_PATH;
    public static final ByteString TARGET_SCHEME;
    public final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    static {
        ByteString byteString = ByteString.EMPTY;
        PSEUDO_PREFIX = JSONObject.Null.encodeUtf8(":");
        RESPONSE_STATUS = JSONObject.Null.encodeUtf8(":status");
        TARGET_METHOD = JSONObject.Null.encodeUtf8(":method");
        TARGET_PATH = JSONObject.Null.encodeUtf8(":path");
        TARGET_SCHEME = JSONObject.Null.encodeUtf8(":scheme");
        TARGET_AUTHORITY = JSONObject.Null.encodeUtf8(":authority");
    }

    public Header(ByteString name, ByteString value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
        this.hpackSize = value.getSize$okio() + name.getSize$okio() + 32;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual(this.name, header.name) && Intrinsics.areEqual(this.value, header.value);
    }

    public final int hashCode() {
        ByteString byteString = this.name;
        int iHashCode = (byteString != null ? byteString.hashCode() : 0) * 31;
        ByteString byteString2 = this.value;
        return iHashCode + (byteString2 != null ? byteString2.hashCode() : 0);
    }

    public final String toString() {
        return this.name.utf8() + ": " + this.value.utf8();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String name, String value) {
        this(JSONObject.Null.encodeUtf8(name), JSONObject.Null.encodeUtf8(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString byteString = ByteString.EMPTY;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(ByteString name, String value) {
        this(name, JSONObject.Null.encodeUtf8(value));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        ByteString byteString = ByteString.EMPTY;
    }
}
