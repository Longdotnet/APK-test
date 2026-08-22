package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    public final String zza;
    public final PersistableBundle zzb;
    public final Boolean zzc;
    public final Boolean zzd;

    public zzi(String str, PersistableBundle persistableBundle, Boolean bool, Boolean bool2) {
        this.zza = str;
        this.zzb = persistableBundle;
        this.zzc = bool;
        this.zzd = bool2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.writeBooleanObject(parcel, 3, this.zzc);
        CloseableKt.writeBooleanObject(parcel, 4, this.zzd);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zza() {
        return this.zza;
    }
}
