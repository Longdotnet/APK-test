package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzbp extends zzayt implements zzbr {
    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final boolean zzf(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        Parcel parcelZzda = zzda(1, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.ads.internal.util.zzbr
    public final boolean zzg(IObjectWrapper iObjectWrapper, zza zzaVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzaVar);
        Parcel parcelZzda = zzda(3, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
