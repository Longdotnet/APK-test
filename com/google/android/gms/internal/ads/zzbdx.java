package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbdx extends zzayt implements zzbdz {
    public zzbdx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbdz
    public final void zze(zzbdw zzbdwVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbdwVar);
        zzdb(1, parcelZza);
    }
}
