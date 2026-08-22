package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class StockProfileImageEntity extends com.google.android.gms.games.internal.zzg implements StockProfileImage {
    public static final Parcelable.Creator<StockProfileImageEntity> CREATOR = new zzj();
    public final String zza;
    public final Uri zzb;
    public final String zzc;

    public StockProfileImageEntity(String str, Uri uri, String str2) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof StockProfileImage)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        StockProfileImage stockProfileImage = (StockProfileImage) obj;
        return zzah.equal(this.zza, stockProfileImage.getImageUrl()) && zzah.equal(this.zzb, stockProfileImage.zza()) && zzah.equal(this.zzc, stockProfileImage.zzb());
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public String getImageUrl() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, "ImageId");
        zzzVar.add(this.zzb, "ImageUri");
        zzzVar.add(this.zzc, "A11yLabel");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getImageUrl(), false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.internal.player.StockProfileImage
    public final String zzb() {
        return this.zzc;
    }
}
