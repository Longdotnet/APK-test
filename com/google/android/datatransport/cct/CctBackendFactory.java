package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.backends.AutoValue_CreationContext;
import com.google.android.datatransport.runtime.backends.CreationContext;
import com.google.android.datatransport.runtime.backends.TransportBackend;

/* JADX INFO: loaded from: classes.dex */
public class CctBackendFactory {
    public TransportBackend create(CreationContext creationContext) {
        AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) creationContext;
        return new CctTransportBackend(autoValue_CreationContext.applicationContext, autoValue_CreationContext.wallClock, autoValue_CreationContext.monotonicClock);
    }
}
