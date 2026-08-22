package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zza(14);
    public final int zaa;
    public final String zab;
    public final int zac;

    public zac(int i, String str, int i2) {
        this.zaa = i;
        this.zab = str;
        this.zac = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeString(parcel, 2, this.zab, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zac);
        CloseableKt.zzb(parcel, iZza);
    }

    public zac(String str, int i) {
        this.zaa = 1;
        this.zab = str;
        this.zac = i;
    }
}
