package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzp implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzp> CREATOR = new zzq();
    public final String zza;
    public final String zzb;
    public final Map zzc;
    public final boolean zzd;

    public zzp(boolean z) {
        this.zzd = z;
        this.zzb = null;
        this.zza = null;
        this.zzc = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final Map<String, Object> getProfile() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final String getProviderId() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final String getUsername() {
        if ("github.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.zza)) {
            return (String) this.zzc.get(FirebaseAnalytics.Param.SCREEN_NAME);
        }
        return null;
    }

    @Override // com.google.firebase.auth.AdditionalUserInfo
    public final boolean isNewUser() {
        return this.zzd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        boolean z = this.zzd;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    public zzp(String str, String str2, boolean z) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzaz.zzc(str2);
        this.zzd = z;
    }
}
