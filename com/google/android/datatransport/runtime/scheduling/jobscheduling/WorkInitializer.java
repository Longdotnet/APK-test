package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class WorkInitializer {
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final JobInfoScheduler scheduler;
    public final EventStore store;

    public WorkInitializer(Executor executor, EventStore eventStore, JobInfoScheduler jobInfoScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.store = eventStore;
        this.scheduler = jobInfoScheduler;
        this.guard = synchronizationGuard;
    }
}
