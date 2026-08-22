package com.google.android.datatransport.runtime.scheduling;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ranges.RangesKt;
import okhttp3.Dispatcher;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DefaultScheduler$$ExternalSyntheticLambda1 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ DefaultScheduler$$ExternalSyntheticLambda1(SQLiteEventStore sQLiteEventStore, Object obj, AutoValue_TransportContext autoValue_TransportContext, int i) {
        this.$r8$classId = i;
        this.f$0 = sQLiteEventStore;
        this.f$2 = obj;
        this.f$1 = autoValue_TransportContext;
    }

    public /* synthetic */ DefaultScheduler$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        long jInsert;
        SQLiteEventStore sQLiteEventStore;
        LogEventDropped.Reason reason;
        LogEventDropped.Reason reason2;
        int i = 5;
        int i2 = 4;
        int i3 = 3;
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        Object obj2 = this.f$2;
        int i4 = 2;
        int i5 = 0;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        int i6 = 1;
        switch (this.$r8$classId) {
            case 1:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) obj4;
                long jSimpleQueryForLong = sQLiteEventStore2.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore2.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
                AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore2.config;
                long j = autoValue_EventStoreConfig.maxStorageSizeInBytes;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj2;
                String str = autoValue_EventInternal.transportName;
                if (jSimpleQueryForLong >= j) {
                    sQLiteEventStore2.recordLogEventDropped(1L, reason3, str);
                    return -1L;
                }
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) obj3;
                Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext);
                if (transportContextId != null) {
                    jInsert = transportContextId.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", autoValue_TransportContext.backendName);
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext.priority)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr = autoValue_TransportContext.extras;
                    if (bArr != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                byte[] bArr2 = encodedPayload.bytes;
                int length = bArr2.length;
                int i7 = autoValue_EventStoreConfig.maxBlobByteSizePerRow;
                boolean z = length <= i7;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", str);
                contentValues2.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
                contentValues2.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
                contentValues2.put("payload_encoding", encodedPayload.encoding.name);
                contentValues2.put("code", autoValue_EventInternal.code);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr2 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert(UUFMQdNK.ZRTCCft, null, contentValues2);
                if (!z) {
                    int iCeil = (int) Math.ceil(((double) bArr2.length) / ((double) i7));
                    for (int i8 = 1; i8 <= iCeil; i8++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr2, (i8 - 1) * i7, Math.min(i8 * i7, bArr2.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put(xPQrbOSWiEdU.uehOP, Integer.valueOf(i8));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put(FirebaseAnalytics.Param.VALUE, (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            case 2:
                Cursor cursor = (Cursor) obj;
                SQLiteEventStore sQLiteEventStore3 = (SQLiteEventStore) obj4;
                sQLiteEventStore3.getClass();
                while (cursor.moveToNext()) {
                    long j2 = cursor.getLong(0);
                    int i9 = cursor.getInt(7) != 0 ? i6 : 0;
                    Request request = new Request(i4);
                    request.tags = new HashMap();
                    String string = cursor.getString(i6);
                    if (string == null) {
                        throw new NullPointerException(DYYbQc.NJMZ);
                    }
                    request.method = string;
                    request.headers = Long.valueOf(cursor.getLong(i4));
                    request.body = Long.valueOf(cursor.getLong(3));
                    if (i9 != 0) {
                        String string2 = cursor.getString(4);
                        request.url = new EncodedPayload(string2 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string2), cursor.getBlob(5));
                        sQLiteEventStore = sQLiteEventStore3;
                    } else {
                        String string3 = cursor.getString(4);
                        Encoding encoding = string3 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string3);
                        Cursor cursorQuery = sQLiteEventStore3.getDb().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j2)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList = new ArrayList();
                            int length2 = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList.add(blob);
                                length2 += blob.length;
                            }
                            byte[] bArr3 = new byte[length2];
                            int i10 = 0;
                            int length3 = 0;
                            while (i10 < arrayList.size()) {
                                byte[] bArr4 = (byte[]) arrayList.get(i10);
                                ArrayList arrayList2 = arrayList;
                                SQLiteEventStore sQLiteEventStore4 = sQLiteEventStore3;
                                System.arraycopy(bArr4, 0, bArr3, length3, bArr4.length);
                                length3 += bArr4.length;
                                i10++;
                                arrayList = arrayList2;
                                sQLiteEventStore3 = sQLiteEventStore4;
                            }
                            sQLiteEventStore = sQLiteEventStore3;
                            cursorQuery.close();
                            request.url = new EncodedPayload(encoding, bArr3);
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        request.lazyCacheControl = Integer.valueOf(cursor.getInt(6));
                    }
                    ((ArrayList) obj2).add(new AutoValue_PersistedEvent(j2, (AutoValue_TransportContext) obj3, request.build()));
                    sQLiteEventStore3 = sQLiteEventStore;
                    i4 = 2;
                    i6 = 1;
                }
                return null;
            default:
                Cursor cursor2 = (Cursor) obj;
                SQLiteEventStore sQLiteEventStore5 = (SQLiteEventStore) obj4;
                sQLiteEventStore5.getClass();
                while (true) {
                    HashMap map = (HashMap) obj3;
                    if (cursor2.moveToNext()) {
                        String string4 = cursor2.getString(i5);
                        int i11 = cursor2.getInt(1);
                        LogEventDropped.Reason reason4 = LogEventDropped.Reason.REASON_UNKNOWN;
                        if (i11 != 0) {
                            if (i11 == 1) {
                                reason4 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
                            } else if (i11 == 2) {
                                reason = reason3;
                                reason2 = reason;
                            } else if (i11 == i3) {
                                reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
                            } else if (i11 == i2) {
                                reason4 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
                            } else if (i11 == i) {
                                reason4 = LogEventDropped.Reason.INVALID_PAYLOD;
                            } else if (i11 == 6) {
                                reason4 = LogEventDropped.Reason.SERVER_ERROR;
                            } else {
                                RangesKt.d("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i11));
                            }
                            reason2 = reason3;
                            reason = reason4;
                        } else {
                            reason2 = reason3;
                            reason = reason4;
                        }
                        long j3 = cursor2.getLong(2);
                        if (!map.containsKey(string4)) {
                            map.put(string4, new ArrayList());
                        }
                        ((List) map.get(string4)).add(new LogEventDropped(j3, reason));
                        reason3 = reason2;
                        i = 5;
                        i2 = 4;
                        i3 = 3;
                        i5 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            Dispatcher dispatcher = (Dispatcher) obj2;
                            if (!it.hasNext()) {
                                long time = sQLiteEventStore5.wallClock.getTime();
                                SQLiteDatabase db = sQLiteEventStore5.getDb();
                                db.beginTransaction();
                                try {
                                    Cursor cursorRawQuery = db.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]);
                                    try {
                                        cursorRawQuery.moveToNext();
                                        TimeWindow timeWindow = new TimeWindow(cursorRawQuery.getLong(0), time);
                                        cursorRawQuery.close();
                                        db.setTransactionSuccessful();
                                        db.endTransaction();
                                        dispatcher.executorServiceOrNull = timeWindow;
                                        dispatcher.runningAsyncCalls = new GlobalMetrics(new StorageMetrics(sQLiteEventStore5.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore5.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong(), AutoValue_EventStoreConfig.DEFAULT.maxStorageSizeInBytes));
                                        dispatcher.runningSyncCalls = (String) sQLiteEventStore5.packageName.get();
                                        return new ClientMetrics((TimeWindow) dispatcher.executorServiceOrNull, Collections.unmodifiableList((ArrayList) dispatcher.readyAsyncCalls), (GlobalMetrics) dispatcher.runningAsyncCalls, (String) dispatcher.runningSyncCalls);
                                    } catch (Throwable th2) {
                                        cursorRawQuery.close();
                                        throw th2;
                                    }
                                } catch (Throwable th3) {
                                    db.endTransaction();
                                    throw th3;
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i12 = LogSourceMetrics.$r8$clinit;
                            new ArrayList();
                            ((ArrayList) dispatcher.readyAsyncCalls).add(new LogSourceMetrics((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                        }
                    }
                }
                break;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.f$0;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) defaultScheduler.eventStore;
        sQLiteEventStore.getClass();
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.f$2;
        String tag = RangesKt.getTag("SQLiteEventStore");
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, "Storing event with priority=" + autoValue_TransportContext.priority + GsPcpBmONXh.PEKm + autoValue_EventInternal.transportName + " for destination " + autoValue_TransportContext.backendName);
        }
        ((Long) sQLiteEventStore.inTransaction(new DefaultScheduler$$ExternalSyntheticLambda1(sQLiteEventStore, (Object) autoValue_EventInternal, autoValue_TransportContext, 1))).getClass();
        defaultScheduler.workScheduler.schedule(autoValue_TransportContext, 1, false);
        return null;
    }
}
