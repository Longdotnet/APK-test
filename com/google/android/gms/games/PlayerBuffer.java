package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class PlayerBuffer extends AbstractDataBuffer {
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Player get(int i) {
        return new PlayerRef(this.mDataHolder, i, null);
    }
}
