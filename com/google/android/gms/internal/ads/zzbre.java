package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbre extends zzayt implements zzbrg {
    public zzbre(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzg() {
        zzdb(2, zza());
    }
}
