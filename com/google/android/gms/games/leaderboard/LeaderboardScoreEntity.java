package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardScoreEntity implements LeaderboardScore {
    public final long zza;
    public final String zzb;
    public final String zzc;
    public final long zzd;
    public final long zze;
    public final String zzf;
    public final Uri zzg;
    public final Uri zzh;
    public final PlayerEntity zzi;
    public final String zzj;
    public final String zzk;
    public final String zzl;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardScore) {
        this.zza = leaderboardScore.getRank();
        String displayRank = leaderboardScore.getDisplayRank();
        zzah.checkNotNull(displayRank);
        this.zzb = displayRank;
        String displayScore = leaderboardScore.getDisplayScore();
        zzah.checkNotNull(displayScore);
        this.zzc = displayScore;
        this.zzd = leaderboardScore.getRawScore();
        this.zze = leaderboardScore.getTimestampMillis();
        this.zzf = leaderboardScore.getScoreHolderDisplayName();
        this.zzg = leaderboardScore.getScoreHolderIconImageUri();
        this.zzh = leaderboardScore.getScoreHolderHiResImageUri();
        Player scoreHolder = leaderboardScore.getScoreHolder();
        this.zzi = scoreHolder == null ? null : new PlayerEntity(scoreHolder);
        this.zzj = leaderboardScore.getScoreTag();
        this.zzk = leaderboardScore.getScoreHolderIconImageUrl();
        this.zzl = leaderboardScore.getScoreHolderHiResImageUrl();
    }

    public static int zza(LeaderboardScore leaderboardScore) {
        return Arrays.hashCode(new Object[]{Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder()});
    }

    public static boolean zzb(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzah.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzah.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzah.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzah.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzah.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzah.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzah.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzah.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzah.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzah.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    public static String zzc(LeaderboardScore leaderboardScore) {
        zzz zzzVar = new zzz(leaderboardScore);
        zzzVar.add(Long.valueOf(leaderboardScore.getRank()), "Rank");
        zzzVar.add(leaderboardScore.getDisplayRank(), "DisplayRank");
        zzzVar.add(Long.valueOf(leaderboardScore.getRawScore()), "Score");
        zzzVar.add(leaderboardScore.getDisplayScore(), "DisplayScore");
        zzzVar.add(Long.valueOf(leaderboardScore.getTimestampMillis()), "Timestamp");
        zzzVar.add(leaderboardScore.getScoreHolderDisplayName(), "DisplayName");
        zzzVar.add(leaderboardScore.getScoreHolderIconImageUri(), "IconImageUri");
        zzzVar.add(leaderboardScore.getScoreHolderIconImageUrl(), "IconImageUrl");
        zzzVar.add(leaderboardScore.getScoreHolderHiResImageUri(), "HiResImageUri");
        zzzVar.add(leaderboardScore.getScoreHolderHiResImageUrl(), "HiResImageUrl");
        zzzVar.add(leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder(), "Player");
        zzzVar.add(leaderboardScore.getScoreTag(), "ScoreTag");
        return zzzVar.toString();
    }

    public final boolean equals(Object obj) {
        return zzb(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayRank() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getDisplayScore() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRank() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getRawScore() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Player getScoreHolder() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreHolderDisplayName() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzf : playerEntity.getDisplayName();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderHiResImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzh : playerEntity.getHiResImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderHiResImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzl : playerEntity.getHiResImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final Uri getScoreHolderIconImageUri() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzg : playerEntity.getIconImageUri();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public String getScoreHolderIconImageUrl() {
        PlayerEntity playerEntity = this.zzi;
        return playerEntity == null ? this.zzk : playerEntity.getIconImageUrl();
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final String getScoreTag() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final long getTimestampMillis() {
        return this.zze;
    }

    public final int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzc(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayRank(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getDisplayScore(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardScore
    public final void getScoreHolderDisplayName(CharArrayBuffer charArrayBuffer) {
        PlayerEntity playerEntity = this.zzi;
        if (playerEntity == null) {
            Hex.copyStringToBuffer(this.zzf, charArrayBuffer);
        } else {
            playerEntity.getDisplayName(charArrayBuffer);
        }
    }
}
