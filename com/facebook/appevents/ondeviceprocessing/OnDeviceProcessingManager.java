package com.facebook.appevents.ondeviceprocessing;

import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class OnDeviceProcessingManager {
    public static final OnDeviceProcessingManager INSTANCE = new OnDeviceProcessingManager();
    public static final Set ALLOWED_IMPLICIT_EVENTS = GamepadHandler_API19.setOf("fb_mobile_purchase", "StartTrial", "Subscribe");

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Class<com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static final boolean isOnDeviceProcessingEnabled() {
        ?? r0;
        ?? BooleanValue = OnDeviceProcessingManager.class;
        if (CrashShieldHandler.isObjectCrashing(BooleanValue)) {
            return false;
        }
        try {
            if (FacebookSdk.getLimitEventAndDataUsage(FacebookSdk.getApplicationContext()) || Utility.isDataProcessingRestricted()) {
                return false;
            }
            if (CrashShieldHandler.isObjectCrashing(RemoteServiceWrapper.class)) {
                r0 = 0;
            } else {
                try {
                    if (RemoteServiceWrapper.isServiceAvailable == null) {
                        RemoteServiceWrapper.isServiceAvailable = Boolean.valueOf(RemoteServiceWrapper.INSTANCE.getVerifiedServiceIntent(FacebookSdk.getApplicationContext()) != null);
                    }
                    Boolean bool = RemoteServiceWrapper.isServiceAvailable;
                    if (bool == null) {
                        r0 = 0;
                    } else {
                        BooleanValue = bool.booleanValue();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(RemoteServiceWrapper.class, th);
                }
            }
            if (r0 != 0) {
                r0 = BooleanValue;
                return true;
            }
            r0 = BooleanValue;
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(BooleanValue, th2);
            return false;
        }
    }
}
