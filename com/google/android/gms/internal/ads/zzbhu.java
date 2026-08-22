package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzbhu extends zzayt implements zzbhw {
    public zzbhu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbhw
    public final void zze(zzbhj zzbhjVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbhjVar);
        zzdb(1, parcelZza);
    }
}
