package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zza extends com.google.android.gms.games.internal.zzg implements CurrentPlayerInfo {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    public final int zza;

    public zza(int i) {
        this.zza = i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof CurrentPlayerInfo) {
            return obj == this || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == getFriendsListVisibilityStatus();
        }
        return false;
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getFriendsListVisibilityStatus())});
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(Integer.valueOf(getFriendsListVisibilityStatus()), "FriendsListVisibilityStatus");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int friendsListVisibilityStatus = getFriendsListVisibilityStatus();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(friendsListVisibilityStatus);
        CloseableKt.zzb(parcel, iZza);
    }

    public zza(CurrentPlayerInfo currentPlayerInfo) {
        this.zza = currentPlayerInfo.getFriendsListVisibilityStatus();
    }
}
