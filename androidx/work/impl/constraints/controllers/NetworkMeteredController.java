package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkMeteredController extends ConstraintController {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix("NetworkMeteredCtrlr");

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.mRequiredNetworkType == 5;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        NetworkState networkState = (NetworkState) obj;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            Logger$LogcatLogger.get().debug(TAG, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !networkState.mIsConnected;
        }
        if (networkState.mIsConnected && networkState.mIsMetered) {
            z = false;
        }
        return z;
    }
}
