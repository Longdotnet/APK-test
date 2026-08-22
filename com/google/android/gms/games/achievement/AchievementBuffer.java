package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class AchievementBuffer extends AbstractDataBuffer {
    public AchievementBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Achievement get(int i) {
        return new AchievementRef(this.mDataHolder, i);
    }
}
