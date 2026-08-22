package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiParamDefaults_Factory;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder_Factory;

/* JADX INFO: loaded from: classes.dex */
public final class zzdst implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzdst(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        this.zza = zzhhaVar2;
        this.zzb = zzhhaVar3;
        this.zzc = zzhhaVar4;
        this.zzd = zzhhaVar5;
    }

    public static zzdst zza(zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4, zzhha zzhhaVar5) {
        return new zzdst(zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4, zzhhaVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        zzgdy zzgdyVarZzc = zzffu.zzc();
        com.google.android.gms.ads.internal.util.client.zzu zzuVar = (com.google.android.gms.ads.internal.util.client.zzu) this.zza.zzb();
        CsiParamDefaults_Factory csiParamDefaults_Factory = (CsiParamDefaults_Factory) this.zzb;
        CsiParamDefaults csiParamDefaults = new CsiParamDefaults((Context) csiParamDefaults_Factory.zza.zzb(), (VersionInfoParcel) csiParamDefaults_Factory.zzb.zzb());
        ((CsiUrlBuilder_Factory) this.zzc).getClass();
        return new zzdso(zzgdyVarZzc, zzuVar, csiParamDefaults, new CsiUrlBuilder(), ((zzchl) this.zzd).zza());
    }
}
