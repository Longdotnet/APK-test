package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest$Companion$$ExternalSyntheticLambda0;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.ads.internal.util.zzq;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Utility {
    public static long availableExternalStorageGB = -1;
    public static String carrierName = "NoCarrier";
    public static String deviceTimeZoneName = "";
    public static String deviceTimezoneAbbreviation = "";
    public static int numCPUCores = 0;
    public static long timestampOfLastCheck = -1;
    public static long totalExternalStorageGB = -1;

    /* JADX INFO: loaded from: classes.dex */
    public interface GraphMeRequestWithCacheCallback {
        void onFailure(FacebookException facebookException);

        void onSuccess(JSONObject jSONObject);
    }

    public static final Uri buildUri(String str, String str2, Bundle bundle) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority(str);
        builder.path(str2);
        if (bundle != null) {
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    builder.appendQueryParameter(str3, (String) obj);
                }
            }
        }
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "builder.build()");
        return uriBuild;
    }

    public static void clearCookiesForDomain(Context context, String str) {
        CookieSyncManager.createInstance(context).sync();
        CookieManager cookieManager = CookieManager.getInstance();
        String cookie = cookieManager.getCookie(str);
        if (cookie == null) {
            return;
        }
        Object[] array = StringsKt__StringsKt.split$default(cookie, new String[]{";"}, 0, 6).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str2 = strArr[i];
            i++;
            Object[] array2 = StringsKt__StringsKt.split$default(str2, new String[]{"="}, 0, 6).toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr2 = (String[]) array2;
            if (strArr2.length > 0) {
                String str3 = strArr2[0];
                int length2 = str3.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length2) {
                    boolean z2 = Intrinsics.compare(str3.charAt(!z ? i2 : length2), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        } else {
                            length2--;
                        }
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                cookieManager.setCookie(str, Intrinsics.stringPlus("=;expires=Sat, 1 Jan 2000 00:00:01 UTC;", str3.subSequence(i2, length2 + 1).toString()));
            }
        }
        cookieManager.removeExpiredCookie();
    }

    public static final void clearFacebookCookies(Context context) {
        try {
            clearCookiesForDomain(context, "facebook.com");
            clearCookiesForDomain(context, ".facebook.com");
            clearCookiesForDomain(context, "https://facebook.com");
            clearCookiesForDomain(context, "https://.facebook.com");
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static final String coerceValueIfNullOrEmpty(String str) {
        return isNullOrEmpty(str) ? "" : str;
    }

    public static final ArrayList convertJSONArrayToList(JSONArray jSONArray) {
        try {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            if (length <= 0) {
                return arrayList;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                String string = jSONArray.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                arrayList.add(string);
                if (i2 >= length) {
                    return arrayList;
                }
                i = i2;
            }
        } catch (JSONException unused) {
            return new ArrayList();
        }
    }

    public static final HashMap convertJSONObjectToHashMap(JSONObject jsonObject) {
        int length;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        HashMap map = new HashMap();
        JSONArray jSONArrayNames = jsonObject.names();
        if (jSONArrayNames != null && (length = jSONArrayNames.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                try {
                    String string = jSONArrayNames.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string, "keys.getString(i)");
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject) value);
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    map.put(string, value);
                } catch (JSONException unused) {
                }
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return map;
    }

    public static final HashMap convertJSONObjectToStringMap(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String key = (String) itKeys.next();
            String strOptString = jSONObject.optString(key);
            if (strOptString != null) {
                Intrinsics.checkNotNullExpressionValue(key, "key");
                map.put(key, strOptString);
            }
        }
        return map;
    }

    public static final int copyAndCloseInputStream(InputStream inputStream, FilterOutputStream filterOutputStream) throws Throwable {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = bufferedInputStream2.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    filterOutputStream.write(bArr, 0, i2);
                    i += i2;
                }
                bufferedInputStream2.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                return i;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final void disconnectQuietly(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static final String getActivityName(Context context) {
        if (context == null) {
            return "null";
        }
        return context == context.getApplicationContext() ? "unknown" : context.getClass().getSimpleName();
    }

    public static final String getAppName(Context context) {
        String string;
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Validate.sdkInitialized();
            String str = FacebookSdk.applicationName;
            if (str != null) {
                return str;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i == 0) {
                string = applicationInfo.nonLocalizedLabel.toString();
            } else {
                string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringId)");
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static final Date getBundleLongAsDate(Bundle bundle, String str, Date date) {
        long jLongValue;
        if (bundle == null) {
            return null;
        }
        Object obj = bundle.get(str);
        if (!(obj instanceof Long)) {
            if (obj instanceof String) {
                try {
                    jLongValue = Long.parseLong((String) obj);
                } catch (NumberFormatException unused) {
                }
            }
            return null;
        }
        jLongValue = ((Number) obj).longValue();
        if (jLongValue == 0) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date((jLongValue * 1000) + date.getTime());
    }

    public static final JSONObject getDataProcessingOptions() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return null;
        }
        try {
            String string = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.DataProcessingOptions", 0).getString("data_processing_options", null);
            if (string != null) {
                try {
                    return new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Utility.class, th);
            return null;
        }
    }

    public static final String getDialogAuthority() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return String.format("m.%s", Arrays.copyOf(new Object[]{FacebookSdk.facebookDomain}, 1));
    }

    public static final void getGraphMeRequestWithCacheAsync(final GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback, final String accessToken) {
        String str;
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        ConcurrentHashMap concurrentHashMap = ProfileInformationCache.infoCache;
        JSONObject jSONObject = (JSONObject) ProfileInformationCache.infoCache.get(accessToken);
        if (jSONObject != null) {
            graphMeRequestWithCacheCallback.onSuccess(jSONObject);
            return;
        }
        GraphRequest.Callback callback = new GraphRequest.Callback() { // from class: com.facebook.internal.Utility$$ExternalSyntheticLambda4
            @Override // com.facebook.GraphRequest.Callback
            public final void onCompleted(GraphResponse graphResponse) {
                Utility.GraphMeRequestWithCacheCallback graphMeRequestWithCacheCallback2 = graphMeRequestWithCacheCallback;
                String accessToken2 = accessToken;
                Intrinsics.checkNotNullParameter(accessToken2, "$accessToken");
                FacebookRequestError facebookRequestError = graphResponse.error;
                if (facebookRequestError != null) {
                    graphMeRequestWithCacheCallback2.onFailure(facebookRequestError.exception);
                    return;
                }
                ConcurrentHashMap concurrentHashMap2 = ProfileInformationCache.infoCache;
                JSONObject jSONObject2 = graphResponse.jsonObject;
                if (jSONObject2 == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                ProfileInformationCache.infoCache.put(accessToken2, jSONObject2);
                graphMeRequestWithCacheCallback2.onSuccess(jSONObject2);
            }
        };
        HttpMethod httpMethod = HttpMethod.GET;
        Bundle bundle = new Bundle();
        Date date = AccessToken.DEFAULT_EXPIRATION_TIME;
        AccessToken currentAccessToken = Headers.Companion.getCurrentAccessToken();
        if (currentAccessToken == null || (str = currentAccessToken.graphDomain) == null) {
            str = "facebook";
        }
        bundle.putString("fields", str.equals("instagram") ? "id,name,profile_picture" : "id,name,first_name,middle_name,last_name");
        bundle.putString("access_token", accessToken);
        GraphRequest graphRequest = new GraphRequest(null, "me", null, null, new GraphRequest$Companion$$ExternalSyntheticLambda0(0));
        graphRequest.parameters = bundle;
        graphRequest.httpMethod = httpMethod;
        graphRequest.setCallback(callback);
        graphRequest.executeAsync();
    }

    public static final String getInstagramDialogAuthority() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return String.format("m.%s", Arrays.copyOf(new Object[]{FacebookSdk.instagramDomain}, 1));
    }

    public static void getInstance(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (zzq.access$getSingleton$cp() != null) {
            zzq.access$getSingleton$cp();
            return;
        }
        zzq zzqVar = new zzq(context);
        if (!CrashShieldHandler.isObjectCrashing(zzq.class)) {
            try {
                if (!CrashShieldHandler.isObjectCrashing(zzqVar)) {
                    try {
                        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance((Context) zzqVar.zza);
                        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
                        localBroadcastManager.registerReceiver(zzqVar, new IntentFilter("com.parse.bolts.measurement_event"));
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(zzqVar, th);
                    }
                }
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(zzq.class, th2);
            }
        }
        if (!CrashShieldHandler.isObjectCrashing(zzq.class)) {
            try {
                zzq.singleton = zzqVar;
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(zzq.class, th3);
            }
        }
        zzq.access$getSingleton$cp();
    }

    public static final Method getMethodQuietly(Class cls, String str, Class... parameterTypes) {
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static final Object getStringPropertyAsJSON(JSONObject jSONObject, String str, String str2) {
        Object objOpt = jSONObject.opt(str);
        if (objOpt != null && (objOpt instanceof String)) {
            objOpt = new JSONTokener((String) objOpt).nextValue();
        }
        if (objOpt == null || (objOpt instanceof JSONObject) || (objOpt instanceof JSONArray)) {
            return objOpt;
        }
        if (str2 == null) {
            throw new FacebookException("Got an unexpected non-JSON object.");
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.putOpt(str2, objOpt);
        return jSONObject2;
    }

    public static String hashWithAlgorithm(String str, byte[] bArr) {
        try {
            MessageDigest hash = MessageDigest.getInstance(str);
            Intrinsics.checkNotNullExpressionValue(hash, "hash");
            hash.update(bArr);
            byte[] digest = hash.digest();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(digest, "digest");
            int length = digest.length;
            int i = 0;
            while (i < length) {
                byte b = digest[i];
                i++;
                sb.append(Integer.toHexString((b >> 4) & 15));
                sb.append(Integer.toHexString(b & 15));
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "builder.toString()");
            return string;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static final Object invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static final boolean isAutoAppLinkSetup() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(String.format("fb%s://applinks", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1))));
            Context applicationContext = FacebookSdk.getApplicationContext();
            PackageManager packageManager = applicationContext.getPackageManager();
            String packageName = applicationContext.getPackageName();
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(packageName, it.next().activityInfo.packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static final boolean isChromeOS(FragmentActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT >= 27) {
            return context.getPackageManager().hasSystemFeature("android.hardware.type.pc");
        }
        String str = Build.DEVICE;
        if (str != null) {
            Pattern patternCompile = Pattern.compile(".+_cheets|cheets_.+");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
            if (patternCompile.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isDataProcessingRestricted() {
        if (CrashShieldHandler.isObjectCrashing(Utility.class)) {
            return false;
        }
        try {
            JSONObject dataProcessingOptions = getDataProcessingOptions();
            if (dataProcessingOptions == null) {
                return false;
            }
            try {
                JSONArray jSONArray = dataProcessingOptions.getJSONArray("data_processing_options");
                int length = jSONArray.length();
                if (length > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "options.getString(i)");
                        String lowerCase = string.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                        if (lowerCase.equals("ldu")) {
                            return true;
                        }
                        if (i2 < length) {
                            i = i2;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Utility.class, th);
            return false;
        }
    }

    public static boolean isGooglePlayServicesAvailable(Context context) {
        Method methodQuietly = getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", ZRqOdXiy.npPAUU, Context.class);
        if (methodQuietly == null) {
            return false;
        }
        Object objInvokeMethodQuietly = invokeMethodQuietly(null, methodQuietly, context);
        return (objInvokeMethodQuietly instanceof Integer) && Intrinsics.areEqual(objInvokeMethodQuietly, 0);
    }

    public static final boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static final boolean isWebUri(Uri uri) {
        return uri != null && ("http".equalsIgnoreCase(uri.getScheme()) || "https".equalsIgnoreCase(uri.getScheme()) || "fbstaging".equalsIgnoreCase(uri.getScheme()));
    }

    public static final ArrayList jsonArrayToStringList(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayList.add(jSONArray.getString(i));
                if (i2 >= length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public static final HashMap jsonStrToMap(String str) {
        if (str.length() == 0) {
            return new HashMap();
        }
        try {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String key = (String) itKeys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String string = jSONObject.getString(key);
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                map.put(key, string);
            }
            return map;
        } catch (JSONException unused) {
            return new HashMap();
        }
    }

    public static final String mapToJsonStr(Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        String string = "";
        if (!map.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                }
                string = jSONObject.toString();
            } catch (JSONException unused) {
            }
            Intrinsics.checkNotNullExpressionValue(string, "{\n      try {\n        val jsonObject = JSONObject()\n        for ((key, value) in map) {\n          jsonObject.put(key, value)\n        }\n        jsonObject.toString()\n      } catch (_e: JSONException) {\n        \"\"\n      }\n    }");
        }
        return string;
    }

    public static final Bundle parseUrlQueryString(String str) {
        Bundle bundle = new Bundle();
        if (!isNullOrEmpty(str)) {
            if (str == null) {
                throw new IllegalStateException(GsPcpBmONXh.WLQ);
            }
            Object[] array = StringsKt__StringsKt.split$default(str, new String[]{"&"}, 0, 6).toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str2 = strArr[i];
                i++;
                Object[] array2 = StringsKt__StringsKt.split$default(str2, new String[]{"="}, 0, 6).toArray(new String[0]);
                if (array2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] strArr2 = (String[]) array2;
                try {
                    if (strArr2.length == 2) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), URLDecoder.decode(strArr2[1], "UTF-8"));
                    } else if (strArr2.length == 1) {
                        bundle.putString(URLDecoder.decode(strArr2[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException unused) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void putJSONValueInBundle(Bundle bundle, JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (jSONArray instanceof boolean[]) {
            bundle.putBooleanArray("media", (boolean[]) jSONArray);
            return;
        }
        if (jSONArray instanceof double[]) {
            bundle.putDoubleArray("media", (double[]) jSONArray);
            return;
        }
        if (jSONArray instanceof int[]) {
            bundle.putIntArray("media", (int[]) jSONArray);
        } else if (jSONArray instanceof long[]) {
            bundle.putLongArray("media", (long[]) jSONArray);
        } else {
            bundle.putString("media", jSONArray.toString());
        }
    }

    public static final HashMap readNonnullStringMapFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i = parcel.readInt();
        if (i < 0) {
            return null;
        }
        HashMap map = new HashMap();
        if (i > 0) {
            int i2 = 0;
            do {
                i2++;
                String string = parcel.readString();
                String string2 = parcel.readString();
                if (string != null && string2 != null) {
                    map.put(string, string2);
                }
            } while (i2 < i);
        }
        return map;
    }

    public static final String readStreamToString(InputStream inputStream) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        InputStreamReader inputStreamReader;
        try {
            bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                inputStreamReader = new InputStreamReader(bufferedInputStream);
                try {
                    StringBuilder sb = new StringBuilder();
                    char[] cArr = new char[2048];
                    while (true) {
                        int i = inputStreamReader.read(cArr);
                        if (i == -1) {
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "{\n      bufferedInputStream = BufferedInputStream(inputStream)\n      reader = InputStreamReader(bufferedInputStream)\n      val stringBuilder = StringBuilder()\n      val bufferSize = 1024 * 2\n      val buffer = CharArray(bufferSize)\n      var n = 0\n      while (reader.read(buffer).also { n = it } != -1) {\n        stringBuilder.append(buffer, 0, n)\n      }\n      stringBuilder.toString()\n    }");
                            closeQuietly(bufferedInputStream);
                            closeQuietly(inputStreamReader);
                            return string;
                        }
                        sb.append(cArr, 0, i);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(bufferedInputStream);
                    closeQuietly(inputStreamReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
            }
        } catch (Throwable th4) {
            bufferedInputStream = null;
            th = th4;
            inputStreamReader = null;
        }
    }

    public static final void runOnNonUiThread(Runnable runnable) {
        try {
            FacebookSdk.getExecutor().execute(runnable);
        } catch (Exception unused) {
        }
    }

    public static final void setAppEventExtendedDeviceInfoParameters(JSONObject jSONObject, Context appContext) {
        String str;
        Locale locale;
        int i;
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("a2");
        int i2 = 0;
        if (timestampOfLastCheck == -1 || System.currentTimeMillis() - timestampOfLastCheck >= 1800000) {
            timestampOfLastCheck = System.currentTimeMillis();
            try {
                TimeZone timeZone = TimeZone.getDefault();
                String displayName = timeZone.getDisplayName(timeZone.inDaylightTime(new Date()), 0);
                Intrinsics.checkNotNullExpressionValue(displayName, "tz.getDisplayName(tz.inDaylightTime(Date()), TimeZone.SHORT)");
                deviceTimezoneAbbreviation = displayName;
                String id = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id, "tz.id");
                deviceTimeZoneName = id;
            } catch (AssertionError | Exception unused) {
            }
            if (carrierName.equals("NoCarrier")) {
                try {
                    Object systemService = appContext.getSystemService("phone");
                    if (systemService == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
                    }
                    String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
                    Intrinsics.checkNotNullExpressionValue(networkOperatorName, "telephonyManager.networkOperatorName");
                    carrierName = networkOperatorName;
                } catch (Exception unused2) {
                }
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    totalExternalStorageGB = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
                }
                totalExternalStorageGB = Math.round(totalExternalStorageGB / 1.073741824E9d);
            } catch (Exception unused3) {
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                    availableExternalStorageGB = ((long) statFs2.getAvailableBlocks()) * ((long) statFs2.getBlockSize());
                }
                availableExternalStorageGB = Math.round(availableExternalStorageGB / 1.073741824E9d);
            } catch (Exception unused4) {
            }
        }
        String packageName = appContext.getPackageName();
        int i3 = -1;
        try {
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) {
                return;
            }
            i3 = packageInfo.versionCode;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused5) {
            str = "";
        }
        jSONArray.put(packageName);
        jSONArray.put(i3);
        jSONArray.put(str);
        jSONArray.put(Build.VERSION.RELEASE);
        jSONArray.put(Build.MODEL);
        try {
            locale = appContext.getResources().getConfiguration().locale;
        } catch (Exception unused6) {
            locale = Locale.getDefault();
        }
        jSONArray.put(locale.getLanguage() + '_' + ((Object) locale.getCountry()));
        jSONArray.put(deviceTimezoneAbbreviation);
        jSONArray.put(carrierName);
        double d = 0.0d;
        try {
            Object systemService2 = appContext.getSystemService("display");
            Display display = null;
            DisplayManager displayManager = systemService2 instanceof DisplayManager ? (DisplayManager) systemService2 : null;
            if (displayManager != null) {
                display = displayManager.getDisplay(0);
            }
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getMetrics(displayMetrics);
                int i4 = displayMetrics.widthPixels;
                try {
                    i2 = displayMetrics.heightPixels;
                    d = displayMetrics.density;
                } catch (Exception unused7) {
                }
                i = i2;
                i2 = i4;
            } else {
                i = 0;
            }
        } catch (Exception unused8) {
        }
        jSONArray.put(i2);
        jSONArray.put(i);
        jSONArray.put(new DecimalFormat("#.##").format(d));
        int i5 = numCPUCores;
        if (i5 <= 0) {
            try {
                File[] fileArrListFiles = new File("/sys/devices/system/cpu/").listFiles(new Utility$$ExternalSyntheticLambda5(0));
                if (fileArrListFiles != null) {
                    numCPUCores = fileArrListFiles.length;
                }
            } catch (Exception unused9) {
            }
            if (numCPUCores <= 0) {
                numCPUCores = Math.max(Runtime.getRuntime().availableProcessors(), 1);
            }
            i5 = numCPUCores;
        }
        jSONArray.put(i5);
        jSONArray.put(totalExternalStorageGB);
        jSONArray.put(availableExternalStorageGB);
        jSONArray.put(deviceTimeZoneName);
        jSONObject.put("extinfo", jSONArray.toString());
    }

    public static final String sha256hash(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return hashWithAlgorithm("SHA-256", bytes);
    }

    public static final void writeNonnullStringMapToParcel(Parcel parcel, Map map) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            parcel.writeString(str);
            parcel.writeString(str2);
        }
    }

    public static final Method getMethodQuietly(String str, String str2, Class... clsArr) {
        try {
            return getMethodQuietly(Class.forName(str), str2, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
