package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AppEventCollection {
    public HashMap stateMap = new HashMap();

    /* JADX WARN: Code duplicated, block: B:14:0x0024 A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:3:0x0001, B:11:0x001a, B:12:0x001e, B:14:0x0024, B:16:0x0036, B:17:0x0040, B:19:0x0046, B:10:0x0017, B:7:0x0009), top: B:27:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0046 A[Catch: all -> 0x0050, LOOP:1: B:17:0x0040->B:19:0x0046, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:11:0x001a, B:12:0x001e, B:14:0x0024, B:16:0x0036, B:17:0x0040, B:19:0x0046, B:10:0x0017, B:7:0x0009), top: B:27:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x001e A[SYNTHETIC] */
    public synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        SessionEventsState sessionEventsState;
        Iterator it;
        Set<Map.Entry> set = null;
        if (CrashShieldHandler.isObjectCrashing(persistedEvents)) {
            for (Map.Entry entry : set) {
                sessionEventsState = getSessionEventsState((AccessTokenAppIdPair) entry.getKey());
                if (sessionEventsState != null) {
                    it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        sessionEventsState.addEvent((AppEvent) it.next());
                    }
                }
            }
        } else {
            try {
                Set setEntrySet = persistedEvents.events.entrySet();
                Intrinsics.checkNotNullExpressionValue(setEntrySet, "events.entries");
                set = setEntrySet;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(persistedEvents, th);
            }
            while (r4.hasNext()) {
                sessionEventsState = getSessionEventsState((AccessTokenAppIdPair) entry.getKey());
                if (sessionEventsState != null) {
                    it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        sessionEventsState.addEvent((AppEvent) it.next());
                    }
                }
            }
        }
        throw th;
    }

    public synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
        return (SessionEventsState) this.stateMap.get(accessTokenAppIdPair);
    }

    public synchronized int getEventCount() {
        int accumulatedEventCount;
        Iterator it = this.stateMap.values().iterator();
        accumulatedEventCount = 0;
        while (it.hasNext()) {
            accumulatedEventCount += ((SessionEventsState) it.next()).getAccumulatedEventCount();
        }
        return accumulatedEventCount;
    }

    public synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        Context applicationContext;
        AttributionIdentifiers attributionIdentifiers;
        SessionEventsState sessionEventsState = (SessionEventsState) this.stateMap.get(accessTokenAppIdPair);
        if (sessionEventsState == null && (attributionIdentifiers = Validate.getAttributionIdentifiers((applicationContext = FacebookSdk.getApplicationContext()))) != null) {
            sessionEventsState = new SessionEventsState(attributionIdentifiers, CloseableKt.getAnonymousAppDeviceGUID(applicationContext));
        }
        if (sessionEventsState == null) {
            return null;
        }
        this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
        return sessionEventsState;
    }

    public synchronized Set keySet() {
        Set setKeySet;
        setKeySet = this.stateMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "stateMap.keys");
        return setKeySet;
    }
}
