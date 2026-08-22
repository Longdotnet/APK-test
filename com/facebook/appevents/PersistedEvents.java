package com.facebook.appevents;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.vu.dLDI;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class PersistedEvents implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    public final HashMap events;

    /* JADX INFO: loaded from: classes.dex */
    public final class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        public final HashMap proxyEvents;

        public SerializationProxyV1(HashMap proxyEvents) {
            Intrinsics.checkNotNullParameter(proxyEvents, "proxyEvents");
            this.proxyEvents = proxyEvents;
        }

        private final Object readResolve() {
            return new PersistedEvents(this.proxyEvents);
        }
    }

    public PersistedEvents() {
        this.events = new HashMap();
    }

    private final Object writeReplace() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return new SerializationProxyV1(this.events);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final void addEvents(AccessTokenAppIdPair accessTokenAppIdPair, List appEvents) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(appEvents, "appEvents");
            HashMap map = this.events;
            if (!map.containsKey(accessTokenAppIdPair)) {
                map.put(accessTokenAppIdPair, CollectionsKt.toMutableList(appEvents));
                return;
            }
            List list = (List) map.get(accessTokenAppIdPair);
            if (list == null) {
                return;
            }
            list.addAll(appEvents);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public PersistedEvents(HashMap map) {
        Intrinsics.checkNotNullParameter(map, dLDI.FZEa);
        HashMap map2 = new HashMap();
        this.events = map2;
        map2.putAll(map);
    }
}
