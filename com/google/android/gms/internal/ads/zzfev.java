package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfev implements zzfet {
    private final String zza;

    public zzfev(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfet
    public final boolean equals(Object obj) {
        if (obj instanceof zzfev) {
            return this.zza.equals(((zzfev) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfet
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
