package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpm;

/* JADX INFO: loaded from: classes.dex */
public final class zzdx extends zzayt {
    public final zzdw zze(ObjectWrapper objectWrapper, zzbpm zzbpmVar) {
        zzdw zzduVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, objectWrapper);
        zzayv.zzg(parcelZza, zzbpmVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(1, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzduVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzduVar = iInterfaceQueryLocalInterface instanceof zzdw ? (zzdw) iInterfaceQueryLocalInterface : new zzdu(strongBinder);
        }
        parcelZzda.recycle();
        return zzduVar;
    }
}
