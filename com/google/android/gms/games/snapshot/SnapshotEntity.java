package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotEntity extends zzg implements Snapshot {
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();
    public final SnapshotMetadataEntity zza;
    public final SnapshotContentsEntity zzb;

    public SnapshotEntity(SnapshotMetadata snapshotMetadata, SnapshotContentsEntity snapshotContentsEntity) {
        this.zza = new SnapshotMetadataEntity(snapshotMetadata);
        this.zzb = snapshotContentsEntity;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Snapshot snapshot = (Snapshot) obj;
        return zzah.equal(snapshot.getMetadata(), getMetadata()) && zzah.equal(snapshot.getSnapshotContents(), getSnapshotContents());
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public Snapshot freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotMetadata getMetadata() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public SnapshotContents getSnapshotContents() {
        SnapshotContentsEntity snapshotContentsEntity = this.zzb;
        if (snapshotContentsEntity.isClosed()) {
            return null;
        }
        return snapshotContentsEntity;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getMetadata(), getSnapshotContents()});
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(getMetadata(), "Metadata");
        zzzVar.add(Boolean.valueOf(getSnapshotContents() != null), "HasContents");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, getMetadata(), i, false);
        CloseableKt.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }
}
