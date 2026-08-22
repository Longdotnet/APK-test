package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class VideoConfiguration extends AbstractSafeParcelable {
    public static final int CAPTURE_MODE_FILE = 0;
    public static final int CAPTURE_MODE_STREAM = 1;
    public static final int CAPTURE_MODE_UNKNOWN = -1;
    public static final Parcelable.Creator<VideoConfiguration> CREATOR = new zzb();
    public static final int NUM_CAPTURE_MODE = 2;
    public static final int NUM_QUALITY_LEVEL = 4;
    public static final int QUALITY_LEVEL_FULLHD = 3;
    public static final int QUALITY_LEVEL_HD = 1;
    public static final int QUALITY_LEVEL_SD = 0;
    public static final int QUALITY_LEVEL_UNKNOWN = -1;
    public static final int QUALITY_LEVEL_XHD = 2;
    public final int zza;
    public final int zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;

    public static final class Builder {
        public int zza;
        public int zzb;
        public boolean zzc = true;
        public boolean zzd = true;

        public Builder(int i, int i2) {
            this.zza = i;
            this.zzb = i2;
        }

        public VideoConfiguration build() {
            return new VideoConfiguration(this.zza, this.zzb, true, this.zzc, this.zzd);
        }

        public Builder setCameraEnabled(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setCaptureMode(int i) {
            this.zzb = i;
            return this;
        }

        public Builder setMicEnabled(boolean z) {
            this.zzd = z;
            return this;
        }

        public Builder setQualityLevel(int i) {
            this.zza = i;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ValidCaptureModes {
    }

    public VideoConfiguration(int i, int i2, boolean z, boolean z2, boolean z3) {
        zzah.checkArgument(isValidQualityLevel(i, false));
        zzah.checkArgument(isValidCaptureMode(i2, false));
        this.zza = i;
        this.zzb = i2;
        this.zzc = z;
        this.zzd = z2;
        this.zze = z3;
    }

    public static boolean isValidCaptureMode(int i, boolean z) {
        if (i != -1) {
            z = true;
            if (i != 0 && i != 1) {
                return false;
            }
        }
        return z;
    }

    public static boolean isValidQualityLevel(int i, boolean z) {
        if (i != -1) {
            z = true;
            if (i != 0 && i != 1 && i != 2 && i != 3) {
                return false;
            }
        }
        return z;
    }

    public boolean getCameraEnabled() {
        return this.zzd;
    }

    public int getCaptureMode() {
        return this.zzb;
    }

    public boolean getMicEnabled() {
        return this.zze;
    }

    public int getQualityLevel() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int qualityLevel = getQualityLevel();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(qualityLevel);
        int captureMode = getCaptureMode();
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(captureMode);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        boolean cameraEnabled = getCameraEnabled();
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(cameraEnabled ? 1 : 0);
        boolean micEnabled = getMicEnabled();
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(micEnabled ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
