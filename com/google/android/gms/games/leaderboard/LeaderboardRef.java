package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardRef extends DataBufferRef implements Leaderboard {
    public final int zza;
    public final GameRef zzb;

    public LeaderboardRef(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zza = i2;
        this.zzb = new GameRef(dataHolder, i);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return LeaderboardEntity.zzc(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final /* synthetic */ Object freeze() {
        return new LeaderboardEntity(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getDisplayName() {
        return getString("name");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Uri getIconImageUri() {
        return parseUri("board_icon_image_uri");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String getIconImageUrl() {
        return getString("board_icon_image_url");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final String getLeaderboardId() {
        return getString("external_leaderboard_id");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final int getScoreOrder() {
        return getInteger("score_order");
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final ArrayList<LeaderboardVariant> getVariants() {
        int i = this.zza;
        ArrayList<LeaderboardVariant> arrayList = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new zzb(this.mDataHolder, this.mDataRow + i2));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{getLeaderboardId(), getDisplayName(), getIconImageUri(), Integer.valueOf(getScoreOrder()), getVariants()});
    }

    public final String toString() {
        return LeaderboardEntity.zzd(this);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final Game zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }
}
