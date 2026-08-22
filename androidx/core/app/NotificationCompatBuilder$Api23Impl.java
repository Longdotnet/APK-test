package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.drawable.Icon;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api23Impl {
    public static Notification.Action.Builder createBuilder(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
        return new Notification.Action.Builder(icon, charSequence, pendingIntent);
    }

    public static Notification.Builder setLargeIcon(Notification.Builder builder, Icon icon) {
        return builder.setLargeIcon(icon);
    }

    public static Notification.Builder setSmallIcon(Notification.Builder builder, Object obj) {
        return builder.setSmallIcon((Icon) obj);
    }
}
