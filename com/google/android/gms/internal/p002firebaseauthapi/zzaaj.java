package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Strings;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzaaj extends AbstractSafeParcelable implements zzxn<zzaaj> {
    public static final Parcelable.Creator<zzaaj> CREATOR = new zzaak();
    private static final String zza = "zzaaj";
    private String zzb;
    private String zzc;
    private String zzd;
    private zzaac zze;

    public zzaaj() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        CloseableKt.writeParcelable(parcel, 5, this.zze, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        String str2;
        byte b;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("email"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("newEmail"));
            int iOptInt = jSONObject.optInt("reqType");
            if (iOptInt != 1) {
                switch (iOptInt) {
                    case 4:
                        str2 = "VERIFY_EMAIL";
                        break;
                    case 5:
                        str2 = "RECOVER_EMAIL";
                        break;
                    case 6:
                        str2 = "EMAIL_SIGNIN";
                        break;
                    case 7:
                        str2 = "VERIFY_AND_CHANGE_EMAIL";
                        break;
                    case 8:
                        str2 = "REVERT_SECOND_FACTOR_ADDITION";
                        break;
                    default:
                        str2 = null;
                        break;
                }
            } else {
                str2 = "PASSWORD_RESET";
            }
            this.zzd = str2;
            if (TextUtils.isEmpty(str2)) {
                String strOptString = jSONObject.optString("requestType");
                switch (strOptString) {
                    case "REVERT_SECOND_FACTOR_ADDITION":
                        b = 5;
                        break;
                    case "PASSWORD_RESET":
                        b = 1;
                        break;
                    case "VERIFY_EMAIL":
                        b = 0;
                        break;
                    case "VERIFY_AND_CHANGE_EMAIL":
                        b = 3;
                        break;
                    case "EMAIL_SIGNIN":
                        b = 2;
                        break;
                    case "RECOVER_EMAIL":
                        b = 4;
                        break;
                    default:
                        b = -1;
                        break;
                }
                this.zzd = (b == 0 || b == 1 || b == 2 || b == 3 || b == 4 || b == 5) ? strOptString : null;
            }
            if (jSONObject.has("mfaInfo")) {
                this.zze = zzaac.zzb(jSONObject.optJSONObject("mfaInfo"));
            }
            return this;
        } catch (NullPointerException e) {
            e = e;
            throw zzabk.zza(e, zza, str);
        } catch (JSONException e2) {
            e = e2;
            throw zzabk.zza(e, zza, str);
        }
    }

    public final zzaac zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zzb != null;
    }

    public final boolean zzg() {
        return this.zze != null;
    }

    public final boolean zzh() {
        return this.zzc != null;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    public zzaaj(String str, String str2, String str3, zzaac zzaacVar) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzaacVar;
    }
}
