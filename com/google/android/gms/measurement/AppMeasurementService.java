package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.facebook.ProfileCache;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzhz;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.tasks.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzjs {
    public ProfileCache zza;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        ProfileCache profileCacheZzd$1 = zzd$1();
        if (intent == null) {
            profileCacheZzd$1.zzk().zzd.zza("onBind called with null intent");
            return null;
        }
        profileCacheZzd$1.getClass();
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgj(zzkt.zzt((Service) profileCacheZzd$1.sharedPreferences));
        }
        profileCacheZzd$1.zzk().zzg.zzb(action, "onBind received unknown action");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzeh zzehVar = zzfr.zzp((Service) zzd$1().sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzeh zzehVar = zzfr.zzp((Service) zzd$1().sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        ProfileCache profileCacheZzd$1 = zzd$1();
        if (intent == null) {
            profileCacheZzd$1.zzk().zzd.zza("onRebind called with null intent");
            return;
        }
        profileCacheZzd$1.getClass();
        profileCacheZzd$1.zzk().zzl.zzb(intent.getAction(), "onRebind called. action");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        ProfileCache profileCacheZzd$1 = zzd$1();
        zzeh zzehVar = zzfr.zzp((Service) profileCacheZzd$1.sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        if (intent == null) {
            zzehVar.zzg.zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzehVar.zzl.zzc(Integer.valueOf(i2), "Local AppMeasurementService called. startId, action", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        zzhz zzhzVar = new zzhz(profileCacheZzd$1, i2, zzehVar, intent);
        zzkt zzktVarZzt = zzkt.zzt((Service) profileCacheZzd$1.sharedPreferences);
        zzktVarZzt.zzaz().zzp(new zzc(zzktVarZzt, zzhzVar, 7, false));
        return 2;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        ProfileCache profileCacheZzd$1 = zzd$1();
        if (intent == null) {
            profileCacheZzd$1.zzk().zzd.zza("onUnbind called with null intent");
            return true;
        }
        profileCacheZzd$1.getClass();
        profileCacheZzd$1.zzk().zzl.zzb(intent.getAction(), "onUnbind called for intent. action");
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zza(Intent intent) {
        SparseArray sparseArray = WakefulBroadcastReceiver.sActiveWakeLocks;
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return;
        }
        SparseArray sparseArray2 = WakefulBroadcastReceiver.sActiveWakeLocks;
        synchronized (sparseArray2) {
            try {
                PowerManager.WakeLock wakeLock = (PowerManager.WakeLock) sparseArray2.get(intExtra);
                if (wakeLock != null) {
                    wakeLock.release();
                    sparseArray2.remove(intExtra);
                } else {
                    Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zzb(JobParameters jobParameters) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final boolean zzc(int i) {
        return stopSelfResult(i);
    }

    public final ProfileCache zzd$1() {
        if (this.zza == null) {
            this.zza = new ProfileCache(this, 27);
        }
        return this.zza;
    }
}
