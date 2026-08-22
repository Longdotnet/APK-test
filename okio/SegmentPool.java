package okio;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SegmentPool {
    public static final int HASH_BUCKET_COUNT;
    public static final Segment LOCK = new Segment(new byte[0], 0, 0, false);
    public static final AtomicReference[] hashBuckets;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        hashBuckets = atomicReferenceArr;
    }

    public static final void recycle(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (segment.next != null || segment.prev != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.shared) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        AtomicReference atomicReference = hashBuckets[(int) (threadCurrentThread.getId() & (((long) HASH_BUCKET_COUNT) - 1))];
        Segment segment2 = (Segment) atomicReference.get();
        if (segment2 == LOCK) {
            return;
        }
        int i = segment2 != null ? segment2.limit : 0;
        if (i >= 65536) {
            return;
        }
        segment.next = segment2;
        segment.pos = 0;
        segment.limit = i + 8192;
        while (!atomicReference.compareAndSet(segment2, segment)) {
            if (atomicReference.get() != segment2) {
                segment.next = null;
                return;
            }
        }
    }

    public static final Segment take() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
        AtomicReference atomicReference = hashBuckets[(int) (threadCurrentThread.getId() & (((long) HASH_BUCKET_COUNT) - 1))];
        Segment segment = LOCK;
        Segment segment2 = (Segment) atomicReference.getAndSet(segment);
        if (segment2 == segment) {
            return new Segment();
        }
        if (segment2 == null) {
            atomicReference.set(null);
            return new Segment();
        }
        atomicReference.set(segment2.next);
        segment2.next = null;
        segment2.limit = 0;
        return segment2;
    }
}
