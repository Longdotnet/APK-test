package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzqx;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbg {
    public final Context zza;
    public final String zzb;
    public final SharedPreferences zzc;
    public final Logger zzd;

    public zzbg(Context context, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(context);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zzb = str;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences("com.google.firebase.auth.api.Store." + str, 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zzf(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzzy zzb(FirebaseUser firebaseUser) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        String string = this.zzc.getString("com.google.firebase.auth.GET_TOKEN_RESPONSE." + firebaseUser.getUid(), null);
        if (string != null) {
            return zzzy.zzd(string);
        }
        return null;
    }

    public final void zzc(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        String string;
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzxVar = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzxVar.zzf());
                jSONObject.put("applicationName", zzxVar.zza().getName());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzxVar.zzo() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List listZzo = zzxVar.zzo();
                    int size = listZzo.size();
                    if (listZzo.size() > 30) {
                        this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(listZzo.size()));
                        size = 30;
                    }
                    for (int i = 0; i < size; i++) {
                        jSONArray.put(((zzt) listZzo.get(i)).zzb());
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", zzxVar.isAnonymous());
                jSONObject.put("version", "2");
                if (zzxVar.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzz) zzxVar.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzxVar).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < enrolledFactors.size(); i2++) {
                        jSONArray2.put(enrolledFactors.get(i2).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                string = jSONObject.toString();
            } catch (Exception e) {
                Logger logger = this.zzd;
                Log.wtf(logger.zza, logger.format("Failed to turn object into JSON", new Object[0]), e);
                throw new zzqx(e);
            }
        } else {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", string).apply();
    }

    public final void zze(FirebaseUser firebaseUser, zzzy zzzyVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzzyVar);
        this.zzc.edit().putString(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("com.google.firebase.auth.GET_TOKEN_RESPONSE.", firebaseUser.getUid()), zzzyVar.zzh()).apply();
    }

    private final zzx zzf(JSONObject jSONObject) {
        JSONArray jSONArray;
        PhoneMultiFactorInfo phoneMultiFactorInfo;
        zzz zzzVar;
        try {
            try {
                String string = jSONObject.getString("cachedTokenState");
                String string2 = jSONObject.getString("applicationName");
                boolean z = jSONObject.getBoolean("anonymous");
                String str = yzwzcWHcnH.ZEq;
                String string3 = jSONObject.getString("version");
                if (string3 != null) {
                    str = string3;
                }
                JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
                int length = jSONArray2.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i = 0; i < length; i++) {
                    String string4 = jSONArray2.getString(i);
                    Parcelable.Creator<zzt> creator = zzt.CREATOR;
                    try {
                        JSONObject jSONObject2 = new JSONObject(string4);
                        arrayList.add(new zzt(jSONObject2.optString("userId"), jSONObject2.optString("providerId"), jSONObject2.optString("email"), jSONObject2.optString("phoneNumber"), jSONObject2.optString("displayName"), jSONObject2.optString("photoUrl"), jSONObject2.optBoolean("isEmailVerified"), jSONObject2.optString("rawUserInfo")));
                    } catch (JSONException e) {
                        Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
                        throw new zzqx(e);
                    }
                }
                zzx zzxVar = new zzx(FirebaseApp.getInstance(string2), arrayList);
                if (!TextUtils.isEmpty(string)) {
                    zzxVar.zzh(zzzy.zzd(string));
                }
                if (!z) {
                    zzxVar.zzm();
                }
                zzxVar.zzl(str);
                if (jSONObject.has("userMetadata")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("userMetadata");
                    Parcelable.Creator<zzz> creator2 = zzz.CREATOR;
                    if (jSONObject3 == null) {
                        zzzVar = null;
                    } else {
                        try {
                            zzzVar = new zzz(jSONObject3.getLong("lastSignInTimestamp"), jSONObject3.getLong("creationTimestamp"));
                        } catch (JSONException unused) {
                            zzzVar = null;
                        }
                    }
                    if (zzzVar != null) {
                        zzxVar.zzr(zzzVar);
                    }
                }
                if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject4 = new JSONObject(jSONArray.getString(i2));
                        if ("phone".equals(jSONObject4.optString(MultiFactorInfo.FACTOR_ID_KEY))) {
                            Parcelable.Creator<PhoneMultiFactorInfo> creator3 = PhoneMultiFactorInfo.CREATOR;
                            if (!jSONObject4.has("enrollmentTimestamp")) {
                                throw new IllegalArgumentException("An enrollment timestamp in seconds of UTC time since Unix epoch is required to build a PhoneMultiFactorInfo instance.");
                            }
                            phoneMultiFactorInfo = new PhoneMultiFactorInfo(jSONObject4.optString("uid"), jSONObject4.optString("displayName"), jSONObject4.optLong("enrollmentTimestamp"), jSONObject4.optString("phoneNumber"));
                        } else {
                            phoneMultiFactorInfo = null;
                        }
                        arrayList2.add(phoneMultiFactorInfo);
                    }
                    zzxVar.zzi(arrayList2);
                }
                return zzxVar;
            } catch (zzqx e2) {
                e = e2;
                Log.wtf(this.zzd.zza, e);
                return null;
            } catch (ArrayIndexOutOfBoundsException e3) {
                e = e3;
                Log.wtf(this.zzd.zza, e);
                return null;
            } catch (IllegalArgumentException e4) {
                e = e4;
                Log.wtf(this.zzd.zza, e);
                return null;
            }
        } catch (JSONException e5) {
            e = e5;
            Log.wtf(this.zzd.zza, e);
            return null;
        }
    }
}
