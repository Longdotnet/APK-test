package androidx.collection;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class MapCollections$MapIterator implements Iterator, Map.Entry {
    public int mEnd;
    public boolean mEntryValid = false;
    public int mIndex = -1;
    public final /* synthetic */ ArrayMap.AnonymousClass1 this$0;

    public MapCollections$MapIterator(ArrayMap.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
        this.mEnd = anonymousClass1.colGetSize() - 1;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        int i = this.mIndex;
        ArrayMap.AnonymousClass1 anonymousClass1 = this.this$0;
        Object objColGetEntry = anonymousClass1.colGetEntry(i, 0);
        if (key != objColGetEntry && (key == null || !key.equals(objColGetEntry))) {
            return false;
        }
        Object value = entry.getValue();
        Object objColGetEntry2 = anonymousClass1.colGetEntry(this.mIndex, 1);
        return value == objColGetEntry2 || (value != null && value.equals(objColGetEntry2));
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.this$0.colGetEntry(this.mIndex, 0);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        return this.this$0.colGetEntry(this.mIndex, 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.mIndex < this.mEnd;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        int i = this.mIndex;
        ArrayMap.AnonymousClass1 anonymousClass1 = this.this$0;
        Object objColGetEntry = anonymousClass1.colGetEntry(i, 0);
        Object objColGetEntry2 = anonymousClass1.colGetEntry(this.mIndex, 1);
        return (objColGetEntry == null ? 0 : objColGetEntry.hashCode()) ^ (objColGetEntry2 != null ? objColGetEntry2.hashCode() : 0);
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.mIndex++;
        this.mEntryValid = true;
        return this;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.mEntryValid) {
            throw new IllegalStateException();
        }
        this.this$0.colRemoveAt(this.mIndex);
        this.mIndex--;
        this.mEnd--;
        this.mEntryValid = false;
    }

    public final String toString() {
        return getKey() + "=" + getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!this.mEntryValid) {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        ArrayMap.AnonymousClass1 anonymousClass1 = this.this$0;
        int i = this.mIndex;
        switch (anonymousClass1.$r8$classId) {
            case 0:
                int i2 = (i << 1) + 1;
                Object[] objArr = ((ArrayMap) anonymousClass1.this$0).mArray;
                Object obj2 = objArr[i2];
                objArr[i2] = obj;
                return obj2;
            default:
                throw new UnsupportedOperationException(ygoi.UGDox);
        }
    }
}
