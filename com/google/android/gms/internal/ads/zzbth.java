package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbth extends zzayt implements zzbtj {
    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zze(Intent intent) {
        Parcel parcelZza = zza();
        zzayv.zze(parcelZza, intent);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzh() {
        zzdb(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtj
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzaVar);
        zzdb(6, parcelZza);
    }

    public zzbth(IBinder iBinder) {
        super(iBinder, bUqMCsuPSX.uIBGBFdAGQR);
    }
}
