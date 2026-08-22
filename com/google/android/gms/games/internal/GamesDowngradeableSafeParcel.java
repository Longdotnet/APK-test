package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    public static boolean zzp(Integer num) {
        return num != null && num.intValue() >= 3200000;
    }

    public final boolean prepareForClientVersion(int i) {
        setShouldDowngrade(!zzp(Integer.valueOf(i)));
        return true;
    }
}
