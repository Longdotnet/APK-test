package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbd {
    private final zzv zza;

    static {
        new zzbc().zze();
        String str = zzex.zza;
        Integer.toString(0, 36);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbd) {
            return this.zza.equals(((zzbd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }
}
