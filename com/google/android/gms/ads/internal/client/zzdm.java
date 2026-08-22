package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzdm extends zzayu implements zzdn {
    public zzdm() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zze zzeVar = (zze) zzayv.zza(parcel, zze.CREATOR);
        zzayv.zzd(parcel);
        zze(zzeVar);
        parcel2.writeNoException();
        return true;
    }
}
