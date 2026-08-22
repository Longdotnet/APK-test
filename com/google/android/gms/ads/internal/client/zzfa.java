package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;

/* JADX INFO: loaded from: classes.dex */
public final class zzfa extends zzayu implements zzdj {
    public final String zza;
    public final String zzb;

    public zzfa(String str, String str2) {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        this.zza = str;
        this.zzb = str2;
    }

    public static zzdj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdh(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel2.writeNoException();
            parcel2.writeString(this.zza);
        } else {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeString(this.zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zze() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final String zzf() {
        return this.zzb;
    }
}
