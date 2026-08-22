package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbrc extends zzayu implements zzbrd {
    public zzbrc() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzg(iObjectWrapperAsInterface);
        } else if (i == 2) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zze(string);
        } else if (i == 3) {
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayv.zzd(parcel);
            zzf(zzeVar);
        } else {
            if (i != 4) {
                return false;
            }
            zzbpz zzbpzVarZzb = zzbpy.zzb(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzh(zzbpzVarZzb);
        }
        parcel2.writeNoException();
        return true;
    }
}
