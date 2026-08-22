package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzdri implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;

    private zzdri(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar4;
    }

    public static zzdri zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzdri(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        Set setEmptySet;
        final String strZzc = ((zzewn) this.zza).zzc();
        Context contextZza = ((zzchl) this.zzb).zza();
        zzgdy zzgdyVarZzc = zzffu.zzc();
        Map mapZzb = ((zzhgv) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzft)).booleanValue()) {
            zzbcc zzbccVar = new zzbcc(new zzbci(contextZza));
            zzbccVar.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdrj
                @Override // com.google.android.gms.internal.ads.zzbcb
                public final void zza(zzbcj.zzt.zza zzaVar) {
                    zzaVar.zzO(strZzc);
                }
            });
            setEmptySet = Collections.singleton(new zzddv(new zzdrl(zzbccVar, mapZzb), zzgdyVarZzc));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhgz.zzb(setEmptySet);
        return setEmptySet;
    }
}
