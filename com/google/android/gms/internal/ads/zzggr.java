package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzggr extends zzgga {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzggp zze;
    private final zzggo zzf;

    public /* synthetic */ zzggr(int i, int i2, int i3, int i4, zzggp zzggpVar, zzggo zzggoVar, zzggq zzggqVar) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzggpVar;
        this.zzf = zzggoVar;
    }

    public static zzggn zzf() {
        return new zzggn(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggr)) {
            return false;
        }
        zzggr zzggrVar = (zzggr) obj;
        return zzggrVar.zza == this.zza && zzggrVar.zzb == this.zzb && zzggrVar.zzc == this.zzc && zzggrVar.zzd == this.zzd && zzggrVar.zze == this.zze && zzggrVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzggr.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("AesCtrHmacAead Parameters (variant: ", String.valueOf(this.zze), ", hashType: ", String.valueOf(this.zzf), ", ");
        sbM22m.append(this.zzc);
        sbM22m.append("-byte IV, and ");
        sbM22m.append(this.zzd);
        sbM22m.append("-byte tags, and ");
        sbM22m.append(this.zza);
        sbM22m.append("-byte AES key, and ");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sbM22m, this.zzb, "-byte HMAC key)");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zze != zzggp.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzggo zzg() {
        return this.zzf;
    }

    public final zzggp zzh() {
        return this.zze;
    }
}
