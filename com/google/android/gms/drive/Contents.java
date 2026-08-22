package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class Contents extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Contents> CREATOR = new zza(0);
    public final ParcelFileDescriptor zza;
    public final int zzb;
    public final int zzc;
    public final DriveId zzd;
    public final boolean zze;
    public final String zzf;

    public Contents(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, DriveId driveId, boolean z, String str) {
        this.zza = parcelFileDescriptor;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = driveId;
        this.zze = z;
        this.zzf = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, this.zza, i, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.writeParcelable(parcel, 5, this.zzd, i, false);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zze ? 1 : 0);
        CloseableKt.writeString(parcel, 8, this.zzf, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
