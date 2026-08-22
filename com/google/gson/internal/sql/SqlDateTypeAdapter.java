package com.google.gson.internal.sql;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonWriter;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class SqlDateTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.AnonymousClass28 FACTORY = new TypeAdapters.AnonymousClass28(4);
    public static final TypeAdapters.AnonymousClass28 FACTORY$1 = new TypeAdapters.AnonymousClass28(5);
    public static final TypeAdapters.AnonymousClass28 FACTORY$2 = new TypeAdapters.AnonymousClass28(6);
    public final /* synthetic */ int $r8$classId;
    public final Object format;

    public SqlDateTypeAdapter(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.format = new SimpleDateFormat("hh:mm:ss a");
                break;
            default:
                this.format = new SimpleDateFormat("MMM d, yyyy");
                break;
        }
    }

    private final void write$com$google$gson$internal$sql$SqlTimeTypeAdapter(JsonWriter jsonWriter, Object obj) {
        Time time = (Time) obj;
        synchronized (this) {
            jsonWriter.value(time == null ? null : ((SimpleDateFormat) this.format).format((Date) time));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                java.sql.Date date = (java.sql.Date) obj;
                synchronized (this) {
                    jsonWriter.value(date == null ? null : ((SimpleDateFormat) this.format).format((Date) date));
                }
                return;
            case 1:
                write$com$google$gson$internal$sql$SqlTimeTypeAdapter(jsonWriter, obj);
                return;
            default:
                ((TypeAdapter) this.format).write(jsonWriter, (Timestamp) obj);
                return;
        }
    }

    public SqlDateTypeAdapter(TypeAdapter typeAdapter) {
        this.$r8$classId = 2;
        this.format = typeAdapter;
    }
}
