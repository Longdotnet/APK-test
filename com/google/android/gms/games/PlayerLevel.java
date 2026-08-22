package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayerLevel extends com.google.android.gms.games.internal.zzg {
    public static final Parcelable.Creator<PlayerLevel> CREATOR = new zzm();
    public final int zza;
    public final long zzb;
    public final long zzc;

    public PlayerLevel(int i, long j, long j2) {
        zzah.checkState(j >= 0, "Min XP must be positive!");
        zzah.checkState(j2 > j, "Max XP must be more than min XP!");
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzah.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzah.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzah.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zza;
    }

    public long getMaxXp() {
        return this.zzc;
    }

    public long getMinXp() {
        return this.zzb;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int levelNumber = getLevelNumber();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(levelNumber);
        long minXp = getMinXp();
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(minXp);
        long maxXp = getMaxXp();
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(maxXp);
        CloseableKt.zzb(parcel, iZza);
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(Integer.valueOf(getLevelNumber()), yzwzcWHcnH.OkyxCy);
        zzzVar.add(Long.valueOf(getMinXp()), "MinXp");
        zzzVar.add(Long.valueOf(getMaxXp()), "MaxXp");
        return zzzVar.toString();
    }
}
