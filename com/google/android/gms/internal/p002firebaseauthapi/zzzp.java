package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.List;
import kotlin.io.CloseableKt;
import kotlinx.coroutines.internal.Jbo.ygoi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzp extends AbstractSafeParcelable implements zzxn<zzzp> {
    public static final Parcelable.Creator<zzzp> CREATOR = new zzzq();
    private static final String zza = "zzzp";
    private zzzt zzb;

    public zzzp() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final List zzb() {
        return this.zzb.zzb();
    }

    public zzzp(zzzt zzztVar) {
        this.zzb = zzztVar == null ? new zzzt() : zzzt.zza(zzztVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        zzzt zzztVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("users")) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("users");
                Parcelable.Creator<zzzt> creator = zzzt.CREATOR;
                if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                    zzztVar = new zzzt(new ArrayList());
                } else {
                    ArrayList arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                    boolean z = false;
                    int i = 0;
                    while (i < jSONArrayOptJSONArray.length()) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        arrayList.add(jSONObject2 == null ? new zzzr() : new zzzr(Strings.emptyToNull(jSONObject2.optString("localId", null)), Strings.emptyToNull(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z), Strings.emptyToNull(jSONObject2.optString(ygoi.uYuSNFHRKJe, null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", null)), zzaag.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", null)), Strings.emptyToNull(jSONObject2.optString("phoneNumber", null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzaac.zzf(jSONObject2.optJSONArray("mfaInfo"))));
                        i++;
                        z = false;
                    }
                    zzztVar = new zzzt(arrayList);
                }
                this.zzb = zzztVar;
            } else {
                this.zzb = new zzzt();
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
}
