package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwl extends zzayt implements zzbwn {
    public zzbwl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg(IObjectWrapper iObjectWrapper, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i);
        zzdb(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzh(IObjectWrapper iObjectWrapper) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzi(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzk(IObjectWrapper iObjectWrapper, int i) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzm(IObjectWrapper iObjectWrapper, zzbwo zzbwoVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzbwoVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzn(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzo(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzp(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(5, parcelZza);
    }
}
