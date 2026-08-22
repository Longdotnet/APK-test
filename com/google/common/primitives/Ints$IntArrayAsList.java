package com.google.common.primitives;

import com.google.android.gms.auth.IJ.gZrKCJ;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes2.dex */
public final class Ints$IntArrayAsList extends AbstractList implements RandomAccess, Serializable {
    private static final long serialVersionUID = 0;
    public final int[] array;
    public final int end;
    public final int start;

    public Ints$IntArrayAsList(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            while (i < this.end) {
                if (this.array[i] != iIntValue) {
                    i++;
                } else if (i != -1) {
                    return true;
                }
            }
            i = -1;
            if (i != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ints$IntArrayAsList)) {
            return super.equals(obj);
        }
        Ints$IntArrayAsList ints$IntArrayAsList = (Ints$IntArrayAsList) obj;
        int size = size();
        if (ints$IntArrayAsList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.array[this.start + i] != ints$IntArrayAsList.array[ints$IntArrayAsList.start + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        StringsKt__IndentKt.checkElementIndex(i, size());
        return Integer.valueOf(this.array[this.start + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + this.array[i2];
        }
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i = this.start;
            int i2 = i;
            while (i2 < this.end) {
                if (this.array[i2] != iIntValue) {
                    i2++;
                } else if (i2 >= 0) {
                    return i2 - i;
                }
            }
            i2 = -1;
            if (i2 >= 0) {
                return i2 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i2 = this.end;
            do {
                i2--;
                i = this.start;
                if (i2 < i) {
                    i2 = -1;
                    break;
                }
            } while (this.array[i2] != iIntValue);
            if (i2 >= 0) {
                return i2 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        StringsKt__IndentKt.checkElementIndex(i, size());
        int i2 = this.start + i;
        int[] iArr = this.array;
        int i3 = iArr[i2];
        num.getClass();
        iArr[i2] = num.intValue();
        return Integer.valueOf(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.end - this.start;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i2) {
        StringsKt__IndentKt.checkPositionIndexes(i, i2, size());
        if (i == i2) {
            return Collections.emptyList();
        }
        int i3 = this.start;
        return new Ints$IntArrayAsList(this.array, i + i3, i3 + i2);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        int[] iArr = this.array;
        int i = this.start;
        sb.append(iArr[i]);
        while (true) {
            i++;
            if (i >= this.end) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(gZrKCJ.mGgkHbHqann);
            sb.append(iArr[i]);
        }
    }
}
