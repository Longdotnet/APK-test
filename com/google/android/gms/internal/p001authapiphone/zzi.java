package com.google.android.gms.internal.p001authapiphone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzi extends zzb implements zzj {
    public zzi() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // com.google.android.gms.internal.p001authapiphone.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzb((Status) zzc.zza(parcel, Status.CREATOR));
        return true;
    }
}
