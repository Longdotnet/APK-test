package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new com.google.android.gms.drive.zza(10);
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int[] zzd;
    public final int zze;
    public final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.writeIntArray(parcel, 4, this.zzd, false);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        CloseableKt.writeIntArray(parcel, 6, this.zzf, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
