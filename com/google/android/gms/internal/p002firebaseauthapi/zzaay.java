package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.firebase.auth.internal.zzi;
import kotlin.io.CloseableKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaay extends AbstractSafeParcelable implements zzxm {
    public static final Parcelable.Creator<zzaay> CREATOR = new zzaaz();
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private String zzn;
    private boolean zzo;
    private String zzp;

    public zzaay() {
        this.zzi = true;
        this.zzj = true;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zza, false);
        CloseableKt.writeString(parcel, 3, this.zzb, false);
        CloseableKt.writeString(parcel, 4, this.zzc, false);
        CloseableKt.writeString(parcel, 5, this.zzd, false);
        CloseableKt.writeString(parcel, 6, this.zze, false);
        CloseableKt.writeString(parcel, 7, this.zzf, false);
        CloseableKt.writeString(parcel, 8, this.zzg, false);
        CloseableKt.writeString(parcel, 9, this.zzh, false);
        boolean z = this.zzi;
        CloseableKt.zzc(parcel, 10, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.zzj;
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeString(parcel, 12, this.zzk, false);
        CloseableKt.writeString(parcel, 13, this.zzl, false);
        CloseableKt.writeString(parcel, 14, this.zzm, false);
        CloseableKt.writeString(parcel, 15, this.zzn, false);
        boolean z3 = this.zzo;
        CloseableKt.zzc(parcel, 16, 4);
        parcel.writeInt(z3 ? 1 : 0);
        CloseableKt.writeString(parcel, 17, this.zzp, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final zzaay zzb(boolean z) {
        this.zzj = false;
        return this;
    }

    public final zzaay zzc(String str) {
        zzah.checkNotEmpty(str);
        this.zzb = str;
        return this;
    }

    public final zzaay zzd(boolean z) {
        this.zzo = true;
        return this;
    }

    public final zzaay zze(boolean z) {
        this.zzi = true;
        return this;
    }

    public final zzaay zzf(String str) {
        this.zzn = str;
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoCreate", this.zzj);
        jSONObject.put("returnSecureToken", this.zzi);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        String str2 = this.zzg;
        if (str2 != null) {
            jSONObject.put(TSDAbK.tChIamWR, str2);
        }
        String str3 = this.zzn;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzp;
        if (str4 != null) {
            jSONObject.put("pendingToken", str4);
        }
        if (!TextUtils.isEmpty(this.zzl)) {
            jSONObject.put("sessionId", this.zzl);
        }
        if (TextUtils.isEmpty(this.zzm)) {
            String str5 = this.zza;
            if (str5 != null) {
                jSONObject.put("requestUri", str5);
            }
        } else {
            jSONObject.put("requestUri", this.zzm);
        }
        jSONObject.put("returnIdpCredential", this.zzo);
        return jSONObject.toString();
    }

    public zzaay(zzi zziVar, String str) {
        zzah.checkNotNull(zziVar);
        String strZzd = zziVar.zzd();
        zzah.checkNotEmpty(strZzd);
        this.zzl = strZzd;
        zzah.checkNotEmpty(str);
        this.zzm = str;
        String strZzc = zziVar.zzc();
        zzah.checkNotEmpty(strZzc);
        this.zze = strZzc;
        this.zzi = true;
        this.zzg = "providerId=".concat(String.valueOf(strZzc));
    }

    public zzaay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.zza = "http://localhost";
        this.zzc = str;
        this.zzd = str2;
        this.zzh = str5;
        this.zzk = str6;
        this.zzn = str7;
        this.zzp = str8;
        this.zzi = true;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(this.zzd) && TextUtils.isEmpty(this.zzk)) {
            throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
        }
        zzah.checkNotEmpty(str3);
        this.zze = str3;
        this.zzf = null;
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.zzc)) {
            sb.append("id_token=");
            sb.append(this.zzc);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzd)) {
            sb.append("access_token=");
            sb.append(this.zzd);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzf)) {
            sb.append("identifier=");
            sb.append(this.zzf);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            sb.append("oauth_token_secret=");
            sb.append(this.zzh);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.zzk)) {
            sb.append("code=");
            sb.append(this.zzk);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(str9)) {
            sb.append("nonce=");
            sb.append(str9);
            sb.append("&");
        }
        sb.append("providerId=");
        sb.append(this.zze);
        this.zzg = sb.toString();
        this.zzj = true;
    }

    public zzaay(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, boolean z2, String str9, String str10, String str11, String str12, boolean z3, String str13) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = str9;
        this.zzl = str10;
        this.zzm = str11;
        this.zzn = str12;
        this.zzo = z3;
        this.zzp = str13;
    }
}
