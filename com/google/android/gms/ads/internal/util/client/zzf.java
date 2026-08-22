package com.google.android.gms.ads.internal.util.client;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzfoc;
import com.google.android.gms.internal.ads.zzfrw;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzf {
    public static final zzfrw zza = new zzfrw(Looper.getMainLooper());
    public static final String zzb = AdView.class.getName();
    public static final String zzc = InterstitialAd.class.getName();
    public static final String zzd = AdManagerAdView.class.getName();
    public static final String zze = AdManagerInterstitialAd.class.getName();
    public static final String zzf = zzfoc.class.getName();
    public static final String zzg = AdLoader.class.getName();
    public float zzh;

    public static final int zzC(Context context, int i) {
        return zzu(context.getResources().getDisplayMetrics(), i);
    }

    public static final String zzD(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String string = contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id");
        if (string == null || zzw()) {
            string = "emulator";
        }
        return zzE(string, "MD5");
    }

    public static String zzE(String str, String str2) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str2);
                messageDigest.update(str.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, messageDigest.digest()));
            } catch (ArithmeticException unused) {
                return null;
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        return null;
    }

    public static boolean zzt(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith((String) zzbfn.zzd.zze());
    }

    public static final int zzu(DisplayMetrics displayMetrics, int i) {
        return (int) TypedValue.applyDimension(1, i, displayMetrics);
    }

    public static final boolean zzw() {
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlQ)).booleanValue();
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator")) {
            return true;
        }
        return zBooleanValue && Build.HARDWARE.contains("ranchu");
    }

    public final JSONArray zzF(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zzG(jSONArray, it.next());
        }
        return jSONArray;
    }

    public final void zzG(JSONArray jSONArray, Object obj) {
        if (obj instanceof Bundle) {
            jSONArray.put(zzn((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONArray.put(zzo((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONArray.put(zzF((Collection) obj));
        } else if (obj instanceof Object[]) {
            jSONArray.put(zzm((Object[]) obj));
        } else {
            jSONArray.put(obj);
        }
    }

    public final void zzH(JSONObject jSONObject, String str, Object obj) {
        Boolean[] boolArr;
        Long[] lArr;
        Double[] dArr;
        Integer[] numArr;
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzq)).booleanValue()) {
            str = String.valueOf(str);
        }
        if (obj instanceof Bundle) {
            jSONObject.put(str, zzn((Bundle) obj));
            return;
        }
        if (obj instanceof Map) {
            jSONObject.put(str, zzo((Map) obj));
            return;
        }
        if (obj instanceof Collection) {
            jSONObject.put(String.valueOf(str), zzF((Collection) obj));
            return;
        }
        if (obj instanceof Object[]) {
            jSONObject.put(str, zzF(Arrays.asList((Object[]) obj)));
            return;
        }
        int i = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            if (iArr == null) {
                numArr = new Integer[0];
            } else {
                int length = iArr.length;
                Integer[] numArr2 = new Integer[length];
                while (i < length) {
                    numArr2[i] = Integer.valueOf(iArr[i]);
                    i++;
                }
                numArr = numArr2;
            }
            jSONObject.put(str, zzm(numArr));
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr2 = (double[]) obj;
            if (dArr2 == null) {
                dArr = new Double[0];
            } else {
                int length2 = dArr2.length;
                Double[] dArr3 = new Double[length2];
                while (i < length2) {
                    dArr3[i] = Double.valueOf(dArr2[i]);
                    i++;
                }
                dArr = dArr3;
            }
            jSONObject.put(str, zzm(dArr));
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            if (jArr == null) {
                lArr = new Long[0];
            } else {
                int length3 = jArr.length;
                Long[] lArr2 = new Long[length3];
                while (i < length3) {
                    lArr2[i] = Long.valueOf(jArr[i]);
                    i++;
                }
                lArr = lArr2;
            }
            jSONObject.put(str, zzm(lArr));
            return;
        }
        if (!(obj instanceof boolean[])) {
            jSONObject.put(str, obj);
            return;
        }
        boolean[] zArr = (boolean[]) obj;
        if (zArr == null) {
            boolArr = new Boolean[0];
        } else {
            int length4 = zArr.length;
            Boolean[] boolArr2 = new Boolean[length4];
            while (i < length4) {
                boolArr2[i] = Boolean.valueOf(zArr[i]);
                i++;
            }
            boolArr = boolArr2;
        }
        jSONObject.put(str, zzm(boolArr));
    }

    public final int zzb(Context context, int i) {
        if (this.zzh < 0.0f) {
            synchronized (this) {
                try {
                    if (this.zzh < 0.0f) {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        if (windowManager == null) {
                            return 0;
                        }
                        Display defaultDisplay = windowManager.getDefaultDisplay();
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        defaultDisplay.getMetrics(displayMetrics);
                        this.zzh = displayMetrics.density;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Math.round(i / this.zzh);
    }

    public final JSONArray zzm(Object[] objArr) {
        JSONArray jSONArray = new JSONArray();
        for (Object obj : objArr) {
            zzG(jSONArray, obj);
        }
        return jSONArray;
    }

    public final JSONObject zzn(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            zzH(jSONObject, str, bundle.get(str));
        }
        return jSONObject;
    }

    public final JSONObject zzo(Map map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                zzH(jSONObject, str, map.get(str));
            }
            return jSONObject;
        } catch (ClassCastException e) {
            throw new JSONException("Could not convert map to JSON: ".concat(String.valueOf(e.getMessage())));
        }
    }

    public static final void zzB(Context context, String str, Bundle bundle, zze zzeVar) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        bundle.putString("os", Build.VERSION.RELEASE);
        bundle.putString("api", String.valueOf(Build.VERSION.SDK_INT));
        bundle.putString("appid", applicationContext.getPackageName());
        if (str == null) {
            GoogleApiAvailabilityLight.zza.getClass();
            str = GoogleApiAvailabilityLight.getApkVersion(context) + ".252530000";
        }
        bundle.putString("js", str);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("https").path(iafHZUfOuHNwvy.ezppZXWmLYUZvb).appendQueryParameter("id", "gmob-apps");
        for (String str2 : bundle.keySet()) {
            builderAppendQueryParameter.appendQueryParameter(str2, bundle.getString(str2));
        }
        zzeVar.zza(builderAppendQueryParameter.toString());
    }
}
