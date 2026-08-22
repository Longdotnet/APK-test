package okhttp3.internal.http2;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.IOException;
import okhttp3.internal.concurrent.Task;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection$pushResetLater$$inlined$execute$1 extends Task {
    public final /* synthetic */ int $errorCode$inlined;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Http2Connection$pushResetLater$$inlined$execute$1(String str, Object obj, int i, int i2, int i3) {
        super(str, true);
        this.$r8$classId = i3;
        this.this$0 = obj;
        this.$streamId$inlined = i;
        this.$errorCode$inlined = i2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        switch (this.$r8$classId) {
            case 0:
                PushObserver$Companion$PushObserverCancel pushObserver$Companion$PushObserverCancel = ((Http2Connection) this.this$0).pushObserver;
                int i = this.$errorCode$inlined;
                pushObserver$Companion$PushObserverCancel.getClass();
                BarcodeFormat$EnumUnboxingLocalUtility.m(i, "errorCode");
                synchronized (((Http2Connection) this.this$0)) {
                    ((Http2Connection) this.this$0).currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                }
                return -1L;
            case 1:
                Http2Connection http2Connection = (Http2Connection) this.this$0;
                try {
                    int i2 = this.$streamId$inlined;
                    int i3 = this.$errorCode$inlined;
                    http2Connection.getClass();
                    BarcodeFormat$EnumUnboxingLocalUtility.m(i3, "statusCode");
                    http2Connection.writer.rstStream(i2, i3);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
            default:
                Http2Connection http2Connection2 = ((Http2Connection.ReaderRunnable) this.this$0).this$0;
                int i4 = this.$streamId$inlined;
                int i5 = this.$errorCode$inlined;
                http2Connection2.getClass();
                try {
                    http2Connection2.writer.ping(i4, i5, true);
                    return -1L;
                } catch (IOException e2) {
                    http2Connection2.close$okhttp(2, 2, e2);
                    return -1L;
                }
        }
    }
}
