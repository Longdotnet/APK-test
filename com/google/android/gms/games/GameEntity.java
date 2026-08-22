package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new zze();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Uri zzg;
    public final Uri zzh;
    public final Uri zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final String zzl;
    public final int zzm;
    public final int zzn;
    public final int zzo;
    public final boolean zzp;
    public final boolean zzq;
    public final String zzr;
    public final String zzs;
    public final String zzt;
    public final boolean zzu;
    public final boolean zzv;
    public final boolean zzw;
    public final String zzx;
    public final boolean zzy;
    public final boolean zzz;

    public GameEntity(Game game) {
        this.zza = game.getApplicationId();
        this.zzc = game.getPrimaryCategory();
        this.zzd = game.getSecondaryCategory();
        this.zze = game.getDescription();
        this.zzf = game.getDeveloperName();
        this.zzb = game.getDisplayName();
        this.zzg = game.getIconImageUri();
        this.zzr = game.getIconImageUrl();
        this.zzh = game.getHiResImageUri();
        this.zzs = game.getHiResImageUrl();
        this.zzi = game.getFeaturedImageUri();
        this.zzt = game.getFeaturedImageUrl();
        this.zzj = game.zza();
        this.zzk = game.zze();
        this.zzl = game.zzf();
        this.zzm = 1;
        this.zzn = game.getAchievementTotalCount();
        this.zzo = game.getLeaderboardCount();
        this.zzp = game.zzg();
        this.zzq = game.zzh();
        this.zzu = game.zzb();
        this.zzv = game.zzc();
        this.zzw = game.areSnapshotsEnabled();
        this.zzx = game.getThemeColor();
        this.zzy = game.hasGamepadSupport();
        this.zzz = game.zzd();
    }

    public static int zzi(Game game) {
        return Arrays.hashCode(new Object[]{game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zza()), Boolean.valueOf(game.zze()), game.zzf(), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.zzg()), Boolean.valueOf(game.zzh()), Boolean.valueOf(game.zzb()), Boolean.valueOf(game.zzc()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()), Boolean.valueOf(game.zzd())});
    }

    public static boolean zzj(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        return zzah.equal(game2.getApplicationId(), game.getApplicationId()) && zzah.equal(game2.getDisplayName(), game.getDisplayName()) && zzah.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzah.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzah.equal(game2.getDescription(), game.getDescription()) && zzah.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzah.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzah.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzah.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzah.equal(Boolean.valueOf(game2.zza()), Boolean.valueOf(game.zza())) && zzah.equal(Boolean.valueOf(game2.zze()), Boolean.valueOf(game.zze())) && zzah.equal(game2.zzf(), game.zzf()) && zzah.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzah.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzah.equal(Boolean.valueOf(game2.zzg()), Boolean.valueOf(game.zzg())) && zzah.equal(Boolean.valueOf(game2.zzh()), Boolean.valueOf(game.zzh())) && zzah.equal(Boolean.valueOf(game2.zzb()), Boolean.valueOf(game.zzb())) && zzah.equal(Boolean.valueOf(game2.zzc()), Boolean.valueOf(game.zzc())) && zzah.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzah.equal(game2.getThemeColor(), game.getThemeColor()) && zzah.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport())) && zzah.equal(Boolean.valueOf(game2.zzd()), Boolean.valueOf(game.zzd()));
    }

    public static String zzk(Game game) {
        zzz zzzVar = new zzz(game);
        zzzVar.add(game.getApplicationId(), "ApplicationId");
        zzzVar.add(game.getDisplayName(), "DisplayName");
        zzzVar.add(game.getPrimaryCategory(), "PrimaryCategory");
        zzzVar.add(game.getSecondaryCategory(), "SecondaryCategory");
        zzzVar.add(game.getDescription(), "Description");
        zzzVar.add(game.getDeveloperName(), "DeveloperName");
        zzzVar.add(game.getIconImageUri(), "IconImageUri");
        zzzVar.add(game.getIconImageUrl(), "IconImageUrl");
        zzzVar.add(game.getHiResImageUri(), "HiResImageUri");
        zzzVar.add(game.getHiResImageUrl(), "HiResImageUrl");
        zzzVar.add(game.getFeaturedImageUri(), "FeaturedImageUri");
        zzzVar.add(game.getFeaturedImageUrl(), "FeaturedImageUrl");
        zzzVar.add(Boolean.valueOf(game.zza()), "PlayEnabledGame");
        zzzVar.add(Boolean.valueOf(game.zze()), "InstanceInstalled");
        zzzVar.add(game.zzf(), "InstancePackageName");
        zzzVar.add(Integer.valueOf(game.getAchievementTotalCount()), "AchievementTotalCount");
        zzzVar.add(Integer.valueOf(game.getLeaderboardCount()), "LeaderboardCount");
        zzzVar.add(Boolean.valueOf(game.areSnapshotsEnabled()), "AreSnapshotsEnabled");
        zzzVar.add(game.getThemeColor(), "ThemeColor");
        zzzVar.add(Boolean.valueOf(game.hasGamepadSupport()), "HasGamepadSupport");
        return zzzVar.toString();
    }

    @Override // com.google.android.gms.games.Game
    public boolean areSnapshotsEnabled() {
        return this.zzw;
    }

    public boolean equals(Object obj) {
        return zzj(this, obj);
    }

    @Override // com.google.android.gms.games.Game
    public Game freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Game
    public int getAchievementTotalCount() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.Game
    public String getApplicationId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.Game
    public String getDescription() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.Game
    public String getDeveloperName() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.Game
    public String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.Game
    public Uri getFeaturedImageUri() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return this.zzt;
    }

    @Override // com.google.android.gms.games.Game
    public Uri getHiResImageUri() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.games.Game
    public Uri getIconImageUri() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return this.zzr;
    }

    @Override // com.google.android.gms.games.Game
    public int getLeaderboardCount() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.Game
    public String getPrimaryCategory() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.Game
    public String getSecondaryCategory() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.Game
    public String getThemeColor() {
        return this.zzx;
    }

    @Override // com.google.android.gms.games.Game
    public boolean hasGamepadSupport() {
        return this.zzy;
    }

    public int hashCode() {
        return zzi(this);
    }

    @Override // com.google.android.gms.games.Game
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzk(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        boolean zShouldDowngrade = shouldDowngrade();
        int i2 = this.zzm;
        String str = this.zzl;
        boolean z = this.zzk;
        boolean z2 = this.zzj;
        if (zShouldDowngrade) {
            parcel.writeString(this.zza);
            parcel.writeString(this.zzb);
            parcel.writeString(this.zzc);
            parcel.writeString(this.zzd);
            parcel.writeString(this.zze);
            parcel.writeString(this.zzf);
            Uri uri = this.zzg;
            parcel.writeString(uri == null ? null : uri.toString());
            Uri uri2 = this.zzh;
            parcel.writeString(uri2 == null ? null : uri2.toString());
            Uri uri3 = this.zzi;
            parcel.writeString(uri3 != null ? uri3.toString() : null);
            parcel.writeInt(z2 ? 1 : 0);
            parcel.writeInt(z ? 1 : 0);
            parcel.writeString(str);
            parcel.writeInt(i2);
            parcel.writeInt(this.zzn);
            parcel.writeInt(this.zzo);
            return;
        }
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getApplicationId(), false);
        CloseableKt.writeString(parcel, 2, getDisplayName(), false);
        CloseableKt.writeString(parcel, 3, getPrimaryCategory(), false);
        CloseableKt.writeString(parcel, 4, getSecondaryCategory(), false);
        CloseableKt.writeString(parcel, 5, getDescription(), false);
        CloseableKt.writeString(parcel, 6, getDeveloperName(), false);
        CloseableKt.writeParcelable(parcel, 7, getIconImageUri(), i, false);
        CloseableKt.writeParcelable(parcel, 8, getHiResImageUri(), i, false);
        CloseableKt.writeParcelable(parcel, 9, getFeaturedImageUri(), i, false);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 12, str, false);
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(i2);
        int achievementTotalCount = getAchievementTotalCount();
        CloseableKt.zzc(parcel, 14, 4);
        parcel.writeInt(achievementTotalCount);
        int leaderboardCount = getLeaderboardCount();
        CloseableKt.zzc(parcel, 15, 4);
        parcel.writeInt(leaderboardCount);
        CloseableKt.zzc(parcel, 16, 4);
        parcel.writeInt(this.zzp ? 1 : 0);
        CloseableKt.zzc(parcel, 17, 4);
        parcel.writeInt(this.zzq ? 1 : 0);
        CloseableKt.writeString(parcel, 18, getIconImageUrl(), false);
        CloseableKt.writeString(parcel, 19, getHiResImageUrl(), false);
        CloseableKt.writeString(parcel, 20, getFeaturedImageUrl(), false);
        CloseableKt.zzc(parcel, 21, 4);
        parcel.writeInt(this.zzu ? 1 : 0);
        CloseableKt.zzc(parcel, 22, 4);
        parcel.writeInt(this.zzv ? 1 : 0);
        boolean zAreSnapshotsEnabled = areSnapshotsEnabled();
        CloseableKt.zzc(parcel, 23, 4);
        parcel.writeInt(zAreSnapshotsEnabled ? 1 : 0);
        CloseableKt.writeString(parcel, 24, getThemeColor(), false);
        boolean zHasGamepadSupport = hasGamepadSupport();
        CloseableKt.zzc(parcel, 25, 4);
        parcel.writeInt(zHasGamepadSupport ? 1 : 0);
        CloseableKt.zzc(parcel, 28, 4);
        parcel.writeInt(this.zzz ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zza() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzb() {
        return this.zzu;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzc() {
        return this.zzv;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzd() {
        return this.zzz;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zze() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.Game
    public final String zzf() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzg() {
        return this.zzp;
    }

    @Override // com.google.android.gms.games.Game
    public final boolean zzh() {
        return this.zzq;
    }

    @Override // com.google.android.gms.games.Game
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Game
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zze, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzf, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.Game
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    public GameEntity(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Uri uri2, Uri uri3, boolean z, boolean z2, String str7, int i, int i2, int i3, boolean z3, boolean z4, String str8, String str9, String str10, boolean z5, boolean z6, boolean z7, String str11, boolean z8, boolean z9) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = uri;
        this.zzr = str8;
        this.zzh = uri2;
        this.zzs = str9;
        this.zzi = uri3;
        this.zzt = str10;
        this.zzj = z;
        this.zzk = z2;
        this.zzl = str7;
        this.zzm = i;
        this.zzn = i2;
        this.zzo = i3;
        this.zzp = z3;
        this.zzq = z4;
        this.zzu = z5;
        this.zzv = z6;
        this.zzw = z7;
        this.zzx = str11;
        this.zzy = z8;
        this.zzz = z9;
    }
}
