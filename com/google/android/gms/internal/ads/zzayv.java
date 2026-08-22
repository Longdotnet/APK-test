package com.google.android.gms.internal.ads;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzayv {
    public static final /* synthetic */ int zza = 0;
    private static final ClassLoader zzb = zzayv.class.getClassLoader();

    private zzayv() {
    }

    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static ArrayList zzb(Parcel parcel) {
        return parcel.readArrayList(zzb);
    }

    public static HashMap zzc(Parcel parcel) {
        return parcel.readHashMap(zzb);
    }

    public static void zzd(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail > 0) {
            throw new BadParcelableException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(iDataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }

    public static void zze(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void zzf(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 1);
        }
    }

    public static void zzg(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static boolean zzh(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
