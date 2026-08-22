package com.facebook.appevents;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.facebook.FacebookSdk;
import com.facebook.appevents.aam.MetadataRule;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class UserDataStore {
    public static SharedPreferences sharedPreferences;
    public static final UserDataStore INSTANCE = new UserDataStore();
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    public static final ConcurrentHashMap externalHashedUserData = new ConcurrentHashMap();
    public static final ConcurrentHashMap internalHashedUserData = new ConcurrentHashMap();

    public final HashMap getEnabledInternalUserData() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            HashMap map = new HashMap();
            CopyOnWriteArraySet copyOnWriteArraySet = MetadataRule.rules;
            HashSet hashSet = new HashSet();
            Iterator it = MetadataRule.access$getRules$cp().iterator();
            while (it.hasNext()) {
                hashSet.add(((MetadataRule) it.next()).getName());
            }
            ConcurrentHashMap concurrentHashMap = internalHashedUserData;
            for (String str : concurrentHashMap.keySet()) {
                if (hashSet.contains(str)) {
                    map.put(str, concurrentHashMap.get(str));
                }
            }
            return map;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }

    public final synchronized void initAndWait() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = initialized;
            if (atomicBoolean.get()) {
                return;
            }
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
            sharedPreferences = defaultSharedPreferences;
            String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", "");
            if (string == null) {
                string = "";
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            String string2 = sharedPreferences2.getString("com.facebook.appevents.UserDataStore.internalUserData", ehgOP.McuauRcc);
            if (string2 == null) {
                string2 = "";
            }
            externalHashedUserData.putAll(Utility.jsonStrToMap(string));
            internalHashedUserData.putAll(Utility.jsonStrToMap(string2));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final String normalizeData(String str, String str2) {
        String strSubstring;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare(str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String string = str2.subSequence(i, length + 1).toString();
            if (string == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = string.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if ("em".equals(str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e("UserDataStore", "Setting email failure: this is not a valid email address");
                return "";
            }
            if ("ph".equals(str)) {
                Pattern patternCompile = Pattern.compile("[^0-9]");
                Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(pattern)");
                String strReplaceAll = patternCompile.matcher(lowerCase).replaceAll("");
                Intrinsics.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
                return strReplaceAll;
            }
            if (!"ge".equals(str)) {
                return lowerCase;
            }
            if (lowerCase.length() > 0) {
                strSubstring = lowerCase.substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                strSubstring = "";
            }
            if (!"f".equals(strSubstring) && !"m".equals(strSubstring)) {
                Log.e("UserDataStore", "Setting gender failure: the supported value for gender is f or m");
                return "";
            }
            return strSubstring;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return null;
        }
    }
}
