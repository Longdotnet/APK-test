package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzfqj extends zzayt implements zzfql {
    public zzfqj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zze(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeString(null);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zzf() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zzg(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zzh(int[] iArr) {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zzi(int i) {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfql
    public final void zzj(byte[] bArr) {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzdb(5, parcelZza);
    }
}
