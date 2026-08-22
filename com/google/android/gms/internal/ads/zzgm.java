package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzgm {
    private Uri zza;
    private Map zzb;
    private long zzc;
    private final long zzd;
    private int zze;

    public /* synthetic */ zzgm(zzgo zzgoVar, zzgn zzgnVar) {
        this.zza = zzgoVar.zza;
        this.zzb = zzgoVar.zzd;
        this.zzc = zzgoVar.zze;
        this.zzd = zzgoVar.zzf;
        this.zze = zzgoVar.zzg;
    }

    public final zzgm zza(int i) {
        this.zze = 6;
        return this;
    }

    public final zzgm zzb(Map map) {
        this.zzb = map;
        return this;
    }

    public final zzgm zzc(long j) {
        this.zzc = j;
        return this;
    }

    public final zzgm zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzgo zze() {
        if (this.zza == null) {
            throw new IllegalStateException("The uri must be set.");
        }
        return new zzgo(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public zzgm() {
        this.zzb = Collections.emptyMap();
        this.zzd = -1L;
    }
}
