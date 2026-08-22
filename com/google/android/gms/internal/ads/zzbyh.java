package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
final class zzbyh {
    private Context zza;
    private Clock zzb;
    private com.google.android.gms.ads.internal.util.zzg zzc;
    private zzbyo zzd;

    private zzbyh() {
        throw null;
    }

    public final zzbyh zza(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzc = zzgVar;
        return this;
    }

    public final zzbyh zzb(Context context) {
        context.getClass();
        this.zza = context;
        return this;
    }

    public final zzbyh zzc(Clock clock) {
        clock.getClass();
        this.zzb = clock;
        return this;
    }

    public final zzbyh zzd(zzbyo zzbyoVar) {
        this.zzd = zzbyoVar;
        return this;
    }

    public final zzbyp zze() {
        zzhgz.zzc(this.zza, Context.class);
        zzhgz.zzc(this.zzb, Clock.class);
        zzhgz.zzc(this.zzc, com.google.android.gms.ads.internal.util.zzg.class);
        zzhgz.zzc(this.zzd, zzbyo.class);
        return new zzbyi(this.zza, this.zzb, this.zzc, this.zzd);
    }

    public /* synthetic */ zzbyh(zzbyj zzbyjVar) {
    }
}
