package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqb extends zzayt implements IInterface {
    public zzbqb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final double zze() {
        Parcel parcelZzda = zzda(7, zza());
        double d = parcelZzda.readDouble();
        parcelZzda.recycle();
        return d;
    }

    public final Bundle zzf() {
        Parcel parcelZzda = zzda(15, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzed zzg() {
        Parcel parcelZzda = zzda(17, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    public final zzbgi zzh() {
        Parcel parcelZzda = zzda(19, zza());
        zzbgi zzbgiVarZzj = zzbgh.zzj(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgiVarZzj;
    }

    public final zzbgp zzi() {
        Parcel parcelZzda = zzda(5, zza());
        zzbgp zzbgpVarZzh = zzbgo.zzh(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgpVarZzh;
    }

    public final IObjectWrapper zzj() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(18, zza()));
    }

    public final IObjectWrapper zzk() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(20, zza()));
    }

    public final IObjectWrapper zzl() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(21, zza()));
    }

    public final String zzm() {
        Parcel parcelZzda = zzda(4, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    public final String zzn() {
        Parcel parcelZzda = zzda(6, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    public final String zzo() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    public final String zzp() {
        Parcel parcelZzda = zzda(9, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    public final String zzq() {
        Parcel parcelZzda = zzda(8, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    public final List zzr() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(11, parcelZza);
    }

    public final void zzt() {
        zzdb(10, zza());
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(12, parcelZza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        zzayv.zzg(parcelZza, iObjectWrapper3);
        zzdb(22, parcelZza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(16, parcelZza);
    }

    public final boolean zzx() {
        Parcel parcelZzda = zzda(14, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    public final boolean zzy() {
        Parcel parcelZzda = zzda(13, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
