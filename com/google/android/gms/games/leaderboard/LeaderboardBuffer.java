package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* JADX INFO: loaded from: classes.dex */
public class LeaderboardBuffer extends EntityBuffer {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zaa = false;
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    public final /* bridge */ /* synthetic */ Object getEntry(int i, int i2) {
        return new LeaderboardRef(this.mDataHolder, i, i2);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    public final String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
