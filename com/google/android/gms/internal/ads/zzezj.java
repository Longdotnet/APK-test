package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
final class zzezj implements zzfve {
    final /* synthetic */ zzezn zza;

    public zzezj(zzezn zzeznVar) {
        Objects.requireNonNull(zzeznVar);
        this.zza = zzeznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfve
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("", (zzdyx) obj);
        com.google.android.gms.ads.internal.util.zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzezn zzeznVar = this.zza;
        zzeznVar.zzd = new zzezl(null, zzeznVar.zze(), null);
        return zzeznVar.zzd;
    }
}
