package com.facebook.internal.instrument.crashshield;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class CrashShieldHandler {
    public static final Set crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    public static boolean enabled;

    public static final void handleThrowable(Object o, Throwable th) {
        Intrinsics.checkNotNullParameter(o, "o");
        if (enabled) {
            crashingObjects.add(o);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (UserSettingsManager.getAutoLogAppEventsEnabled()) {
                MapsKt__MapsKt.execute(th);
                GamepadHandler_API19.build(th, InstrumentData.Type.CrashShield).save();
            }
        }
    }

    public static final boolean isObjectCrashing(Object o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return crashingObjects.contains(o);
    }
}
