package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbp extends zzayu implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzm zzmVar = (zzm) zzayv.zza(parcel, zzm.CREATOR);
            zzayv.zzd(parcel);
            zzg(zzmVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            String strZze = zze();
            parcel2.writeNoException();
            parcel2.writeString(strZze);
        } else if (i == 3) {
            boolean zZzi = zzi();
            parcel2.writeNoException();
            int i3 = zzayv.zza;
            parcel2.writeInt(zZzi ? 1 : 0);
        } else if (i == 4) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else {
            if (i != 5) {
                return false;
            }
            zzm zzmVar2 = (zzm) zzayv.zza(parcel, zzm.CREATOR);
            int i4 = parcel.readInt();
            zzayv.zzd(parcel);
            zzh(zzmVar2, i4);
            parcel2.writeNoException();
        }
        return true;
    }
}
