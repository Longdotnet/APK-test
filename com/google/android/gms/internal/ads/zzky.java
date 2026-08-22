package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzky {
    private long zza;
    private float zzb;
    private long zzc;

    public zzky() {
        this.zza = -9223372036854775807L;
        this.zzb = -3.4028235E38f;
        this.zzc = -9223372036854775807L;
    }

    public final zzky zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == -9223372036854775807L) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzdd.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzky zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzky zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzdd.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzla zzg() {
        return new zzla(this, null);
    }

    public /* synthetic */ zzky(zzla zzlaVar, zzkz zzkzVar) {
        this.zza = zzlaVar.zza;
        this.zzb = zzlaVar.zzb;
        this.zzc = zzlaVar.zzc;
    }
}
