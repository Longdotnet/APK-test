package kotlin.collections;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.StrictMode;
import androidx.core.widget.NestedScrollView;
import com.daerisoft.thespikerm.GamepadHandler_API19;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.UserSettingsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.internal.ads.zzbun;
import com.google.common.collect.Iterators$ArrayItr;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Cookie;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MapsKt__MapsKt implements NestedScrollView.OnScrollChangeListener {
    public static boolean enabled;
    public static boolean isEnabled;
    public static GamepadHandler_API19 ms_GamepadHandler;

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void buildTrieRecursive(long j, Buffer buffer, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = i;
        int i9 = 0;
        int i10 = 1;
        if (!(i2 < i3)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i11 = i2; i11 < i3; i11++) {
            if (((ByteString) arrayList.get(i11)).getSize$okio() < i8) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        ByteString byteString = (ByteString) arrayList.get(i2);
        ByteString byteString2 = (ByteString) arrayList.get(i3 - 1);
        int i12 = -1;
        if (i8 == byteString.getSize$okio()) {
            int iIntValue = ((Number) arrayList2.get(i2)).intValue();
            int i13 = i2 + 1;
            ByteString byteString3 = (ByteString) arrayList.get(i13);
            i4 = i13;
            i5 = iIntValue;
            byteString = byteString3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (byteString.internalGet$okio(i8) == byteString2.internalGet$okio(i8)) {
            int iMin = Math.min(byteString.getSize$okio(), byteString2.getSize$okio());
            for (int i14 = i8; i14 < iMin && byteString.internalGet$okio(i14) == byteString2.internalGet$okio(i14); i14++) {
                i9++;
            }
            long j2 = 4;
            long j3 = (buffer.size / j2) + j + ((long) 2) + ((long) i9) + 1;
            buffer.writeInt(-i9);
            buffer.writeInt(i5);
            int i15 = i8 + i9;
            while (i8 < i15) {
                buffer.writeInt(byteString.internalGet$okio(i8) & 255);
                i8++;
            }
            if (i4 + 1 == i3) {
                if (i15 != ((ByteString) arrayList.get(i4)).getSize$okio()) {
                    throw new IllegalStateException("Check failed.");
                }
                buffer.writeInt(((Number) arrayList2.get(i4)).intValue());
                return;
            } else {
                Buffer buffer2 = new Buffer();
                buffer.writeInt(((int) ((buffer2.size / j2) + j3)) * (-1));
                buildTrieRecursive(j3, buffer2, i15, arrayList, i4, i3, arrayList2);
                buffer.writeAll(buffer2);
                return;
            }
        }
        for (int i16 = i4 + 1; i16 < i3; i16++) {
            if (((ByteString) arrayList.get(i16 - 1)).internalGet$okio(i8) != ((ByteString) arrayList.get(i16)).internalGet$okio(i8)) {
                i10++;
            }
        }
        long j4 = 4;
        long j5 = ((long) (i10 * 2)) + (buffer.size / j4) + j + ((long) 2);
        buffer.writeInt(i10);
        buffer.writeInt(i5);
        for (int i17 = i4; i17 < i3; i17++) {
            int iInternalGet$okio = ((ByteString) arrayList.get(i17)).internalGet$okio(i8);
            if (i17 == i4 || iInternalGet$okio != ((ByteString) arrayList.get(i17 - 1)).internalGet$okio(i8)) {
                buffer.writeInt(iInternalGet$okio & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        while (i4 < i3) {
            byte bInternalGet$okio = ((ByteString) arrayList.get(i4)).internalGet$okio(i8);
            int i18 = i4 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i3) {
                    i6 = i3;
                    break;
                } else {
                    if (bInternalGet$okio != ((ByteString) arrayList.get(i19)).internalGet$okio(i8)) {
                        i6 = i19;
                        break;
                    }
                    i19++;
                }
            }
            if (i18 == i6 && i8 + 1 == ((ByteString) arrayList.get(i4)).getSize$okio()) {
                buffer.writeInt(((Number) arrayList2.get(i4)).intValue());
                i7 = i6;
            } else {
                buffer.writeInt(((int) ((buffer3.size / j4) + j5)) * i12);
                i7 = i6;
                buildTrieRecursive(j5, buffer3, i8 + 1, arrayList, i4, i7, arrayList2);
            }
            buffer3 = buffer3;
            i4 = i7;
            j4 = j4;
            i12 = -1;
        }
        buffer.writeAll(buffer3);
    }

    public static int dateCharacterOffset(boolean z, String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static Iterators$ArrayItr forArray(Object[] objArr, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        StringsKt__IndentKt.checkPositionIndexes(0, i, objArr.length);
        StringsKt__IndentKt.checkPositionIndex(i2, i);
        return i == 0 ? Iterators$ArrayItr.EMPTY : new Iterators$ArrayItr(objArr, i, i2);
    }

    public static HashMap hashMapOf(Pair... pairArr) {
        HashMap map = new HashMap(mapCapacity(pairArr.length));
        putAll(map, pairArr);
        return map;
    }

    public static int mapCapacity(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map mapOf(Pair... pairArr) {
        if (pairArr.length <= 0) {
            return EmptyMap.INSTANCE;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(pairArr.length));
        putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00a6  */
    public static long parseExpires(int i, String str) {
        int iDateCharacterOffset = dateCharacterOffset(false, str, 0, i);
        Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int iIndexOf$default = -1;
        int i5 = -1;
        int i6 = -1;
        while (iDateCharacterOffset < i) {
            int iDateCharacterOffset2 = dateCharacterOffset(true, str, iDateCharacterOffset + 1, i);
            matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
            if (i3 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                String strGroup = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
                i3 = Integer.parseInt(strGroup);
                String strGroup2 = matcher.group(2);
                Intrinsics.checkNotNullExpressionValue(strGroup2, "matcher.group(2)");
                i5 = Integer.parseInt(strGroup2);
                String strGroup3 = matcher.group(3);
                Intrinsics.checkNotNullExpressionValue(strGroup3, "matcher.group(3)");
                i6 = Integer.parseInt(strGroup3);
            } else if (i4 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                String strGroup4 = matcher.group(1);
                Intrinsics.checkNotNullExpressionValue(strGroup4, "matcher.group(1)");
                i4 = Integer.parseInt(strGroup4);
            } else if (iIndexOf$default == -1) {
                Pattern pattern = Cookie.MONTH_PATTERN;
                if (matcher.usePattern(pattern).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "Locale.US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = pattern.pattern();
                    Intrinsics.checkNotNullExpressionValue(strPattern, "MONTH_PATTERN.pattern()");
                    iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i2 != -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "matcher.group(1)");
                    i2 = Integer.parseInt(strGroup6);
                }
            } else if (i2 != -1) {
            }
            iDateCharacterOffset = dateCharacterOffset(false, str, iDateCharacterOffset2 + 1, i);
        }
        if (70 <= i2 && 99 >= i2) {
            i2 += 1900;
        }
        if (i2 >= 0 && 69 >= i2) {
            i2 += 2000;
        }
        if (!(i2 >= 1601)) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iIndexOf$default == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (1 > i4 || 31 < i4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i3 < 0 || 23 < i3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i5 < 0 || 59 < i5) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i6 < 0 || 59 < i6) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i2);
        gregorianCalendar.set(2, iIndexOf$default - 1);
        gregorianCalendar.set(5, i4);
        gregorianCalendar.set(11, i3);
        gregorianCalendar.set(12, i5);
        gregorianCalendar.set(13, i6);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    public static final void putAll(HashMap map, Pair[] pairArr) {
        for (Pair pair : pairArr) {
            map.put(pair.first, pair.second);
        }
    }

    public static void setSavedCloudBridgeCredentials$facebook_core_release(HashMap map) {
        SharedPreferences sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.sdk.CloudBridgeSavedCredentials", 0);
        if (sharedPreferences == null) {
            return;
        }
        Object obj = map.get("dataset_id");
        Object obj2 = map.get("endpoint");
        Object obj3 = map.get("access_key");
        if (obj == null || obj2 == null || obj3 == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("dataset_id", obj.toString());
        editorEdit.putString("endpoint", obj2.toString());
        editorEdit.putString("access_key", obj3.toString());
        editorEdit.apply();
        GraphRequest.Companion companion = Logger.Companion;
        synchronized (FacebookSdk.loggingBehaviors) {
        }
    }

    public static int toActivityTransitResId(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static Map toMap(ArrayList arrayList) {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        int size = arrayList.size();
        if (size == 0) {
            return emptyMap;
        }
        if (size == 1) {
            Pair pair = (Pair) arrayList.get(0);
            Intrinsics.checkNotNullParameter(pair, "pair");
            Map mapSingletonMap = Collections.singletonMap(pair.first, pair.second);
            Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(pair.first, pair.second)");
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair2 = (Pair) it.next();
            linkedHashMap.put(pair2.first, pair2.second);
        }
        return linkedHashMap;
    }

    public static LinkedHashMap toMutableMap(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new LinkedHashMap(map);
    }

    public static Object zza(Context context, Callable callable) {
        try {
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return callable.call();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            zzo.zzh("Unexpected exception.", th);
            zzbun.zza(context).zzh(th, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }

    public static final void execute(Throwable th) {
        HashMap map;
        FeatureManager.Feature feature;
        if (!enabled || th == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            FeatureManager featureManager = FeatureManager.INSTANCE;
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "it.className");
            synchronized (FeatureManager.INSTANCE) {
                map = FeatureManager.featureMapping;
                if (map.isEmpty()) {
                    map.put(FeatureManager.Feature.AAM, new String[]{"com.facebook.appevents.aam."});
                    map.put(FeatureManager.Feature.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                    map.put(FeatureManager.Feature.CloudBridge, new String[]{"com.facebook.appevents.cloudbridge."});
                    map.put(FeatureManager.Feature.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                    map.put(FeatureManager.Feature.AnrReport, new String[]{"com.facebook.internal.instrument.anrreport."});
                    map.put(FeatureManager.Feature.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                    map.put(FeatureManager.Feature.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                    map.put(FeatureManager.Feature.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                    map.put(FeatureManager.Feature.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                    map.put(FeatureManager.Feature.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                    map.put(FeatureManager.Feature.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
                    map.put(FeatureManager.Feature.IapLogging, new String[]{"com.facebook.appevents.iap."});
                    map.put(FeatureManager.Feature.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
                }
            }
            Iterator it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    feature = FeatureManager.Feature.Unknown;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                feature = (FeatureManager.Feature) entry.getKey();
                String[] strArr = (String[]) entry.getValue();
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    String str = strArr[i];
                    i++;
                    if (StringsKt__StringsKt.startsWith(className, str, false)) {
                        break;
                    }
                }
            }
            if (feature != FeatureManager.Feature.Unknown) {
                FeatureManager featureManager2 = FeatureManager.INSTANCE;
                Intrinsics.checkNotNullParameter(feature, "feature");
                FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString(Intrinsics.stringPlus(feature, "FBSDKFeature"), "16.0.0").apply();
                hashSet.add(feature.toString());
            }
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (!UserSettingsManager.getAutoLogAppEventsEnabled() || hashSet.isEmpty()) {
            return;
        }
        JSONArray jSONArray = new JSONArray((Collection) hashSet);
        InstrumentData instrumentData = new InstrumentData();
        instrumentData.type = InstrumentData.Type.Analysis;
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        instrumentData.timestamp = lValueOf;
        instrumentData.featureNames = jSONArray;
        StringBuffer stringBuffer = new StringBuffer(dLDI.SCgLyFPXofuVKMF);
        stringBuffer.append(String.valueOf(lValueOf));
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuffer()\n            .append(InstrumentUtility.ANALYSIS_REPORT_PREFIX)\n            .append(timestamp.toString())\n            .append(\".json\")\n            .toString()");
        instrumentData.filename = string;
        instrumentData.save();
    }

    public static Map toMap(AbstractMap abstractMap) {
        Intrinsics.checkNotNullParameter(abstractMap, "<this>");
        int size = abstractMap.size();
        if (size == 0) {
            return EmptyMap.INSTANCE;
        }
        if (size != 1) {
            return toMutableMap(abstractMap);
        }
        Intrinsics.checkNotNullParameter(abstractMap, "<this>");
        Map.Entry entry = (Map.Entry) abstractMap.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
