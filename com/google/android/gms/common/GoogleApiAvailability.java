package com.google.android.gms.common;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BigTextStyle;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabw;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.ads.zzch$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.internal.base.zao;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new GoogleApiAvailability();

    public static AlertDialog zaa(Activity activity, int i, com.google.android.gms.common.internal.zad zadVar, DialogInterface.OnCancelListener onCancelListener) {
        String string;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(activity, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zac.zac(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i == 1) {
            string = resources.getString(com.daerisoft.thespikerm.R.string.common_google_play_services_install_button);
        } else if (i != 2) {
            string = i != 3 ? resources.getString(R.string.ok) : resources.getString(com.daerisoft.thespikerm.R.string.common_google_play_services_enable_button);
        } else {
            string = resources.getString(com.daerisoft.thespikerm.R.string.common_google_play_services_update_button);
        }
        if (string != null) {
            builder.setPositiveButton(string, zadVar);
        }
        String strZaf = zac.zaf(activity, i);
        if (strZaf != null) {
            builder.setTitle(strZaf);
        }
        Log.w("GoogleApiAvailability", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    public static zabx zac(Context context, zabw zabwVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabxVar = new zabx(zabwVar);
        zao.zaa(context, zabxVar, intentFilter);
        zabxVar.zaa(context);
        if (GooglePlayServicesUtil.zza(context)) {
            return zabxVar;
        }
        zabwVar.zaa();
        zabxVar.zab();
        return null;
    }

    public static void zad(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                zzah.checkNotNull(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                supportErrorDialogFragment.zaa = alertDialog;
                if (onCancelListener != null) {
                    supportErrorDialogFragment.zab = onCancelListener;
                }
                supportErrorDialogFragment.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        zzah.checkNotNull(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        errorDialogFragment.zaa = alertDialog;
        if (onCancelListener != null) {
            errorDialogFragment.zab = onCancelListener;
        }
        errorDialogFragment.show(fragmentManager, str);
    }

    public final void showErrorDialogFragment(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog alertDialogZaa = zaa(googleApiActivity, i, new com.google.android.gms.common.internal.zad(super.getErrorResolutionIntent(googleApiActivity, "d", i), googleApiActivity, 0), googleApiActivity2);
        if (alertDialogZaa == null) {
            return;
        }
        zad(googleApiActivity, alertDialogZaa, "GooglePlayServicesErrorDialog", googleApiActivity2);
    }

    public final void zae(Context context, int i, PendingIntent pendingIntent) {
        int i2;
        Log.w("GoogleApiAvailability", CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "GMS core API Availability. ConnectionResult=", ", tag=null"), new IllegalArgumentException());
        if (i == 18) {
            new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
            return;
        }
        if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
                return;
            }
            return;
        }
        String strZah = i == 6 ? zac.zah(context, "common_google_play_services_resolution_required_title") : zac.zaf(context, i);
        if (strZah == null) {
            strZah = context.getResources().getString(com.daerisoft.thespikerm.R.string.common_google_play_services_notification_ticker);
        }
        String strZag = (i == 6 || i == 19) ? zac.zag(context, "common_google_play_services_resolution_required_text", zac.zaa(context)) : zac.zac(context, i);
        Resources resources = context.getResources();
        Object systemService = context.getSystemService("notification");
        zzah.checkNotNull(systemService);
        NotificationManager notificationManager = (NotificationManager) systemService;
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
        notificationCompat$Builder.mLocalOnly = true;
        notificationCompat$Builder.mNotification.flags |= 16;
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(strZah);
        NotificationCompat$BigTextStyle notificationCompat$BigTextStyle = new NotificationCompat$BigTextStyle();
        notificationCompat$BigTextStyle.mBigText = NotificationCompat$Builder.limitCharSequenceLength(strZag);
        notificationCompat$Builder.setStyle(notificationCompat$BigTextStyle);
        PackageManager packageManager = context.getPackageManager();
        if (Hex.zze == null) {
            Hex.zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (Hex.zze.booleanValue()) {
            notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
            notificationCompat$Builder.mPriority = 2;
            if (Hex.isWearableWithoutPlayStore(context)) {
                notificationCompat$Builder.mActions.add(new NotificationCompat$Action(resources.getString(com.daerisoft.thespikerm.R.string.common_open_on_phone), pendingIntent));
            } else {
                notificationCompat$Builder.mContentIntent = pendingIntent;
            }
        } else {
            notificationCompat$Builder.mNotification.icon = R.drawable.stat_sys_warning;
            notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(resources.getString(com.daerisoft.thespikerm.R.string.common_google_play_services_notification_ticker));
            notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
            notificationCompat$Builder.mContentIntent = pendingIntent;
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(strZag);
        }
        if (Hex.isAtLeastO()) {
            zzah.checkState$1(Hex.isAtLeastO());
            synchronized (zaa) {
            }
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
            String string = context.getResources().getString(com.daerisoft.thespikerm.R.string.common_google_play_services_notification_channel_name);
            if (notificationChannel == null) {
                notificationManager.createNotificationChannel(zzch$$ExternalSyntheticApiModelOutline0.m(string));
            } else if (!string.contentEquals(notificationChannel.getName())) {
                notificationChannel.setName(string);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationCompat$Builder.mChannelId = "com.google.android.gms.availability";
        }
        Notification notificationBuild = notificationCompat$Builder.build();
        if (i == 1 || i == 2 || i == 3) {
            GooglePlayServicesUtil.sCanceledAvailabilityNotification.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        notificationManager.notify(i2, notificationBuild);
    }

    public final void zag(Activity activity, LifecycleFragment lifecycleFragment, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog alertDialogZaa = zaa(activity, i, new com.google.android.gms.common.internal.zad(super.getErrorResolutionIntent(activity, "d", i), lifecycleFragment, 1), onCancelListener);
        if (alertDialogZaa == null) {
            return;
        }
        zad(activity, alertDialogZaa, "GooglePlayServicesErrorDialog", onCancelListener);
    }
}
