package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza(0);
    public final int zza;
    public final long zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final String zzf;

    public AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.zza = i;
        this.zzb = j;
        zzah.checkNotNull(str);
        this.zzc = str;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.zza == accountChangeEvent.zza && this.zzb == accountChangeEvent.zzb && zzah.equal(this.zzc, accountChangeEvent.zzc) && this.zzd == accountChangeEvent.zzd && this.zze == accountChangeEvent.zze && zzah.equal(this.zzf, accountChangeEvent.zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf});
    }

    public final String toString() {
        String str;
        int i = this.zzd;
        if (i == 1) {
            str = "ADDED";
        } else if (i == 2) {
            str = "REMOVED";
        } else if (i != 3) {
            str = i != 4 ? "UNKNOWN" : "RENAMED_TO";
        } else {
            str = "RENAMED_FROM";
        }
        String str2 = this.zzc;
        int length = String.valueOf(str2).length();
        int length2 = str.length();
        String str3 = this.zzf;
        StringBuilder sb = new StringBuilder(length + 91 + length2 + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(this.zze);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(this.zzb);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        CloseableKt.writeString(parcel, 6, this.zzf, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
