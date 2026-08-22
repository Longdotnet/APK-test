package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public final List zzb;
    public static final List zza = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new com.google.android.gms.drive.zza(28);

    public LocationResult(List list) {
        this.zzb = list;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        int size = locationResult.zzb.size();
        List list = this.zzb;
        if (size != list.size()) {
            return false;
        }
        Iterator it = locationResult.zzb.iterator();
        Iterator it2 = list.iterator();
        while (it.hasNext()) {
            if (((Location) it2.next()).getTime() != ((Location) it.next()).getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        Iterator it = this.zzb.iterator();
        int i = 17;
        while (it.hasNext()) {
            long time = ((Location) it.next()).getTime();
            i = (i * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        return Fragment$$ExternalSyntheticOutline0.m(new StringBuilder(strValueOf.length() + 27), "LocationResult[locations: ", strValueOf, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
