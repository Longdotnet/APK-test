package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class zzcpb implements zzhgr {
    private final zzcoz zza;

    private zzcpb(zzcoz zzcozVar) {
        this.zza = zzcozVar;
    }

    public static View zzc(zzcoz zzcozVar) {
        View viewZza = zzcozVar.zza();
        zzhgz.zzb(viewZza);
        return viewZza;
    }

    public static zzcpb zzd(zzcoz zzcozVar) {
        return new zzcpb(zzcozVar);
    }

    public final View zza() {
        return zzc(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
