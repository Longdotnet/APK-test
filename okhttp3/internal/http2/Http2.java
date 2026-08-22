package okhttp3.internal.http2;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Http2 {
    public static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    public static final String[] FLAGS;
    public static final String[] FRAME_NAMES;

    /* JADX WARN: Code duplicated, block: B:34:0x0068  */
    public static String frameLog(boolean z, int i, int i2, int i3, int i4) {
        String strReplace$default;
        String str;
        String[] strArr = FRAME_NAMES;
        String str2 = i3 < strArr.length ? strArr[i3] : Util.format("0x%02x", Integer.valueOf(i3));
        if (i4 == 0) {
            strReplace$default = "";
        } else {
            String[] strArr2 = BINARY;
            if (i3 == 2 || i3 == 3) {
                strReplace$default = strArr2[i4];
            } else if (i3 == 4 || i3 == 6) {
                strReplace$default = i4 == 1 ? "ACK" : strArr2[i4];
            } else if (i3 == 7 || i3 == 8) {
                strReplace$default = strArr2[i4];
            } else {
                String[] strArr3 = FLAGS;
                if (i4 < strArr3.length) {
                    str = strArr3[i4];
                    Intrinsics.checkNotNull(str);
                } else {
                    str = strArr2[i4];
                }
                if (i3 != 5 || (i4 & 4) == 0) {
                    strReplace$default = (i3 != 0 || (i4 & 32) == 0) ? str : StringsKt__StringsKt.replace$default(str, "PRIORITY", "COMPRESSED");
                } else {
                    strReplace$default = StringsKt__StringsKt.replace$default(str, "HEADERS", "PUSH_PROMISE");
                }
            }
        }
        return Util.format("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), str2, strReplace$default);
    }

    static {
        ByteString byteString = ByteString.EMPTY;
        CONNECTION_PREFACE = JSONObject.Null.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", TSDAbK.xzagYynRNlv, "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "Integer.toBinaryString(it)");
            String strReplace = Util.format("%8s", binaryString).replace(' ', '0');
            Intrinsics.checkNotNullExpressionValue(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            strArr[i] = strReplace;
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = Intrinsics.stringPlus("|PADDED", strArr2[i2]);
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = FLAGS;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + "|" + strArr3[i4];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i5]);
            sb.append("|");
            strArr3[i6 | 8] = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, strArr3[i4], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i7] == null) {
                strArr4[i7] = BINARY[i7];
            }
        }
    }
}
