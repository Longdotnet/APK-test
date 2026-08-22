package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AnalyticsUserIDStore;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppEventsLoggerUtility {
    public static final HashMap API_ACTIVITY_TYPE_TO_STRING = MapsKt__MapsKt.hashMapOf(new Pair(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), new Pair(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes2.dex */
    public final class GraphAPIActivityType {
        public static final /* synthetic */ GraphAPIActivityType[] $VALUES;
        public static final GraphAPIActivityType CUSTOM_APP_EVENTS;
        public static final GraphAPIActivityType MOBILE_INSTALL_EVENT;

        static {
            GraphAPIActivityType graphAPIActivityType = new GraphAPIActivityType("MOBILE_INSTALL_EVENT", 0);
            MOBILE_INSTALL_EVENT = graphAPIActivityType;
            GraphAPIActivityType graphAPIActivityType2 = new GraphAPIActivityType(oKjScaD.PAJmWGWzKNy, 1);
            CUSTOM_APP_EVENTS = graphAPIActivityType2;
            $VALUES = new GraphAPIActivityType[]{graphAPIActivityType, graphAPIActivityType2};
        }

        public static GraphAPIActivityType valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (GraphAPIActivityType) Enum.valueOf(GraphAPIActivityType.class, value);
        }

        public static GraphAPIActivityType[] values() {
            return (GraphAPIActivityType[]) Arrays.copyOf($VALUES, 2);
        }
    }

    public static final JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        ReentrantReadWriteLock reentrantReadWriteLock = AnalyticsUserIDStore.lock;
        if (!AnalyticsUserIDStore.initialized) {
            Log.w("AnalyticsUserIDStore", "initStore should have been called before calling setUserID");
            AnalyticsUserIDStore.initAndWait();
        }
        ReentrantReadWriteLock reentrantReadWriteLock2 = AnalyticsUserIDStore.lock;
        reentrantReadWriteLock2.readLock().lock();
        try {
            String str2 = AnalyticsUserIDStore.userID;
            reentrantReadWriteLock2.readLock().unlock();
            if (str2 != null) {
                jSONObject.put("app_user_id", str2);
            }
            FeatureManager featureManager = FeatureManager.INSTANCE;
            FeatureManager.Feature feature = FeatureManager.Feature.ServiceUpdateCompliance;
            if (!FeatureManager.isEnabled(feature)) {
                jSONObject.put("anon_id", str);
            }
            jSONObject.put("application_tracking_enabled", !z);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            jSONObject.put("advertiser_id_collection_enabled", UserSettingsManager.getAdvertiserIDCollectionEnabled());
            if (attributionIdentifiers != null) {
                if (FeatureManager.isEnabled(feature) && (Build.VERSION.SDK_INT < 31 || !Utility.isGooglePlayServicesAvailable(context) || !attributionIdentifiers.isTrackingLimited)) {
                    jSONObject.put("anon_id", str);
                }
                if (attributionIdentifiers.attributionId != null && (!FeatureManager.isEnabled(feature) || Build.VERSION.SDK_INT < 31 || !Utility.isGooglePlayServicesAvailable(context) || !attributionIdentifiers.isTrackingLimited)) {
                    jSONObject.put("attribution", attributionIdentifiers.attributionId);
                }
                if (attributionIdentifiers.getAndroidAdvertiserId() != null) {
                    jSONObject.put("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                    jSONObject.put("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited);
                }
                if (!attributionIdentifiers.isTrackingLimited) {
                    UserDataStore userDataStore = UserDataStore.INSTANCE;
                    String strMapToJsonStr = null;
                    if (!CrashShieldHandler.isObjectCrashing(UserDataStore.class)) {
                        try {
                            boolean z2 = UserDataStore.initialized.get();
                            UserDataStore userDataStore2 = UserDataStore.INSTANCE;
                            if (!z2) {
                                userDataStore2.initAndWait();
                            }
                            HashMap map = new HashMap();
                            map.putAll(UserDataStore.externalHashedUserData);
                            map.putAll(userDataStore2.getEnabledInternalUserData());
                            strMapToJsonStr = Utility.mapToJsonStr(map);
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(UserDataStore.class, th);
                        }
                    }
                    if (strMapToJsonStr.length() != 0) {
                        jSONObject.put("ud", strMapToJsonStr);
                    }
                }
                String str3 = attributionIdentifiers.androidInstallerPackage;
                if (str3 != null) {
                    jSONObject.put("installer_package", str3);
                }
            }
            try {
                Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
            } catch (Exception e) {
                GraphRequest.Companion companion = Logger.Companion;
                e.toString();
                synchronized (FacebookSdk.loggingBehaviors) {
                }
            }
            JSONObject dataProcessingOptions = Utility.getDataProcessingOptions();
            if (dataProcessingOptions != null) {
                Iterator itKeys = dataProcessingOptions.keys();
                while (itKeys.hasNext()) {
                    String str4 = (String) itKeys.next();
                    jSONObject.put(str4, dataProcessingOptions.get(str4));
                }
            }
            jSONObject.put("application_package_name", context.getPackageName());
            return jSONObject;
        } catch (Throwable th2) {
            AnalyticsUserIDStore.lock.readLock().unlock();
            throw th2;
        }
    }
}
