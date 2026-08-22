package com.google.android.gms.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.facebook.AccessTokenCache;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver {
    public AccessTokenCache zza;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new AccessTokenCache(this, 23);
        }
        AccessTokenCache accessTokenCache = this.zza;
        accessTokenCache.getClass();
        zzeh zzehVar = zzfr.zzp(context, null, null).zzm;
        zzfr.zzR(zzehVar);
        if (intent == null) {
            zzehVar.zzg.zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzehVar.zzl.zzb(action, "Local receiver got");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzehVar.zzg.zza("Install Referrer Broadcasts are deprecated");
                return;
            }
            return;
        }
        Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        zzehVar.zzl.zza("Starting wakeful intent.");
        ((AppMeasurementReceiver) accessTokenCache.sharedPreferences).getClass();
        SparseArray sparseArray = WakefulBroadcastReceiver.sActiveWakeLocks;
        synchronized (sparseArray) {
            try {
                int i = WakefulBroadcastReceiver.mNextId;
                int i2 = i + 1;
                WakefulBroadcastReceiver.mNextId = i2;
                if (i2 <= 0) {
                    WakefulBroadcastReceiver.mNextId = 1;
                }
                className.putExtra("androidx.contentpager.content.wakelockid", i);
                ComponentName componentNameStartService = context.startService(className);
                if (componentNameStartService == null) {
                    return;
                }
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
                wakeLockNewWakeLock.setReferenceCounted(false);
                wakeLockNewWakeLock.acquire(60000L);
                sparseArray.put(i, wakeLockNewWakeLock);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
