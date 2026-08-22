package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzrj implements zzqr {
    final /* synthetic */ zzro zza;

    public /* synthetic */ zzrj(zzro zzroVar, zzrn zzrnVar) {
        Objects.requireNonNull(zzroVar);
        this.zza = zzroVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zza(long j) {
        zzea.zzf("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j);
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzb(long j) {
        zzro zzroVar = this.zza;
        if (zzroVar.zzq != null) {
            ((zzrs) zzroVar.zzq).zza.zzc.zzx(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzc(long j, long j2, long j3, long j4) {
        zzro zzroVar = this.zza;
        zzea.zzf("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzroVar.zzN() + ", " + zzroVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zzd(long j, long j2, long j3, long j4) {
        zzro zzroVar = this.zza;
        zzea.zzf("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + zzroVar.zzN() + ", " + zzroVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzqr
    public final void zze(int i, long j) {
        zzro zzroVar = this.zza;
        if (zzroVar.zzq != null) {
            ((zzrs) zzroVar.zzq).zza.zzc.zzz(i, j, SystemClock.elapsedRealtime() - zzroVar.zzW);
        }
    }
}
