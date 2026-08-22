package kotlin.text;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
public final class DelimitedRangesSequence implements Sequence {
    public final Lambda getNextMatch;
    public final CharSequence input;
    public final int limit;
    public final int startIndex;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public int counter;
        public int currentStartIndex;
        public IntRange nextItem;
        public int nextSearchIndex;
        public int nextState = -1;

        public AnonymousClass1() {
            int i = DelimitedRangesSequence.this.startIndex;
            int length = DelimitedRangesSequence.this.input.length();
            if (length < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(length, "Cannot coerce value to an empty range: maximum ", " is less than minimum 0."));
            }
            if (i < 0) {
                i = 0;
            } else if (i > length) {
                i = length;
            }
            this.currentStartIndex = i;
            this.nextSearchIndex = i;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0022 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x006f  */
        /* JADX WARN: Code duplicated, block: B:9:0x001c  */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
        public final void calcNext$1() {
            Pair pair;
            int i = this.nextSearchIndex;
            if (i < 0) {
                this.nextState = 0;
                this.nextItem = null;
                return;
            }
            DelimitedRangesSequence delimitedRangesSequence = DelimitedRangesSequence.this;
            int i2 = delimitedRangesSequence.limit;
            CharSequence charSequence = delimitedRangesSequence.input;
            if (i2 > 0) {
                int i3 = this.counter + 1;
                this.counter = i3;
                if (i3 >= i2) {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringsKt.getLastIndex(charSequence), 1);
                    this.nextSearchIndex = -1;
                } else if (i > charSequence.length() && (pair = (Pair) delimitedRangesSequence.getNextMatch.invoke(charSequence, Integer.valueOf(this.nextSearchIndex))) != null) {
                    int iIntValue = ((Number) pair.first).intValue();
                    int iIntValue2 = ((Number) pair.second).intValue();
                    this.nextItem = RangesKt.until(this.currentStartIndex, iIntValue);
                    int i4 = iIntValue + iIntValue2;
                    this.currentStartIndex = i4;
                    this.nextSearchIndex = i4 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringsKt.getLastIndex(charSequence), 1);
                    this.nextSearchIndex = -1;
                }
            } else if (i > charSequence.length()) {
                this.nextItem = new IntRange(this.currentStartIndex, StringsKt__StringsKt.getLastIndex(charSequence), 1);
                this.nextSearchIndex = -1;
            } else {
                int iIntValue3 = ((Number) pair.first).intValue();
                int iIntValue4 = ((Number) pair.second).intValue();
                this.nextItem = RangesKt.until(this.currentStartIndex, iIntValue3);
                int i5 = iIntValue3 + iIntValue4;
                this.currentStartIndex = i5;
                this.nextSearchIndex = i5 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.nextState = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.nextState == -1) {
                calcNext$1();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextState == -1) {
                calcNext$1();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.nextItem;
            Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence input, int i, int i2, Function2 function2) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.input = input;
        this.startIndex = i;
        this.limit = i2;
        this.getNextMatch = (Lambda) function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1();
    }
}
