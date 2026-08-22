package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.facebook.GraphRequest;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;

/* JADX INFO: loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory {
    public final /* synthetic */ int $r8$classId;
    public final InstanceFactory applicationContextProvider;

    public /* synthetic */ CreationContextFactory_Factory(InstanceFactory instanceFactory, int i) {
        this.$r8$classId = i;
        this.applicationContextProvider = instanceFactory;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return new CreationContextFactory((Context) this.applicationContextProvider.instance, new GraphRequest.Companion(18), new GraphRequest.Companion(17));
            default:
                return new SchemaManager((Context) this.applicationContextProvider.instance, "com.google.android.datatransport.events", Integer.valueOf(SchemaManager.SCHEMA_VERSION).intValue());
        }
    }
}
