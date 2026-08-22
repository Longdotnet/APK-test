package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzu extends zzb implements zzv {
    public zzu() {
        super("com.google.android.gms.games.internal.connect.IGamesConnectCallbacks");
    }

    @Override // com.google.android.gms.internal.games_v2.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        Status status = (Status) zzc.zzb(parcel, Status.CREATOR);
        zzs zzsVar = (zzs) zzc.zzb(parcel, zzs.CREATOR);
        zzc.zze(parcel);
        zzb(status, zzsVar);
        return true;
    }
}
