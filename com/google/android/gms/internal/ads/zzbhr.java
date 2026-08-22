package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhr extends zzayt implements zzbht {
    public zzbhr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbht
    public final void zze(zzbhj zzbhjVar, String str) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbhjVar);
        parcelZza.writeString(str);
        zzdb(1, parcelZza);
    }
}
