package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Hex;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzxo {
    private final int zza;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    public zzxo(String str) {
        int i = -1;
        try {
            List listZzd = zzaf.zzc("[.-]").zzd(str);
            if (listZzd.size() == 1) {
                i = Integer.parseInt(str);
                str = str;
            } else if (listZzd.size() >= 3) {
                str = str;
                int i2 = (Integer.parseInt((String) listZzd.get(1)) * 1000) + (Integer.parseInt((String) listZzd.get(0)) * 1000000);
                int i3 = Integer.parseInt((String) listZzd.get(2));
                i = i2 + i3;
                str = i3;
            }
            str = str;
        } catch (IllegalArgumentException e) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                Log.d("LibraryVersionContainer", String.format("Version code parsing failed for: %s with exception %s.", new Object[]{str, e}));
            }
        }
        this.zza = i;
    }

    public static zzxo zza() throws Throwable {
        String str;
        InputStream resourceAsStream;
        String str2;
        LibraryVersion libraryVersion = LibraryVersion.zzb;
        libraryVersion.getClass();
        GmsLogger gmsLogger = LibraryVersion.zza;
        zzah.checkNotEmpty("firebase-auth", "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = libraryVersion.zzc;
        if (concurrentHashMap.containsKey("firebase-auth")) {
            str2 = (String) concurrentHashMap.get("firebase-auth");
        } else {
            Properties properties = new Properties();
            InputStream inputStream = null;
            property = null;
            property = null;
            String property = null;
            inputStream = null;
            try {
                try {
                    resourceAsStream = LibraryVersion.class.getResourceAsStream("/firebase-auth.properties");
                    try {
                        if (resourceAsStream != null) {
                            properties.load(resourceAsStream);
                            property = properties.getProperty("version", null);
                            String str3 = "firebase-auth version is " + property;
                            if (Log.isLoggable(gmsLogger.zza, 2)) {
                                Log.v("LibraryVersion", gmsLogger.zza(str3));
                            }
                        } else if (Log.isLoggable(gmsLogger.zza, 5)) {
                            Log.w("LibraryVersion", gmsLogger.zza("Failed to get app version for libraryName: firebase-auth"));
                        }
                    } catch (IOException e) {
                        e = e;
                        str = property;
                        inputStream = resourceAsStream;
                        if (Log.isLoggable(gmsLogger.zza, 6)) {
                            Log.e("LibraryVersion", gmsLogger.zza("Failed to get app version for libraryName: firebase-auth"), e);
                        }
                        resourceAsStream = inputStream;
                        property = str;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = resourceAsStream;
                        if (inputStream != null) {
                            Hex.closeQuietly(inputStream);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
                str = null;
            }
            if (resourceAsStream != null) {
                Hex.closeQuietly(resourceAsStream);
            }
            if (property == null) {
                if (Log.isLoggable(gmsLogger.zza, 3)) {
                    Log.d("LibraryVersion", gmsLogger.zza(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"));
                }
                str2 = "UNKNOWN";
            } else {
                str2 = property;
            }
            concurrentHashMap.put("firebase-auth", str2);
        }
        if (TextUtils.isEmpty(str2) || str2.equals("UNKNOWN")) {
            str2 = "-1";
        }
        return new zzxo(str2);
    }

    public final String zzb() {
        return CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("X", Integer.toString(this.zza));
    }
}
