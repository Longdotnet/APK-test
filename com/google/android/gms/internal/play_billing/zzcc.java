package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
final class zzcc {
    private final Object zza;
    private final int zzb;

    public zzcc(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzcc)) {
            return false;
        }
        zzcc zzccVar = (zzcc) obj;
        return this.zza == zzccVar.zza && this.zzb == zzccVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
