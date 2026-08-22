package androidx.work.impl.model;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger$LogcatLogger;

/* JADX INFO: loaded from: classes.dex */
public final class WorkSpec {
    public long backoffDelayDuration;
    public int backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    public String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long minimumRetentionDuration;
    public int outOfQuotaPolicy;
    public Data output;
    public long periodStartTime;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public int state = 1;
    public String workerClassName;

    public final class IdAndState {
        public String id;
        public int state;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.state != idAndState.state) {
                return false;
            }
            return this.id.equals(idAndState.id);
        }

        public final int hashCode() {
            return Fragment$$ExternalSyntheticOutline0.ordinal(this.state) + (this.id.hashCode() * 31);
        }
    }

    static {
        Logger$LogcatLogger.tagWithPrefix("WorkSpec");
    }

    public WorkSpec(String str, String str2) {
        Data data = Data.EMPTY;
        this.input = data;
        this.output = data;
        this.constraints = Constraints.NONE;
        this.backoffPolicy = 1;
        this.backoffDelayDuration = 30000L;
        this.scheduleRequestedAt = -1L;
        this.outOfQuotaPolicy = 1;
        this.id = str;
        this.workerClassName = str2;
    }

    public final long calculateNextRunTime() {
        int i;
        if (this.state == 1 && (i = this.runAttemptCount) > 0) {
            return Math.min(18000000L, this.backoffPolicy == 2 ? this.backoffDelayDuration * ((long) i) : (long) Math.scalb(this.backoffDelayDuration, i - 1)) + this.periodStartTime;
        }
        if (!isPeriodic()) {
            long jCurrentTimeMillis = this.periodStartTime;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.initialDelay;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j = this.periodStartTime;
        if (j == 0) {
            j = this.initialDelay + jCurrentTimeMillis2;
        }
        long j2 = this.flexDuration;
        long j3 = this.intervalDuration;
        if (j2 != j3) {
            return j + j3 + (j == 0 ? j2 * (-1) : 0L);
        }
        return j + (j != 0 ? j3 : 0L);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkSpec.class != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.initialDelay != workSpec.initialDelay || this.intervalDuration != workSpec.intervalDuration || this.flexDuration != workSpec.flexDuration || this.runAttemptCount != workSpec.runAttemptCount || this.backoffDelayDuration != workSpec.backoffDelayDuration || this.periodStartTime != workSpec.periodStartTime || this.minimumRetentionDuration != workSpec.minimumRetentionDuration || this.scheduleRequestedAt != workSpec.scheduleRequestedAt || this.expedited != workSpec.expedited || !this.id.equals(workSpec.id) || this.state != workSpec.state || !this.workerClassName.equals(workSpec.workerClassName)) {
            return false;
        }
        String str = this.inputMergerClassName;
        if (str == null ? workSpec.inputMergerClassName == null : str.equals(workSpec.inputMergerClassName)) {
            return this.input.equals(workSpec.input) && this.output.equals(workSpec.output) && this.constraints.equals(workSpec.constraints) && this.backoffPolicy == workSpec.backoffPolicy && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy;
        }
        return false;
    }

    public final boolean hasConstraints() {
        return !Constraints.NONE.equals(this.constraints);
    }

    public final int hashCode() {
        int iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m((Fragment$$ExternalSyntheticOutline0.ordinal(this.state) + (this.id.hashCode() * 31)) * 31, 31, this.workerClassName);
        String str = this.inputMergerClassName;
        int iHashCode = (this.output.hashCode() + ((this.input.hashCode() + ((iM + (str != null ? str.hashCode() : 0)) * 31)) * 31)) * 31;
        long j = this.initialDelay;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.intervalDuration;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.flexDuration;
        int iOrdinal = (Fragment$$ExternalSyntheticOutline0.ordinal(this.backoffPolicy) + ((((this.constraints.hashCode() + ((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31)) * 31) + this.runAttemptCount) * 31)) * 31;
        long j4 = this.backoffDelayDuration;
        int i3 = (iOrdinal + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j5 = this.periodStartTime;
        int i4 = (i3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.minimumRetentionDuration;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.scheduleRequestedAt;
        return Fragment$$ExternalSyntheticOutline0.ordinal(this.outOfQuotaPolicy) + ((((i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.expedited ? 1 : 0)) * 31);
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(new StringBuilder("{WorkSpec: "), this.id, "}");
    }
}
