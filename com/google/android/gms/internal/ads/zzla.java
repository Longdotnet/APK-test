package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzla {
    public final long zza;
    public final float zzb;
    public final long zzc;

    public /* synthetic */ zzla(zzky zzkyVar, zzkz zzkzVar) {
        this.zza = zzkyVar.zza;
        this.zzb = zzkyVar.zzb;
        this.zzc = zzkyVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzla)) {
            return false;
        }
        zzla zzlaVar = (zzla) obj;
        return this.zza == zzlaVar.zza && this.zzb == zzlaVar.zzb && this.zzc == zzlaVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzky zza() {
        return new zzky(this, null);
    }
}
