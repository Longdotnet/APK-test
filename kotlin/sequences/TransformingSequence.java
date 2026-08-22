package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.AbstractCollection$toString$1;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.DelimitedRangesSequence.AnonymousClass1;

/* JADX INFO: loaded from: classes3.dex */
public final class TransformingSequence implements Sequence {
    public final DelimitedRangesSequence sequence;
    public final AbstractCollection$toString$1 transformer;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public final Iterator iterator;

        public AnonymousClass1() {
            this.iterator = TransformingSequence.this.sequence.new AnonymousClass1();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            return TransformingSequence.this.transformer.invoke(this.iterator.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TransformingSequence(DelimitedRangesSequence delimitedRangesSequence, AbstractCollection$toString$1 abstractCollection$toString$1) {
        this.sequence = delimitedRangesSequence;
        this.transformer = abstractCollection$toString$1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
