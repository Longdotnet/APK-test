package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgk extends zzayt implements zzbgm {
    public zzbgk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zze() {
        Parcel parcelZzda = zzda(2, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzf() {
        Parcel parcelZzda = zzda(6, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final float zzg() {
        Parcel parcelZzda = zzda(5, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        Parcel parcelZzda = zzda(7, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final IObjectWrapper zzi() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(4, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzk() {
        Parcel parcelZzda = zzda(10, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final boolean zzl() {
        Parcel parcelZzda = zzda(8, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbgm
    public final void zzm(zzbhx zzbhxVar) {
        throw null;
    }
}
