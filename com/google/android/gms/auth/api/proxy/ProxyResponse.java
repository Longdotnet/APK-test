package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zza(24);
    public final byte[] body;
    public final int googlePlayServicesStatusCode;
    public final PendingIntent recoveryAction;
    public final int statusCode;
    public final int zza;
    public final Bundle zzb;

    public ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.zza = i;
        this.googlePlayServicesStatusCode = i2;
        this.statusCode = i3;
        this.zzb = bundle;
        this.body = bArr;
        this.recoveryAction = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.googlePlayServicesStatusCode);
        CloseableKt.writeParcelable(parcel, 2, this.recoveryAction, i, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.statusCode);
        CloseableKt.writeBundle(parcel, 4, this.zzb, false);
        CloseableKt.writeByteArray(parcel, 5, this.body, false);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzb(parcel, iZza);
    }
}
