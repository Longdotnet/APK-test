package com.google.android.gms.common;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.drive.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zza(23);
    public final String zza;
    public final zzk zzb;
    public final boolean zzc;
    public final boolean zzd;

    public zzs(String str, zzk zzkVar, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzkVar;
        this.zzc = z;
        this.zzd = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        zzk zzkVar = this.zzb;
        if (zzkVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzkVar = null;
        }
        CloseableKt.writeIBinder(parcel, 2, zzkVar);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzs(String str, IBinder iBinder, boolean z, boolean z2) {
        zzaa zzyVar;
        this.zza = str;
        zzk zzkVar = null;
        if (iBinder != null) {
            try {
                int i = zzj.$r8$clinit;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
                if (iInterfaceQueryLocalInterface instanceof zzaa) {
                    zzyVar = (zzaa) iInterfaceQueryLocalInterface;
                } else {
                    zzyVar = new zzy(iBinder, "com.google.android.gms.common.internal.ICertData");
                }
                IObjectWrapper iObjectWrapperZzd = zzyVar.zzd();
                byte[] bArr = iObjectWrapperZzd == null ? null : (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd);
                if (bArr != null) {
                    zzkVar = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.zzb = zzkVar;
        this.zzc = z;
        this.zzd = z2;
    }
}
