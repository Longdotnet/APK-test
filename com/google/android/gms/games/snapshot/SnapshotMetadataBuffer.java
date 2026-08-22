package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class SnapshotMetadataBuffer extends AbstractDataBuffer {
    public SnapshotMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    public SnapshotMetadata get(int i) {
        return new SnapshotMetadataRef(this.mDataHolder, i);
    }
}
