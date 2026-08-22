package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class LeaderboardScoreBuffer extends AbstractDataBuffer {
    public final zza zza;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new zza(dataHolder.zaj);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.mDataHolder, i);
    }

    public final zza zza() {
        return this.zza;
    }
}
