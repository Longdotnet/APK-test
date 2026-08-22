package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class BitArray implements Cloneable {
    public int size = 0;
    public int[] bits = new int[1];

    public final void appendBit(boolean z) {
        ensureCapacity(this.size + 1);
        if (z) {
            int[] iArr = this.bits;
            int i = this.size;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.size++;
    }

    public final void appendBits(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        ensureCapacity(this.size + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            appendBit(z);
            i2--;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.bits.clone();
        int i = this.size;
        BitArray bitArray = new BitArray();
        bitArray.bits = iArr;
        bitArray.size = i;
        return bitArray;
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.bits;
        if (i > (iArr.length << 5)) {
            int[] iArr2 = new int[(i + 31) / 32];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.bits = iArr2;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BitArray)) {
            return false;
        }
        BitArray bitArray = (BitArray) obj;
        return this.size == bitArray.size && Arrays.equals(this.bits, bitArray.bits);
    }

    public final boolean get(int i) {
        return ((1 << (i & 31)) & this.bits[i / 32]) != 0;
    }

    public final int getSizeInBytes() {
        return (this.size + 7) / 8;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.bits) + (this.size * 31);
    }

    public final String toString() {
        int i = this.size;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.size; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(get(i2) ? 'X' : '.');
        }
        return sb.toString();
    }
}
