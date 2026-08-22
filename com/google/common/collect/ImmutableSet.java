package com.google.common.collect;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.google.common.math.IntMath$1;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import okio.Okio;

/* JADX INFO: loaded from: classes.dex */
public abstract class ImmutableSet extends ImmutableCollection implements Set {
    public static final /* synthetic */ int $r8$clinit = 0;

    public abstract class CachingAsList extends ImmutableSet {
        public transient ImmutableList asList;

        @Override // com.google.common.collect.ImmutableCollection
        public final ImmutableList asList() {
            ImmutableList immutableList = this.asList;
            if (immutableList != null) {
                return immutableList;
            }
            ImmutableList immutableListCreateAsList = createAsList();
            this.asList = immutableListCreateAsList;
            return immutableListCreateAsList;
        }

        public abstract ImmutableList createAsList();
    }

    public final class JdkBackedSetBuilderImpl extends SetBuilderImpl {
        public final HashSet delegate;

        public JdkBackedSetBuilderImpl(RegularSetBuilderImpl regularSetBuilderImpl) {
            int iCeil;
            Object[] objArr = regularSetBuilderImpl.dedupedElements;
            this.dedupedElements = Arrays.copyOf(objArr, objArr.length);
            int i = regularSetBuilderImpl.distinct;
            this.distinct = i;
            if (i >= 3) {
                iCeil = i < 1073741824 ? (int) Math.ceil(((double) i) / 0.75d) : Integer.MAX_VALUE;
            } else {
                if (i < 0) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "expectedSize cannot be negative but was: "));
                }
                iCeil = i + 1;
            }
            this.delegate = new HashSet(iCeil);
            for (int i2 = 0; i2 < this.distinct; i2++) {
                HashSet hashSet = this.delegate;
                Object obj = this.dedupedElements[i2];
                Objects.requireNonNull(obj);
                hashSet.add(obj);
            }
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        public final SetBuilderImpl add(Object obj) {
            obj.getClass();
            if (this.delegate.add(obj)) {
                addDedupedElement(obj);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        public final ImmutableSet build() {
            int i = this.distinct;
            if (i == 0) {
                int i2 = ImmutableSet.$r8$clinit;
                return RegularImmutableSet.EMPTY;
            }
            if (i != 1) {
                return new JdkBackedImmutableSet(this.delegate, ImmutableList.asImmutableList(this.dedupedElements, this.distinct));
            }
            Object obj = this.dedupedElements[0];
            Objects.requireNonNull(obj);
            int i3 = ImmutableSet.$r8$clinit;
            return new SingletonImmutableSet(obj);
        }
    }

    public final class RegularSetBuilderImpl extends SetBuilderImpl {
        public int expandTableThreshold;
        public int hashCode;
        public Object[] hashTable;
        public int maxRunBeforeFallback;

        public static Object[] rebuildHashTable(Object[] objArr, int i, int i2) {
            int i3;
            Object[] objArr2 = new Object[i];
            int i4 = i - 1;
            for (int i5 = 0; i5 < i2; i5++) {
                Object obj = objArr[i5];
                Objects.requireNonNull(obj);
                int iSmear = Okio.smear(obj.hashCode());
                while (true) {
                    i3 = iSmear & i4;
                    if (objArr2[i3] == null) {
                        break;
                    }
                    iSmear++;
                }
                objArr2[i3] = obj;
            }
            return objArr2;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        public final SetBuilderImpl add(Object obj) {
            if (this.hashTable != null) {
                return insertInHashTable(obj);
            }
            if (this.distinct == 0) {
                addDedupedElement(obj);
                return this;
            }
            ensureTableCapacity(this.dedupedElements.length);
            Object obj2 = this.dedupedElements[0];
            this.distinct--;
            return insertInHashTable(obj2).add(obj);
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        public final ImmutableSet build() {
            int i = this.distinct;
            if (i == 0) {
                return RegularImmutableSet.EMPTY;
            }
            if (i == 1) {
                Object obj = this.dedupedElements[0];
                Objects.requireNonNull(obj);
                return new SingletonImmutableSet(obj);
            }
            Object[] objArrCopyOf = this.dedupedElements;
            if (i != objArrCopyOf.length) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i);
            }
            int i2 = this.hashCode;
            Object[] objArr = this.hashTable;
            Objects.requireNonNull(objArr);
            return new RegularImmutableSet(objArrCopyOf, i2, objArr, this.hashTable.length - 1);
        }

        public final void ensureTableCapacity(int i) {
            int length;
            Object[] objArr = this.hashTable;
            if (objArr == null) {
                length = ImmutableSet.chooseTableSize(i);
                this.hashTable = new Object[length];
            } else {
                if (i <= this.expandTableThreshold || objArr.length >= 1073741824) {
                    return;
                }
                length = objArr.length * 2;
                this.hashTable = rebuildHashTable(this.dedupedElements, length, this.distinct);
            }
            this.maxRunBeforeFallback = GamepadHandler_API19.log2(length, RoundingMode.UNNECESSARY) * 13;
            this.expandTableThreshold = (int) (((double) length) * 0.7d);
        }

        public final SetBuilderImpl insertInHashTable(Object obj) {
            Objects.requireNonNull(this.hashTable);
            int iHashCode = obj.hashCode();
            int iSmear = Okio.smear(iHashCode);
            int length = this.hashTable.length - 1;
            for (int i = iSmear; i - iSmear < this.maxRunBeforeFallback; i++) {
                int i2 = i & length;
                Object obj2 = this.hashTable[i2];
                if (obj2 == null) {
                    addDedupedElement(obj);
                    this.hashTable[i2] = obj;
                    this.hashCode += iHashCode;
                    ensureTableCapacity(this.distinct);
                    return this;
                }
                if (obj2.equals(obj)) {
                    return this;
                }
            }
            JdkBackedSetBuilderImpl jdkBackedSetBuilderImpl = new JdkBackedSetBuilderImpl(this);
            jdkBackedSetBuilderImpl.add(obj);
            return jdkBackedSetBuilderImpl;
        }

        @Override // com.google.common.collect.ImmutableSet.SetBuilderImpl
        public final SetBuilderImpl review() {
            if (this.hashTable == null) {
                return this;
            }
            int iChooseTableSize = ImmutableSet.chooseTableSize(this.distinct);
            if (iChooseTableSize * 2 < this.hashTable.length) {
                this.hashTable = rebuildHashTable(this.dedupedElements, iChooseTableSize, this.distinct);
                this.maxRunBeforeFallback = GamepadHandler_API19.log2(iChooseTableSize, RoundingMode.UNNECESSARY) * 13;
                this.expandTableThreshold = (int) (((double) iChooseTableSize) * 0.7d);
            }
            Object[] objArr = this.hashTable;
            int iLog2 = GamepadHandler_API19.log2(objArr.length, RoundingMode.UNNECESSARY) * 13;
            int length = objArr.length - 1;
            int i = 0;
            int i2 = 0;
            while (i < objArr.length) {
                if (i != i2 || objArr[i] != null) {
                    int i3 = i + iLog2;
                    for (int i4 = i3 - 1; i4 >= i2; i4--) {
                        if (objArr[i4 & length] == null) {
                            i2 = i3;
                            i = i4 + 1;
                        }
                    }
                    return new JdkBackedSetBuilderImpl(this);
                }
                i2 = i + iLog2;
                if (objArr[(i2 - 1) & length] != null) {
                    i2 = i + 1;
                }
                i = i2;
            }
            return this;
        }
    }

    public final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        public final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            int i;
            Object[] objArr = this.elements;
            int length = objArr.length;
            if (length == 0) {
                return RegularImmutableSet.EMPTY;
            }
            if (length == 1) {
                return new SingletonImmutableSet(objArr[0]);
            }
            int length2 = objArr.length;
            Object[] objArr2 = (Object[]) objArr.clone();
            RoundingMode roundingMode = RoundingMode.CEILING;
            if (length2 < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(length2, "x (", ") must be >= 0"));
            }
            int iSqrt = (int) Math.sqrt(length2);
            switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    if (iSqrt * iSqrt != length2) {
                        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                    }
                case 2:
                case 3:
                    return ImmutableSet.construct(objArr2, length2, Math.max(4, iSqrt));
                case 4:
                case 5:
                    i = iSqrt * iSqrt;
                    iSqrt += (~(~(i - length2))) >>> 31;
                    return ImmutableSet.construct(objArr2, length2, Math.max(4, iSqrt));
                case 6:
                case 7:
                case 8:
                    i = (iSqrt * iSqrt) + iSqrt;
                    iSqrt += (~(~(i - length2))) >>> 31;
                    return ImmutableSet.construct(objArr2, length2, Math.max(4, iSqrt));
                default:
                    throw new AssertionError();
            }
        }
    }

    public abstract class SetBuilderImpl {
        public Object[] dedupedElements;
        public int distinct;

        public abstract SetBuilderImpl add(Object obj);

        public final void addDedupedElement(Object obj) {
            int i = this.distinct;
            int i2 = i + 1;
            Object[] objArr = this.dedupedElements;
            if (i2 > objArr.length) {
                int length = objArr.length;
                if (i2 < 0) {
                    throw new AssertionError("cannot store more than MAX_VALUE elements");
                }
                int iHighestOneBit = length + (length >> 1) + 1;
                if (iHighestOneBit < i2) {
                    iHighestOneBit = Integer.highestOneBit(i) << 1;
                }
                if (iHighestOneBit < 0) {
                    iHighestOneBit = Integer.MAX_VALUE;
                }
                this.dedupedElements = Arrays.copyOf(this.dedupedElements, iHighestOneBit);
            }
            Object[] objArr2 = this.dedupedElements;
            int i3 = this.distinct;
            this.distinct = i3 + 1;
            objArr2[i3] = obj;
        }

        public abstract ImmutableSet build();

        public SetBuilderImpl review() {
            return this;
        }
    }

    public static int chooseTableSize(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static ImmutableSet construct(Object[] objArr, int i, int i2) {
        SetBuilderImpl setBuilderImplAdd;
        if (i == 0) {
            return RegularImmutableSet.EMPTY;
        }
        int i3 = 0;
        if (i == 1) {
            return new SingletonImmutableSet(objArr[0]);
        }
        RegularSetBuilderImpl regularSetBuilderImpl = new RegularSetBuilderImpl();
        regularSetBuilderImpl.dedupedElements = new Object[i2];
        regularSetBuilderImpl.distinct = 0;
        regularSetBuilderImpl.hashTable = null;
        regularSetBuilderImpl.maxRunBeforeFallback = 0;
        regularSetBuilderImpl.expandTableThreshold = 0;
        while (i3 < i) {
            setBuilderImplAdd = regularSetBuilderImpl;
            Object obj = objArr[i3];
            obj.getClass();
            i3++;
            setBuilderImplAdd = setBuilderImplAdd.add(obj);
        }
        setBuilderImplAdd = regularSetBuilderImpl;
        return setBuilderImplAdd.review().build();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public boolean isHashCodeFast() {
        return this instanceof ImmutableEnumSet;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray(ImmutableCollection.EMPTY_ARRAY));
    }
}
