package kotlin.ranges;

/* JADX INFO: loaded from: classes3.dex */
public final class IntRange extends IntProgression {
    public static final IntRange EMPTY = new IntRange(1, 0, 1);

    public final boolean contains(int i) {
        return this.first <= i && i <= this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (this.first == intRange.first) {
                    if (this.last == intRange.last) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean isEmpty() {
        return this.first > this.last;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        return this.first + ".." + this.last;
    }
}
