package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class BeginSignInResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInResult> CREATOR = new zza(12);
    public final PendingIntent zba;

    public BeginSignInResult(PendingIntent pendingIntent) {
        zzah.checkNotNull(pendingIntent);
        this.zba = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zba, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
