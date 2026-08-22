package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzblc extends zzayt implements zzble {
    public zzblc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsEventListener");
    }

    @Override // com.google.android.gms.internal.ads.zzble
    public final void zzb(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdb(1, parcelZza);
    }
}
