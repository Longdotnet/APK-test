package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class VideoCapabilities extends zzg {
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean[] zzd;
    public final boolean[] zze;

    public VideoCapabilities(boolean z, boolean z2, boolean z3, boolean[] zArr, boolean[] zArr2) {
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = zArr;
        this.zze = zArr2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return zzah.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && zzah.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && zzah.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && zzah.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && zzah.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public boolean[] getSupportedCaptureModes() {
        return this.zzd;
    }

    public boolean[] getSupportedQualityLevels() {
        return this.zze;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported())});
    }

    public boolean isCameraSupported() {
        return this.zza;
    }

    public boolean isFullySupported(int i, int i2) {
        return this.zza && this.zzb && this.zzc && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public boolean isMicSupported() {
        return this.zzb;
    }

    public boolean isWriteStorageSupported() {
        return this.zzc;
    }

    public boolean supportsCaptureMode(int i) {
        zzah.checkState$1(VideoConfiguration.isValidCaptureMode(i, false));
        return this.zzd[i];
    }

    public boolean supportsQualityLevel(int i) {
        zzah.checkState$1(VideoConfiguration.isValidQualityLevel(i, false));
        return this.zze[i];
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(getSupportedCaptureModes(), "SupportedCaptureModes");
        zzzVar.add(getSupportedQualityLevels(), "SupportedQualityLevels");
        zzzVar.add(Boolean.valueOf(isCameraSupported()), "CameraSupported");
        zzzVar.add(Boolean.valueOf(isMicSupported()), "MicSupported");
        zzzVar.add(Boolean.valueOf(isWriteStorageSupported()), "StorageWriteSupported");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        boolean zIsCameraSupported = isCameraSupported();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(zIsCameraSupported ? 1 : 0);
        boolean zIsMicSupported = isMicSupported();
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(zIsMicSupported ? 1 : 0);
        boolean zIsWriteStorageSupported = isWriteStorageSupported();
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(zIsWriteStorageSupported ? 1 : 0);
        CloseableKt.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        CloseableKt.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        CloseableKt.zzb(parcel, iZza);
    }
}
