package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzl(8);
    public static final zzn IS_SAME_TRANSITION = new zzn(0);
    public final List zza;
    public final String zzb;
    public final List zzc;
    public final String zzd;

    public ActivityTransitionRequest(ArrayList arrayList, String str, ArrayList arrayList2, String str2) {
        zzah.checkNotNull(arrayList, "transitions can't be null");
        zzah.checkArgument(arrayList.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(IS_SAME_TRANSITION);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ActivityTransition activityTransition = (ActivityTransition) it.next();
            zzah.checkArgument(treeSet.add(activityTransition), "Found duplicated transition: " + activityTransition + ".");
        }
        this.zza = Collections.unmodifiableList(arrayList);
        this.zzb = str;
        this.zzc = arrayList2 == null ? Collections.emptyList() : Collections.unmodifiableList(arrayList2);
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ActivityTransitionRequest.class == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (zzah.equal(this.zza, activityTransitionRequest.zza) && zzah.equal(this.zzb, activityTransitionRequest.zzb) && zzah.equal(this.zzd, activityTransitionRequest.zzd) && zzah.equal(this.zzc, activityTransitionRequest.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List list = this.zzc;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.zzd;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        String strValueOf2 = String.valueOf(this.zzc);
        int length = strValueOf.length();
        String str = this.zzb;
        int length2 = String.valueOf(str).length();
        int length3 = strValueOf2.length();
        String str2 = this.zzd;
        StringBuilder sb = new StringBuilder(length + 79 + length2 + length3 + String.valueOf(str2).length());
        sb.append("ActivityTransitionRequest [mTransitions=");
        sb.append(strValueOf);
        sb.append(", mTag='");
        sb.append(str);
        sb.append("', mClients=");
        sb.append(strValueOf2);
        sb.append(", mAttributionTag=");
        sb.append(str2);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzah.checkNotNull(parcel);
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeTypedList(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
