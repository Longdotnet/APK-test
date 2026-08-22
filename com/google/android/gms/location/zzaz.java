package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzc;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzaz extends com.google.android.gms.internal.location.zzb implements zzba {
    public static zzba zzb(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterfaceQueryLocalInterface instanceof zzba ? (zzba) iInterfaceQueryLocalInterface : new zzay(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzd((LocationResult) zzc.zzb(parcel, LocationResult.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zze((LocationAvailability) zzc.zzb(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
