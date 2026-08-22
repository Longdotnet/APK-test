package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new com.google.android.gms.drive.zza(3);
    public final int zaa;
    public List zab;

    public TelemetryData(int i, List list) {
        this.zaa = i;
        this.zab = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeTypedList(parcel, 2, this.zab, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
