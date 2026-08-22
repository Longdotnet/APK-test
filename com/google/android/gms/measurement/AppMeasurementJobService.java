package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.work.impl.WorkerWrapper;
import com.facebook.ProfileCache;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzjs;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.android.gms.tasks.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zzjs {
    public ProfileCache zza;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzeh zzehVar = zzfr.zzp((Service) zzd().sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzeh zzehVar = zzfr.zzp((Service) zzd().sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zza("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        ProfileCache profileCacheZzd = zzd();
        if (intent == null) {
            profileCacheZzd.zzk().zzd.zza("onRebind called with null intent");
            return;
        }
        profileCacheZzd.getClass();
        profileCacheZzd.zzk().zzl.zzb(intent.getAction(), "onRebind called. action");
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        ProfileCache profileCacheZzd = zzd();
        zzeh zzehVar = zzfr.zzp((Service) profileCacheZzd.sharedPreferences, null, null).zzm;
        zzfr.zzR(zzehVar);
        String string = jobParameters.getExtras().getString("action");
        zzehVar.zzl.zzb(string, "Local AppMeasurementJobService called. action");
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        WorkerWrapper.AnonymousClass1 anonymousClass1 = new WorkerWrapper.AnonymousClass1(profileCacheZzd, zzehVar, jobParameters, 25, false);
        zzkt zzktVarZzt = zzkt.zzt((Service) profileCacheZzd.sharedPreferences);
        zzktVarZzt.zzaz().zzp(new zzc(zzktVarZzt, anonymousClass1, 7, false));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        ProfileCache profileCacheZzd = zzd();
        if (intent == null) {
            profileCacheZzd.zzk().zzd.zza("onUnbind called with null intent");
            return true;
        }
        profileCacheZzd.getClass();
        profileCacheZzd.zzk().zzl.zzb(intent.getAction(), "onUnbind called for intent. action");
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zza(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final void zzb(JobParameters jobParameters) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzjs
    public final boolean zzc(int i) {
        throw new UnsupportedOperationException();
    }

    public final ProfileCache zzd() {
        if (this.zza == null) {
            this.zza = new ProfileCache(this, 27);
        }
        return this.zza;
    }
}
