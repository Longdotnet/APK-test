package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbau extends zzayt implements zzbaw {
    public zzbau(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final long zze() {
        Parcel parcelZzda = zzda(9, zza());
        long j = parcelZzda.readLong();
        parcelZzda.recycle();
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzbx zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final com.google.android.gms.ads.internal.client.zzea zzg() {
        Parcel parcelZzda = zzda(5, zza());
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzb = com.google.android.gms.ads.internal.client.zzdz.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzeaVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final String zzh() {
        Parcel parcelZzda = zzda(8, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzi(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzj(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzdtVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzk(long j) {
        Parcel parcelZza = zza();
        parcelZza.writeLong(j);
        zzdb(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaw
    public final void zzl(IObjectWrapper iObjectWrapper, zzbbd zzbbdVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbbdVar);
        zzdb(4, parcelZza);
    }
}
