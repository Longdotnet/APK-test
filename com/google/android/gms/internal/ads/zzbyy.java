package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyy extends zzayt implements zzbza {
    public zzbyy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, iObjectWrapper3);
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(11, parcelZza));
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzf(IObjectWrapper iObjectWrapper, zzbze zzbzeVar, zzbyx zzbyxVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzbzeVar);
        zzayv.zzg(parcelZza, zzbyxVar);
        zzdb(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzg(zzbui zzbuiVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzk(IObjectWrapper iObjectWrapper) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        throw null;
    }
}
