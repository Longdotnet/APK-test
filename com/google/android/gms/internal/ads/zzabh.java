package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class zzabh {
    private final Context zza;
    private final zzabs zzb;
    private zzca zzc;
    private boolean zzd;
    private zzdj zze = zzdj.zza;
    private boolean zzf;

    public zzabh(Context context, zzabs zzabsVar) {
        this.zza = context.getApplicationContext();
        this.zzb = zzabsVar;
    }

    public final zzabh zzd(zzdj zzdjVar) {
        this.zze = zzdjVar;
        return this;
    }

    public final zzabh zze(boolean z) {
        this.zzd = true;
        return this;
    }

    public final zzabo zzf() {
        zzdd.zzf(!this.zzf);
        if (this.zzc == null) {
            this.zzc = new zzabl(false);
        }
        zzabo zzaboVar = new zzabo(this, null);
        this.zzf = true;
        return zzaboVar;
    }
}
