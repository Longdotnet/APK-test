package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zzl(19);
    public final int zaa;
    public final ConnectionResult zab;
    public final zav zac;

    public zak(int i, ConnectionResult connectionResult, zav zavVar) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zavVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeParcelable(parcel, 2, this.zab, i, false);
        CloseableKt.writeParcelable(parcel, 3, this.zac, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
