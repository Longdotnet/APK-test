package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.io.Closeable;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class DaggerTransportRuntimeComponent implements Closeable {
    public Provider executorProvider;
    public Provider metadataBackendRegistryProvider;
    public Provider sQLiteEventStoreProvider;
    public CreationContextFactory_Factory schemaManagerProvider;
    public InstanceFactory setApplicationContextProvider;
    public Provider transportRuntimeProvider;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((SQLiteEventStore) ((EventStore) this.sQLiteEventStoreProvider.get())).close();
    }
}
