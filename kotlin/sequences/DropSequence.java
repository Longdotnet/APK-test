package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.ArrayIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class DropSequence implements Sequence {
    public final int count;
    public final Sequence sequence;

    public DropSequence(Sequence sequence, int i) {
        this.sequence = sequence;
        this.count = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new ArrayIterator(this);
    }
}
