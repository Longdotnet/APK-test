package com.google.android.gms.internal.measurement;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
final class zzhu extends zzib {
    public zzhu(zzhy zzhyVar, String str, Long l, boolean z) {
        super(zzhyVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Invalid long value for ", zzc(), ": ");
            sbM21m.append((String) obj);
            Log.e("PhenotypeFlag", sbM21m.toString());
            return null;
        }
    }
}
