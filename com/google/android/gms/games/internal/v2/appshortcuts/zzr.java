package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public final long zza;
    public final String zzb;
    public final int zzc;
    public final ComponentName zzd;
    public final String zze;

    public zzr(long j, String str, int i, ComponentName componentName, String str2) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
        this.zzd = componentName;
        this.zze = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 8);
        parcel.writeLong(this.zza);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        CloseableKt.writeString(parcel, 5, this.zze, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zze;
    }
}
