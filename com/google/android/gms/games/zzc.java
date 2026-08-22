package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends zzg implements CurrentPlayerInfo {
    public final com.google.android.gms.games.internal.player.zzd zza;

    public zzc(DataHolder dataHolder, int i, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        Parcelable.Creator<zza> creator = zza.CREATOR;
        if (obj instanceof CurrentPlayerInfo) {
            return obj == this || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == getFriendsListVisibilityStatus();
        }
        return false;
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final /* synthetic */ Object freeze() {
        return new zza(this);
    }

    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return zzu(this.zza.zzL, 0);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        Parcelable.Creator<zza> creator = zza.CREATOR;
        return Arrays.hashCode(new Object[]{Integer.valueOf(getFriendsListVisibilityStatus())});
    }

    public final String toString() {
        Parcelable.Creator<zza> creator = zza.CREATOR;
        zzz zzzVar = new zzz(this);
        zzzVar.add(Integer.valueOf(getFriendsListVisibilityStatus()), "FriendsListVisibilityStatus");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = new zza(this);
        int iZza = CloseableKt.zza(parcel, 20293);
        int friendsListVisibilityStatus = zzaVar.getFriendsListVisibilityStatus();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(friendsListVisibilityStatus);
        CloseableKt.zzb(parcel, iZza);
    }

    public final boolean zza() {
        String str = this.zza.zzL;
        return hasColumn(str) && !hasNull(str);
    }
}
