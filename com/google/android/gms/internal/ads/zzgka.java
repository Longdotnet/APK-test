package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgka extends zzgga {
    private final zzgjz zza;

    private zzgka(zzgjz zzgjzVar) {
        this.zza = zzgjzVar;
    }

    public static zzgka zzc(zzgjz zzgjzVar) {
        return new zzgka(zzgjzVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzgka) && ((zzgka) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzgka.class, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza != zzgjz.zzc;
    }

    public final zzgjz zzb() {
        return this.zza;
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("XChaCha20Poly1305 Parameters (variant: ", this.zza.toString(), JuorMn.TBjWVdqmC);
    }
}
