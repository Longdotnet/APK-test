package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final AppMeasurementSdk zza;
    final Map zzb;

    public AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        zzah.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
        this.zzb = new ConcurrentHashMap();
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    public static void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            AnalyticsConnector analyticsConnector = zzc;
            zzah.checkNotNull(analyticsConnector);
            ((AnalyticsConnectorImpl) analyticsConnector).zza.zza.zzI(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzc(String str) {
        return (str.isEmpty() || !this.zzb.containsKey(str) || this.zzb.get(str) == null) ? false : true;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.zzj(str2, bundle)) {
            this.zza.zza.zzw(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.zza.zzq(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(zzc.zzb((Bundle) it.next()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return this.zza.zza.zza(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zza.zza.zzr(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zzl(str) && zzc.zzj(str2, bundle) && zzc.zzh(str, str2, bundle)) {
            zzc.zze(str, str2, bundle);
            this.zza.zza.zzz(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        com.google.firebase.analytics.connector.internal.zza zzgVar;
        zzah.checkNotNull(analyticsConnectorListener);
        if (!zzc.zzl(str) || zzc(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.zza;
        if ("fiam".equals(str)) {
            zzgVar = new zze(appMeasurementSdk, analyticsConnectorListener);
        } else {
            zzgVar = "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
        }
        if (zzgVar == null) {
            return null;
        }
        this.zzb.put(str, zzgVar);
        return new AnalyticsConnector.AnalyticsConnectorHandle() { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public final void registerEventNames(Set set) {
                AnalyticsConnectorImpl analyticsConnectorImpl = AnalyticsConnectorImpl.this;
                String str2 = str;
                if (!analyticsConnectorImpl.zzc(str2) || !str2.equals("fiam") || set == null || set.isEmpty()) {
                    return;
                }
                ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzb(set);
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public final void unregister() {
                AnalyticsConnectorImpl analyticsConnectorImpl = AnalyticsConnectorImpl.this;
                String str2 = str;
                if (analyticsConnectorImpl.zzc(str2)) {
                    AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListenerZza = ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zza();
                    if (analyticsConnectorListenerZza != null) {
                        analyticsConnectorListenerZza.onMessageTriggered(0, null);
                    }
                    analyticsConnectorImpl.zzb.remove(str2);
                }
            }

            @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
            public final void unregisterEventNames() {
                AnalyticsConnectorImpl analyticsConnectorImpl = AnalyticsConnectorImpl.this;
                String str2 = str;
                if (analyticsConnectorImpl.zzc(str2) && str2.equals("fiam")) {
                    ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzc();
                }
            }
        };
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        if (zzc.zzi(conditionalUserProperty)) {
            AppMeasurementSdk appMeasurementSdk = this.zza;
            appMeasurementSdk.zza.zzE(zzc.zza(conditionalUserProperty));
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zzl(str) && zzc.zzm(str, str2)) {
            this.zza.zza.zzO(str, str2, obj, true);
        }
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        zzah.checkNotNull(firebaseApp);
        zzah.checkNotNull(context);
        zzah.checkNotNull(subscriber);
        zzah.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                try {
                    if (zzc == null) {
                        Bundle bundle = new Bundle(1);
                        if (firebaseApp.isDefaultApp()) {
                            subscriber.subscribe(DataCollectionDefaultChange.class, new Executor() { // from class: com.google.firebase.analytics.connector.zza
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new EventHandler() { // from class: com.google.firebase.analytics.connector.zzb
                                @Override // com.google.firebase.events.EventHandler
                                public final void handle(Event event) {
                                    AnalyticsConnectorImpl.zza(event);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                        }
                        zzc = new AnalyticsConnectorImpl(zzef.zzg(context, null, null, null, bundle).zzd());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzc;
    }
}
