package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.InitializedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.Task;

/* JADX INFO: loaded from: classes3.dex */
public final class Http2Connection$ReaderRunnable$settings$$inlined$execute$1 extends Task {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $settings$inlined;
    public final /* synthetic */ Http2Connection.ReaderRunnable this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Http2Connection$ReaderRunnable$settings$$inlined$execute$1(String str, Http2Connection.ReaderRunnable readerRunnable, Object obj, int i) {
        super(str, true);
        this.$r8$classId = i;
        this.this$0 = readerRunnable;
        this.$settings$inlined = obj;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        long initialWindowSize;
        int i;
        Http2Stream[] http2StreamArr;
        switch (this.$r8$classId) {
            case 0:
                Http2Connection.ReaderRunnable readerRunnable = this.this$0;
                Settings settings = (Settings) this.$settings$inlined;
                readerRunnable.getClass();
                InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl();
                synchronized (Http2Connection.this.writer) {
                    synchronized (Http2Connection.this) {
                        try {
                            Settings settings2 = Http2Connection.this.peerSettings;
                            Settings settings3 = new Settings();
                            settings3.merge(settings2);
                            settings3.merge(settings);
                            initializedLazyImpl.value = settings3;
                            initialWindowSize = ((long) settings3.getInitialWindowSize()) - ((long) settings2.getInitialWindowSize());
                            if (initialWindowSize == 0 || Http2Connection.this.streams.isEmpty()) {
                                http2StreamArr = null;
                            } else {
                                Object[] array = Http2Connection.this.streams.values().toArray(new Http2Stream[0]);
                                if (array == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                                http2StreamArr = (Http2Stream[]) array;
                            }
                            Http2Connection http2Connection = Http2Connection.this;
                            Settings settings4 = (Settings) initializedLazyImpl.value;
                            http2Connection.getClass();
                            Intrinsics.checkNotNullParameter(settings4, "<set-?>");
                            http2Connection.peerSettings = settings4;
                            Http2Connection.this.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$1(Http2Connection.this.connectionName + " onSettings", readerRunnable, initializedLazyImpl, 1), 0L);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        Http2Connection.this.writer.applyAndAckSettings((Settings) initializedLazyImpl.value);
                    } catch (IOException e) {
                        Http2Connection.this.close$okhttp(2, 2, e);
                    }
                    break;
                }
                Http2Stream[] http2StreamArr2 = http2StreamArr;
                if (http2StreamArr2 == null) {
                    return -1L;
                }
                for (Http2Stream http2Stream : http2StreamArr2) {
                    synchronized (http2Stream) {
                        http2Stream.writeBytesMaximum += initialWindowSize;
                        if (initialWindowSize > 0) {
                            http2Stream.notifyAll();
                        }
                        break;
                    }
                }
                return -1L;
            default:
                Http2Connection http2Connection2 = Http2Connection.this;
                http2Connection2.listener.onSettings(http2Connection2, (Settings) ((InitializedLazyImpl) this.$settings$inlined).value);
                return -1L;
        }
    }
}
