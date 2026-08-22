package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzghm extends zzgga {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzghk zzd;

    public /* synthetic */ zzghm(int i, int i2, int i3, zzghk zzghkVar, zzghl zzghlVar) {
        this.zza = i;
        this.zzd = zzghkVar;
    }

    public static zzghj zzc() {
        return new zzghj(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghm)) {
            return false;
        }
        zzghm zzghmVar = (zzghm) obj;
        return zzghmVar.zza == this.zza && zzghmVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzghm.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("AesGcm Parameters (variant: ", String.valueOf(this.zzd), ", 12-byte IV, 16-byte tag, and "), this.zza, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzd != zzghk.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzghk zzd() {
        return this.zzd;
    }
}
