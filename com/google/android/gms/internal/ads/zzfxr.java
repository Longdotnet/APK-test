package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfxr extends zzfxu {
    final /* synthetic */ zzfxz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfxr(zzfxz zzfxzVar) {
        super(zzfxzVar, null);
        Objects.requireNonNull(zzfxzVar);
        this.zza = zzfxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final /* bridge */ /* synthetic */ Object zza(int i) {
        return new zzfxw(this.zza, i);
    }
}
