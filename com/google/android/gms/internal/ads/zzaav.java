package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzaav implements zzacl {
    final /* synthetic */ zzaba zza;

    public zzaav(zzaba zzabaVar) {
        Objects.requireNonNull(zzabaVar);
        this.zza = zzabaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zza() {
        zzaba zzabaVar = this.zza;
        if (zzabaVar.zzs != null) {
            zzabaVar.zzbk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzb() {
        zzlz zzlzVarZzaE = this.zza.zzaE();
        if (zzlzVarZzaE != null) {
            zzlzVarZzaE.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzc() {
        zzaba zzabaVar = this.zza;
        if (zzabaVar.zzs != null) {
            zzabaVar.zzba(0, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzd(zzcd zzcdVar) {
    }
}
