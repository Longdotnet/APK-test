package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes.dex */
final class zzcsd implements zzgdj {
    final /* synthetic */ zzcse zza;

    public zzcsd(zzcse zzcseVar) {
        Objects.requireNonNull(zzcseVar);
        this.zza = zzcseVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        this.zza.zzf.zzl(false);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(@NullableDecl Object obj) {
        this.zza.zzf.zzl(true);
    }
}
