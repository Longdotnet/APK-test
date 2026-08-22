package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcih implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzcih(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzcih zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzcih(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbvk zzb() {
        Context contextZza = ((zzchl) this.zza).zza();
        zzfhx zzfhxVar = (zzfhx) this.zzb.zzb();
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzbow zzbowVarZzb = zzvVar.zzs.zzb(contextZza, VersionInfoParcel.forPackage(), zzfhxVar);
        zzboq zzboqVar = zzbot.zza;
        zzbowVarZzb.zza("google.afma.request.getAdDictionary", zzboqVar, zzboqVar);
        return new zzbvm(contextZza, zzvVar.zzs.zzb(contextZza, VersionInfoParcel.forPackage(), zzfhxVar).zza("google.afma.sdkConstants.getSdkConstants", zzboqVar, zzboqVar), VersionInfoParcel.forPackage());
    }
}
