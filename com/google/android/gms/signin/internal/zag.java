package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzl;
import java.util.ArrayList;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zzl(17);
    public final ArrayList zaa;
    public final String zab;

    public zag(ArrayList arrayList, String str) {
        this.zaa = arrayList;
        this.zab = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zab != null ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeStringList(parcel, 1, this.zaa);
        CloseableKt.writeString(parcel, 2, this.zab, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
