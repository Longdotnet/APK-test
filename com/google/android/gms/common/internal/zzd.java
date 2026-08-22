package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzd extends com.google.android.gms.internal.common.zzb {
    public BaseGmsClient zza;
    public final int zzb;

    public zzd(BaseGmsClient baseGmsClient, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.zza = baseGmsClient;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3 = this.zzb;
        if (i == 1) {
            int i4 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i4, strongBinder, bundle, i3);
            this.zza = null;
        } else if (i == 2) {
            parcel.readInt();
            zzc.zzb(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzk zzkVar = (zzk) zzc.zza(parcel, zzk.CREATOR);
            zzc.zzb(parcel);
            BaseGmsClient baseGmsClient = this.zza;
            zzah.checkNotNull(baseGmsClient, TSDAbK.diqfqUfkDhU);
            zzah.checkNotNull(zzkVar);
            BaseGmsClient.zzj(baseGmsClient, zzkVar);
            Bundle bundle2 = zzkVar.zza;
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i5, strongBinder2, bundle2, i3);
            this.zza = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
