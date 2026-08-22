package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.drive.zza;
import com.google.android.gms.dynamic.ObjectWrapper;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zza(21);
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final Context zzd;
    public final boolean zze;
    public final boolean zzf;

    public zzo(String str, boolean z, boolean z2, IBinder iBinder, boolean z3, boolean z4) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = (Context) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder));
        this.zze = z3;
        this.zzf = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        CloseableKt.writeIBinder(parcel, 4, new ObjectWrapper(this.zzd));
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zzf ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }
}
