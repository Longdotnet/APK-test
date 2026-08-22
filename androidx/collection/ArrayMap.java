package androidx.collection;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ArrayMap extends SimpleArrayMap implements Map {
    public AnonymousClass1 mCollections;

    /* JADX INFO: renamed from: androidx.collection.ArrayMap$1 */
    public final class AnonymousClass1 {
        public final /* synthetic */ int $r8$classId;
        public MapCollections$KeySet mEntrySet;
        public MapCollections$KeySet mKeySet;
        public MapCollections$ValuesCollection mValues;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass1(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        public static boolean equalsSetHelper(Set set, Object obj) {
            if (set == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set2 = (Set) obj;
                try {
                    return set.size() == set2.size() && set.containsAll(set2);
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }

        public static boolean retainAllHelper(Map map, Collection collection) {
            int size = map.size();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != map.size();
        }

        public final void colClear() {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.this$0).clear();
                    break;
                default:
                    ((ArraySet) this.this$0).clear();
                    break;
            }
        }

        public final Object colGetEntry(int i, int i2) {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).mArray[(i << 1) + i2];
                default:
                    return ((ArraySet) this.this$0).mArray[i];
            }
        }

        public final Map colGetMap() {
            switch (this.$r8$classId) {
                case 0:
                    return (ArrayMap) this.this$0;
                default:
                    throw new UnsupportedOperationException("not a map");
            }
        }

        public final int colGetSize() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).mSize;
                default:
                    return ((ArraySet) this.this$0).mSize;
            }
        }

        public final int colIndexOfKey(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).indexOfKey(obj);
                default:
                    return ((ArraySet) this.this$0).indexOf(obj);
            }
        }

        public final int colIndexOfValue(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).indexOfValue(obj);
                default:
                    return ((ArraySet) this.this$0).indexOf(obj);
            }
        }

        public final void colRemoveAt(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ((ArrayMap) this.this$0).removeAt(i);
                    break;
                default:
                    ((ArraySet) this.this$0).removeAt(i);
                    break;
            }
        }

        public final Object[] toArrayHelper(Object[] objArr, int i) {
            int iColGetSize = colGetSize();
            if (objArr.length < iColGetSize) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iColGetSize);
            }
            for (int i2 = 0; i2 < iColGetSize; i2++) {
                objArr[i2] = colGetEntry(i2, i);
            }
            if (objArr.length > iColGetSize) {
                objArr[iColGetSize] = null;
            }
            return objArr;
        }
    }

    public ArrayMap() {
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(this, 0);
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mEntrySet == null) {
            anonymousClass1.mEntrySet = new MapCollections$KeySet(anonymousClass1, 1);
        }
        return anonymousClass1.mEntrySet;
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(this, 0);
        }
        AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mKeySet == null) {
            anonymousClass1.mKeySet = new MapCollections$KeySet(anonymousClass1, 0);
        }
        return anonymousClass1.mKeySet;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        ensureCapacity(map.size() + this.mSize);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.collection.MapCollections$ValuesCollection] */
    @Override // java.util.Map
    public final Collection values() {
        if (this.mCollections == null) {
            this.mCollections = new AnonymousClass1(this, 0);
        }
        final AnonymousClass1 anonymousClass1 = this.mCollections;
        if (anonymousClass1.mValues == null) {
            anonymousClass1.mValues = new Collection() { // from class: androidx.collection.MapCollections$ValuesCollection
                @Override // java.util.Collection
                public final boolean add(Object obj) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Collection
                public final boolean addAll(Collection collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // java.util.Collection
                public final void clear() {
                    anonymousClass1.colClear();
                }

                @Override // java.util.Collection
                public final boolean contains(Object obj) {
                    return anonymousClass1.colIndexOfValue(obj) >= 0;
                }

                @Override // java.util.Collection
                public final boolean containsAll(Collection collection) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                @Override // java.util.Collection
                public final boolean isEmpty() {
                    return anonymousClass1.colGetSize() == 0;
                }

                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator iterator() {
                    return new MapCollections$ArrayIterator(anonymousClass1, 1);
                }

                @Override // java.util.Collection
                public final boolean remove(Object obj) {
                    ArrayMap.AnonymousClass1 anonymousClass2 = anonymousClass1;
                    int iColIndexOfValue = anonymousClass2.colIndexOfValue(obj);
                    if (iColIndexOfValue < 0) {
                        return false;
                    }
                    anonymousClass2.colRemoveAt(iColIndexOfValue);
                    return true;
                }

                @Override // java.util.Collection
                public final boolean removeAll(Collection collection) {
                    ArrayMap.AnonymousClass1 anonymousClass2 = anonymousClass1;
                    int iColGetSize = anonymousClass2.colGetSize();
                    int i = 0;
                    boolean z = false;
                    while (i < iColGetSize) {
                        if (collection.contains(anonymousClass2.colGetEntry(i, 1))) {
                            anonymousClass2.colRemoveAt(i);
                            i--;
                            iColGetSize--;
                            z = true;
                        }
                        i++;
                    }
                    return z;
                }

                @Override // java.util.Collection
                public final boolean retainAll(Collection collection) {
                    ArrayMap.AnonymousClass1 anonymousClass2 = anonymousClass1;
                    int iColGetSize = anonymousClass2.colGetSize();
                    int i = 0;
                    boolean z = false;
                    while (i < iColGetSize) {
                        if (!collection.contains(anonymousClass2.colGetEntry(i, 1))) {
                            anonymousClass2.colRemoveAt(i);
                            i--;
                            iColGetSize--;
                            z = true;
                        }
                        i++;
                    }
                    return z;
                }

                @Override // java.util.Collection
                public final int size() {
                    return anonymousClass1.colGetSize();
                }

                @Override // java.util.Collection
                public final Object[] toArray() {
                    ArrayMap.AnonymousClass1 anonymousClass2 = anonymousClass1;
                    int iColGetSize = anonymousClass2.colGetSize();
                    Object[] objArr = new Object[iColGetSize];
                    for (int i = 0; i < iColGetSize; i++) {
                        objArr[i] = anonymousClass2.colGetEntry(i, 1);
                    }
                    return objArr;
                }

                @Override // java.util.Collection
                public final Object[] toArray(Object[] objArr) {
                    return anonymousClass1.toArrayHelper(objArr, 1);
                }
            };
        }
        return anonymousClass1.mValues;
    }

    public ArrayMap(int i) {
        if (i == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }
}
