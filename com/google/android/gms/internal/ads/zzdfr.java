package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdfr implements zzhgr {
    private final zzdff zza;
    private final zzhha zzb;

    private zzdfr(zzdff zzdffVar, zzhha zzhhaVar) {
        this.zza = zzdffVar;
        this.zzb = zzhhaVar;
    }

    public static zzdfr zza(zzdff zzdffVar, zzhha zzhhaVar) {
        return new zzdfr(zzdffVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzf = this.zza.zzf((zzcur) this.zzb.zzb());
        zzhgz.zzb(setZzf);
        return setZzf;
    }
}
