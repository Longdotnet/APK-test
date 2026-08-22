package com.google.android.gms.games.internal;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzj extends com.google.android.gms.internal.games_v2.zzac {
    public final /* synthetic */ zzah zza;

    public zzj(zzah zzahVar) {
        Objects.requireNonNull(zzahVar);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.games_v2.zzac
    public final com.google.android.gms.internal.games_v2.zzab zza() {
        return new zzt(this.zza);
    }
}
