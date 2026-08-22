package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import com.google.firebase.auth.zzaa;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SystemJobService extends JobService implements ExecutionListener {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("SystemJobService");
    public final HashMap mJobParameters = new HashMap();
    public WorkManagerImpl mWorkManagerImpl;

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(getApplicationContext());
            this.mWorkManagerImpl = workManagerImpl;
            workManagerImpl.mProcessor.addExecutionListener(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            Logger$LogcatLogger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (workManagerImpl != null) {
            workManagerImpl.mProcessor.removeExecutionListener(this);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String str, boolean z) {
        JobParameters jobParameters;
        Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m(str, " executed on JobScheduler"), new Throwable[0]);
        synchronized (this.mJobParameters) {
            jobParameters = (JobParameters) this.mJobParameters.remove(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string;
        if (this.mWorkManagerImpl == null) {
            Logger$LogcatLogger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(jobParameters, true);
            return false;
        }
        zzaa zzaaVar = null;
        try {
            PersistableBundle extras = jobParameters.getExtras();
            string = (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) ? null : extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
        }
        if (TextUtils.isEmpty(string)) {
            Logger$LogcatLogger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.mJobParameters) {
            try {
                if (this.mJobParameters.containsKey(string)) {
                    Logger$LogcatLogger.get().debug(TAG, "Job is already being executed by SystemJobService: " + string, new Throwable[0]);
                    return false;
                }
                Logger$LogcatLogger.get().debug(TAG, "onStartJob for " + string, new Throwable[0]);
                this.mJobParameters.put(string, jobParameters);
                int i = Build.VERSION.SDK_INT;
                if (i >= 24) {
                    zzaaVar = new zzaa();
                    if (jobParameters.getTriggeredContentUris() != null) {
                        zzaaVar.zzb = Arrays.asList(jobParameters.getTriggeredContentUris());
                    }
                    if (jobParameters.getTriggeredContentAuthorities() != null) {
                        zzaaVar.zza = Arrays.asList(jobParameters.getTriggeredContentAuthorities());
                    }
                    if (i >= 28) {
                        zzaaVar.zzc = jobParameters.getNetwork();
                    }
                }
                this.mWorkManagerImpl.startWork(string, zzaaVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        String string;
        if (this.mWorkManagerImpl == null) {
            Logger$LogcatLogger.get().debug(TAG, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        try {
            PersistableBundle extras = jobParameters.getExtras();
            string = (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) ? null : extras.getString("EXTRA_WORK_SPEC_ID");
        } catch (NullPointerException unused) {
        }
        if (TextUtils.isEmpty(string)) {
            Logger$LogcatLogger.get().error(TAG, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("onStopJob for ", string), new Throwable[0]);
        synchronized (this.mJobParameters) {
            this.mJobParameters.remove(string);
        }
        this.mWorkManagerImpl.stopWork(string);
        return !this.mWorkManagerImpl.mProcessor.isCancelled(string);
    }
}
