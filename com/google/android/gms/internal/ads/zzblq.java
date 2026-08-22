package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzblq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzblq> CREATOR = new zzblr();
    public final String zza;
    public final String[] zzb;
    public final String[] zzc;

    public zzblq(String str, String[] strArr, String[] strArr2) {
        this.zza = str;
        this.zzb = strArr;
        this.zzc = strArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.writeStringArray(parcel, 2, this.zzb, false);
        CloseableKt.writeStringArray(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
