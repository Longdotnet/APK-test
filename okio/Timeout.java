package okio;

import com.google.zxing.BarcodeFormat$EnumUnboxingLocalUtility;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class Timeout {
    public static final Timeout$Companion$NONE$1 NONE = new Timeout$Companion$NONE$1();
    public long deadlineNanoTime;
    public boolean hasDeadline;
    public long timeoutNanos;

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(BarcodeFormat$EnumUnboxingLocalUtility.m(j, "timeout < 0: ").toString());
        }
        this.timeoutNanos = unit.toNanos(j);
        return this;
    }

    public Timeout deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
