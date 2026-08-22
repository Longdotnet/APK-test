package com.facebook.appevents.iap;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseActivityLifecycleTracker$initializeIfNotInitialized$1 implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        AtomicBoolean atomicBoolean = InAppPurchaseActivityLifecycleTracker.isTracking;
        InAppPurchaseEventManager inAppPurchaseEventManager = InAppPurchaseEventManager.INSTANCE;
        Context applicationContext = FacebookSdk.getApplicationContext();
        Object objInvokeMethod = null;
        if (!CrashShieldHandler.isObjectCrashing(InAppPurchaseEventManager.class)) {
            try {
                objInvokeMethod = InAppPurchaseEventManager.INSTANCE.invokeMethod(applicationContext, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{service});
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(InAppPurchaseEventManager.class, th);
            }
        }
        InAppPurchaseActivityLifecycleTracker.inAppBillingObj = objInvokeMethod;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
