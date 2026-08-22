package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkh extends zzkg {
    public boolean zza;

    public zzkh(zzkt zzktVar) {
        super(zzktVar);
        this.zzf.zzr++;
    }

    public final void zzW() {
        if (!this.zza) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzX() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzb();
        this.zzf.zzs++;
        this.zza = true;
    }

    public abstract void zzb();
}
