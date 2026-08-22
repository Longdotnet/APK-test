package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzb extends zzayt implements zzbzd {
    public zzbzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbzd
    public final zzbza zze(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        zzbza zzbyyVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(2, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbyyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzbyyVar = iInterfaceQueryLocalInterface instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface : new zzbyy(strongBinder);
        }
        parcelZzda.recycle();
        return zzbyyVar;
    }
}
