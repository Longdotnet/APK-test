package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaqb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaqd zzc;

    public zzaqb(zzaqd zzaqdVar, String str, long j) {
        this.zza = str;
        this.zzb = j;
        Objects.requireNonNull(zzaqdVar);
        this.zzc = zzaqdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaqd zzaqdVar = this.zzc;
        zzaqdVar.zza.zza(this.zza, this.zzb);
        zzaqdVar.zza.zzb(zzaqdVar.toString());
    }
}
