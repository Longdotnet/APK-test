package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxs extends zzfxu {
    final /* synthetic */ zzfxz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxs(zzfxz zzfxzVar) {
        super(zzfxzVar, null);
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final Object zza(int i) {
        return zzfxz.zzj(this.zza, i);
    }
}
