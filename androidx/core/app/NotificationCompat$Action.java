package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$Action {
    public final PendingIntent actionIntent;
    public final int icon;
    public final boolean mAllowGeneratedReplies;
    public final Bundle mExtras;
    public IconCompat mIcon;
    public final boolean mShowsUserInterface;
    public final CharSequence title;

    public NotificationCompat$Action(String str, PendingIntent pendingIntent) {
        IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(2131165300);
        Bundle bundle = new Bundle();
        this.mShowsUserInterface = true;
        this.mIcon = iconCompatCreateWithResource;
        if (iconCompatCreateWithResource.getType() == 2) {
            this.icon = iconCompatCreateWithResource.getResId();
        }
        this.title = NotificationCompat$Builder.limitCharSequenceLength(str);
        this.actionIntent = pendingIntent;
        this.mExtras = bundle;
        this.mAllowGeneratedReplies = true;
        this.mShowsUserInterface = true;
    }
}
