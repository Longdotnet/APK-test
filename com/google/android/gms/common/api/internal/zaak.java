package com.google.android.gms.common.api.internal;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtil;

/* JADX INFO: loaded from: classes.dex */
final class zaak implements Runnable {
    public final /* synthetic */ zaaw zaa;

    public zaak(zaaw zaawVar) {
        this.zaa = zaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zaaw zaawVar = this.zaa;
        GoogleApiAvailabilityLight googleApiAvailabilityLight = zaawVar.zad;
        Context context = zaawVar.zac;
        googleApiAvailabilityLight.getClass();
        if (GooglePlayServicesUtil.sCanceledAvailabilityNotification.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException e) {
            Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e);
        }
    }
}
