package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbrr extends zzayu implements zzbrs {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String string = parcel.readString();
            zzayv.zzd(parcel);
            zze(string);
        } else if (i == 2) {
            String string2 = parcel.readString();
            zzayv.zzd(parcel);
            zzf(string2);
        } else {
            if (i != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzayv.zzd(parcel);
            zzg(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }

    public zzbrr() {
        super(QTaELkFI.MVlXYnHwvpSTru);
    }
}
