package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrb extends zzayt implements zzbrd {
    public zzbrb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrd
    public final void zzh(zzbpz zzbpzVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbpzVar);
        zzdb(4, parcelZza);
    }
}
