package com.google.android.gms.measurement.internal;

import android.os.SystemClock;
import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzks {
    public final String zza;
    public final long zzb;

    public zzks(zzkt zzktVar, String str) {
        this.zza = str;
        ((DefaultClock) zzktVar.zzav()).getClass();
        this.zzb = SystemClock.elapsedRealtime();
    }
}
