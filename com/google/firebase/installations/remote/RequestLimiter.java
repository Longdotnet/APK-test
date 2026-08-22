package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class RequestLimiter {
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    public int attemptCount;
    public long nextRequestTime;
    public final Utils utils = Utils.getInstance();

    public final synchronized long getBackoffDuration(int i) {
        try {
            if (i == 429 || (i >= 500 && i < 600)) {
                return (long) Math.min(Math.pow(2.0d, this.attemptCount) + this.utils.getRandomDelayForSyncPrevention(), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
            }
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean isRequestAllowed() {
        return this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime;
    }

    public final synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    public final synchronized void setNextRequestTime(int i) {
        try {
            if ((i >= 200 && i < 300) || i == 401 || i == 404) {
                resetBackoffStrategy();
                return;
            }
            this.attemptCount++;
            this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i);
        } catch (Throwable th) {
            throw th;
        }
    }
}
