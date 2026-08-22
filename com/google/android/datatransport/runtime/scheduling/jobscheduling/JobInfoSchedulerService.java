package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda1;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.firebase.auth.zzaa;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt("priority");
        final int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.initialize(getApplicationContext());
        zzaa zzaaVarBuilder = AutoValue_TransportContext.builder();
        zzaaVarBuilder.setBackendName(string);
        zzaaVarBuilder.zzc = PriorityMapping.valueOf(i);
        if (string2 != null) {
            zzaaVarBuilder.zzb = Base64.decode(string2, 0);
        }
        final Uploader uploader = TransportRuntime.getInstance().uploader;
        final AutoValue_TransportContext autoValue_TransportContextM98build = zzaaVarBuilder.m98build();
        final GraphRequest$Companion$$ExternalSyntheticLambda1 graphRequest$Companion$$ExternalSyntheticLambda1 = new GraphRequest$Companion$$ExternalSyntheticLambda1(this, jobParameters, 20);
        uploader.getClass();
        uploader.executor.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                final AutoValue_TransportContext autoValue_TransportContext = autoValue_TransportContextM98build;
                final int i3 = i2;
                Runnable runnable = graphRequest$Companion$$ExternalSyntheticLambda1;
                final Uploader uploader2 = uploader;
                SynchronizationGuard synchronizationGuard = uploader2.guard;
                try {
                    try {
                        EventStore eventStore = uploader2.eventStore;
                        Objects.requireNonNull(eventStore);
                        ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(eventStore, 9));
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) uploader2.context.getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            ((SQLiteEventStore) synchronizationGuard).runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda2
                                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                                public final Object execute() {
                                    uploader2.workScheduler.schedule(autoValue_TransportContext, i3 + 1, false);
                                    return null;
                                }
                            });
                        } else {
                            uploader2.logAndUpdateState(autoValue_TransportContext, i3);
                        }
                    } catch (SynchronizationException unused) {
                        uploader2.workScheduler.schedule(autoValue_TransportContext, i3 + 1, false);
                    }
                } finally {
                    runnable.run();
                }
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
