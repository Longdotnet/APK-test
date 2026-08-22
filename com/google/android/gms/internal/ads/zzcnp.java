package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnp implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcnp(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcnp zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzcnp(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzayz zzayzVar = (zzayz) this.zza.zzb();
        return new zzcni(zzayzVar.zzc(), (zzbpf) this.zzb.zzb(), zzffs.zzc());
    }
}
