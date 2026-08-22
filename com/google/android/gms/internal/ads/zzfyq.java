package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfyq extends zzfyl implements List, RandomAccess {
    private static final zzgax zza = new zzfyo(zzgac.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    public static zzfyn zzi(int i) {
        zzfxn.zza(i, "expectedSize");
        return new zzfyn(i);
    }

    public static zzfyq zzj(Object[] objArr, int i) {
        return i == 0 ? zzgac.zza : new zzgac(objArr, i);
    }

    public static zzfyq zzk(Iterable iterable) {
        iterable.getClass();
        return zzl((Collection) iterable);
    }

    public static zzfyq zzl(Collection collection) {
        if (!(collection instanceof zzfyl)) {
            Object[] array = collection.toArray();
            int length = array.length;
            zzgaa.zzb(array, length);
            return zzj(array, length);
        }
        zzfyq zzfyqVarZzd = ((zzfyl) collection).zzd();
        if (!zzfyqVarZzd.zzf()) {
            return zzfyqVarZzd;
        }
        Object[] array2 = zzfyqVarZzd.toArray();
        return zzj(array2, array2.length);
    }

    public static zzfyq zzm(Object[] objArr) {
        if (objArr.length == 0) {
            return zzgac.zza;
        }
        Object[] objArr2 = (Object[]) objArr.clone();
        int length = objArr2.length;
        zzgaa.zzb(objArr2, length);
        return zzj(objArr2, length);
    }

    public static zzfyq zzn() {
        return zzgac.zza;
    }

    public static zzfyq zzo(Object obj) {
        Object[] objArr = {obj};
        zzgaa.zzb(objArr, 1);
        return zzj(objArr, 1);
    }

    public static zzfyq zzp(Object obj, Object obj2) {
        Object[] objArr = {obj, obj2};
        zzgaa.zzb(objArr, 2);
        return zzj(objArr, 2);
    }

    public static zzfyq zzq(Object obj, Object obj2, Object obj3) {
        Object[] objArr = {obj, obj2, obj3};
        zzgaa.zzb(objArr, 3);
        return zzj(objArr, 3);
    }

    public static zzfyq zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        Object[] objArr = {obj, obj2, obj3, obj4, obj5};
        zzgaa.zzb(objArr, 5);
        return zzj(objArr, 5);
    }

    public static zzfyq zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Object[] objArr = {"3010", "3008", "1005", "1009", "2011", "2007"};
        zzgaa.zzb(objArr, 6);
        return zzj(objArr, 6);
    }

    @SafeVarargs
    public static zzfyq zzt(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        int length = objArr.length;
        int i = length + 12;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, length);
        zzgaa.zzb(objArr2, i);
        return zzj(objArr2, i);
    }

    public static zzfyq zzu(Comparator comparator, Iterable iterable) {
        Object[] array = (iterable instanceof Collection ? (Collection) iterable : zzfzg.zza(((zzfyq) iterable).listIterator(0))).toArray();
        int length = array.length;
        zzgaa.zzb(array, length);
        Arrays.sort(array, comparator);
        return zzj(array, length);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzfvm.zza(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && zzfvm.zza(it.next(), it2.next())) {
                    }
                }
                if (!it2.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
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

    @Override // com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
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
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    @Deprecated
    public final zzfyq zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    /* JADX INFO: renamed from: zze */
    public final zzgaw iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzh */
    public zzfyq subList(int i, int i2) {
        zzfvp.zzk(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? zzgac.zza : new zzfyp(this, i, i3);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzv */
    public final zzgax listIterator(int i) {
        zzfvp.zzb(i, size(), FirebaseAnalytics.Param.INDEX);
        return isEmpty() ? zza : new zzfyo(this, i);
    }
}
