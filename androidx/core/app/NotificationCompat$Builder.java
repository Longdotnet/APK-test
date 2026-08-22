package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCompat$Builder {
    public final boolean mAllowSystemGeneratedContextualActions;
    public String mChannelId;
    public PendingIntent mContentIntent;
    public CharSequence mContentText;
    public CharSequence mContentTitle;
    public final Context mContext;
    public Bundle mExtras;
    public IconCompat mLargeIcon;
    public final Notification mNotification;
    public final ArrayList mPeople;
    public int mPriority;
    public NotificationCompat$Style mStyle;
    public final ArrayList mActions = new ArrayList();
    public final ArrayList mPersonList = new ArrayList();
    public final ArrayList mInvisibleActions = new ArrayList();
    public final boolean mShowWhen = true;
    public boolean mLocalOnly = false;

    public NotificationCompat$Builder(Context context, String str) {
        Notification notification = new Notification();
        this.mNotification = notification;
        this.mContext = context;
        this.mChannelId = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.mPriority = 0;
        this.mPeople = new ArrayList();
        this.mAllowSystemGeneratedContextualActions = true;
    }

    public static CharSequence limitCharSequenceLength(String str) {
        return (str != null && str.length() > 5120) ? str.subSequence(0, 5120) : str;
    }

    public final void setLargeIcon(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 27) {
            Resources resources = this.mContext.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
            }
        }
        PorterDuff.Mode mode = IconCompat.DEFAULT_TINT_MODE;
        bitmap.getClass();
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.mObj1 = bitmap;
        this.mLargeIcon = iconCompat;
    }

    public final void setStyle(NotificationCompat$Style notificationCompat$Style) {
        if (this.mStyle != notificationCompat$Style) {
            this.mStyle = notificationCompat$Style;
            if (((NotificationCompat$Builder) notificationCompat$Style.mBuilder) != this) {
                notificationCompat$Style.mBuilder = this;
                setStyle(notificationCompat$Style);
            }
        }
    }

    public final Notification build() {
        String str;
        Notification notificationBuild;
        Bundle bundle;
        int i;
        ArrayList arrayList;
        int i2;
        Dispatcher dispatcher = new Dispatcher();
        new ArrayList();
        dispatcher.runningSyncCalls = new Bundle();
        dispatcher.runningAsyncCalls = this;
        Context context = this.mContext;
        dispatcher.executorServiceOrNull = context;
        if (Build.VERSION.SDK_INT >= 26) {
            dispatcher.readyAsyncCalls = NotificationCompatBuilder$Api26Impl.createBuilder(context, this.mChannelId);
        } else {
            dispatcher.readyAsyncCalls = new Notification.Builder(this.mContext);
        }
        Notification notification = this.mNotification;
        int i3 = 0;
        ((Notification.Builder) dispatcher.readyAsyncCalls).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(this.mContentTitle).setContentText(this.mContentText).setContentInfo(null).setContentIntent(this.mContentIntent).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        Notification.Builder builder = (Notification.Builder) dispatcher.readyAsyncCalls;
        IconCompat iconCompat = this.mLargeIcon;
        NotificationCompatBuilder$Api23Impl.setLargeIcon(builder, iconCompat == null ? null : IconCompat.Api23Impl.toIcon(iconCompat, context));
        ((Notification.Builder) dispatcher.readyAsyncCalls).setSubText(null).setUsesChronometer(false).setPriority(this.mPriority);
        Iterator it = this.mActions.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            str = xPQrbOSWiEdU.DkDuwBx;
            if (!zHasNext) {
                break;
            }
            NotificationCompat$Action notificationCompat$Action = (NotificationCompat$Action) it.next();
            if (notificationCompat$Action.mIcon == null && (i2 = notificationCompat$Action.icon) != 0) {
                notificationCompat$Action.mIcon = IconCompat.createWithResource(i2);
            }
            IconCompat iconCompat2 = notificationCompat$Action.mIcon;
            Notification.Action.Builder builderCreateBuilder = NotificationCompatBuilder$Api23Impl.createBuilder(iconCompat2 != null ? IconCompat.Api23Impl.toIcon(iconCompat2, null) : null, notificationCompat$Action.title, notificationCompat$Action.actionIntent);
            Bundle bundle2 = notificationCompat$Action.mExtras;
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle2) : new Bundle();
            boolean z = notificationCompat$Action.mAllowGeneratedReplies;
            bundle3.putBoolean(str, z);
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                NotificationCompatBuilder$Api24Impl.setAllowGeneratedReplies(builderCreateBuilder, z);
            }
            bundle3.putInt("android.support.action.semanticAction", 0);
            if (i4 >= 28) {
                NotificationCompatBuilder$Api28Impl.setSemanticAction(builderCreateBuilder, 0);
            }
            if (i4 >= 29) {
                NotificationCompatBuilder$Api29Impl.setContextual(builderCreateBuilder, false);
            }
            if (i4 >= 31) {
                NotificationCompatBuilder$Api31Impl.setAuthenticationRequired(builderCreateBuilder, false);
            }
            bundle3.putBoolean("android.support.action.showsUserInterface", notificationCompat$Action.mShowsUserInterface);
            NotificationCompatBuilder$Api20Impl.addExtras(builderCreateBuilder, bundle3);
            NotificationCompatBuilder$Api20Impl.addAction((Notification.Builder) dispatcher.readyAsyncCalls, NotificationCompatBuilder$Api20Impl.build(builderCreateBuilder));
        }
        Bundle bundle4 = this.mExtras;
        if (bundle4 != null) {
            ((Bundle) dispatcher.runningSyncCalls).putAll(bundle4);
        }
        int i5 = Build.VERSION.SDK_INT;
        ((Notification.Builder) dispatcher.readyAsyncCalls).setShowWhen(this.mShowWhen);
        NotificationCompatBuilder$Api20Impl.setLocalOnly((Notification.Builder) dispatcher.readyAsyncCalls, this.mLocalOnly);
        NotificationCompatBuilder$Api20Impl.setGroup((Notification.Builder) dispatcher.readyAsyncCalls, null);
        NotificationCompatBuilder$Api20Impl.setSortKey((Notification.Builder) dispatcher.readyAsyncCalls, null);
        NotificationCompatBuilder$Api20Impl.setGroupSummary((Notification.Builder) dispatcher.readyAsyncCalls, false);
        NotificationCompatBuilder$Api21Impl.setCategory((Notification.Builder) dispatcher.readyAsyncCalls, null);
        NotificationCompatBuilder$Api21Impl.setColor((Notification.Builder) dispatcher.readyAsyncCalls, 0);
        NotificationCompatBuilder$Api21Impl.setVisibility((Notification.Builder) dispatcher.readyAsyncCalls, 0);
        NotificationCompatBuilder$Api21Impl.setPublicVersion((Notification.Builder) dispatcher.readyAsyncCalls, null);
        NotificationCompatBuilder$Api21Impl.setSound((Notification.Builder) dispatcher.readyAsyncCalls, notification.sound, notification.audioAttributes);
        ArrayList arrayList2 = this.mPeople;
        ArrayList arrayList3 = this.mPersonList;
        if (i5 < 28) {
            if (arrayList3 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList3.size());
                Iterator it2 = arrayList3.iterator();
                if (it2.hasNext()) {
                    it2.next().getClass();
                    throw new ClassCastException();
                }
            }
            if (arrayList != null) {
                if (arrayList2 == null) {
                    arrayList2 = arrayList;
                } else {
                    ArraySet arraySet = new ArraySet(arrayList2.size() + arrayList.size());
                    arraySet.addAll(arrayList);
                    arraySet.addAll(arrayList2);
                    arrayList2 = new ArrayList(arraySet);
                }
            }
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                NotificationCompatBuilder$Api21Impl.addPerson((Notification.Builder) dispatcher.readyAsyncCalls, (String) it3.next());
            }
        }
        ArrayList arrayList4 = this.mInvisibleActions;
        if (arrayList4.size() > 0) {
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            Bundle bundle5 = this.mExtras.getBundle("android.car.EXTENSIONS");
            if (bundle5 == null) {
                bundle5 = new Bundle();
            }
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            int i6 = 0;
            while (i6 < arrayList4.size()) {
                String string = Integer.toString(i6);
                NotificationCompat$Action notificationCompat$Action2 = (NotificationCompat$Action) arrayList4.get(i6);
                Bundle bundle8 = new Bundle();
                if (notificationCompat$Action2.mIcon == null && (i = notificationCompat$Action2.icon) != 0) {
                    notificationCompat$Action2.mIcon = IconCompat.createWithResource(i);
                }
                IconCompat iconCompat3 = notificationCompat$Action2.mIcon;
                bundle8.putInt("icon", iconCompat3 != null ? iconCompat3.getResId() : i3);
                bundle8.putCharSequence("title", notificationCompat$Action2.title);
                bundle8.putParcelable("actionIntent", notificationCompat$Action2.actionIntent);
                Bundle bundle9 = notificationCompat$Action2.mExtras;
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean(str, notificationCompat$Action2.mAllowGeneratedReplies);
                bundle8.putBundle("extras", bundle10);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", notificationCompat$Action2.mShowsUserInterface);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
                i6++;
                i3 = 0;
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (this.mExtras == null) {
                this.mExtras = new Bundle();
            }
            this.mExtras.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) dispatcher.runningSyncCalls).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            ((Notification.Builder) dispatcher.readyAsyncCalls).setExtras(this.mExtras);
            NotificationCompatBuilder$Api24Impl.setRemoteInputHistory((Notification.Builder) dispatcher.readyAsyncCalls, null);
        }
        if (i7 >= 26) {
            NotificationCompatBuilder$Api26Impl.setBadgeIconType((Notification.Builder) dispatcher.readyAsyncCalls, 0);
            NotificationCompatBuilder$Api26Impl.setSettingsText((Notification.Builder) dispatcher.readyAsyncCalls, null);
            NotificationCompatBuilder$Api26Impl.setShortcutId((Notification.Builder) dispatcher.readyAsyncCalls, null);
            NotificationCompatBuilder$Api26Impl.setTimeoutAfter((Notification.Builder) dispatcher.readyAsyncCalls, 0L);
            NotificationCompatBuilder$Api26Impl.setGroupAlertBehavior((Notification.Builder) dispatcher.readyAsyncCalls, 0);
            if (!TextUtils.isEmpty(this.mChannelId)) {
                ((Notification.Builder) dispatcher.readyAsyncCalls).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i7 >= 28) {
            Iterator it4 = arrayList3.iterator();
            if (it4.hasNext()) {
                it4.next().getClass();
                throw new ClassCastException();
            }
        }
        if (i7 >= 29) {
            NotificationCompatBuilder$Api29Impl.setAllowSystemGeneratedContextualActions((Notification.Builder) dispatcher.readyAsyncCalls, this.mAllowSystemGeneratedContextualActions);
            NotificationCompatBuilder$Api29Impl.setBubbleMetadata((Notification.Builder) dispatcher.readyAsyncCalls, null);
        }
        NotificationCompat$Builder notificationCompat$Builder = (NotificationCompat$Builder) dispatcher.runningAsyncCalls;
        NotificationCompat$Style notificationCompat$Style = notificationCompat$Builder.mStyle;
        if (notificationCompat$Style != null) {
            notificationCompat$Style.apply(dispatcher);
        }
        int i8 = Build.VERSION.SDK_INT;
        Notification.Builder builder2 = (Notification.Builder) dispatcher.readyAsyncCalls;
        if (i8 < 26 && i8 < 24) {
            builder2.setExtras((Bundle) dispatcher.runningSyncCalls);
            notificationBuild = builder2.build();
        } else {
            notificationBuild = builder2.build();
        }
        if (notificationCompat$Style != null) {
            notificationCompat$Builder.mStyle.getClass();
        }
        if (notificationCompat$Style != null && (bundle = notificationBuild.extras) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", notificationCompat$Style.getClassName());
        }
        return notificationBuild;
    }
}
