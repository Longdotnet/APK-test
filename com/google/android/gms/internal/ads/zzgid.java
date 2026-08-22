package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgid extends zzgga {
    private final zzgic zza;

    private zzgid(zzgic zzgicVar) {
        this.zza = zzgicVar;
    }

    public static zzgid zzc(zzgic zzgicVar) {
        return new zzgid(zzgicVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgid) && ((zzgid) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgid.class, this.zza);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("ChaCha20Poly1305 Parameters (variant: ", this.zza.toString(), ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza != zzgic.zzc;
    }

    public final zzgic zzb() {
        return this.zza;
    }
}
