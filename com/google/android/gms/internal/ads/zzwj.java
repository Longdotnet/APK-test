package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzwj {
    public final int zza;
    public final boolean zzb;

    public zzwj(int i, boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwj.class == obj.getClass()) {
            zzwj zzwjVar = (zzwj) obj;
            if (this.zza == zzwjVar.zza && this.zzb == zzwjVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
