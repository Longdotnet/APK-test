package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import androidx.room.RoomOpenHelper;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class MetadataBackendRegistry {
    public final RoomOpenHelper backendFactoryProvider;
    public final HashMap backends;
    public final CreationContextFactory creationContextFactory;

    public MetadataBackendRegistry(Context context, CreationContextFactory creationContextFactory) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(context, 24);
        this.backends = new HashMap();
        this.backendFactoryProvider = roomOpenHelper;
        this.creationContextFactory = creationContextFactory;
    }

    public final synchronized TransportBackend get(String str) {
        if (this.backends.containsKey(str)) {
            return (TransportBackend) this.backends.get(str);
        }
        CctBackendFactory cctBackendFactory = this.backendFactoryProvider.get(str);
        if (cctBackendFactory == null) {
            return null;
        }
        CreationContextFactory creationContextFactory = this.creationContextFactory;
        TransportBackend transportBackendCreate = cctBackendFactory.create(new AutoValue_CreationContext(creationContextFactory.applicationContext, creationContextFactory.wallClock, creationContextFactory.monotonicClock, str));
        this.backends.put(str, transportBackendCreate);
        return transportBackendCreate;
    }
}
