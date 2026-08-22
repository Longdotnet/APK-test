package androidx.core.app;

import android.app.Notification;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api26Impl {
    public static Notification.Builder createBuilder(Context context, String str) {
        return new Notification.Builder(context, str);
    }

    public static Notification.Builder setBadgeIconType(Notification.Builder builder, int i) {
        return builder.setBadgeIconType(i);
    }

    public static Notification.Builder setColorized(Notification.Builder builder, boolean z) {
        return builder.setColorized(z);
    }

    public static Notification.Builder setGroupAlertBehavior(Notification.Builder builder, int i) {
        return builder.setGroupAlertBehavior(i);
    }

    public static Notification.Builder setSettingsText(Notification.Builder builder, CharSequence charSequence) {
        return builder.setSettingsText(charSequence);
    }

    public static Notification.Builder setShortcutId(Notification.Builder builder, String str) {
        return builder.setShortcutId(str);
    }

    public static Notification.Builder setTimeoutAfter(Notification.Builder builder, long j) {
        return builder.setTimeoutAfter(j);
    }
}
