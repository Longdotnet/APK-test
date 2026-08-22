package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgn extends zzayt implements zzbgp {
    public zzbgn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final double zzb() {
        Parcel parcelZzda = zzda(3, zza());
        double d = parcelZzda.readDouble();
        parcelZzda.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final int zzc() {
        Parcel parcelZzda = zzda(5, zza());
        int i = parcelZzda.readInt();
        parcelZzda.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final int zzd() {
        Parcel parcelZzda = zzda(4, zza());
        int i = parcelZzda.readInt();
        parcelZzda.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final Uri zze() {
        Parcel parcelZzda = zzda(2, zza());
        Uri uri = (Uri) zzayv.zza(parcelZzda, Uri.CREATOR);
        parcelZzda.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final IObjectWrapper zzf() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(zzda(1, zza()));
    }

    @Override // com.google.android.gms.internal.ads.zzbgp
    public final Map zzg() {
        Parcel parcelZzda = zzda(6, zza());
        HashMap mapZzc = zzayv.zzc(parcelZzda);
        parcelZzda.recycle();
        return mapZzc;
    }
}
