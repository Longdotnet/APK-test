package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzch$$ExternalSyntheticApiModelOutline0;

/* JADX INFO: loaded from: classes.dex */
public class zzv extends zzu {
    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        return intent;
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final zzbcj.zzq zzg(Context context, TelephonyManager telephonyManager) {
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        if (zzs.zzB(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return telephonyManager.isDataEnabled() ? zzbcj.zzq.ENUM_TRUE : zzbcj.zzq.ENUM_FALSE;
        }
        return zzbcj.zzq.ENUM_FALSE;
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final void zzh(Context context) {
        zzch$$ExternalSyntheticApiModelOutline0.m74m();
        NotificationChannel notificationChannelM = zzch$$ExternalSyntheticApiModelOutline0.m(((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziS)).intValue());
        notificationChannelM.setShowBadge(false);
        ((NotificationManager) context.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannelM);
    }

    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final boolean zzi(Context context) {
        NotificationChannel notificationChannel = ((NotificationManager) context.getSystemService(NotificationManager.class)).getNotificationChannel("offline_notification_channel");
        return notificationChannel != null && notificationChannel.getImportance() == 0;
    }
}
