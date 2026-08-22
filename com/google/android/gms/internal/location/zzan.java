package com.google.android.gms.internal.location;

import android.os.Parcel;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.location.LocationSettingsResult;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzan extends zzb implements zzao {
    @Override // com.google.android.gms.internal.location.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzb((LocationSettingsResult) zzc.zzb(parcel, LocationSettingsResult.CREATOR));
        return true;
    }

    public zzan() {
        super(YcVWhnLsj.EblavtIMqClTAUd);
    }
}
