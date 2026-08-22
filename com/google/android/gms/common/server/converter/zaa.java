package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zza(12);
    public final int zaa;
    public final StringToIntConverter zab;

    public zaa(int i, StringToIntConverter stringToIntConverter) {
        this.zaa = i;
        this.zab = stringToIntConverter;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeParcelable(parcel, 2, this.zab, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.zaa = 1;
        this.zab = stringToIntConverter;
    }
}
