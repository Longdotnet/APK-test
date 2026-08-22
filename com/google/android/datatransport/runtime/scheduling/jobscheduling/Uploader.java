package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.CodelessManager$$ExternalSyntheticLambda0;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.connector.pDv.PZmDzEagKNdW;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import kotlin.ranges.RangesKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public final class Uploader {
    public final MetadataBackendRegistry backendRegistry;
    public final ClientHealthMetricsStore clientHealthMetricsStore;
    public final GraphRequest.Companion clock;
    public final Context context;
    public final EventStore eventStore;
    public final Executor executor;
    public final SynchronizationGuard guard;
    public final GraphRequest.Companion uptimeClock;
    public final JobInfoScheduler workScheduler;

    public Uploader(Context context, MetadataBackendRegistry metadataBackendRegistry, EventStore eventStore, JobInfoScheduler jobInfoScheduler, Executor executor, SynchronizationGuard synchronizationGuard, GraphRequest.Companion companion, GraphRequest.Companion companion2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.context = context;
        this.backendRegistry = metadataBackendRegistry;
        this.eventStore = eventStore;
        this.workScheduler = jobInfoScheduler;
        this.executor = executor;
        this.guard = synchronizationGuard;
        this.clock = companion;
        this.uptimeClock = companion2;
        this.clientHealthMetricsStore = clientHealthMetricsStore;
    }

    public final void logAndUpdateState(final AutoValue_TransportContext autoValue_TransportContext, int i) {
        TransportBackend transportBackend;
        AutoValue_BackendResponse autoValue_BackendResponse;
        String str;
        AutoValue_BackendResponse autoValue_BackendResponse2;
        int i2;
        CctTransportBackend.HttpResponse httpResponseApply;
        String str2;
        Integer numValueOf;
        String str3;
        TooltipPopup tooltipPopup;
        int i3;
        final AutoValue_TransportContext autoValue_TransportContext2 = autoValue_TransportContext;
        int i4 = 8;
        int i5 = 2;
        final int i6 = 1;
        final int i7 = 0;
        TransportBackend transportBackend2 = this.backendRegistry.get(autoValue_TransportContext2.backendName);
        long jMax = 0;
        while (true) {
            SynchronizationGuard.CriticalSection criticalSection = new SynchronizationGuard.CriticalSection(this) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                public final /* synthetic */ Uploader f$0;

                {
                    this.f$0 = this;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean bool;
                    switch (i7) {
                        case 0:
                            AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.f$0.eventStore;
                            SQLiteDatabase db = sQLiteEventStore.getDb();
                            db.beginTransaction();
                            try {
                                Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                if (transportContextId == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = sQLiteEventStore.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                db.setTransactionSuccessful();
                                db.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                db.endTransaction();
                                throw th2;
                            }
                        default:
                            SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                            sQLiteEventStore2.getClass();
                            return (Iterable) sQLiteEventStore2.inTransaction(new CodelessManager$$ExternalSyntheticLambda0(sQLiteEventStore2, autoValue_TransportContext2, 10));
                    }
                }
            };
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.guard;
            if (!((Boolean) sQLiteEventStore.runCriticalSection(criticalSection)).booleanValue()) {
                sQLiteEventStore.runCriticalSection(new Uploader$$ExternalSyntheticLambda9(this, autoValue_TransportContext2, jMax));
                return;
            }
            final Iterable iterable = (Iterable) sQLiteEventStore.runCriticalSection(new SynchronizationGuard.CriticalSection(this) { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda3
                public final /* synthetic */ Uploader f$0;

                {
                    this.f$0 = this;
                }

                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean bool;
                    switch (i6) {
                        case 0:
                            AutoValue_TransportContext autoValue_TransportContext3 = autoValue_TransportContext2;
                            SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.f$0.eventStore;
                            SQLiteDatabase db = sQLiteEventStore2.getDb();
                            db.beginTransaction();
                            try {
                                Long transportContextId = SQLiteEventStore.getTransportContextId(db, autoValue_TransportContext3);
                                if (transportContextId == null) {
                                    bool = Boolean.FALSE;
                                } else {
                                    Cursor cursorRawQuery = sQLiteEventStore2.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                                    try {
                                        Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                                        cursorRawQuery.close();
                                        bool = boolValueOf;
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                db.setTransactionSuccessful();
                                db.endTransaction();
                                return bool;
                            } catch (Throwable th2) {
                                db.endTransaction();
                                throw th2;
                            }
                        default:
                            SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) this.f$0.eventStore;
                            sQLiteEventStore3.getClass();
                            return (Iterable) sQLiteEventStore3.inTransaction(new CodelessManager$$ExternalSyntheticLambda0(sQLiteEventStore3, autoValue_TransportContext2, 10));
                    }
                }
            });
            if (!iterable.iterator().hasNext()) {
                return;
            }
            byte[] bArr = autoValue_TransportContext2.extras;
            if (transportBackend2 == null) {
                RangesKt.d("Uploader", "Unknown backend for %s, deleting event batch for it...", autoValue_TransportContext2);
                autoValue_BackendResponse2 = new AutoValue_BackendResponse(3, -1L);
                i2 = i5;
                transportBackend = transportBackend2;
            } else {
                ArrayList<AutoValue_EventInternal> arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AutoValue_PersistedEvent) it.next()).event);
                }
                String str4 = "proto";
                if ((bArr != null ? 1 : i7) != 0) {
                    ClientHealthMetricsStore clientHealthMetricsStore = this.clientHealthMetricsStore;
                    Objects.requireNonNull(clientHealthMetricsStore);
                    ClientMetrics clientMetrics = (ClientMetrics) sQLiteEventStore.runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(clientHealthMetricsStore, i4));
                    Request request = new Request(i5);
                    request.tags = new HashMap();
                    request.headers = Long.valueOf(this.clock.getTime());
                    request.body = Long.valueOf(this.uptimeClock.getTime());
                    request.method = "GDT_CLIENT_METRICS";
                    Encoding encoding = new Encoding("proto");
                    clientMetrics.getClass();
                    request.url = new EncodedPayload(encoding, ProtoEncoderDoNotUse.ENCODER.encode(clientMetrics));
                    arrayList.add(((CctTransportBackend) transportBackend2).decorate(request.build()));
                }
                CctTransportBackend cctTransportBackend = (CctTransportBackend) transportBackend2;
                HashMap map = new HashMap();
                for (AutoValue_EventInternal autoValue_EventInternal : arrayList) {
                    String str5 = autoValue_EventInternal.transportName;
                    if (map.containsKey(str5)) {
                        ((List) map.get(str5)).add(autoValue_EventInternal);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(autoValue_EventInternal);
                        map.put(str5, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    AutoValue_EventInternal autoValue_EventInternal2 = (AutoValue_EventInternal) ((List) entry.getValue()).get(i7);
                    QosTier qosTier = QosTier.DEFAULT;
                    long time = cctTransportBackend.wallTimeClock.getTime();
                    long time2 = cctTransportBackend.uptimeClock.getTime();
                    AutoValue_ClientInfo autoValue_ClientInfo = new AutoValue_ClientInfo(new AutoValue_AndroidClientInfo(Integer.valueOf(autoValue_EventInternal2.getInteger("sdk-version")), autoValue_EventInternal2.get("model"), autoValue_EventInternal2.get("hardware"), autoValue_EventInternal2.get("device"), autoValue_EventInternal2.get("product"), autoValue_EventInternal2.get("os-uild"), autoValue_EventInternal2.get("manufacturer"), autoValue_EventInternal2.get("fingerprint"), autoValue_EventInternal2.get("locale"), autoValue_EventInternal2.get("country"), autoValue_EventInternal2.get("mcc_mnc"), autoValue_EventInternal2.get("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    Iterator it3 = ((List) entry.getValue()).iterator();
                    while (it3.hasNext()) {
                        Iterator it4 = it2;
                        AutoValue_EventInternal autoValue_EventInternal3 = (AutoValue_EventInternal) it3.next();
                        TransportBackend transportBackend3 = transportBackend2;
                        EncodedPayload encodedPayload = autoValue_EventInternal3.encodedPayload;
                        Iterator it5 = it3;
                        Encoding encoding2 = encodedPayload.encoding;
                        boolean zEquals = encoding2.equals(new Encoding(str4));
                        byte[] bArr2 = encodedPayload.bytes;
                        if (zEquals) {
                            tooltipPopup = new TooltipPopup();
                            tooltipPopup.mLayoutParams = bArr2;
                            str3 = str4;
                        } else {
                            str3 = str4;
                            if (encoding2.equals(new Encoding("json"))) {
                                String str6 = new String(bArr2, Charset.forName("UTF-8"));
                                TooltipPopup tooltipPopup2 = new TooltipPopup();
                                tooltipPopup2.mTmpDisplayFrame = str6;
                                tooltipPopup = tooltipPopup2;
                            } else {
                                String tag = RangesKt.getTag("CctTransportBackend");
                                if (Log.isLoggable(tag, 5)) {
                                    Log.w(tag, "Received event of unsupported encoding " + encoding2 + ". Skipping...");
                                }
                            }
                            it3 = it5;
                            it2 = it4;
                            transportBackend2 = transportBackend3;
                            str4 = str3;
                        }
                        tooltipPopup.mContext = Long.valueOf(autoValue_EventInternal3.eventMillis);
                        tooltipPopup.mMessageView = Long.valueOf(autoValue_EventInternal3.uptimeMillis);
                        String str7 = (String) autoValue_EventInternal3.autoMetadata.get("tz-offset");
                        tooltipPopup.mTmpAnchorPos = Long.valueOf(str7 == null ? 0L : Long.valueOf(str7).longValue());
                        tooltipPopup.mTmpAppPos = new AutoValue_NetworkConnectionInfo((NetworkConnectionInfo.NetworkType) NetworkConnectionInfo.NetworkType.valueMap.get(autoValue_EventInternal3.getInteger("net-type")), (NetworkConnectionInfo.MobileSubtype) NetworkConnectionInfo.MobileSubtype.valueMap.get(autoValue_EventInternal3.getInteger("mobile-subtype")));
                        Integer num = autoValue_EventInternal3.code;
                        if (num != null) {
                            tooltipPopup.mContentView = num;
                        }
                        String strM = ((Long) tooltipPopup.mContext) == null ? " eventTimeMs" : "";
                        if (((Long) tooltipPopup.mMessageView) == null) {
                            strM = strM.concat(GsPcpBmONXh.ThAQZMh);
                        }
                        if (((Long) tooltipPopup.mTmpAnchorPos) == null) {
                            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, " timezoneOffsetSeconds");
                        }
                        if (!strM.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strM));
                        }
                        arrayList4.add(new AutoValue_LogEvent(((Long) tooltipPopup.mContext).longValue(), (Integer) tooltipPopup.mContentView, ((Long) tooltipPopup.mMessageView).longValue(), (byte[]) tooltipPopup.mLayoutParams, (String) tooltipPopup.mTmpDisplayFrame, ((Long) tooltipPopup.mTmpAnchorPos).longValue(), (AutoValue_NetworkConnectionInfo) tooltipPopup.mTmpAppPos));
                        it3 = it5;
                        it2 = it4;
                        transportBackend2 = transportBackend3;
                        str4 = str3;
                    }
                    arrayList3.add(new AutoValue_LogRequest(time, time2, autoValue_ClientInfo, numValueOf, str2, arrayList4));
                    it2 = it2;
                    transportBackend2 = transportBackend2;
                    str4 = str4;
                    i7 = 0;
                }
                transportBackend = transportBackend2;
                AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = new AutoValue_BatchedLogRequest(arrayList3);
                URL urlOrThrow = cctTransportBackend.endPoint;
                if (bArr != null) {
                    try {
                        CCTDestination cCTDestinationFromByteArray = CCTDestination.fromByteArray(bArr);
                        str = cCTDestinationFromByteArray.apiKey;
                        if (str == null) {
                            str = null;
                        }
                        String str8 = cCTDestinationFromByteArray.endPoint;
                        if (str8 != null) {
                            urlOrThrow = CctTransportBackend.parseUrlOrThrow(str8);
                        }
                    } catch (IllegalArgumentException unused2) {
                        autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    CctTransportBackend.HttpRequest httpRequest = new CctTransportBackend.HttpRequest(urlOrThrow, autoValue_BatchedLogRequest, str);
                    InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(cctTransportBackend, 7);
                    int i8 = 5;
                    do {
                        httpResponseApply = inputConnectionCompat$$ExternalSyntheticLambda0.apply(httpRequest);
                        URL url = httpResponseApply.redirectUrl;
                        if (url != null) {
                            RangesKt.d("CctTransportBackend", "Following redirect to: %s", url);
                            httpRequest = new CctTransportBackend.HttpRequest(url, httpRequest.requestBody, httpRequest.apiKey);
                        } else {
                            httpRequest = null;
                        }
                        if (httpRequest == null) {
                            break;
                        } else {
                            i8--;
                        }
                    } while (i8 >= 1);
                    int i9 = httpResponseApply.code;
                    if (i9 == 200) {
                        autoValue_BackendResponse2 = new AutoValue_BackendResponse(1, httpResponseApply.nextRequestMillis);
                    } else {
                        if (i9 >= 500 || i9 == 404) {
                            autoValue_BackendResponse = new AutoValue_BackendResponse(2, -1L);
                        } else if (i9 == 400) {
                            try {
                                autoValue_BackendResponse = new AutoValue_BackendResponse(4, -1L);
                            } catch (IOException e) {
                                e = e;
                                RangesKt.e(e, "CctTransportBackend", "Could not make request to the backend");
                                i2 = 2;
                                autoValue_BackendResponse2 = new AutoValue_BackendResponse(2, -1L);
                            }
                        } else {
                            autoValue_BackendResponse = new AutoValue_BackendResponse(3, -1L);
                        }
                        autoValue_BackendResponse2 = autoValue_BackendResponse;
                    }
                    i2 = 2;
                } catch (IOException e2) {
                    e = e2;
                }
            }
            int i10 = autoValue_BackendResponse2.status;
            if (i10 == i2) {
                final long j = jMax;
                sQLiteEventStore.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader$$ExternalSyntheticLambda5
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Uploader uploader = this.f$0;
                        SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) uploader.eventStore;
                        sQLiteEventStore2.getClass();
                        Iterable iterable2 = iterable;
                        if (iterable2.iterator().hasNext()) {
                            String str9 = PZmDzEagKNdW.Bjo + SQLiteEventStore.toIdList(iterable2);
                            SQLiteDatabase db = sQLiteEventStore2.getDb();
                            db.beginTransaction();
                            try {
                                db.compileStatement(str9).execute();
                                Cursor cursorRawQuery = db.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", null);
                                while (cursorRawQuery.moveToNext()) {
                                    try {
                                        sQLiteEventStore2.recordLogEventDropped(cursorRawQuery.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursorRawQuery.getString(1));
                                    } catch (Throwable th) {
                                        cursorRawQuery.close();
                                        throw th;
                                    }
                                }
                                cursorRawQuery.close();
                                db.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                                db.setTransactionSuccessful();
                                db.endTransaction();
                            } catch (Throwable th2) {
                                db.endTransaction();
                                throw th2;
                            }
                        }
                        sQLiteEventStore2.inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(uploader.clock.getTime() + j, autoValue_TransportContext));
                        return null;
                    }
                });
                this.workScheduler.schedule(autoValue_TransportContext, i + 1, true);
                return;
            }
            sQLiteEventStore.runCriticalSection(new CodelessManager$$ExternalSyntheticLambda0(this, iterable, 8));
            if (i10 == 1) {
                jMax = Math.max(jMax, autoValue_BackendResponse2.nextRequestWaitMillis);
                if (bArr != null) {
                    sQLiteEventStore.runCriticalSection(new InputConnectionCompat$$ExternalSyntheticLambda0(this, 10));
                }
            } else {
                if (i10 == 4) {
                    HashMap map2 = new HashMap();
                    Iterator it6 = iterable.iterator();
                    while (it6.hasNext()) {
                        String str9 = ((AutoValue_PersistedEvent) it6.next()).event.transportName;
                        if (map2.containsKey(str9)) {
                            map2.put(str9, Integer.valueOf(((Integer) map2.get(str9)).intValue() + 1));
                        } else {
                            map2.put(str9, 1);
                        }
                    }
                    i3 = 1;
                    sQLiteEventStore.runCriticalSection(new CodelessManager$$ExternalSyntheticLambda0(this, map2, 9));
                }
                i5 = i2;
                i6 = i3;
                i4 = 8;
                i7 = 0;
                autoValue_TransportContext2 = autoValue_TransportContext;
                transportBackend2 = transportBackend;
            }
            i3 = 1;
            i5 = i2;
            i6 = i3;
            i4 = 8;
            i7 = 0;
            autoValue_TransportContext2 = autoValue_TransportContext;
            transportBackend2 = transportBackend;
        }
    }
}
