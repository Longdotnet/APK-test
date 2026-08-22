package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbqz extends zzayu implements zzbra {
    public zzbqz() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzg();
        } else if (i == 3) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zze(string);
        } else {
            if (i != 4) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayv.zzd(parcel);
            zzf(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
