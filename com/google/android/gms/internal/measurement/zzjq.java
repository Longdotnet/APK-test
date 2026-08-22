package com.google.android.gms.internal.measurement;

/* JADX INFO: loaded from: classes.dex */
final class zzjq {
    private final Object zza;
    private final int zzb;

    public zzjq(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjq)) {
            return false;
        }
        zzjq zzjqVar = (zzjq) obj;
        return this.zza == zzjqVar.zza && this.zzb == zzjqVar.zzb;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
