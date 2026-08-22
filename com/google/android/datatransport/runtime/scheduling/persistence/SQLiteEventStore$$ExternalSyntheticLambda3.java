package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.ads.jY.UUFMQdNK;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda3 implements SQLiteEventStore.Function {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ AutoValue_TransportContext f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda3(long j, AutoValue_TransportContext autoValue_TransportContext) {
        this.f$0 = j;
        this.f$1 = autoValue_TransportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put(UUFMQdNK.SCnMRiBoqNfmeAc, Long.valueOf(this.f$0));
        AutoValue_TransportContext autoValue_TransportContext = this.f$1;
        String str = autoValue_TransportContext.backendName;
        Priority priority = autoValue_TransportContext.priority;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(PriorityMapping.toInt(priority))}) < 1) {
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(priority)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
