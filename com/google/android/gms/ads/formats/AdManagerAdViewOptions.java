package com.google.android.gms.ads.formats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.appset.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzb(8);
    public final boolean zza;

    public AdManagerAdViewOptions(boolean z) {
        this.zza = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
