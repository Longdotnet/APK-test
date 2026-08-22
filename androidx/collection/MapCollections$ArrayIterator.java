package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class MapCollections$ArrayIterator implements Iterator {
    public boolean mCanRemove = false;
    public int mIndex;
    public final int mOffset;
    public int mSize;
    public final /* synthetic */ ArrayMap.AnonymousClass1 this$0;

    public MapCollections$ArrayIterator(ArrayMap.AnonymousClass1 anonymousClass1, int i) {
        this.this$0 = anonymousClass1;
        this.mOffset = i;
        this.mSize = anonymousClass1.colGetSize();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.mIndex < this.mSize;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objColGetEntry = this.this$0.colGetEntry(this.mIndex, this.mOffset);
        this.mIndex++;
        this.mCanRemove = true;
        return objColGetEntry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.mCanRemove) {
            throw new IllegalStateException();
        }
        int i = this.mIndex - 1;
        this.mIndex = i;
        this.mSize--;
        this.mCanRemove = false;
        this.this$0.colRemoveAt(i);
    }
}
