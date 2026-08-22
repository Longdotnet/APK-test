package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.nonagon.signalgeneration.zzd;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzhgr;

/* JADX INFO: loaded from: classes.dex */
public final class zzcc implements zzhgr {
    public final /* synthetic */ int $r8$classId;
    public final zzchl zza;

    public /* synthetic */ zzcc(zzchl zzchlVar, int i) {
        this.$r8$classId = i;
        this.zza = zzchlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        switch (this.$r8$classId) {
            case 0:
                return new zzcb(this.zza.zza());
            default:
                return new zzd(this.zza.zza());
        }
    }
}
