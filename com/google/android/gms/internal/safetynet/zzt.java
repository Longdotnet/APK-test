package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzt extends zze {
    private final /* synthetic */ zzk.zzc zzah;

    public zzt(zzk.zzc zzcVar) {
        this.zzah = zzcVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, boolean z) {
        this.zzah.setResult(new zzk.zzj(status, z));
    }
}
