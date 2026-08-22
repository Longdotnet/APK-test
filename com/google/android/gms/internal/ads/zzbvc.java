package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvc extends zzayt implements zzbve {
    public zzbvc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zze(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbvqVar);
        zzayv.zzg(parcelZza, zzbviVar);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzf(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbvqVar);
        zzayv.zzg(parcelZza, zzbviVar);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzg(zzbvq zzbvqVar, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbvqVar);
        zzayv.zzg(parcelZza, zzbviVar);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzh(String str, zzbvi zzbviVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbviVar);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbve
    public final void zzi(zzbva zzbvaVar, zzbvj zzbvjVar) {
        throw null;
    }
}
