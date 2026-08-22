package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okhttp3.internal.concurrent.Task;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection$pushHeadersLater$$inlined$execute$1 extends Task {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ List $requestHeaders$inlined;
    public final /* synthetic */ int $streamId$inlined;
    public final /* synthetic */ Http2Connection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushHeadersLater$$inlined$execute$1(String str, Http2Connection http2Connection, int i, List list) {
        super(str, true);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$requestHeaders$inlined = list;
    }

    private final long runOnce$okhttp3$internal$http2$Http2Connection$pushHeadersLater$$inlined$execute$1() {
        this.this$0.pushObserver.getClass();
        try {
            this.this$0.writer.rstStream(this.$streamId$inlined, 9);
            synchronized (this.this$0) {
                this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        switch (this.$r8$classId) {
            case 0:
                return runOnce$okhttp3$internal$http2$Http2Connection$pushHeadersLater$$inlined$execute$1();
            default:
                this.this$0.pushObserver.getClass();
                try {
                    this.this$0.writer.rstStream(this.$streamId$inlined, 9);
                    synchronized (this.this$0) {
                        this.this$0.currentPushRequests.remove(Integer.valueOf(this.$streamId$inlined));
                    }
                    return -1L;
                } catch (IOException unused) {
                    return -1L;
                }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$pushHeadersLater$$inlined$execute$1(String str, Http2Connection http2Connection, int i, List list, boolean z) {
        super(str, true);
        this.this$0 = http2Connection;
        this.$streamId$inlined = i;
        this.$requestHeaders$inlined = list;
    }
}
