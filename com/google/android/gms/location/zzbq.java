package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.location.zzbs;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzl(5);
    public final zzbs zza;
    public final PendingIntent zzb;
    public final String zzc;

    public zzbq(List list, PendingIntent pendingIntent, String str) {
        this.zza = list == null ? zzbs.zzi() : zzbs.zzj(list);
        this.zzb = pendingIntent;
        this.zzc = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeStringList(parcel, 1, this.zza);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
