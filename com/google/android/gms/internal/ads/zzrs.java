package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzrs implements zzql {
    final /* synthetic */ zzru zza;

    public /* synthetic */ zzrs(zzru zzruVar, zzrt zzrtVar) {
        Objects.requireNonNull(zzruVar);
        this.zza = zzruVar;
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zza(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzp(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzql
    public final void zzb() {
        zzlz zzlzVarZzaE = this.zza.zzaE();
        if (zzlzVarZzaE != null) {
            zzlzVarZzaE.zza();
        }
    }
}
