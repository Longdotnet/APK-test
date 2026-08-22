package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzhz extends zzhd {
    static final zzhd zza = new zzhz(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzhz(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfu.zzb(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, com.google.android.gms.internal.games_v2.zzgy
    public final int zze(Object[] objArr, int i) {
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }
}
