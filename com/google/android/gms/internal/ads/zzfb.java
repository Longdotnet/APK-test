package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfb implements zzau {
    public final int zza;

    public zzfb(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzfb) && this.zza == ((zzfb) obj).zza;
    }

    public final int hashCode() {
        return this.zza;
    }

    public final String toString() {
        return "Mp4AlternateGroup: " + this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzau
    public final /* synthetic */ void zza(zzar zzarVar) {
    }
}
