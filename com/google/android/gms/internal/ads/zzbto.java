package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbto extends zzayt implements zzbtq {
    public zzbto(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final boolean zzH() {
        Parcel parcelZzda = zzda(11, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(int i, int i2, Intent intent) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeInt(i2);
        zzayv.zze(parcelZza, intent);
        zzdb(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzi() {
        zzdb(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzk(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzl(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzm() {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzo() {
        zzdb(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzp(int i, String[] strArr, int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzdb(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzq() {
        zzdb(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzr() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzs(Bundle bundle) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        Parcel parcelZzda = zzda(6, parcelZza);
        if (parcelZzda.readInt() != 0) {
            bundle.readFromParcel(parcelZzda);
        }
        parcelZzda.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzt() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzu() {
        zzdb(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzv() {
        zzdb(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzx() {
        zzdb(9, zza());
    }
}
