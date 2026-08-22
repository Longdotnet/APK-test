package com.facebook.appevents.codeless;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.daerisoft.thespikerm.GoogleMobileAdsGM;
import com.facebook.FacebookSdk;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.UserDataStore$$ExternalSyntheticLambda0;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.Model;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.internal.ads.zzbxf;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.zzaa;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CodelessManager$$ExternalSyntheticLambda0 implements OnUserEarnedRewardListener, OnPaidEventListener, FileDownloadTask.Callback, SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, Deferred.DeferredHandler {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ CodelessManager$$ExternalSyntheticLambda0(Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0;
        AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore.config;
        int i = autoValue_EventStoreConfig.loadBatchSize;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        ArrayList arrayListLoadEvents = sQLiteEventStore.loadEvents(sQLiteDatabase, autoValue_TransportContext, i);
        for (Priority priority : Priority.values()) {
            if (priority != autoValue_TransportContext.priority) {
                int size = autoValue_EventStoreConfig.loadBatchSize - arrayListLoadEvents.size();
                if (size <= 0) {
                    break;
                }
                zzaa zzaaVarBuilder = AutoValue_TransportContext.builder();
                zzaaVarBuilder.setBackendName(autoValue_TransportContext.backendName);
                if (priority == null) {
                    throw new NullPointerException("Null priority");
                }
                zzaaVarBuilder.zzc = priority;
                zzaaVarBuilder.zzb = autoValue_TransportContext.extras;
                arrayListLoadEvents.addAll(sQLiteEventStore.loadEvents(sQLiteDatabase, zzaaVarBuilder.m98build(), size));
            }
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i2 = 0; i2 < arrayListLoadEvents.size(); i2++) {
            sb.append(((AutoValue_PersistedEvent) arrayListLoadEvents.get(i2)).id);
            if (i2 < arrayListLoadEvents.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor cursorQuery = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", FirebaseAnalytics.Param.VALUE}, sb.toString(), null, null, null, null);
        while (cursorQuery.moveToNext()) {
            try {
                long j = cursorQuery.getLong(0);
                Set hashSet = (Set) map.get(Long.valueOf(j));
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map.put(Long.valueOf(j), hashSet);
                }
                hashSet.add(new SQLiteEventStore.Metadata(cursorQuery.getString(1), cursorQuery.getString(2)));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        ListIterator listIterator = arrayListLoadEvents.listIterator();
        while (listIterator.hasNext()) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) listIterator.next();
            if (map.containsKey(Long.valueOf(autoValue_PersistedEvent.id))) {
                Request builder = autoValue_PersistedEvent.event.toBuilder();
                long j2 = autoValue_PersistedEvent.id;
                for (SQLiteEventStore.Metadata metadata : (Set) map.get(Long.valueOf(j2))) {
                    builder.addMetadata(metadata.key, metadata.value);
                }
                listIterator.set(new AutoValue_PersistedEvent(j2, autoValue_PersistedEvent.transportContext, builder.build()));
            }
        }
        return arrayListLoadEvents;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.$r8$classId) {
            case 8:
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) ((Uploader) this.f$0).eventStore;
                sQLiteEventStore.getClass();
                Iterable iterable = (Iterable) this.f$1;
                if (iterable.iterator().hasNext()) {
                    sQLiteEventStore.getDb().compileStatement("DELETE FROM events WHERE _id in " + SQLiteEventStore.toIdList(iterable)).execute();
                    break;
                }
                break;
            default:
                Uploader uploader = (Uploader) this.f$0;
                uploader.getClass();
                for (Map.Entry entry : ((HashMap) this.f$1).entrySet()) {
                    ((SQLiteEventStore) uploader.clientHealthMetricsStore).recordLogEventDropped(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        ((Deferred.DeferredHandler) this.f$0).handle(provider);
        ((Deferred.DeferredHandler) this.f$1).handle(provider);
    }

    @Override // com.facebook.appevents.internal.FileDownloadTask.Callback
    public void onComplete(File file) {
        ModelManager.TaskHandler slave = (ModelManager.TaskHandler) this.f$0;
        Intrinsics.checkNotNullParameter(slave, "$slave");
        Intrinsics.checkNotNullParameter(file, "file");
        slave.model = (Model) this.f$1;
        slave.ruleFile = file;
        Runnable runnable = slave.onPostExecute;
        if (runnable == null) {
            return;
        }
        runnable.run();
    }

    @Override // com.google.android.gms.ads.OnPaidEventListener
    public void onPaidEvent(AdValue adValue) {
        switch (this.$r8$classId) {
            case 3:
                GoogleMobileAdsGM.AnonymousClass2 anonymousClass2 = (GoogleMobileAdsGM.AnonymousClass2) this.f$0;
                anonymousClass2.getClass();
                InterstitialAd interstitialAd = (InterstitialAd) this.f$1;
                AdapterResponseInfo adapterResponseInfo = interstitialAd.getResponseInfo().zzc;
                if (adapterResponseInfo != null) {
                    anonymousClass2.this$0.onPaidEventHandler(adValue, interstitialAd.getAdUnitId(), "Interstitial", adapterResponseInfo, interstitialAd.getResponseInfo().getMediationAdapterClassName());
                    break;
                }
                break;
            case 4:
                GoogleMobileAdsGM.AnonymousClass4 anonymousClass4 = (GoogleMobileAdsGM.AnonymousClass4) this.f$0;
                anonymousClass4.getClass();
                RewardedAd rewardedAd = (RewardedAd) this.f$1;
                AdapterResponseInfo adapterResponseInfo2 = rewardedAd.getResponseInfo().zzc;
                if (adapterResponseInfo2 != null) {
                    anonymousClass4.this$0.onPaidEventHandler(adValue, rewardedAd.getAdUnitId(), "RewardedVideo", adapterResponseInfo2, rewardedAd.getResponseInfo().getMediationAdapterClassName());
                    break;
                }
                break;
            default:
                GoogleMobileAdsGM.AnonymousClass6 anonymousClass6 = (GoogleMobileAdsGM.AnonymousClass6) this.f$0;
                anonymousClass6.getClass();
                RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) this.f$1;
                AdapterResponseInfo adapterResponseInfo3 = rewardedInterstitialAd.getResponseInfo().zzc;
                if (adapterResponseInfo3 != null) {
                    anonymousClass6.this$0.onPaidEventHandler(adValue, rewardedInterstitialAd.getAdUnitId(), "RewardedInterstitial", adapterResponseInfo3, rewardedInterstitialAd.getResponseInfo().getMediationAdapterClassName());
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001b  */
    public void onShake() {
        boolean z;
        int i = 1;
        String str = (String) this.f$1;
        if (CrashShieldHandler.isObjectCrashing(CodelessManager.class)) {
            return;
        }
        FetchedAppSettings fetchedAppSettings = (FetchedAppSettings) this.f$0;
        boolean value = false;
        if (fetchedAppSettings != null) {
            try {
                if (fetchedAppSettings.codelessEventsEnabled) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(CodelessManager.class, th);
            }
        } else {
            z = false;
        }
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        UserSettingsManager userSettingsManager = UserSettingsManager.INSTANCE;
        if (!CrashShieldHandler.isObjectCrashing(UserSettingsManager.class)) {
            try {
                UserSettingsManager.INSTANCE.initializeIfNotInitialized();
                value = UserSettingsManager.codelessSetupEnabled.getValue();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(UserSettingsManager.class, th2);
            }
        }
        if (z && value) {
            CodelessManager codelessManager = CodelessManager.INSTANCE;
            if (CrashShieldHandler.isObjectCrashing(codelessManager)) {
                return;
            }
            try {
                if (CodelessManager.isCheckingSession) {
                    return;
                }
                CodelessManager.isCheckingSession = true;
                FacebookSdk.getExecutor().execute(new UserDataStore$$ExternalSyntheticLambda0(str, i));
                return;
            } catch (Throwable th3) {
                CrashShieldHandler.handleThrowable(codelessManager, th3);
                return;
            }
            CrashShieldHandler.handleThrowable(CodelessManager.class, th);
        }
    }

    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
    public void onUserEarnedReward(RewardItem rewardItem) {
        switch (this.$r8$classId) {
            case 1:
                ((GoogleMobileAdsGM) this.f$0).lambda$showRewardedInterstitialAd$14((RewardedInterstitialAd) this.f$1, (zzbxf) rewardItem);
                break;
            default:
                ((GoogleMobileAdsGM) this.f$0).lambda$showRewardedAd$11((RewardedAd) this.f$1, (zzbxf) rewardItem);
                break;
        }
    }
}
