package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhh extends zzayt implements zzbhj {
    public zzbhh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgm zzf() {
        zzbgm zzbgkVar;
        Parcel parcelZzda = zzda(16, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbgkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbgkVar = iInterfaceQueryLocalInterface instanceof zzbgm ? (zzbgm) iInterfaceQueryLocalInterface : new zzbgk(strongBinder);
        }
        parcelZzda.recycle();
        return zzbgkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgp zzg(String str) {
        zzbgp zzbgnVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(2, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbgnVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbgnVar = iInterfaceQueryLocalInterface instanceof zzbgp ? (zzbgp) iInterfaceQueryLocalInterface : new zzbgn(strongBinder);
        }
        parcelZzda.recycle();
        return zzbgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final IObjectWrapper zzh() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(9, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzi() {
        Parcel parcelZzda = zzda(4, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzj(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(1, parcelZza);
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final List zzk() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList<String> arrayListCreateStringArrayList = parcelZzda.createStringArrayList();
        parcelZzda.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzl() {
        zzdb(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzm() {
        zzdb(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzn(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzo() {
        zzdb(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzp(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzq() {
        Parcel parcelZzda = zzda(12, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(17, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(10, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzt() {
        Parcel parcelZzda = zzda(13, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
