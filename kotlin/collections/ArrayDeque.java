package kotlin.collections;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayDeque extends java.util.AbstractList implements List, KMutableList {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData = emptyElementData;
    public int head;
    public int size;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int length;
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "index: ", ", size: "));
        }
        if (i == i2) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        ensureCapacity(i2 + 1);
        int iPositiveMod = positiveMod(this.head + i);
        int i3 = this.size;
        if (i < ((i3 + 1) >> 1)) {
            if (iPositiveMod == 0) {
                Object[] objArr = this.elementData;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                iPositiveMod = objArr.length;
            }
            int i4 = iPositiveMod - 1;
            int i5 = this.head;
            if (i5 == 0) {
                Object[] objArr2 = this.elementData;
                Intrinsics.checkNotNullParameter(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i5 - 1;
            }
            int i6 = this.head;
            if (i4 >= i6) {
                Object[] objArr3 = this.elementData;
                objArr3[length] = objArr3[i6];
                ArraysKt.copyInto(objArr3, i6, objArr3, i6 + 1, i4 + 1);
            } else {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, i6 - 1, objArr4, i6, objArr4.length);
                Object[] objArr5 = this.elementData;
                objArr5[objArr5.length - 1] = objArr5[0];
                ArraysKt.copyInto(objArr5, 0, objArr5, 1, i4 + 1);
            }
            this.elementData[i4] = obj;
            this.head = length;
        } else {
            int iPositiveMod2 = positiveMod(this.head + i3);
            if (iPositiveMod < iPositiveMod2) {
                Object[] objArr6 = this.elementData;
                ArraysKt.copyInto(objArr6, iPositiveMod + 1, objArr6, iPositiveMod, iPositiveMod2);
            } else {
                Object[] objArr7 = this.elementData;
                ArraysKt.copyInto(objArr7, 1, objArr7, 0, iPositiveMod2);
                Object[] objArr8 = this.elementData;
                objArr8[0] = objArr8[objArr8.length - 1];
                ArraysKt.copyInto(objArr8, iPositiveMod + 1, objArr8, iPositiveMod, objArr8.length - 1);
            }
            this.elementData[iPositiveMod] = obj;
        }
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "index: ", ", size: "));
        }
        if (elements.isEmpty()) {
            return false;
        }
        int i3 = this.size;
        if (i == i3) {
            return addAll(elements);
        }
        ensureCapacity(elements.size() + i3);
        int iPositiveMod = positiveMod(this.head + this.size);
        int iPositiveMod2 = positiveMod(this.head + i);
        int size = elements.size();
        if (i < ((this.size + 1) >> 1)) {
            int i4 = this.head;
            int length = i4 - size;
            if (iPositiveMod2 < i4) {
                Object[] objArr = this.elementData;
                ArraysKt.copyInto(objArr, length, objArr, i4, objArr.length);
                if (size >= iPositiveMod2) {
                    Object[] objArr2 = this.elementData;
                    ArraysKt.copyInto(objArr2, objArr2.length - size, objArr2, 0, iPositiveMod2);
                } else {
                    Object[] objArr3 = this.elementData;
                    ArraysKt.copyInto(objArr3, objArr3.length - size, objArr3, 0, size);
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, 0, objArr4, size, iPositiveMod2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, length, objArr5, i4, iPositiveMod2);
            } else {
                Object[] objArr6 = this.elementData;
                length += objArr6.length;
                int i5 = iPositiveMod2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    ArraysKt.copyInto(objArr6, length, objArr6, i4, iPositiveMod2);
                } else {
                    ArraysKt.copyInto(objArr6, length, objArr6, i4, i4 + length2);
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, 0, objArr7, this.head + length2, iPositiveMod2);
                }
            }
            this.head = length;
            int length3 = iPositiveMod2 - size;
            if (length3 < 0) {
                length3 += this.elementData.length;
            }
            copyCollectionElements(length3, elements);
        } else {
            int i6 = iPositiveMod2 + size;
            if (iPositiveMod2 < iPositiveMod) {
                int i7 = size + iPositiveMod;
                Object[] objArr8 = this.elementData;
                if (i7 <= objArr8.length) {
                    ArraysKt.copyInto(objArr8, i6, objArr8, iPositiveMod2, iPositiveMod);
                } else if (i6 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, i6 - objArr8.length, objArr8, iPositiveMod2, iPositiveMod);
                } else {
                    int length4 = iPositiveMod - (i7 - objArr8.length);
                    ArraysKt.copyInto(objArr8, 0, objArr8, length4, iPositiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, i6, objArr9, iPositiveMod2, length4);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto(objArr10, size, objArr10, 0, iPositiveMod);
                Object[] objArr11 = this.elementData;
                if (i6 >= objArr11.length) {
                    ArraysKt.copyInto(objArr11, i6 - objArr11.length, objArr11, iPositiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto(objArr11, 0, objArr11, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto(objArr12, i6, objArr12, iPositiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(iPositiveMod2, elements);
        }
        return true;
    }

    public final void addFirst(Object obj) {
        ensureCapacity(this.size + 1);
        int length = this.head;
        if (length == 0) {
            Object[] objArr = this.elementData;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            length = objArr.length;
        }
        int i = length - 1;
        this.head = i;
        this.elementData[i] = obj;
        this.size++;
    }

    public final void addLast(Object obj) {
        ensureCapacity(this.size + 1);
        this.elementData[positiveMod(this.head + this.size)] = obj;
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int iPositiveMod = positiveMod(this.head + this.size);
        int i = this.head;
        if (i < iPositiveMod) {
            ArraysKt.fill(this.elementData, i, iPositiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.fill(objArr, this.head, objArr.length);
            ArraysKt.fill(this.elementData, 0, iPositiveMod);
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void copyCollectionElements(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = collection.size() + this.size;
    }

    public final void ensureCapacity(int i) {
        if (i < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.elementData;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == emptyElementData) {
            if (i < 10) {
                i = 10;
            }
            this.elementData = new Object[i];
            return;
        }
        int length = objArr.length;
        int i2 = length + (length >> 1);
        if (i2 - i < 0) {
            i2 = i;
        }
        if (i2 - 2147483639 > 0) {
            i2 = i > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i2];
        ArraysKt.copyInto(objArr, 0, objArr2, this.head, objArr.length);
        Object[] objArr3 = this.elementData;
        int length2 = objArr3.length;
        int i3 = this.head;
        ArraysKt.copyInto(objArr3, length2 - i3, objArr2, 0, i3);
        this.head = 0;
        this.elementData = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "index: ", ", size: "));
        }
        return this.elementData[positiveMod(this.head + i)];
    }

    public final int incremented(int i) {
        Object[] objArr = this.elementData;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (i == objArr.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int iPositiveMod = positiveMod(this.head + this.size);
        int length = this.head;
        if (length < iPositiveMod) {
            while (length < iPositiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[length])) {
                    i = this.head;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iPositiveMod) {
            return -1;
        }
        int length2 = this.elementData.length;
        while (length < length2) {
            if (Intrinsics.areEqual(obj, this.elementData[length])) {
                i = this.head;
            } else {
                length++;
            }
        }
        for (int i2 = 0; i2 < iPositiveMod; i2++) {
            if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                length = i2 + this.elementData.length;
                i = this.head;
            }
        }
        return -1;
        return length - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int iPositiveMod = positiveMod(this.head + this.size);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            length = iPositiveMod - 1;
            if (i2 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
            return -1;
        }
        if (i2 > iPositiveMod) {
            for (int i3 = iPositiveMod - 1; -1 < i3; i3--) {
                if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    length = i3 + this.elementData.length;
                    i = this.head;
                    return length - i;
                }
            }
            Object[] objArr = this.elementData;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            length = objArr.length - 1;
            int i4 = this.head;
            if (i4 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i4) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
        }
        return -1;
    }

    public final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        return i >= objArr.length ? i - objArr.length : i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "index: ", ", size: "));
        }
        if (i == size() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        if (i < (this.size >> 1)) {
            int i3 = this.head;
            if (iPositiveMod >= i3) {
                ArraysKt.copyInto(objArr, i3 + 1, objArr, i3, iPositiveMod);
            } else {
                ArraysKt.copyInto(objArr, 1, objArr, 0, iPositiveMod);
                Object[] objArr2 = this.elementData;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i4 = this.head;
                ArraysKt.copyInto(objArr2, i4 + 1, objArr2, i4, objArr2.length - 1);
            }
            Object[] objArr3 = this.elementData;
            int i5 = this.head;
            objArr3[i5] = null;
            this.head = incremented(i5);
        } else {
            int iPositiveMod2 = positiveMod((size() - 1) + this.head);
            if (iPositiveMod <= iPositiveMod2) {
                Object[] objArr4 = this.elementData;
                ArraysKt.copyInto(objArr4, iPositiveMod, objArr4, iPositiveMod + 1, iPositiveMod2 + 1);
            } else {
                Object[] objArr5 = this.elementData;
                ArraysKt.copyInto(objArr5, iPositiveMod, objArr5, iPositiveMod + 1, objArr5.length);
                Object[] objArr6 = this.elementData;
                objArr6[objArr6.length - 1] = objArr6[0];
                ArraysKt.copyInto(objArr6, 0, objArr6, 1, iPositiveMod2 + 1);
            }
            this.elementData[iPositiveMod2] = null;
        }
        this.size--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iPositiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.head + this.size);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (elements.contains(obj)) {
                        z = true;
                    } else {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    }
                    i++;
                }
                ArraysKt.fill(this.elementData, iPositiveMod, iPositiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.elementData[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iPositiveMod - this.head;
                if (length2 < 0) {
                    length2 += this.elementData.length;
                }
                this.size = length2;
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.elementData;
        int i = this.head;
        Object obj = objArr[i];
        objArr[i] = null;
        this.head = incremented(i);
        this.size--;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int iPositiveMod = positiveMod((size() - 1) + this.head);
        Object[] objArr = this.elementData;
        Object obj = objArr[iPositiveMod];
        objArr[iPositiveMod] = null;
        this.size--;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iPositiveMod;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int iPositiveMod2 = positiveMod(this.head + this.size);
            int i = this.head;
            if (i < iPositiveMod2) {
                iPositiveMod = i;
                while (i < iPositiveMod2) {
                    Object obj = this.elementData[i];
                    if (elements.contains(obj)) {
                        this.elementData[iPositiveMod] = obj;
                        iPositiveMod++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt.fill(this.elementData, iPositiveMod, iPositiveMod2);
            } else {
                int length = this.elementData.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.elementData;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                iPositiveMod = positiveMod(i2);
                for (int i3 = 0; i3 < iPositiveMod2; i3++) {
                    Object[] objArr2 = this.elementData;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[iPositiveMod] = obj3;
                        iPositiveMod = incremented(iPositiveMod);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                int length2 = iPositiveMod - this.head;
                if (length2 < 0) {
                    length2 += this.elementData.length;
                }
                this.size = length2;
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, i2, "index: ", ", size: "));
        }
        int iPositiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[iPositiveMod];
        objArr[iPositiveMod] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i = this.size;
        if (length < i) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        int iPositiveMod = positiveMod(this.head + this.size);
        int i2 = this.head;
        if (i2 < iPositiveMod) {
            ArraysKt.copyInto(this.elementData, 0, array, i2, iPositiveMod);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, 0, array, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, objArr2.length - this.head, array, 0, iPositiveMod);
        }
        int length2 = array.length;
        int i3 = this.size;
        if (length2 > i3) {
            array[i3] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ensureCapacity(elements.size() + this.size);
        copyCollectionElements(positiveMod(this.head + this.size), elements);
        return true;
    }
}
