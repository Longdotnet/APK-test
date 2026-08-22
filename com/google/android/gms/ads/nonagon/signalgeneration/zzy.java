package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzdxp;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* JADX INFO: loaded from: classes.dex */
public final class zzy implements zzhgr {
    public final /* synthetic */ int $r8$classId;
    public final zzhha zza;

    public /* synthetic */ zzy(zzhha zzhhaVar, int i) {
        this.$r8$classId = i;
        this.zza = zzhhaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final Object zzb() {
        switch (this.$r8$classId) {
            case 0:
                return new zzv((zzdso) this.zza.zzb());
            default:
                return new zzbi(zzffu.zzc(), ((zzdxp) this.zza).zzb());
        }
    }
}
