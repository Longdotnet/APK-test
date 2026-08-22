package androidx.core.app;

import android.app.Notification;
import android.widget.RemoteViews;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api24Impl {
    public static Notification.Action.Builder setAllowGeneratedReplies(Notification.Action.Builder builder, boolean z) {
        return builder.setAllowGeneratedReplies(z);
    }

    public static Notification.Builder setCustomBigContentView(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomBigContentView(remoteViews);
    }

    public static Notification.Builder setCustomContentView(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomContentView(remoteViews);
    }

    public static Notification.Builder setCustomHeadsUpContentView(Notification.Builder builder, RemoteViews remoteViews) {
        return builder.setCustomHeadsUpContentView(remoteViews);
    }

    public static Notification.Builder setRemoteInputHistory(Notification.Builder builder, CharSequence[] charSequenceArr) {
        return builder.setRemoteInputHistory(charSequenceArr);
    }
}
