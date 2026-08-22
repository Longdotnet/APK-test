package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzs extends zze {
    private final /* synthetic */ zzk.zzb zzag;

    public zzs(zzk.zzb zzbVar) {
        this.zzag = zzbVar;
    }

    @Override // com.google.android.gms.internal.safetynet.zze, com.google.android.gms.internal.safetynet.zzg
    public final void zza(Status status, com.google.android.gms.safetynet.zza zzaVar) {
        this.zzag.setResult(new zzk.zza(status, zzaVar));
    }
}
