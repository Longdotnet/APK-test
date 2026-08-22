package com.google.android.gms.measurement.internal;

import androidx.core.app.NotificationCompat$Style;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzgl extends NotificationCompat$Style {
    public boolean zza;

    public zzgl(zzfr zzfrVar) {
        super(zzfrVar);
        ((zzfr) this.mBuilder).zzG++;
    }

    public abstract boolean zzf();

    public final void zzu() {
        if (!this.zza) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzf()) {
            return;
        }
        ((zzfr) this.mBuilder).zzB$1();
        this.zza = true;
    }
}
