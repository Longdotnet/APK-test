package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzau extends AbstractSafeParcelable implements Iterable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzr(2);
    public final Bundle zza;

    public zzau(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzat(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 2, zzc(), false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final Bundle zzc() {
        return new Bundle(this.zza);
    }

    public final Double zzd() {
        return Double.valueOf(this.zza.getDouble(FirebaseAnalytics.Param.VALUE));
    }

    public final Object zzf(String str) {
        return this.zza.get(str);
    }

    public final String zzg$1() {
        return this.zza.getString(FirebaseAnalytics.Param.CURRENCY);
    }
}
