package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import androidx.work.Logger$LogcatLogger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class NetworkNotRoamingController extends ConstraintController {
    public static final String TAG = Logger$LogcatLogger.tagWithPrefix(YcVWhnLsj.CZYzFdJHFsF);

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        return workSpec.constraints.mRequiredNetworkType == 4;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        NetworkState networkState = (NetworkState) obj;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            Logger$LogcatLogger.get().debug(TAG, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !networkState.mIsConnected;
        }
        if (networkState.mIsConnected && networkState.mIsNotRoaming) {
            z = false;
        }
        return z;
    }
}
