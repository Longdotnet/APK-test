package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.io.CloseableKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab(0);
    public final int zab;
    public final ArrayList zac;
    public final String zad;
    public final String zae;
    public final String zaf;
    public final String zag;
    public final Uri zah;
    public String zai;
    public final long zaj;
    public final String zak;
    public final String zal;
    public final String zam;
    public final HashSet zan = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.zab = i;
        this.zad = str;
        this.zae = str2;
        this.zaf = str3;
        this.zag = str4;
        this.zah = uri;
        this.zai = str5;
        this.zaj = j;
        this.zak = str6;
        this.zac = arrayList;
        this.zal = str7;
        this.zam = str8;
    }

    public static GoogleSignInAccount zab(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        zzah.checkNotEmpty(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.zai = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.zak.equals(this.zak) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
    }

    public final HashSet getRequestedScopes() {
        HashSet hashSet = new HashSet(this.zac);
        hashSet.addAll(this.zan);
        return hashSet;
    }

    public final int hashCode() {
        return ((this.zak.hashCode() + 527) * 31) + getRequestedScopes().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zab);
        CloseableKt.writeString(parcel, 2, this.zad, false);
        CloseableKt.writeString(parcel, 3, this.zae, false);
        CloseableKt.writeString(parcel, 4, this.zaf, false);
        CloseableKt.writeString(parcel, 5, this.zag, false);
        CloseableKt.writeParcelable(parcel, 6, this.zah, i, false);
        CloseableKt.writeString(parcel, 7, this.zai, false);
        CloseableKt.zzc(parcel, 8, 8);
        parcel.writeLong(this.zaj);
        CloseableKt.writeString(parcel, 9, this.zak, false);
        CloseableKt.writeTypedList(parcel, 10, this.zac, false);
        CloseableKt.writeString(parcel, 11, this.zal, false);
        CloseableKt.writeString(parcel, 12, this.zam, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
