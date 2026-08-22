package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzeiz implements com.google.android.gms.ads.internal.zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcvw zzb;
    private final zzcwq zzc;
    private final zzdef zzd;
    private final zzddx zze;
    private final zzcnn zzf;

    public zzeiz(zzcvw zzcvwVar, zzcwq zzcwqVar, zzdef zzdefVar, zzddx zzddxVar, zzcnn zzcnnVar) {
        this.zzb = zzcvwVar;
        this.zzc = zzcwqVar;
        this.zzd = zzdefVar;
        this.zze = zzddxVar;
        this.zzf = zzcnnVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzt();
            this.zze.zza(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
