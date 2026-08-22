package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzl;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class HarmfulAppsData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<HarmfulAppsData> CREATOR = new zzl(11);
    public final int apkCategory;
    public final String apkPackageName;
    public final byte[] apkSha256;

    public HarmfulAppsData(String str, byte[] bArr, int i) {
        this.apkPackageName = str;
        this.apkSha256 = bArr;
        this.apkCategory = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.apkPackageName, false);
        CloseableKt.writeByteArray(parcel, 3, this.apkSha256, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.apkCategory);
        CloseableKt.zzb(parcel, iZza);
    }
}
