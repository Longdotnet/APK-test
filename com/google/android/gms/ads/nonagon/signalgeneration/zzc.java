package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements zzhgr {
    public final zzchl zza;
    public final zzhha zzb;
    public final zzhha zzc;
    public final zzhha zzd;
    public final zzhha zze;

    public zzc(zzchl zzchlVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzchlVar;
        this.zzb = zzhhaVar;
        this.zzc = zzhhaVar2;
        this.zzd = zzhhaVar3;
        this.zze = zzhhaVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzb(this.zza.zza(), ((Long) this.zzb.zzb()).longValue(), (PackageInfo) this.zzc.zzb(), (zzd) this.zzd.zzb(), (ScheduledExecutorService) this.zze.zzb());
    }
}
