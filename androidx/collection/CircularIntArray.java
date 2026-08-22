package androidx.collection;

/* JADX INFO: loaded from: classes.dex */
public final class CircularIntArray {
    public int mCapacityBitmask;
    public int[] mElements;
    public int mHead;
    public int mTail;

    public CircularIntArray() {
        int iHighestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.mCapacityBitmask = iHighestOneBit - 1;
        this.mElements = new int[iHighestOneBit];
    }

    public final void addLast(int i) {
        int[] iArr = this.mElements;
        int i2 = this.mTail;
        iArr[i2] = i;
        int i3 = this.mCapacityBitmask & (i2 + 1);
        this.mTail = i3;
        int i4 = this.mHead;
        if (i3 == i4) {
            int length = iArr.length;
            int i5 = length - i4;
            int i6 = length << 1;
            if (i6 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i6];
            System.arraycopy(iArr, i4, iArr2, 0, i5);
            System.arraycopy(this.mElements, 0, iArr2, i5, this.mHead);
            this.mElements = iArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i6 - 1;
        }
    }
}
