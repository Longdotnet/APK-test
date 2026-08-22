package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzdy extends zzayt implements zzea {
    public zzdy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final Bundle zze() {
        Parcel parcelZzda = zzda(5, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final zzv zzf() {
        Parcel parcelZzda = zzda(4, zza());
        zzv zzvVar = (zzv) zzayv.zza(parcelZzda, zzv.CREATOR);
        parcelZzda.recycle();
        return zzvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzg() {
        Parcel parcelZzda = zzda(1, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzh() {
        Parcel parcelZzda = zzda(6, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final String zzi() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzea
    public final List zzj() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzda.createTypedArrayList(zzv.CREATOR);
        parcelZzda.recycle();
        return arrayListCreateTypedArrayList;
    }
}
