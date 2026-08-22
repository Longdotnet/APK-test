package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes.dex */
public final class InAppPurchaseManager {
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    public static final AtomicBoolean enabled = new AtomicBoolean(false);

    public static final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(InAppPurchaseManager.class)) {
            return;
        }
        try {
            if (enabled.get()) {
                if (INSTANCE.usingBillingLib2Plus()) {
                    FeatureManager featureManager = FeatureManager.INSTANCE;
                    if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                        InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext());
                        return;
                    }
                }
                InAppPurchaseActivityLifecycleTracker.startIapLogging();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(InAppPurchaseManager.class, th);
        }
    }

    public final boolean usingBillingLib2Plus() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)");
            String string = applicationInfo.metaData.getString("com.google.android.play.billingclient.version");
            return string != null && Integer.parseInt((String) StringsKt__StringsKt.split$default(string, new String[]{"."}, 3, 2).get(0)) >= 2;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }
}
