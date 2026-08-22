package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerStatsBuffer extends AbstractDataBuffer {
    public PlayerStatsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final PlayerStats get(int i) {
        return new zzb(this.mDataHolder, i);
    }
}
