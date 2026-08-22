package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzc;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbc extends com.google.android.gms.internal.location.zzb implements zzbd {
    public static zzbd zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterfaceQueryLocalInterface instanceof zzbd ? (zzbd) iInterfaceQueryLocalInterface : new zzbb(iBinder, "com.google.android.gms.location.ILocationListener");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzd((Location) zzc.zzb(parcel, Location.CREATOR));
        return true;
    }
}
