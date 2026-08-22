package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.games.internal.recall.IRecallCallbacks");
    }

    @Override // com.google.android.gms.internal.games_v2.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 2) {
            zzam zzamVar = (zzam) zzc.zzb(parcel, zzam.CREATOR);
            zzc.zze(parcel);
            zzb(zzamVar);
            return true;
        }
        if (i != 3) {
            return false;
        }
        Status status = (Status) zzc.zzb(parcel, Status.CREATOR);
        zzc.zze(parcel);
        zzc(status);
        return true;
    }
}
