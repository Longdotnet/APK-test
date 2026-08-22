package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((ProxyResponse) zzc.zza(parcel, ProxyResponse.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zzc(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
