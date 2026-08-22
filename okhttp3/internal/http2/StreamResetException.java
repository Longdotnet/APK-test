package okhttp3.internal.http2;

import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class StreamResetException extends IOException {
    public final int errorCode;

    /* JADX WARN: Illegal instructions before constructor call */
    public StreamResetException(int i) {
        String str;
        BarcodeFormat$EnumUnboxingLocalUtility.m(i, FKidOcdAYt.auKxFlLsCiWI);
        switch (i) {
            case 1:
                str = "NO_ERROR";
                break;
            case 2:
                str = "PROTOCOL_ERROR";
                break;
            case 3:
                str = "INTERNAL_ERROR";
                break;
            case 4:
                str = "FLOW_CONTROL_ERROR";
                break;
            case 5:
                str = "SETTINGS_TIMEOUT";
                break;
            case 6:
                str = "STREAM_CLOSED";
                break;
            case 7:
                str = "FRAME_SIZE_ERROR";
                break;
            case 8:
                str = "REFUSED_STREAM";
                break;
            case 9:
                str = "CANCEL";
                break;
            case 10:
                str = "COMPRESSION_ERROR";
                break;
            case 11:
                str = "CONNECT_ERROR";
                break;
            case 12:
                str = "ENHANCE_YOUR_CALM";
                break;
            case 13:
                str = "INADEQUATE_SECURITY";
                break;
            case 14:
                str = "HTTP_1_1_REQUIRED";
                break;
            default:
                str = "null";
                break;
        }
        super("stream was reset: ".concat(str));
        this.errorCode = i;
    }
}
