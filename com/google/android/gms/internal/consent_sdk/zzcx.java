package com.google.android.gms.internal.consent_sdk;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.yWTz.kBfGXgdfpo;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcx {
    public static int zza(int i, int i2, String str) {
        String strZza;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZza = zzcy.zza("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
            }
            strZza = zzcy.zza(FKidOcdAYt.nLhNDdoHBL, FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZza);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzd(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    public static void zzc(int i, int i2, int i3) {
        String strZzd;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzd = zzd(i, i3, "start index");
            } else {
                strZzd = (i2 < 0 || i2 > i3) ? zzd(i2, i3, "end index") : zzcy.zza("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzd);
        }
    }

    private static String zzd(int i, int i2, String str) {
        if (i < 0) {
            return zzcy.zza("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzcy.zza(kBfGXgdfpo.jRhYY, str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
    }
}
