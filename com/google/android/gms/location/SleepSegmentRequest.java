package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SleepSegmentRequest> CREATOR = new zzl(6);
    public final ArrayList zza;
    public final int zzb;

    public SleepSegmentRequest(ArrayList arrayList, int i) {
        this.zza = arrayList;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SleepSegmentRequest)) {
            return false;
        }
        SleepSegmentRequest sleepSegmentRequest = (SleepSegmentRequest) obj;
        return zzah.equal(this.zza, sleepSegmentRequest.zza) && this.zzb == sleepSegmentRequest.zzb;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzah.checkNotNull(parcel);
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, this.zza, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }
}
