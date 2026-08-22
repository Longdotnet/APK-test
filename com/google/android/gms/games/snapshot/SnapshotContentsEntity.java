package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzg;
import com.google.android.gms.internal.games_v2.zzfn;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class SnapshotContentsEntity extends zzg implements SnapshotContents {
    public Contents zzb;
    public static final Object zza = new Object();
    public static final Parcelable.Creator<SnapshotContentsEntity> CREATOR = new zza();

    public SnapshotContentsEntity(Contents contents) {
        this.zzb = contents;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean isClosed() {
        return this.zzb == null;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean modifyBytes(int i, byte[] bArr, int i2, int i3) {
        return zzc(bArr, i, i2, bArr.length, false);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final byte[] readFully() {
        byte[] byteArray;
        zzah.checkState(!isClosed(), "Must provide a previously opened Snapshot");
        synchronized (zza) {
            try {
                FileInputStream fileInputStream = new FileInputStream(this.zzb.zza.getFileDescriptor());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    fileInputStream.getChannel().position(0L);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    Hex.copyStream(bufferedInputStream, byteArrayOutputStream, false);
                    byteArray = byteArrayOutputStream.toByteArray();
                    fileInputStream.getChannel().position(0L);
                } catch (IOException e) {
                    zzfn.zzf("SnapshotContentsEntity", "Failed to read snapshot data", e);
                    throw e;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArray;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean writeBytes(byte[] bArr) {
        return zzc(bArr, 0, 0, bArr.length, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final Contents zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final void zzb() {
        this.zzb = null;
    }

    public final boolean zzc(byte[] bArr, int i, int i2, int i3, boolean z) {
        zzah.checkState(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (zza) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.zzb.zza.getFileDescriptor());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    FileChannel channel = fileOutputStream.getChannel();
                    channel.position(i);
                    bufferedOutputStream.write(bArr, i2, i3);
                    if (z) {
                        channel.truncate(bArr.length);
                    }
                    bufferedOutputStream.flush();
                } catch (IOException e) {
                    zzfn.zzd("SnapshotContentsEntity", "Failed to write snapshot data", e);
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        zzah.checkState(!isClosed(), ehgOP.bMArQiy);
        return this.zzb.zza;
    }
}
