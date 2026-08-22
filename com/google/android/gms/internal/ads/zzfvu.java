package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzfvu extends zzfvn {
    private final Object zza;

    public zzfvu(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfvu) {
            return this.zza.equals(((zzfvu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Optional.of(", this.zza.toString(), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final zzfvn zza(zzfve zzfveVar) {
        Object objApply = zzfveVar.apply(this.zza);
        zzfvp.zzc(objApply, "the Function passed to Optional.transform() must not return null.");
        return new zzfvu(objApply);
    }

    @Override // com.google.android.gms.internal.ads.zzfvn
    public final Object zzb(Object obj) {
        return this.zza;
    }
}
