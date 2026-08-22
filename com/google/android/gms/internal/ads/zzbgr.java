package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgr extends zzayt implements zzbgt {
    public zzbgr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final IObjectWrapper zzb(String str) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(2, parcelZza));
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzc() {
        zzdb(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzd(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdA(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdB(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdx(String str, IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdy(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zzdz(zzbgm zzbgmVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, zzbgmVar);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgt
    public final void zze(IObjectWrapper iObjectWrapper, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i);
        zzdb(5, parcelZza);
    }
}
