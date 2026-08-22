package com.google.android.gms.internal.measurement;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.IJ.gZrKCJ;

/* JADX INFO: loaded from: classes2.dex */
final class zzhw extends zzib {
    public zzhw(zzhy zzhyVar, String str, Double d, boolean z) {
        super(zzhyVar, "measurement.test.double_flag", d, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzib
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            StringBuilder sbM21m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m21m("Invalid double value for ", zzc(), ": ");
            sbM21m.append((String) obj);
            Log.e(gZrKCJ.nEZr, sbM21m.toString());
            return null;
        }
    }
}
