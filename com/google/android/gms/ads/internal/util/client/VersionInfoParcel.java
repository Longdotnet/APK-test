package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.games.snapshot.Xa.JrbhsraGtto;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class VersionInfoParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new com.google.android.gms.appset.zzb(26);
    public final String afmaVersion;
    public final int buddyApkVersion;
    public final int clientJarVersion;
    public final boolean isClientJar;
    public final boolean isLiteSdk;

    public VersionInfoParcel(String str, int i, int i2, boolean z, boolean z2) {
        this.afmaVersion = str;
        this.buddyApkVersion = i;
        this.clientJarVersion = i2;
        this.isClientJar = z;
        this.isLiteSdk = z2;
    }

    public static VersionInfoParcel forPackage() {
        return new VersionInfoParcel(12451000, 12451000, true, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.afmaVersion, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.buddyApkVersion);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.clientJarVersion);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.isClientJar ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.isLiteSdk ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VersionInfoParcel(int i, int i2, boolean z, boolean z2) {
        String str = z ? "0" : JrbhsraGtto.vGnOfcc;
        StringBuilder sbM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m("afma-sdk-a-v", i, ".", i2, ".");
        sbM.append(str);
        this(sbM.toString(), i, i2, z, z2);
    }
}
