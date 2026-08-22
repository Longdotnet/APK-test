package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zza(15);
    public final int zaa;
    public final String zab;
    public final FastJsonResponse.Field zac;

    public zam(FastJsonResponse.Field field, String str) {
        this.zaa = 1;
        this.zab = str;
        this.zac = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeString(parcel, 2, this.zab, false);
        CloseableKt.writeParcelable(parcel, 3, this.zac, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public zam(FastJsonResponse.Field field, String str, int i) {
        this.zaa = i;
        this.zab = str;
        this.zac = field;
    }
}
