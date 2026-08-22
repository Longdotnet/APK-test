package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbzk {
    final /* synthetic */ zzbzl zza;
    private long zzb;
    private long zzc;

    public zzbzk(zzbzl zzbzlVar) {
        Objects.requireNonNull(zzbzlVar);
        this.zza = zzbzlVar;
        this.zzb = -1L;
        this.zzc = -1L;
    }

    public final long zza() {
        return this.zzc;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.zzb);
        bundle.putLong("tclose", this.zzc);
        return bundle;
    }

    public final void zzc() {
        ((DefaultClock) this.zza.zza).getClass();
        this.zzc = SystemClock.elapsedRealtime();
    }

    public final void zzd() {
        ((DefaultClock) this.zza.zza).getClass();
        this.zzb = SystemClock.elapsedRealtime();
    }
}
