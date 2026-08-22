package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import kotlin.io.CloseableKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzzd extends AbstractSafeParcelable implements zzxn<zzzd> {
    public static final Parcelable.Creator<zzzd> CREATOR = new zzze();
    private static final String zza = "zzzd";
    private String zzb;
    private boolean zzc;
    private String zzd;
    private boolean zze;
    private zzaaw zzf;
    private List zzg;

    public zzzd() {
        this.zzf = new zzaaw(null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        boolean z = this.zzc;
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        boolean z2 = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(z2 ? 1 : 0);
        CloseableKt.writeParcelable(parcel, 6, this.zzf, i, false);
        CloseableKt.writeStringList(parcel, 7, this.zzg);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", null);
            this.zzc = jSONObject.optBoolean("registered", false);
            this.zzd = jSONObject.optString("providerId", null);
            this.zze = jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzf = new zzaaw(1, zzabk.zzb(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzf = new zzaaw(null);
            }
            this.zzg = zzabk.zzb(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException e) {
            e = e;
            throw zzabk.zza(e, zza, str);
        } catch (JSONException e2) {
            e = e2;
            throw zzabk.zza(e, zza, str);
        }
    }

    public final List zzb() {
        return this.zzg;
    }

    public zzzd(String str, boolean z, String str2, boolean z2, zzaaw zzaawVar, List list) {
        zzaaw zzaawVarZza;
        this.zzb = str;
        this.zzc = z;
        this.zzd = str2;
        this.zze = z2;
        if (zzaawVar == null) {
            zzaawVarZza = new zzaaw(null);
        } else {
            zzaawVarZza = zzaaw.zza(zzaawVar);
        }
        this.zzf = zzaawVarZza;
        this.zzg = list;
    }
}
