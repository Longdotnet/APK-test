package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzpq {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzpq zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzpq zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzpq zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzps zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzps(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
