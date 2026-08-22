package androidx.work.impl.constraints.trackers;

import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryChargingTracker extends BroadcastReceiverConstraintTracker {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("BatteryChrgTracker");

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public final Object getInitialState() {
        Intent intentRegisterReceiver = this.mAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            Logger$LogcatLogger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
        return Boolean.valueOf(intExtra == 2 || intExtra == 5);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.os.action.CHARGING");
        intentFilter.addAction("android.os.action.DISCHARGING");
        return intentFilter;
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public final void onBroadcastReceive(Intent intent) {
        byte b = 0;
        String action = intent.getAction();
        if (action == null) {
        }
        Logger$LogcatLogger.get().debug(TAG, "Received ".concat(action), new Throwable[0]);
        switch (action.hashCode()) {
            case -1886648615:
                if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    b = -1;
                }
                break;
            case -54942926:
                b = !action.equals("android.os.action.DISCHARGING") ? (byte) -1 : (byte) 1;
                break;
            case 948344062:
                b = !action.equals("android.os.action.CHARGING") ? (byte) -1 : (byte) 2;
                break;
            case 1019184907:
                b = !action.equals("android.intent.action.ACTION_POWER_CONNECTED") ? (byte) -1 : (byte) 3;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                setState(Boolean.FALSE);
                break;
            case 1:
                setState(Boolean.FALSE);
                break;
            case 2:
                setState(Boolean.TRUE);
                break;
            case 3:
                setState(Boolean.TRUE);
                break;
        }
    }
}
