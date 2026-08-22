package androidx.work;

import android.os.Build;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class Constraints {
    public static final Constraints NONE;
    public boolean mRequiresBatteryNotLow;
    public boolean mRequiresCharging;
    public boolean mRequiresDeviceIdle;
    public boolean mRequiresStorageNotLow;
    public int mRequiredNetworkType = 1;
    public long mTriggerContentUpdateDelay = -1;
    public long mTriggerMaxContentDelay = -1;
    public ContentUriTriggers mContentUriTriggers = new ContentUriTriggers();

    static {
        ContentUriTriggers contentUriTriggers = new ContentUriTriggers();
        Constraints constraints = new Constraints();
        constraints.mRequiredNetworkType = 1;
        constraints.mTriggerContentUpdateDelay = -1L;
        constraints.mTriggerMaxContentDelay = -1L;
        constraints.mContentUriTriggers = new ContentUriTriggers();
        constraints.mRequiresCharging = false;
        int i = Build.VERSION.SDK_INT;
        constraints.mRequiresDeviceIdle = false;
        constraints.mRequiredNetworkType = 1;
        constraints.mRequiresBatteryNotLow = false;
        constraints.mRequiresStorageNotLow = false;
        if (i >= 24) {
            constraints.mContentUriTriggers = contentUriTriggers;
            constraints.mTriggerContentUpdateDelay = -1L;
            constraints.mTriggerMaxContentDelay = -1L;
        }
        NONE = constraints;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Constraints.class != obj.getClass()) {
            return false;
        }
        Constraints constraints = (Constraints) obj;
        if (this.mRequiresCharging == constraints.mRequiresCharging && this.mRequiresDeviceIdle == constraints.mRequiresDeviceIdle && this.mRequiresBatteryNotLow == constraints.mRequiresBatteryNotLow && this.mRequiresStorageNotLow == constraints.mRequiresStorageNotLow && this.mTriggerContentUpdateDelay == constraints.mTriggerContentUpdateDelay && this.mTriggerMaxContentDelay == constraints.mTriggerMaxContentDelay && this.mRequiredNetworkType == constraints.mRequiredNetworkType) {
            return this.mContentUriTriggers.equals(constraints.mContentUriTriggers);
        }
        return false;
    }

    public final int hashCode() {
        int iOrdinal = ((((((((Fragment$$ExternalSyntheticOutline0.ordinal(this.mRequiredNetworkType) * 31) + (this.mRequiresCharging ? 1 : 0)) * 31) + (this.mRequiresDeviceIdle ? 1 : 0)) * 31) + (this.mRequiresBatteryNotLow ? 1 : 0)) * 31) + (this.mRequiresStorageNotLow ? 1 : 0)) * 31;
        long j = this.mTriggerContentUpdateDelay;
        int i = (iOrdinal + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.mTriggerMaxContentDelay;
        return this.mContentUriTriggers.mTriggers.hashCode() + ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }
}
