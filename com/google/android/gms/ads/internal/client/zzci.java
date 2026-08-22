package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbav;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwv;

/* JADX INFO: loaded from: classes.dex */
public final class zzci extends zzayt implements zzck {
    public zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbaw zzh(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(5, parcelZza);
        zzbaw zzbawVarZzb = zzbav.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbawVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbx zzj(String str) {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(7, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbwv zzm(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(3, parcelZza);
        zzbwv zzbwvVarZzt = zzbwu.zzt(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbwvVarZzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzo(zzbpq zzbpqVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbpqVar);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzs(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(4, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzt(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(6, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzu(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzda = zzda(2, parcelZza);
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
