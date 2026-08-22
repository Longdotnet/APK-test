package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.loader.app.gv.DYYbQc;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes2.dex */
public final class zzy {
    public static int zza(int i, int i2, String str) {
        String strZzb;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strZzb = zzag.zzb(DaWYVMJ.dWyNRTXAh, FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
            }
            strZzb = zzag.zzb("%s (%s) must be less than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strZzb);
    }

    public static int zzb(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(zzd(i, i2, FirebaseAnalytics.Param.INDEX));
        }
        return i;
    }

    private static String zzd(int i, int i2, String str) {
        if (i < 0) {
            return zzag.zzb("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zzag.zzb("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "negative size: "));
    }

    public static void zzc(int i, int i2, int i3) {
        String strZzd;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strZzd = zzd(i, i3, "start index");
            } else {
                strZzd = (i2 < 0 || i2 > i3) ? zzd(i2, i3, "end index") : zzag.zzb(DYYbQc.jjTvbKpIgNU, Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strZzd);
        }
    }
}
