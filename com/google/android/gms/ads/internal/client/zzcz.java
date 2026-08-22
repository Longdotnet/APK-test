package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzcz extends zzayt implements zzdb {
    public zzcz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final float zze() {
        Parcel parcelZzda = zzda(7, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzg() {
        Parcel parcelZzda = zzda(13, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzda.createTypedArrayList(zzbmd.CREATOR);
        parcelZzda.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzk() {
        zzdb(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzo(zzbpq zzbpqVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbpqVar);
        zzdb(11, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzp(boolean z) {
        Parcel parcelZza = zza();
        int i = zzayv.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzq(float f) {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs(zzbmk zzbmkVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbmkVar);
        zzdb(12, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzt(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(18, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzu(zzfx zzfxVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzfxVar);
        zzdb(14, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final boolean zzv() {
        Parcel parcelZzda = zzda(8, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
