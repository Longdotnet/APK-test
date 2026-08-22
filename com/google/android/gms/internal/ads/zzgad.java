package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzgad extends zzfyq {
    final /* synthetic */ zzgae zza;

    public zzgad(zzgae zzgaeVar) {
        Objects.requireNonNull(zzgaeVar);
        this.zza = zzgaeVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzgae zzgaeVar = this.zza;
        zzfvp.zza(i, zzgaeVar.zzc, FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        Object obj = zzgaeVar.zzb[i2];
        Objects.requireNonNull(obj);
        Object obj2 = zzgaeVar.zzb[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfyl
    public final boolean zzf() {
        return true;
    }
}
