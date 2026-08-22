package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzl(15);
    public String zzm;
    public DataHolder zzn;
    public ParcelFileDescriptor zzo;
    public long zzp;
    public byte[] zzq;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zzm, false);
        CloseableKt.writeParcelable(parcel, 3, this.zzn, i, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzo, i, false);
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(this.zzp);
        CloseableKt.writeByteArray(parcel, 6, this.zzq, false);
        CloseableKt.zzb(parcel, iZza);
        this.zzo = null;
    }
}
