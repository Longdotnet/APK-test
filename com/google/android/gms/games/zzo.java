package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends com.google.android.gms.games.internal.zzg implements PlayerRelationshipInfo {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;

    public zzo(int i, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public static boolean zze(PlayerRelationshipInfo playerRelationshipInfo, Object obj) {
        if (!(obj instanceof PlayerRelationshipInfo)) {
            return false;
        }
        if (obj == playerRelationshipInfo) {
            return true;
        }
        PlayerRelationshipInfo playerRelationshipInfo2 = (PlayerRelationshipInfo) obj;
        return playerRelationshipInfo2.getFriendStatus() == playerRelationshipInfo.getFriendStatus() && zzah.equal(playerRelationshipInfo2.zza(), playerRelationshipInfo.zza()) && zzah.equal(playerRelationshipInfo2.zzb(), playerRelationshipInfo.zzb()) && zzah.equal(playerRelationshipInfo2.zzc(), playerRelationshipInfo.zzc());
    }

    public static String zzf(PlayerRelationshipInfo playerRelationshipInfo) {
        zzz zzzVar = new zzz(playerRelationshipInfo);
        zzzVar.add(Integer.valueOf(playerRelationshipInfo.getFriendStatus()), "FriendStatus");
        if (playerRelationshipInfo.zza() != null) {
            zzzVar.add(playerRelationshipInfo.zza(), "Nickname");
        }
        if (playerRelationshipInfo.zzb() != null) {
            zzzVar.add(playerRelationshipInfo.zzb(), "InvitationNickname");
        }
        if (playerRelationshipInfo.zzc() != null) {
            zzzVar.add(playerRelationshipInfo.zzb(), "NicknameAbuseReportToken");
        }
        return zzzVar.toString();
    }

    public final boolean equals(Object obj) {
        return zze(this, obj);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(getFriendStatus()), zza(), zzb(), zzc()});
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzf(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel);
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzc() {
        return this.zzd;
    }

    public zzo(PlayerRelationshipInfo playerRelationshipInfo) {
        this.zza = playerRelationshipInfo.getFriendStatus();
        this.zzb = playerRelationshipInfo.zza();
        this.zzc = playerRelationshipInfo.zzb();
        this.zzd = playerRelationshipInfo.zzc();
    }
}
