package com.google.android.gms.games.internal.v2.resolution;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class zzc {
    public final boolean zza;
    public final Intent zzb;

    public zzc(boolean z, Intent intent) {
        this.zza = z;
        this.zzb = intent;
    }

    public static zzc zza(Intent intent) {
        return new zzc(true, intent);
    }

    public static zzc zzb(Intent intent) {
        return new zzc(false, intent);
    }

    public final boolean zzc() {
        return this.zza;
    }

    public final Intent zzd() {
        return this.zzb;
    }
}
