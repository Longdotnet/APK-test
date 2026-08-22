package com.facebook.appevents.codeless;

import android.hardware.SensorManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class CodelessManager {
    public static String deviceSessionID;
    public static volatile boolean isCheckingSession;
    public static SensorManager sensorManager;
    public static ViewIndexer viewIndexer;
    public static final CodelessManager INSTANCE = new CodelessManager();
    public static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();
    public static final AtomicBoolean isCodelessEnabled = new AtomicBoolean(true);
    public static final AtomicBoolean isAppIndexingEnabled = new AtomicBoolean(false);

    public static final String getCurrentDeviceSessionID$facebook_core_release() {
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return null;
        }
        try {
            if (deviceSessionID == null) {
                deviceSessionID = UUID.randomUUID().toString();
            }
            String str = deviceSessionID;
            if (str != null) {
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(CodelessManager.class, th);
            return null;
        }
    }
}
