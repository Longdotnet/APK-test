package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbri extends zzayu implements zzbrj {
    public zzbri() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzbqf zzbqfVarZzb = zzbqe.zzb(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            zzg(zzbqfVarZzb);
        } else if (i == 2) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zze(string);
        } else {
            if (i != 3) {
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
