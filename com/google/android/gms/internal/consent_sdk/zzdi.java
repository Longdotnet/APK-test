package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
final class zzdi extends zzdf {
    static final zzdi zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzdi(objArr, 0, objArr, 0, 0);
    }

    public zzdi(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzb = objArr;
        this.zze = i;
        this.zzc = objArr2;
        this.zzf = i2;
        this.zzg = i3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzda.zza(obj.hashCode());
                while (true) {
                    int i = iZza & this.zzf;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb
    /* JADX INFO: renamed from: zzd */
    public final zzdk iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf
    public final zzde zzh() {
        return zzde.zzg(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf
    public final boolean zzl() {
        return true;
    }
}
