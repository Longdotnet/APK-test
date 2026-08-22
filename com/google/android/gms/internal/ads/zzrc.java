package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzrc {
    private final Context zza;
    private final zzpj zzb;
    private boolean zzc;
    private final zzra zzd;
    private final zzrb zze;
    private zzre zzf;
    private zzqu zzg;

    @Deprecated
    public zzrc() {
        this.zza = null;
        this.zzb = zzpj.zza;
        this.zzd = zzra.zza;
        this.zze = zzrb.zza;
    }

    public final zzro zzc() {
        zzdd.zzf(!this.zzc);
        this.zzc = true;
        if (this.zzf == null) {
            this.zzf = new zzre(new zzcn[0]);
        }
        if (this.zzg == null) {
            this.zzg = new zzqu(this.zza);
        }
        return new zzro(this, null);
    }

    public zzrc(Context context) {
        this.zza = context;
        this.zzb = zzpj.zza;
        this.zzd = zzra.zza;
        this.zze = zzrb.zza;
    }
}
