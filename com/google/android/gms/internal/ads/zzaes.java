package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class zzaes {
    public final zzaev zza;
    public final zzaev zzb;

    public zzaes(zzaev zzaevVar, zzaev zzaevVar2) {
        this.zza = zzaevVar;
        this.zzb = zzaevVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaes.class == obj.getClass()) {
            zzaes zzaesVar = (zzaes) obj;
            if (this.zza.equals(zzaesVar.zza) && this.zzb.equals(zzaesVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        zzaev zzaevVar = this.zza;
        zzaev zzaevVar2 = this.zzb;
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("[", zzaevVar.toString(), zzaevVar.equals(zzaevVar2) ? "" : ", ".concat(zzaevVar2.toString()), "]");
    }
}
