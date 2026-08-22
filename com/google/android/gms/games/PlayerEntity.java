package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zzk();
    public final String zza;
    public final String zzb;
    public final Uri zzc;
    public final Uri zzd;
    public final long zze;
    public final int zzf;
    public final long zzg;
    public final String zzh;
    public final String zzi;
    public final String zzj;
    public final MostRecentGameInfoEntity zzk;
    public final PlayerLevelInfo zzl;
    public final boolean zzm;
    public final boolean zzn;
    public final String zzo;
    public final String zzp;
    public final Uri zzq;
    public final String zzr;
    public final Uri zzs;
    public final String zzt;
    public final long zzu;
    public final zzo zzv;
    public final zza zzw;
    public final boolean zzx;
    public final String zzy;

    public PlayerEntity(Player player) {
        String playerId = player.getPlayerId();
        this.zza = playerId;
        String displayName = player.getDisplayName();
        this.zzb = displayName;
        this.zzc = player.getIconImageUri();
        this.zzh = player.getIconImageUrl();
        this.zzd = player.getHiResImageUri();
        this.zzi = player.getHiResImageUrl();
        long retrievedTimestamp = player.getRetrievedTimestamp();
        this.zze = retrievedTimestamp;
        this.zzf = player.zze();
        this.zzg = player.getLastPlayedWithTimestamp();
        this.zzj = player.getTitle();
        this.zzm = player.zzf();
        com.google.android.gms.games.internal.player.zza zzaVarZzh = player.zzh();
        this.zzk = zzaVarZzh == null ? null : new MostRecentGameInfoEntity(zzaVarZzh);
        this.zzl = player.getLevelInfo();
        this.zzn = player.zzd();
        this.zzo = player.zzb();
        this.zzp = player.zzc();
        this.zzq = player.getBannerImageLandscapeUri();
        this.zzr = player.getBannerImageLandscapeUrl();
        this.zzs = player.getBannerImagePortraitUri();
        this.zzt = player.getBannerImagePortraitUrl();
        this.zzu = player.zzi();
        PlayerRelationshipInfo relationshipInfo = player.getRelationshipInfo();
        this.zzv = relationshipInfo == null ? null : new zzo((PlayerRelationshipInfo) relationshipInfo.freeze());
        CurrentPlayerInfo currentPlayerInfo = player.getCurrentPlayerInfo();
        this.zzw = currentPlayerInfo != null ? (zza) currentPlayerInfo.freeze() : null;
        this.zzx = player.zzg();
        this.zzy = player.zza();
        if (playerId == null) {
            throw new IllegalArgumentException("null reference");
        }
        if (displayName == null) {
            throw new IllegalArgumentException("null reference");
        }
        zzah.checkState(retrievedTimestamp > 0);
    }

    public static int zzj(Player player) {
        return Arrays.hashCode(new Object[]{player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzd()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzb(), player.zzc(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Long.valueOf(player.zzi()), player.getRelationshipInfo(), player.getCurrentPlayerInfo(), Boolean.valueOf(player.zzg()), player.zza()});
    }

    public static boolean zzk(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzah.equal(player2.getPlayerId(), player.getPlayerId()) && zzah.equal(player2.getDisplayName(), player.getDisplayName()) && zzah.equal(Boolean.valueOf(player2.zzd()), Boolean.valueOf(player.zzd())) && zzah.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzah.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzah.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzah.equal(player2.getTitle(), player.getTitle()) && zzah.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzah.equal(player2.zzb(), player.zzb()) && zzah.equal(player2.zzc(), player.zzc()) && zzah.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && zzah.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && zzah.equal(Long.valueOf(player2.zzi()), Long.valueOf(player.zzi())) && zzah.equal(player2.getCurrentPlayerInfo(), player.getCurrentPlayerInfo()) && zzah.equal(player2.getRelationshipInfo(), player.getRelationshipInfo()) && zzah.equal(Boolean.valueOf(player2.zzg()), Boolean.valueOf(player.zzg())) && zzah.equal(player2.zza(), player.zza());
    }

    public boolean equals(Object obj) {
        return zzk(this, obj);
    }

    @Override // com.google.android.gms.games.Player
    public Player freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImageLandscapeUri() {
        return this.zzq;
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return this.zzr;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImagePortraitUri() {
        return this.zzs;
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return this.zzt;
    }

    @Override // com.google.android.gms.games.Player
    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzw;
    }

    @Override // com.google.android.gms.games.Player
    public String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getHiResImageUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getIconImageUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.Player
    public long getLastPlayedWithTimestamp() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo getLevelInfo() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.Player
    public String getPlayerId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.Player
    public PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzv;
    }

    @Override // com.google.android.gms.games.Player
    public long getRetrievedTimestamp() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.Player
    public String getTitle() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzj(this);
    }

    @Override // com.google.android.gms.games.Player
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzl(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (shouldDowngrade()) {
            parcel.writeString(this.zza);
            parcel.writeString(this.zzb);
            Uri uri = this.zzc;
            parcel.writeString(uri == null ? null : uri.toString());
            Uri uri2 = this.zzd;
            parcel.writeString(uri2 != null ? uri2.toString() : null);
            parcel.writeLong(this.zze);
            return;
        }
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getPlayerId(), false);
        CloseableKt.writeString(parcel, 2, getDisplayName(), false);
        CloseableKt.writeParcelable(parcel, 3, getIconImageUri(), i, false);
        CloseableKt.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
        long retrievedTimestamp = getRetrievedTimestamp();
        CloseableKt.zzc(parcel, 5, 8);
        parcel.writeLong(retrievedTimestamp);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf);
        long lastPlayedWithTimestamp = getLastPlayedWithTimestamp();
        CloseableKt.zzc(parcel, 7, 8);
        parcel.writeLong(lastPlayedWithTimestamp);
        CloseableKt.writeString(parcel, 8, getIconImageUrl(), false);
        CloseableKt.writeString(parcel, 9, getHiResImageUrl(), false);
        CloseableKt.writeString(parcel, 14, getTitle(), false);
        CloseableKt.writeParcelable(parcel, 15, this.zzk, i, false);
        CloseableKt.writeParcelable(parcel, 16, getLevelInfo(), i, false);
        CloseableKt.zzc(parcel, 18, 4);
        parcel.writeInt(this.zzm ? 1 : 0);
        CloseableKt.zzc(parcel, 19, 4);
        parcel.writeInt(this.zzn ? 1 : 0);
        CloseableKt.writeString(parcel, 20, this.zzo, false);
        CloseableKt.writeString(parcel, 21, this.zzp, false);
        CloseableKt.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
        CloseableKt.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
        CloseableKt.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
        CloseableKt.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
        CloseableKt.zzc(parcel, 29, 8);
        parcel.writeLong(this.zzu);
        CloseableKt.writeParcelable(parcel, 33, getRelationshipInfo(), i, false);
        CloseableKt.writeParcelable(parcel, 35, getCurrentPlayerInfo(), i, false);
        CloseableKt.zzc(parcel, 36, 4);
        parcel.writeInt(this.zzx ? 1 : 0);
        CloseableKt.writeString(parcel, 37, this.zzy, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.Player
    public final String zza() {
        return this.zzy;
    }

    @Override // com.google.android.gms.games.Player
    public final String zzb() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.Player
    public final String zzc() {
        return this.zzp;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzd() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.Player
    public final int zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzf() {
        return this.zzm;
    }

    @Override // com.google.android.gms.games.Player
    public final boolean zzg() {
        return this.zzx;
    }

    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzh() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.Player
    public final long zzi() {
        return this.zzu;
    }

    public static String zzl(Player player) {
        zzz zzzVar = new zzz(player);
        zzzVar.add(player.getPlayerId(), "PlayerId");
        zzzVar.add(player.getDisplayName(), "DisplayName");
        zzzVar.add(Boolean.valueOf(player.zzd()), "HasDebugAccess");
        zzzVar.add(player.getIconImageUri(), "IconImageUri");
        zzzVar.add(player.getIconImageUrl(), "IconImageUrl");
        zzzVar.add(player.getHiResImageUri(), "HiResImageUri");
        zzzVar.add(player.getHiResImageUrl(), "HiResImageUrl");
        zzzVar.add(Long.valueOf(player.getRetrievedTimestamp()), "RetrievedTimestamp");
        zzzVar.add(player.getTitle(), yzwzcWHcnH.yHVCNZnN);
        zzzVar.add(player.getLevelInfo(), "LevelInfo");
        zzzVar.add(player.zzb(), "GamerTag");
        zzzVar.add(player.zzc(), "Name");
        zzzVar.add(player.getBannerImageLandscapeUri(), "BannerImageLandscapeUri");
        zzzVar.add(player.getBannerImageLandscapeUrl(), "BannerImageLandscapeUrl");
        zzzVar.add(player.getBannerImagePortraitUri(), "BannerImagePortraitUri");
        zzzVar.add(player.getBannerImagePortraitUrl(), "BannerImagePortraitUrl");
        zzzVar.add(player.getCurrentPlayerInfo(), "CurrentPlayerInfo");
        zzzVar.add(Long.valueOf(player.zzi()), "TotalUnlockedAchievement");
        if (player.zzg()) {
            zzzVar.add(Boolean.valueOf(player.zzg()), "AlwaysAutoSignIn");
        }
        if (player.getRelationshipInfo() != null) {
            zzzVar.add(player.getRelationshipInfo(), "RelationshipInfo");
        }
        if (player.zza() != null) {
            zzzVar.add(player.zza(), "GamePlayerId");
        }
        return zzzVar.toString();
    }

    @Override // com.google.android.gms.games.Player
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Player
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Player
    public void getTitle(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    public PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j, int i, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, long j3, zzo zzoVar, zza zzaVar, boolean z3, String str10) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzh = str3;
        this.zzd = uri2;
        this.zzi = str4;
        this.zze = j;
        this.zzf = i;
        this.zzg = j2;
        this.zzj = str5;
        this.zzm = z;
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = playerLevelInfo;
        this.zzn = z2;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = uri3;
        this.zzr = str8;
        this.zzs = uri4;
        this.zzt = str9;
        this.zzu = j3;
        this.zzv = zzoVar;
        this.zzw = zzaVar;
        this.zzx = z3;
        this.zzy = str10;
    }
}
