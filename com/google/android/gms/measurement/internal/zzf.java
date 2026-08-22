package com.google.android.gms.measurement.internal;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf extends zze {
    public boolean zza;

    public zzf(zzfr zzfrVar) {
        super(zzfrVar);
        ((zzfr) this.mBuilder).zzG++;
    }

    public final void zza() {
        if (!this.zza) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzb$1() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzf()) {
            return;
        }
        ((zzfr) this.mBuilder).zzB$1();
        this.zza = true;
    }

    public abstract boolean zzf();
}
