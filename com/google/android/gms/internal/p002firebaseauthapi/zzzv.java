package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.zzah;
import com.google.firebase.auth.ActionCodeSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzzv implements zzxm {
    private final String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    private String zzf;

    public zzzv(int i) {
        this.zza = i != 1 ? i != 4 ? i != 6 ? i != 7 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_AND_CHANGE_EMAIL" : "EMAIL_SIGNIN" : "VERIFY_EMAIL" : "PASSWORD_RESET";
    }

    public static zzzv zzc(ActionCodeSettings actionCodeSettings, String str, String str2) {
        zzah.checkNotEmpty(str);
        zzah.checkNotEmpty(str2);
        zzah.checkNotNull(actionCodeSettings);
        return new zzzv(7, actionCodeSettings, null, str2, str, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxm
    public final String zza() {
        byte b;
        JSONObject jSONObject = new JSONObject();
        int i = 0;
        switch (this.zza) {
            case "PASSWORD_RESET":
                b = 0;
                break;
            case "VERIFY_EMAIL":
                b = 1;
                break;
            case "VERIFY_AND_CHANGE_EMAIL":
                b = 3;
                break;
            case "EMAIL_SIGNIN":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            i = 1;
        } else if (b == 1) {
            i = 4;
        } else if (b == 2) {
            i = 6;
        } else if (b == 3) {
            i = 7;
        }
        jSONObject.put("requestType", i);
        String str = this.zzb;
        if (str != null) {
            jSONObject.put("email", str);
        }
        String str2 = this.zzc;
        if (str2 != null) {
            jSONObject.put("newEmail", str2);
        }
        String str3 = this.zzd;
        if (str3 != null) {
            jSONObject.put("idToken", str3);
        }
        ActionCodeSettings actionCodeSettings = this.zze;
        if (actionCodeSettings != null) {
            jSONObject.put("androidInstallApp", actionCodeSettings.getAndroidInstallApp());
            jSONObject.put("canHandleCodeInApp", this.zze.canHandleCodeInApp());
            if (this.zze.getUrl() != null) {
                jSONObject.put("continueUrl", this.zze.getUrl());
            }
            if (this.zze.getIOSBundle() != null) {
                jSONObject.put("iosBundleId", this.zze.getIOSBundle());
            }
            if (this.zze.zzd() != null) {
                jSONObject.put("iosAppStoreId", this.zze.zzd());
            }
            if (this.zze.getAndroidPackageName() != null) {
                jSONObject.put("androidPackageName", this.zze.getAndroidPackageName());
            }
            if (this.zze.getAndroidMinimumVersion() != null) {
                jSONObject.put("androidMinimumVersion", this.zze.getAndroidMinimumVersion());
            }
            if (this.zze.zzc() != null) {
                jSONObject.put("dynamicLinkDomain", this.zze.zzc());
            }
        }
        String str4 = this.zzf;
        if (str4 != null) {
            jSONObject.put("tenantId", str4);
        }
        return jSONObject.toString();
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    public final zzzv zzd(ActionCodeSettings actionCodeSettings) {
        zzah.checkNotNull(actionCodeSettings);
        this.zze = actionCodeSettings;
        return this;
    }

    public final zzzv zze(String str) {
        zzah.checkNotEmpty(str);
        this.zzb = str;
        return this;
    }

    public final zzzv zzf(String str) {
        this.zzf = str;
        return this;
    }

    public final zzzv zzg(String str) {
        zzah.checkNotEmpty(str);
        this.zzd = str;
        return this;
    }

    private zzzv(int i, ActionCodeSettings actionCodeSettings, String str, String str2, String str3, String str4) {
        this.zza = "VERIFY_AND_CHANGE_EMAIL";
        zzah.checkNotNull(actionCodeSettings);
        this.zze = actionCodeSettings;
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
    }
}
