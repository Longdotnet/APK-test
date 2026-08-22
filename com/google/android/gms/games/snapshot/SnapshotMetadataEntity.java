package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class SnapshotMetadataEntity extends zzg implements SnapshotMetadata {
    public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new zzd();
    public final GameEntity zza;
    public final PlayerEntity zzb;
    public final String zzc;
    public final Uri zzd;
    public final String zze;
    public final String zzf;
    public final String zzg;
    public final long zzh;
    public final long zzi;
    public final float zzj;
    public final String zzk;
    public final boolean zzl;
    public final long zzm;
    public final String zzn;

    public SnapshotMetadataEntity(GameEntity gameEntity, PlayerEntity playerEntity, String str, Uri uri, String str2, String str3, String str4, long j, long j2, float f, String str5, boolean z, long j3, String str6) {
        this.zza = gameEntity;
        this.zzb = playerEntity;
        this.zzc = str;
        this.zzd = uri;
        this.zze = str2;
        this.zzj = f;
        this.zzf = str3;
        this.zzg = str4;
        this.zzh = j;
        this.zzi = j2;
        this.zzk = str5;
        this.zzl = z;
        this.zzm = j3;
        this.zzn = str6;
    }

    public static int zzb(SnapshotMetadata snapshotMetadata) {
        return Arrays.hashCode(new Object[]{snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.zza(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()), snapshotMetadata.getDeviceName()});
    }

    public static boolean zzc(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzah.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzah.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzah.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzah.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzah.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzah.equal(snapshotMetadata2.zza(), snapshotMetadata.zza()) && zzah.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzah.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzah.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzah.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzah.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzah.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue())) && zzah.equal(snapshotMetadata2.getDeviceName(), snapshotMetadata.getDeviceName());
    }

    public boolean equals(Object obj) {
        return zzc(this, obj);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public SnapshotMetadata freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public float getCoverImageAspectRatio() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Uri getCoverImageUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getCoverImageUrl() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getDescription() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getDeviceName() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Game getGame() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getLastModifiedTimestamp() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public Player getOwner() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getPlayedTime() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public long getProgressValue() {
        return this.zzm;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getSnapshotId() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public String getUniqueName() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean hasChangePending() {
        return this.zzl;
    }

    public int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzd(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, getGame(), i, false);
        CloseableKt.writeParcelable(parcel, 2, getOwner(), i, false);
        CloseableKt.writeString(parcel, 3, getSnapshotId(), false);
        CloseableKt.writeParcelable(parcel, 5, getCoverImageUri(), i, false);
        CloseableKt.writeString(parcel, 6, getCoverImageUrl(), false);
        CloseableKt.writeString(parcel, 7, this.zzf, false);
        CloseableKt.writeString(parcel, 8, getDescription(), false);
        long lastModifiedTimestamp = getLastModifiedTimestamp();
        CloseableKt.zzc(parcel, 9, 8);
        parcel.writeLong(lastModifiedTimestamp);
        long playedTime = getPlayedTime();
        CloseableKt.zzc(parcel, 10, 8);
        parcel.writeLong(playedTime);
        float coverImageAspectRatio = getCoverImageAspectRatio();
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeFloat(coverImageAspectRatio);
        CloseableKt.writeString(parcel, 12, getUniqueName(), false);
        boolean zHasChangePending = hasChangePending();
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(zHasChangePending ? 1 : 0);
        long progressValue = getProgressValue();
        CloseableKt.zzc(parcel, 14, 8);
        parcel.writeLong(progressValue);
        CloseableKt.writeString(parcel, 15, getDeviceName(), false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final String zza() {
        return this.zzf;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        PlayerEntity playerEntity = new PlayerEntity(snapshotMetadata.getOwner());
        this.zza = new GameEntity(snapshotMetadata.getGame());
        this.zzb = playerEntity;
        this.zzc = snapshotMetadata.getSnapshotId();
        this.zzd = snapshotMetadata.getCoverImageUri();
        this.zze = snapshotMetadata.getCoverImageUrl();
        this.zzj = snapshotMetadata.getCoverImageAspectRatio();
        this.zzf = snapshotMetadata.zza();
        this.zzg = snapshotMetadata.getDescription();
        this.zzh = snapshotMetadata.getLastModifiedTimestamp();
        this.zzi = snapshotMetadata.getPlayedTime();
        this.zzk = snapshotMetadata.getUniqueName();
        this.zzl = snapshotMetadata.hasChangePending();
        this.zzm = snapshotMetadata.getProgressValue();
        this.zzn = snapshotMetadata.getDeviceName();
    }

    public static String zzd(SnapshotMetadata snapshotMetadata) {
        zzz zzzVar = new zzz(snapshotMetadata);
        zzzVar.add(snapshotMetadata.getGame(), "Game");
        zzzVar.add(snapshotMetadata.getOwner(), "Owner");
        zzzVar.add(snapshotMetadata.getSnapshotId(), "SnapshotId");
        zzzVar.add(snapshotMetadata.getCoverImageUri(), "CoverImageUri");
        zzzVar.add(snapshotMetadata.getCoverImageUrl(), "CoverImageUrl");
        zzzVar.add(Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), "CoverImageAspectRatio");
        zzzVar.add(snapshotMetadata.getDescription(), "Description");
        zzzVar.add(Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), dLDI.fVJJiPzgcsfno);
        zzzVar.add(Long.valueOf(snapshotMetadata.getPlayedTime()), "PlayedTime");
        zzzVar.add(snapshotMetadata.getUniqueName(), "UniqueName");
        zzzVar.add(Boolean.valueOf(snapshotMetadata.hasChangePending()), "ChangePending");
        zzzVar.add(Long.valueOf(snapshotMetadata.getProgressValue()), "ProgressValue");
        zzzVar.add(snapshotMetadata.getDeviceName(), "DeviceName");
        return zzzVar.toString();
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadata
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzg, charArrayBuffer);
    }
}
