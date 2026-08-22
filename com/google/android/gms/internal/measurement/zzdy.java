package com.google.android.gms.internal.measurement;

import android.app.Activity;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
final class zzdy extends zzdu {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzee zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdy(zzee zzeeVar, Activity activity) {
        super(zzeeVar.zza, true);
        this.zzb = zzeeVar;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzdu
    public final void zza() {
        zzcc zzccVar = this.zzb.zza.zzj;
        com.google.android.gms.common.internal.zzah.checkNotNull(zzccVar);
        zzccVar.onActivityStarted(new ObjectWrapper(this.zza), this.zzi);
    }
}
