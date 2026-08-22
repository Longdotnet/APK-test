package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzsm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsm> CREATOR = new zzsn();
    private final zzaay zza;

    public zzsm(zzaay zzaayVar) {
        this.zza = zzaayVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzaay zza() {
        return this.zza;
    }
}
