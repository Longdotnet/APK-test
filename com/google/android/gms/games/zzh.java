package com.google.android.gms.games;

import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzh {
    public int zza = 4368;
    public final ArrayList zzb = new ArrayList();
    public String zzc = null;
    public com.google.android.gms.games.internal.zzi zzd = com.google.android.gms.games.internal.zzi.zza;

    static {
        new AtomicInteger(0);
    }

    public final zzh zza(int i) {
        this.zza = 2101523;
        return this;
    }

    public final zzh zzb(String str) {
        this.zzc = str;
        return this;
    }

    public final zzh zzc(com.google.android.gms.games.internal.zzi zziVar) {
        zzah.checkNotNull(zziVar);
        this.zzd = zziVar;
        return this;
    }

    public final zzi zzd() {
        return new zzi(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
