package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes.dex */
final class zzbyi extends zzbyp {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    private final Clock zzj;

    public zzbyi(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyo zzbyoVar) {
        this.zzj = clock;
        zzhgr zzhgrVarZza = zzhgs.zza(context);
        this.zza = zzhgrVarZza;
        zzhgr zzhgrVarZza2 = zzhgs.zza(zzgVar);
        this.zzb = zzhgrVarZza2;
        this.zzc = zzhgq.zzc(zzbyc.zza(zzhgrVarZza, zzhgrVarZza2));
        zzhgr zzhgrVarZza3 = zzhgs.zza(clock);
        this.zzd = zzhgrVarZza3;
        zzhgr zzhgrVarZza4 = zzhgs.zza(zzbyoVar);
        this.zze = zzhgrVarZza4;
        zzhha zzhhaVarZzc = zzhgq.zzc(zzbye.zza(zzhgrVarZza3, zzhgrVarZza2, zzhgrVarZza4));
        this.zzf = zzhhaVarZzc;
        zzbyg zzbygVarZzc = zzbyg.zzc(zzhgrVarZza3, zzhhaVarZzc);
        this.zzg = zzbygVarZzc;
        this.zzh = zzhgq.zzc(zzbyu.zza(zzhgrVarZza, zzbygVarZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbyp
    public final zzbyf zza() {
        return new zzbyf(this.zzj, (zzbyd) this.zzf.zzb());
    }
}
