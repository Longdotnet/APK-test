package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbvh extends zzayu implements zzbvi {
    public zzbvh() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzayv.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzayv.zzd(parcel);
            zzf(parcelFileDescriptor);
        } else if (i == 2) {
            com.google.android.gms.ads.internal.util.zzbb zzbbVar = (com.google.android.gms.ads.internal.util.zzbb) zzayv.zza(parcel, com.google.android.gms.ads.internal.util.zzbb.CREATOR);
            zzayv.zzd(parcel);
            zze(zzbbVar);
        } else {
            if (i != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzayv.zza(parcel, ParcelFileDescriptor.CREATOR);
            zzbvq zzbvqVar = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
            zzayv.zzd(parcel);
            zzg(parcelFileDescriptor2, zzbvqVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
