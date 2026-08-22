package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class LockFreeTaskQueueCore {
    private volatile Object _next;
    private volatile long _state;
    public final AtomicReferenceArray array;
    public final int capacity;
    public final int mask;
    public final boolean singleConsumer;
    public static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    public static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN", 0);

    public final class Placeholder {
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.capacity = i;
        this.singleConsumer = z;
        int i2 = i - 1;
        this.mask = i2;
        this.array = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int addLast(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (j & 2305843009213693952L) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.mask;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.array;
            if (!this.singleConsumer && atomicReferenceArray.get(i2 & i3) != null) {
                int i4 = this.capacity;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i2 & i3, runnable);
                LockFreeTaskQueueCore next = this;
                while ((atomicLongFieldUpdater.get(next) & 1152921504606846976L) != 0) {
                    next = next.next();
                    AtomicReferenceArray atomicReferenceArray2 = next.array;
                    int i5 = next.mask & i2;
                    Object obj = atomicReferenceArray2.get(i5);
                    if ((obj instanceof Placeholder) && ((Placeholder) obj).index == i2) {
                        atomicReferenceArray2.set(i5, runnable);
                    } else {
                        next = null;
                    }
                    if (next == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    public final LockFreeTaskQueueCore next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        while (true) {
            atomicLongFieldUpdater = _state$FU;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.mask;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object placeholder = this.array.get(i4);
                if (placeholder == null) {
                    placeholder = new Placeholder(i);
                }
                lockFreeTaskQueueCore2.array.set(lockFreeTaskQueueCore2.mask & i, placeholder);
                i++;
            }
            atomicLongFieldUpdater.set(lockFreeTaskQueueCore2, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object removeFirstOrNull() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return REMOVE_FROZEN;
            }
            int i = (int) (j & 1073741823);
            int i2 = this.mask;
            int i3 = i & i2;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == i3) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.array;
            Object obj = atomicReferenceArray.get(i3);
            boolean z = this.singleConsumer;
            if (obj == null) {
                if (z) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                long j2 = (i + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    atomicReferenceArray.set(i3, null);
                    return obj;
                }
                if (z) {
                    LockFreeTaskQueueCore next = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = _state$FU;
                        long j3 = atomicLongFieldUpdater2.get(next);
                        int i4 = (int) (j3 & 1073741823);
                        if ((j3 & 1152921504606846976L) != 0) {
                            next = next.next();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(next, j3, (j3 & (-1073741824)) | j2)) {
                                next.array.set(next.mask & i4, null);
                                next = null;
                            } else {
                                continue;
                            }
                        }
                        if (next == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
