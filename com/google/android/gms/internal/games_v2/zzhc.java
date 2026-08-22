package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzhc extends zzhd {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzhd zzc;

    public zzhc(zzhd zzhdVar, int i, int i2) {
        Objects.requireNonNull(zzhdVar);
        this.zzc = zzhdVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfu.zzb(i, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final Object[] zzb() {
        return this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgy
    public final int zzd() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    /* JADX INFO: renamed from: zzg */
    public final zzhd subList(int i, int i2) {
        zzfu.zzd(i, i2, this.zzb);
        int i3 = this.zza;
        return this.zzc.subList(i + i3, i2 + i3);
    }
}
