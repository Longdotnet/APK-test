package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzayw extends zzayt implements zzayy {
    public zzayw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zze(IObjectWrapper iObjectWrapper, String str) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString("GMA_SDK");
        zzdb(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzf() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzh(int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzi(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(0);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzayy
    public final void zzj(byte[] bArr) {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzdb(5, parcelZza);
    }
}
