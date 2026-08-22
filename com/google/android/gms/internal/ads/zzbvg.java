package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvg extends zzayt implements zzbvi {
    public zzbvg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbbVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, parcelFileDescriptor);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbvq zzbvqVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, parcelFileDescriptor);
        zzayv.zze(parcelZza, zzbvqVar);
        zzdb(3, parcelZza);
    }
}
