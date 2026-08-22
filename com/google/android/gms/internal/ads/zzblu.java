package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzblu extends zzayu implements zzblv {
    public zzblu() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzayv.zza(parcel, ParcelFileDescriptor.CREATOR);
        zzayv.zzd(parcel);
        zzb(parcelFileDescriptor);
        return true;
    }
}
