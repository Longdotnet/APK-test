package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbly implements zzgcu {
    final /* synthetic */ zzblq zza;

    public zzbly(zzbmc zzbmcVar, zzblq zzblqVar) {
        this.zza = zzblqVar;
        Objects.requireNonNull(zzbmcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) {
        zzcak zzcakVar = new zzcak();
        ((zzblw) obj).zze(this.zza, new zzblx(this, zzcakVar));
        return zzcakVar;
    }
}
