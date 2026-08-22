package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzfu extends zzayu implements zzdt {
    public final OnPaidEventListener zza;

    public zzfu(OnPaidEventListener onPaidEventListener) {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        this.zza = onPaidEventListener;
    }

    public static zzdt zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return iInterfaceQueryLocalInterface instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface : new zzdr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzt zztVar = (zzt) zzayv.zza(parcel, zzt.CREATOR);
            zzayv.zzd(parcel);
            zze(zztVar);
            parcel2.writeNoException();
        } else {
            if (i != 2) {
                return false;
            }
            boolean zZzf = zzf();
            parcel2.writeNoException();
            int i3 = zzayv.zza;
            parcel2.writeInt(zZzf ? 1 : 0);
        }
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final void zze(zzt zztVar) {
        OnPaidEventListener onPaidEventListener = this.zza;
        if (onPaidEventListener != null) {
            onPaidEventListener.onPaidEvent(new AdValue(zztVar.zzb, zztVar.zzd, zztVar.zzc));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdt
    public final boolean zzf() {
        return this.zza == null;
    }
}
