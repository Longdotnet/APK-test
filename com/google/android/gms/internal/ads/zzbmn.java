package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbmn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbmn> CREATOR = new zzbmo();
    public final String zza;
    public final Bundle zzb;

    public zzbmn(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, str, false);
        CloseableKt.writeBundle(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
