package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class PlayerStatsEntity extends zzg implements PlayerStats {
    public static final Parcelable.Creator<PlayerStatsEntity> CREATOR = new zza();
    public final float zza;
    public final float zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final float zzf;
    public final float zzg;
    public final Bundle zzh;
    public final float zzi;
    public final float zzj;
    public final float zzk;

    public PlayerStatsEntity(float f, float f2, int i, int i2, int i3, float f3, float f4, Bundle bundle, float f5, float f6, float f7) {
        this.zza = f;
        this.zzb = f2;
        this.zzc = i;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = f3;
        this.zzg = f4;
        this.zzh = bundle;
        this.zzi = f5;
        this.zzj = f6;
        this.zzk = f7;
    }

    public static int zzb(PlayerStats playerStats) {
        return Arrays.hashCode(new Object[]{Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()), Float.valueOf(playerStats.getSpendProbability()), Float.valueOf(playerStats.getHighSpenderProbability()), Float.valueOf(playerStats.getTotalSpendNext28Days())});
    }

    public static boolean zzc(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzah.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && zzah.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && zzah.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && zzah.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && zzah.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && zzah.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && zzah.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile())) && zzah.equal(Float.valueOf(playerStats2.getSpendProbability()), Float.valueOf(playerStats.getSpendProbability())) && zzah.equal(Float.valueOf(playerStats2.getHighSpenderProbability()), Float.valueOf(playerStats.getHighSpenderProbability())) && zzah.equal(Float.valueOf(playerStats2.getTotalSpendNext28Days()), Float.valueOf(playerStats.getTotalSpendNext28Days()));
    }

    public final boolean equals(Object obj) {
        return zzc(this, obj);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getAverageSessionLength() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getChurnProbability() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getDaysSinceLastPlayed() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getHighSpenderProbability() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfPurchases() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfSessions() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSessionPercentile() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendPercentile() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendProbability() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getTotalSpendNext28Days() {
        return this.zzk;
    }

    public final int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzd(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zza() {
        return this.zzh;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.zza = playerStats.getAverageSessionLength();
        this.zzb = playerStats.getChurnProbability();
        this.zzc = playerStats.getDaysSinceLastPlayed();
        this.zzd = playerStats.getNumberOfPurchases();
        this.zze = playerStats.getNumberOfSessions();
        this.zzf = playerStats.getSessionPercentile();
        this.zzg = playerStats.getSpendPercentile();
        this.zzi = playerStats.getSpendProbability();
        this.zzj = playerStats.getHighSpenderProbability();
        this.zzk = playerStats.getTotalSpendNext28Days();
        this.zzh = playerStats.zza();
    }

    public static String zzd(PlayerStats playerStats) {
        zzz zzzVar = new zzz(playerStats);
        zzzVar.add(Float.valueOf(playerStats.getAverageSessionLength()), "AverageSessionLength");
        zzzVar.add(Float.valueOf(playerStats.getChurnProbability()), "ChurnProbability");
        zzzVar.add(Integer.valueOf(playerStats.getDaysSinceLastPlayed()), "DaysSinceLastPlayed");
        zzzVar.add(Integer.valueOf(playerStats.getNumberOfPurchases()), dLDI.osyNGpGVHPL);
        zzzVar.add(Integer.valueOf(playerStats.getNumberOfSessions()), eoBKjVuj.YtqwJIXYVUyUJc);
        zzzVar.add(Float.valueOf(playerStats.getSessionPercentile()), "SessionPercentile");
        zzzVar.add(Float.valueOf(playerStats.getSpendPercentile()), "SpendPercentile");
        zzzVar.add(Float.valueOf(playerStats.getSpendProbability()), "SpendProbability");
        zzzVar.add(Float.valueOf(playerStats.getHighSpenderProbability()), "HighSpenderProbability");
        zzzVar.add(Float.valueOf(playerStats.getTotalSpendNext28Days()), "TotalSpendNext28Days");
        return zzzVar.toString();
    }
}
