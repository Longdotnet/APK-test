package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.ads.zzbcj;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaa {
    public boolean zzd(Activity activity, Configuration configuration) {
        return false;
    }

    public Intent zzf(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.putExtra("app_package", activity.getPackageName());
        intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        return intent;
    }

    public zzbcj.zzq zzg(Context context, TelephonyManager telephonyManager) {
        return zzbcj.zzq.ENUM_UNKNOWN;
    }

    public boolean zzi(Context context) {
        return false;
    }

    public int zzj(AudioManager audioManager) {
        return 0;
    }

    public void zzl(Activity activity) {
    }

    public int zzm(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
    }

    public void zzh(Context context) {
    }
}
