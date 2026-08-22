package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxq extends zzfxu {
    final /* synthetic */ zzfxz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxq(zzfxz zzfxzVar) {
        super(zzfxzVar, null);
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final Object zza(int i) {
        return zzfxz.zzg(this.zza, i);
    }
}
