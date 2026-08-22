package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzdu extends zzayt implements zzdw {
    public zzdu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdw
    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        zzdb(1, parcelZza);
    }
}
