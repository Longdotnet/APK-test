package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.games.zzr;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class ProfileSettingsEntity extends com.google.android.gms.games.internal.zzg implements zzr {
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zzg();
    public final Status zza;
    public final String zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final boolean zze;
    public final StockProfileImageEntity zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzh zzo;
    public final Boolean zzp;

    public ProfileSettingsEntity(Status status, String str, boolean z, boolean z2, boolean z3, StockProfileImageEntity stockProfileImageEntity, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, int i3, boolean z8, zzh zzhVar, Boolean bool) {
        this.zza = status;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = z3;
        this.zzf = stockProfileImageEntity;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = i;
        this.zzj = z6;
        this.zzk = z7;
        this.zzl = i2;
        this.zzm = i3;
        this.zzn = z8;
        this.zzo = zzhVar;
        this.zzp = bool;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzr)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzr zzrVar = (zzr) obj;
        return zzah.equal(this.zzb, zzrVar.zzc()) && zzah.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzrVar.zze())) && zzah.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzrVar.zza())) && zzah.equal(Boolean.valueOf(this.zze), Boolean.valueOf(zzrVar.zzb())) && zzah.equal(this.zza, zzrVar.getStatus()) && zzah.equal(this.zzf, zzrVar.zzd()) && zzah.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(zzrVar.zzf())) && zzah.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzrVar.zzg())) && this.zzi == zzrVar.zzj() && this.zzj == zzrVar.zzh() && this.zzk == zzrVar.zzi() && this.zzl == zzrVar.zzk() && this.zzm == zzrVar.zzl() && this.zzn == zzrVar.zzm() && zzah.equal(this.zzp, zzrVar.zzo()) && zzah.equal(this.zzo, zzrVar.zzn());
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zza, this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), Boolean.valueOf(this.zzn), this.zzo, this.zzp});
    }

    public final String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(this.zzb, "GamerTag");
        zzzVar.add(Boolean.valueOf(this.zzc), "IsGamerTagExplicitlySet");
        zzzVar.add(Boolean.valueOf(this.zzd), "IsProfileVisible");
        zzzVar.add(Boolean.valueOf(this.zze), "IsVisibilityExplicitlySet");
        zzzVar.add(this.zza, "Status");
        zzzVar.add(this.zzf, "StockProfileImage");
        zzzVar.add(Boolean.valueOf(this.zzg), "IsProfileDiscoverable");
        zzzVar.add(Boolean.valueOf(this.zzh), "AutoSignIn");
        zzzVar.add(Integer.valueOf(this.zzi), "httpErrorCode");
        zzzVar.add(Boolean.valueOf(this.zzj), "IsSettingsChangesProhibited");
        zzzVar.add(Boolean.valueOf(this.zzk), "AllowFriendInvites");
        zzzVar.add(Integer.valueOf(this.zzl), "ProfileVisibility");
        zzzVar.add(Integer.valueOf(this.zzm), "global_friends_list_visibility");
        zzzVar.add(Boolean.valueOf(this.zzn), "always_auto_sign_in");
        zzzVar.add(this.zzo, "profileless_recall_summary");
        zzzVar.add(this.zzp, "games_streaks_enabled");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd ? 1 : 0);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 6, this.zzf, i, false);
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(this.zzg ? 1 : 0);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zzh ? 1 : 0);
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(this.zzi);
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(this.zzj ? 1 : 0);
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(this.zzk ? 1 : 0);
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(this.zzl);
        CloseableKt.zzc(parcel, 13, 4);
        parcel.writeInt(this.zzm);
        CloseableKt.zzc(parcel, 14, 4);
        parcel.writeInt(this.zzn ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 15, this.zzo, i, false);
        CloseableKt.writeBooleanObject(parcel, 16, this.zzp);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.games.zzr
    public final String zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.zzr
    public final StockProfileImage zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzg() {
        return this.zzh;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzh() {
        return this.zzj;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzi() {
        return this.zzk;
    }

    @Override // com.google.android.gms.games.zzr
    public final int zzj() {
        return this.zzi;
    }

    @Override // com.google.android.gms.games.zzr
    public final int zzk() {
        return this.zzl;
    }

    @Override // com.google.android.gms.games.zzr
    public final int zzl() {
        return this.zzm;
    }

    @Override // com.google.android.gms.games.zzr
    public final boolean zzm() {
        return this.zzn;
    }

    @Override // com.google.android.gms.games.zzr
    public final zzh zzn() {
        return this.zzo;
    }

    @Override // com.google.android.gms.games.zzr
    public final Boolean zzo() {
        return this.zzp;
    }
}
