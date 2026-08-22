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
public final class zzbqc extends zzayt implements IInterface {
    public zzbqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final Bundle zze() {
        Parcel parcelZzda = zzda(13, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzed zzf() {
        Parcel parcelZzda = zzda(16, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    public final zzbgi zzg() {
        Parcel parcelZzda = zzda(19, zza());
        zzbgi zzbgiVarZzj = zzbgh.zzj(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgiVarZzj;
    }

    public final zzbgp zzh() {
        Parcel parcelZzda = zzda(5, zza());
        zzbgp zzbgpVarZzh = zzbgo.zzh(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgpVarZzh;
    }

    public final IObjectWrapper zzi() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(15, zza()));
    }

    public final IObjectWrapper zzj() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(20, zza()));
    }

    public final IObjectWrapper zzk() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(21, zza()));
    }

    public final String zzl() {
        Parcel parcelZzda = zzda(7, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
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

    public final List zzp() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(9, parcelZza);
    }

    public final void zzr() {
        zzdb(8, zza());
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(10, parcelZza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        zzayv.zzg(parcelZza, iObjectWrapper3);
        zzdb(22, parcelZza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(14, parcelZza);
    }

    public final boolean zzv() {
        Parcel parcelZzda = zzda(12, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    public final boolean zzw() {
        Parcel parcelZzda = zzda(11, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }
}
