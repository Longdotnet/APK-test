package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnu implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcnu(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar3;
    }

    public static zzcnu zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3) {
        return new zzcnu(zzhhaVar, zzhhaVar2, zzhhaVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet = ((JSONObject) this.zzb.zzb()) == null ? Collections.emptySet() : Collections.singleton(new zzddv((zzcnn) this.zza.zzb(), zzffu.zzc()));
        zzhgz.zzb(setEmptySet);
        return setEmptySet;
    }
}
