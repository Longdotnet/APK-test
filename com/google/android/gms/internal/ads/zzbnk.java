package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbnk implements zzbkf {
    final /* synthetic */ zzbnl zza;
    private final zzbkf zzb;

    public zzbnk(zzbnl zzbnlVar, zzbkf zzbkfVar) {
        Objects.requireNonNull(zzbnlVar);
        this.zza = zzbnlVar;
        this.zzb = zzbkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        this.zzb.zza(this.zza, map);
    }
}
