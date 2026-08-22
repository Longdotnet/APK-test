package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbqd extends zzayt implements zzbqf {
    public zzbqd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzA() {
        Parcel parcelZzda = zzda(18, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final boolean zzB() {
        Parcel parcelZzda = zzda(17, zza());
        boolean zZzh = zzayv.zzh(parcelZzda);
        parcelZzda.recycle();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final double zze() {
        Parcel parcelZzda = zzda(8, zza());
        double d = parcelZzda.readDouble();
        parcelZzda.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzf() {
        Parcel parcelZzda = zzda(23, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzg() {
        Parcel parcelZzda = zzda(25, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final float zzh() {
        Parcel parcelZzda = zzda(24, zza());
        float f = parcelZzda.readFloat();
        parcelZzda.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final Bundle zzi() {
        Parcel parcelZzda = zzda(16, zza());
        Bundle bundle = (Bundle) zzayv.zza(parcelZzda, Bundle.CREATOR);
        parcelZzda.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final com.google.android.gms.ads.internal.client.zzed zzj() {
        Parcel parcelZzda = zzda(11, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgi zzk() {
        Parcel parcelZzda = zzda(12, zza());
        zzbgi zzbgiVarZzj = zzbgh.zzj(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgiVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final zzbgp zzl() {
        Parcel parcelZzda = zzda(5, zza());
        zzbgp zzbgpVarZzh = zzbgo.zzh(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgpVarZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzm() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(13, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzn() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(14, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final IObjectWrapper zzo() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(15, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzp() {
        Parcel parcelZzda = zzda(7, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzq() {
        Parcel parcelZzda = zzda(4, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzr() {
        Parcel parcelZzda = zzda(6, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzs() {
        Parcel parcelZzda = zzda(2, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzt() {
        Parcel parcelZzda = zzda(10, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final String zzu() {
        Parcel parcelZzda = zzda(9, zza());
        String string = parcelZzda.readString();
        parcelZzda.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final List zzv() {
        Parcel parcelZzda = zzda(3, zza());
        ArrayList arrayListZzb = zzayv.zzb(parcelZzda);
        parcelZzda.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzx() {
        zzdb(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        zzayv.zzg(parcelZza, iObjectWrapper3);
        zzdb(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzz(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzdb(22, parcelZza);
    }
}
