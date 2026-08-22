package com.google.android.gms.internal.auth;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
final class zzfz<E> extends zzdn<E> implements RandomAccess {
    private static final zzfz<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzfz<Object> zzfzVar = new zzfz<>(new Object[0], 0);
        zza = zzfzVar;
        zzfzVar.zzb();
    }

    public zzfz() {
        this(new Object[10], 0);
    }

    public static <E> zzfz<E> zze() {
        return (zzfz<E>) zza;
    }

    private final String zzf(int i) {
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1(i2, 3, 2, 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzg(i);
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zza();
        zzg(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zza();
        zzg(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.auth.zzeu
    public final /* bridge */ /* synthetic */ zzeu zzd(int i) {
        if (i >= this.zzc) {
            return new zzfz(Arrays.copyOf(this.zzb, i), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    private zzfz(E[] eArr, int i) {
        this.zzb = eArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        zza();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }
}
