package com.google.android.gms.games.snapshot;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;

/* JADX INFO: loaded from: classes.dex */
public interface SnapshotContents extends Parcelable {
    ParcelFileDescriptor getParcelFileDescriptor();

    boolean isClosed();

    boolean modifyBytes(int i, byte[] bArr, int i2, int i3);

    byte[] readFully();

    boolean writeBytes(byte[] bArr);

    Contents zza();

    void zzb();
}
