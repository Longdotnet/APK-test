package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzz implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    public final long zza;
    public final long zzb;

    public zzz(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getCreationTimestamp() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.FirebaseUserMetadata
    public final long getLastSignInTimestamp() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        long j = this.zza;
        CloseableKt.zzc(parcel, 1, 8);
        parcel.writeLong(j);
        long j2 = this.zzb;
        CloseableKt.zzc(parcel, 2, 8);
        parcel.writeLong(j2);
        CloseableKt.zzb(parcel, iZza);
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zza);
            jSONObject.put("creationTimestamp", this.zzb);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
