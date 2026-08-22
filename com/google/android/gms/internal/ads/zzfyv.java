package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfyv extends zzfyl implements Set {
    private transient zzfyq zza;

    public static int zzh(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzfvp.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzfyu zzj(int i) {
        return new zzfyu(i, true);
    }

    public static zzfyv zzl(Collection collection) {
        if ((collection instanceof zzfyv) && !(collection instanceof SortedSet)) {
            zzfyv zzfyvVar = (zzfyv) collection;
            if (!zzfyvVar.zzf()) {
                return zzfyvVar;
            }
        }
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzfyv zzm(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzgat(objArr[0]);
        }
        return zzgai.zza;
    }

    public static zzfyv zzn() {
        return zzgai.zza;
    }

    public static zzfyv zzo(Object obj) {
        return new zzgat(obj);
    }

    public static zzfyv zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzfyv zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzfyv zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzfyv zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[9];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 3);
        return zzv(9, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfyv zzv(int i, Object... objArr) {
        if (i == 0) {
            return zzgai.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzgat(obj);
        }
        int iZzh = zzh(i);
        Object[] objArr2 = new Object[iZzh];
        int i2 = iZzh - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzgaa.zza(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzfyi.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj3 = objArr2[i6];
                if (obj3 == null) {
                    objArr[i4] = obj2;
                    objArr2[i6] = obj2;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzgat(obj4);
        }
        if (zzh(i4) < iZzh / 2) {
            return zzv(i4, objArr);
        }
        if (zzw(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzgai(objArr, i3, objArr2, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzfyv) && zzu() && ((zzfyv) obj).zzu() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgas.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgas.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public zzfyq zzd() {
        zzfyq zzfyqVar = this.zza;
        if (zzfyqVar != null) {
            return zzfyqVar;
        }
        zzfyq zzfyqVarZzi = zzi();
        this.zza = zzfyqVarZzi;
        return zzfyqVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzgaw iterator();

    public zzfyq zzi() {
        Object[] array = toArray();
        int i = zzfyq.zzd;
        return zzfyq.zzj(array, array.length);
    }

    public boolean zzu() {
        return false;
    }
}
