package androidx.work.impl.constraints.trackers;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("BatteryNotLowTracker");

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object getInitialState() {
        Intent intentRegisterReceiver = this.mAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(intentRegisterReceiver.getIntExtra("status", -1) == 1 || ((float) intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) intentRegisterReceiver.getIntExtra("scale", -1)) > 0.15f);
        }
        Logger$LogcatLogger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void onBroadcastReceive(Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        Logger$LogcatLogger.get().debug(TAG, CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Received ", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        action.getClass();
        if (action.equals("android.intent.action.BATTERY_OKAY")) {
            setState(Boolean.TRUE);
        } else if (action.equals("android.intent.action.BATTERY_LOW")) {
            setState(Boolean.FALSE);
        }
    }
}
