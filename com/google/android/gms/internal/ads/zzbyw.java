package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbyw extends zzayu implements zzbyx {
    public zzbyw() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzayv.zzd(parcel);
        } else if (i == 2) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zzb(string);
        } else {
            if (i != 3) {
                return false;
            }
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
            zzayv.zzd(parcel);
            zzc(string2, string3, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}
