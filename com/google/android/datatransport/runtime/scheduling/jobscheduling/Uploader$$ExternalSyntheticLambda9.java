package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore$$ExternalSyntheticLambda3;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda9 implements SynchronizationGuard.CriticalSection, SQLiteEventStore.Function {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda9(Object obj, Object obj2, long j) {
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = j;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        int i = ((LogEventDropped.Reason) this.f$1).number_;
        String string = Integer.toString(i);
        String str = (String) this.f$0;
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, string});
        try {
            boolean z = cursorRawQuery.getCount() > 0;
            cursorRawQuery.close();
            long j = this.f$2;
            if (z) {
                sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(i)});
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("log_source", str);
                contentValues.put("reason", Integer.valueOf(i));
                contentValues.put("events_dropped_count", Long.valueOf(j));
                sQLiteDatabase.insert("log_event_dropped", null, contentValues);
            }
            return null;
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Uploader uploader = (Uploader) this.f$0;
        long time = uploader.clock.getTime() + this.f$2;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) uploader.eventStore;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.f$1;
        sQLiteEventStore.getClass();
        sQLiteEventStore.inTransaction(new SQLiteEventStore$$ExternalSyntheticLambda3(time, autoValue_TransportContext));
        return null;
    }
}
