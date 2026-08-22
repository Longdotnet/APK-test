package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbal {
    final long zza;
    final String zzb;
    final int zzc;

    public zzbal(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbal)) {
            return false;
        }
        zzbal zzbalVar = (zzbal) obj;
        return zzbalVar.zza == this.zza && zzbalVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
