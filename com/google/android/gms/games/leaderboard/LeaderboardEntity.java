package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.firebase.auth.zzz;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardEntity implements Leaderboard {
    public final String zza;
    public final String zzb;
    public final Uri zzc;
    public final int zzd;
    public final ArrayList zze;
    public final String zzf;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zza = leaderboard.getLeaderboardId();
        this.zzb = leaderboard.getDisplayName();
        this.zzc = leaderboard.getIconImageUri();
        this.zzf = leaderboard.getIconImageUrl();
        this.zzd = leaderboard.getScoreOrder();
        Game gameZza = leaderboard.zza();
        if (gameZza != null) {
            new GameEntity(gameZza);
        }
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.zze = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zze.add((LeaderboardVariantEntity) variants.get(i).freeze());
        }
    }

    public static boolean zzc(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzah.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzah.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzah.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzah.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzah.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    public static String zzd(Leaderboard leaderboard) {
        zzz zzzVar = new zzz(leaderboard);
        zzzVar.add(leaderboard.getLeaderboardId(), "LeaderboardId");
        zzzVar.add(leaderboard.getDisplayName(), "DisplayName");
        zzzVar.add(leaderboard.getIconImageUri(), "IconImageUri");
        zzzVar.add(leaderboard.getIconImageUrl(), "IconImageUrl");
        zzzVar.add(Integer.valueOf(leaderboard.getScoreOrder()), "ScoreOrder");
        zzzVar.add(leaderboard.getVariants(), "Variants");
        return zzzVar.toString();
    }

    public final boolean equals(Object obj) {
        return zzc(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String getIconImageUrl() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zze);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getLeaderboardId(), getDisplayName(), getIconImageUri(), Integer.valueOf(getScoreOrder()), getVariants()});
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        return zzd(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game zza() {
        throw null;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzb, charArrayBuffer);
    }
}
