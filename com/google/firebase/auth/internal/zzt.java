package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.internal.p002firebaseauthapi.zzaae;
import com.google.android.gms.internal.p002firebaseauthapi.zzqx;
import com.google.android.gms.internal.p002firebaseauthapi.zzzr;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.UserInfo;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzt extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public String zzd;
    public Uri zze;
    public final String zzf;
    public final String zzg;
    public final boolean zzh;
    public final String zzi;

    public zzt(zzaae zzaaeVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzaaeVar);
        this.zza = zzaaeVar.zzd();
        String strZzf = zzaaeVar.zzf();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
        this.zzb = strZzf;
        this.zzc = zzaaeVar.zzb();
        Uri uriZza = zzaaeVar.zza();
        if (uriZza != null) {
            this.zzd = uriZza.toString();
            this.zze = uriZza;
        }
        this.zzf = zzaaeVar.zzc();
        this.zzg = zzaaeVar.zze();
        this.zzh = false;
        this.zzi = zzaaeVar.zzg();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getDisplayName() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getEmail() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getPhoneNumber() {
        return this.zzg;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getProviderId() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final String getUid() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeString(parcel, 5, this.zzf, false);
        CloseableKt.writeString(parcel, 6, this.zzg, false);
        boolean z = this.zzh;
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 8, this.zzi, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zza() {
        return this.zzi;
    }

    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d(oKjScaD.HygCJwtxMl, "Failed to jsonify this object");
            throw new zzqx(e);
        }
    }

    public zzt(zzzr zzzrVar, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzzrVar);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(FirebaseAuthProvider.PROVIDER_ID);
        String strZzo = zzzrVar.zzo();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzo);
        this.zza = strZzo;
        this.zzb = FirebaseAuthProvider.PROVIDER_ID;
        this.zzf = zzzrVar.zzn();
        this.zzc = zzzrVar.zzm();
        Uri uriZzc = zzzrVar.zzc();
        if (uriZzc != null) {
            this.zzd = uriZzc.toString();
            this.zze = uriZzc;
        }
        this.zzh = zzzrVar.zzs();
        this.zzi = null;
        this.zzg = zzzrVar.zzp();
    }

    public zzt(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(str6)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }
}
