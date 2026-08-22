package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.internal.p002firebaseauthapi.zzqx;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PhoneMultiFactorInfo extends MultiFactorInfo {
    public static final Parcelable.Creator<PhoneMultiFactorInfo> CREATOR = new zzai();
    private final String zza;
    private final String zzb;
    private final long zzc;
    private final String zzd;

    public PhoneMultiFactorInfo(String str, String str2, long j, String str3) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str3);
        this.zzd = str3;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getDisplayName() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public long getEnrollmentTimestamp() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getFactorId() {
        return "phone";
    }

    public String getPhoneNumber() {
        return this.zzd;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.MultiFactorInfo
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(MultiFactorInfo.FACTOR_ID_KEY, "phone");
            jSONObject.putOpt("uid", this.zza);
            jSONObject.putOpt("displayName", this.zzb);
            jSONObject.putOpt("enrollmentTimestamp", Long.valueOf(this.zzc));
            jSONObject.putOpt("phoneNumber", this.zzd);
            return jSONObject;
        } catch (JSONException e) {
            Log.d("PhoneMultiFactorInfo", "Failed to jsonify this object");
            throw new zzqx(e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getUid(), false);
        CloseableKt.writeString(parcel, 2, getDisplayName(), false);
        long enrollmentTimestamp = getEnrollmentTimestamp();
        CloseableKt.zzc(parcel, 3, 8);
        parcel.writeLong(enrollmentTimestamp);
        CloseableKt.writeString(parcel, 4, getPhoneNumber(), false);
        CloseableKt.zzb(parcel, iZza);
    }
}
