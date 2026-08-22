package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzgne extends zzgfm {
    private final zzgoy zza;

    public zzgne(zzgoy zzgoyVar) {
        this.zza = zzgoyVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgne)) {
            return false;
        }
        zzgoy zzgoyVar = ((zzgne) obj).zza;
        zzgoy zzgoyVar2 = this.zza;
        return zzgoyVar2.zzc().zzg().equals(zzgoyVar.zzc().zzg()) && zzgoyVar2.zzc().zzi().equals(zzgoyVar.zzc().zzi()) && zzgoyVar2.zzc().zzh().equals(zzgoyVar.zzc().zzh());
    }

    public final int hashCode() {
        zzgoy zzgoyVar = this.zza;
        return Objects.hash(zzgoyVar.zzc(), zzgoyVar.zzd());
    }

    public final String toString() {
        String str;
        zzgoy zzgoyVar = this.zza;
        String strZzi = zzgoyVar.zzc().zzi();
        int iOrdinal = zzgoyVar.zzc().zzg().ordinal();
        if (iOrdinal == 1) {
            str = "TINK";
        } else if (iOrdinal == 2) {
            str = "LEGACY";
        } else if (iOrdinal != 3) {
            str = iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY";
        } else {
            str = "RAW";
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("(typeUrl=", strZzi, ", outputPrefixType=", str, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zza.zzc().zzg() != zzgvf.RAW;
    }

    public final zzgoy zzb() {
        return this.zza;
    }
}
