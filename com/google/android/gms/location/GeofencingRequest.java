package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new com.google.android.gms.drive.zza(25);
    public final ArrayList zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;

    public GeofencingRequest(ArrayList arrayList, int i, String str, String str2) {
        this.zza = arrayList;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeofencingRequest[geofences=");
        sb.append(this.zza);
        sb.append(", initialTrigger=");
        sb.append(this.zzb);
        sb.append(", tag=");
        sb.append(this.zzc);
        sb.append(", attributionTag=");
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, this.zzd, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, this.zza, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
