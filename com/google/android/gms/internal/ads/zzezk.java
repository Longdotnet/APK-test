package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
final class zzezk implements zzfve {
    final /* synthetic */ zzezn zza;

    public zzezk(zzezn zzeznVar) {
        Objects.requireNonNull(zzeznVar);
        this.zza = zzeznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfve
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbvq zzbvqVar = (zzbvq) obj;
        zzezl zzezlVar = new zzezl(zzbvqVar, new zzfev(zzbvqVar.zzj), null);
        zzezn zzeznVar = this.zza;
        zzeznVar.zzd = zzezlVar;
        return zzeznVar.zzd;
    }
}
