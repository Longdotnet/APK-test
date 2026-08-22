package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzxp {
    public final long zza;
    public final long zzb;

    public zzxp(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxp)) {
            return false;
        }
        zzxp zzxpVar = (zzxp) obj;
        return this.zza == zzxpVar.zza && this.zzb == zzxpVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
