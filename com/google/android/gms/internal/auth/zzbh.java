package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* JADX INFO: loaded from: classes.dex */
public final class zzbh extends zza implements IInterface {
    public zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    public final void zzd(zzbg zzbgVar) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzbgVar);
        zzc(3, parcelZza);
    }

    public final void zze(zzbg zzbgVar, ProxyRequest proxyRequest) {
        Parcel parcelZza = zza();
        zzc.zzd(parcelZza, zzbgVar);
        zzc.zzc(parcelZza, proxyRequest);
        zzc(1, parcelZza);
    }
}
