package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbax extends zzayt implements zzbaz {
    public zzbax(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzb(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzeVar);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzd(zzbaw zzbawVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbawVar);
        zzdb(1, parcelZza);
    }
}
