package androidx.core.app;

import android.app.Notification;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api31Impl {
    public static Notification.Action.Builder setAuthenticationRequired(Notification.Action.Builder builder, boolean z) {
        return builder.setAuthenticationRequired(z);
    }

    public static Notification.Builder setForegroundServiceBehavior(Notification.Builder builder, int i) {
        return builder.setForegroundServiceBehavior(i);
    }
}
