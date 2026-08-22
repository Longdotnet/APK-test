package com.google.android.gms.games.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzao {
    public static final zzao zza;
    public volatile boolean zzb;

    static {
        zzao zzaoVar = new zzao();
        zzaoVar.zzb = false;
        zza = zzaoVar;
    }

    public static zzao zza() {
        return zza;
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zzb = true;
    }
}
