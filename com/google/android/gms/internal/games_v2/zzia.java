package com.google.android.gms.internal.games_v2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzia extends zzhd {
    final /* synthetic */ zzib zza;

    public zzia(zzib zzibVar) {
        Objects.requireNonNull(zzibVar);
        this.zza = zzibVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzib zzibVar = this.zza;
        zzfu.zzb(i, zzibVar.zzl(), FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        Object obj = zzibVar.zzk()[i2];
        Objects.requireNonNull(obj);
        Object obj2 = zzibVar.zzk()[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzl();
    }
}
