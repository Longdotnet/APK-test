package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface Game extends Parcelable {
    boolean areSnapshotsEnabled();

    /* synthetic */ Object freeze();

    int getAchievementTotalCount();

    String getApplicationId();

    String getDescription();

    void getDescription(CharArrayBuffer charArrayBuffer);

    String getDeveloperName();

    void getDeveloperName(CharArrayBuffer charArrayBuffer);

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getFeaturedImageUri();

    @Deprecated
    String getFeaturedImageUrl();

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    int getLeaderboardCount();

    String getPrimaryCategory();

    String getSecondaryCategory();

    String getThemeColor();

    boolean hasGamepadSupport();

    /* synthetic */ boolean isDataValid();

    boolean zza();

    boolean zzb();

    boolean zzc();

    boolean zzd();

    boolean zze();

    String zzf();

    @Deprecated
    boolean zzg();

    @Deprecated
    boolean zzh();
}
