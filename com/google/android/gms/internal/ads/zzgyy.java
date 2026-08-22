package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzgyy extends zzgxl implements RandomAccess, zzgzo, zzhbb {
    private static final float[] zza;
    private static final zzgyy zzb;
    private float[] zzc;
    private int zzd;

    static {
        float[] fArr = new float[0];
        zza = fArr;
        zzb = new zzgyy(fArr, 0, false);
    }

    public zzgyy() {
        this(zza, 0, true);
    }

    public static zzgyy zze() {
        return zzb;
    }

    private static int zzj(int i) {
        return Math.max(((i * 3) / 2) + 1, 10);
    }

    private final String zzk(int i) {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, this.zzd, "Index:", ", Size:");
    }

    private final void zzl(int i) {
        if (i < 0 || i >= this.zzd) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float fFloatValue = ((Float) obj).floatValue();
        zzdJ();
        if (i < 0 || i > (i2 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzk(i));
        }
        int i3 = i + 1;
        float[] fArr = this.zzc;
        int length = fArr.length;
        if (i2 < length) {
            System.arraycopy(fArr, i, fArr, i3, i2 - i);
        } else {
            float[] fArr2 = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr2, 0, i);
            System.arraycopy(this.zzc, i, fArr2, i3, this.zzd - i);
            this.zzc = fArr2;
        }
        this.zzc[i] = fFloatValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdJ();
        byte[] bArr = zzgzu.zzb;
        collection.getClass();
        if (!(collection instanceof zzgyy)) {
            return super.addAll(collection);
        }
        zzgyy zzgyyVar = (zzgyy) collection;
        int i = zzgyyVar.zzd;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzd;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.zzc;
        if (i3 > fArr.length) {
            this.zzc = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(zzgyyVar.zzc, 0, this.zzc, this.zzd, zzgyyVar.zzd);
        this.zzd = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgyy)) {
            return super.equals(obj);
        }
        zzgyy zzgyyVar = (zzgyy) obj;
        if (this.zzd != zzgyyVar.zzd) {
            return false;
        }
        float[] fArr = zzgyyVar.zzc;
        for (int i = 0; i < this.zzd; i++) {
            if (Float.floatToIntBits(this.zzc[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzl(i);
        return Float.valueOf(this.zzc[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.zzd; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.zzc[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i = this.zzd;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzc[i2] == fFloatValue) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zzdJ();
        zzl(i);
        float[] fArr = this.zzc;
        float f = fArr[i];
        int i2 = this.zzd;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        zzdJ();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzc;
        System.arraycopy(fArr, i2, fArr, i, this.zzd - i2);
        this.zzd -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        zzdJ();
        zzl(i);
        float[] fArr = this.zzc;
        float f = fArr[i];
        fArr[i] = fFloatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    public final float zzd(int i) {
        zzl(i);
        return this.zzc[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgzt
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgzo zzf(int i) {
        if (i >= this.zzd) {
            return new zzgyy(i == 0 ? zza : Arrays.copyOf(this.zzc, i), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(float f) {
        zzdJ();
        int i = this.zzd;
        int length = this.zzc.length;
        if (i == length) {
            float[] fArr = new float[zzj(length)];
            System.arraycopy(this.zzc, 0, fArr, 0, this.zzd);
            this.zzc = fArr;
        }
        float[] fArr2 = this.zzc;
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        fArr2[i2] = f;
    }

    public final void zzi(int i) {
        int length = this.zzc.length;
        if (i <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new float[Math.max(i, 10)];
            return;
        }
        while (length < i) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzgyy(float[] fArr, int i, boolean z) {
        super(z);
        this.zzc = fArr;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgxl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }
}
