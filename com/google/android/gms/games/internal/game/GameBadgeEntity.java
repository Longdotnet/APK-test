package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new zzb();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final Uri zzd;

    public GameBadgeEntity(int i, String str, String str2, Uri uri) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = uri;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zzaVar = (zza) obj;
        return zzah.equal(Integer.valueOf(zzaVar.zza()), this.zzb) && zzah.equal(zzaVar.zzb(), this.zzd);
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzb, this.zzc, this.zzd});
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(Integer.valueOf(this.zza), "Type");
        zzzVar.add(this.zzb, "Title");
        zzzVar.add(this.zzc, "Description");
        zzzVar.add(this.zzd, "IconImageUri");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean zShouldDowngrade = shouldDowngrade();
        Uri uri = this.zzd;
        String str = this.zzc;
        String str2 = this.zzb;
        int i2 = this.zza;
        if (zShouldDowngrade) {
            parcel.writeInt(i2);
            parcel.writeString(str2);
            parcel.writeString(str);
            parcel.writeString(uri == null ? null : uri.toString());
            return;
        }
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 2, str2, false);
        CloseableKt.writeString(parcel, 3, str, false);
        CloseableKt.writeParcelable(parcel, 4, uri, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final String zzb() {
        return this.zzc;
    }
}
