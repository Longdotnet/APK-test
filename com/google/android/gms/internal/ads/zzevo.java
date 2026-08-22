package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class zzevo implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzevo(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
    }

    public static zzevo zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzevo(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    public static zzevm zzc(String str, zzbbf zzbbfVar, zzbzs zzbzsVar, ScheduledExecutorService scheduledExecutorService, zzgdy zzgdyVar) {
        return new zzevm(str, zzbbfVar, zzbzsVar, scheduledExecutorService, zzgdyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzevm(((zzewj) this.zza).zzc(), zzckr.zza(), (zzbzs) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzffu.zzc());
    }
}
