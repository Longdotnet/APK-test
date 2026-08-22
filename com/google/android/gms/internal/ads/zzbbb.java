package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbbb extends zzayt implements zzbbd {
    public zzbbb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzb() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzc() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zze() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbbd
    public final void zzf() {
        zzdb(1, zza());
    }
}
