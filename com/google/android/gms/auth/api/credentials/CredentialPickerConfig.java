package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zza(7);
    public final int zba;
    public final boolean zbb;
    public final boolean zbc;
    public final int zbd;

    public CredentialPickerConfig(int i, int i2, boolean z, boolean z2, boolean z3) {
        this.zba = i;
        this.zbb = z;
        this.zbc = z2;
        if (i < 2) {
            this.zbd = true == z3 ? 3 : 1;
        } else {
            this.zbd = i2;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zbb ? 1 : 0);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zbc ? 1 : 0);
        int i2 = this.zbd;
        int i3 = i2 != 3 ? 0 : 1;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(i3);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(i2);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zba);
        CloseableKt.zzb(parcel, iZza);
    }
}
