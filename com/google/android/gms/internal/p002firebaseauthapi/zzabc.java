package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Strings;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzabc extends AbstractSafeParcelable implements zzxn<zzabc> {
    public static final Parcelable.Creator<zzabc> CREATOR = new zzabd();
    private static final String zza = "zzabc";
    private String zzb;
    private String zzc;
    private long zzd;
    private boolean zze;

    public zzabc() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        long j = this.zzd;
        CloseableKt.zzc(parcel, 4, 8);
        parcel.writeLong(j);
        boolean z = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzd = jSONObject.optLong("expiresIn", 0L);
            this.zze = jSONObject.optBoolean("isNewUser", false);
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzabk.zza(e, zza, str);
        }
    }

    public final long zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zze;
    }

    public zzabc(String str, String str2, long j, boolean z) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zze = z;
    }
}
