package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbwt extends zzayt implements zzbwv {
    public zzbwt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final long zzb() {
        Parcel parcelZzda = zzda(17, zza());
        long j = parcelZzda.readLong();
        parcelZzda.recycle();
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final Bundle zzc() {
        Parcel parcelZzda = zzda(9, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final com.google.android.gms.ads.internal.client.zzea zzd() {
        Parcel parcelZzda = zzda(12, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final zzbws zze() {
        zzbws zzbwqVar;
        Parcel parcelZzda = zzda(11, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbwqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbwqVar = iInterfaceQueryLocalInterface instanceof zzbws ? (zzbws) iInterfaceQueryLocalInterface : new zzbwq(strongBinder);
        }
        parcelZzda.recycle();
        return zzbwqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzf() {
        Parcel parcelZzda = zzda(16, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final String zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzh(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, zzbxcVar);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbxc zzbxcVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzmVar);
        zzayv.zzg(parcelZza, zzbxcVar);
        zzdb(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzj(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzk(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdqVar);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzl(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdtVar);
        zzdb(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzm(long j) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdb(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzn(zzbwy zzbwyVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbwyVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzo(zzbxj zzbxjVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbxjVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzp(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzq(IObjectWrapper iObjectWrapper, boolean z) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final boolean zzr() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzs(zzbxd zzbxdVar) {
        throw null;
    }
}
