package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new zza(28);
    public final int zza;
    public final ArrayList zzb;

    public AccountChangeEventsResponse(ArrayList arrayList, int i) {
        this.zza = i;
        zzah.checkNotNull(arrayList);
        this.zzb = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.writeTypedList(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
