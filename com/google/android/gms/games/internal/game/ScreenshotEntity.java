package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenshotEntity extends zzg implements Parcelable {
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzd();
    public final Uri zza;
    public final int zzb;
    public final int zzc;

    public ScreenshotEntity(Uri uri, int i, int i2) {
        this.zza = uri;
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScreenshotEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
        return zzah.equal(screenshotEntity.zza, this.zza) && zzah.equal(Integer.valueOf(screenshotEntity.zzb), Integer.valueOf(this.zzb)) && zzah.equal(Integer.valueOf(screenshotEntity.zzc), Integer.valueOf(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc)});
    }

    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, "Uri");
        zzzVar.add(Integer.valueOf(this.zzb), "Width");
        zzzVar.add(Integer.valueOf(this.zzc), oKjScaD.YfLskABzhXfcsQ);
        return zzzVar.toString();
    }
}
