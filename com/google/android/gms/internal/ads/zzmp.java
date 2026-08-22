package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzmp {
    public final long zza;
    public final zzbl zzb;
    public final int zzc;
    public final zzvh zzd;
    public final long zze;
    public final zzbl zzf;
    public final int zzg;
    public final zzvh zzh;
    public final long zzi;
    public final long zzj;

    public zzmp(long j, zzbl zzblVar, int i, zzvh zzvhVar, long j2, zzbl zzblVar2, int i2, zzvh zzvhVar2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzblVar;
        this.zzc = i;
        this.zzd = zzvhVar;
        this.zze = j2;
        this.zzf = zzblVar2;
        this.zzg = i2;
        this.zzh = zzvhVar2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmp.class == obj.getClass()) {
            zzmp zzmpVar = (zzmp) obj;
            if (this.zza == zzmpVar.zza && this.zzc == zzmpVar.zzc && this.zze == zzmpVar.zze && this.zzg == zzmpVar.zzg && this.zzi == zzmpVar.zzi && this.zzj == zzmpVar.zzj && Objects.equals(this.zzb, zzmpVar.zzb) && Objects.equals(this.zzd, zzmpVar.zzd) && Objects.equals(this.zzf, zzmpVar.zzf) && Objects.equals(this.zzh, zzmpVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
