package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza(23);
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    public final int zza;
    public final Bundle zzb;

    public ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.zza = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzb = bundle;
    }

    public final String toString() {
        String str = this.url;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(this.httpMethod);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.url, false);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.httpMethod);
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(this.timeoutMillis);
        CloseableKt.writeByteArray(parcel, 4, this.body, false);
        CloseableKt.writeBundle(parcel, 5, this.zzb, false);
        CloseableKt.zzc(parcel, 1000, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzb(parcel, iZza);
    }
}
