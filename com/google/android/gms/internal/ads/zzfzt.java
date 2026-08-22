package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfzt extends zzfzs {
    final /* synthetic */ zzfzu zza;

    public zzfzt(zzfzu zzfzuVar, int i) {
        Objects.requireNonNull(zzfzuVar);
        this.zza = zzfzuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfzs
    public final zzfzb zza() {
        return new zzfzx(this.zza.zza(), new zzfzr(2));
    }
}
