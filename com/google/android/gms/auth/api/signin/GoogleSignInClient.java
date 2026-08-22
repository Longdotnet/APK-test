package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.dynamite.DynamiteModule;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleSignInClient extends GoogleApi {
    public static int zba = 1;

    public final synchronized int zba() {
        int i;
        try {
            i = zba;
            if (i == 1) {
                Context applicationContext = getApplicationContext();
                GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
                int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, 12451000);
                if (iIsGooglePlayServicesAvailable == 0) {
                    i = 4;
                    zba = 4;
                } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, null, iIsGooglePlayServicesAvailable) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                    i = 2;
                    zba = 2;
                } else {
                    i = 3;
                    zba = 3;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }
}
