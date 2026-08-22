package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends com.google.android.gms.games.internal.zzg {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();
    private final Bundle zza;
    private final IBinder zzb;

    public zzaf(Bundle bundle, IBinder iBinder) {
        this.zza = bundle;
        this.zzb = iBinder;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = this.zza;
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeBundle(parcel, 1, bundle, false);
        CloseableKt.writeIBinder(parcel, 2, this.zzb);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzaf(zzae zzaeVar) {
        this.zza = zzaeVar.zza();
        this.zzb = zzaeVar.zza;
    }
}
