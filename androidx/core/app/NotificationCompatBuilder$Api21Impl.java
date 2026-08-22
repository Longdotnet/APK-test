package androidx.core.app;

import android.app.Notification;
import android.media.AudioAttributes;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api21Impl {
    public static Notification.Builder addPerson(Notification.Builder builder, String str) {
        return builder.addPerson(str);
    }

    public static Notification.Builder setCategory(Notification.Builder builder, String str) {
        return builder.setCategory(str);
    }

    public static Notification.Builder setColor(Notification.Builder builder, int i) {
        return builder.setColor(i);
    }

    public static Notification.Builder setPublicVersion(Notification.Builder builder, Notification notification) {
        return builder.setPublicVersion(notification);
    }

    public static Notification.Builder setSound(Notification.Builder builder, Uri uri, Object obj) {
        return builder.setSound(uri, (AudioAttributes) obj);
    }

    public static Notification.Builder setVisibility(Notification.Builder builder, int i) {
        return builder.setVisibility(i);
    }
}
