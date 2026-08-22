package okio;

import org.json.JSONObject;

/* JADX INFO: renamed from: okio.-Base64, reason: invalid class name */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Base64 {
    public static final byte[] BASE64;

    static {
        ByteString byteString = ByteString.EMPTY;
        BASE64 = JSONObject.Null.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").data;
        JSONObject.Null.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }
}
