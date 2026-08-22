package com.google.android.gms.internal.p001authapiphone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: loaded from: classes.dex */
public final class zzh extends zza implements IInterface {
    public zzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zzc(zze zzeVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzeVar);
        zzb(4, parcelZza);
    }

    public final void zzd(String str, zzg zzgVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc.zzb(parcelZza, zzgVar);
        zzb(5, parcelZza);
    }

    public final void zze(IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iStatusCallback);
        zzb(3, parcelZza);
    }

    public final void zzf(IStatusCallback iStatusCallback) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, iStatusCallback);
        zzb(6, parcelZza);
    }

    public final void zzg(zzj zzjVar) {
        Parcel parcelZza = zza();
        zzc.zzb(parcelZza, zzjVar);
        zzb(1, parcelZza);
    }

    public final void zzh(String str, zzj zzjVar) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzc.zzb(parcelZza, zzjVar);
        zzb(2, parcelZza);
    }
}
