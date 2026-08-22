package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbrh extends zzayt implements zzbrj {
    public zzbrh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zze(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final void zzg(zzbqf zzbqfVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbqfVar);
        zzdb(1, parcelZza);
    }
}
