package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.JavaVersion;
import com.google.gson.stream.JsonWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DateTypeAdapter extends TypeAdapter {
    public static final TypeAdapters.AnonymousClass28 FACTORY = new TypeAdapters.AnonymousClass28(2);
    public final /* synthetic */ int $r8$classId = 0;
    public final Object dateFormats;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.dateFormats = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (JavaVersion.majorJavaVersion >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Date date = (Date) obj;
                synchronized (this) {
                    try {
                        if (date == null) {
                            jsonWriter.nullValue();
                        } else {
                            jsonWriter.value(((DateFormat) ((ArrayList) this.dateFormats).get(0)).format(date));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                ((TypeAdapters.AnonymousClass30) this.dateFormats).val$typeAdapter.write(jsonWriter, obj);
                return;
        }
    }

    public DateTypeAdapter(TypeAdapters.AnonymousClass30 anonymousClass30, Class cls) {
        this.dateFormats = anonymousClass30;
    }
}
