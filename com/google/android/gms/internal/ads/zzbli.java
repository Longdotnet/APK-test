package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class zzbli extends zzayt implements zzblk {
    public zzbli(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzblk
    public final zzblh zze(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i, zzble zzbleVar) {
        zzblh zzblfVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzayv.zzg(parcelZza, zzbleVar);
        Parcel parcelZzda = zzda(1, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzblfVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzblfVar = iInterfaceQueryLocalInterface instanceof zzblh ? (zzblh) iInterfaceQueryLocalInterface : new zzblf(strongBinder);
        }
        parcelZzda.recycle();
        return zzblfVar;
    }
}
