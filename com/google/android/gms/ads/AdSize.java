package com.google.android.gms.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzf;

/* JADX INFO: loaded from: classes2.dex */
public final class AdSize {
    public static final AdSize FLUID;
    public static final AdSize INVALID;
    public static final AdSize SMART_BANNER;
    public final int zzb;
    public final int zzc;
    public final String zzd;
    public boolean zze;
    public boolean zzf;
    public int zzg;
    public boolean zzh;
    public int zzi;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");

    public AdSize(int i, int i2) {
        this(i, i2, (i == -1 ? "FULL" : String.valueOf(i)) + "x" + (i2 == -2 ? "AUTO" : String.valueOf(i2)) + "_as");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzb == adSize.zzb && this.zzc == adSize.zzc && this.zzd.equals(adSize.zzd);
    }

    public final int getHeightInPixels(Context context) {
        int i;
        int i2 = this.zzc;
        if (i2 == -4 || i2 == -3) {
            return -1;
        }
        if (i2 != -2) {
            zzf zzfVar = zzbb.zzb.zzc;
            return zzf.zzC(context, i2);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.heightPixels;
        float f2 = displayMetrics.density;
        int i3 = (int) (f / f2);
        if (i3 <= 400) {
            i = 32;
        } else {
            i = i3 <= 720 ? 50 : 90;
        }
        return (int) (i * f2);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd;
    }

    static {
        new AdSize(160, 600, "160x600_as");
        SMART_BANNER = new AdSize(-1, -2, "smart_banner");
        FLUID = new AdSize(-3, -4, FETmZwrVHuasmL.cOOBrwuNExdtwmV);
        INVALID = new AdSize(0, 0, "invalid");
        new AdSize(50, 50, "50x50_mb");
        new AdSize(-3, 0, "search_v2");
    }

    public AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Invalid width for AdSize: "));
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i2, "Invalid height for AdSize: "));
        }
        this.zzb = i;
        this.zzc = i2;
        this.zzd = str;
    }
}
