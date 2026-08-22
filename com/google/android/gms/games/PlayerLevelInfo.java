package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerLevelInfo extends com.google.android.gms.games.internal.zzg {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzn();
    public final long zza;
    public final long zzb;
    public final PlayerLevel zzc;
    public final PlayerLevel zzd;

    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        zzah.checkState$1(j != -1);
        zzah.checkNotNull(playerLevel);
        zzah.checkNotNull(playerLevel2);
        this.zza = j;
        this.zzb = j2;
        this.zzc = playerLevel;
        this.zzd = playerLevel2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzah.equal(Long.valueOf(this.zza), Long.valueOf(playerLevelInfo.zza)) && zzah.equal(Long.valueOf(this.zzb), Long.valueOf(playerLevelInfo.zzb)) && zzah.equal(this.zzc, playerLevelInfo.zzc) && zzah.equal(this.zzd, playerLevelInfo.zzd);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzc;
    }

    public long getCurrentXpTotal() {
        return this.zza;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzb;
    }

    public PlayerLevel getNextLevel() {
        return this.zzd;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public boolean isMaxLevel() {
        return this.zzc.equals(this.zzd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        long currentXpTotal = getCurrentXpTotal();
        CloseableKt.zzc(parcel, 1, 8);
        parcel.writeLong(currentXpTotal);
        long lastLevelUpTimestamp = getLastLevelUpTimestamp();
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(lastLevelUpTimestamp);
        CloseableKt.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        CloseableKt.writeParcelable(parcel, 4, getNextLevel(), i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
