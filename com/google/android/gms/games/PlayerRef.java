package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerRef extends zzg implements Player {
    public final com.google.android.gms.games.internal.player.zzd zza;
    public final PlayerLevelInfo zzb;
    public final com.google.android.gms.games.internal.player.zzc zzc;
    public final zzq zzd;
    public final zzc zze;

    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        com.google.android.gms.games.internal.player.zzd zzdVar = new com.google.android.gms.games.internal.player.zzd(null);
        this.zza = zzdVar;
        this.zzc = new com.google.android.gms.games.internal.player.zzc(dataHolder, i, zzdVar);
        this.zzd = new zzq(dataHolder, i, zzdVar);
        this.zze = new zzc(dataHolder, i, zzdVar);
        if (hasNull(zzdVar.zzk) || getLong(zzdVar.zzk) == -1) {
            this.zzb = null;
            return;
        }
        int integer = getInteger(zzdVar.zzl);
        int integer2 = getInteger(zzdVar.zzo);
        PlayerLevel playerLevel = new PlayerLevel(integer, getLong(zzdVar.zzm), getLong(zzdVar.zzn));
        this.zzb = new PlayerLevelInfo(getLong(zzdVar.zzk), getLong(zzdVar.zzq), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(zzdVar.zzn), getLong(zzdVar.zzp)) : playerLevel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return PlayerEntity.zzk(this, obj);
    }

    @Override // com.google.android.gms.games.Player
    public final /* synthetic */ Object freeze() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zza.zzC);
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return getString(this.zza.zzD);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zza.zzE);
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return getString(this.zza.zzF);
    }

    @Override // com.google.android.gms.games.Player
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        zzc zzcVar = this.zze;
        if (zzcVar.zza()) {
            return zzcVar;
        }
        return null;
    }

    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return getString(this.zza.zzc);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return parseUri(this.zza.zzf);
    }

    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return getString(this.zza.zzg);
    }

    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return parseUri(this.zza.zzd);
    }

    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return getString(this.zza.zze);
    }

    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        String str = this.zza.zzj;
        if (!hasColumn(str) || hasNull(str)) {
            return -1L;
        }
        return getLong(str);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return getString(this.zza.zza);
    }

    @Override // com.google.android.gms.games.Player
    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzq zzqVar = this.zzd;
        if (zzqVar.getFriendStatus() == -1 && zzqVar.zza() == null && zzqVar.zzb() == null) {
            return null;
        }
        return zzqVar;
    }

    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return getLong(this.zza.zzh);
    }

    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return getString(this.zza.zzr);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.zzj(this);
    }

    public final String toString() {
        return PlayerEntity.zzl(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new PlayerEntity(this).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.games.Player
    public final String zza() {
        return zzj(this.zza.zzb, null);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzb() {
        return getString(this.zza.zzA);
    }

    @Override // com.google.android.gms.games.Player
    public final String zzc() {
        return getString(this.zza.zzB);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzd() {
        return getBoolean(this.zza.zzz);
    }

    @Override // com.google.android.gms.games.Player
    public final int zze() {
        return getInteger(this.zza.zzi);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzf() {
        return getBoolean(this.zza.zzs);
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzg() {
        String str = this.zza.zzM;
        return hasColumn(str) && getBoolean(str);
    }

    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzh() {
        if (hasNull(this.zza.zzt)) {
            return null;
        }
        return this.zzc;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzi() {
        String str = this.zza.zzG;
        if (!hasColumn(str) || hasNull(str)) {
            return -1L;
        }
        return getLong(str);
    }

    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzc, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzr, charArrayBuffer);
    }
}
