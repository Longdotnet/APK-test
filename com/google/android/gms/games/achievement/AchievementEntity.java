package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class AchievementEntity extends zzg implements Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final Uri zze;
    public final String zzf;
    public final Uri zzg;
    public final String zzh;
    public final int zzi;
    public final String zzj;
    public final PlayerEntity zzk;
    public final int zzl;
    public final int zzm;
    public final String zzn;
    public final long zzo;
    public final long zzp;
    public final float zzq;
    public final String zzr;

    public AchievementEntity(Achievement achievement) {
        String achievementId = achievement.getAchievementId();
        this.zza = achievementId;
        this.zzb = achievement.getType();
        this.zzc = achievement.getName();
        String description = achievement.getDescription();
        this.zzd = description;
        this.zze = achievement.getUnlockedImageUri();
        this.zzf = achievement.getUnlockedImageUrl();
        this.zzg = achievement.getRevealedImageUri();
        this.zzh = achievement.getRevealedImageUrl();
        Player playerZzb = achievement.zzb();
        if (playerZzb != null) {
            this.zzk = new PlayerEntity(playerZzb);
        } else {
            this.zzk = null;
        }
        this.zzl = achievement.getState();
        this.zzo = achievement.getLastUpdatedTimestamp();
        this.zzp = achievement.getXpValue();
        this.zzq = achievement.zzc();
        this.zzr = achievement.zza();
        if (achievement.getType() == 1) {
            this.zzi = achievement.getTotalSteps();
            this.zzj = achievement.getFormattedTotalSteps();
            this.zzm = achievement.getCurrentSteps();
            this.zzn = achievement.getFormattedCurrentSteps();
        } else {
            this.zzi = 0;
            this.zzj = null;
            this.zzm = 0;
            this.zzn = null;
        }
        if (achievementId == null) {
            throw new IllegalArgumentException("null reference");
        }
        if (description == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static int zzd(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            currentSteps = 0;
            totalSteps = 0;
        }
        return Arrays.hashCode(new Object[]{achievement.getAchievementId(), achievement.zza(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzb(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps)});
    }

    public static boolean zze(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && zzah.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzah.equal(achievement2.zza(), achievement.zza()) && zzah.equal(achievement2.getName(), achievement.getName()) && zzah.equal(achievement2.getDescription(), achievement.getDescription()) && zzah.equal(achievement2.zzb(), achievement.zzb()) && achievement2.zzc() == achievement.zzc();
    }

    public boolean equals(Object obj) {
        return zze(this, obj);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getAchievementId() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        zzah.checkState(getType() == 1);
        return this.zzm;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getDescription() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedCurrentSteps() {
        zzah.checkState(getType() == 1);
        return this.zzn;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedTotalSteps() {
        zzah.checkState(getType() == 1);
        return this.zzj;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getName() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Player getPlayer() {
        PlayerEntity playerEntity = this.zzk;
        zzah.checkNotNull(playerEntity);
        return playerEntity;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getRevealedImageUri() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        zzah.checkState(getType() == 1);
        return this.zzi;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getUnlockedImageUri() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzp;
    }

    public int hashCode() {
        return zzd(this);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzf(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getAchievementId(), false);
        int type = getType();
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(type);
        CloseableKt.writeString(parcel, 3, getName(), false);
        CloseableKt.writeString(parcel, 4, getDescription(), false);
        CloseableKt.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        CloseableKt.writeString(parcel, 6, getUnlockedImageUrl(), false);
        CloseableKt.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        CloseableKt.writeString(parcel, 8, getRevealedImageUrl(), false);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzi);
        CloseableKt.writeString(parcel, 10, this.zzj, false);
        CloseableKt.writeParcelable(parcel, 11, this.zzk, i, false);
        int state = getState();
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(state);
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(this.zzm);
        CloseableKt.writeString(parcel, 14, this.zzn, false);
        long lastUpdatedTimestamp = getLastUpdatedTimestamp();
        CloseableKt.zzc(parcel, 15, 8);
        parcel.writeLong(lastUpdatedTimestamp);
        long xpValue = getXpValue();
        CloseableKt.zzc(parcel, 16, 8);
        parcel.writeLong(xpValue);
        CloseableKt.zzc(parcel, 17, 4);
        parcel.writeFloat(this.zzq);
        CloseableKt.writeString(parcel, 18, this.zzr, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final String zza() {
        return this.zzr;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zzc() {
        return this.zzq;
    }

    public static String zzf(Achievement achievement) {
        zzz zzzVar = new zzz(achievement);
        zzzVar.add(achievement.getAchievementId(), "Id");
        zzzVar.add(achievement.zza(), "Game Id");
        zzzVar.add(Integer.valueOf(achievement.getType()), "Type");
        zzzVar.add(achievement.getName(), "Name");
        zzzVar.add(achievement.getDescription(), nYVxXTZQ.qebzTEeowDNN);
        zzzVar.add(achievement.zzb(), eoBKjVuj.VgcjUWdrNLRDSS);
        zzzVar.add(Integer.valueOf(achievement.getState()), "State");
        zzzVar.add(Float.valueOf(achievement.zzc()), "Rarity Percent");
        if (achievement.getType() == 1) {
            zzzVar.add(Integer.valueOf(achievement.getCurrentSteps()), "CurrentSteps");
            zzzVar.add(Integer.valueOf(achievement.getTotalSteps()), "TotalSteps");
        }
        return zzzVar.toString();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzd, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        zzah.checkState(getType() == 1);
        Hex.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        zzah.checkState(getType() == 1);
        Hex.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getName(CharArrayBuffer charArrayBuffer) {
        Hex.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    public AchievementEntity(String str, int i, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i2, String str6, PlayerEntity playerEntity, int i3, int i4, String str7, long j, long j2, float f, String str8) {
        this.zza = str;
        this.zzb = i;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = uri2;
        this.zzh = str5;
        this.zzi = i2;
        this.zzj = str6;
        this.zzk = playerEntity;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = str7;
        this.zzo = j;
        this.zzp = j2;
        this.zzq = f;
        this.zzr = str8;
    }
}
