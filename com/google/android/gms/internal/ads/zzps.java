package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzps {
    public static final zzps zza = new zzpq().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzps(zzpq zzpqVar, zzpr zzprVar) {
        this.zzb = zzpqVar.zza;
        this.zzc = zzpqVar.zzb;
        this.zzd = zzpqVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzps.class == obj.getClass()) {
            zzps zzpsVar = (zzps) obj;
            if (this.zzb == zzpsVar.zzb && this.zzc == zzpsVar.zzc && this.zzd == zzpsVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return (z2 ? 1 : 0) + (z2 ? 1 : 0) + ((z ? 1 : 0) << 2) + (this.zzd ? 1 : 0);
    }
}
