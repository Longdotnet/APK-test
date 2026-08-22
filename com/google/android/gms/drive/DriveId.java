package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class DriveId extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zza(24);
    public final String zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == DriveId.class) {
            DriveId driveId = (DriveId) obj;
            if (driveId.zzc != this.zzc) {
                return false;
            }
            long j = driveId.zzb;
            String str = this.zza;
            long j2 = this.zzb;
            String str2 = driveId.zza;
            if (j == -1) {
                if (j2 == -1) {
                    zzah.checkNotNull(str2);
                    return str2.equals(str);
                }
                j = -1;
            }
            if (str != null && str2 != null) {
                return j == j2 && str2.equals(str);
            }
            if (j == j2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zzb;
        if (j == -1) {
            String str = this.zza;
            zzah.checkNotNull(str);
            return str.hashCode();
        }
        String strValueOf = String.valueOf(j);
        long j2 = this.zzc;
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + String.valueOf(strValueOf).length());
        sb.append(j2);
        sb.append(strValueOf);
        return sb.toString().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(this.zzb);
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(this.zzc);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }

    public DriveId(int i, String str, long j, long j2) {
        this.zza = str;
        boolean z = true;
        zzah.checkArgument(!TSDAbK.HQKhegaSsVyT.equals(str));
        if (str == null && j == -1) {
            z = false;
            j = -1;
        }
        zzah.checkArgument(z);
        this.zzb = j;
        this.zzc = j2;
        this.zzd = i;
    }
}
