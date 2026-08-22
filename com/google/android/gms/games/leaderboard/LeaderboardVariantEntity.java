package com.google.android.gms.games.leaderboard;

import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    public final int zza;
    public final int zzb;
    public final boolean zzc;
    public final long zzd;
    public final String zze;
    public final long zzf;
    public final String zzg;
    public final String zzh;
    public final long zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zza = leaderboardVariant.getTimeSpan();
        this.zzb = leaderboardVariant.getCollection();
        this.zzc = leaderboardVariant.hasPlayerInfo();
        this.zzd = leaderboardVariant.getRawPlayerScore();
        this.zze = leaderboardVariant.getDisplayPlayerScore();
        this.zzf = leaderboardVariant.getPlayerRank();
        this.zzg = leaderboardVariant.getDisplayPlayerRank();
        this.zzh = leaderboardVariant.getPlayerScoreTag();
        this.zzi = leaderboardVariant.getNumScores();
        this.zzj = leaderboardVariant.zza();
        this.zzk = leaderboardVariant.zzb();
        this.zzl = leaderboardVariant.zzc();
    }

    public static int zzd(LeaderboardVariant leaderboardVariant) {
        return Arrays.hashCode(new Object[]{Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zza(), leaderboardVariant.zzc(), leaderboardVariant.zzb()});
    }

    public static boolean zze(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzah.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzah.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzah.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzah.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzah.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzah.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzah.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzah.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzah.equal(leaderboardVariant2.zza(), leaderboardVariant.zza()) && zzah.equal(leaderboardVariant2.zzc(), leaderboardVariant.zzc()) && zzah.equal(leaderboardVariant2.zzb(), leaderboardVariant.zzb());
    }

    public final boolean equals(Object obj) {
        return zze(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return this.zzc;
    }

    public final int hashCode() {
        return zzd(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzf(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zza() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzc() {
        return this.zzl;
    }

    public static String zzf(LeaderboardVariant leaderboardVariant) {
        String str;
        zzz zzzVar = new zzz(leaderboardVariant);
        zzzVar.add(com.google.android.gms.internal.games_v2.zzz.zza(leaderboardVariant.getTimeSpan()), "TimeSpan");
        int collection = leaderboardVariant.getCollection();
        if (collection == -1) {
            str = "UNKNOWN";
        } else if (collection == 0) {
            str = "PUBLIC";
        } else if (collection != 1) {
            str = "SOCIAL_1P";
            if (collection != 2) {
                if (collection == 3) {
                    str = "FRIENDS";
                } else if (collection != 4) {
                    StringBuilder sb = new StringBuilder(String.valueOf(collection).length() + 32);
                    sb.append(UUFMQdNK.ZtZzYKgzqs);
                    sb.append(collection);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        } else {
            str = "SOCIAL";
        }
        zzzVar.add(str, "Collection");
        zzzVar.add(leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none", "RawPlayerScore");
        zzzVar.add(leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none", "DisplayPlayerScore");
        zzzVar.add(leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none", "PlayerRank");
        zzzVar.add(leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none", "DisplayPlayerRank");
        zzzVar.add(Long.valueOf(leaderboardVariant.getNumScores()), "NumScores");
        zzzVar.add(leaderboardVariant.zza(), "TopPageNextToken");
        zzzVar.add(leaderboardVariant.zzc(), "WindowPageNextToken");
        zzzVar.add(leaderboardVariant.zzb(), "WindowPagePrevToken");
        return zzzVar.toString();
    }
}
