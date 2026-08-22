package com.google.common.collect;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes.dex */
public final class CollectSpliterators$1WithCharacteristics implements Spliterator {
    public final Spliterator.OfInt delegate;
    public final /* synthetic */ int val$extraCharacteristics;
    public final /* synthetic */ IntFunction val$function;

    public CollectSpliterators$1WithCharacteristics(Spliterator.OfInt ofInt, IntFunction intFunction, int i) {
        this.val$function = intFunction;
        this.val$extraCharacteristics = i;
        this.delegate = ofInt;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.val$extraCharacteristics | 16464;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.delegate.estimateSize();
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        this.delegate.forEachRemaining((IntConsumer) new CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda6(consumer, this.val$function, 0));
    }

    @Override // java.util.Spliterator
    public final Comparator getComparator() {
        if (hasCharacteristics(4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        return this.delegate.tryAdvance((IntConsumer) new CollectSpliterators$1WithCharacteristics$$ExternalSyntheticLambda6(consumer, this.val$function, 1));
    }

    @Override // java.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator.OfInt ofIntTrySplit = this.delegate.trySplit();
        if (ofIntTrySplit == null) {
            return null;
        }
        return new CollectSpliterators$1WithCharacteristics(ofIntTrySplit, this.val$function, this.val$extraCharacteristics);
    }
}
