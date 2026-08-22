package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchz;
import com.google.android.gms.internal.ads.zzhgr;

/* JADX INFO: loaded from: classes.dex */
public final class CsiParamDefaults_Factory implements zzhgr {
    public final zzchl zza;
    public final zzchz zzb;

    public CsiParamDefaults_Factory(zzchl zzchlVar, zzchz zzchzVar) {
        this.zza = zzchlVar;
        this.zzb = zzchzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        return new CsiParamDefaults((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
