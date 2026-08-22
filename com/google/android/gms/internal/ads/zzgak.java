package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
final class zzgak extends zzgab implements Serializable {
    final zzgab zza;

    public zzgak(zzgab zzgabVar) {
        this.zza = zzgabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgab, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgak) {
            return this.zza.equals(((zzgak) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }
}
