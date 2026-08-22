package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbxa extends zzayt implements zzbxc {
    public zzbxa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zze(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzg() {
        zzdb(1, zza());
    }
}
