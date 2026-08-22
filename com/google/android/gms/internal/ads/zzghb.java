package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzghb extends zzgga {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzggz zzd;

    public /* synthetic */ zzghb(int i, int i2, int i3, zzggz zzggzVar, zzgha zzghaVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzggzVar;
    }

    public static zzggy zzd() {
        return new zzggy(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghb)) {
            return false;
        }
        zzghb zzghbVar = (zzghb) obj;
        return zzghbVar.zza == this.zza && zzghbVar.zzb == this.zzb && zzghbVar.zzd == this.zzd;
    }

    public final int hashCode() {
        return Objects.hash(zzghb.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("AesEax Parameters (variant: ", String.valueOf(this.zzd), ", ");
        sbM21m.append(this.zzb);
        sbM21m.append("-byte IV, 16-byte tag, and ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM21m, this.zza, "-byte key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzd != zzggz.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzggz zze() {
        return this.zzd;
    }
}
