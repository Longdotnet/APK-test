package androidx.work.impl.constraints.trackers;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes.dex */
public final class StorageNotLowTracker extends BroadcastReceiverConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("StorageNotLowTracker");

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object getInitialState() {
        Intent intentRegisterReceiver = this.mAppContext.registerReceiver(null, getIntentFilter());
        if (intentRegisterReceiver == null || intentRegisterReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = intentRegisterReceiver.getAction();
        action.getClass();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
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
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            setState(Boolean.FALSE);
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            setState(Boolean.TRUE);
        }
    }
}
