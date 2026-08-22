package com.facebook.devicerequests.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceRequestsHelper {
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();
    public static final HashMap deviceRequestsListeners = new HashMap();

    public static final void cleanUpAdvertisementService(String str) {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return;
        }
        try {
            INSTANCE.cleanUpAdvertisementServiceImpl(str);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(DeviceRequestsHelper.class, th);
        }
    }

    public static final boolean isAvailable() {
        if (CrashShieldHandler.isObjectCrashing(DeviceRequestsHelper.class)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            return appSettingsWithoutQuery != null && appSettingsWithoutQuery.smartLoginOptions.contains(SmartLoginOption.Enabled);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(DeviceRequestsHelper.class, th);
            return false;
        }
    }

    public final void cleanUpAdvertisementServiceImpl(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        HashMap map = deviceRequestsListeners;
        try {
            NsdManager.RegistrationListener registrationListener = (NsdManager.RegistrationListener) map.get(str);
            if (registrationListener != null) {
                Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
                }
                try {
                    ((NsdManager) systemService).unregisterService(registrationListener);
                } catch (IllegalArgumentException unused) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                }
                map.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
        }
    }

    public final boolean startAdvertisementServiceImpl(final String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            HashMap map = deviceRequestsListeners;
            if (map.containsKey(str)) {
                return true;
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            String strReplace = wsbWxekY.LQVh.replace('.', '|');
            Intrinsics.checkNotNullExpressionValue(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
            final String str2 = "fbsdk_" + Intrinsics.stringPlus(strReplace, "android-") + '_' + ((Object) str);
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType("_fb._tcp.");
            nsdServiceInfo.setServiceName(str2);
            nsdServiceInfo.setPort(80);
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
            }
            NsdManager.RegistrationListener registrationListener = new NsdManager.RegistrationListener() { // from class: com.facebook.devicerequests.internal.DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1
                @Override // android.net.nsd.NsdManager.RegistrationListener
                public final void onRegistrationFailed(NsdServiceInfo serviceInfo, int i) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public final void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
                    Intrinsics.checkNotNullParameter(NsdServiceInfo, "NsdServiceInfo");
                    if (Intrinsics.areEqual(str2, NsdServiceInfo.getServiceName())) {
                        return;
                    }
                    DeviceRequestsHelper deviceRequestsHelper = DeviceRequestsHelper.INSTANCE;
                    DeviceRequestsHelper.cleanUpAdvertisementService(str);
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public final void onServiceUnregistered(NsdServiceInfo serviceInfo) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                }

                @Override // android.net.nsd.NsdManager.RegistrationListener
                public final void onUnregistrationFailed(NsdServiceInfo serviceInfo, int i) {
                    Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
                }
            };
            map.put(str, registrationListener);
            ((NsdManager) systemService).registerService(nsdServiceInfo, 1, registrationListener);
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(this, th);
            return false;
        }
    }
}
