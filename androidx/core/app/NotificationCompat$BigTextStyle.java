package androidx.core.app;

import android.app.Notification;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$BigTextStyle extends NotificationCompat$Style {
    public CharSequence mBigText;

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(Dispatcher dispatcher) {
        new Notification.BigTextStyle((Notification.Builder) dispatcher.readyAsyncCalls).setBigContentTitle(null).bigText(this.mBigText);
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }
}
