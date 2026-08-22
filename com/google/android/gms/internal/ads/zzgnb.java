package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzgnb extends zzgfm {
    private final String zza;
    private final zzgvf zzb;

    public /* synthetic */ zzgnb(String str, zzgvf zzgvfVar, zzgnc zzgncVar) {
        this.zza = str;
        this.zzb = zzgvfVar;
    }

    public final String toString() {
        String str;
        String str2 = this.zza;
        int iOrdinal = this.zzb.ordinal();
        if (iOrdinal == 1) {
            str = "TINK";
        } else if (iOrdinal == 2) {
            str = "LEGACY";
        } else if (iOrdinal != 3) {
            str = iOrdinal != 4 ? "UNKNOWN" : "CRUNCHY";
        } else {
            str = "RAW";
        }
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m("(typeUrl=", str2, ", outputPrefixType=", str, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzb != zzgvf.RAW;
    }
}
