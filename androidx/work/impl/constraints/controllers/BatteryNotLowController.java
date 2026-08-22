package androidx.work.impl.constraints.controllers;

import android.os.Build;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;

/* JADX INFO: loaded from: classes.dex */
public final class BatteryNotLowController extends ConstraintController {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BatteryNotLowController(ConstraintTracker constraintTracker, int i) {
        super(constraintTracker);
        this.$r8$classId = i;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean hasConstraint(WorkSpec workSpec) {
        switch (this.$r8$classId) {
            case 0:
                return workSpec.constraints.mRequiresBatteryNotLow;
            case 1:
                return workSpec.constraints.mRequiresCharging;
            case 2:
                return workSpec.constraints.mRequiredNetworkType == 2;
            case 3:
                int i = workSpec.constraints.mRequiredNetworkType;
                return i == 3 || (Build.VERSION.SDK_INT >= 30 && i == 6);
            default:
                return workSpec.constraints.mRequiresStorageNotLow;
        }
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public final boolean isConstrained(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return !((Boolean) obj).booleanValue();
            case 1:
                return !((Boolean) obj).booleanValue();
            case 2:
                NetworkState networkState = (NetworkState) obj;
                if (Build.VERSION.SDK_INT >= 26) {
                    return (networkState.mIsConnected && networkState.mIsValidated) ? false : true;
                }
                return true ^ networkState.mIsConnected;
            case 3:
                NetworkState networkState2 = (NetworkState) obj;
                return !networkState2.mIsConnected || networkState2.mIsMetered;
            default:
                return !((Boolean) obj).booleanValue();
        }
    }
}
