package androidx.core.app;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationCompat$BigPictureStyle extends NotificationCompat$Style {
    public IconCompat mBigLargeIcon;
    public boolean mBigLargeIconSet;
    public IconCompat mPictureIcon;

    public abstract class Api23Impl {
        public static void setBigLargeIcon(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigLargeIcon(icon);
        }
    }

    public abstract class Api31Impl {
        public static void setBigPicture(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
            bigPictureStyle.bigPicture(icon);
        }

        public static void setContentDescription(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
            bigPictureStyle.setContentDescription(charSequence);
        }

        public static void showBigPictureWhenCollapsed(Notification.BigPictureStyle bigPictureStyle, boolean z) {
            bigPictureStyle.showBigPictureWhenCollapsed(z);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final void apply(Dispatcher dispatcher) {
        Bitmap bitmapCreateLegacyIconFromAdaptiveIcon;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle((Notification.Builder) dispatcher.readyAsyncCalls).setBigContentTitle(null);
        IconCompat iconCompat = this.mPictureIcon;
        Context context = (Context) dispatcher.executorServiceOrNull;
        if (iconCompat != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                Api31Impl.setBigPicture(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat, context));
            } else if (iconCompat.getType() == 1) {
                IconCompat iconCompat2 = this.mPictureIcon;
                int i = iconCompat2.mType;
                if (i == -1) {
                    Object obj = iconCompat2.mObj1;
                    bitmapCreateLegacyIconFromAdaptiveIcon = obj instanceof Bitmap ? (Bitmap) obj : null;
                } else if (i == 1) {
                    bitmapCreateLegacyIconFromAdaptiveIcon = (Bitmap) iconCompat2.mObj1;
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                    }
                    bitmapCreateLegacyIconFromAdaptiveIcon = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap) iconCompat2.mObj1, true);
                }
                bigContentTitle = bigContentTitle.bigPicture(bitmapCreateLegacyIconFromAdaptiveIcon);
            }
        }
        if (this.mBigLargeIconSet) {
            IconCompat iconCompat3 = this.mBigLargeIcon;
            if (iconCompat3 == null) {
                bigContentTitle.bigLargeIcon((Bitmap) null);
            } else {
                Api23Impl.setBigLargeIcon(bigContentTitle, IconCompat.Api23Impl.toIcon(iconCompat3, context));
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            Api31Impl.showBigPictureWhenCollapsed(bigContentTitle, false);
            Api31Impl.setContentDescription(bigContentTitle, null);
        }
    }

    @Override // androidx.core.app.NotificationCompat$Style
    public final String getClassName() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
