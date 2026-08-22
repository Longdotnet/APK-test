package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchz;
import com.google.android.gms.internal.ads.zzcko;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzepn;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzhgr;
import com.google.android.gms.internal.ads.zzhha;

/* JADX INFO: loaded from: classes.dex */
public final class zzg implements zzhgr {
    public final /* synthetic */ int $r8$classId;
    public final zzchl zza;
    public final zzhha zzb;

    public /* synthetic */ zzg(zzchl zzchlVar, zzhha zzhhaVar, int i) {
        this.$r8$classId = i;
        this.zza = zzchlVar;
        this.zzb = zzhhaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        switch (this.$r8$classId) {
            case 0:
                Context contextZza = this.zza.zza();
                zzcko.zza();
                return new zzf(contextZza, zzepn.zzc(), ((zzchz) this.zzb).zza());
            default:
                return new zzo(this.zza.zza(), (zzdso) this.zzb.zzb(), zzffu.zzc());
        }
    }
}
