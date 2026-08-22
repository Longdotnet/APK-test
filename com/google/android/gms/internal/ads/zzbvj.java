package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvj extends zzayt implements IInterface {
    public zzbvj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
    }

    public final void zze(com.google.android.gms.ads.internal.util.zzbb zzbbVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbbVar);
        zzdb(2, parcelZza);
    }

    public final void zzf(String str, zzbva zzbvaVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zze(parcelZza, zzbvaVar);
        zzdb(1, parcelZza);
    }
}
