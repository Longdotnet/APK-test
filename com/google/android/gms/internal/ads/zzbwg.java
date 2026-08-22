package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwg extends zzayt implements zzbwi {
    public zzbwg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zze(zzbwc zzbwcVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwcVar);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzf() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzh() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzi() {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzj() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzk() {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbwi
    public final void zzl() {
        zzdb(3, zza());
    }
}
