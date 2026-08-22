package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.facebook.GraphRequest;

/* JADX INFO: loaded from: classes.dex */
public final class CreationContextFactory {
    public final Context applicationContext;
    public final GraphRequest.Companion monotonicClock;
    public final GraphRequest.Companion wallClock;

    public CreationContextFactory(Context context, GraphRequest.Companion companion, GraphRequest.Companion companion2) {
        this.applicationContext = context;
        this.wallClock = companion;
        this.monotonicClock = companion2;
    }
}
