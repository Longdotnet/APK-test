package com.google.android.gms.games.event;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public final class EventBuffer extends AbstractDataBuffer {
    public EventBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public Event get(int i) {
        return new EventRef(this.mDataHolder, i);
    }
}
