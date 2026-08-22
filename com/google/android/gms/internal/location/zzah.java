package com.google.android.gms.internal.location;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((zzaa) zzc.zzb(parcel, zzaa.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zzc();
        }
        return true;
    }
}
