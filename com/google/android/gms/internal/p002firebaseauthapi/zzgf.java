package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzgf extends zzbn {
    private final String zza;
    private final zzoy zzb;

    public /* synthetic */ zzgf(String str, zzoy zzoyVar, zzge zzgeVar) {
        this.zza = str;
        this.zzb = zzoyVar;
    }

    public final String toString() {
        String str;
        String str2 = this.zza;
        zzoy zzoyVar = this.zzb;
        zznr zznrVar = zznr.UNKNOWN_KEYMATERIAL;
        zzoy zzoyVar2 = zzoy.UNKNOWN_PREFIX;
        int iOrdinal = zzoyVar.ordinal();
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
}
