package com.google.android.gms.internal.measurement;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbj extends zzaw {
    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        if (str == null || str.isEmpty() || !zzgVar.zzh(str)) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Command not found: ", str));
        }
        zzap zzapVarZzd = zzgVar.zzd(str);
        if (zzapVarZzd instanceof zzai) {
            return ((zzai) zzapVarZzd).zza(zzgVar, list);
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Function ", str, " is not defined"));
    }
}
