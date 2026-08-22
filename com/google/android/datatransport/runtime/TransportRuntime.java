package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.AccessTokenCache;
import com.facebook.AccessTokenManager$$ExternalSyntheticLambda0;
import com.facebook.GraphRequest;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.firebase.auth.zzaa;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class TransportRuntime {
    public static volatile DaggerTransportRuntimeComponent instance;
    public final GraphRequest.Companion eventClock;
    public final Scheduler scheduler;
    public final Uploader uploader;
    public final GraphRequest.Companion uptimeClock;

    public TransportRuntime(GraphRequest.Companion companion, GraphRequest.Companion companion2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.eventClock = companion;
        this.uptimeClock = companion2;
        this.scheduler = scheduler;
        this.uploader = uploader;
        workInitializer.getClass();
        workInitializer.executor.execute(new AccessTokenManager$$ExternalSyntheticLambda0(workInitializer, 14));
    }

    public static TransportRuntime getInstance() {
        DaggerTransportRuntimeComponent daggerTransportRuntimeComponent = instance;
        if (daggerTransportRuntimeComponent != null) {
            return (TransportRuntime) daggerTransportRuntimeComponent.transportRuntimeProvider.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void initialize(Context context) {
        if (instance == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (instance == null) {
                        AccessTokenCache accessTokenCache = new AccessTokenCache(16, false);
                        context.getClass();
                        accessTokenCache.sharedPreferences = context;
                        instance = accessTokenCache.m62build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final zzaa newFactory(CCTDestination cCTDestination) {
        Set setSingleton;
        byte[] bytes;
        if (cCTDestination instanceof EncodedDestination) {
            cCTDestination.getClass();
            setSingleton = Collections.unmodifiableSet(CCTDestination.SUPPORTED_ENCODINGS);
        } else {
            setSingleton = Collections.singleton(new Encoding("proto"));
        }
        zzaa zzaaVarBuilder = AutoValue_TransportContext.builder();
        cCTDestination.getClass();
        zzaaVarBuilder.zza = "cct";
        String str = cCTDestination.endPoint;
        String str2 = cCTDestination.apiKey;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
        }
        zzaaVarBuilder.zzb = bytes;
        return new zzaa(setSingleton, zzaaVarBuilder.m98build(), this, 14);
    }
}
