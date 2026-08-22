package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes.dex */
final class zzhb extends zzhd {
    private final transient zzhd zza;

    public zzhb(zzhd zzhdVar) {
        this.zza = zzhdVar;
    }

    private final int zzm(int i) {
        return (this.zza.size() - 1) - i;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, com.google.android.gms.internal.games_v2.zzgy, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzhd zzhdVar = this.zza;
        zzfu.zzb(i, zzhdVar.size(), FirebaseAnalytics.Param.INDEX);
        return zzhdVar.get(zzm(i));
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzm(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzm(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd
    public final zzhd zzf() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzhd, java.util.List
    /* JADX INFO: renamed from: zzg */
    public final zzhd subList(int i, int i2) {
        zzhd zzhdVar = this.zza;
        zzfu.zzd(i, i2, zzhdVar.size());
        return zzhdVar.subList(zzhdVar.size() - i2, zzhdVar.size() - i).zzf();
    }
}
