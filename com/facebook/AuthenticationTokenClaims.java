package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.fragment.app.FragmentState;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.google.firebase.inject.PVS.jIKWv;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class AuthenticationTokenClaims implements Parcelable {
    public static final Parcelable.Creator<AuthenticationTokenClaims> CREATOR = new FragmentState.AnonymousClass1(22);
    public final String aud;
    public final String email;
    public final long exp;
    public final String familyName;
    public final String givenName;
    public final long iat;
    public final String iss;
    public final String jti;
    public final String middleName;
    public final String name;
    public final String nonce;
    public final String picture;
    public final String sub;
    public final Map userAgeRange;
    public final String userBirthday;
    public final Set userFriends;
    public final String userGender;
    public final Map userHometown;
    public final String userLink;
    public final Map userLocation;

    public AuthenticationTokenClaims(String encodedClaims, String expectedNonce) throws JSONException {
        Set setUnmodifiableSet;
        Intrinsics.checkNotNullParameter(encodedClaims, "encodedClaims");
        Intrinsics.checkNotNullParameter(expectedNonce, "expectedNonce");
        Validate.notEmpty(encodedClaims, "encodedClaims");
        byte[] decodedBytes = Base64.decode(encodedClaims, 8);
        Intrinsics.checkNotNullExpressionValue(decodedBytes, "decodedBytes");
        JSONObject jSONObject = new JSONObject(new String(decodedBytes, Charsets.UTF_8));
        String jti = jSONObject.optString("jti");
        Intrinsics.checkNotNullExpressionValue(jti, "jti");
        if (jti.length() != 0) {
            try {
                String iss = jSONObject.optString("iss");
                Intrinsics.checkNotNullExpressionValue(iss, "iss");
                if (iss.length() != 0 && (Intrinsics.areEqual(new URL(iss).getHost(), "facebook.com") || Intrinsics.areEqual(new URL(iss).getHost(), "www.facebook.com"))) {
                    String aud = jSONObject.optString("aud");
                    Intrinsics.checkNotNullExpressionValue(aud, "aud");
                    if (aud.length() != 0 && aud.equals(FacebookSdk.getApplicationId())) {
                        long j = 1000;
                        if (!new Date().after(new Date(jSONObject.optLong("exp") * j))) {
                            if (!new Date().after(new Date((jSONObject.optLong("iat") * j) + 600000))) {
                                String sub = jSONObject.optString("sub");
                                Intrinsics.checkNotNullExpressionValue(sub, "sub");
                                if (sub.length() != 0) {
                                    String nonce = jSONObject.optString("nonce");
                                    Intrinsics.checkNotNullExpressionValue(nonce, "nonce");
                                    if (nonce.length() != 0 && nonce.equals(expectedNonce)) {
                                        String string = jSONObject.getString("jti");
                                        Intrinsics.checkNotNullExpressionValue(string, jIKWv.yKrvdx);
                                        this.jti = string;
                                        String string2 = jSONObject.getString("iss");
                                        Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(JSON_KEY_ISS)");
                                        this.iss = string2;
                                        String string3 = jSONObject.getString("aud");
                                        Intrinsics.checkNotNullExpressionValue(string3, "jsonObj.getString(JSON_KEY_AUD)");
                                        this.aud = string3;
                                        String string4 = jSONObject.getString("nonce");
                                        Intrinsics.checkNotNullExpressionValue(string4, "jsonObj.getString(JSON_KEY_NONCE)");
                                        this.nonce = string4;
                                        this.exp = jSONObject.getLong("exp");
                                        this.iat = jSONObject.getLong("iat");
                                        String string5 = jSONObject.getString("sub");
                                        Intrinsics.checkNotNullExpressionValue(string5, "jsonObj.getString(JSON_KEY_SUB)");
                                        this.sub = string5;
                                        this.name = MediaType.Companion.getNullableString$facebook_core_release("name", jSONObject);
                                        this.givenName = MediaType.Companion.getNullableString$facebook_core_release("given_name", jSONObject);
                                        this.middleName = MediaType.Companion.getNullableString$facebook_core_release("middle_name", jSONObject);
                                        this.familyName = MediaType.Companion.getNullableString$facebook_core_release("family_name", jSONObject);
                                        this.email = MediaType.Companion.getNullableString$facebook_core_release("email", jSONObject);
                                        this.picture = MediaType.Companion.getNullableString$facebook_core_release("picture", jSONObject);
                                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("user_friends");
                                        if (jSONArrayOptJSONArray == null) {
                                            setUnmodifiableSet = null;
                                        } else {
                                            HashSet hashSet = new HashSet();
                                            int length = jSONArrayOptJSONArray.length();
                                            if (length > 0) {
                                                int i = 0;
                                                while (true) {
                                                    int i2 = i + 1;
                                                    String string6 = jSONArrayOptJSONArray.getString(i);
                                                    Intrinsics.checkNotNullExpressionValue(string6, "jsonArray.getString(i)");
                                                    hashSet.add(string6);
                                                    if (i2 >= length) {
                                                        break;
                                                    } else {
                                                        i = i2;
                                                    }
                                                }
                                            }
                                            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
                                        }
                                        this.userFriends = setUnmodifiableSet;
                                        this.userBirthday = MediaType.Companion.getNullableString$facebook_core_release("user_birthday", jSONObject);
                                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("user_age_range");
                                        this.userAgeRange = jSONObjectOptJSONObject == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToHashMap(jSONObjectOptJSONObject));
                                        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("user_hometown");
                                        this.userHometown = jSONObjectOptJSONObject2 == null ? null : Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject2));
                                        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("user_location");
                                        this.userLocation = jSONObjectOptJSONObject3 != null ? Collections.unmodifiableMap(Utility.convertJSONObjectToStringMap(jSONObjectOptJSONObject3)) : null;
                                        this.userGender = MediaType.Companion.getNullableString$facebook_core_release("user_gender", jSONObject);
                                        this.userLink = MediaType.Companion.getNullableString$facebook_core_release("user_link", jSONObject);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (MalformedURLException unused) {
            }
        }
        throw new IllegalArgumentException("Invalid claims");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenClaims)) {
            return false;
        }
        AuthenticationTokenClaims authenticationTokenClaims = (AuthenticationTokenClaims) obj;
        return Intrinsics.areEqual(this.jti, authenticationTokenClaims.jti) && Intrinsics.areEqual(this.iss, authenticationTokenClaims.iss) && Intrinsics.areEqual(this.aud, authenticationTokenClaims.aud) && Intrinsics.areEqual(this.nonce, authenticationTokenClaims.nonce) && this.exp == authenticationTokenClaims.exp && this.iat == authenticationTokenClaims.iat && Intrinsics.areEqual(this.sub, authenticationTokenClaims.sub) && Intrinsics.areEqual(this.name, authenticationTokenClaims.name) && Intrinsics.areEqual(this.givenName, authenticationTokenClaims.givenName) && Intrinsics.areEqual(this.middleName, authenticationTokenClaims.middleName) && Intrinsics.areEqual(this.familyName, authenticationTokenClaims.familyName) && Intrinsics.areEqual(this.email, authenticationTokenClaims.email) && Intrinsics.areEqual(this.picture, authenticationTokenClaims.picture) && Intrinsics.areEqual(this.userFriends, authenticationTokenClaims.userFriends) && Intrinsics.areEqual(this.userBirthday, authenticationTokenClaims.userBirthday) && Intrinsics.areEqual(this.userAgeRange, authenticationTokenClaims.userAgeRange) && Intrinsics.areEqual(this.userHometown, authenticationTokenClaims.userHometown) && Intrinsics.areEqual(this.userLocation, authenticationTokenClaims.userLocation) && Intrinsics.areEqual(this.userGender, authenticationTokenClaims.userGender) && Intrinsics.areEqual(this.userLink, authenticationTokenClaims.userLink);
    }

    public final int hashCode() {
        int iM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(527, 31, this.jti), 31, this.iss), 31, this.aud), 31, this.nonce);
        long j = this.exp;
        int i = (iM + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.iat;
        int iM2 = CoroutineAdapterKt$$ExternalSyntheticLambda0.m((i + ((int) (j2 ^ (j2 >>> 32)))) * 31, 31, this.sub);
        String str = this.name;
        int iHashCode = (iM2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.middleName;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.familyName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.picture;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Set set = this.userFriends;
        int iHashCode7 = (iHashCode6 + (set == null ? 0 : set.hashCode())) * 31;
        String str7 = this.userBirthday;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Map map = this.userAgeRange;
        int iHashCode9 = (iHashCode8 + (map == null ? 0 : map.hashCode())) * 31;
        Map map2 = this.userHometown;
        int iHashCode10 = (iHashCode9 + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map map3 = this.userLocation;
        int iHashCode11 = (iHashCode10 + (map3 == null ? 0 : map3.hashCode())) * 31;
        String str8 = this.userGender;
        int iHashCode12 = (iHashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.userLink;
        return iHashCode12 + (str9 != null ? str9.hashCode() : 0);
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("jti", this.jti);
        jSONObject.put("iss", this.iss);
        jSONObject.put("aud", this.aud);
        jSONObject.put("nonce", this.nonce);
        jSONObject.put("exp", this.exp);
        jSONObject.put("iat", this.iat);
        String str = this.sub;
        if (str != null) {
            jSONObject.put("sub", str);
        }
        String str2 = this.name;
        if (str2 != null) {
            jSONObject.put("name", str2);
        }
        String str3 = this.givenName;
        if (str3 != null) {
            jSONObject.put("given_name", str3);
        }
        String str4 = this.middleName;
        if (str4 != null) {
            jSONObject.put("middle_name", str4);
        }
        String str5 = this.familyName;
        if (str5 != null) {
            jSONObject.put("family_name", str5);
        }
        String str6 = this.email;
        if (str6 != null) {
            jSONObject.put("email", str6);
        }
        String str7 = this.picture;
        if (str7 != null) {
            jSONObject.put("picture", str7);
        }
        Set set = this.userFriends;
        if (set != null) {
            jSONObject.put("user_friends", new JSONArray((Collection) set));
        }
        String str8 = this.userBirthday;
        if (str8 != null) {
            jSONObject.put("user_birthday", str8);
        }
        Map map = this.userAgeRange;
        if (map != null) {
            jSONObject.put("user_age_range", new JSONObject(map));
        }
        Map map2 = this.userHometown;
        if (map2 != null) {
            jSONObject.put("user_hometown", new JSONObject(map2));
        }
        Map map3 = this.userLocation;
        if (map3 != null) {
            jSONObject.put("user_location", new JSONObject(map3));
        }
        String str9 = this.userGender;
        if (str9 != null) {
            jSONObject.put("user_gender", str9);
        }
        String str10 = this.userLink;
        if (str10 != null) {
            jSONObject.put("user_link", str10);
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "claimsJsonObject.toString()");
        return string;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.jti);
        dest.writeString(this.iss);
        dest.writeString(this.aud);
        dest.writeString(this.nonce);
        dest.writeLong(this.exp);
        dest.writeLong(this.iat);
        dest.writeString(this.sub);
        dest.writeString(this.name);
        dest.writeString(this.givenName);
        dest.writeString(this.middleName);
        dest.writeString(this.familyName);
        dest.writeString(this.email);
        dest.writeString(this.picture);
        Set set = this.userFriends;
        if (set == null) {
            dest.writeStringList(null);
        } else {
            dest.writeStringList(new ArrayList(set));
        }
        dest.writeString(this.userBirthday);
        dest.writeMap(this.userAgeRange);
        dest.writeMap(this.userHometown);
        dest.writeMap(this.userLocation);
        dest.writeString(this.userGender);
        dest.writeString(this.userLink);
    }

    public AuthenticationTokenClaims(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        Validate.notNullOrEmpty(string, "jti");
        this.jti = string;
        String string2 = parcel.readString();
        Validate.notNullOrEmpty(string2, "iss");
        this.iss = string2;
        String string3 = parcel.readString();
        Validate.notNullOrEmpty(string3, "aud");
        this.aud = string3;
        String string4 = parcel.readString();
        Validate.notNullOrEmpty(string4, "nonce");
        this.nonce = string4;
        this.exp = parcel.readLong();
        this.iat = parcel.readLong();
        String string5 = parcel.readString();
        Validate.notNullOrEmpty(string5, "sub");
        this.sub = string5;
        this.name = parcel.readString();
        this.givenName = parcel.readString();
        this.middleName = parcel.readString();
        this.familyName = parcel.readString();
        this.email = parcel.readString();
        this.picture = parcel.readString();
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        this.userFriends = arrayListCreateStringArrayList != null ? Collections.unmodifiableSet(new HashSet(arrayListCreateStringArrayList)) : null;
        this.userBirthday = parcel.readString();
        HashMap hashMap = parcel.readHashMap(CollectionToArray.class.getClassLoader());
        hashMap = hashMap instanceof HashMap ? hashMap : null;
        this.userAgeRange = hashMap != null ? Collections.unmodifiableMap(hashMap) : null;
        HashMap hashMap2 = parcel.readHashMap(StringCompanionObject.class.getClassLoader());
        hashMap2 = hashMap2 instanceof HashMap ? hashMap2 : null;
        this.userHometown = hashMap2 != null ? Collections.unmodifiableMap(hashMap2) : null;
        HashMap hashMap3 = parcel.readHashMap(StringCompanionObject.class.getClassLoader());
        hashMap3 = hashMap3 instanceof HashMap ? hashMap3 : null;
        this.userLocation = hashMap3 != null ? Collections.unmodifiableMap(hashMap3) : null;
        this.userGender = parcel.readString();
        this.userLink = parcel.readString();
    }
}
