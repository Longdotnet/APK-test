package com.google.android.gms.ads;

/* JADX INFO: loaded from: classes.dex */
public enum AdFormat {
    BANNER(0),
    INTERSTITIAL(1),
    REWARDED(2),
    REWARDED_INTERSTITIAL(3),
    NATIVE(4),
    APP_OPEN_AD(6);

    public final int zzb;

    AdFormat(int i) {
        this.zzb = i;
    }

    public static AdFormat getAdFormat(int i) {
        for (AdFormat adFormat : values()) {
            if (adFormat.zzb == i) {
                return adFormat;
            }
        }
        return null;
    }
}
