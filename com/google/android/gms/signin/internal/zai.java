package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new zzl(18);
    public final int zaa;
    public final zat zab;

    public zai(int i, zat zatVar) {
        this.zaa = i;
        this.zab = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeParcelable(parcel, 2, this.zab, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
