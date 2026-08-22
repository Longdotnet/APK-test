package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api20Impl {
    public static Notification.Builder addAction(Notification.Builder builder, Notification.Action action) {
        return builder.addAction(action);
    }

    public static Notification.Action.Builder addExtras(Notification.Action.Builder builder, Bundle bundle) {
        return builder.addExtras(bundle);
    }

    public static Notification.Action.Builder addRemoteInput(Notification.Action.Builder builder, RemoteInput remoteInput) {
        return builder.addRemoteInput(remoteInput);
    }

    public static Notification.Action build(Notification.Action.Builder builder) {
        return builder.build();
    }

    public static Notification.Action.Builder createBuilder(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(i, charSequence, pendingIntent);
    }

    public static String getGroup(Notification notification) {
        return notification.getGroup();
    }

    public static Notification.Builder setGroup(Notification.Builder builder, String str) {
        return builder.setGroup(str);
    }

    public static Notification.Builder setGroupSummary(Notification.Builder builder, boolean z) {
        return builder.setGroupSummary(z);
    }

    public static Notification.Builder setLocalOnly(Notification.Builder builder, boolean z) {
        return builder.setLocalOnly(z);
    }

    public static Notification.Builder setSortKey(Notification.Builder builder, String str) {
        return builder.setSortKey(str);
    }
}
