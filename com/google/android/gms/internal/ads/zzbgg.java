package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgg extends zzayt implements zzbgi {
    public zzbgg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final String zzg() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbgi
    public final List zzh() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }
}
