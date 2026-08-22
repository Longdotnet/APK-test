package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdc;
import com.google.android.gms.internal.ads.zzbde;

/* JADX INFO: loaded from: classes.dex */
public class zzu extends zzt {
    @Override // com.google.android.gms.ads.internal.util.zzaa
    public final boolean zzd(Activity activity, Configuration configuration) {
        zzbcv zzbcvVar = zzbde.zzfo;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (!((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            return false;
        }
        zzbcv zzbcvVar2 = zzbde.zzfq;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        int iZzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, configuration.screenHeightDp);
        int iZzu = com.google.android.gms.ads.internal.util.client.zzf.zzu(activity.getResources().getDisplayMetrics(), configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int iIntValue = ((Integer) zzbdcVar.zzb(zzbde.zzfm)).intValue() * ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d));
        return !(Math.abs(i - (iZzC + dimensionPixelSize)) <= iIntValue) || Math.abs(i2 - iZzu) > iIntValue;
    }
}
