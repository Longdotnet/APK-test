package com.google.android.gms.games.snapshot;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface Snapshot extends Parcelable {
    /* synthetic */ Object freeze();

    SnapshotMetadata getMetadata();

    SnapshotContents getSnapshotContents();

    /* synthetic */ boolean isDataValid();
}
