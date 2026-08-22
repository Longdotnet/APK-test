package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbid;

/* JADX INFO: loaded from: classes.dex */
public final class zzbr extends zzayt implements zzbt {
    public zzbr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final zzbq zze() {
        zzbq zzboVar;
        Parcel parcelZzda = zzda(1, zza());
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
        }
        parcelZzda.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzh(String str, zzbhw zzbhwVar, zzbht zzbhtVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbhwVar);
        zzayv.zzg(parcelZza, zzbhtVar);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzk(zzbid zzbidVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbidVar);
        zzdb(10, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzl(zzbk zzbkVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbkVar);
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbt
    public final void zzo(zzbge zzbgeVar) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, zzbgeVar);
        zzdb(6, parcelZza);
    }
}
