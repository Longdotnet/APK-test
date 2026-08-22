package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzghx extends zzgga {
    private final int zza;
    private final zzghv zzb;

    public /* synthetic */ zzghx(int i, zzghv zzghvVar, zzghw zzghwVar) {
        this.zza = i;
        this.zzb = zzghvVar;
    }

    public static zzghu zzc() {
        return new zzghu(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghx)) {
            return false;
        }
        zzghx zzghxVar = (zzghx) obj;
        return zzghxVar.zza == this.zza && zzghxVar.zzb == this.zzb;
    }

    public final int hashCode() {
        return Objects.hash(zzghx.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("AesGcmSiv Parameters (variant: ", String.valueOf(this.zzb), ", "), this.zza, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzb != zzghv.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzghv zzd() {
        return this.zzb;
    }
}
