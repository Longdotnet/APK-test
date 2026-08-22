package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbuy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbuy> CREATOR = new zzbuz();
    public final boolean zza;
    public final List zzb;

    public zzbuy(boolean z, List list) {
        this.zza = z;
        this.zzb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeStringList(parcel, 3, this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzbuy() {
        this(false, Collections.emptyList());
    }
}
