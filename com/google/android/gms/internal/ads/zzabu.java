package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzabu implements DisplayManager.DisplayListener {
    final /* synthetic */ zzabw zza;
    private final DisplayManager zzb;

    public zzabu(zzabw zzabwVar, DisplayManager displayManager) {
        Objects.requireNonNull(zzabwVar);
        this.zza = zzabwVar;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzabw.zzb(this.zza, zzc());
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzex.zzy(null));
        zzabw.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
