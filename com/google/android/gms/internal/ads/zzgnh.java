package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgnh {
    public static final zzgnh zza = new zzgnf().zza();
    private final Map zzb;

    public final boolean equals(Object obj) {
        if (obj instanceof zzgnh) {
            return this.zzb.equals(((zzgnh) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final boolean zza() {
        return this.zzb.isEmpty();
    }
}
