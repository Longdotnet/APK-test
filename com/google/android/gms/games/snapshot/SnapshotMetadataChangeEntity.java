package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.internal.zzg;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMetadataChangeEntity extends zzg implements SnapshotMetadataChange {
    public static final Parcelable.Creator<SnapshotMetadataChangeEntity> CREATOR = new zzc();
    public final String zza;
    public final Long zzb;
    public final Uri zzc;
    public final BitmapTeleporter zzd;
    public final Long zze;

    public SnapshotMetadataChangeEntity(String str, Long l, BitmapTeleporter bitmapTeleporter, Uri uri, Long l2) {
        this.zza = str;
        this.zzb = l;
        this.zzd = bitmapTeleporter;
        this.zzc = uri;
        this.zze = l2;
        boolean z = true;
        if (bitmapTeleporter != null && uri != null) {
            z = false;
        }
        zzah.checkState(z, "Cannot set both a URI and an image");
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Bitmap getCoverImage() {
        BitmapTeleporter bitmapTeleporter = this.zzd;
        if (bitmapTeleporter == null) {
            return null;
        }
        if (!bitmapTeleporter.zae) {
            ParcelFileDescriptor parcelFileDescriptor = bitmapTeleporter.zab;
            zzah.checkNotNull(parcelFileDescriptor);
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    int i = dataInputStream.readInt();
                    int i2 = dataInputStream.readInt();
                    Bitmap.Config configValueOf = Bitmap.Config.valueOf(dataInputStream.readUTF());
                    dataInputStream.read(bArr);
                    BitmapTeleporter.zaa(dataInputStream);
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, configValueOf);
                    bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferWrap);
                    bitmapTeleporter.zad = bitmapCreateBitmap;
                    bitmapTeleporter.zae = true;
                } catch (IOException e) {
                    throw new IllegalStateException("Could not read from parcel file descriptor", e);
                }
            } catch (Throwable th) {
                BitmapTeleporter.zaa(dataInputStream);
                throw th;
            }
        }
        return bitmapTeleporter.zad;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final String getDescription() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Long getPlayedTimeMillis() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final Long getProgressValue() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeLongObject(parcel, 2, this.zzb);
        CloseableKt.writeParcelable(parcel, 4, this.zzc, i, false);
        CloseableKt.writeParcelable(parcel, 5, this.zzd, i, false);
        CloseableKt.writeLongObject(parcel, 6, this.zze);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public final BitmapTeleporter zza() {
        return this.zzd;
    }
}
