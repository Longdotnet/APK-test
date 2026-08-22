package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgac extends zzfyq {
    static final zzfyq zza = new zzgac(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzgac(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfvp.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfyq, com.google.android.gms.internal.ads.zzfyl
    public final int zza(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, i, i2);
        return i + i2;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final Object[] zzg() {
        return this.zzb;
    }
}
