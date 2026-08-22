package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzbc;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Validate {
    public static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    public static FeatureManager.Feature fromInt(int i) {
        FeatureManager.Feature[] featureArrValuesCustom = FeatureManager.Feature.valuesCustom();
        int length = featureArrValuesCustom.length;
        int i2 = 0;
        while (i2 < length) {
            FeatureManager.Feature feature = featureArrValuesCustom[i2];
            i2++;
            if (feature.code == i) {
                return feature;
            }
        }
        return FeatureManager.Feature.Unknown;
    }

    public static final String getChromePackage() {
        if (CrashShieldHandler.isObjectCrashing(Validate.class)) {
            return null;
        }
        try {
            Context applicationContext = FacebookSdk.getApplicationContext();
            List<ResolveInfo> listQueryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            Intrinsics.checkNotNullExpressionValue(listQueryIntentServices, "context.packageManager.queryIntentServices(serviceIntent, 0)");
            String[] strArr = CHROME_PACKAGES;
            HashSet hashSet = new HashSet(MapsKt__MapsKt.mapCapacity(3));
            ArraysKt.toCollection(strArr, hashSet);
            Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
            while (it.hasNext()) {
                ServiceInfo serviceInfo = it.next().serviceInfo;
                if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                    return serviceInfo.packageName;
                }
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Validate.class, th);
            return null;
        }
    }

    public static final String getDefaultRedirectURI() {
        if (CrashShieldHandler.isObjectCrashing(Validate.class)) {
            return null;
        }
        try {
            return Intrinsics.stringPlus(FacebookSdk.getApplicationContext().getPackageName(), "fbconnect://cct.");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Validate.class, th);
            return null;
        }
    }

    public static final String getValidRedirectURI(String developerDefinedRedirectURI) {
        if (CrashShieldHandler.isObjectCrashing(Validate.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(developerDefinedRedirectURI, "developerDefinedRedirectURI");
            if (hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), developerDefinedRedirectURI)) {
                return developerDefinedRedirectURI;
            }
            return hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI()) ? getDefaultRedirectURI() : "";
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(Validate.class, th);
            return null;
        }
    }

    public static final boolean hasCustomTabRedirectActivity(Context context, String redirectURI) {
        List<ResolveInfo> listQueryIntentActivities;
        Intrinsics.checkNotNullParameter(redirectURI, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(redirectURI));
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!Intrinsics.areEqual(activityInfo.name, "com.facebook.CustomTabActivity") || !Intrinsics.areEqual(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    public static final void notEmpty(String arg, String str) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        if (arg.length() <= 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Argument '", str, "' cannot be empty").toString());
        }
    }

    public static final void notEmptyAndContainsNoNulls(GraphRequestBatch container) {
        Intrinsics.checkNotNullParameter(container, "container");
        Iterator it = container.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container 'requests' cannot contain null values");
            }
        }
        if (container.isEmpty()) {
            throw new IllegalArgumentException("Container 'requests' cannot be empty".toString());
        }
    }

    public static final void sdkInitialized() {
        if (!FacebookSdk.sdkInitialized.get()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:110:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0096  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00db  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ee A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2 A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0124 A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0133 A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x013d A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x014c A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x015a  */
    /* JADX WARN: Code duplicated, block: B:68:0x015c A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0166 A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x016a A[Catch: all -> 0x0104, Exception -> 0x0107, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0173 A[Catch: all -> 0x0104, Exception -> 0x0107, TRY_LEAVE, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x0187  */
    /* JADX WARN: Code duplicated, block: B:79:0x0188 A[Catch: all -> 0x01b7, Exception -> 0x01b9, TryCatch #2 {Exception -> 0x01b9, blocks: (B:76:0x0181, B:79:0x0188, B:82:0x019e, B:84:0x01a4, B:93:0x01c7), top: B:112:0x0181 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x019c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d6 A[Catch: all -> 0x0104, Exception -> 0x0107, TRY_ENTER, TryCatch #8 {Exception -> 0x0107, all -> 0x0104, blocks: (B:42:0x00e0, B:44:0x00ee, B:46:0x00f2, B:54:0x0109, B:56:0x0124, B:58:0x0133, B:65:0x0154, B:70:0x0166, B:72:0x016a, B:74:0x0173, B:68:0x015c, B:61:0x013d, B:63:0x014c, B:98:0x01d6, B:99:0x01dd), top: B:113:0x00e0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static AttributionIdentifiers getAttributionIdentifiers(Context context) throws Throwable {
        AttributionIdentifiers attributionIdentifiers;
        Cursor cursorQuery;
        AttributionIdentifiers attributionIdentifiers2;
        String[] strArr;
        ProviderInfo providerInfoResolveContentProvider;
        ProviderInfo providerInfoResolveContentProvider2;
        Uri uri;
        String str;
        Uri uri2;
        PackageManager packageManager;
        String installerPackageName;
        int columnIndex;
        int columnIndex2;
        String str2;
        zzbc zzbcVar;
        Intent intent;
        Method methodQuietly;
        Object objInvokeMethodQuietly;
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r7 = 0;
        try {
            Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            try {
                try {
                    if (methodQuietly2 != null) {
                        Object objInvokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly2, context);
                        if ((objInvokeMethodQuietly2 instanceof Integer) && Intrinsics.areEqual(objInvokeMethodQuietly2, 0) && (methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class)) != null && (objInvokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context)) != null) {
                            Method methodQuietly3 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "getId", new Class[0]);
                            Method methodQuietly4 = Utility.getMethodQuietly(objInvokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                            if (methodQuietly3 != null && methodQuietly4 != null) {
                                attributionIdentifiers = new AttributionIdentifiers();
                                attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly3, new Object[0]);
                                Boolean bool = (Boolean) Utility.invokeMethodQuietly(objInvokeMethodQuietly, methodQuietly4, new Object[0]);
                                attributionIdentifiers.isTrackingLimited = bool == null ? false : bool.booleanValue();
                            }
                        }
                        if (attributionIdentifiers == null) {
                            zzbcVar = new zzbc();
                            intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                            intent.setPackage("com.google.android.gms");
                            try {
                                if (context.bindService(intent, zzbcVar, 1)) {
                                    try {
                                        try {
                                            AttributionIdentifiers.GoogleAdInfo googleAdInfo = new AttributionIdentifiers.GoogleAdInfo(zzbcVar.getBinder());
                                            AttributionIdentifiers attributionIdentifiers3 = new AttributionIdentifiers();
                                            attributionIdentifiers3.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                                            attributionIdentifiers3.isTrackingLimited = googleAdInfo.isTrackingLimited();
                                            context.unbindService(zzbcVar);
                                            attributionIdentifiers = attributionIdentifiers3;
                                        } catch (Throwable th) {
                                            context.unbindService(zzbcVar);
                                            throw th;
                                        }
                                    } catch (Exception unused) {
                                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                                        context.unbindService(zzbcVar);
                                        attributionIdentifiers = null;
                                        if (attributionIdentifiers == null) {
                                            attributionIdentifiers = new AttributionIdentifiers();
                                        }
                                        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                                            throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                                        }
                                        attributionIdentifiers2 = AttributionIdentifiers.cachedIdentifiers;
                                        if (attributionIdentifiers2 == null) {
                                        }
                                        strArr = new String[]{"aid", "androidid", "limit_tracking"};
                                        providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                                        providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(FKidOcdAYt.aLhqRhXIbABHUo, 0);
                                        if (providerInfoResolveContentProvider != null) {
                                            HashSet hashSet = FacebookSignatureValidator.validAppSignatureHashes;
                                            str2 = providerInfoResolveContentProvider.packageName;
                                            Intrinsics.checkNotNullExpressionValue(str2, "contentProviderInfo.packageName");
                                            if (FacebookSignatureValidator.validateSignature(context, str2)) {
                                                uri2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                                            } else {
                                                if (providerInfoResolveContentProvider2 != null) {
                                                    HashSet hashSet2 = FacebookSignatureValidator.validAppSignatureHashes;
                                                    str = providerInfoResolveContentProvider2.packageName;
                                                    Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                                                    if (FacebookSignatureValidator.validateSignature(context, str)) {
                                                        uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                                    }
                                                }
                                                uri = null;
                                            }
                                            uri = uri2;
                                        } else {
                                            if (providerInfoResolveContentProvider2 != null) {
                                                HashSet hashSet3 = FacebookSignatureValidator.validAppSignatureHashes;
                                                str = providerInfoResolveContentProvider2.packageName;
                                                Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                                                if (FacebookSignatureValidator.validateSignature(context, str)) {
                                                    uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                                    uri = uri2;
                                                }
                                            }
                                            uri = null;
                                        }
                                        packageManager = context.getPackageManager();
                                        if (packageManager == null) {
                                            installerPackageName = null;
                                        } else {
                                            installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
                                        }
                                        if (installerPackageName != null) {
                                            attributionIdentifiers.androidInstallerPackage = installerPackageName;
                                        }
                                        if (uri == null) {
                                            attributionIdentifiers.fetchTime = System.currentTimeMillis();
                                            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                                            return attributionIdentifiers;
                                        }
                                        cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                                        if (cursorQuery != null) {
                                            try {
                                                if (cursorQuery.moveToFirst()) {
                                                    int columnIndex3 = cursorQuery.getColumnIndex("aid");
                                                    columnIndex = cursorQuery.getColumnIndex("androidid");
                                                    columnIndex2 = cursorQuery.getColumnIndex("limit_tracking");
                                                    attributionIdentifiers.attributionId = cursorQuery.getString(columnIndex3);
                                                    if (columnIndex > 0) {
                                                        attributionIdentifiers.androidAdvertiserIdValue = cursorQuery.getString(columnIndex);
                                                        attributionIdentifiers.isTrackingLimited = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
                                                    }
                                                    cursorQuery.close();
                                                    attributionIdentifiers.fetchTime = System.currentTimeMillis();
                                                    AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                                                    return attributionIdentifiers;
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                Intrinsics.stringPlus(e, "Caught unexpected exception in getAttributionId(): ");
                                                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                                                if (cursorQuery != null) {
                                                    cursorQuery.close();
                                                }
                                                return null;
                                            }
                                        }
                                        attributionIdentifiers.fetchTime = System.currentTimeMillis();
                                        AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        return attributionIdentifiers;
                                    }
                                } else {
                                    attributionIdentifiers = null;
                                }
                            } catch (SecurityException unused2) {
                            }
                            if (attributionIdentifiers == null) {
                                attributionIdentifiers = new AttributionIdentifiers();
                            }
                        }
                        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                            throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                        }
                        attributionIdentifiers2 = AttributionIdentifiers.cachedIdentifiers;
                        if (attributionIdentifiers2 == null && System.currentTimeMillis() - attributionIdentifiers2.fetchTime < 3600000) {
                            return attributionIdentifiers2;
                        }
                        strArr = new String[]{"aid", "androidid", "limit_tracking"};
                        providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                        providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(FKidOcdAYt.aLhqRhXIbABHUo, 0);
                        if (providerInfoResolveContentProvider != null) {
                            HashSet hashSet4 = FacebookSignatureValidator.validAppSignatureHashes;
                            str2 = providerInfoResolveContentProvider.packageName;
                            Intrinsics.checkNotNullExpressionValue(str2, "contentProviderInfo.packageName");
                            if (FacebookSignatureValidator.validateSignature(context, str2)) {
                                uri2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                            } else {
                                if (providerInfoResolveContentProvider2 != null) {
                                    HashSet hashSet5 = FacebookSignatureValidator.validAppSignatureHashes;
                                    str = providerInfoResolveContentProvider2.packageName;
                                    Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                                    if (FacebookSignatureValidator.validateSignature(context, str)) {
                                        uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                    }
                                }
                                uri = null;
                            }
                            uri = uri2;
                        } else {
                            if (providerInfoResolveContentProvider2 != null) {
                                HashSet hashSet6 = FacebookSignatureValidator.validAppSignatureHashes;
                                str = providerInfoResolveContentProvider2.packageName;
                                Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                                if (FacebookSignatureValidator.validateSignature(context, str)) {
                                    uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                    uri = uri2;
                                }
                            }
                            uri = null;
                        }
                        packageManager = context.getPackageManager();
                        if (packageManager == null) {
                            installerPackageName = null;
                        } else {
                            installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
                        }
                        if (installerPackageName != null) {
                            attributionIdentifiers.androidInstallerPackage = installerPackageName;
                        }
                        if (uri == null) {
                            attributionIdentifiers.fetchTime = System.currentTimeMillis();
                            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                            return attributionIdentifiers;
                        }
                        cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                        if (cursorQuery != null) {
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex4 = cursorQuery.getColumnIndex("aid");
                                columnIndex = cursorQuery.getColumnIndex("androidid");
                                columnIndex2 = cursorQuery.getColumnIndex("limit_tracking");
                                attributionIdentifiers.attributionId = cursorQuery.getString(columnIndex4);
                                if (columnIndex > 0 && columnIndex2 > 0 && attributionIdentifiers.getAndroidAdvertiserId() == null) {
                                    attributionIdentifiers.androidAdvertiserIdValue = cursorQuery.getString(columnIndex);
                                    attributionIdentifiers.isTrackingLimited = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
                                }
                                cursorQuery.close();
                                attributionIdentifiers.fetchTime = System.currentTimeMillis();
                                AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                                return attributionIdentifiers;
                            }
                        }
                        attributionIdentifiers.fetchTime = System.currentTimeMillis();
                        AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return attributionIdentifiers;
                    }
                    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                    }
                    attributionIdentifiers2 = AttributionIdentifiers.cachedIdentifiers;
                    if (attributionIdentifiers2 == null) {
                    }
                    strArr = new String[]{"aid", "androidid", "limit_tracking"};
                    providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                    providerInfoResolveContentProvider2 = context.getPackageManager().resolveContentProvider(FKidOcdAYt.aLhqRhXIbABHUo, 0);
                    if (providerInfoResolveContentProvider != null) {
                        HashSet hashSet7 = FacebookSignatureValidator.validAppSignatureHashes;
                        str2 = providerInfoResolveContentProvider.packageName;
                        Intrinsics.checkNotNullExpressionValue(str2, "contentProviderInfo.packageName");
                        if (FacebookSignatureValidator.validateSignature(context, str2)) {
                            uri2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                        } else {
                            if (providerInfoResolveContentProvider2 != null) {
                                HashSet hashSet8 = FacebookSignatureValidator.validAppSignatureHashes;
                                str = providerInfoResolveContentProvider2.packageName;
                                Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                                if (FacebookSignatureValidator.validateSignature(context, str)) {
                                    uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                }
                            }
                            uri = null;
                        }
                        uri = uri2;
                    } else {
                        if (providerInfoResolveContentProvider2 != null) {
                            HashSet hashSet9 = FacebookSignatureValidator.validAppSignatureHashes;
                            str = providerInfoResolveContentProvider2.packageName;
                            Intrinsics.checkNotNullExpressionValue(str, "wakizashiProviderInfo.packageName");
                            if (FacebookSignatureValidator.validateSignature(context, str)) {
                                uri2 = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                                uri = uri2;
                            }
                        }
                        uri = null;
                    }
                    packageManager = context.getPackageManager();
                    if (packageManager == null) {
                        installerPackageName = null;
                    } else {
                        installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
                    }
                    if (installerPackageName != null) {
                        attributionIdentifiers.androidInstallerPackage = installerPackageName;
                    }
                    if (uri == null) {
                        attributionIdentifiers.fetchTime = System.currentTimeMillis();
                        AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                        return attributionIdentifiers;
                    }
                    cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
                    if (cursorQuery != null) {
                        if (cursorQuery.moveToFirst()) {
                            int columnIndex5 = cursorQuery.getColumnIndex("aid");
                            columnIndex = cursorQuery.getColumnIndex("androidid");
                            columnIndex2 = cursorQuery.getColumnIndex("limit_tracking");
                            attributionIdentifiers.attributionId = cursorQuery.getString(columnIndex5);
                            if (columnIndex > 0) {
                                attributionIdentifiers.androidAdvertiserIdValue = cursorQuery.getString(columnIndex);
                                attributionIdentifiers.isTrackingLimited = Boolean.parseBoolean(cursorQuery.getString(columnIndex2));
                            }
                            cursorQuery.close();
                            attributionIdentifiers.fetchTime = System.currentTimeMillis();
                            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                            return attributionIdentifiers;
                        }
                    }
                    attributionIdentifiers.fetchTime = System.currentTimeMillis();
                    AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return attributionIdentifiers;
                } catch (Exception e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (r7 != 0) {
                        r7.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r7 = context;
                if (r7 != 0) {
                    r7.close();
                }
                throw th;
            }
        } catch (Exception unused3) {
            FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
        }
        attributionIdentifiers = null;
        if (attributionIdentifiers == null) {
            zzbcVar = new zzbc();
            intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, zzbcVar, 1)) {
                AttributionIdentifiers.GoogleAdInfo googleAdInfo2 = new AttributionIdentifiers.GoogleAdInfo(zzbcVar.getBinder());
                AttributionIdentifiers attributionIdentifiers4 = new AttributionIdentifiers();
                attributionIdentifiers4.androidAdvertiserIdValue = googleAdInfo2.getAdvertiserId();
                attributionIdentifiers4.isTrackingLimited = googleAdInfo2.isTrackingLimited();
                context.unbindService(zzbcVar);
                attributionIdentifiers = attributionIdentifiers4;
            } else {
                attributionIdentifiers = null;
            }
            if (attributionIdentifiers == null) {
                attributionIdentifiers = new AttributionIdentifiers();
            }
        }
    }

    public static final void notNullOrEmpty(String str, String str2) {
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Argument '", str2, PZmDzEagKNdW.uSn).toString());
        }
    }
}
