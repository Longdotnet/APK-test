package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzwf extends zzaei {
    final /* synthetic */ zzwl zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzwf(zzwl zzwlVar, zzaeu zzaeuVar) {
        super(zzaeuVar);
        Objects.requireNonNull(zzwlVar);
        this.zza = zzwlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaei, com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zza.zzB;
    }
}
