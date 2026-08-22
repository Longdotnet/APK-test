package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeug implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzeug(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
    }

    public static zzeug zzc(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzeug(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeuf zzb() {
        return new zzeuf(((zzchl) this.zza).zza(), zzffu.zzc(), ((zzhhd) this.zzb).zzb(), (zzfhu) this.zzc.zzb(), (zzdsj) this.zzd.zzb());
    }
}
