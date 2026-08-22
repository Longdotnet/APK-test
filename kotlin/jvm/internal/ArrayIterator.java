package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.DropSequence;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ int $r8$classId = 1;
    public final Object array;
    public int index;

    public ArrayIterator(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.array = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.$r8$classId) {
            case 0:
                return this.index < ((Object[]) this.array).length;
            case 1:
                return this.index < ((AbstractList) this.array).getSize();
        }
        while (true) {
            int i = this.index;
            it = (Iterator) this.array;
            if (i > 0 && it.hasNext()) {
                it.next();
                this.index--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.$r8$classId) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.array;
                    int i = this.index;
                    this.index = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.index--;
                    throw new NoSuchElementException(e.getMessage());
                }
            case 1:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i2 = this.index;
                this.index = i2 + 1;
                return ((AbstractList) this.array).get(i2);
        }
        while (true) {
            int i3 = this.index;
            it = (Iterator) this.array;
            if (i3 > 0 && it.hasNext()) {
                it.next();
                this.index--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public ArrayIterator(AbstractList abstractList) {
        this.array = abstractList;
    }

    public ArrayIterator(DropSequence dropSequence) {
        this.array = dropSequence.sequence.iterator();
        this.index = dropSequence.count;
    }
}
