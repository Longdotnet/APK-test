package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzl(1);
    public final ArrayList zza;
    public final boolean zzb;
    public final boolean zzc;
    public final zzbj zzd;

    public LocationSettingsRequest(ArrayList arrayList, boolean z, boolean z2, zzbj zzbjVar) {
        this.zza = arrayList;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = zzbjVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeTypedList(parcel, 1, Collections.unmodifiableList(this.zza), false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 5, this.zzd, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
