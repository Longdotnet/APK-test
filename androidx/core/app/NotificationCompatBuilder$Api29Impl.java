package androidx.core.app;

import android.app.Notification;
import android.content.LocusId;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatBuilder$Api29Impl {
    public static Notification.Builder setAllowSystemGeneratedContextualActions(Notification.Builder builder, boolean z) {
        return builder.setAllowSystemGeneratedContextualActions(z);
    }

    public static Notification.Builder setBubbleMetadata(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
        return builder.setBubbleMetadata(bubbleMetadata);
    }

    public static Notification.Action.Builder setContextual(Notification.Action.Builder builder, boolean z) {
        return builder.setContextual(z);
    }

    public static Notification.Builder setLocusId(Notification.Builder builder, Object obj) {
        return builder.setLocusId((LocusId) obj);
    }
}
