package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.ads.jY.UUFMQdNK;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfsl extends zzayt implements zzfsn {
    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zze(Bundle bundle, zzfsp zzfspVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzayv.zzg(parcelZza, zzfspVar);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zzf(String str, Bundle bundle, zzfsp zzfspVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zze(parcelZza, bundle);
        zzayv.zzg(parcelZza, zzfspVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsn
    public final void zzg(Bundle bundle, zzfsp zzfspVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, bundle);
        zzayv.zzg(parcelZza, zzfspVar);
        zzdc(3, parcelZza);
    }

    public zzfsl(IBinder iBinder) {
        super(iBinder, UUFMQdNK.UtyhvLxDbxBPG);
    }
}
