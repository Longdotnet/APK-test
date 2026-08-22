package com.google.common.collect;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableList extends ImmutableCollection implements List, RandomAccess {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: renamed from: com.google.common.collect.ImmutableList$1 */
    public final class AnonymousClass1 extends AbstractIndexedListIterator {
        public AnonymousClass1(int i, int i2) {
            super(i, i2);
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        public final Object get(int i) {
            return ImmutableList.this.get(i);
        }
    }

    public final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            int i = ImmutableList.$r8$clinit;
            Object[] objArr = this.elements;
            int length = objArr.length;
            if (length == 0) {
                return RegularImmutableList.EMPTY;
            }
            if (length == 1) {
                return new SingletonImmutableList(objArr[0]);
            }
            Object[] objArr2 = (Object[]) objArr.clone();
            int length2 = objArr2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                if (objArr2[i2] == null) {
                    throw new NullPointerException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "at index "));
                }
            }
            return ImmutableList.asImmutableList(objArr2, objArr2.length);
        }
    }

    public final class SubList extends ImmutableList {
        public final transient int length;
        public final transient int offset;

        public SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        @Override // java.util.List
        public final Object get(int i) {
            StringsKt__IndentKt.checkElementIndex(i, this.length);
            return ImmutableList.this.get(i + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return listIterator(0);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ListIterator listIterator() {
            return listIterator(0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return listIterator(i);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public final ImmutableList subList(int i, int i2) {
            StringsKt__IndentKt.checkPositionIndexes(i, i2, this.length);
            int i3 = this.offset;
            return ImmutableList.this.subList(i + i3, i2 + i3);
        }
    }

    public static ImmutableList asImmutableList(Object[] objArr, int i) {
        if (i == 0) {
            return RegularImmutableList.EMPTY;
        }
        if (i != 1) {
            if (i < objArr.length) {
                objArr = Arrays.copyOf(objArr, i);
            }
            return new RegularImmutableList(objArr);
        }
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        return new SingletonImmutableList(obj);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr) {
        int size = size();
        for (int i = 0; i < size; i++) {
            objArr[i] = get(i);
        }
        return size;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        Object next;
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(list instanceof RandomAccess)) {
                    Iterator it = list.iterator();
                    for (Object obj2 : this) {
                        if (it.hasNext() && (r3 == (next = it.next()) || (obj2 != null && obj2.equals(next)))) {
                        }
                    }
                    return !it.hasNext();
                }
                for (int i = 0; i < size; i++) {
                    Object obj3 = get(i);
                    Object obj4 = list.get(i);
                    if (obj3 == obj4 || (obj3 != null && obj3.equals(obj4))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer consumer) {
        consumer.getClass();
        int size = size();
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public UnmodifiableIterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator spliterator() {
        int size = size();
        return new CollectSpliterators$1WithCharacteristics(IntStream.range(0, size).spliterator(), new ImmutableList$$ExternalSyntheticLambda0(this, 0), 1296);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray(ImmutableCollection.EMPTY_ARRAY));
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public ImmutableList subList(int i, int i2) {
        StringsKt__IndentKt.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return RegularImmutableList.EMPTY;
        }
        return i3 == 1 ? new SingletonImmutableList(get(i)) : new SubList(i, i3);
    }

    @Override // java.util.List
    public AbstractIndexedListIterator listIterator(int i) {
        return new AbstractIndexedListIterator(size(), i) { // from class: com.google.common.collect.ImmutableList.1
            public AnonymousClass1(int i2, int i3) {
                super(i2, i3);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            public final Object get(int i2) {
                return ImmutableList.this.get(i2);
            }
        };
    }
}
