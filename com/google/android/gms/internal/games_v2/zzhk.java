package com.google.android.gms.internal.games_v2;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzhk extends zzgy implements Set {
    private transient zzhd zza;

    public static int zzf(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzhk zzk(int i, Object... objArr) {
        if (i == 0) {
            return zzif.zza;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzii(obj);
        }
        int iZzf = zzf(i);
        Object[] objArr2 = new Object[iZzf];
        int i2 = iZzf - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj2 = objArr[i5];
            zzhs.zzb(obj2, i5);
            int iHashCode = obj2.hashCode();
            int iZza = zzgv.zza(iHashCode);
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
            return new zzii(obj4);
        }
        if (zzf(i4) < iZzf / 2) {
            return zzk(i4, objArr);
        }
        int length = objArr.length;
        if (i4 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzif(objArr, i3, objArr2, i2, i4);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzhk) && zzg() && ((zzhk) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
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
        return zzih.zza(this);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzil iterator();

    public boolean zzg() {
        return false;
    }

    public final zzhd zzh() {
        zzhd zzhdVar = this.zza;
        if (zzhdVar != null) {
            return zzhdVar;
        }
        zzhd zzhdVarZzi = zzi();
        this.zza = zzhdVarZzi;
        return zzhdVarZzi;
    }

    public zzhd zzi() {
        Object[] array = toArray();
        int i = zzhd.zzd;
        return zzhd.zzk(array, array.length);
    }
}
