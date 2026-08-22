package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.zzg;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class ExperienceEventEntity extends zzg implements ExperienceEvent {
    public static final Parcelable.Creator<ExperienceEventEntity> CREATOR = new zza();
    public final String zza;
    public final GameEntity zzb;
    public final String zzc;
    public final String zzd;
    public final String zze;
    public final Uri zzf;
    public final long zzg;
    public final long zzh;
    public final long zzi;
    public final int zzj;
    public final int zzk;

    public ExperienceEventEntity(String str, GameEntity gameEntity, String str2, String str3, String str4, Uri uri, long j, long j2, long j3, int i, int i2) {
        this.zza = str;
        this.zzb = gameEntity;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = str4;
        this.zzf = uri;
        this.zzg = j;
        this.zzh = j2;
        this.zzi = j3;
        this.zzj = i;
        this.zzk = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExperienceEvent)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ExperienceEvent experienceEvent = (ExperienceEvent) obj;
        return zzah.equal(experienceEvent.zza(), this.zza) && zzah.equal(experienceEvent.zzb(), this.zzb) && zzah.equal(experienceEvent.zzc(), this.zzc) && zzah.equal(experienceEvent.zzd(), this.zzd) && zzah.equal(experienceEvent.getIconImageUrl(), getIconImageUrl()) && zzah.equal(experienceEvent.zze(), this.zzf) && zzah.equal(Long.valueOf(experienceEvent.zzf()), Long.valueOf(this.zzg)) && zzah.equal(Long.valueOf(experienceEvent.zzg()), Long.valueOf(this.zzh)) && zzah.equal(Long.valueOf(experienceEvent.zzh()), Long.valueOf(this.zzi)) && zzah.equal(Integer.valueOf(experienceEvent.zzi()), Integer.valueOf(this.zzj)) && zzah.equal(Integer.valueOf(experienceEvent.zzj()), Integer.valueOf(this.zzk));
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public String getIconImageUrl() {
        return this.zze;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, getIconImageUrl(), this.zzf, Long.valueOf(this.zzg), Long.valueOf(this.zzh), Long.valueOf(this.zzi), Integer.valueOf(this.zzj), Integer.valueOf(this.zzk)});
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeString(parcel, 5, getIconImageUrl(), false);
        CloseableKt.writeParcelable(parcel, 6, this.zzf, i, false);
        CloseableKt.zzc(parcel, 7, 8);
        parcel.writeLong(this.zzg);
        CloseableKt.zzc(parcel, 8, 8);
        parcel.writeLong(this.zzh);
        CloseableKt.zzc(parcel, 9, 8);
        parcel.writeLong(this.zzi);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(this.zzj);
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(this.zzk);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Game zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final String zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final Uri zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzg() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final long zzh() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzi() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.internal.experience.ExperienceEvent
    public final int zzj() {
        return this.zzk;
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zza, "ExperienceId");
        zzzVar.add(this.zzb, "Game");
        zzzVar.add(this.zzc, "DisplayTitle");
        zzzVar.add(this.zzd, "DisplayDescription");
        zzzVar.add(getIconImageUrl(), "IconImageUrl");
        zzzVar.add(this.zzf, "IconImageUri");
        zzzVar.add(Long.valueOf(this.zzg), "CreatedTimestamp");
        zzzVar.add(Long.valueOf(this.zzh), "XpEarned");
        zzzVar.add(Long.valueOf(this.zzi), "CurrentXp");
        zzzVar.add(Integer.valueOf(this.zzj), sgtsHsWT.upzfKgiejr);
        zzzVar.add(Integer.valueOf(this.zzk), "NewLevel");
        return zzzVar.toString();
    }
}
