package com.google.android.gms.games.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzi {
    public static final zzi zza = new zzi(new zzh());
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public zzi(zzh zzhVar) {
        this.zzb = zzhVar.zza;
        this.zzc = zzhVar.zzb;
        this.zzd = zzhVar.zzc;
    }

    public static zzh zzd() {
        return new zzh();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzi.class == obj.getClass()) {
            zzi zziVar = (zzi) obj;
            if (this.zzb == zziVar.zzb && this.zzc == zziVar.zzc && this.zzd == zziVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zzb ? 1 : 0) * 31) + (this.zzc ? 1 : 0)) * 31) + (this.zzd ? 1 : 0);
    }

    public final boolean zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
