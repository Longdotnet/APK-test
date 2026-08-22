package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class DefaultScheduler implements Scheduler {
    public static final Logger LOGGER = Logger.getLogger(TransportRuntime.class.getName());
    public final MetadataBackendRegistry backendRegistry;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final JobInfoScheduler workScheduler;

    public DefaultScheduler(Executor executor, MetadataBackendRegistry metadataBackendRegistry, JobInfoScheduler jobInfoScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.executor = executor;
        this.backendRegistry = metadataBackendRegistry;
        this.workScheduler = jobInfoScheduler;
        this.eventStore = eventStore;
        this.guard = synchronizationGuard;
    }
}
