package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzy extends AbstractSafeParcelable implements zzxn<zzzy> {
    public static final Parcelable.Creator<zzzy> CREATOR = new zzzz();
    private static final String zza = "zzzy";
    private String zzb;
    private String zzc;
    private Long zzd;
    private String zze;
    private Long zzf;

    public zzzy() {
        this.zzf = Long.valueOf(System.currentTimeMillis());
    }

    public static zzzy zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzzy zzzyVar = new zzzy();
            zzzyVar.zzb = jSONObject.optString("refresh_token", null);
            zzzyVar.zzc = jSONObject.optString("access_token", null);
            zzzyVar.zzd = Long.valueOf(jSONObject.optLong("expires_in"));
            zzzyVar.zze = jSONObject.optString("token_type", null);
            zzzyVar.zzf = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzzyVar;
        } catch (JSONException e) {
            Log.d(zza, "Failed to read GetTokenResponse from JSONObject");
            throw new zzqx(e);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeLongObject(parcel, 4, Long.valueOf(zzb()));
        CloseableKt.writeString(parcel, 5, this.zze, false);
        Long l = this.zzf;
        l.getClass();
        CloseableKt.writeLongObject(parcel, 6, l);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("refresh_token"));
            this.zzc = Strings.emptyToNull(jSONObject.optString("access_token"));
            this.zzd = Long.valueOf(jSONObject.optLong("expires_in", 0L));
            this.zze = Strings.emptyToNull(jSONObject.optString("token_type"));
            this.zzf = Long.valueOf(System.currentTimeMillis());
            return this;
        } catch (NullPointerException | JSONException e) {
            throw zzabk.zza(e, zza, str);
        }
    }

    public final long zzb() {
        Long l = this.zzd;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final long zzc() {
        return this.zzf.longValue();
    }

    public final String zze() {
        return this.zzc;
    }

    public final String zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zze;
    }

    public final void zzi(String str) {
        zzah.checkNotEmpty(str);
        this.zzb = str;
    }

    public final boolean zzj() {
        return System.currentTimeMillis() + 300000 < (this.zzd.longValue() * 1000) + this.zzf.longValue();
    }

    public final String zzh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(wsbWxekY.JMqd, this.zzb);
            jSONObject.put("access_token", this.zzc);
            jSONObject.put("expires_in", this.zzd);
            jSONObject.put("token_type", this.zze);
            jSONObject.put("issued_at", this.zzf);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d(zza, "Failed to convert GetTokenResponse to JSON");
            throw new zzqx(e);
        }
    }

    public zzzy(String str, String str2, Long l, String str3, Long l2) {
        this.zzb = str;
        this.zzc = str2;
        this.zzd = l;
        this.zze = str3;
        this.zzf = l2;
    }

    public zzzy(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }
}
