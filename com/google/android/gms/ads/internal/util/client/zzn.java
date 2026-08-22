package com.google.android.gms.ads.internal.util.client;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zzx {
    public final int zza;
    public final int zzb;
    public final double zzc;
    public final boolean zzd;

    public zzn(int i, int i2, double d, boolean z) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = d;
        this.zzd = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzx) {
            zzx zzxVar = (zzx) obj;
            if (this.zza == ((zzn) zzxVar).zza) {
                zzn zznVar = (zzn) zzxVar;
                if (this.zzb == zznVar.zzb && Double.doubleToLongBits(this.zzc) == Double.doubleToLongBits(zznVar.zzc) && this.zzd == zznVar.zzd) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        double d = this.zzc;
        return ((((int) (Double.doubleToLongBits(d) ^ (Double.doubleToLongBits(d) >>> 32))) ^ ((((this.zza ^ 1000003) * 1000003) ^ this.zzb) * 1000003)) * 1000003) ^ (true != this.zzd ? 1237 : 1231);
    }

    public final String toString() {
        return "PingStrategy{maxAttempts=" + this.zza + ", initialBackoffMs=" + this.zzb + ", backoffMultiplier=" + this.zzc + ", bufferAfterMaxAttempts=" + this.zzd + "}";
    }
}
