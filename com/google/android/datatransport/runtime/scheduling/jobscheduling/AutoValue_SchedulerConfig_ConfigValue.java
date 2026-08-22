package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoValue_SchedulerConfig_ConfigValue {
    public final long delta;
    public final Set flags;
    public final long maxAllowedDelay;

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_SchedulerConfig_ConfigValue)) {
            return false;
        }
        AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) obj;
        return this.delta == autoValue_SchedulerConfig_ConfigValue.delta && this.maxAllowedDelay == autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay && this.flags.equals(autoValue_SchedulerConfig_ConfigValue.flags);
    }

    public final int hashCode() {
        long j = this.delta;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.maxAllowedDelay;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.flags.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.delta + ", maxAllowedDelay=" + this.maxAllowedDelay + ", flags=" + this.flags + xPQrbOSWiEdU.WrDxLFTcJNxoEg;
    }
}
