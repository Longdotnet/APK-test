package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.ConfigurationCompat$Api24Impl;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import com.daerisoft.thespikerm.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zac {
    public static final SimpleArrayMap zaa = new SimpleArrayMap();
    public static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        String strZaa = zaa(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, strZaa);
        }
        if (i == 2) {
            return Hex.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, strZaa);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, strZaa);
        }
        if (i == 5) {
            return zag(context, "common_google_play_services_invalid_account_text", strZaa);
        }
        if (i == 7) {
            return zag(context, "common_google_play_services_network_error_text", strZaa);
        }
        if (i == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, strZaa);
        }
        if (i == 20) {
            return zag(context, "common_google_play_services_restricted_profile_text", strZaa);
        }
        switch (i) {
            case 16:
                return zag(context, "common_google_play_services_api_unavailable_text", strZaa);
            case 17:
                return zag(context, "common_google_play_services_sign_in_failed_text", strZaa);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, strZaa);
            default:
                return resources.getString(R.string.common_google_play_services_unknown_issue, strZaa);
        }
    }

    public static String zag(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String strZah = zah(context, str);
        if (strZah == null) {
            strZah = resources.getString(R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, strZah, str2);
    }

    public static String zah(Context context, String str) {
        Resources resourcesForApplication;
        String str2 = ZRqOdXiy.KBBSPKXujQv;
        SimpleArrayMap simpleArrayMap = zaa;
        synchronized (simpleArrayMap) {
            try {
                Configuration configuration = context.getResources().getConfiguration();
                Locale locale = (Build.VERSION.SDK_INT >= 24 ? new LocaleListCompat(new LocaleListPlatformWrapper(ConfigurationCompat$Api24Impl.getLocales(configuration))) : LocaleListCompat.create(configuration.locale)).mImpl.get(0);
                if (!locale.equals(zab)) {
                    simpleArrayMap.clear();
                    zab = locale;
                }
                String str3 = (String) simpleArrayMap.getOrDefault(str, null);
                if (str3 != null) {
                    return str3;
                }
                int i = GooglePlayServicesUtil.$r8$clinit;
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
                } catch (PackageManager.NameNotFoundException unused) {
                    resourcesForApplication = null;
                }
                if (resourcesForApplication == null) {
                    return null;
                }
                int identifier = resourcesForApplication.getIdentifier(str, "string", "com.google.android.gms");
                if (identifier == 0) {
                    Log.w("GoogleApiAvailability", "Missing resource: ".concat(str));
                    return null;
                }
                String string = resourcesForApplication.getString(identifier);
                if (TextUtils.isEmpty(string)) {
                    Log.w("GoogleApiAvailability", str2.concat(str));
                    return null;
                }
                zaa.put(str, string);
                return string;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String zaf(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", jIKWv.KxffGdCZLo);
                return zah(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zah(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zah(context, JuorMn.nwV);
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zah(context, "common_google_play_services_restricted_profile_title");
        }
    }
}
