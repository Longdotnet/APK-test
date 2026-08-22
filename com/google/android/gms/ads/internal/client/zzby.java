package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbpq;

/* JADX INFO: loaded from: classes.dex */
public final class zzby extends zzayt {
    public zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(ObjectWrapper objectWrapper, zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, objectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        parcelZza.writeInt(i);
        Parcel parcelZzda = zzda(2, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        parcelZzda.recycle();
        return strongBinder;
    }
}
